package com.transsion.rewardscenter;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b0;
import androidx.lifecycle.v;
import com.transsion.rewardscenter.task.ad.g0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RewardsCenterProvider implements bp.a {
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.a
        public final Object invoke() {
            xo.a g;
            g = RewardsCenterProvider.g();
            return g;
        }
    });
    private final b0 b = new b0(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.a g() {
        return (xo.a) kg.c.e.a().h(xo.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.a h() {
        return (xo.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(g0 g0Var) {
        g0Var.r();
        return Unit.a;
    }

    @Override // bp.a
    public void a(Context context, n0 n0Var) {
        Intrinsics.h(context, "context");
        a.a.f(wf.a.a, "RewardsCenter", "preloadTaskAd", false, 4, (Object) null);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        final g0 g0Var = new g0(applicationContext, n0Var);
        g0Var.f(new Function0() { // from class: com.transsion.rewardscenter.b
            public final Object invoke() {
                Unit i;
                i = RewardsCenterProvider.i(g0.this);
                return i;
            }
        });
    }

    @Override // bp.a
    public LiveData b() {
        i.d(v.a(androidx.lifecycle.g0.i.a()), (CoroutineContext) null, (CoroutineStart) null, new RewardsCenterProvider$fetchUnclaimRewardCount$1(this, null), 3, (Object) null);
        return this.b;
    }
}
