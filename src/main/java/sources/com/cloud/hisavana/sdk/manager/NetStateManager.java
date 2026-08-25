package com.cloud.hisavana.sdk.manager;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.util.Log;
import com.cloud.hisavana.sdk.Y;
import com.cloud.hisavana.sdk.b4;
import com.cloud.hisavana.sdk.g1;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import com.cloud.sdk.commonutil.util.e;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class NetStateManager {
    private static final int PROTECTION_TIME = 10000;
    private static final String TAG = "NetStateManager";
    private static AtomicBoolean isNetAvailable = new AtomicBoolean(false);
    private static AtomicBoolean isInitSuccessful = new AtomicBoolean(false);
    private static long lastRequestTime = 0;
    private static boolean isInit = false;

    class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(true);
            b4.b().d(NetStateManager.TAG, "onAvailable isNetAvailable " + NetStateManager.isNetAvailable);
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - NetStateManager.lastRequestTime) > 10000) {
                long unused = NetStateManager.lastRequestTime = currentTimeMillis;
                g1.o().n(2);
                g.d.a().i();
                Y.a.D();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z) {
            super.onBlockedStatusChanged(network, z);
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(!z);
            b4.b().d(NetStateManager.TAG, "onBlockedStatusChanged isNetAvailable " + NetStateManager.isNetAvailable);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            super.onLosing(network, i);
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(false);
            b4.b().d(NetStateManager.TAG, "onLosing isNetAvailable " + NetStateManager.isNetAvailable);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(false);
            NetStateManager.updateNetStatus(1000);
            b4.b().d(NetStateManager.TAG, "onLost isNetAvailable " + NetStateManager.isNetAvailable);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            NetStateManager.isInitSuccessful.set(true);
            NetStateManager.isNetAvailable.set(false);
            b4.b().d(NetStateManager.TAG, "onUnavailable isNetAvailable " + NetStateManager.isNetAvailable);
        }
    }

    public static boolean checkNetworkState(boolean z) {
        if (Build.VERSION.SDK_INT < 24) {
            return MitNetUtil.c(e.a());
        }
        b4.b().d(TAG, "checkNetworkState " + isNetAvailable + ", isInitSuccessful " + isInitSuccessful + ", isSync=" + z);
        if (!z) {
            return isNetAvailable.get();
        }
        boolean c = MitNetUtil.c(e.a());
        isNetAvailable.set(c);
        return c;
    }

    public static void registerMonitorBroadcast() {
        if (isInit) {
            return;
        }
        isInit = true;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                ((ConnectivityManager) e.a().getSystemService("connectivity")).registerDefaultNetworkCallback(new a());
            } catch (Exception e) {
                b4.b().e(TAG, "registerMonitorBroadcast " + Log.getStackTraceString(e));
            }
        }
        updateNetStatus(0);
    }

    public static void setIsNetAvailable(boolean z) {
        isNetAvailable.set(z);
    }

    public static void updateNetStatus(int i) {
        HSScopeHelper.a.j(new b(), i);
    }
}
