package com.tn.tranpay.viewmodel;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel", f = "PaymentViewModel.kt", l = {TaskResultKt.ERROR_LOAD_REQUEST_FAIL}, m = "loadConfigBean")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class PaymentViewModel$loadConfigBean$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaymentViewModel$loadConfigBean$1(PaymentViewModel paymentViewModel, Continuation<? super PaymentViewModel$loadConfigBean$1> continuation) {
        super(continuation);
        this.this$0 = paymentViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object F;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        F = this.this$0.F(null, null, this);
        return F;
    }
}
