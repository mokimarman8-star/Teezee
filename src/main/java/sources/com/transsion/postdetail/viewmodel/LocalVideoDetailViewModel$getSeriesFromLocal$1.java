package com.transsion.postdetail.viewmodel;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.BuildConfig;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel$getSeriesFromLocal$1", f = "LocalVideoDetailViewModel.kt", l = {44}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LocalVideoDetailViewModel$getSeriesFromLocal$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $curBean;
    int label;
    final /* synthetic */ LocalVideoDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalVideoDetailViewModel$getSeriesFromLocal$1(DownloadBean downloadBean, LocalVideoDetailViewModel localVideoDetailViewModel, Continuation<? super LocalVideoDetailViewModel$getSeriesFromLocal$1> continuation) {
        super(2, continuation);
        this.$curBean = downloadBean;
        this.this$0 = localVideoDetailViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailViewModel$getSeriesFromLocal$1(this.$curBean, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            DownloadEsHelper a = DownloadEsHelper.m.a();
            DownloadBean downloadBean = this.$curBean;
            if (downloadBean == null || (str = downloadBean.getSubjectId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            this.label = 1;
            obj = a.H(str, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            LocalVideoDetailViewModel localVideoDetailViewModel = this.this$0;
            DownloadBean downloadBean2 = this.$curBean;
            int i2 = 0;
            for (Object obj2 : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.u();
                }
                DownloadBean downloadBean3 = (DownloadBean) obj2;
                a.a aVar = wf.a.a;
                str2 = localVideoDetailViewModel.a;
                a.a.f(aVar, str2, "on get series, episode = " + downloadBean3.getEpse() + ", cur epse = " + (downloadBean2 != null ? downloadBean2.getEpse() : -1) + ", index = " + i2, false, 4, (Object) null);
                if (downloadBean3.isSeries()) {
                    if (!Intrinsics.c(downloadBean2 != null ? downloadBean2.getResourceId() : null, downloadBean3.getResourceId())) {
                        downloadBean3.setPlaying(false);
                    }
                    arrayList.add(downloadBean3);
                }
                i2 = i3;
            }
        }
        this.this$0.i().n(arrayList);
        return Unit.a;
    }
}
