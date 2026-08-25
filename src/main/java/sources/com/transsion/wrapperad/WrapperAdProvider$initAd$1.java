package com.transsion.wrapperad;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.wrapperad.WrapperAdProvider", f = "WrapperAdProvider.kt", l = {63, 67, 129}, m = "initAd")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class WrapperAdProvider$initAd$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WrapperAdProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WrapperAdProvider$initAd$1(WrapperAdProvider wrapperAdProvider, Continuation<? super WrapperAdProvider$initAd$1> continuation) {
        super(continuation);
        this.this$0 = wrapperAdProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
