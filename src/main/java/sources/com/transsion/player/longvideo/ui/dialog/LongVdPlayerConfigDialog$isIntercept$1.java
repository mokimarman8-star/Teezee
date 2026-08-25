package com.transsion.player.longvideo.ui.dialog;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVdPlayerConfigDialog", f = "LongVdPlayerConfigDialog.kt", l = {181}, m = "isIntercept")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVdPlayerConfigDialog$isIntercept$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LongVdPlayerConfigDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVdPlayerConfigDialog$isIntercept$1(LongVdPlayerConfigDialog longVdPlayerConfigDialog, Continuation<? super LongVdPlayerConfigDialog$isIntercept$1> continuation) {
        super(continuation);
        this.this$0 = longVdPlayerConfigDialog;
    }

    public final Object invokeSuspend(Object obj) {
        Object w0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        w0 = this.this$0.w0(null, this);
        return w0;
    }
}
