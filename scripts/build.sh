#!/usr/bin/env bash
set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "$SCRIPT_DIR/.." && pwd)"

VERSION="${1:-1.0.2}"
# Strip leading 'v' if present
VERSION="${VERSION#v}"

echo "=========================================="
echo " Building Teezee v${VERSION}"
echo "=========================================="

DIST_DIR="$ROOT_DIR/dist"
APP_SRC="$ROOT_DIR/app_source"
KEYSTORE="$ROOT_DIR/keystore/release.jks"
KS_PASS="password123"
KEY_PASS="password123"
KEY_ALIAS="teezee"

mkdir -p "$DIST_DIR"
rm -f "$DIST_DIR"/*.apk "$DIST_DIR"/*.sha256

if [ ! -d "$APP_SRC" ]; then
    echo "[-] Error: App source directory not found at $APP_SRC"
    exit 1
fi

if [ ! -f "$KEYSTORE" ]; then
    echo "[*] Keystore not found, generating new release keystore..."
    keytool -genkey -v -keystore "$KEYSTORE" -alias "$KEY_ALIAS" \
        -keyalg RSA -keysize 2048 -validity 10000 \
        -storepass "$KS_PASS" -keypass "$KEY_PASS" \
        -dname "CN=Teezee, OU=App, O=Teezee, C=IN"
fi

# Step 1: Package ZIP
echo "[1/4] Packaging APK contents..."
TEMP_UNALIGNED="$DIST_DIR/unaligned_temp.apk"
TEMP_ALIGNED="$DIST_DIR/aligned_temp.apk"
FINAL_APK="$DIST_DIR/Teezee-v${VERSION}.apk"

cd "$APP_SRC"
zip -r -q "$TEMP_UNALIGNED" . *
cd "$ROOT_DIR"

# Step 2: Zipalign 4-byte
echo "[2/4] Aligning APK (4-byte alignment)..."
zipalign -p -f -v 4 "$TEMP_UNALIGNED" "$TEMP_ALIGNED" > /dev/null

# Step 3: Sign APK with v1, v2, v3 schemes
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

# Step 4: Verify APK
echo "[4/4] Verifying APK signature..."
apksigner verify --verbose --print-certs "$FINAL_APK"

# Compute SHA256 Checksum
cd "$DIST_DIR"
sha256sum "Teezee-v${VERSION}.apk" > "Teezee-v${VERSION}.apk.sha256"
cd "$ROOT_DIR"

# Clean temp files
rm -f "$TEMP_UNALIGNED" "$TEMP_ALIGNED"

echo "=========================================="
echo " Build Succeeded!"
echo " Output: $FINAL_APK"
echo " Size: $(ls -lh "$FINAL_APK" | awk '{print $5}')"
echo " SHA-256: $(cat "$DIST_DIR/Teezee-v${VERSION}.apk.sha256" | awk '{print $1}')"
echo "=========================================="
