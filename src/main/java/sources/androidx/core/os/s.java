package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static long f7031a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f7032b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f7033c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f7034d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f7035e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f7031a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f7032b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f7033c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f7034d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f7035e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
