package com.transsion.baselib.db.place;

import com.transsion.baselib.db.place.PlaceDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.baselib.db.place.PlaceDao$DefaultImpls", f = "PlaceDao.kt", l = {21, 22}, m = "insertList")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PlaceDao$insertList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    PlaceDao$insertList$1(Continuation<? super PlaceDao$insertList$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PlaceDao.DefaultImpls.a(null, null, this);
    }
}
