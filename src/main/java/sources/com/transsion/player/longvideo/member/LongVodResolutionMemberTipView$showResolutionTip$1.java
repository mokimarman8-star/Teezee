package com.transsion.player.longvideo.member;

import com.therouter.TheRouter;
import com.transsion.ad.strategy.t;
import com.transsion.gslb.BuildConfig;
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
@DebugMetadata(c = "com.transsion.player.longvideo.member.LongVodResolutionMemberTipView$showResolutionTip$1", f = "LongVodResolutionMemberTipView.kt", l = {144}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodResolutionMemberTipView$showResolutionTip$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ln.a $curBean;
    final /* synthetic */ boolean $hasAtLeast720P;
    final /* synthetic */ Integer $target;
    int label;
    final /* synthetic */ LongVodResolutionMemberTipView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodResolutionMemberTipView$showResolutionTip$1(ln.a aVar, LongVodResolutionMemberTipView longVodResolutionMemberTipView, boolean z, Integer num, Continuation<? super LongVodResolutionMemberTipView$showResolutionTip$1> continuation) {
        super(2, continuation);
        this.$curBean = aVar;
        this.this$0 = longVodResolutionMemberTipView;
        this.$hasAtLeast720P = z;
        this.$target = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodResolutionMemberTipView$showResolutionTip$1(this.$curBean, this.this$0, this.$hasAtLeast720P, this.$target, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String classTag;
        String classTag2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            ResolutionMemberManager resolutionMemberManager = ResolutionMemberManager.a;
            ln.a aVar = this.$curBean;
            this.label = 1;
            obj = resolutionMemberManager.g(aVar, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            wj.h hVar = wj.h.a;
            classTag2 = this.this$0.getClassTag();
            hVar.a(classTag2 + " --> showResolutionTip() --> 已出现过，不显示");
            return Unit.a;
        }
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        boolean m = bVar != null ? bVar.m() : false;
        if (!m && this.$hasAtLeast720P) {
            this.this$0.setVisibility(0);
            this.this$0.curBean = this.$curBean;
            t.a.j(this.this$0);
            this.this$0.e();
            wj.h hVar2 = wj.h.a;
            classTag = this.this$0.getClassTag();
            hVar2.a(classTag + " --> showResolutionTip() --> isMember = " + m + " --> 右下角提示 --> target = " + this.$target);
        }
        return Unit.a;
    }
}
