package com.transsion.ninegridview.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ninegridview.helper.FileHelper", f = "FileHelper.kt", l = {102}, m = "saveToAlbum")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class FileHelper$saveToAlbum$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileHelper$saveToAlbum$1(FileHelper fileHelper, Continuation<? super FileHelper$saveToAlbum$1> continuation) {
        super(continuation);
        this.this$0 = fileHelper;
    }

    public final Object invokeSuspend(Object obj) {
        Object u;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        u = this.this$0.u(null, null, null, null, false, this);
        return u;
    }
}
