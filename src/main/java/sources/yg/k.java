package yg;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.core.content.b;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.networkinfo.NetworkType;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class k extends ConnectivityManager.NetworkCallback {
    public static final a g = new a((DefaultConstructorMarker) null);
    private static final Lazy h = LazyKt.b(new Function0() { // from class: yg.c
        public final Object invoke() {
            Handler A;
            A = k.A();
            return A;
        }
    });
    private static final Lazy i = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: yg.d
        public final Object invoke() {
            k j;
            j = k.j();
            return j;
        }
    });
    private volatile Boolean b;
    private volatile Boolean c;
    private NetworkType d;
    private final CopyOnWriteArrayList a = new CopyOnWriteArrayList();
    private final Function0 e = new Function0() { // from class: yg.e
        public final Object invoke() {
            Unit z;
            z = k.z(k.this);
            return z;
        }
    };
    private final Function0 f = new Function0() { // from class: yg.f
        public final Object invoke() {
            Unit H;
            H = k.H(k.this);
            return H;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler A() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(k kVar) {
        Context applicationContext;
        try {
            Application a = Utils.a();
            Object systemService = (a == null || (applicationContext = a.getApplicationContext()) == null) ? null : applicationContext.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), kVar);
            }
        } catch (SecurityException unused) {
        }
    }

    private final void E() {
        Boolean bool = Boolean.FALSE;
        this.b = bool;
        this.c = bool;
        this.d = null;
    }

    private final void F() {
        StringBuilder sb = new StringBuilder();
        sb.append(t());
        sb.append(" --> startTimer() --> 开启定时任务");
        g.b().postDelayed(new j(this.f), 120000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(k kVar) {
        l lVar = l.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        kVar.c = Boolean.valueOf(lVar.i(a));
        StringBuilder sb = new StringBuilder();
        sb.append(kVar.t());
        sb.append(" --> timerRunnable --> isValidated = ");
        sb.append(kVar.c);
        kVar.F();
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k j() {
        return new k();
    }

    private final void m(Network network, NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.hasCapability(12)) {
            Boolean bool = this.b;
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.c(bool, bool2)) {
                return;
            }
            this.b = bool2;
            StringBuilder sb = new StringBuilder();
            sb.append(t());
            sb.append(" --> onCapabilitiesChanged --> disposeConnect --> 表示是否连接上了互联网（不关心是否可以上网");
            g.b().post(new b(this, network, networkCapabilities));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(k kVar, Network network, NetworkCapabilities networkCapabilities) {
        for (m mVar : kVar.a) {
            if (Intrinsics.c(kVar.b, Boolean.TRUE)) {
                mVar.onConnected(network, networkCapabilities);
            }
        }
    }

    private final void o(NetworkCapabilities networkCapabilities) {
        NetworkType v = networkCapabilities.hasTransport(1) ? NetworkType.NETWORK_WIFI : networkCapabilities.hasTransport(0) ? v() : NetworkType.NETWORK_UNKNOWN;
        if (this.d == v) {
            return;
        }
        this.d = v;
        StringBuilder sb = new StringBuilder();
        sb.append("当前网络类型是 mNetworkType = ");
        sb.append(this.d);
    }

    private final void p() {
        a aVar = g;
        aVar.b().removeCallbacks(new h(this.e));
        aVar.b().postDelayed(new i(this.e), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function0 function0) {
        function0.invoke();
    }

    private final void s(NetworkCapabilities networkCapabilities) {
        this.c = Boolean.valueOf(networkCapabilities.hasCapability(16));
        StringBuilder sb = new StringBuilder();
        sb.append(t());
        sb.append(" --> disposeValidated() --> isValidated = ");
        sb.append(this.c);
        sb.append(" netState = ");
        sb.append(u());
    }

    private final String t() {
        String simpleName = k.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final NetworkType v() {
        if (Build.VERSION.SDK_INT >= 24 && b.checkSelfPermission(Utils.a(), "android.permission.READ_PHONE_STATE") == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.a().getSystemService("phone");
            Integer valueOf = telephonyManager != null ? Integer.valueOf(a.a(telephonyManager)) : null;
            return ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 2) || ((valueOf != null && valueOf.intValue() == 4) || ((valueOf != null && valueOf.intValue() == 11) || (valueOf != null && valueOf.intValue() == 7)))) ? NetworkType.NETWORK_2G : ((valueOf != null && valueOf.intValue() == 5) || (valueOf != null && valueOf.intValue() == 6) || ((valueOf != null && valueOf.intValue() == 12) || ((valueOf != null && valueOf.intValue() == 8) || ((valueOf != null && valueOf.intValue() == 9) || ((valueOf != null && valueOf.intValue() == 10) || ((valueOf != null && valueOf.intValue() == 15) || (valueOf != null && valueOf.intValue() == 14))))))) ? NetworkType.NETWORK_3G : ((valueOf != null && valueOf.intValue() == 13) || (valueOf != null && valueOf.intValue() == 19)) ? NetworkType.NETWORK_4G : (valueOf != null && valueOf.intValue() == 20) ? NetworkType.NETWORK_5G : (valueOf != null && valueOf.intValue() == 0) ? NetworkType.NETWORK_UNKNOWN : NetworkType.NETWORK_UNKNOWN;
        }
        return l.a.d();
    }

    private final boolean y() {
        if (this.c != null) {
            return Intrinsics.c(this.c, Boolean.TRUE);
        }
        l lVar = l.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return lVar.i(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(k kVar) {
        l lVar = l.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        boolean j = lVar.j(a);
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        kVar.c = Boolean.valueOf(lVar.i(a2));
        int u = kVar.u();
        if (j) {
            kVar.b = Boolean.TRUE;
            StringBuilder sb = new StringBuilder();
            sb.append(kVar.t());
            sb.append(" --> onLost() --> disposeOnLost --> lostRunnable --> networkConnected = ");
            sb.append(j);
            sb.append(" netState = ");
            sb.append(u);
            sb.append(" --  网络重新连接了");
            for (m mVar : kVar.a) {
                if (Intrinsics.c(kVar.b, Boolean.TRUE)) {
                    mVar.onConnected();
                }
            }
        } else {
            kVar.E();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(kVar.t());
            sb2.append(" --> onLost() --> disposeOnLost --> lostRunnable --> networkConnected = ");
            sb2.append(j);
            sb2.append(" netState = ");
            sb2.append(u);
            sb2.append(" -- 网络断开了");
            for (m mVar2 : kVar.a) {
                if (Intrinsics.c(kVar.b, Boolean.FALSE)) {
                    mVar2.onDisconnected();
                }
            }
        }
        return Unit.a;
    }

    public final void B() {
        Context applicationContext;
        try {
            Application a = Utils.a();
            Object systemService = (a == null || (applicationContext = a.getApplicationContext()) == null) ? null : applicationContext.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this);
            }
        } catch (SecurityException unused) {
            g.b().postDelayed(new g(this), 500L);
        }
        F();
    }

    public final void D(m mVar) {
        if (mVar == null || this.a.contains(mVar)) {
            return;
        }
        this.a.add(mVar);
    }

    public final void I(m mVar) {
        if (mVar != null) {
            this.a.remove(mVar);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        Intrinsics.h(network, "network");
        super.onAvailable(network);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onBlockedStatusChanged(Network network, boolean z) {
        Intrinsics.h(network, "network");
        super.onBlockedStatusChanged(network, z);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Object m34constructorimpl;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        try {
            Result.Companion companion = Result.Companion;
            m(network, networkCapabilities);
            s(networkCapabilities);
            o(networkCapabilities);
            m34constructorimpl = Result.m34constructorimpl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m34constructorimpl = Result.m34constructorimpl(ResultKt.a(th));
        }
        Throwable m37exceptionOrNullimpl = Result.m37exceptionOrNullimpl(m34constructorimpl);
        if (m37exceptionOrNullimpl == null) {
            return;
        }
        Log.e("net_log", t() + " --> it = " + m37exceptionOrNullimpl);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        Intrinsics.h(network, "network");
        Intrinsics.h(linkProperties, "linkProperties");
        super.onLinkPropertiesChanged(network, linkProperties);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLosing(Network network, int i2) {
        Intrinsics.h(network, "network");
        super.onLosing(network, i2);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.h(network, "network");
        super.onLost(network);
        p();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        super.onUnavailable();
    }

    public final int u() {
        if (x() && y()) {
            return 2;
        }
        if (x()) {
            return 1;
        }
        return !x() ? 0 : 3;
    }

    public final NetworkType w() {
        NetworkType networkType = this.d;
        if (networkType != null) {
            return networkType;
        }
        l lVar = l.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        if (lVar.k(a)) {
            NetworkType networkType2 = NetworkType.NETWORK_WIFI;
            this.d = networkType2;
            return networkType2;
        }
        NetworkType v = v();
        this.d = v;
        return v;
    }

    public final boolean x() {
        if (this.b == null) {
            l lVar = l.a;
            Application a = Utils.a();
            Intrinsics.g(a, "getApp(...)");
            return lVar.j(a);
        }
        if (!Intrinsics.c(this.b, Boolean.FALSE)) {
            return Intrinsics.c(this.b, Boolean.TRUE);
        }
        l lVar2 = l.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return lVar2.j(a2);
    }
}
