package com.mbridge.msdk.thrid.okhttp.internal.platform;

import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class g {
    private static final g a = c();
    private static final Logger b = Logger.getLogger(t.class.getName());

    private static g a() {
        g h = a.h();
        if (h != null) {
            return h;
        }
        g h2 = b.h();
        if (h2 != null) {
            return h2;
        }
        throw new NullPointerException("No platform found on Android");
    }

    public static List<String> a(List<u> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            u uVar = list.get(i);
            if (uVar != u.HTTP_1_0) {
                arrayList.add(uVar.toString());
            }
        }
        return arrayList;
    }

    private static g b() {
        c h;
        if (g() && (h = c.h()) != null) {
            return h;
        }
        d h2 = d.h();
        if (h2 != null) {
            return h2;
        }
        g h3 = e.h();
        return h3 != null ? h3 : new g();
    }

    static byte[] b(List<u> list) {
        com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            u uVar = list.get(i);
            if (uVar != u.HTTP_1_0) {
                cVar.writeByte(uVar.toString().length());
                cVar.a(uVar.toString());
            }
        }
        return cVar.n();
    }

    private static g c() {
        return f() ? a() : b();
    }

    public static g d() {
        return a;
    }

    public static boolean f() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    public static boolean g() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    public com.mbridge.msdk.thrid.okhttp.internal.tls.c a(X509TrustManager x509TrustManager) {
        return new com.mbridge.msdk.thrid.okhttp.internal.tls.a(b(x509TrustManager));
    }

    public Object a(String str) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(int i, String str, Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<u> list) throws IOException {
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
    }

    public com.mbridge.msdk.thrid.okhttp.internal.tls.e b(X509TrustManager x509TrustManager) {
        return new com.mbridge.msdk.thrid.okhttp.internal.tls.b(x509TrustManager.getAcceptedIssuers());
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    public SSLContext e() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
