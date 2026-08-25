package com.pgl.ssdk;

import android.os.Handler;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class o0 {
    public static Handler a() {
        return x0.a().b();
    }

    public static void a(Runnable runnable) {
        Handler a;
        if (runnable == null || (a = a()) == null) {
            return;
        }
        a.post(runnable);
    }

    public static Handler b() {
        return x0.a().c();
    }

    public static void b(Runnable runnable) {
        Handler b;
        if (runnable == null || (b = b()) == null) {
            return;
        }
        b.post(runnable);
    }
}
