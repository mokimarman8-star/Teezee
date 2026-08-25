package com.transsion.ad.monopoly.intercept;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.monopoly.intercept.ValidTimesHandler", f = "ValidTimesHandler.kt", l = {29, 35}, m = "doHandle")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ValidTimesHandler$doHandle$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ValidTimesHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ValidTimesHandler$doHandle$1(ValidTimesHandler validTimesHandler, Continuation<? super ValidTimesHandler$doHandle$1> continuation) {
        super(continuation);
        this.this$0 = validTimesHandler;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
