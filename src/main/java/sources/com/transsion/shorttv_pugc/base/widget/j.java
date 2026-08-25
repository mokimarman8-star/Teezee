package com.transsion.shorttv_pugc.base.widget;

import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class j {
    public static final void a(String pageName) {
        Intrinsics.h(pageName, "pageName");
        qi.h.a.z(pageName, MapsKt.f(TuplesKt.a("module_name", "no_network")));
    }

    public static final void b(String pageName) {
        Intrinsics.h(pageName, "pageName");
        qi.h.a.o(pageName, MapsKt.f(TuplesKt.a("module_name", "retry")));
    }

    public static final void c(String pageName) {
        Intrinsics.h(pageName, "pageName");
        qi.h.a.o(pageName, MapsKt.f(TuplesKt.a("module_name", "setting")));
    }
}
