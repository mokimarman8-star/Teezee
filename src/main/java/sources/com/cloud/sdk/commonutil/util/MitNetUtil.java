package com.cloud.sdk.commonutil.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.transsion.baselib.report.recent_event.ActionEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class MitNetUtil {

    public enum NetworkType {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G,
        NETWORK_5G,
        NETWORK_ETHERNET
    }

    public static NetworkType a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        NetworkInfo.State state2;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) != null) {
            try {
                networkInfo = connectivityManager.getNetworkInfo(1);
            } catch (Exception e) {
                c.Log().e("MitNetUtil", Log.getStackTraceString(e));
            }
            if (networkInfo == null || ((state2 = networkInfo.getState()) != NetworkInfo.State.CONNECTED && state2 != NetworkInfo.State.CONNECTING)) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(9);
                if (networkInfo2 != null && ((state = networkInfo2.getState()) == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                    return NetworkType.NETWORK_ETHERNET;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    if (activeNetworkInfo.getType() != 0) {
                        return NetworkType.NETWORK_UNKNOWN;
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case ActionEvent.delete_comment /* 14 */:
                        case ActionEvent.pageview /* 15 */:
                        case ActionEvent.want_to_see_cancel /* 17 */:
                            break;
                        case 13:
                        case 18:
                            break;
                        case ActionEvent.search_cover_expose /* 19 */:
                        default:
                            String subtypeName = activeNetworkInfo.getSubtypeName();
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                                break;
                            }
                            break;
                        case ActionEvent.search_cover_click /* 20 */:
                            break;
                    }
                    return NetworkType.NETWORK_UNKNOWN;
                }
                return NetworkType.NETWORK_UNKNOWN;
            }
            return NetworkType.NETWORK_WIFI;
        }
        return NetworkType.NETWORK_UNKNOWN;
    }

    public static String b() {
        return e.a().getApplicationContext() != null ? ((TelephonyManager) e.a().getApplicationContext().getSystemService("phone")).getSimOperatorName() : "";
    }

    public static boolean c(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(4)) {
                    if (!networkCapabilities.hasTransport(3)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e) {
            c.Log().e("MitNetUtil", Log.getStackTraceString(e));
        }
        return false;
    }
}
