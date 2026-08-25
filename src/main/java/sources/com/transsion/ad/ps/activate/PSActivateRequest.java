package com.transsion.ad.ps.activate;

import android.os.SystemClock;
import com.transsion.ad.MBAd;
import com.transsion.ad.strategy.v;
import java.util.concurrent.atomic.AtomicBoolean;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PSActivateRequest {
    public static final PSActivateRequest a = new PSActivateRequest();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.ad.ps.activate.a
        public final Object invoke() {
            zh.a i;
            i = PSActivateRequest.i();
            return i;
        }
    });
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static long d;

    private PSActivateRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f() {
        String simpleName = PSActivateRequest.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zh.a h() {
        return (zh.a) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final zh.a i() {
        return (zh.a) c.e.a().h(zh.a.class);
    }

    public final Object g(Continuation continuation) {
        MBAd mBAd = MBAd.a;
        MBAd.a b2 = mBAd.b();
        if (b2 != null && !b2.i()) {
            xh.a aVar = xh.a.a;
            String f = f();
            MBAd.a b3 = mBAd.b();
            xh.a.k(aVar, f + " --> getPsActivateList() --> openPsActivateAd = " + (b3 != null ? Boxing.a(b3.i()) : null) + " --> 没有开启PS激活广告，直接返回", 0, false, 6, null);
            return Unit.a;
        }
        if (v.a.a()) {
            xh.a.k(xh.a.a, f() + " --> getPsActivateList() --> 青少年模式不请求激活广告", 0, false, 6, null);
            return Unit.a;
        }
        AtomicBoolean atomicBoolean = c;
        if (atomicBoolean.get()) {
            xh.a.k(xh.a.a, f() + " --> getPsActivateList() --> isRequesting = " + atomicBoolean, 0, false, 6, null);
            return Unit.a;
        }
        atomicBoolean.set(true);
        if (d <= 0 || SystemClock.elapsedRealtime() - d >= 7200000) {
            d = SystemClock.elapsedRealtime();
            Object g = i.g(y0.b(), new PSActivateRequest$getPsActivateList$2(null), continuation);
            return g == IntrinsicsKt.f() ? g : Unit.a;
        }
        xh.a.k(xh.a.a, f() + " --> getPsActivateList() --> 两次请求小于2H", 0, false, 6, null);
        atomicBoolean.set(false);
        return Unit.a;
    }
}
