package com.transsion.subtitle;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle.VideoSubtitleManagerImp;
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
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subtitle.VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1", f = "VideoSubtitleManagerImp.kt", l = {94}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $bean;
    final /* synthetic */ boolean $isSuccess;
    int label;
    final /* synthetic */ VideoSubtitleManagerImp this$0;
    final /* synthetic */ VideoSubtitleManagerImp.resDownloadListener.1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(VideoSubtitleManagerImp videoSubtitleManagerImp, DownloadBean downloadBean, boolean z, VideoSubtitleManagerImp.resDownloadListener.1 r4, Continuation<? super VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1> continuation) {
        super(2, continuation);
        this.this$0 = videoSubtitleManagerImp;
        this.$bean = downloadBean;
        this.$isSuccess = z;
        this.this$1 = r4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(this.this$0, this.$bean, this.$isSuccess, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((VideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            VideoSubtitleManagerImp videoSubtitleManagerImp = this.this$0;
            String subtitleResId = this.$bean.getSubtitleResId();
            this.label = 1;
            obj = videoSubtitleManagerImp.a(subtitleResId, this);
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
        String str = this.$isSuccess ? "下载完成" : "资源继续下载";
        if (list.isEmpty()) {
            wf.a.a.u(com.transsion.baselib.report.a.a.a(), VideoSubtitleManagerImp.p(this.this$0) + " " + str + "，数据库为空，执行检测 titleName:" + this.$bean.getTitleName() + ", ep:" + this.$bean.getEp() + " se:" + this.$bean.getSe(), true);
            VideoSubtitleManagerImp.t(this.this$0, this.$bean, (Function1) null, 2, (Object) null);
        } else if (VideoSubtitleManagerImp.resDownloadListener.1.d(this.this$1, list)) {
            wf.a.a.u(com.transsion.baselib.report.a.a.a(), VideoSubtitleManagerImp.p(this.this$0) + " " + str + "，有失败，执行检测 titleName:" + this.$bean.getTitleName() + ", ep:" + this.$bean.getEp() + " se:" + this.$bean.getSe(), true);
            VideoSubtitleManagerImp.t(this.this$0, this.$bean, (Function1) null, 2, (Object) null);
        } else {
            wf.a.a.u(com.transsion.baselib.report.a.a.a(), VideoSubtitleManagerImp.p(this.this$0) + " " + str + "，有字幕无需检测 titleName:" + this.$bean.getTitleName() + ", ep:" + this.$bean.getEp() + " se:" + this.$bean.getSe(), true);
        }
        return Unit.a;
    }
}
