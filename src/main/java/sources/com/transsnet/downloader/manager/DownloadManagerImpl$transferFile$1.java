package com.transsnet.downloader.manager;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.util.DownloadUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;
import ui.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$transferFile$1", f = "DownloadManagerImpl.kt", l = {1201}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadManagerImpl$transferFile$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $downloadInfo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadManagerImpl$transferFile$1(DownloadBean downloadBean, Continuation<? super DownloadManagerImpl$transferFile$1> continuation) {
        super(2, continuation);
        this.$downloadInfo = downloadBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$transferFile$1(this.$downloadInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$transferFile$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            DownloadUtil downloadUtil = DownloadUtil.a;
            Application a = Utils.a();
            Intrinsics.g(a, "getApp(...)");
            DownloadBean downloadBean = this.$downloadInfo;
            b.a aVar = b.a;
            String e = aVar.e();
            String rootPath = this.$downloadInfo.getRootPath();
            if (rootPath == null) {
                rootPath = aVar.e();
            }
            int rootPathType = this.$downloadInfo.getRootPathType();
            this.label = 1;
            if (DownloadUtil.K(downloadUtil, a, true, downloadBean, e, 1, rootPath, rootPathType, (Function2) null, (Function1) null, true, this, 384, (Object) null) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
