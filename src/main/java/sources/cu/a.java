package cu;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.wifi.util.g;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();
    private static Network b;

    private a() {
    }

    private final String a() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void b() {
        Object obj;
        try {
            Result$Companion result$Companion = Result.Companion;
            if (b != null) {
                b = null;
            }
            Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                connectivityManager.bindProcessToNetwork(null);
            }
            g.b(g.a, a.a() + " --> releaseDefaultNetwork() --> Success", false, 2, null);
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null) {
            return;
        }
        g.d(g.a, a.a() + " --> releaseDefaultNetwork() --> it = " + th2, false, 2, null);
    }

    public final boolean c() {
        NetworkInfo networkInfo;
        Object systemService = Utils.a().getApplicationContext().getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        int i = 0;
        boolean z = false;
        while (true) {
            i++;
            Network[] allNetworks = connectivityManager.getAllNetworks();
            Intrinsics.g(allNetworks, "getAllNetworks(...)");
            g.b(g.a, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork size = " + allNetworks.length, false, 2, null);
            int length = allNetworks.length;
            for (int i2 = 0; i2 < length; i2++) {
                Network network = allNetworks[i2];
                try {
                    networkInfo = connectivityManager.getNetworkInfo(network);
                } catch (Exception e) {
                    e.printStackTrace();
                    networkInfo = null;
                }
                g gVar = g.a;
                g.b(gVar, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork = " + networkInfo + ", network = " + network, false, 2, null);
                if (networkInfo != null && networkInfo.getType() == 1) {
                    g.b(gVar, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork2 = " + network, false, 2, null);
                    b = network;
                    connectivityManager.bindProcessToNetwork(network);
                    z = true;
                }
            }
            if (z) {
                g.b(g.a, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork OK!", false, 2, null);
                break;
            }
            g.b(g.a, a() + " --> setProcessDefaultNetwork() --> setProcessDefaultNetwork failed, start to sleep", false, 2, null);
            if (i >= 20) {
                break;
            }
        }
        return z;
    }
}
