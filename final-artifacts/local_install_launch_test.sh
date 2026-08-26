#!/usr/bin/env bash
set -Eeuo pipefail

APK="${1:-}"
PACKAGE="${PACKAGE:-com.teezee.app}"
ACTIVITY="${ACTIVITY:-com.transsion.subroom.activity.SplashActivity}"
OUT="${OUT:-$(pwd)/teezee-local-test-$(date +%Y%m%d-%H%M%S)}"
ADB="${ADB:-adb}"

if [[ -z "$APK" || ! -f "$APK" ]]; then
  echo "Usage: $0 /path/to/Teezee.apk" >&2
  exit 2
fi
command -v "$ADB" >/dev/null || { echo "adb is required" >&2; exit 2; }
mkdir -p "$OUT"

"$ADB" start-server >/dev/null
DEVICE="$($ADB devices | awk '$2=="device" {print $1; exit}')"
if [[ -z "$DEVICE" ]]; then
  echo "No online Android device found. Connect an ARM64 Android device or start an ARM-capable emulator." >&2
  "$ADB" devices -l | tee "$OUT/adb-devices.txt"
  exit 3
fi

run_adb() { "$ADB" -s "$DEVICE" "$@"; }
run_adb shell getprop > "$OUT/getprop.txt"
run_adb shell getprop ro.build.version.sdk > "$OUT/api-level.txt"
run_adb shell getprop ro.product.cpu.abilist > "$OUT/device-abis.txt"
run_adb uninstall "$PACKAGE" > "$OUT/uninstall-before.txt" 2>&1 || true
if ! run_adb install -r -d "$APK" > "$OUT/install.txt" 2>&1; then
  echo "INSTALL_FAILED" | tee "$OUT/result.txt"
  cat "$OUT/install.txt"
  exit 4
fi

run_adb shell am force-stop "$PACKAGE" || true
run_adb shell am start -W -n "$PACKAGE/$ACTIVITY" > "$OUT/launch.txt" 2>&1 || true
sleep "${SMOKE_SECONDS:-20}"
run_adb shell dumpsys window windows > "$OUT/windows.txt" 2>&1 || true
run_adb shell dumpsys activity activities > "$OUT/activities.txt" 2>&1 || true
run_adb logcat -d > "$OUT/logcat.txt" 2>&1 || true
run_adb logcat -d -b crash > "$OUT/crash-log.txt" 2>&1 || true
run_adb exec-out screencap -p > "$OUT/screenshot.png" 2>/dev/null || true

if grep -qE 'FATAL EXCEPTION|AndroidRuntime|Process: com\.teezee\.app' "$OUT/crash-log.txt"; then
  echo "CRASH" | tee "$OUT/result.txt"
elif [[ ! -s "$OUT/screenshot.png" ]]; then
  echo "NO_SCREENSHOT" | tee "$OUT/result.txt"
elif python3 - "$OUT/screenshot.png" <<'PY'
from PIL import Image
import sys
p=sys.argv[1]
try:
    im=Image.open(p).convert('RGB')
    pixels=list(im.resize((64,64)).getdata())
    dark=sum(1 for r,g,b in pixels if r<8 and g<8 and b<8)
    raise SystemExit(0 if dark/len(pixels) >= 0.98 else 1)
except Exception:
    raise SystemExit(1)
PY
then
  echo "BLACK_SCREEN" | tee "$OUT/result.txt"
else
  echo "LAUNCHED_SCREEN_CAPTURED" | tee "$OUT/result.txt"
fi

printf 'device=%s\n' "$DEVICE"
printf 'api=%s\n' "$(tr -d '\r\n' < "$OUT/api-level.txt")"
printf 'abi=%s\n' "$(tr -d '\r\n' < "$OUT/device-abis.txt")"
printf 'result=%s\n' "$(cat "$OUT/result.txt")"
printf 'evidence=%s\n' "$OUT"
