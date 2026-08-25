package com.transsion.player.longvideo.ui.dialog;

import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.longvideo.constants.LongVodContentType;
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
@DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$setLongVdPlayerBean$1", f = "LongVodPlayerViewAdHelper.kt", l = {178}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodPlayerViewAdHelper$setLongVdPlayerBean$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ln.a $bean;
    final /* synthetic */ LongVodContentType $contextType;
    Object L$0;
    int label;
    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodPlayerViewAdHelper$setLongVdPlayerBean$1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, ln.a aVar, LongVodContentType longVodContentType, Continuation<? super LongVodPlayerViewAdHelper$setLongVdPlayerBean$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerViewAdHelper;
        this.$bean = aVar;
        this.$contextType = longVodContentType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerViewAdHelper$setLongVdPlayerBean$1(this.this$0, this.$bean, this.$contextType, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        VideoDetailPlayDao S3;
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper;
        VideoDetailPlayBean videoDetailPlayBean;
        VideoDetailPlayBean videoDetailPlayBean2;
        String str;
        Long lastAdEndTimeStamp;
        Long lastAdStartTimeStamp;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.this$0.S = this.$bean;
            LongVodPlayerViewAdHelper longVodPlayerViewAdHelper2 = this.this$0;
            S3 = longVodPlayerViewAdHelper2.S3();
            String o = this.$bean.o();
            int l = this.$bean.l();
            int e = this.$bean.e();
            this.L$0 = longVodPlayerViewAdHelper2;
            this.label = 1;
            Object l2 = S3.l(o, l, e, this);
            if (l2 == f) {
                return f;
            }
            longVodPlayerViewAdHelper = longVodPlayerViewAdHelper2;
            obj = l2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            longVodPlayerViewAdHelper = (LongVodPlayerViewAdHelper) this.L$0;
            ResultKt.b(obj);
        }
        longVodPlayerViewAdHelper.T = (VideoDetailPlayBean) obj;
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper3 = this.this$0;
        videoDetailPlayBean = longVodPlayerViewAdHelper3.T;
        long j = 0;
        long longValue = (videoDetailPlayBean == null || (lastAdStartTimeStamp = videoDetailPlayBean.getLastAdStartTimeStamp()) == null) ? 0L : lastAdStartTimeStamp.longValue();
        videoDetailPlayBean2 = this.this$0.T;
        if (videoDetailPlayBean2 != null && (lastAdEndTimeStamp = videoDetailPlayBean2.getLastAdEndTimeStamp()) != null) {
            j = lastAdEndTimeStamp.longValue();
        }
        longVodPlayerViewAdHelper3.D0(longValue, j);
        if (ij.o.a.g() || ij.g.a.b()) {
            this.this$0.I1(false);
            this.this$0.H1(false);
        }
        this.this$0.h1();
        if (this.$contextType != LongVodContentType.UGC_VIDEO_LOCAL) {
            this.this$0.W3(this.$bean);
            LongVodPlayerViewAdHelper longVodPlayerViewAdHelper4 = this.this$0;
            str = longVodPlayerViewAdHelper4.Q;
            longVodPlayerViewAdHelper4.F0(str);
        }
        return Unit.a;
    }
}
