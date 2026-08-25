# Teezee Android Application

> **Clean, High-Performance Android Build & Automated CI/CD Release System**

## 📱 Project Overview
Teezee is an Android media application featuring full native acceleration (ARM64-v8a & ARMEABI-v7a), modern Android 15 (API 35) runtime compatibility, and automated multi-scheme signing.

---

## 🛠️ Key Improvements & Fixes
- **Installation Fix**: Resolved signature validation and `META-INF` integrity conflicts that triggered `"App not installed"` on Android devices.
- **Strict 4-Byte Zip Alignment**: Standard Android page alignment applied across all resources and native binaries.
- **Multi-Scheme Signing**: Signed simultaneously with **v1 (JAR)**, **v2 (APK Signature Scheme)**, and **v3 (APK Signature Scheme v3)**.
- **Automated CI/CD**: Automatic semantic tag incrementing (`v1.0.2`, `v1.0.3`...), signed APK build, and automated GitHub Release publishing.

---

## 🚀 Automated Release Workflow (GitHub Actions)
Every push to `main` or manual trigger via **GitHub Actions** (`workflow_dispatch`) will:
1. Detect the latest release tag and automatically bump the semantic version (e.g. `v1.0.2` -> `v1.0.3`).
2. Package and zip-align the application.
3. Sign the APK with release keys (`v1` + `v2` + `v3`).
4. Generate a SHA-256 checksum.
5. Create a new GitHub Release with the tag and upload the signed APK (`Teezee-v<version>.apk`).

---

## 💻 Local Build Instructions

### Prerequisites
- Java JDK 17 or 21
- `zipalign`
- `apksigner`
- `zip` & `unzip`

### Build Command
```bash
# Build default version (e.g., 1.0.2)
./scripts/build.sh

# Or build a specific version
./scripts/build.sh 1.0.3
```

Output APK will be available in the `dist/` directory:
- `dist/Teezee-v<version>.apk`
- `dist/Teezee-v<version>.apk.sha256`

---

## 🔒 Security & Verification
To verify the APK signature locally:
```bash
apksigner verify --verbose --print-certs dist/Teezee-v1.0.2.apk
```
Expected output:
```text
Verifies
Verified using v1 scheme (JAR signing): true
Verified using v2 scheme (APK Signature Scheme v2): true
Verified using v3 scheme (APK Signature Scheme v3): true
```

---

## 📂 Project Structure
```text
Teezee/
├── .github/
│   └── workflows/
│       └── release.yml        # Automated Build & Release Workflow
├── app_source/                # Complete APK Resources & Dex Bytecode
│   ├── AndroidManifest.xml
│   ├── resources.arsc
│   ├── classes.dex ... classes9.dex
│   ├── assets/
│   ├── lib/ (arm64-v8a, armeabi-v7a)
│   └── res/
├── keystore/
│   ├── release.jks            # Release Signing Keystore
│   └── keystore.properties
├── scripts/
│   ├── build.sh               # Local & CI Build Engine
│   └── auto_tag.py            # Automated Version Tag Engine
└── README.md
```
