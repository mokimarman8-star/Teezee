package com.transsion.baselib.kids;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.baselib.kids.KidsAccountManager", f = "KidsAccountManager.kt", l = {44}, m = "shouldShowAutoPopup")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class KidsAccountManager$shouldShowAutoPopup$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KidsAccountManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KidsAccountManager$shouldShowAutoPopup$1(KidsAccountManager kidsAccountManager, Continuation<? super KidsAccountManager$shouldShowAutoPopup$1> continuation) {
        super(continuation);
        this.this$0 = kidsAccountManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(this);
    }
}
