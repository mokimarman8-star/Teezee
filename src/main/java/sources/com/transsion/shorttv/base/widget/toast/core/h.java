package com.transsion.shorttv.base.widget.toast.core;

import android.app.Application;
import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    public static final h a = new h();
    private static Application b;
    private static kr.b c;
    private static kr.c d;

    private h() {
    }

    public static /* synthetic */ void b(h hVar, Application application, kr.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            cVar = d;
        }
        hVar.a(application, cVar);
    }

    public final void a(Application application, kr.c cVar) {
        b = application;
        if (c == null) {
            e(new g());
        }
        if (cVar == null) {
            cVar = new lr.a();
        }
        a.f(cVar);
    }

    public final void c(int i, int i2, int i3) {
        d(i, i2, i3, 0.0f, 0.0f);
    }

    public final void d(int i, int i2, int i3, float f, float f2) {
        kr.b bVar = c;
        Intrinsics.e(bVar);
        kr.c cVar = d;
        Intrinsics.e(cVar);
        bVar.b(new lr.b(cVar, i, i2, i3, f, f2));
    }

    public final void e(kr.b bVar) {
        c = bVar;
        Intrinsics.e(bVar);
        bVar.registerStrategy(b);
    }

    public final void f(kr.c cVar) {
        d = cVar;
        kr.b bVar = c;
        Intrinsics.e(bVar);
        bVar.b(cVar);
    }

    public final void g(int i) {
        if (i <= 0) {
            return;
        }
        f(new lr.c(i, d));
    }

    public final void h(int i) {
        try {
            Application application = b;
            Intrinsics.e(application);
            i(application.getResources().getText(i));
        } catch (Resources.NotFoundException unused) {
            i(String.valueOf(i));
        }
    }

    public final void i(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        kr.b bVar = c;
        Intrinsics.e(bVar);
        bVar.a(charSequence);
    }
}
