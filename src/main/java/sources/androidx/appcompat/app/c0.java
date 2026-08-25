package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Calendar;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class c0 {

    /* renamed from: d, reason: collision with root package name */
    private static c0 f272d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f273a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f274b;

    /* renamed from: c, reason: collision with root package name */
    private final a f275c = new a();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f276a;

        /* renamed from: b, reason: collision with root package name */
        long f277b;

        a() {
        }
    }

    c0(Context context, LocationManager locationManager) {
        this.f273a = context;
        this.f274b = locationManager;
    }

    static c0 a(Context context) {
        if (f272d == null) {
            Context applicationContext = context.getApplicationContext();
            f272d = new c0(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f272d;
    }

    private Location b() {
        Location c5 = androidx.core.content.f.b(this.f273a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location c6 = androidx.core.content.f.b(this.f273a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (c6 == null || c5 == null) ? c6 != null ? c6 : c5 : c6.getTime() > c5.getTime() ? c6 : c5;
    }

    private Location c(String str) {
        try {
            if (this.f274b.isProviderEnabled(str)) {
                return this.f274b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean e() {
        return this.f275c.f277b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j5;
        a aVar = this.f275c;
        long currentTimeMillis = System.currentTimeMillis();
        b0 b5 = b0.b();
        b5.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        b5.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z5 = b5.f268c == 1;
        long j6 = b5.f267b;
        long j7 = b5.f266a;
        b5.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j8 = b5.f267b;
        if (j6 == -1 || j7 == -1) {
            j5 = currentTimeMillis + 43200000;
        } else {
            if (currentTimeMillis <= j7) {
                j8 = currentTimeMillis > j6 ? j7 : j6;
            }
            j5 = j8 + 60000;
        }
        aVar.f276a = z5;
        aVar.f277b = j5;
    }

    boolean d() {
        a aVar = this.f275c;
        if (e()) {
            return aVar.f276a;
        }
        Location b5 = b();
        if (b5 != null) {
            f(b5);
            return aVar.f276a;
        }
        int i5 = Calendar.getInstance().get(11);
        return i5 < 6 || i5 >= 22;
    }
}
