package com.transsion.push.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.push.helper.RoomHelper", f = "RoomHelper.kt", l = {56}, m = "hasGetMsgToday")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class RoomHelper$hasGetMsgToday$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomHelper$hasGetMsgToday$1(RoomHelper roomHelper, Continuation<? super RoomHelper$hasGetMsgToday$1> continuation) {
        super(continuation);
        this.this$0 = roomHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
