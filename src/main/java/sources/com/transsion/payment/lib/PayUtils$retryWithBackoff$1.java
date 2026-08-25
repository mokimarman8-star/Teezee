package com.transsion.payment.lib;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.payment.lib.PayUtils", f = "PayUtils.kt", l = {26, 38}, m = "retryWithBackoff")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PayUtils$retryWithBackoff$1<T> extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PayUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayUtils$retryWithBackoff$1(PayUtils payUtils, Continuation<? super PayUtils$retryWithBackoff$1> continuation) {
        super(continuation);
        this.this$0 = payUtils;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0L, 0, null, this);
    }
}
