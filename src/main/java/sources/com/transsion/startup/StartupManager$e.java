package com.transsion.startup;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class StartupManager$e implements sn.f {
    StartupManager$e() {
    }

    public void a(String tag, String msg, boolean z) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(msg, "msg");
        wf.a.a.p(tag, new String[]{msg}, z);
    }

    public void b(String tag, String msg, boolean z) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(msg, "msg");
        wf.a.a.c(tag, msg, z);
    }

    public void c(String tag, String msg, boolean z) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(msg, "msg");
        wf.a.a.u(tag, msg, z);
    }

    public void d(String tag, String msg, boolean z) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(msg, "msg");
        wf.a.a.i(tag, msg, z);
    }
}
