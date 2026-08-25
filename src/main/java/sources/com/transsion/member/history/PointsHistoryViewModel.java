package com.transsion.member.history;

import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PointsHistoryViewModel extends t0 {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.member.history.e
        public final Object invoke() {
            fm.a g;
            g = PointsHistoryViewModel.g();
            return g;
        }
    });
    private final b0 b = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public final fm.a f() {
        return (fm.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fm.a g() {
        return (fm.a) kg.c.e.a().h(fm.a.class);
    }

    public final void d(String str) {
        Intrinsics.h(str, "page");
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new PointsHistoryViewModel$fetchHistory$1(this, str, null), 2, (Object) null);
    }

    public final b0 e() {
        return this.b;
    }
}
