package com.transsion.player.longvideo.ui.dialog;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1", f = "LongVodPlayerViewAdHelper.kt", l = {359, 361}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, Continuation<? super LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerViewAdHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        VideoDetailPlayDao S3;
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            LongVodPlayerViewAdHelper longVodPlayerViewAdHelper2 = this.this$0;
            this.label = 1;
            obj = longVodPlayerViewAdHelper2.R3(this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                longVodPlayerViewAdHelper = (LongVodPlayerViewAdHelper) this.L$0;
                ResultKt.b(obj);
                longVodPlayerViewAdHelper.I1(false);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        VideoDetailPlayBean videoDetailPlayBean = (VideoDetailPlayBean) obj;
        if (videoDetailPlayBean != null) {
            LongVodPlayerViewAdHelper longVodPlayerViewAdHelper3 = this.this$0;
            videoDetailPlayBean.setLastAdStartTimeStamp(Boxing.e(System.currentTimeMillis()));
            S3 = longVodPlayerViewAdHelper3.S3();
            this.L$0 = longVodPlayerViewAdHelper3;
            this.label = 2;
            if (S3.p(videoDetailPlayBean, this) == f) {
                return f;
            }
            longVodPlayerViewAdHelper = longVodPlayerViewAdHelper3;
            longVodPlayerViewAdHelper.I1(false);
        }
        return Unit.a;
    }
}
