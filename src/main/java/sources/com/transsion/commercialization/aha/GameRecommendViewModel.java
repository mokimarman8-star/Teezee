package com.transsion.commercialization.aha;

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
public final class GameRecommendViewModel extends t0 {
    private final b0 a = new b0();
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.aha.h
        public final Object invoke() {
            g l;
            l = GameRecommendViewModel.l();
            return l;
        }
    });
    private int c;

    /* JADX INFO: Access modifiers changed from: private */
    public final String j() {
        String simpleName = GameRecommendViewModel.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g k() {
        return (g) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g l() {
        return (g) kg.c.e.a().h(g.class);
    }

    public final b0 h() {
        return this.a;
    }

    public final void i() {
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new GameRecommendViewModel$getAllGame$1(this, null), 2, (Object) null);
    }
}
