package com.cloud.sdk.commonutil.util;

import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class d {
    private static Location a = null;
    private static double b = 0.0d;
    private static double c = 0.0d;
    private static int d = 0;
    private static long e = 0;
    private static String f = "";
    private static final AtomicInteger g = new AtomicInteger(0);

    private static boolean a() {
        return b == 0.0d && c == 0.0d && g.getAndIncrement() <= 1;
    }

    public static long b() {
        h();
        return e;
    }

    public static String c() {
        h();
        return f;
    }

    public static double d() {
        h();
        return b;
    }

    private static void e() {
        try {
            if (e.a() != null) {
                LocationManager locationManager = (LocationManager) e.a().getSystemService("location");
                boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
                if (!isProviderEnabled && !isProviderEnabled2) {
                    return;
                }
                if (isProviderEnabled) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                    a = lastKnownLocation;
                    g(lastKnownLocation);
                }
                if (isProviderEnabled2 && a == null) {
                    Location lastKnownLocation2 = locationManager.getLastKnownLocation("network");
                    a = lastKnownLocation2;
                    g(lastKnownLocation2);
                }
            }
        } catch (Throwable unused) {
            c.Log().d("ssp", "Location Impossible to connect to LocationManager");
        }
        Location location = a;
        if (location != null) {
            g(location);
        }
    }

    public static double f() {
        h();
        return c;
    }

    private static void g(Location location) {
        if (location != null) {
            b = location.getLatitude();
            c = location.getLongitude();
            d = (int) location.getAccuracy();
            e = location.getTime();
            try {
                f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(e));
            } catch (Exception e2) {
                c.Log().e(Log.getStackTraceString(e2));
            }
        }
    }

    private static void h() {
        if (a()) {
            e();
        }
    }
}
