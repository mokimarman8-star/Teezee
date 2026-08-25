package com.transsion.rewardscenter.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.rewardscenter.utils.RewardsCenterApiHelper", f = "RewardsCenterApiHelper.kt", l = {89}, m = "checkDadaSetDefault")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RewardsCenterApiHelper$checkDadaSetDefault$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RewardsCenterApiHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RewardsCenterApiHelper$checkDadaSetDefault$1(RewardsCenterApiHelper rewardsCenterApiHelper, Continuation<? super RewardsCenterApiHelper$checkDadaSetDefault$1> continuation) {
        super(continuation);
        this.this$0 = rewardsCenterApiHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, null, this);
    }
}
