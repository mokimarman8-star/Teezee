package com.tn.tranpay.helper;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.tn.tranpay.helper.PaymentMMKV", f = "PaymentMMKV.kt", l = {TaskResultKt.ERROR_LOAD_RESPONSE_ERROR_CODE}, m = "cacheCurrencyInfoByIP")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class PaymentMMKV$cacheCurrencyInfoByIP$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaymentMMKV this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaymentMMKV$cacheCurrencyInfoByIP$1(PaymentMMKV paymentMMKV, Continuation<? super PaymentMMKV$cacheCurrencyInfoByIP$1> continuation) {
        super(continuation);
        this.this$0 = paymentMMKV;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
