package wh;

import com.tn.lib.net.interceptor.HttpLoggingInterceptor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();
    private static final HttpLoggingInterceptor b;
    private static final Lazy c;

    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.a) null, 1, (DefaultConstructorMarker) null);
        httpLoggingInterceptor.b(HttpLoggingInterceptor.Level.BODY);
        b = httpLoggingInterceptor;
        c = LazyKt.b(new Function0() { // from class: wh.a
            public final Object invoke() {
                OkHttpClient b2;
                b2 = b.b();
                return b2;
            }
        });
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient b() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(30L, timeUnit).cache((Cache) null).addInterceptor(b).build();
    }

    private final OkHttpClient c() {
        return (OkHttpClient) c.getValue();
    }

    public final OkHttpClient d() {
        return c();
    }
}
