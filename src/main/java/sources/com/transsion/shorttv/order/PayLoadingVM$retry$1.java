package com.transsion.shorttv.order;

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
@DebugMetadata(c = "com.transsion.shorttv.order.PayLoadingVM$retry$1", f = "PayLoadingVM.kt", l = {137}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PayLoadingVM$retry$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isDebug;
    final /* synthetic */ String $projectName;
    final /* synthetic */ long $startTime;
    final /* synthetic */ String $tradingOrderId;
    int label;
    final /* synthetic */ PayLoadingVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayLoadingVM$retry$1(PayLoadingVM payLoadingVM, long j, String str, String str2, boolean z, Continuation<? super PayLoadingVM$retry$1> continuation) {
        super(2, continuation);
        this.this$0 = payLoadingVM;
        this.$startTime = j;
        this.$tradingOrderId = str;
        this.$projectName = str2;
        this.$isDebug = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PayLoadingVM$retry$1(this.this$0, this.$startTime, this.$tradingOrderId, this.$projectName, this.$isDebug, continuation);
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
            PayLoadingVM payLoadingVM = this.this$0;
            j = payLoadingVM.b;
            payLoadingVM.c = RangesKt.f(j - (SystemClock.elapsedRealtime() - this.$startTime), 0L);
            j2 = this.this$0.c;
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
        this.this$0.i(this.$tradingOrderId, this.$projectName, this.$isDebug);
        return Unit.a;
    }
}
