package com.tn.tranpay.network;

import com.tn.tranpay.TranPayConfiguration;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.k0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class RetrofitClient {
    public static final RetrofitClient a = new RetrofitClient();
    private static String b;
    private static final Lazy c;
    private static final Lazy d;

    static {
        b = TranPayConfiguration.a.u() ? "https://api.paynicorn.com" : "https://test.paynicorn.com/";
        c = LazyKt.b(new Function0<OkHttpClient>() { // from class: com.tn.tranpay.network.RetrofitClient$okHttpClient$2
            public final OkHttpClient invoke() {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder addNetworkInterceptor = new OkHttpClient.Builder().addNetworkInterceptor(new a()).addNetworkInterceptor(httpLoggingInterceptor);
                TimeUnit timeUnit = TimeUnit.SECONDS;
                return addNetworkInterceptor.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
            }
        });
        d = LazyKt.b(new Function0<k0>() { // from class: com.tn.tranpay.network.RetrofitClient$retrofit$2
            public final k0 invoke() {
                String str;
                OkHttpClient c2;
                k0.b bVar = new k0.b();
                str = RetrofitClient.b;
                k0.b c3 = bVar.c(str);
                c2 = RetrofitClient.a.c();
                return c3.g(c2).b(k00.a.f()).e();
            }
        });
    }

    private RetrofitClient() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient c() {
        return (OkHttpClient) c.getValue();
    }

    public final k0 d() {
        Object value = d.getValue();
        Intrinsics.g(value, "<get-retrofit>(...)");
        return (k0) value;
    }
}
