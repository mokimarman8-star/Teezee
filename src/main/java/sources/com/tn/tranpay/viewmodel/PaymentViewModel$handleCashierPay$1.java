package com.tn.tranpay.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel", f = "PaymentViewModel.kt", l = {156, 168}, m = "handleCashierPay")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class PaymentViewModel$handleCashierPay$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaymentViewModel$handleCashierPay$1(PaymentViewModel paymentViewModel, Continuation<? super PaymentViewModel$handleCashierPay$1> continuation) {
        super(continuation);
        this.this$0 = paymentViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object C;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        C = this.this$0.C(null, null, null, null, this);
        return C;
    }
}
