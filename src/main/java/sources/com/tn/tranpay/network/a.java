package com.tn.tranpay.network;

import android.app.Application;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.device.TNDeviceHelper;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a implements Interceptor {
    private final String a() {
        try {
            Application d = TranPay.a.d();
            String str = d.getPackageManager().getPackageInfo(d.getPackageName(), 0).versionName;
            Intrinsics.g(str, "{\n            // 使用 Tran… 0).versionName\n        }");
            return str;
        } catch (Exception e) {
            lh.a.e(lh.a.a, "Failed to get app version: " + e.getMessage(), null, 2, null);
            return TmcConstants.ROUTE_UNKNOWN;
        }
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        List<Pair> q = CollectionsKt.q(new Pair[]{TuplesKt.a("sdkVersion", TranPay.a.e()), TuplesKt.a("appVersion", a()), TuplesKt.a("deviceId", TNDeviceHelper.a.c()), TuplesKt.a("platform", "android"), TuplesKt.a("Content-Type", "application/json;charset=UTF-8")});
        Request.Builder newBuilder = chain.request().newBuilder();
        for (Pair pair : q) {
            newBuilder.header((String) pair.getFirst(), (String) pair.getSecond());
        }
        return chain.proceed(newBuilder.build());
    }
}
