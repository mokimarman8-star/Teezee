package yg;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.blankj.utilcode.util.Utils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tn.lib.util.networkinfo.NetworkType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class l {
    public static final l a = new l();

    private l() {
    }

    private final NetworkInfo a() {
        Object systemService = Utils.a().getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    private final boolean g() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        Object systemService = Utils.a().getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

    public final int b() {
        return k.g.a().u();
    }

    public final NetworkType c() {
        return k.g.a().w();
    }

    public final NetworkType d() {
        if (g()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo a2 = a();
        if (a2 == null) {
            return NetworkType.NETWORK_NO;
        }
        int type = a2.getType();
        if (type != 0) {
            return type != 1 ? NetworkType.NETWORK_UNKNOWN : NetworkType.NETWORK_WIFI;
        }
        switch (a2.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case TTAdConstant.IMAGE_MODE_VIDEO_VERTICAL /* 15 */:
            case 17:
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            case TTAdConstant.CONVERSION_LINK_LANDING_DIRECT_AND_ENDCARD /* 19 */:
            default:
                String subtypeName = a2.getSubtypeName();
                return (StringsKt.H(subtypeName, "TD-SCDMA", true) || StringsKt.H(subtypeName, "WCDMA", true) || StringsKt.H(subtypeName, "CDMA2000", true)) ? NetworkType.NETWORK_3G : NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    public final boolean e() {
        return k.g.a().x();
    }

    public final void f() {
        k.g.a().B();
    }

    public final boolean h(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        return (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || !networkCapabilities.hasTransport(0)) ? false : true;
    }

    public final boolean i(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        return (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || !networkCapabilities.hasCapability(16)) ? false : true;
    }

    public final boolean j(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) ? false : true;
    }

    public final boolean k(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        return (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || !networkCapabilities.hasTransport(1)) ? false : true;
    }

    public final void l(m mVar) {
        k.g.a().D(mVar);
    }

    public final void m(m mVar) {
        k.g.a().I(mVar);
    }
}
