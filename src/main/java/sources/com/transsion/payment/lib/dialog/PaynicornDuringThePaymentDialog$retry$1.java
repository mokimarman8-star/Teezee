package com.transsion.payment.lib.dialog;

import android.os.SystemClock;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$retry$1", f = "PaynicornDuringThePaymentDialog.kt", l = {266}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PaynicornDuringThePaymentDialog$retry$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $startTime;
    int label;
    final /* synthetic */ PaynicornDuringThePaymentDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaynicornDuringThePaymentDialog$retry$1(PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog, long j, Continuation<? super PaynicornDuringThePaymentDialog$retry$1> continuation) {
        super(2, continuation);
        this.this$0 = paynicornDuringThePaymentDialog;
        this.$startTime = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaynicornDuringThePaymentDialog$retry$1(this.this$0, this.$startTime, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog = this.this$0;
            j = paynicornDuringThePaymentDialog.initialDelayMillis;
            paynicornDuringThePaymentDialog.currentDelay = RangesKt.f(j - (SystemClock.elapsedRealtime() - this.$startTime), 0L);
            j2 = this.this$0.currentDelay;
            this.label = 1;
            if (u0.a(j2, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.this$0.H0();
        return Unit.a;
    }
}
