# Teezee automatic release signing setup

The release workflow in `.github/workflows/release.yml` intentionally fails closed when signing secrets are absent. This prevents an accidental release signed with a newly generated key that would not match the existing Teezee certificate.

Add these four **repository Actions secrets** in the GitHub web interface for `mokimarman8-star/Teezee`:

| Secret | Value |
|---|---|
| `TEEZEE_KEYSTORE_B64` | Base64 of the legitimate Teezee release keystore file. |
| `TEEZEE_KEY_ALIAS` | The alias belonging to that keystore. |
| `TEEZEE_STORE_PASSWORD` | Keystore password. |
| `TEEZEE_KEY_PASSWORD` | Private-key password. |

To prepare only the Base64 value on a trusted local machine, use a command such as:

```bash
base64 -w0 /secure/path/to/teezee-release.jks > /tmp/teezee-release.jks.b64
```

Copy the resulting single-line value directly into the `TEEZEE_KEYSTORE_B64` secret field. Do not commit the keystore, properties file, password, Base64 value, or personal access token. Do not post any of them in an issue or chat.

The workflow reconstructs the keystore under the runner's temporary directory, exports only the required environment variables to the build step, signs with v1/v2/v3, verifies the signature, creates the SHA-256 file, and then creates or updates the release without deleting an existing release.

If the original release keystore is unavailable, an owner-controlled replacement key can sign future releases, but Android users will need to uninstall the currently installed app before installing that differently signed APK. The package ID can stay `com.teezee.app`, but the certificate relationship cannot be recreated from the package name alone.
