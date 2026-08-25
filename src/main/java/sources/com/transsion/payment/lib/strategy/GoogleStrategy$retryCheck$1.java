package com.transsion.payment.lib.strategy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy", f = "GoogleStrategy.kt", l = {334, 336}, m = "retryCheck")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class GoogleStrategy$retryCheck$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleStrategy$retryCheck$1(GoogleStrategy googleStrategy, Continuation<? super GoogleStrategy$retryCheck$1> continuation) {
        super(continuation);
        this.this$0 = googleStrategy;
    }

    public final Object invokeSuspend(Object obj) {
        Object J;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        J = this.this$0.J(0L, null, this);
        return J;
    }
}
