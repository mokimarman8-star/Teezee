package com.transsion.lib_web.zip.loader;

import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.lib_web.zip.loader.a
        public final Object invoke() {
            OkHttpClient b2;
            b2 = b.b();
            return b2;
        }
    });

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient b() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(30L, timeUnit).cache((Cache) null).build();
    }

    private final OkHttpClient c() {
        return (OkHttpClient) b.getValue();
    }

    public final OkHttpClient d() {
        return c();
    }
}
