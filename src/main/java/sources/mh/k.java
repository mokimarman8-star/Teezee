package mh;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.transsion.ga.AthenaAnalytics;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class k {
    public static final k a = new k();
    private static boolean b;
    private static boolean c;
    private static boolean d;
    private static boolean e;
    private static long f;

    public static final class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Intrinsics.h(network, "network");
            super.onAvailable(network);
            o.a.h("NetworkMonitor", new Object[]{"onAvailable : " + network});
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z) {
            Intrinsics.h(network, "network");
            super.onBlockedStatusChanged(network, z);
            o.a.h("NetworkMonitor", new Object[]{"onBlockedStatusChanged"});
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            super.onCapabilitiesChanged(network, networkCapabilities);
            boolean hasCapability = networkCapabilities.hasCapability(16);
            k kVar = k.a;
            kVar.k(networkCapabilities.hasCapability(12));
            kVar.i(kVar.g() && !hasCapability);
            kVar.j(true);
            o.a.h("NetworkMonitor", new Object[]{"isNetworkConnected : " + kVar.g() + ",  isFakeNetwork : " + kVar.e()});
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            Intrinsics.h(network, "network");
            super.onLosing(network, i);
            o.a.h("NetworkMonitor", new Object[]{"onLosing"});
            k.a.k(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.h(network, "network");
            super.onLost(network);
            o.a.h("NetworkMonitor", new Object[]{"onLost"});
            k.a.k(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            o.a.h("NetworkMonitor", new Object[]{"onUnavailable"});
        }
    }

    private k() {
    }

    public static final void c(Application application, boolean z) {
        Intrinsics.h(application, "application");
        d(application, new String[0], z);
    }

    public static final void d(Application application, String[] strArr, boolean z) {
        Intrinsics.h(application, "application");
        Intrinsics.h(strArr, "hosts");
        b = z;
        AthenaAnalytics.Q(application, "NetworkMonitor", 1814, z, false);
        d.a.e(strArr);
        k kVar = a;
        kVar.h(application);
        f = SystemClock.uptimeMillis();
        kVar.l();
    }

    private final void h(Context context) {
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new a());
    }

    private final void l() {
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: mh.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.m();
                }
            }, 5000L);
        } catch (Exception e2) {
            o.a.j("NetworkMonitor", new Object[]{Log.getStackTraceString(e2)});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        String str = c ? "0" : "1";
        if (d) {
            str = "2";
        }
        new hi.a("monitor_init", 1814).c(androidx.core.os.d.b(new Pair[]{TuplesKt.a("net_status", str)}), (Bundle) null).b();
    }

    public final long b() {
        return f;
    }

    public final boolean e() {
        return d;
    }

    public final boolean f() {
        return e;
    }

    public final boolean g() {
        return c;
    }

    public final void i(boolean z) {
        d = z;
    }

    public final void j(boolean z) {
        e = z;
    }

    public final void k(boolean z) {
        c = z;
    }
}
