package com.transsion.athena.taaneh;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.b;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.gslb.BuildConfig;
import com.transsion.publish.view.ObservableScrollView;
import yg.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class aatnhe {
    private static int a = -1;
    private static aethna b;

    @TargetApi(21)
    private static class aethna extends ConnectivityManager.NetworkCallback {
        private aethna() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            aatnhe.a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            aatnhe.a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            aatnhe.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[RETURN] */
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(Context context) {
        int i;
        String str;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            if (Build.VERSION.SDK_INT < 30) {
                i = telephonyManager.getNetworkType();
            } else if (b.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0 || telephonyManager.hasCarrierPrivileges()) {
                i = a.a(telephonyManager);
            }
            if (i == 0 || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                str = BuildConfig.FLAVOR;
            } else {
                i = activeNetworkInfo.getSubtype();
                str = activeNetworkInfo.getSubtypeName();
            }
            switch (i) {
                case 1:
                case 2:
                case 4:
                case 7:
                case DownloadBean.STATUS_TITLE /* 11 */:
                case ObservableScrollView.SCROLL_DOWN /* 16 */:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case DownloadBean.STATUS_SERIES /* 10 */:
                case 12:
                case DownloadBean.STATUS_ALL_EP_BTN /* 14 */:
                case 15:
                case 17:
                    return 3;
                case 13:
                case 18:
                case 19:
                    return 4;
                case 20:
                    return 5;
                default:
                    if (TextUtils.isEmpty(str)) {
                        return 99;
                    }
                    return (str.equalsIgnoreCase("TD-SCDMA") || str.equalsIgnoreCase("WCDMA") || str.equalsIgnoreCase("CDMA2000")) ? 3 : 0;
            }
        }
        i = 0;
        if (i == 0) {
        }
        str = BuildConfig.FLAVOR;
        switch (i) {
        }
    }

    public static void a() {
        a = -1;
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(3);
    }

    public static int b(Context context) {
        NetworkCapabilities networkCapabilities;
        int i = a;
        if (i != -1 && i != 0 && i != 99) {
            return i;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!b(connectivityManager)) {
                a = 99;
                return 99;
            }
            if (c(connectivityManager)) {
                a = 1;
            } else if (a(connectivityManager)) {
                a = 6;
            } else {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                boolean z = false;
                if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                    z = networkCapabilities.hasTransport(0);
                }
                if (z) {
                    a = a(context);
                } else {
                    a = 100;
                }
            }
            return a;
        } catch (Exception unused) {
            return 99;
        }
    }

    private static boolean b(ConnectivityManager connectivityManager) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
    }

    public static boolean c(Context context) {
        try {
            return b((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            return false;
        }
    }

    private static boolean c(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }

    public static boolean d(Context context) {
        try {
            if (!c(context)) {
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!c(connectivityManager)) {
                if (!a(connectivityManager)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void e(Context context) {
        try {
            if (b == null) {
                b = new aethna();
            }
            NetworkRequest build = new NetworkRequest.Builder().build();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(build, b);
            }
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
        }
    }
}
