package com.transsion.commercialization.task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.commercialization.task.TaskCenterProvider", f = "TaskCenterProvider.kt", l = {78}, m = "getLotteryUserInfoEntity")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TaskCenterProvider$getLotteryUserInfoEntity$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskCenterProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TaskCenterProvider$getLotteryUserInfoEntity$1(TaskCenterProvider taskCenterProvider, Continuation<? super TaskCenterProvider$getLotteryUserInfoEntity$1> continuation) {
        super(continuation);
        this.this$0 = taskCenterProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
