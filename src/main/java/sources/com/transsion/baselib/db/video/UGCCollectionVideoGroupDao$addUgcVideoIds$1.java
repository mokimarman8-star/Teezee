package com.transsion.baselib.db.video;

import com.transsion.baselib.db.video.UGCCollectionVideoGroupDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.baselib.db.video.UGCCollectionVideoGroupDao$DefaultImpls", f = "UGCCollectionVideoGroupDao.kt", l = {44, 46, 53}, m = "addUgcVideoIds")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UGCCollectionVideoGroupDao$addUgcVideoIds$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    UGCCollectionVideoGroupDao$addUgcVideoIds$1(Continuation<? super UGCCollectionVideoGroupDao$addUgcVideoIds$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UGCCollectionVideoGroupDao.DefaultImpls.a(null, null, null, this);
    }
}
