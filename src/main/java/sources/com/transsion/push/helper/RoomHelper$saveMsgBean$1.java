package com.transsion.push.helper;

import android.content.Context;
import com.transsion.baselib.db.notification.PullMsgResp;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.push.helper.RoomHelper", f = "RoomHelper.kt", l = {19, 24, 34}, m = "saveMsgBean")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RoomHelper$saveMsgBean$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomHelper$saveMsgBean$1(RoomHelper roomHelper, Continuation<? super RoomHelper$saveMsgBean$1> continuation) {
        super(continuation);
        this.this$0 = roomHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g((Context) null, (PullMsgResp) null, this);
    }
}
