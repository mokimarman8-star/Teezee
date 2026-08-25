package e4;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f15181a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f15182b;

    public static void a(String str) {
        b.a(f(str));
    }

    public static void b() {
        b.b();
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 29 ? c.a() : e();
    }

    private static boolean e() {
        try {
            if (f15182b == null) {
                f15181a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f15182b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f15182b.invoke(null, Long.valueOf(f15181a))).booleanValue();
        } catch (Exception e5) {
            c("isTagEnabled", e5);
            return false;
        }
    }

    private static String f(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }
}
