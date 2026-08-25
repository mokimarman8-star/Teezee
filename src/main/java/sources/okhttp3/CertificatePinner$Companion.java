package okhttp3;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.ByteString;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "DEFAULT", "Lokhttp3/CertificatePinner;", "pin", HttpUrl.FRAGMENT_ENCODE_SET, "certificate", "Ljava/security/cert/Certificate;", "sha1Hash", "Lokio/ByteString;", "Ljava/security/cert/X509Certificate;", "sha256Hash", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class CertificatePinner$Companion {
    private CertificatePinner$Companion() {
    }

    public /* synthetic */ CertificatePinner$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public final String pin(Certificate certificate) {
        Intrinsics.h(certificate, "certificate");
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
    }

    @JvmStatic
    public final ByteString sha1Hash(X509Certificate x509Certificate) {
        Intrinsics.h(x509Certificate, "<this>");
        ByteString.Companion companion = ByteString.Companion;
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        Intrinsics.g(encoded, "publicKey.encoded");
        return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, (Object) null).sha1();
    }

    @JvmStatic
    public final ByteString sha256Hash(X509Certificate x509Certificate) {
        Intrinsics.h(x509Certificate, "<this>");
        ByteString.Companion companion = ByteString.Companion;
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        Intrinsics.g(encoded, "publicKey.encoded");
        return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, (Object) null).sha256();
    }
}
