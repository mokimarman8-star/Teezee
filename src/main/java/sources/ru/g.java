package ru;

import com.transsion.upgradesdk.net.j;
import com.transsion.upgradesdk.net.k;
import com.transsion.upgradesdk.net.l;
import com.transsion.upgradesdk.net.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient$Builder;
import retrofit2.k0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class g {
    public static final Lazy a = LazyKt.b(k.a);
    public static final Lazy b = LazyKt.b(j.a);
    public static final OkHttpClient c = new OkHttpClient$Builder().addInterceptor(new a()).build();
    public static final Lazy d = LazyKt.b(m.a);
    public static final Lazy e = LazyKt.b(l.a);

    public static k0 a() {
        Object value = e.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (k0) value;
    }

    public static k0 b() {
        Object value = d.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (k0) value;
    }
}
