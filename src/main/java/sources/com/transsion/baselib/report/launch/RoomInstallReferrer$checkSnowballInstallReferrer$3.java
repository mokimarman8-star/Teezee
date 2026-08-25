package com.transsion.baselib.report.launch;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baselib.report.launch.RoomInstallReferrer$checkSnowballInstallReferrer$3", f = "RoomInstallReferrer.kt", l = {166}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RoomInstallReferrer$checkSnowballInstallReferrer$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    RoomInstallReferrer$checkSnowballInstallReferrer$3(Continuation<? super RoomInstallReferrer$checkSnowballInstallReferrer$3> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RoomInstallReferrer$checkSnowballInstallReferrer$3 roomInstallReferrer$checkSnowballInstallReferrer$3 = new RoomInstallReferrer$checkSnowballInstallReferrer$3(continuation);
        roomInstallReferrer$checkSnowballInstallReferrer$3.L$0 = obj;
        return roomInstallReferrer$checkSnowballInstallReferrer$3;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                Result.Companion companion = Result.Companion;
                RoomInstallReferrer roomInstallReferrer = RoomInstallReferrer.a;
                this.label = 1;
                if (RoomInstallReferrer.d(roomInstallReferrer, this) == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        return Unit.a;
    }
}
