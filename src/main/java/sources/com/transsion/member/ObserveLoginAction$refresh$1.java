package com.transsion.member;

import com.transsion.gslb.BuildConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.member.ObserveLoginAction$refresh$1", f = "ObserveLoginAction.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ObserveLoginAction$refresh$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObserveLoginAction this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ObserveLoginAction$refresh$1(ObserveLoginAction observeLoginAction, Continuation<? super ObserveLoginAction$refresh$1> continuation) {
        super(2, continuation);
        this.this$0 = observeLoginAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ObserveLoginAction$refresh$1(this.this$0, continuation);
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
        Iterator it = ObserveLoginAction.d(this.this$0).iterator();
        while (it.hasNext()) {
            ((im.f) it.next()).onMemberStateChange();
        }
        return Unit.a;
    }
}
