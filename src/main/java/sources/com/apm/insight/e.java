package com.apm.insight;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.g;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class e {
    private static Context a = null;
    private static Application b = null;
    private static long c = 0;
    private static String d = "default";
    private static boolean e;

    @SuppressLint({"StaticFieldLeak"})
    private static com.apm.insight.nativecrash.b f;
    private static volatile ConcurrentHashMap<Integer, String> i;
    private static volatile String n;
    private static ConfigManager g = new ConfigManager();
    private static a h = new a();
    private static g j = null;
    private static volatile String k = null;
    private static Object l = new Object();
    private static volatile int m = 0;
    private static int o = 0;
    private static boolean p = true;
    private static boolean q = true;
    private static boolean r = false;
    private static boolean s = true;
    private static boolean t = true;
    private static boolean u = true;

    public static com.apm.insight.nativecrash.b a() {
        if (f == null) {
            f = g.a(a);
        }
        return f;
    }

    public static String a(long j2, CrashType crashType, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(j2);
        sb.append("_");
        sb.append(crashType.getName());
        sb.append('_');
        sb.append(f());
        sb.append('_');
        sb.append(z ? "oom_" : "normal_");
        sb.append(c);
        sb.append('_');
        sb.append(z2 ? "ignore_" : "normal_");
        sb.append(Long.toHexString(new Random().nextLong()));
        sb.append("G");
        return sb.toString();
    }

    static void a(int i2, String str) {
        if (i == null) {
            synchronized (e.class) {
                try {
                    if (i == null) {
                        i = new ConcurrentHashMap<>();
                    }
                } finally {
                }
            }
        }
        i.put(Integer.valueOf(i2), str);
    }

    public static void a(Application application) {
        if (application != null) {
            b = application;
        }
    }

    public static void a(Application application, Context context) {
        if (b == null) {
            c = System.currentTimeMillis();
            a = context;
            b = application;
            k = Long.toHexString(new Random().nextLong()) + "G";
        }
    }

    static void a(Application application, Context context, ICommonParams iCommonParams) {
        a(application, context);
        f = new com.apm.insight.nativecrash.b(a, iCommonParams, a());
    }

    public static void a(com.apm.insight.nativecrash.b bVar) {
        f = bVar;
    }

    static void a(String str) {
        d = str;
    }

    public static void a(boolean z) {
        p = z;
    }

    public static a b() {
        return h;
    }

    static void b(int i2, String str) {
        m = i2;
        n = str;
    }

    public static void b(boolean z) {
        q = z;
    }

    public static g c() {
        if (j == null) {
            synchronized (e.class) {
                j = new g();
            }
        }
        return j;
    }

    public static void c(boolean z) {
        r = z;
    }

    public static void d(boolean z) {
        s = z;
    }

    public static boolean d() {
        if (!g.isDebugMode()) {
            return false;
        }
        Object obj = a().a().get("channel");
        return (obj == null ? "unknown" : String.valueOf(obj)).contains("local_test");
    }

    public static String e() {
        return f() + '_' + Long.toHexString(new Random().nextLong()) + "G";
    }

    public static void e(boolean z) {
        u = z;
    }

    public static String f() {
        if (k == null) {
            synchronized (l) {
                try {
                    if (k == null) {
                        k = Long.toHexString(new Random().nextLong()) + "U";
                    }
                } finally {
                }
            }
        }
        return k;
    }

    public static void f(boolean z) {
        t = z;
    }

    public static Context g() {
        return a;
    }

    public static Application h() {
        return b;
    }

    public static ConfigManager i() {
        return g;
    }

    public static long j() {
        return c;
    }

    public static String k() {
        return d;
    }

    public static void l() {
        o = 1;
    }

    public static int m() {
        return o;
    }

    public static boolean n() {
        return e;
    }

    static void o() {
        e = true;
    }

    public static ConcurrentHashMap<Integer, String> p() {
        return i;
    }

    public static int q() {
        return m;
    }

    public static String r() {
        return n;
    }

    public static boolean s() {
        return p;
    }

    public static boolean t() {
        return q;
    }

    public static boolean u() {
        return r;
    }

    public static boolean v() {
        return s;
    }

    public static boolean w() {
        return u;
    }

    public static boolean x() {
        return t;
    }
}
