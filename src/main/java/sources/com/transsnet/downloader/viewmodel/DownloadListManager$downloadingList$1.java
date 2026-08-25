package com.transsnet.downloader.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadListManager", f = "DownloadListManager.kt", l = {384}, m = "downloadingList")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class DownloadListManager$downloadingList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadListManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadListManager$downloadingList$1(DownloadListManager downloadListManager, Continuation<? super DownloadListManager$downloadingList$1> continuation) {
        super(continuation);
        this.this$0 = downloadListManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object x;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        x = this.this$0.x(this);
        return x;
    }
}
