package com.transsion.shorttv.subtitle.manager;

import com.transsion.gslb.BuildConfig;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.subtitle.manager.ShortTvVideoSubtitleManagerImp$resDownloadListener$1$deleteSubtitle$1", f = "ShortTvVideoSubtitleManagerImp.kt", l = {111}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTvVideoSubtitleManagerImp$resDownloadListener$1$deleteSubtitle$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subtitleResId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortTvVideoSubtitleManagerImp$resDownloadListener$1$deleteSubtitle$1(String str, Continuation<? super ShortTvVideoSubtitleManagerImp$resDownloadListener$1$deleteSubtitle$1> continuation) {
        super(2, continuation);
        this.$subtitleResId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTvVideoSubtitleManagerImp$resDownloadListener$1$deleteSubtitle$1(this.$subtitleResId, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            SubtitleDownloadManager subtitleDownloadManager = SubtitleDownloadManager.a;
            String str = this.$subtitleResId;
            this.label = 1;
            if (subtitleDownloadManager.c(str, this) == f) {
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
