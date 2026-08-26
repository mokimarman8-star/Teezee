# Teezee — Fresh Reconstruction Project

This project is a fresh, self-contained reconstruction workspace for the exact Teezee Android package. The original package identity is preserved as `com.teezee.app`, with `com.transsion.subroom.activity.SplashActivity` as the launcher and `com.transsion.subroom.app.SubRoomApp` as the Application class.

Android does not allow a numeric application UID to be copied between installations. The device assigns that UID at install time. The portable identity is the application/package ID, manifest configuration, launcher icon, resources, assets, native ABI folders and signing/build metadata.

## Contents

`rebuild-input/` contains the complete decoded APK input: ten DEX/smali modules, manifest, resources, assets, native libraries and unknown packaged files. `extracted/source-readable/` contains the file-by-file readable reconstruction of the startup-critical source files. `docs/` contains identity and verification reports. `rebuild.sh` reproduces the decoded APK build, zip alignment and local v1/v2/v3 signing without changing the original Teezee workspace.

## Rebuild

Run:

```bash
./rebuild.sh
```

The output is written to `build/Teezee.apk`. Because this APK is rebuilt with a local certificate, it must be installed after uninstalling any package signed with a different certificate. The package still contains only `arm64-v8a` and `armeabi-v7a` native libraries.

## Reconstruction scope

The decoded APK contains 52,677 smali files across ten DEX modules. The startup-critical files have been manually rewritten into readable source form, while the remaining files are preserved in decoded smali form so no packaged code is discarded. Decompiled bytecode cannot restore original comments, source names, build history or proprietary dependency source word-for-word; the readable files therefore document behavior and safe launch flow rather than claiming original-source recovery.
