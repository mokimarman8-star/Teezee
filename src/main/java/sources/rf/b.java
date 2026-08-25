package rf;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    public static final b a = new b();
    private static String b;
    private static String c;
    private static int d;
    private static boolean e;

    private b() {
    }

    private final String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("================");
        stringBuffer.append(c);
        stringBuffer.append("(");
        stringBuffer.append(b);
        stringBuffer.append(":");
        stringBuffer.append(d);
        stringBuffer.append(")================:");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private final void f(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement stackTraceElement;
        StackTraceElement stackTraceElement2;
        b = (stackTraceElementArr == null || (stackTraceElement = stackTraceElementArr[1]) == null) ? null : stackTraceElement.getFileName();
        c = (stackTraceElementArr == null || (stackTraceElement2 = stackTraceElementArr[1]) == null) ? null : stackTraceElement2.getMethodName();
        StackTraceElement stackTraceElement3 = stackTraceElementArr != null ? stackTraceElementArr[1] : null;
        Intrinsics.e(stackTraceElement3);
        d = stackTraceElement3.getLineNumber();
    }

    public final void b(String str) {
        if (e) {
            f(new Throwable().getStackTrace());
            Intrinsics.e(a(str));
        }
    }

    public final void c(String str) {
        f(new Throwable().getStackTrace());
        String str2 = b;
        String a2 = a(str);
        Intrinsics.e(a2);
        Log.e(str2, a2);
    }

    public final void d(String str, String str2) {
        Intrinsics.h(str, "tag");
        Log.e(str, String.valueOf(str2));
    }

    public final void e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        if (th != null) {
            try {
                th.printStackTrace(printWriter);
                Unit unit = Unit.a;
            } finally {
            }
        }
        CloseableKt.a(printWriter, (Throwable) null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.g(stringWriter2, "sw.toString()");
        c(stringWriter2);
    }

    public final void g(String str) {
        if (e) {
            f(new Throwable().getStackTrace());
            Intrinsics.e(a(str));
        }
    }

    public final void h(boolean z) {
        e = z;
    }

    public final void i(String str) {
        if (e) {
            f(new Throwable().getStackTrace());
            String str2 = b;
            String a2 = a(str);
            Intrinsics.e(a2);
            Log.w(str2, a2);
        }
    }
}
