#!/usr/bin/env bash
set -u

APK="${1:?APK path required}"
PACKAGE="com.teezee.app"
ACTIVITY="com.transsion.subroom.activity.SplashActivity"
EVIDENCE_DIR="${GITHUB_WORKSPACE:-.}/ci-artifacts/evidence"
mkdir -p "$EVIDENCE_DIR"

adb wait-for-device
adb shell getprop > "$EVIDENCE_DIR/getprop.txt"
API=$(adb shell getprop ro.build.version.sdk | tr -d '\r')
MODEL=$(adb shell getprop ro.product.model | tr -d '\r')
PREFIX="api-${API}"

{
  echo "api=$API"
  echo "model=$MODEL"
  echo "apk=$APK"
  sha256sum "$APK"
} > "$EVIDENCE_DIR/${PREFIX}-environment.txt"

adb uninstall "$PACKAGE" >/dev/null 2>&1 || true
if adb install -r -d "$APK" > "$EVIDENCE_DIR/${PREFIX}-install.txt" 2>&1; then
  install_status=PASS
else
  install_status=FAIL
fi

launch_status=NOT_RUN
foreground_status=NOT_RUN
crash_status=NONE
screen_status=NO_SCREENSHOT

if [[ "$install_status" == PASS ]]; then
  if adb shell am start -W -n "$PACKAGE/$ACTIVITY" > "$EVIDENCE_DIR/${PREFIX}-launch.txt" 2>&1; then
    launch_status=PASS
  else
    launch_status=FAIL
  fi
  sleep 20
  adb shell dumpsys window windows > "$EVIDENCE_DIR/${PREFIX}-windows.txt" 2>&1 || true
  adb shell dumpsys activity activities > "$EVIDENCE_DIR/${PREFIX}-activities.txt" 2>&1 || true
  if grep -q "$PACKAGE" "$EVIDENCE_DIR/${PREFIX}-windows.txt"; then
    foreground_status=PASS
  else
    foreground_status=UNKNOWN
  fi
  adb logcat -d -b crash > "$EVIDENCE_DIR/${PREFIX}-crash-log.txt" 2>&1 || true
  if grep -q "$PACKAGE" "$EVIDENCE_DIR/${PREFIX}-crash-log.txt"; then
    crash_status=FOUND
  fi
  adb exec-out screencap -p > "$EVIDENCE_DIR/${PREFIX}-screenshot.png" 2>/dev/null || true
  if [[ -s "$EVIDENCE_DIR/${PREFIX}-screenshot.png" ]]; then
    python3 scripts/check_screenshot.py "$EVIDENCE_DIR/${PREFIX}-screenshot.png" > "$EVIDENCE_DIR/${PREFIX}-screen-status.txt" 2>&1 || true
    screen_status=$(tail -1 "$EVIDENCE_DIR/${PREFIX}-screen-status.txt" 2>/dev/null || echo UNKNOWN)
  fi
fi

printf 'api=%s\nmodel=%s\ninstall=%s\nlaunch=%s\nforeground=%s\ncrash=%s\nscreen=%s\n' \
  "$API" "$MODEL" "$install_status" "$launch_status" "$foreground_status" "$crash_status" "$screen_status" \
  | tee "$EVIDENCE_DIR/${PREFIX}-summary.txt"

adb logcat -d > "$EVIDENCE_DIR/${PREFIX}-logcat.txt" 2>&1 || true

if [[ "$install_status" != PASS || "$launch_status" != PASS || "$crash_status" == FOUND || "$screen_status" == BLACK_SCREEN ]]; then
  exit 1
fi
