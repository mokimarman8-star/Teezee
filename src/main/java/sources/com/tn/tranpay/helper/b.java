package com.tn.tranpay.helper;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.tn.tranpay.TranPay;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final boolean a() {
        try {
            Object systemService = TranPay.a.d().getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            boolean z = false;
            if (connectivityManager == null) {
                lh.a.k(lh.a.a, "无法获取 ConnectivityManager", null, 2, null);
                return false;
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                lh.a.k(lh.a.a, "网络不可用: activeNetwork 为 null", null, 2, null);
                return false;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                lh.a.k(lh.a.a, "网络不可用: NetworkCapabilities 为 null", null, 2, null);
                return false;
            }
            if (networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16)) {
                z = true;
            }
            if (!z) {
                lh.a.k(lh.a.a, "网络不可用: 无Internet连接或未验证", null, 2, null);
            }
            return z;
        } catch (Exception e) {
            lh.a.e(lh.a.a, "检查网络状态失败: " + e.getMessage(), null, 2, null);
            return true;
        }
    }
}
