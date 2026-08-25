package il;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a {
    protected static HostnameVerifier a;

    /* renamed from: il.a$a, reason: collision with other inner class name */
    class C0073a implements HostnameVerifier {
        C0073a(a aVar) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public HostnameVerifier a() {
        if (a == null) {
            synchronized (this) {
                try {
                    if (a == null) {
                        a = new C0073a(this);
                    }
                } finally {
                }
            }
        }
        return a;
    }
}
