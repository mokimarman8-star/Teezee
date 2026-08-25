package com.transsion.postdetail.shorttv.factory;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider", f = "ShortTvHistoryProvider.kt", l = {61}, m = "saveHistory")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTvHistoryProvider$saveHistory$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShortTvHistoryProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTvHistoryProvider$saveHistory$1(ShortTvHistoryProvider shortTvHistoryProvider, Continuation<? super ShortTvHistoryProvider$saveHistory$1> continuation) {
        super(continuation);
        this.this$0 = shortTvHistoryProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, 0L, this);
    }
}
