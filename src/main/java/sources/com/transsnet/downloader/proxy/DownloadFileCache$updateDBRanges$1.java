package com.transsnet.downloader.proxy;

import com.danikula.videocache.q;
import com.transsion.baselib.db.download.DownloadRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.proxy.DownloadFileCache$updateDBRanges$1", f = "DownloadFileCache.kt", l = {339}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadFileCache$updateDBRanges$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DownloadRange> $downloadRanges;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DownloadFileCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadFileCache$updateDBRanges$1(List<DownloadRange> list, DownloadFileCache downloadFileCache, Continuation<? super DownloadFileCache$updateDBRanges$1> continuation) {
        super(2, continuation);
        this.$downloadRanges = list;
        this.this$0 = downloadFileCache;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadFileCache$updateDBRanges$1(this.$downloadRanges, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadFileCache$updateDBRanges$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0040 A[Catch: all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:6:0x0017, B:7:0x005a, B:8:0x003a, B:10:0x0040, B:20:0x0026), top: B:2:0x0007 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0057 -> B:7:0x005a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Iterator it;
        DownloadFileCache downloadFileCache;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.$downloadRanges);
            DownloadFileCache downloadFileCache2 = this.this$0;
            it = arrayList.iterator();
            downloadFileCache = downloadFileCache2;
            if (it.hasNext()) {
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DownloadRange downloadRange = (DownloadRange) this.L$2;
        it = (Iterator) this.L$1;
        downloadFileCache = (DownloadFileCache) this.L$0;
        ResultKt.b(obj);
        q.c("================range,  updateDBRanges ，threadId = " + downloadRange.getThreadId() + ", rangeId = " + downloadRange.getRangeId() + ", start = " + downloadRange.getStart() + ", end = " + downloadRange.getEnd() + ", progress = " + downloadRange.getProgress());
        if (it.hasNext()) {
            downloadRange = (DownloadRange) it.next();
            ui.n0 e = DownloadFileCache.e(downloadFileCache);
            this.L$0 = downloadFileCache;
            this.L$1 = it;
            this.L$2 = downloadRange;
            this.label = 1;
            if (e.c(downloadRange, this) == f) {
                return f;
            }
            q.c("================range,  updateDBRanges ，threadId = " + downloadRange.getThreadId() + ", rangeId = " + downloadRange.getRangeId() + ", start = " + downloadRange.getStart() + ", end = " + downloadRange.getEnd() + ", progress = " + downloadRange.getProgress());
            if (it.hasNext()) {
            }
        }
        return Unit.a;
    }
}
