#!/usr/bin/env bash
set -Eeuo pipefail

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
INPUT="$PROJECT_DIR/rebuild-input"
TOOLS="$PROJECT_DIR/tools"
OUT="$PROJECT_DIR/build"
KEYSTORE="$PROJECT_DIR/keystore/teezee-local.jks"

: "${APKTOOL_JAR:=$TOOLS/apktool_3.0.3.jar}"
: "${KEY_ALIAS:=teezee-local}"
: "${KEY_PASSWORD:=changeit}"
: "${STORE_PASSWORD:=changeit}"

mkdir -p "$OUT" "$(dirname "$KEYSTORE")"
[ -d "$INPUT" ] || { echo "Missing rebuild-input" >&2; exit 1; }
[ -f "$APKTOOL_JAR" ] || { echo "Missing Apktool jar: $APKTOOL_JAR" >&2; exit 1; }

java -Xmx1200m -XX:+UseSerialGC -jar "$APKTOOL_JAR" b "$INPUT" -o "$OUT/unsigned.apk"
zipalign -f -p 4 "$OUT/unsigned.apk" "$OUT/aligned.apk"

if [ ! -f "$KEYSTORE" ]; then
  keytool -genkeypair -v -keystore "$KEYSTORE" -alias "$KEY_ALIAS" \
    -keyalg RSA -keysize 2048 -validity 10000 \
    -storepass "$STORE_PASSWORD" -keypass "$KEY_PASSWORD" \
    -dname 'CN=Teezee Local, OU=Teezee, O=Teezee, C=IN' >/dev/null 2>&1
fi

apksigner sign --ks "$KEYSTORE" --ks-pass "pass:$STORE_PASSWORD" \
  --key-pass "pass:$KEY_PASSWORD" --ks-key-alias "$KEY_ALIAS" \
  --min-sdk-version 23 --v1-signing-enabled true \
  --v2-signing-enabled true --v3-signing-enabled true \
  --v4-signing-enabled false --out "$OUT/Teezee.apk" "$OUT/aligned.apk"

apksigner verify --verbose --print-certs "$OUT/Teezee.apk"
sha256sum "$OUT/Teezee.apk" | tee "$OUT/Teezee.apk.sha256"
