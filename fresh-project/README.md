# Teezee readable reconstruction

This is the readable reconstruction workspace for the exact Teezee Android package, maintained inside the existing `mokimarman8-star/Teezee` repository on the `fresh-reconstruction` branch. No second Teezee repository was created, and `teezee-app` was not accessed. The project name remains **Teezee** and the Android application ID remains `com.teezee.app`.

## Preserved identity

The launcher remains `com.transsion.subroom.activity.SplashActivity`, the Application class remains `com.transsion.subroom.app.SubRoomApp`, and the original launcher icon, manifest resources, assets and ARM native libraries remain in the repository. Android assigns a numeric UID separately on each installation; that device-assigned number cannot legally or technically be copied into a fresh installation. The portable identity is the package ID, manifest configuration, branding, resources, assets, native ABI folders and signing relationship.

## Existing Teezee files

The repository's existing `app_source/` directory preserves the complete packaged input: manifest, ten DEX files, resources, assets and native libraries. The tracked `src/main/java/sources/` tree contains the decompiled/readable source mirror, including the startup-critical `SplashActivity.java`, `MainActivity.java`, `BaseActivity.java`, `PermissionUtils.java` and `SubRoomApp.java`. The `fresh-project/source-readable/` directory contains the clearer explanations and reconstruction notes; it is documentation within this same Teezee repository, not a new application or a new repository.

## Rebuild and release

From the repository root, run the existing packaging engine:

```bash
./scripts/build.sh 1.0.12
```

The engine packages the preserved `app_source/` tree, applies ZIP alignment, signs with the repository release keystore when available, verifies the APK signatures and writes a SHA-256 checksum in `dist/`. The convenience command below delegates to that same root build path and does not require a second project:

```bash
./fresh-project/rebuild.sh 1.0.12
```

The GitHub workflow in `.github/workflows/release.yml` performs the same versioning, tag, build, signing, checksum and release-asset steps using the repository-scoped Actions token. It updates an existing release without deleting it and does not use the exposed personal token from chat.

## Current startup work

The tracked readable `SplashActivity.java` now schedules an eight-second, lifecycle-guarded fallback to `MainActivity` when optional splash-ad or network callbacks do not return. This is a source-level reconstruction and is separately documented in `docs/startup-crash-root-cause-analysis.md`. The original package also uses `bin.mt.signature.KillerApplication` and `libSignatureKiller.so`; because a real ARM-device stack trace is still unavailable, that security/signing path remains a documented crash suspect rather than being blindly disabled.

## Reconstruction boundary

The decoded APK contains 52,677 smali files across ten DEX modules and approximately 1,500 decoded layout/resource files. Packaged evidence identifies home, movie, short-TV, room/community, player, subtitle, audio-track, language, likes/follows, profile, download and transfer UI families. Static APK inspection cannot recover private server data, live recommendation results, user-specific likes, authenticated responses or original source comments/build history. Those parts are recorded as runtime-dependent instead of being invented.

The readable files are therefore a behaviorally documented and progressively editable reconstruction, not a claim that an APK can restore the impossible word-for-word original source. A definitive common startup-crash fix still requires a readable Android/MIUI crash detail or ADB log captured immediately after launch on a compatible ARM phone.
