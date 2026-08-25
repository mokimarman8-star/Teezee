package kg;

import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.tn.lib.net.interceptor.HttpLoggingInterceptor;
import com.transsion.api.gateway.interceptor.GatewayInterceptor;
import ig.e;
import j00.g;
import java.net.Proxy;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.chromium.net.CronetEngine;
import retrofit2.k0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class c {
    public static final a e = new a((DefaultConstructorMarker) null);
    private static final Lazy f = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: kg.b
        public final Object invoke() {
            c i;
            i = c.i();
            return i;
        }
    });
    private static final String g = "one_room_net_thread";
    private OkHttpClient b;
    private k0 c;
    private final String a = "NetServiceGenerator";
    private final AtomicInteger d = new AtomicInteger(1);

    public c() {
        CacheIpPool.a.h();
        this.b = j();
        k0.b c = new k0.b().c(gg.a.a.a());
        OkHttpClient okHttpClient = this.b;
        Intrinsics.e(okHttpClient);
        this.c = c.g(okHttpClient).b(fg.a.f()).a(g.d(ey.a.a(Executors.newFixedThreadPool(6, new ThreadFactory() { // from class: kg.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread c2;
                c2 = c.c(c.this, runnable);
                return c2;
            }
        })))).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread c(c cVar, Runnable runnable) {
        Thread thread = new Thread(runnable, g + "-" + cVar.d.incrementAndGet());
        thread.setPriority(10);
        return thread;
    }

    private final Object e(Class cls) {
        return new k0.b().e().b(cls);
    }

    private final Interceptor f() {
        try {
            CronetEngine.Builder builder = new CronetEngine.Builder(Utils.a());
            builder.enableQuic(true).enableBrotli(true).addQuicHint("api3.aoneroom.com", 443, 443).addQuicHint("api4.aoneroom.com", 443, 443).addQuicHint("api4sg.aoneroom.com", 443, 443).addQuicHint("api5.aoneroom.com", 443, 443).addQuicHint("api6.aoneroom.com", 443, 443).addQuicHint(" api7.aoneroom.com ", 443, 443).addQuicHint(" api8.aoneroom.com", 443, 443).addQuicHint("api6sg.aoneroom.com", 443, 443).addQuicHint("api.inmoviebox.com", 443, 443).addQuicHint("test-mse-api.aoneroom.com", 443, 443);
            CronetEngine build = builder.build();
            Intrinsics.g(build, "build(...)");
            return (Interceptor) com.google.net.cronet.okhttptransport.a.j(build).a();
        } catch (Throwable th) {
            Log.e("error", "e " + th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c i() {
        return new c();
    }

    private final OkHttpClient j() {
        Proxy proxy = ag.a.a.c() ? null : Proxy.NO_PROXY;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory a = lg.a.a();
        Intrinsics.g(a, "createSSLSocketFactory(...)");
        builder.sslSocketFactory(a, new lg.a()).hostnameVerifier(new a.a());
        OkHttpClient.Builder proxy2 = builder.proxy(proxy);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        proxy2.connectTimeout(40L, timeUnit).writeTimeout(20L, timeUnit).readTimeout(20L, timeUnit).callTimeout(40L, timeUnit).addInterceptor(jg.a.a.a()).addInterceptor(new ig.c()).addInterceptor(new GatewayInterceptor()).addInterceptor(new ig.a());
        Iterator it = e.a.b().iterator();
        while (it.hasNext()) {
            builder.addInterceptor((Interceptor) it.next());
        }
        if (ag.a.a.c()) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new com.tn.lib.net.interceptor.a());
            httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        Interceptor f2 = f();
        if (f2 != null) {
            builder.addInterceptor(f2);
        }
        return builder.build();
    }

    private final void k() {
        bg.a aVar = bg.a.a;
        aVar.a(0);
        aVar.b(0L);
    }

    public final OkHttpClient g() {
        return this.b;
    }

    public final Object h(Class cls) {
        Object e3;
        Intrinsics.h(cls, "service");
        k0 k0Var = this.c;
        if (k0Var == null || (e3 = k0Var.b(cls)) == null) {
            e3 = e(cls);
        }
        try {
            k();
            return e3;
        } catch (Exception e4) {
            e4.printStackTrace();
            return e3;
        }
    }
}
