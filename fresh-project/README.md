# Teezee — Fresh Reconstruction Project

This is the fresh readable reconstruction workspace for the exact Teezee Android package. It is published on the `fresh-reconstruction` branch of `mokimarman8-star/Teezee`; `teezee-app` was not accessed. The original package identity is preserved as `com.teezee.app`, with `com.transsion.subroom.activity.SplashActivity` as the launcher and `com.transsion.subroom.app.SubRoomApp` as the Application class.

Android does not allow a numeric application UID to be copied between installations. The device assigns that UID at install time. The portable identity is the application/package ID, manifest configuration, launcher icon, resources, assets, native ABI folders and signing/build metadata.

## Complete input and readable source

The repository's existing `app_source/` directory contains the complete packaged input: manifest, ten DEX files, resources, assets and native libraries. `fresh-project/source-readable/` contains the readable reconstruction of the startup-critical files and decoded resources. The original packaged files remain preserved rather than being overwritten. `docs/` contains identity and verification reports.

## Rebuild

From the repository root, run the existing verified build engine:

```bash
./scripts/build.sh
```

The `fresh-project/rebuild.sh` convenience wrapper documents the decoded local rebuild route. The output is written to the root `dist/` directory. The local `TeezeeFresh` bundle created during extraction contains a full Apktool mirror and can reproduce the decoded-resource rebuild independently.

## Startup fixes and reconstruction boundary

The reconstructed startup flow makes storage permission checks non-blocking, adds a bounded SplashActivity fallback when optional ad/network callbacks do not return, and makes the launcher theme opaque with preview enabled. These changes are represented in the decoded local rebuild artifact; the readable files explain the intended source-level behavior.

The decoded APK contains 52,677 smali files across ten DEX modules.

The startup-critical files have been manually rewritten into readable source form, while the remaining files are preserved in the original packaged input so no code is discarded. Decompiled bytecode cannot restore original comments, source names, build history or proprietary dependency source word-for-word; the readable files therefore document behavior and safe launch flow rather than claiming impossible 100% original-source recovery.
