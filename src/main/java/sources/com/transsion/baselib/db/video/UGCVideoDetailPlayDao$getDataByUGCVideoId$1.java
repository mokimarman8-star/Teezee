package com.transsion.baselib.db.video;

import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.baselib.db.video.UGCVideoDetailPlayDao$DefaultImpls", f = "UGCVideoDetailPlayDao.kt", l = {84, 89}, m = "getDataByUGCVideoId")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UGCVideoDetailPlayDao$getDataByUGCVideoId$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    UGCVideoDetailPlayDao$getDataByUGCVideoId$1(Continuation<? super UGCVideoDetailPlayDao$getDataByUGCVideoId$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UGCVideoDetailPlayDao.DefaultImpls.a(null, null, this);
    }
}
