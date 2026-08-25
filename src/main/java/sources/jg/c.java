package jg;

import java.util.Map;
import jg.b;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c implements Interceptor {
    private final String a = "HeaderInterceptor";

    private final Request a(Request request, String str) {
        b.a aVar = b.a;
        String c = aVar.c();
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.addHeader("X-Client-Info", c);
        newBuilder.addHeader("X-Client-Status", String.valueOf(!Intrinsics.c(aVar.d(), Boolean.TRUE) ? 1 : 0));
        return newBuilder.build();
    }

    private final Request b(Request request) {
        Map f = b.a.f();
        if (f.isEmpty()) {
            return request;
        }
        Request.Builder newBuilder = request.newBuilder();
        for (Map.Entry entry : f.entrySet()) {
            newBuilder.header((String) entry.getKey(), (String) entry.getValue());
        }
        return newBuilder.build();
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        return chain.proceed(a(b(chain.request()), ""));
    }
}
