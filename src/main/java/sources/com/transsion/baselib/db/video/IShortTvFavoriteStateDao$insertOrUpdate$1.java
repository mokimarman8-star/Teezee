package com.transsion.baselib.db.video;

import com.transsion.publish.view.ObservableScrollView;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.baselib.db.video.IShortTvFavoriteStateDao$DefaultImpls", f = "IShortTvFavoriteStateDao.kt", l = {ObservableScrollView.SCROLL_DOWN, 17, 19}, m = "insertOrUpdate")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class IShortTvFavoriteStateDao$insertOrUpdate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    IShortTvFavoriteStateDao$insertOrUpdate$1(Continuation<? super IShortTvFavoriteStateDao$insertOrUpdate$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IShortTvFavoriteStateDao$DefaultImpls.a(null, null, this);
    }
}
