package com.cloud.hisavana.protocol.intercept;

import com.cloud.config.utils.ConstantsKt;
import com.cloud.sdk.commonutil.util.c;
import java.net.UnknownHostException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mh.h;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a implements Interceptor {
    private final Map a;

    public a(Map map) {
        Intrinsics.h(map, "hostMap");
        this.a = map;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        try {
            Response proceed = chain.proceed(chain.request());
            Intrinsics.g(proceed, "proceed(...)");
            return proceed;
        } catch (Exception e) {
            HttpUrl url = chain.request().url();
            String str = (String) this.a.get(url.host());
            if (str == null || !(e instanceof UnknownHostException)) {
                throw e;
            }
            Request build = chain.request().newBuilder().url(url.newBuilder().host(str).build()).build();
            c.netLog("request downgrade, domain failed, failed url is:" + chain.request().url());
            h hVar = h.a;
            Intrinsics.e(build);
            hVar.a(chain, build, ConstantsKt.ERROR_1005);
            Response proceed2 = chain.proceed(build);
            Intrinsics.g(proceed2, "proceed(...)");
            return proceed2;
        }
    }
}
