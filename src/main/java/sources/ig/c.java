package ig;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tn.lib.net.dns.or.CacheIpPool;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class c implements Interceptor {
    public static final a b = new a((DefaultConstructorMarker) null);
    private final Lazy a = LazyKt.b(new Function0() { // from class: ig.b
        public final Object invoke() {
            Handler b2;
            b2 = c.b();
            return b2;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler b() {
        return new Handler(Looper.getMainLooper());
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        Request request = chain.request();
        HttpUrl.Builder newBuilder = request.url().newBuilder();
        String host = request.url().host();
        CacheIpPool cacheIpPool = CacheIpPool.a;
        if (TextUtils.equals(host, cacheIpPool.l()) && TextUtils.equals(request.url().scheme(), cacheIpPool.m())) {
            newBuilder.removeAllQueryParameters("host");
        } else {
            newBuilder.scheme(cacheIpPool.m()).host(cacheIpPool.l()).removeAllQueryParameters("host");
        }
        Request build = request.newBuilder().url(newBuilder.build()).build();
        Response proceed = chain.proceed(build);
        a.a.p("HttpTag", new String[]{"DynamicHostInterceptor response " + proceed.code() + " : " + build.url() + " protocol: " + proceed.protocol() + " "}, true);
        return proceed;
    }
}
