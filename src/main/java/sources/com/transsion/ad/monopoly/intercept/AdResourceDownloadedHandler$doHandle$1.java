package com.transsion.ad.monopoly.intercept;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.monopoly.intercept.AdResourceDownloadedHandler", f = "AdResourceDownloadedHandler.kt", l = {29, 34, 39, 70}, m = "doHandle")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AdResourceDownloadedHandler$doHandle$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdResourceDownloadedHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdResourceDownloadedHandler$doHandle$1(AdResourceDownloadedHandler adResourceDownloadedHandler, Continuation<? super AdResourceDownloadedHandler$doHandle$1> continuation) {
        super(continuation);
        this.this$0 = adResourceDownloadedHandler;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
