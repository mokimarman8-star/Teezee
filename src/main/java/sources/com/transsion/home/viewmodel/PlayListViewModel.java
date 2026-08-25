package com.transsion.home.viewmodel;

import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PlayListViewModel extends t0 {
    private final yk.b a = (yk.b) kg.c.e.a().h(yk.b.class);
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.m
        public final Object invoke() {
            androidx.lifecycle.b0 h;
            h = PlayListViewModel.h();
            return h;
        }
    });
    private int c = 1;
    private int d = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.lifecycle.b0 h() {
        return new androidx.lifecycle.b0();
    }

    public final int e() {
        return this.c;
    }

    public final void f(String str, String str2, String str3, String str4, int i) {
        Intrinsics.h(str, "label");
        Intrinsics.h(str2, "category");
        Intrinsics.h(str3, "recType");
        Intrinsics.h(str4, "topIds");
        kotlinx.coroutines.i.d(u0.a(this), y0.b(), (CoroutineStart) null, new PlayListViewModel$getPlayList$1(this, str, str2, str3, str4, i, null), 2, (Object) null);
    }

    public final androidx.lifecycle.b0 g() {
        return (androidx.lifecycle.b0) this.b.getValue();
    }

    public final void i(int i) {
        this.c = i;
    }
}
