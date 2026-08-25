package com.transsnet.downloader.util;

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
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.util.DownloadUtil$initSetDownloadInfoAndRanges$1", f = "DownloadUtil.kt", l = {75}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadUtil$initSetDownloadInfoAndRanges$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $bean;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadUtil$initSetDownloadInfoAndRanges$1(DownloadBean downloadBean, Continuation<? super DownloadUtil$initSetDownloadInfoAndRanges$1> continuation) {
        super(2, continuation);
        this.$bean = downloadBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadUtil$initSetDownloadInfoAndRanges$1(this.$bean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadUtil$initSetDownloadInfoAndRanges$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        DownloadBean downloadBean;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            String resourceId = this.$bean.getResourceId();
            if (resourceId != null) {
                DownloadBean downloadBean2 = this.$bean;
                ui.n0 g = DownloadUtil.g(DownloadUtil.a);
                this.L$0 = downloadBean2;
                this.label = 1;
                obj = g.a(resourceId, this);
                if (obj == f) {
                    return f;
                }
                downloadBean = downloadBean2;
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        downloadBean = (DownloadBean) this.L$0;
        ResultKt.b(obj);
        List list = (List) obj;
        if (list != null && (!list.isEmpty())) {
            downloadBean.getDownloadRanges().addAll(list);
        }
        return Unit.a;
    }
}
