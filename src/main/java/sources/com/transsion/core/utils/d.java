package com.transsion.core.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.transsion.baselib.db.download.DownloadBean;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class d {
    public static boolean a() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (yj.a.a().getApplicationContext() == null || (connectivityManager = (ConnectivityManager) yj.a.a().getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isAvailable();
    }

    private static int b(int i) {
        int i2 = -101;
        if (i != -101) {
            i2 = -1;
            if (i != -1) {
                switch (i) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case DownloadBean.STATUS_TITLE /* 11 */:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case DownloadBean.STATUS_SERIES /* 10 */:
                    case 12:
                    case DownloadBean.STATUS_ALL_EP_BTN /* 14 */:
                    case 15:
                        return 2;
                    case 13:
                        return 3;
                    default:
                        return 0;
                }
            }
        }
        return i2;
    }

    public static int c() {
        int i = 0;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (yj.a.a().getApplicationContext() == null && yj.a.a().getApplicationContext().getSystemService("connectivity") == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) yj.a.a().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                i = -101;
            } else if (type == 0) {
                i = ((TelephonyManager) yj.a.a().getApplicationContext().getSystemService("phone")).getNetworkType();
            }
        } else {
            i = -1;
        }
        return b(i);
    }
}
