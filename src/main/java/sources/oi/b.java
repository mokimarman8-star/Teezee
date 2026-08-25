package oi;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        Intrinsics.h(str, "s");
        Intrinsics.h(sSLSession, "sslSession");
        return true;
    }
}
