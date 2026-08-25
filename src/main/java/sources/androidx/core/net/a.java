package androidx.core.net;

import android.net.ConnectivityManager;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {
    public static boolean a(ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
