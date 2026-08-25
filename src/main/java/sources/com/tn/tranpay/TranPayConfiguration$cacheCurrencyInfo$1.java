package com.tn.tranpay;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.tn.tranpay.TranPayConfiguration", f = "TranPayConfiguration.kt", l = {129}, m = "cacheCurrencyInfo")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class TranPayConfiguration$cacheCurrencyInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TranPayConfiguration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TranPayConfiguration$cacheCurrencyInfo$1(TranPayConfiguration tranPayConfiguration, Continuation<? super TranPayConfiguration$cacheCurrencyInfo$1> continuation) {
        super(continuation);
        this.this$0 = tranPayConfiguration;
    }

    public final Object invokeSuspend(Object obj) {
        Object d;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d = this.this$0.d(null, this);
        return d;
    }
}
