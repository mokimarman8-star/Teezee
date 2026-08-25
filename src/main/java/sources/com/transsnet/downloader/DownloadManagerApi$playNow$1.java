package com.transsnet.downloader;

import android.content.Context;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$playNow$1", f = "DownloadManagerApi.kt", l = {912}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadManagerApi$playNow$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $pageFrom;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ String $subjectId;
    int label;
    final /* synthetic */ DownloadManagerApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadManagerApi$playNow$1(String str, DownloadManagerApi downloadManagerApi, Context context, String str2, String str3, Continuation<? super DownloadManagerApi$playNow$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.this$0 = downloadManagerApi;
        this.$context = context;
        this.$pageFrom = str2;
        this.$resourceId = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(DownloadManagerApi downloadManagerApi, Context context, String str, DownloadBean downloadBean) {
        DownloadManagerApi.F(downloadManagerApi, downloadBean);
        DownloadBean w = DownloadManagerApi.w(downloadManagerApi);
        if (w == null || !w.isVideo()) {
            DownloadManagerApi.E(downloadManagerApi, context);
        } else {
            DownloadManagerApi.D(downloadManagerApi, context, str);
        }
        return Unit.a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$playNow$1(this.$subjectId, this.this$0, this.$context, this.$pageFrom, this.$resourceId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerApi$playNow$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            if (this.$subjectId == null) {
                com.transsnet.downloader.manager.g z = DownloadManagerApi.z(this.this$0);
                String str = this.$resourceId;
                final DownloadManagerApi downloadManagerApi = this.this$0;
                final Context context = this.$context;
                final String str2 = this.$pageFrom;
                z.r(str, new Function1() { // from class: com.transsnet.downloader.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit d;
                        d = DownloadManagerApi$playNow$1.d(downloadManagerApi, context, str2, (DownloadBean) obj2);
                        return d;
                    }
                });
                return Unit.a;
            }
            com.transsnet.downloader.manager.g z2 = DownloadManagerApi.z(this.this$0);
            String str3 = this.$subjectId;
            this.label = 1;
            obj = z2.e(str3, this);
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
        List I0 = list != null ? CollectionsKt.I0(list, new Comparator() { // from class: com.transsnet.downloader.DownloadManagerApi$playNow$1$invokeSuspend$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.d(Integer.valueOf(((DownloadBean) t).getEp()), Integer.valueOf(((DownloadBean) t2).getEp()));
            }
        }) : null;
        if (I0 != null && !I0.isEmpty()) {
            DownloadManagerApi.F(this.this$0, (DownloadBean) I0.get(0));
            if (DownloadManagerApi.w(this.this$0) == null) {
                return Unit.a;
            }
            DownloadBean w = DownloadManagerApi.w(this.this$0);
            if (w == null || !w.isVideo()) {
                DownloadManagerApi.E(this.this$0, this.$context);
            } else {
                DownloadManagerApi.D(this.this$0, this.$context, this.$pageFrom);
            }
        }
        return Unit.a;
    }
}
