package ru;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    public static final Lazy f = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, com.transsion.upgradesdk.net.f.a);
    public boolean a;
    public long c;
    public final com.transsion.upgradesdk.net.g b = new com.transsion.upgradesdk.net.g(this);
    public final String d = "UpgradeSdkManager";
    public final e e = new e(this);

    public static final void b(f fVar) {
        fVar.getClass();
        Intrinsics.y("connectivityManager");
        throw null;
    }

    public final void a() {
        if (this.a) {
            return;
        }
        this.a = true;
        Application application = pu.a.a;
        Application application2 = null;
        if (application == null) {
            Intrinsics.y("application");
            application = null;
        }
        Object systemService = application.getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT >= 24) {
            e2.b.a(connectivityManager, this.e);
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        Application application3 = pu.a.a;
        if (application3 != null) {
            application2 = application3;
        } else {
            Intrinsics.y("application");
        }
        application2.registerReceiver(this.b, intentFilter);
    }
}
