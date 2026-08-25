package com.transsion.player.longvideo.member;

import com.therouter.TheRouter;
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
@DebugMetadata(c = "com.transsion.player.longvideo.member.ResolutionMemberManager$isUnlock$2", f = "ResolutionMemberManager.kt", l = {83}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ResolutionMemberManager$isUnlock$2 extends SuspendLambda implements Function2<n0, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ln.a $curBean;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ResolutionMemberManager$isUnlock$2(ln.a aVar, Continuation<? super ResolutionMemberManager$isUnlock$2> continuation) {
        super(2, continuation);
        this.$curBean = aVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResolutionMemberManager$isUnlock$2(this.$curBean, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Boolean> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        MemberResolutionDao e;
        int i;
        String d;
        Boolean isUnlock;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.b(obj);
            im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
            int m = bVar != null ? bVar.m() : 0;
            e = ResolutionMemberManager.a.e();
            String o = this.$curBean.o();
            int l = this.$curBean.l();
            int e2 = this.$curBean.e();
            this.I$0 = m;
            this.label = 1;
            Object b = e.b(o, l, e2, this);
            if (b == f) {
                return f;
            }
            i = m;
            obj = b;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            ResultKt.b(obj);
        }
        MemberResolutionBean memberResolutionBean = (MemberResolutionBean) obj;
        boolean booleanValue = (memberResolutionBean == null || (isUnlock = memberResolutionBean.isUnlock()) == null) ? false : isUnlock.booleanValue();
        k kVar = k.a;
        d = ResolutionMemberManager.a.d();
        kVar.a(d + " --> isUnlock() --> 是否已经解锁过 = " + (i != 0 || booleanValue) + " --> subjectId = " + this.$curBean.o() + " ep = " + this.$curBean.l() + " se = " + this.$curBean.e() + " --> isUnlock = " + booleanValue + " --> isMember = " + (i != 0));
        if (i == 0 && !booleanValue) {
            z = false;
        }
        return Boxing.a(z);
    }
}
