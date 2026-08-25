package com.tn.tranpay.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel", f = "PaymentViewModel.kt", l = {321}, m = "handleQuery")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class PaymentViewModel$handleQuery$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaymentViewModel$handleQuery$1(PaymentViewModel paymentViewModel, Continuation<? super PaymentViewModel$handleQuery$1> continuation) {
        super(continuation);
        this.this$0 = paymentViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object D;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        D = this.this$0.D(null, this);
        return D;
    }
}
