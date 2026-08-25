package com.tn.lib.widget.toast.core;

import android.app.Application;
import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class h {
    public static final h a = new h();
    private static Application b;
    private static gh.b c;
    private static gh.c d;
    private static Boolean e;

    private h() {
    }

    public static /* synthetic */ void c(h hVar, Application application, gh.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            cVar = d;
        }
        hVar.b(application, cVar);
    }

    private final boolean d() {
        if (e == null) {
            Application application = b;
            Intrinsics.e(application);
            e = Boolean.valueOf((application.getApplicationInfo().flags & 2) != 0);
        }
        Boolean bool = e;
        Intrinsics.e(bool);
        return bool.booleanValue();
    }

    public final void a(CharSequence charSequence) {
        if (d()) {
            l(charSequence);
        }
    }

    public final void b(Application application, gh.c cVar) {
        b = application;
        if (c == null) {
            h(new g());
        }
        if (cVar == null) {
            cVar = new hh.a();
        }
        a.i(cVar);
    }

    public final void e(int i) {
        f(i, 0, 0);
    }

    public final void f(int i, int i2, int i3) {
        g(i, i2, i3, 0.0f, 0.0f);
    }

    public final void g(int i, int i2, int i3, float f, float f2) {
        gh.b bVar = c;
        Intrinsics.e(bVar);
        gh.c cVar = d;
        Intrinsics.e(cVar);
        bVar.b(new hh.b(cVar, i, i2, i3, f, f2));
    }

    public final void h(gh.b bVar) {
        c = bVar;
        Intrinsics.e(bVar);
        bVar.registerStrategy(b);
    }

    public final void i(gh.c cVar) {
        d = cVar;
        gh.b bVar = c;
        Intrinsics.e(bVar);
        bVar.b(cVar);
    }

    public final void j(int i) {
        if (i <= 0) {
            return;
        }
        i(new hh.c(i, d));
    }

    public final void k(int i) {
        try {
            Application application = b;
            Intrinsics.e(application);
            l(application.getResources().getText(i));
        } catch (Resources.NotFoundException unused) {
            l(String.valueOf(i));
        }
    }

    public final void l(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        gh.b bVar = c;
        Intrinsics.e(bVar);
        bVar.a(charSequence);
    }
}
