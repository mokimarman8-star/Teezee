package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class o {
    private final b0 a;
    private final f b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private o(b0 b0Var, f fVar, List<Certificate> list, List<Certificate> list2) {
        this.a = b0Var;
        this.b = fVar;
        this.c = list;
        this.d = list2;
    }

    public static o a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        f a = f.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        b0 a2 = b0.a(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List a3 = certificateArr != null ? com.mbridge.msdk.thrid.okhttp.internal.c.a(certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new o(a2, a, a3, localCertificates != null ? com.mbridge.msdk.thrid.okhttp.internal.c.a(localCertificates) : Collections.emptyList());
    }

    public f a() {
        return this.b;
    }

    public List<Certificate> b() {
        return this.c;
    }

    public b0 c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.a.equals(oVar.a) && this.b.equals(oVar.b) && this.c.equals(oVar.c) && this.d.equals(oVar.d);
    }

    public int hashCode() {
        return ((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }
}
