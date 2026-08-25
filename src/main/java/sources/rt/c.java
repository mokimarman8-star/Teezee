package rt;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final c a = new c();
    private static boolean b;
    private static boolean c;
    private static Function0 d;
    private static Function0 e;

    private c() {
    }

    public final boolean a() {
        return e != null;
    }

    public final boolean b() {
        return d != null;
    }

    public final boolean c() {
        return c;
    }

    public final boolean d() {
        return b;
    }

    public final void e() {
        c = false;
        Function0 function0 = e;
        if (function0 != null) {
            function0.invoke();
        }
        e = null;
    }

    public final void f() {
        b = false;
        Function0 function0 = d;
        if (function0 != null) {
            function0.invoke();
        }
        d = null;
    }

    public final void g(Function0 callback) {
        Intrinsics.h(callback, "callback");
        e = callback;
    }

    public final void h(Function0 callback) {
        Intrinsics.h(callback, "callback");
        d = callback;
    }

    public final void i() {
        c = true;
    }

    public final void j() {
        b = true;
    }
}
