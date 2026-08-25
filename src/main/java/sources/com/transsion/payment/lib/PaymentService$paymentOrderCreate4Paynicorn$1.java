package com.transsion.payment.lib;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.payment.lib.PaymentService", f = "PaymentService.kt", l = {107}, m = "paymentOrderCreate4Paynicorn")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PaymentService$paymentOrderCreate4Paynicorn$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaymentService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaymentService$paymentOrderCreate4Paynicorn$1(PaymentService paymentService, Continuation<? super PaymentService$paymentOrderCreate4Paynicorn$1> continuation) {
        super(continuation);
        this.this$0 = paymentService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, null, this);
    }
}
