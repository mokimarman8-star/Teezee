package com.transsion.player.longvideo.member;

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
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.member.ResolutionMemberManager$showRewardDialog$1$1$onActivate$1", f = "ResolutionMemberManager.kt", l = {156, 159}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ResolutionMemberManager$showRewardDialog$1$1$onActivate$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isActivate;
    final /* synthetic */ nw.e $listener;
    final /* synthetic */ ln.a $longVdPlayerBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ResolutionMemberManager$showRewardDialog$1$1$onActivate$1(boolean z, ln.a aVar, nw.e eVar, Continuation<? super ResolutionMemberManager$showRewardDialog$1$1$onActivate$1> continuation) {
        super(2, continuation);
        this.$isActivate = z;
        this.$longVdPlayerBean = aVar;
        this.$listener = eVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResolutionMemberManager$showRewardDialog$1$1$onActivate$1(this.$isActivate, this.$longVdPlayerBean, this.$listener, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        nw.e eVar;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            if (this.$isActivate) {
                ResolutionMemberManager resolutionMemberManager = ResolutionMemberManager.a;
                ln.a aVar = this.$longVdPlayerBean;
                this.label = 1;
                if (resolutionMemberManager.j(aVar, this) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                eVar = this.$listener;
                if (eVar != null) {
                    eVar.a(this.$isActivate);
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        this.label = 2;
        if (u0.a(500L, this) == f) {
            return f;
        }
        eVar = this.$listener;
        if (eVar != null) {
        }
        return Unit.a;
    }
}
