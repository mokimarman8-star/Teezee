package com.transsion.ad.ps.attribution;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.attribution.AttributionConsumeManager$consume$1", f = "AttributionConsumeManager.kt", l = {42, 49}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AttributionConsumeManager$consume$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    AttributionConsumeManager$consume$1(Continuation<? super AttributionConsumeManager$consume$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AttributionConsumeManager$consume$1 attributionConsumeManager$consume$1 = new AttributionConsumeManager$consume$1(continuation);
        attributionConsumeManager$consume$1.L$0 = obj;
        return attributionConsumeManager$consume$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object q;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        if (i == 0) {
            ResultKt.b(obj);
            Result.Companion companion2 = Result.Companion;
            AttributionConsumeManager attributionConsumeManager = AttributionConsumeManager.c;
            this.label = 1;
            q = attributionConsumeManager.q(this);
            if (q == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                AttributionConsumeManager.c.p();
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        obj2 = Result.constructor-impl(Unit.a);
        Throwable th3 = Result.exceptionOrNull-impl(obj2);
        if (th3 != null) {
            xh.a.i(xh.a.a, AttributionConsumeManager.c.e() + " --> consume() --> it = " + th3, 6, false, 4, null);
            this.label = 2;
            if (u0.a(10000L, this) == f) {
                return f;
            }
            AttributionConsumeManager.c.p();
        }
        return Unit.a;
    }
}
