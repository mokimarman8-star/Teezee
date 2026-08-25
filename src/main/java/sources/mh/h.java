package mh;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Request;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class h {
    public static final h a = new h();

    private h() {
    }

    private final i b(Interceptor.Chain chain) {
        m mVar = m.a;
        Call call = chain.call();
        Intrinsics.g(call, "chain.call()");
        Object a2 = mVar.a(call, "eventListener");
        if (a2 instanceof i) {
            return (i) a2;
        }
        return null;
    }

    public final void a(Interceptor.Chain chain, Request request, int i) {
        Intrinsics.h(chain, "chain");
        Intrinsics.h(request, "buildRequest");
        i b = b(chain);
        if (b != null) {
            b.a(request, i);
        }
    }
}
