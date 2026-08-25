package com.transsion.postdetail.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.postdetail.util.VideoSaver", f = "VideoSaver.kt", l = {27, 30}, m = "saveVideoToGallery")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class VideoSaver$saveVideoToGallery$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoSaver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoSaver$saveVideoToGallery$1(VideoSaver videoSaver, Continuation<? super VideoSaver$saveVideoToGallery$1> continuation) {
        super(continuation);
        this.this$0 = videoSaver;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, null, this);
    }
}
