package il;

import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b {
    protected static SSLSocketFactory a;

    class a implements X509TrustManager {
        a(b bVar) {
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

    public SSLSocketFactory a() {
        if (a == null) {
            synchronized (this) {
                try {
                    if (a == null) {
                        TrustManager[] trustManagerArr = {new a(this)};
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, trustManagerArr, null);
                        a = sSLContext.getSocketFactory();
                    }
                } catch (Throwable th2) {
                    jl.a.a.e("SSL", th2.getMessage());
                } finally {
                }
            }
        }
        return a;
    }
}
