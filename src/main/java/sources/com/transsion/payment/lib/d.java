package com.transsion.payment.lib;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    public final void a(String str) {
        Intrinsics.h(str, "msg");
        wf.a.a.c("co_pay", str, true);
    }

    public final void b(String str) {
        Intrinsics.h(str, "msg");
        wf.a.a.i("co_pay", str, true);
    }

    public final void c(String str) {
        Intrinsics.h(str, "msg");
        wf.a.a.w("co_pay", str, true);
    }
}
