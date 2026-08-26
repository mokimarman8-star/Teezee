#!/usr/bin/env bash
set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"

VERSION="${1:-1.0.2}"
VERSION="${VERSION#v}"

echo "=========================================="
echo " Building Teezee v${VERSION}"
echo "=========================================="

DIST_DIR="$ROOT_DIR/dist"
APP_SRC="$ROOT_DIR/app_source"
KEYSTORE="${TEEZEE_KEYSTORE_PATH:-$ROOT_DIR/keystore/release.jks}"
KEY_ALIAS="${TEEZEE_KEY_ALIAS:-}"
KS_PASS="${TEEZEE_STORE_PASSWORD:-}"
KEY_PASS="${TEEZEE_KEY_PASSWORD:-}"
PROPERTIES_FILE="${TEEZEE_KEYSTORE_PROPERTIES:-$ROOT_DIR/keystore/keystore.properties}"

# Credentials may come from GitHub Actions secrets or an ignored local
# properties file. Parse values as data; never source/execute the file.
read_property() {
    local key="$1"
    [ -f "$PROPERTIES_FILE" ] || return 0
    awk -F= -v wanted="$key" '$1 == wanted {sub(/^[^=]*=/, ""); print; exit}' "$PROPERTIES_FILE"
}
KEY_ALIAS="${KEY_ALIAS:-$(read_property keyAlias)}"
KS_PASS="${KS_PASS:-$(read_property storePassword)}"
KEY_PASS="${KEY_PASS:-$(read_property keyPassword)}"

if [ -z "$KEY_ALIAS" ] || [ -z "$KS_PASS" ] || [ -z "$KEY_PASS" ]; then
    echo "[-] Signing credentials are missing." >&2
    echo "    Set TEEZEE_KEY_ALIAS, TEEZEE_STORE_PASSWORD and TEEZEE_KEY_PASSWORD." >&2
    exit 1
fi

mkdir -p "$DIST_DIR"
rm -f "$DIST_DIR"/*.apk "$DIST_DIR"/*.sha256

if [ ! -d "$APP_SRC" ]; then
    echo "[-] Error: App source directory not found at $APP_SRC"
    exit 1
fi

if [ ! -f "$KEYSTORE" ]; then
    echo "[-] Release keystore not found at $KEYSTORE" >&2
    echo "    Refusing to generate a new signing key automatically." >&2
    exit 1
fi

# Step 1: Package ZIP
#
# FIX ("App not installed" root cause):
#   - resources.arsc MUST be STORED (uncompressed) AND its data must be
#     4-byte aligned. Android 11+ REFUSES to install targetSdk>=30 APKs
#     whose resources.arsc is DEFLATED -> PackageManager error
#     INSTALL_PARSE_FAILED_NO_CERTIFICATES / "App not installed".
#   - We add resources.arsc FIRST with `zip -0` (stored), then add the
#     rest DEFLATED. `zipalign -p 4` afterwards keeps it 4-aligned.
TEMP_UNALIGNED="$DIST_DIR/unaligned_temp.apk"
TEMP_ALIGNED="$DIST_DIR/aligned_temp.apk"
FINAL_APK="$DIST_DIR/Teezee-v${VERSION}.apk"

echo "[1/4] Packaging APK contents..."
( cd "$APP_SRC" \
  && zip -q -X -0 "$TEMP_UNALIGNED" resources.arsc \
  && zip -q -X -r -9 "$TEMP_UNALIGNED" . -x "resources.arsc" )

echo "[2/4] Aligning APK (-p flag keeps uncompressed entries page/4-byte aligned)..."
zipalign -f -p 4 "$TEMP_UNALIGNED" "$TEMP_ALIGNED"

echo "[3/4] Signing APK with apksigner (v1, v2, v3)..."
apksigner sign \
    --ks "$KEYSTORE" \
    --ks-pass "pass:$KS_PASS" \
    --key-pass "pass:$KEY_PASS" \
    --ks-key-alias "$KEY_ALIAS" \
    --min-sdk-version 23 \
    --max-sdk-version 35 \
    --v1-signing-enabled true \
    --v2-signing-enabled true \
    --v3-signing-enabled true \
    --v4-signing-enabled false \
    --out "$FINAL_APK" \
    "$TEMP_ALIGNED"

echo "[4/4] Verifying APK..."
apksigner verify --verbose --print-certs "$FINAL_APK"

echo "[*] Sanity checks (fail build if packaging regresses):"
zipalign -c -p 4 "$FINAL_APK"
ARSC_STORED=$(unzip -v "$FINAL_APK" resources.arsc | awk '$NF=="resources.arsc"{print $2}')
if [ "$ARSC_STORED" != "Stored" ]; then
    echo "[-] FATAL: resources.arsc is not Stored (got: $ARSC_STORED)"
    exit 1
fi
echo "[+] resources.arsc is Stored & aligned; signature verified."

cd "$DIST_DIR"
sha256sum "Teezee-v${VERSION}.apk" > "Teezee-v${VERSION}.apk.sha256"
cd "$ROOT_DIR"

rm -f "$TEMP_UNALIGNED" "$TEMP_ALIGNED"

echo "=========================================="
echo " Build Succeeded!"
echo " Output: $FINAL_APK"
echo " Size: $(ls -lh "$FINAL_APK" | awk '{print $5}')"
echo " SHA-256: $(cat "$DIST_DIR/Teezee-v${VERSION}.apk.sha256" | awk '{print $1}')"
echo "=========================================="
