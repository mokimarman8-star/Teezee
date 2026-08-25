package com.transsnet.downloader;

import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$removePlayAvailable$1", f = "DownloadManagerApi.kt", l = {868}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadManagerApi$removePlayAvailable$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSeries;
    final /* synthetic */ boolean $needNotify;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ String $subjectId;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ DownloadManagerApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadManagerApi$removePlayAvailable$1(String str, DownloadManagerApi downloadManagerApi, boolean z, String str2, boolean z2, Continuation<? super DownloadManagerApi$removePlayAvailable$1> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.this$0 = downloadManagerApi;
        this.$needNotify = z;
        this.$resourceId = str2;
        this.$isSeries = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$removePlayAvailable$1(this.$subjectId, this.this$0, this.$needNotify, this.$resourceId, this.$isSeries, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerApi$removePlayAvailable$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        String str;
        DownloadManagerApi downloadManagerApi;
        boolean z;
        boolean z2;
        String str2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            str = this.$subjectId;
            if (str == null) {
                return null;
            }
            downloadManagerApi = this.this$0;
            z = this.$needNotify;
            String str3 = this.$resourceId;
            boolean z3 = this.$isSeries;
            DownloadEsHelper a = DownloadEsHelper.m.a();
            this.L$0 = downloadManagerApi;
            this.L$1 = str;
            this.L$2 = str3;
            this.Z$0 = z;
            this.Z$1 = z3;
            this.label = 1;
            Object o = a.o(str, this);
            if (o == f) {
                return f;
            }
            z2 = z3;
            str2 = str3;
            obj = o;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z2 = this.Z$1;
            z = this.Z$0;
            str2 = (String) this.L$2;
            str = (String) this.L$1;
            downloadManagerApi = (DownloadManagerApi) this.L$0;
            ResultKt.b(obj);
        }
        List list = (List) obj;
        if ((list != null ? list.size() : -1) <= 0) {
            DownloadManagerApi.x(downloadManagerApi).remove(str);
            if (z) {
                AddToDownloadEvent addToDownloadEvent = new AddToDownloadEvent(str, str2, false, z2);
                FlowEventBus applicationScopeViewModel = AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = AddToDownloadEvent.class.getName();
                Intrinsics.g(name, "getName(...)");
                applicationScopeViewModel.postEvent(name, addToDownloadEvent, 0L);
            }
        }
        return Unit.a;
    }
}
