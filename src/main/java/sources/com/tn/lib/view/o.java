package com.tn.lib.view;

import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class o {
    public static final void a(String str) {
        Intrinsics.h(str, "pageName");
        qi.h.a.z(str, MapsKt.f(TuplesKt.a("module_name", "no_network")));
    }

    public static final void b(String str) {
        Intrinsics.h(str, "pageName");
        qi.h.a.o(str, MapsKt.f(TuplesKt.a("module_name", "retry")));
    }

    public static final void c(String str) {
        Intrinsics.h(str, "pageName");
        qi.h.a.o(str, MapsKt.f(TuplesKt.a("module_name", "setting")));
    }
}
