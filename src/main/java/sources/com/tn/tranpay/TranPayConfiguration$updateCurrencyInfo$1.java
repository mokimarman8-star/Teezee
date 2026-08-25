package com.tn.tranpay;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.TranPayConfiguration$updateCurrencyInfo$1", f = "TranPayConfiguration.kt", l = {136}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class TranPayConfiguration$updateCurrencyInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    TranPayConfiguration$updateCurrencyInfo$1(Continuation<? super TranPayConfiguration$updateCurrencyInfo$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TranPayConfiguration$updateCurrencyInfo$1(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            TranPayConfiguration tranPayConfiguration = TranPayConfiguration.a;
            this.label = 1;
            e = tranPayConfiguration.e(true, this);
            if (e == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
