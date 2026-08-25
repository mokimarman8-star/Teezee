package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
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
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$registerNetwork$1$netConnected$3", f = "DownloadManagerImpl.kt", l = {1323}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadManagerImpl$registerNetwork$1$netConnected$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadManagerImpl$registerNetwork$1$netConnected$3(DownloadManagerImpl downloadManagerImpl, Continuation<? super DownloadManagerImpl$registerNetwork$1$netConnected$3> continuation) {
        super(2, continuation);
        this.this$0 = downloadManagerImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$registerNetwork$1$netConnected$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$registerNetwork$1$netConnected$3) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            DownloadManagerImpl downloadManagerImpl = this.this$0;
            this.label = 1;
            obj = downloadManagerImpl.o0(this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List<DownloadBean> list = (List) obj;
        if (list != null) {
            DownloadManagerImpl downloadManagerImpl2 = this.this$0;
            for (DownloadBean downloadBean : list) {
                if (!DownloadManagerImpl.W(downloadManagerImpl2).contains(downloadBean)) {
                    a.a.f(a.a, DownloadManagerImpl.c0(downloadManagerImpl2), "onConnected, db, name = " + downloadBean.getName() + ", epse = " + downloadBean.getEpse() + ",  cur status = " + downloadBean.getStatus(), false, 4, (Object) null);
                    downloadManagerImpl2.s(downloadBean, true);
                }
            }
        }
        return Unit.a;
    }
}
