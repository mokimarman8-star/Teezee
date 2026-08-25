package com.transsion.transfer.wifi.util;

import android.net.wifi.WifiManager;
import android.os.PowerManager;
import com.blankj.utilcode.util.Utils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    public static final f a = new f();
    private static WifiManager.WifiLock b;
    private static PowerManager.WakeLock c;

    private f() {
    }

    private final String b() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void a() {
        PowerManager.WakeLock wakeLock;
        WifiManager.WifiLock wifiLock;
        try {
            if (b == null) {
                Object systemService = Utils.a().getApplicationContext().getSystemService("wifi");
                Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                b = ((WifiManager) systemService).createWifiLock(3, "MB:Wifi-Connect");
            }
            if (c == null) {
                Object systemService2 = Utils.a().getSystemService("power");
                Intrinsics.f(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
                c = ((PowerManager) systemService2).newWakeLock(1, "MB:Wifi-Connect");
            }
            WifiManager.WifiLock wifiLock2 = b;
            if (wifiLock2 != null && !wifiLock2.isHeld() && (wifiLock = b) != null) {
                wifiLock.acquire();
            }
            PowerManager.WakeLock wakeLock2 = c;
            if (wakeLock2 == null || wakeLock2.isHeld() || (wakeLock = c) == null) {
                return;
            }
            wakeLock.acquire(600000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void c() {
        WifiManager.WifiLock wifiLock = b;
        if (wifiLock != null && wifiLock.isHeld()) {
            WifiManager.WifiLock wifiLock2 = b;
            if (wifiLock2 != null) {
                wifiLock2.release();
            }
            b = null;
            g.b(g.a, b() + " --> release() --> mWifiLock?.release() --> success", false, 2, null);
        }
        PowerManager.WakeLock wakeLock = c;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        PowerManager.WakeLock wakeLock2 = c;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
        c = null;
        g.b(g.a, b() + " --> release() --> mWakeLock?.release() --> success", false, 2, null);
    }
}
