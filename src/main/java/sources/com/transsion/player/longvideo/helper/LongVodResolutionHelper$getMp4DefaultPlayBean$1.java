package com.transsion.player.longvideo.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.player.longvideo.helper.LongVodResolutionHelper", f = "LongVodResolutionHelper.kt", l = {122}, m = "getMp4DefaultPlayBean")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodResolutionHelper$getMp4DefaultPlayBean$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LongVodResolutionHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodResolutionHelper$getMp4DefaultPlayBean$1(LongVodResolutionHelper longVodResolutionHelper, Continuation<? super LongVodResolutionHelper$getMp4DefaultPlayBean$1> continuation) {
        super(continuation);
        this.this$0 = longVodResolutionHelper;
    }

    public final Object invokeSuspend(Object obj) {
        Object d;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d = this.this$0.d(null, this);
        return d;
    }
}
