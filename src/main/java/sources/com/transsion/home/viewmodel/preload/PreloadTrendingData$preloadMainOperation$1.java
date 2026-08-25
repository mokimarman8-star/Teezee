package com.transsion.home.viewmodel.preload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData", f = "PreloadTrendingData.kt", l = {109}, m = "preloadMainOperation")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PreloadTrendingData$preloadMainOperation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreloadTrendingData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreloadTrendingData$preloadMainOperation$1(PreloadTrendingData preloadTrendingData, Continuation<? super PreloadTrendingData$preloadMainOperation$1> continuation) {
        super(continuation);
        this.this$0 = preloadTrendingData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PreloadTrendingData.p(this.this$0, (String) null, this);
    }
}
