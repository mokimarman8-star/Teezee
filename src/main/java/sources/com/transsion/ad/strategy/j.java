package com.transsion.ad.strategy;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements androidx.lifecycle.f {
    public static final j a = new j();

    private j() {
    }

    public /* synthetic */ void onCreate(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    public /* synthetic */ void onDestroy(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    public /* synthetic */ void onPause(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    public /* synthetic */ void onResume(androidx.lifecycle.u uVar) {
        androidx.lifecycle.e.d(this, uVar);
    }

    public void onStart(androidx.lifecycle.u uVar) {
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.e(this, uVar);
        a.a.a();
    }

    public void onStop(androidx.lifecycle.u uVar) {
        Intrinsics.h(uVar, "owner");
        androidx.lifecycle.e.f(this, uVar);
        a.a.b();
    }
}
