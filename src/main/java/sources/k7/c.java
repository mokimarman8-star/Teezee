package k7;

import android.os.Build;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.h;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class c {
    private static String a = null;
    private static String b = null;
    private static int c = 0;
    private static int d = -1;
    private static String e = null;
    private static int f = -1;
    private static int g = -1;
    private static int h = -1;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static String m;
    private static int n;
    private static String o;
    private static String p;
    private static String q;
    private static final AtomicInteger r = new AtomicInteger(0);
    private static final AtomicInteger s = new AtomicInteger(0);

    public static String a() {
        if (TextUtils.isEmpty(k)) {
            k = Build.BRAND;
        }
        return k;
    }

    public static String b() {
        if (TextUtils.isEmpty(q)) {
            q = DeviceUtil.c();
        }
        return q;
    }

    public static String c() {
        if (TextUtils.isEmpty(e)) {
            e = Build.MANUFACTURER;
        }
        return e;
    }

    public static String d() {
        if (DeviceUtil.b(i, r, 1)) {
            String l2 = DeviceUtil.l();
            if (!TextUtils.isEmpty(l2) && l2.length() >= 3) {
                i = l2.substring(0, 3);
            }
        }
        return i;
    }

    public static String e() {
        if (DeviceUtil.b(j, s, 1)) {
            String l2 = DeviceUtil.l();
            if (!TextUtils.isEmpty(l2) && l2.length() >= 3) {
                j = l2.substring(3);
            }
        }
        return j;
    }

    public static String f() {
        if (TextUtils.isEmpty(l)) {
            l = Build.MODEL;
        }
        return l;
    }

    public static int g() {
        if (n == 0) {
            n = DeviceUtil.k();
        }
        return n;
    }

    public static String h() {
        if (TextUtils.isEmpty(m)) {
            m = DeviceUtil.m();
        }
        return m;
    }

    public static int i() {
        if (h == -1) {
            h = (int) h.b();
        }
        return h;
    }

    public static int j() {
        if (g == -1) {
            try {
                g = h.f();
            } catch (Throwable unused) {
            }
        }
        return g;
    }

    public static int k() {
        if (f == -1) {
            try {
                f = h.g();
            } catch (Throwable unused) {
            }
        }
        return f;
    }

    public static String l() {
        if (TextUtils.isEmpty(b)) {
            b = "3.5.9.1";
        }
        return b;
    }

    public static int m() {
        if (c == 0) {
            c = 359100;
        }
        return c;
    }

    public static String n() {
        if (TextUtils.isEmpty(a)) {
            a = DeviceUtil.o();
        }
        return a;
    }

    public static int o() {
        if (d == -1) {
            d = DeviceUtil.q() ? 2 : 1;
        }
        return d;
    }

    public static String p() {
        if (TextUtils.isEmpty(p)) {
            p = String.valueOf(com.cloud.sdk.commonutil.util.e.e());
        }
        return p;
    }

    public static String q() {
        if (TextUtils.isEmpty(o)) {
            o = String.valueOf(com.cloud.sdk.commonutil.util.e.f());
        }
        return o;
    }
}
