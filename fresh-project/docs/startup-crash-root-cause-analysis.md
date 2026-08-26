# Teezee startup crash investigation

## Current evidence

The exact repository package declares `com.teezee.app`, while the launcher application class is `com.transsion.subroom.app.SubRoomApp`. A reproducible runtime stack trace from an ARM device has not yet been captured in this environment, so this document records suspects rather than claiming a confirmed fix.

## Highest-priority suspect: `KillerApplication`

`SubRoomApp` extends `bin.mt.signature.KillerApplication`. The parent class has a static initializer that runs before `SubRoomApp.onCreate()`. That initializer calls `killPM(...)`, uses reflection against `PackageInfo.CREATOR`, `PackageManager.sPackageInfoCache`, and hidden Android APIs, then calls `killOpen(...)` to load `libSignatureKiller.so` and hook the APK path.

The decoded source also contains hard-coded values for `com.community.oneroom`, even though the Teezee manifest package is `com.teezee.app`. `killOpen()` catches its own failures, but `killPM()` rethrows an exception after reflection failures. On modern Android releases, hidden-API restrictions, changed package-manager internals, or a signing/package mismatch could therefore terminate the process before the launcher activity is shown. This is a strong common-startup suspect, not a confirmed root cause.

No anti-tamper bypass is applied in this change. Removing or changing it without a real device exception would risk altering security behavior and could hide the actual cause.

## Other startup suspects

The splash activity starts optional HiSavana/ad/configuration work, preloads trending data, initializes push registration, and can invoke several proprietary SDKs before moving to `MainActivity`. A guarded eight-second fallback has been added to the tracked readable `SplashActivity.java`, but it cannot help if the process crashes earlier in `Application` initialization or inside the first activity setup.

The manifest contains many providers, receivers and services from AndroidX, Firebase, advertising, push, media and download libraries. Any provider that initializes before the first activity can also produce a process-start crash. These components require a device log to distinguish from the `KillerApplication` path.

## Required evidence before a definitive fix

Capture an Android Debug Bridge log immediately after launching Teezee and provide the section containing `FATAL EXCEPTION`, `AndroidRuntime`, `Process: com.teezee.app`, or `UnsatisfiedLinkError`. A readable MIUI crash-detail page or exported bug-report text is also sufficient. The black/generic report screen alone does not identify the exception.

Until that evidence is available, the repository will keep the startup fix conservative: preserve the package, branding, resources, native libraries and observable behavior; avoid disabling signature protection blindly; and describe the GitHub release as packaging/signature verified rather than runtime-launch verified.
