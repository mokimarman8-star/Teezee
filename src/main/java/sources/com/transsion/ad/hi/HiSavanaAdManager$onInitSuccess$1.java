package com.transsion.ad.hi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.hi.HiSavanaAdManager", f = "HiSavanaAdManager.kt", l = {136}, m = "onInitSuccess")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HiSavanaAdManager$onInitSuccess$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HiSavanaAdManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HiSavanaAdManager$onInitSuccess$1(HiSavanaAdManager hiSavanaAdManager, Continuation<? super HiSavanaAdManager$onInitSuccess$1> continuation) {
        super(continuation);
        this.this$0 = hiSavanaAdManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object g;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g = this.this$0.g(this);
        return g;
    }
}
