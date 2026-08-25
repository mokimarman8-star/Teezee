package com.transsion.baselib.net;

import android.text.TextUtils;
import com.blankj.utilcode.util.b0;
import com.therouter.TheRouter;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import qx.a;
import wg.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class f implements Interceptor {
    public static final a b = new a((DefaultConstructorMarker) null);
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.baselib.net.e
        public final Object invoke() {
            a d;
            d = f.d();
            return d;
        }
    });

    private final String b() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String g = b0.g(valueOf);
        a.a aVar = wg.a.a;
        Intrinsics.e(g);
        return valueOf + "," + aVar.a(g);
    }

    private final qx.a c() {
        return (qx.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qx.a d() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        Request request = chain.request();
        qx.a c = c();
        UserInfo i = c != null ? c.i() : null;
        if (i == null || TextUtils.isEmpty(i.getToken())) {
            request = request.newBuilder().header("X-Client-Token", b()).build();
        } else {
            String token = i.getToken();
            if (token != null) {
                request = request.newBuilder().header("Authorization", eg.a.a.a(token)).build();
            }
        }
        Response proceed = chain.proceed(request);
        qx.a c2 = c();
        if (c2 != null) {
            c2.h(proceed);
        }
        return proceed;
    }
}
