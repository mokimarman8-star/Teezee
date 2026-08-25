package com.tn.tranpay;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.tn.tranpay.TranPayConfiguration", f = "TranPayConfiguration.kt", l = {80, 88, 91}, m = "getCurrencyInfoBean")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class TranPayConfiguration$getCurrencyInfoBean$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TranPayConfiguration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TranPayConfiguration$getCurrencyInfoBean$1(TranPayConfiguration tranPayConfiguration, Continuation<? super TranPayConfiguration$getCurrencyInfoBean$1> continuation) {
        super(continuation);
        this.this$0 = tranPayConfiguration;
    }

    public final Object invokeSuspend(Object obj) {
        Object o;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        o = this.this$0.o(this);
        return o;
    }
}
