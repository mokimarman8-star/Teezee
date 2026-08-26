# Teezee Android Application

> **Clean, High-Performance Android Build & Automated CI/CD Release System**

## 📱 Project Overview
Teezee is an Android media application preserving the exact package identity `com.teezee.app`, ARM64-v8a and armeabi-v7a native libraries, the original branding/resources, and automated multi-scheme APK packaging.

---

## 🛠️ Packaging and reconstruction status
- **Package identity**: `com.teezee.app` and the original launcher/application declarations are preserved.
- **APK packaging**: The build engine stores and aligns `resources.arsc`, then verifies v1, v2 and v3 signatures.
- **Readable reconstruction**: Startup source, UI/resource inventories and feature boundaries are maintained under `src/main/java/sources/` and `fresh-project/`.
- **Runtime validation boundary**: GitHub-hosted x86 runners cannot launch this ARM-only APK, and no compatible ARM-device stack trace is currently available; therefore the common phone crash is not claimed fixed.

---

## 🚀 Automated Release Workflow (GitHub Actions)
Every push to `main`, `v*` tag, or manual trigger via **GitHub Actions** (`workflow_dispatch`) will:
1. Validate or compute a semantic version and create the tag when required.
2. Restore the signing keystore only from repository secrets in a temporary runner path.
3. Package, align, sign and verify the APK with v1, v2 and v3.
4. Generate a SHA-256 checksum.
5. Create or update the GitHub Release and upload `Teezee-v<version>.apk` plus its checksum without deleting an existing release.

Before enabling the workflow, the repository owner must add `TEEZEE_KEYSTORE_B64`, `TEEZEE_KEY_ALIAS`, `TEEZEE_STORE_PASSWORD` and `TEEZEE_KEY_PASSWORD` under the repository's Actions secrets. The workflow fails closed when any is missing.

---

## 💻 Local Build Instructions

### Prerequisites
- Java JDK 17 or 21
- `zipalign`
- `apksigner`
- `zip` & `unzip`
- A local signing keystore and credentials supplied through `TEEZEE_KEYSTORE_PATH`, `TEEZEE_KEY_ALIAS`, `TEEZEE_STORE_PASSWORD` and `TEEZEE_KEY_PASSWORD`, or an ignored `keystore/keystore.properties` file.

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
Signing files and credentials are intentionally not tracked in Git. The old tracked signing files were removed from the current branch; the signing certificate relationship is preserved only when the repository owner supplies the same keystore through protected secrets or a secure local path.

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
