package bz;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class k {
    public static b a = new b();

    class a implements X509TrustManager {
        a() {
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

    static class b implements HostnameVerifier {
        private HostnameVerifier a = HttpsURLConnection.getDefaultHostnameVerifier();

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return this.a.verify(str, sSLSession);
        }
    }

    public static SSLContext a() {
        SSLContext sSLContext;
        SSLContext sSLContext2 = null;
        try {
            sSLContext = SSLContext.getInstance("TLS");
        } catch (Exception unused) {
        }
        try {
            sSLContext.init(null, new TrustManager[]{new a()}, new SecureRandom());
            return sSLContext;
        } catch (Exception unused2) {
            sSLContext2 = sSLContext;
            return sSLContext2;
        }
    }
}
