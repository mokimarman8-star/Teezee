package com.transsion.ad.monopoly.intercept;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler", f = "ShowOnNetworkStateHandler.kt", l = {30}, m = "doHandle")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShowOnNetworkStateHandler$doHandle$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShowOnNetworkStateHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShowOnNetworkStateHandler$doHandle$1(ShowOnNetworkStateHandler showOnNetworkStateHandler, Continuation<? super ShowOnNetworkStateHandler$doHandle$1> continuation) {
        super(continuation);
        this.this$0 = showOnNetworkStateHandler;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
