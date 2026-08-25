package com.transsion.shorttv.subtitle.manager;

import com.transsion.gslb.BuildConfig;
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
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.subtitle.manager.ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1", f = "ShortTvVideoSubtitleManagerImp.kt", l = {82}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ xr.a $bean;
    final /* synthetic */ boolean $isSuccess;
    int label;
    final /* synthetic */ ShortTvVideoSubtitleManagerImp this$0;
    final /* synthetic */ ShortTvVideoSubtitleManagerImp$resDownloadListener$1 this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(ShortTvVideoSubtitleManagerImp shortTvVideoSubtitleManagerImp, xr.a aVar, boolean z, ShortTvVideoSubtitleManagerImp$resDownloadListener$1 shortTvVideoSubtitleManagerImp$resDownloadListener$1, Continuation<? super ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTvVideoSubtitleManagerImp;
        this.$bean = aVar;
        this.$isSuccess = z;
        this.this$1 = shortTvVideoSubtitleManagerImp$resDownloadListener$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(this.this$0, this.$bean, this.$isSuccess, this.this$1, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean f;
        String str;
        String str2;
        String str3;
        Object f2 = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            ShortTvVideoSubtitleManagerImp shortTvVideoSubtitleManagerImp = this.this$0;
            String g = this.$bean.g();
            this.label = 1;
            obj = shortTvVideoSubtitleManagerImp.a(g, this);
            if (obj == f2) {
                return f2;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        String str4 = this.$isSuccess ? "下载完成" : "资源继续下载";
        if (list.isEmpty()) {
            a.a aVar = wf.a.a;
            str3 = this.this$0.c;
            aVar.u("short_tv_subtitle", str3 + " " + str4 + "，数据库为空，执行检测 titleName:" + this.$bean.h() + ", ep:" + this.$bean.a() + " se:" + this.$bean.c(), true);
            ShortTvVideoSubtitleManagerImp.n(this.this$0, this.$bean, null, 2, null);
        } else {
            f = this.this$1.f(list);
            if (f) {
                a.a aVar2 = wf.a.a;
                str2 = this.this$0.c;
                aVar2.u("short_tv_subtitle", str2 + " " + str4 + "，有失败，执行检测 titleName:" + this.$bean.h() + ", ep:" + this.$bean.a() + " se:" + this.$bean.c(), true);
                ShortTvVideoSubtitleManagerImp.n(this.this$0, this.$bean, null, 2, null);
            } else {
                a.a aVar3 = wf.a.a;
                str = this.this$0.c;
                aVar3.u("short_tv_subtitle", str + " " + str4 + "，有字幕无需检测 titleName:" + this.$bean.h() + ", ep:" + this.$bean.a() + " se:" + this.$bean.c(), true);
            }
        }
        return Unit.a;
    }
}
