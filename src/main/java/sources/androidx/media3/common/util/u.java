package androidx.media3.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class u {

    /* renamed from: b, reason: collision with root package name */
    private static int f9137b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f9138c = true;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f9136a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static a f9139d = a.f9140a;

    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f9140a = new C0071a();

        /* renamed from: androidx.media3.common.util.u$a$a, reason: collision with other inner class name */
        class C0071a implements a {
            C0071a() {
            }

            @Override // androidx.media3.common.util.u.a
            public void a(String str, String str2, Throwable th) {
                u.a(str2, th);
            }

            @Override // androidx.media3.common.util.u.a
            public void b(String str, String str2, Throwable th) {
                u.a(str2, th);
            }

            @Override // androidx.media3.common.util.u.a
            public void e(String str, String str2, Throwable th) {
                Log.e(str, u.a(str2, th));
            }

            @Override // androidx.media3.common.util.u.a
            public void w(String str, String str2, Throwable th) {
                Log.w(str, u.a(str2, th));
            }
        }

        void a(String str, String str2, Throwable th);

        void b(String str, String str2, Throwable th);

        void e(String str, String str2, Throwable th);

        void w(String str, String str2, Throwable th);
    }

    public static String a(String str, Throwable th) {
        String e5 = e(th);
        if (TextUtils.isEmpty(e5)) {
            return str;
        }
        return str + "\n  " + e5.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str, String str2) {
        synchronized (f9136a) {
            try {
                if (f9137b == 0) {
                    f9139d.a(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(String str, String str2) {
        synchronized (f9136a) {
            try {
                if (f9137b <= 3) {
                    f9139d.e(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void d(String str, String str2, Throwable th) {
        synchronized (f9136a) {
            try {
                if (f9137b <= 3) {
                    f9139d.e(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String e(Throwable th) {
        if (th == null) {
            return null;
        }
        synchronized (f9136a) {
            try {
                if (g(th)) {
                    return "UnknownHostException (no network)";
                }
                if (f9138c) {
                    return Log.getStackTraceString(th).trim().replace("\t", "    ");
                }
                return th.getMessage();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void f(String str, String str2) {
        synchronized (f9136a) {
            try {
                if (f9137b <= 1) {
                    f9139d.b(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean g(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void h(String str, String str2) {
        synchronized (f9136a) {
            try {
                if (f9137b <= 2) {
                    f9139d.w(str, str2, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void i(String str, String str2, Throwable th) {
        synchronized (f9136a) {
            try {
                if (f9137b <= 2) {
                    f9139d.w(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
