package com.tn.tranpay.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel", f = "PaymentViewModel.kt", l = {294}, m = "handleCancelPay")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class PaymentViewModel$handleCancelPay$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaymentViewModel$handleCancelPay$1(PaymentViewModel paymentViewModel, Continuation<? super PaymentViewModel$handleCancelPay$1> continuation) {
        super(continuation);
        this.this$0 = paymentViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object B;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        B = this.this$0.B(null, null, null, this);
        return B;
    }
}
