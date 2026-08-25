package com.transsnet.downloader.core;

import com.blankj.utilcode.util.a0;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import ni.f;
import okhttp3.HttpUrl;
import wf.a;
import yg.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.core.DownloadResponseImpl$createOrUpdateDownloadInfo$1", f = "DownloadResponseImpl.kt", l = {183, 184, 190, 198, Sdk$SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadResponseImpl$createOrUpdateDownloadInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $downloadInfo;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadResponseImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadResponseImpl$createOrUpdateDownloadInfo$1(DownloadBean downloadBean, DownloadResponseImpl downloadResponseImpl, Continuation<? super DownloadResponseImpl$createOrUpdateDownloadInfo$1> continuation) {
        super(2, continuation);
        this.$downloadInfo = downloadBean;
        this.this$0 = downloadResponseImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadResponseImpl$createOrUpdateDownloadInfo$1(this.$downloadInfo, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadResponseImpl$createOrUpdateDownloadInfo$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0196 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010b A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #0 {all -> 0x0037, blocks: (B:23:0x0032, B:25:0x0105, B:27:0x010b, B:46:0x00f5), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DownloadResponseImpl downloadResponseImpl;
        DownloadBean downloadBean;
        String cover;
        DownloadResponseImpl downloadResponseImpl2;
        Iterator it;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Throwable th) {
            wf.a.a.c("DownloadImp-ResponseImpl", "createOrUpdateDownloadInfo, insert ranges error:" + th, true);
        }
        if (i == 0) {
            ResultKt.b(obj);
            if (this.$downloadInfo.getStatus() == 7) {
                return Unit.a;
            }
            if (this.$downloadInfo.getStatus() == 6 && l.a.e()) {
                DownloadBean downloadBean2 = this.$downloadInfo;
                downloadBean2.setDownloadErrorCount(downloadBean2.getDownloadErrorCount() + 1);
                a.a.f(wf.a.a, "DownloadImp-ResponseImpl", "download error , save error count = " + this.$downloadInfo.getDownloadErrorCount(), false, 4, (Object) null);
            }
            DownloadEsHelper a = DownloadEsHelper.m.a();
            DownloadBean downloadBean3 = this.$downloadInfo;
            this.label = 1;
            if (a.T(downloadBean3, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.b(obj);
                    if (!this.$downloadInfo.getDownloadRanges().isEmpty()) {
                        a.a.f(wf.a.a, "DownloadImp-ResponseImpl", "Response, insert ranges, size = " + this.$downloadInfo.getDownloadRanges().size(), false, 4, (Object) null);
                        List downloadRanges = this.$downloadInfo.getDownloadRanges();
                        downloadResponseImpl2 = this.this$0;
                        it = downloadRanges.iterator();
                        while (it.hasNext()) {
                        }
                    }
                    if (this.$downloadInfo.isCompleted()) {
                    }
                    downloadResponseImpl = this.this$0;
                    downloadBean = this.$downloadInfo;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 5;
                    if (DownloadResponseImpl.g(downloadResponseImpl, downloadBean, this) == f) {
                    }
                    return Unit.a;
                }
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        return Unit.a;
                    }
                    ResultKt.b(obj);
                    cover = this.$downloadInfo.getCover();
                    if (cover != null) {
                        int a2 = a0.a(120.0f);
                        f.a aVar = ni.f.a;
                        f.a.j(aVar, f.a.e(aVar, cover, a2, false, true, 4, (Object) null), cover, a2, (Function1) null, 8, (Object) null);
                    }
                    downloadResponseImpl = this.this$0;
                    downloadBean = this.$downloadInfo;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 5;
                    if (DownloadResponseImpl.g(downloadResponseImpl, downloadBean, this) == f) {
                        return f;
                    }
                    return Unit.a;
                }
                it = (Iterator) this.L$1;
                downloadResponseImpl2 = (DownloadResponseImpl) this.L$0;
                ResultKt.b(obj);
                while (it.hasNext()) {
                    DownloadRange downloadRange = (DownloadRange) it.next();
                    ui.n0 e = DownloadResponseImpl.e(downloadResponseImpl2);
                    this.L$0 = downloadResponseImpl2;
                    this.L$1 = it;
                    this.label = 3;
                    if (e.c(downloadRange, this) == f) {
                        return f;
                    }
                }
                if (this.$downloadInfo.isCompleted()) {
                    ui.n0 e2 = DownloadResponseImpl.e(this.this$0);
                    String resourceId = this.$downloadInfo.getResourceId();
                    if (resourceId == null) {
                        resourceId = this.$downloadInfo.getUrl();
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 4;
                    if (e2.b(resourceId, this) == f) {
                        return f;
                    }
                    cover = this.$downloadInfo.getCover();
                    if (cover != null) {
                    }
                }
                downloadResponseImpl = this.this$0;
                downloadBean = this.$downloadInfo;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 5;
                if (DownloadResponseImpl.g(downloadResponseImpl, downloadBean, this) == f) {
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        DownloadEsHelper a3 = DownloadEsHelper.m.a();
        String resourceId2 = this.$downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = this.$downloadInfo.getUrl();
        }
        int status = this.$downloadInfo.getStatus();
        this.label = 2;
        if (a3.f0(resourceId2, status, this) == f) {
            return f;
        }
        if (!this.$downloadInfo.getDownloadRanges().isEmpty()) {
        }
        if (this.$downloadInfo.isCompleted()) {
        }
        downloadResponseImpl = this.this$0;
        downloadBean = this.$downloadInfo;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 5;
        if (DownloadResponseImpl.g(downloadResponseImpl, downloadBean, this) == f) {
        }
        return Unit.a;
    }
}
