package com.transsion.postdetail.shorttv_pugc.factory;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.postdetail.shorttv_pugc.factory.PugcShortTvDownloadProvider", f = "PugcShortTvDownloadProvider.kt", l = {40}, m = "fetchDownloadList")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PugcShortTvDownloadProvider$fetchDownloadList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PugcShortTvDownloadProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PugcShortTvDownloadProvider$fetchDownloadList$1(PugcShortTvDownloadProvider pugcShortTvDownloadProvider, Continuation<? super PugcShortTvDownloadProvider$fetchDownloadList$1> continuation) {
        super(continuation);
        this.this$0 = pugcShortTvDownloadProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
