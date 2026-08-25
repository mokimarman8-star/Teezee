package com.transsion.push.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.push.db.PermanentRoom", f = "PermanentRoom.kt", l = {81}, m = "getAll")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PermanentRoom$getAll$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermanentRoom this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermanentRoom$getAll$1(PermanentRoom permanentRoom, Continuation<? super PermanentRoom$getAll$1> continuation) {
        super(continuation);
        this.this$0 = permanentRoom;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
