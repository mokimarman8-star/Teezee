package androidx.coroutines.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class k {
    public static final NetworkCapabilities a(ConnectivityManager connectivityManager, Network network) {
        Intrinsics.h(connectivityManager, "<this>");
        return connectivityManager.getNetworkCapabilities(network);
    }

    public static final boolean b(NetworkCapabilities networkCapabilities, int i5) {
        Intrinsics.h(networkCapabilities, "<this>");
        return networkCapabilities.hasCapability(i5);
    }

    public static final void c(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        Intrinsics.h(connectivityManager, "<this>");
        Intrinsics.h(networkCallback, "networkCallback");
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
