package com.transsion.payment.lib.strategy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy", f = "GoogleStrategy.kt", l = {288}, m = "handlePurchase")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class GoogleStrategy$handlePurchase$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleStrategy$handlePurchase$1(GoogleStrategy googleStrategy, Continuation<? super GoogleStrategy$handlePurchase$1> continuation) {
        super(continuation);
        this.this$0 = googleStrategy;
    }

    public final Object invokeSuspend(Object obj) {
        Object B;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        B = this.this$0.B(null, this);
        return B;
    }
}
