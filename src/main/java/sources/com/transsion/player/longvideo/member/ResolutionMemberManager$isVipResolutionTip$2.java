package com.transsion.player.longvideo.member;

import com.transsion.baselib.db.member.MemberResolutionBean;
import com.transsion.baselib.db.member.MemberResolutionDao;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)Z"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.member.ResolutionMemberManager$isVipResolutionTip$2", f = "ResolutionMemberManager.kt", l = {43}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ResolutionMemberManager$isVipResolutionTip$2 extends SuspendLambda implements Function2<n0, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ln.a $curBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ResolutionMemberManager$isVipResolutionTip$2(ln.a aVar, Continuation<? super ResolutionMemberManager$isVipResolutionTip$2> continuation) {
        super(2, continuation);
        this.$curBean = aVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResolutionMemberManager$isVipResolutionTip$2(this.$curBean, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Boolean> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        MemberResolutionDao e;
        Boolean vipResolutionTip;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            e = ResolutionMemberManager.a.e();
            String o = this.$curBean.o();
            int l = this.$curBean.l();
            int e2 = this.$curBean.e();
            this.label = 1;
            obj = e.b(o, l, e2, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        MemberResolutionBean memberResolutionBean = (MemberResolutionBean) obj;
        return Boxing.a((memberResolutionBean == null || (vipResolutionTip = memberResolutionBean.getVipResolutionTip()) == null) ? false : vipResolutionTip.booleanValue());
    }
}
