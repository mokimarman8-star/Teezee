package c7;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.CommonOkHttpClient;
import com.cloud.hisavana.sdk.Y;
import com.cloud.hisavana.sdk.b4;
import com.cloud.hisavana.sdk.c0;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.util.j0;
import com.cloud.hisavana.sdk.database.HisavanaContentProvider;
import com.cloud.hisavana.sdk.g0;
import com.cloud.hisavana.sdk.g1;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.hisavana.sdk.s1;
import com.cloud.hisavana.sdk.x;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.e;
import com.cloud.sdk.commonutil.util.m;
import com.cloud.sdk.commonutil.util.o;
import java.util.concurrent.atomic.AtomicLong;
import mh.k;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class b {
    private static a a = null;
    public static String b = null;
    private static boolean c = true;
    private static AtomicLong d = new AtomicLong(0);
    private static int e = -1;
    private static int f = 10;
    private static boolean g = true;
    private static boolean h = false;

    private static void c(a aVar) {
        if (a != null || aVar == null) {
            return;
        }
        if (!a.c(aVar)) {
            c.NET_LOG.m().q(Log.isLoggable("AD_NET_LOG", 3));
        }
        j0.b(a.e(aVar));
        if (!a.c(aVar)) {
            a.b(aVar, Log.isLoggable("TA_SDK", 3) || Log.isLoggable("ADSDK", 3));
        }
        a = aVar;
        c0.a.c(a.f(a));
        DeviceUtil.e();
        AthenaTracker.o(a.c(a), e.a());
        NetStateManager.registerMonitorBroadcast();
        b4.b().setLogSwitch(a.c(a));
        AthenaTracker.R();
        e();
        n7.c.e();
        HSScopeHelper.a.i(new Runnable() { // from class: c7.a
            @Override // java.lang.Runnable
            public final void run() {
                b.g();
            }
        });
        g0.b(e.a());
        Y.a.k(d.get());
        x.a.O();
        s1.a.d();
    }

    private static void e() {
        try {
            if (e.a().getApplicationContext() instanceof Application) {
                k.c((Application) e.a().getApplicationContext(), false);
                CommonOkHttpClient.a = l();
            }
        } catch (Exception unused) {
            b4.b().e("init NetworkMonitor failure!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g() {
        g1.o().n(1);
        o.n();
        k7.a.s0();
    }

    public static boolean h() {
        return g;
    }

    public static boolean i() {
        return h;
    }

    public static int j() {
        return e;
    }

    public static void k(Context context, a aVar) {
        if (TextUtils.isEmpty(b)) {
            b4.b().e("AdManager", "AppId is empty, please check your config.");
            return;
        }
        m.j((Application) context.getApplicationContext());
        e.g(context);
        HisavanaContentProvider.h();
        c(aVar);
    }

    public static boolean l() {
        a aVar = a;
        if (aVar != null) {
            return a.c(aVar);
        }
        return false;
    }

    public static boolean m() {
        a aVar = a;
        if (aVar != null) {
            return a.a(aVar);
        }
        return false;
    }

    public static boolean n() {
        return c;
    }

    public static void o(Context context, String str, boolean z) {
        b = str;
        e.g(context);
        HisavanaContentProvider.h();
        DeviceUtil.e();
        AthenaTracker.o(z, e.a());
        NetStateManager.registerMonitorBroadcast();
        n7.c.e();
    }

    public static void p(int i) {
        if (i < 1 || i > 100) {
            return;
        }
        f = i;
    }

    public static void q(boolean z) {
        c = z;
    }

    public static boolean r() {
        a aVar = a;
        if (aVar != null) {
            return a.d(aVar);
        }
        return false;
    }
}
