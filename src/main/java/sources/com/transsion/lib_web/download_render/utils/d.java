package com.transsion.lib_web.download_render.utils;

import pl.h;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();
    private static boolean b;

    private d() {
    }

    public final boolean a() {
        return b;
    }

    public final void b() {
        h.a.a("DR_", "net connected");
        b = true;
    }

    public final void c() {
        h.a.a("DR_", "net disConnected");
        b = false;
    }

    public final void d() {
        b = l.a.b() == 2;
    }
}
