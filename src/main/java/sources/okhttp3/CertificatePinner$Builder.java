package okhttp3;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000b\"\u00020\n¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "pins", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/CertificatePinner$Pin;", "getPins", "()Ljava/util/List;", "add", "pattern", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "build", "Lokhttp3/CertificatePinner;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class CertificatePinner$Builder {
    private final List<CertificatePinner$Pin> pins = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public final CertificatePinner$Builder add(final String pattern, String... pins) {
        Intrinsics.h(pattern, "pattern");
        Intrinsics.h(pins, "pins");
        for (final String str : pins) {
            this.pins.add(new Object(pattern, str) { // from class: okhttp3.CertificatePinner$Pin
                private final ByteString hash;
                private final String hashAlgorithm;
                private final String pattern;

                {
                    Intrinsics.h(pattern, "pattern");
                    Intrinsics.h(str, "pin");
                    if ((!StringsKt.W(pattern, "*.", false, 2, null) || StringsKt.o0(pattern, "*", 1, false, 4, null) != -1) && ((!StringsKt.W(pattern, "**.", false, 2, null) || StringsKt.o0(pattern, "*", 2, false, 4, null) != -1) && StringsKt.o0(pattern, "*", 0, false, 6, null) != -1)) {
                        throw new IllegalArgumentException(("Unexpected pattern: " + pattern).toString());
                    }
                    String canonicalHost = HostnamesKt.toCanonicalHost(pattern);
                    if (canonicalHost == null) {
                        throw new IllegalArgumentException("Invalid pattern: " + pattern);
                    }
                    this.pattern = canonicalHost;
                    if (StringsKt.W(str, "sha1/", false, 2, null)) {
                        this.hashAlgorithm = "sha1";
                        ByteString.Companion companion = ByteString.Companion;
                        String substring = str.substring(5);
                        Intrinsics.g(substring, "this as java.lang.String).substring(startIndex)");
                        ByteString decodeBase64 = companion.decodeBase64(substring);
                        if (decodeBase64 != null) {
                            this.hash = decodeBase64;
                            return;
                        }
                        throw new IllegalArgumentException("Invalid pin hash: " + str);
                    }
                    if (!StringsKt.W(str, "sha256/", false, 2, null)) {
                        throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str);
                    }
                    this.hashAlgorithm = "sha256";
                    ByteString.Companion companion2 = ByteString.Companion;
                    String substring2 = str.substring(7);
                    Intrinsics.g(substring2, "this as java.lang.String).substring(startIndex)");
                    ByteString decodeBase642 = companion2.decodeBase64(substring2);
                    if (decodeBase642 != null) {
                        this.hash = decodeBase642;
                        return;
                    }
                    throw new IllegalArgumentException("Invalid pin hash: " + str);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof CertificatePinner$Pin)) {
                        return false;
                    }
                    CertificatePinner$Pin certificatePinner$Pin = (CertificatePinner$Pin) other;
                    return Intrinsics.c(this.pattern, certificatePinner$Pin.pattern) && Intrinsics.c(this.hashAlgorithm, certificatePinner$Pin.hashAlgorithm) && Intrinsics.c(this.hash, certificatePinner$Pin.hash);
                }

                public final ByteString getHash() {
                    return this.hash;
                }

                public final String getHashAlgorithm() {
                    return this.hashAlgorithm;
                }

                public final String getPattern() {
                    return this.pattern;
                }

                public int hashCode() {
                    return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
                }

                public final boolean matchesCertificate(X509Certificate certificate) {
                    Intrinsics.h(certificate, "certificate");
                    String str2 = this.hashAlgorithm;
                    if (Intrinsics.c(str2, "sha256")) {
                        return Intrinsics.c(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
                    }
                    if (Intrinsics.c(str2, "sha1")) {
                        return Intrinsics.c(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
                    }
                    return false;
                }

                public final boolean matchesHostname(String hostname) {
                    Intrinsics.h(hostname, "hostname");
                    if (StringsKt.W(this.pattern, "**.", false, 2, null)) {
                        int length = this.pattern.length() - 3;
                        int length2 = hostname.length() - length;
                        if (!StringsKt.L(hostname, hostname.length() - length, this.pattern, 3, length, false, 16, null)) {
                            return false;
                        }
                        if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                            return false;
                        }
                    } else {
                        if (!StringsKt.W(this.pattern, "*.", false, 2, null)) {
                            return Intrinsics.c(hostname, this.pattern);
                        }
                        int length3 = this.pattern.length() - 1;
                        int length4 = hostname.length() - length3;
                        if (!StringsKt.L(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, null) || StringsKt.u0(hostname, '.', length4 - 1, false, 4, null) != -1) {
                            return false;
                        }
                    }
                    return true;
                }

                public String toString() {
                    return this.hashAlgorithm + '/' + this.hash.base64();
                }
            });
        }
        return this;
    }

    public final CertificatePinner build() {
        return new CertificatePinner(CollectionsKt.W0(this.pins), (CertificateChainCleaner) null, 2, (DefaultConstructorMarker) null);
    }

    public final List<CertificatePinner$Pin> getPins() {
        return this.pins;
    }
}
