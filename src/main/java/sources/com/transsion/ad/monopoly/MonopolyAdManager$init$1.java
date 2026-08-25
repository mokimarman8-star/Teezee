package com.transsion.ad.monopoly;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.monopoly.MonopolyAdManager", f = "MonopolyAdManager.kt", l = {21, 24, 30}, m = "init")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MonopolyAdManager$init$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MonopolyAdManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MonopolyAdManager$init$1(MonopolyAdManager monopolyAdManager, Continuation<? super MonopolyAdManager$init$1> continuation) {
        super(continuation);
        this.this$0 = monopolyAdManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
