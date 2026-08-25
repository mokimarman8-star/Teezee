package com.transsion.transfer.wifi.util;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    public static /* synthetic */ void b(g gVar, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        gVar.a(str, z);
    }

    public static /* synthetic */ void d(g gVar, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        gVar.c(str, z);
    }

    public static /* synthetic */ void f(g gVar, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        gVar.e(str, z);
    }

    public static /* synthetic */ void h(g gVar, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        gVar.g(str, z);
    }

    public final void a(String msg, boolean z) {
        Intrinsics.h(msg, "msg");
        wf.a.a.c("mb_wifi", msg, z);
    }

    public final void c(String msg, boolean z) {
        Intrinsics.h(msg, "msg");
        wf.a.a.i("mb_wifi", msg, z);
    }

    public final void e(String msg, boolean z) {
        Intrinsics.h(msg, "msg");
        wf.a.a.w("mb_wifi_r", msg, z);
    }

    public final void g(String msg, boolean z) {
        Intrinsics.h(msg, "msg");
        wf.a.a.w("mb_wifi", msg, z);
    }
}
