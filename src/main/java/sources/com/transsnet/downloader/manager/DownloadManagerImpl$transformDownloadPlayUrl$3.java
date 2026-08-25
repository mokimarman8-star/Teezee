package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/String;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$transformDownloadPlayUrl$3", f = "DownloadManagerImpl.kt", l = {1598}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DownloadManagerImpl$transformDownloadPlayUrl$3 extends SuspendLambda implements Function2<n0, Continuation<? super String>, Object> {
    final /* synthetic */ int $ep;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadManagerImpl$transformDownloadPlayUrl$3(String str, int i, String str2, DownloadManagerImpl downloadManagerImpl, Continuation<? super DownloadManagerImpl$transformDownloadPlayUrl$3> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$ep = i;
        this.$url = str2;
        this.this$0 = downloadManagerImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$transformDownloadPlayUrl$3(this.$subjectId, this.$ep, this.$url, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super String> continuation) {
        return ((DownloadManagerImpl$transformDownloadPlayUrl$3) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DownloadBean x;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            DownloadEsHelper$a downloadEsHelper$a = DownloadEsHelper.m;
            x = downloadEsHelper$a.a().x(this.$subjectId, this.$ep);
            if (x == null) {
                DownloadEsHelper a = downloadEsHelper$a.a();
                String str = this.$subjectId;
                int i2 = this.$ep;
                this.label = 1;
                obj = a.w(str, i2, this);
                if (obj == f) {
                    return f;
                }
            }
            if (x != null) {
                return this.$url;
            }
            if (x.isCompleted()) {
                String path = x.getPath();
                return (path == null || path.length() == 0) ? this.$url : x.getPath();
            }
            this.this$0.l(x);
            return this.$url;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        x = (DownloadBean) obj;
        if (x != null) {
        }
    }
}
