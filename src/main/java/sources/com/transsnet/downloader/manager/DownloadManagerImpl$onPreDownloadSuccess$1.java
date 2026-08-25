package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.core.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$onPreDownloadSuccess$1", f = "DownloadManagerImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadManagerImpl$onPreDownloadSuccess$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $downloadInfo;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadManagerImpl$onPreDownloadSuccess$1(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, Continuation<? super DownloadManagerImpl$onPreDownloadSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadManagerImpl;
        this.$downloadInfo = downloadBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$onPreDownloadSuccess$1(this.this$0, this.$downloadInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$onPreDownloadSuccess$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        a.a aVar = a.a;
        aVar.u(DownloadManagerImpl.c0(this.this$0), "preDownload success, change to wait, name = " + this.$downloadInfo.getTotalTitleName() + "， progress = " + this.$downloadInfo.getProgress() + " ,status:" + this.$downloadInfo.getStatus(), true);
        if (this.$downloadInfo.getStatus() == 4) {
            aVar.w(DownloadManagerImpl.c0(this.this$0), "preDownload success, but pause~， break-----", true);
            return Unit.a;
        }
        this.$downloadInfo.setStatus(3);
        this.$downloadInfo.setPreDownload(false);
        c U = DownloadManagerImpl.U(this.this$0);
        if (U != null) {
            U.a(this.$downloadInfo);
        }
        ConcurrentHashMap T = DownloadManagerImpl.T(this.this$0);
        String resourceId = this.$downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = this.$downloadInfo.getUrl();
        }
        T.remove(resourceId);
        ConcurrentHashMap Y = DownloadManagerImpl.Y(this.this$0);
        String resourceId2 = this.$downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = this.$downloadInfo.getUrl();
        }
        Y.remove(resourceId2);
        DownloadManagerImpl.d0(this.this$0);
        return Unit.a;
    }
}
