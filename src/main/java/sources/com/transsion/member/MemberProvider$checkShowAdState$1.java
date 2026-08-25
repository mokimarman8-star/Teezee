package com.transsion.member;

import com.tencent.mmkv.MMKV;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import mg.a;
import rh.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.member.MemberProvider$checkShowAdState$1", f = "MemberProvider.kt", l = {213}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class MemberProvider$checkShowAdState$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    int label;
    final /* synthetic */ MemberProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MemberProvider$checkShowAdState$1(MemberProvider memberProvider, Function0<Unit> function0, Continuation<? super MemberProvider$checkShowAdState$1> continuation) {
        super(2, continuation);
        this.this$0 = memberProvider;
        this.$callback = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(MemberProvider memberProvider, Function0 function0, MemberCheckResult memberCheckResult) {
        String T;
        List<String> vipAdScenes;
        String pointUrl;
        Integer multiDownloadLimit;
        String inviteH5Url;
        String inviteRewardDays;
        Boolean vipPayEnable;
        Boolean vipEnable;
        Boolean isPassed;
        String string;
        a aVar = a.a;
        T = memberProvider.T();
        MMKV c = a.a.c();
        String str = "";
        if (c != null && (string = c.getString("sp_code", "")) != null) {
            str = string;
        }
        aVar.a(T + " --> checkShowAdState() --> SP_CODE = " + str + " --> it = " + memberCheckResult);
        if (memberCheckResult != null && (isPassed = memberCheckResult.isPassed()) != null) {
            isPassed.booleanValue();
            w.a.b().putBoolean("kv_is_skip_ad", true);
            b.a.c(true);
        }
        if (memberCheckResult != null && (vipEnable = memberCheckResult.getVipEnable()) != null) {
            w.a.b().putBoolean("kv_is_enable_member", vipEnable.booleanValue());
        }
        if (memberCheckResult != null && (vipPayEnable = memberCheckResult.getVipPayEnable()) != null) {
            w.a.b().putBoolean("kv_is_pay_enable_member", vipPayEnable.booleanValue());
        }
        if (memberCheckResult != null && (inviteRewardDays = memberCheckResult.getInviteRewardDays()) != null) {
            w.a.b().putString("kv_invite_Reward_Days", inviteRewardDays);
        }
        if (memberCheckResult != null && (inviteH5Url = memberCheckResult.getInviteH5Url()) != null) {
            w.a.b().putString("kv_invite_H5_Url", inviteH5Url);
        }
        if (memberCheckResult != null && (multiDownloadLimit = memberCheckResult.getMultiDownloadLimit()) != null) {
            w.a.b().putInt("kv_parallel_download_task_num", multiDownloadLimit.intValue());
        }
        if (memberCheckResult != null && (pointUrl = memberCheckResult.getPointUrl()) != null) {
            w.a.b().putString("kv_point_url", pointUrl);
        }
        if (memberCheckResult != null && (vipAdScenes = memberCheckResult.getVipAdScenes()) != null) {
            b.a.a(vipAdScenes);
        }
        if (function0 != null) {
        }
        return Unit.a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberProvider$checkShowAdState$1(this.this$0, this.$callback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MemberProvider$checkShowAdState$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            MemberProvider memberProvider = this.this$0;
            MemberSceneType memberSceneType = MemberSceneType.SCENE_AD;
            Integer d = Boxing.d(0);
            final MemberProvider memberProvider2 = this.this$0;
            final Function0<Unit> function0 = this.$callback;
            Function1 function1 = new Function1() { // from class: com.transsion.member.c0
                public final Object invoke(Object obj2) {
                    Unit d2;
                    d2 = MemberProvider$checkShowAdState$1.d(MemberProvider.this, function0, (MemberCheckResult) obj2);
                    return d2;
                }
            };
            this.label = 1;
            if (memberProvider.b(memberSceneType, d, function1, this) == f) {
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
