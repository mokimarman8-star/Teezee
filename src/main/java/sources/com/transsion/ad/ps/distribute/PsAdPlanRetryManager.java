package com.transsion.ad.ps.distribute;

import android.os.SystemClock;
import com.transsion.ad.monopoly.model.AdPlans;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PsAdPlanRetryManager {
    public static final PsAdPlanRetryManager a = new PsAdPlanRetryManager();
    private static long b;

    private PsAdPlanRetryManager() {
    }

    private final String a() {
        String simpleName = PsAdPlanRetryManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void b(AdPlans adPlans) {
        if (SystemClock.elapsedRealtime() - b < com.transsion.ad.scene.b.a.e()) {
            return;
        }
        b = SystemClock.elapsedRealtime();
        xh.a.i(xh.a.a, a() + " --> retry() --> PS 直投的虚拟计划 --> 无商单重试 --> 请求PS商单接口", 5, false, 4, null);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PsAdPlanRetryManager$retry$1(adPlans, null), 3, (Object) null);
    }
}
