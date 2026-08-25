package androidx.coroutines.impl.utils;

import android.net.ConnectivityManager;
import e2.b;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class m {
    public static final void a(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        Intrinsics.h(connectivityManager, "<this>");
        Intrinsics.h(networkCallback, "networkCallback");
        b.a(connectivityManager, networkCallback);
    }
}
