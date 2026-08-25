package com.transsion.transfer.androidasync.http;

import com.transsion.transfer.androidasync.http.g;
import java.lang.reflect.Field;
import java.util.Hashtable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class z implements m {
    Hashtable a = new Hashtable();

    private static class a implements m {
        Field a;
        Field b;
        Field c;
        Field d;
        boolean e;

        public a(Class cls) {
            try {
                Field declaredField = cls.getSuperclass().getDeclaredField("peerHost");
                this.a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getSuperclass().getDeclaredField("peerPort");
                this.b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("sslParameters");
                this.c = declaredField3;
                declaredField3.setAccessible(true);
                Field declaredField4 = this.c.getType().getDeclaredField("useSni");
                this.d = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        }

        @Override // com.transsion.transfer.androidasync.http.m
        public SSLEngine a(SSLContext sSLContext, String str, int i) {
            return null;
        }

        @Override // com.transsion.transfer.androidasync.http.m
        public void b(SSLEngine sSLEngine, g.a aVar, String str, int i) {
            if (this.d == null || this.e) {
                return;
            }
            try {
                this.a.set(sSLEngine, str);
                this.b.set(sSLEngine, Integer.valueOf(i));
                this.d.set(this.c.get(sSLEngine), Boolean.TRUE);
            } catch (IllegalAccessException unused) {
            }
        }
    }

    @Override // com.transsion.transfer.androidasync.http.m
    public SSLEngine a(SSLContext sSLContext, String str, int i) {
        "GmsCore_OpenSSL".equals(sSLContext.getProvider().getName());
        return sSLContext.createSSLEngine(str, i);
    }

    @Override // com.transsion.transfer.androidasync.http.m
    public void b(SSLEngine sSLEngine, g.a aVar, String str, int i) {
        c(sSLEngine).b(sSLEngine, aVar, str, i);
    }

    a c(SSLEngine sSLEngine) {
        String canonicalName = sSLEngine.getClass().getCanonicalName();
        a aVar = (a) this.a.get(canonicalName);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(sSLEngine.getClass());
        this.a.put(canonicalName, aVar2);
        return aVar2;
    }
}
