package com.cloud.sdk.commonutil.util;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.hisavana.common.constant.ComConstants;
import com.transsion.sdk.oneid.OneID;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import l7.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class DeviceUtil {
    private static String a = "";
    private static String b;
    private static String d;
    private static final AtomicInteger c = new AtomicInteger(0);
    private static String e = "";
    private static int f = 0;
    private static long g = 0;

    public static boolean b(String str, AtomicInteger atomicInteger, int i) {
        return TextUtils.isEmpty(str) && atomicInteger.getAndIncrement() < i;
    }

    public static String c() {
        String[] strArr = Build.SUPPORTED_ABIS;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i < strArr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String d() {
        try {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            String simCountryIso = ((TelephonyManager) e.a().getSystemService("phone")).getSimCountryIso();
            if (TextUtils.isEmpty(simCountryIso)) {
                return "";
            }
            String upperCase = simCountryIso.toUpperCase();
            b = upperCase;
            return upperCase;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        if (TextUtils.isEmpty(e)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - g < 10000) {
                return e;
            }
            g = currentTimeMillis;
            e = a.e().j("device_util_ga_id");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                HSScopeHelper.a.i(new 1());
            } else {
                s();
            }
        }
        return e;
    }

    public static int f() {
        if (f == 0) {
            f = a.e().g("is_limit_ad_tracking_enabled", 0);
        }
        return f;
    }

    public static String g() {
        int cid;
        int lac;
        if (!b(a, c, 1)) {
            return a;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) e.a().getSystemService("phone");
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation == null) {
                return "";
            }
            if (telephonyManager.getPhoneType() == 2) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                cid = cdmaCellLocation.getBaseStationId();
                lac = cdmaCellLocation.getNetworkId();
            } else {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                cid = gsmCellLocation.getCid();
                lac = gsmCellLocation.getLac();
            }
            String str = cid + "|" + lac;
            a = str;
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) e.a().getApplicationContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo.isConnected()) {
                d = i();
            } else if (networkInfo2.isConnected()) {
                d = p(((WifiManager) e.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
            }
        } catch (Exception e3) {
            c.Log().d(ComConstants.PLATFORM_SSP, "获取本地ip地址失败 " + e3.getMessage());
        }
        return d;
    }

    private static String i() {
        String str = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && r(nextElement.getHostAddress())) {
                        str = nextElement.getHostAddress();
                    }
                }
            }
        } catch (SocketException e3) {
            c.Log().d(ComConstants.PLATFORM_SSP, "获取本地ip地址失败 " + e3.getMessage());
        }
        return str;
    }

    public static String j() {
        try {
            return OneID.e().a(2411);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int k() {
        return Build.VERSION.SDK_INT;
    }

    public static String l() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) e.a().getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m() {
        return Build.VERSION.RELEASE.replace(";", "");
    }

    public static long n() {
        try {
            ActivityManager activityManager = (ActivityManager) e.a().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        } catch (Exception e3) {
            c.Log().d(ComConstants.PLATFORM_SSP, "获取本地运行内存失败 " + e3.getMessage());
            return 0L;
        }
    }

    public static String o() {
        return UUID.randomUUID().toString();
    }

    public static String p(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static boolean q() {
        try {
            Context a2 = e.a();
            if (a2.getResources() != null) {
                return (a2.getResources().getConfiguration().screenLayout & 15) >= 3;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean r(String str) {
        try {
            return InetAddress.getByName(str) != null;
        } catch (UnknownHostException e3) {
            c.Log().d(ComConstants.PLATFORM_SSP, "获取本地ip地址失败 " + e3.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s() {
        try {
            a.a a2 = a.a(e.a());
            if (a2 == null || a2.a().equals(e)) {
                return;
            }
            e = a2.a();
            boolean b2 = a2.b();
            a.e().r("device_util_ga_id", e);
            a.e().p("is_limit_ad_tracking_enabled", b2 ? 1 : 2);
            c.Log().i(ComConstants.PLATFORM_SSP, "gaid limit ：" + b2 + " GAID is ：" + e);
        } catch (Exception e3) {
            c.Log().e("DeviceUtil", Log.getStackTraceString(e3));
        }
    }
}
