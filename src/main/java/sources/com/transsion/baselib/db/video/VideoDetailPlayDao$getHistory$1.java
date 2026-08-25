package com.transsion.baselib.db.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.baselib.db.video.VideoDetailPlayDao$DefaultImpls", f = "VideoDetailPlayDao.kt", l = {113, 119, 152}, m = "getHistory")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class VideoDetailPlayDao$getHistory$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    VideoDetailPlayDao$getHistory$1(Continuation<? super VideoDetailPlayDao$getHistory$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VideoDetailPlayDao$DefaultImpls.a(null, null, this);
    }
}
