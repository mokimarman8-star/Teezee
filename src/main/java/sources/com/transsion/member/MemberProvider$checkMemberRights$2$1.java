package com.transsion.member;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.memberapi.MemberCheckResult;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.member.MemberProvider$checkMemberRights$2$1", f = "MemberProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MemberProvider$checkMemberRights$2$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<MemberCheckResult, Unit> $callback;
    final /* synthetic */ BaseDto<MemberCheckResult> $result;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MemberProvider$checkMemberRights$2$1(Function1<? super MemberCheckResult, Unit> function1, BaseDto<MemberCheckResult> baseDto, Continuation<? super MemberProvider$checkMemberRights$2$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.$result = baseDto;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberProvider$checkMemberRights$2$1(this.$callback, this.$result, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Function1<MemberCheckResult, Unit> function1 = this.$callback;
        BaseDto<MemberCheckResult> baseDto = this.$result;
        function1.invoke(baseDto != null ? (MemberCheckResult) baseDto.getData() : null);
        return Unit.a;
    }
}
