package oi;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements X509TrustManager {
    public static final C0087a a = new C0087a(null);

    /* renamed from: oi.a$a, reason: collision with other inner class name */
    public static final class C0087a {
        private C0087a() {
        }

        public /* synthetic */ C0087a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SSLSocketFactory a() {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{new a()}, new SecureRandom());
                return sSLContext.getSocketFactory();
            } catch (Exception unused) {
                return null;
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
