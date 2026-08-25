package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadByResId$2", f = "DownloadManagerImpl.kt", l = {951}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadManagerImpl$getDownloadByResId$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<DownloadBean, Unit> $callback;
    final /* synthetic */ Ref.ObjectRef<DownloadBean> $downloadInfo;
    final /* synthetic */ String $resourceId;
    Object L$0;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadManagerImpl$getDownloadByResId$2(Ref.ObjectRef<DownloadBean> objectRef, String str, Function1<? super DownloadBean, Unit> function1, DownloadManagerImpl downloadManagerImpl, Continuation<? super DownloadManagerImpl$getDownloadByResId$2> continuation) {
        super(2, continuation);
        this.$downloadInfo = objectRef;
        this.$resourceId = str;
        this.$callback = function1;
        this.this$0 = downloadManagerImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$getDownloadByResId$2(this.$downloadInfo, this.$resourceId, this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$getDownloadByResId$2) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef<DownloadBean> objectRef;
        DownloadBean downloadBean;
        Ref.ObjectRef<DownloadBean> objectRef2;
        DownloadBean downloadBean2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            objectRef = this.$downloadInfo;
            if (objectRef.element == null) {
                String str = this.$resourceId;
                if (str != null) {
                    DownloadEsHelper a = DownloadEsHelper.m.a();
                    this.L$0 = objectRef;
                    this.label = 1;
                    Object p = a.p(str, this);
                    if (p == f) {
                        return f;
                    }
                    objectRef2 = objectRef;
                    obj = p;
                } else {
                    downloadBean = null;
                    objectRef.element = downloadBean;
                    downloadBean2 = (DownloadBean) this.$downloadInfo.element;
                    if (downloadBean2 != null) {
                        DownloadManagerImpl downloadManagerImpl = this.this$0;
                        if (!DownloadManagerImpl.W(downloadManagerImpl).contains(downloadBean2)) {
                            DownloadManagerImpl.W(downloadManagerImpl).add(downloadBean2);
                        }
                    }
                }
            }
            this.$callback.invoke(this.$downloadInfo.element);
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2 = (Ref.ObjectRef) this.L$0;
        ResultKt.b(obj);
        Ref.ObjectRef<DownloadBean> objectRef3 = objectRef2;
        downloadBean = (DownloadBean) obj;
        objectRef = objectRef3;
        objectRef.element = downloadBean;
        downloadBean2 = (DownloadBean) this.$downloadInfo.element;
        if (downloadBean2 != null) {
        }
        this.$callback.invoke(this.$downloadInfo.element);
        return Unit.a;
    }
}
