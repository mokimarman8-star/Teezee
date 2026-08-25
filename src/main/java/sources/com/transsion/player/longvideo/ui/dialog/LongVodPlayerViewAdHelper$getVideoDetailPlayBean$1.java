package com.transsion.player.longvideo.ui.dialog;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper", f = "LongVodPlayerViewAdHelper.kt", l = {208}, m = "getVideoDetailPlayBean")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, Continuation<? super LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1> continuation) {
        super(continuation);
        this.this$0 = longVodPlayerViewAdHelper;
    }

    public final Object invokeSuspend(Object obj) {
        Object R3;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        R3 = this.this$0.R3(this);
        return R3;
    }
}
