package androidx.coroutines.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class l {
    public static final Network a(ConnectivityManager connectivityManager) {
        Intrinsics.h(connectivityManager, "<this>");
        return connectivityManager.getActiveNetwork();
    }
}
