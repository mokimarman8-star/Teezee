package com.transsion.commercialization.task.treasure;

import com.therouter.TheRouter;
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
import wj.f$a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.task.treasure.TreasureStyleADialog$typePay$1$1$2$1$1$success$1", f = "TreasureStyleADialog.kt", l = {274}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TreasureStyleADialog$typePay$1$1$2$1$1$success$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    int label;
    final /* synthetic */ TreasureStyleADialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TreasureStyleADialog$typePay$1$1$2$1$1$success$1(String str, TreasureStyleADialog treasureStyleADialog, Continuation<? super TreasureStyleADialog$typePay$1$1$2$1$1$success$1> continuation) {
        super(2, continuation);
        this.$orderId = str;
        this.this$0 = treasureStyleADialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TreasureStyleADialog$typePay$1$1$2$1$1$success$1(this.$orderId, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            wj.f fVar = (wj.f) TheRouter.d(wj.f.class, new Object[0]);
            if (fVar != null) {
                String str = this.$orderId;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                this.label = 1;
                if (f$a.a(fVar, BuildConfig.FLAVOR, str, false, this, 4, null) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.this$0.dismissAllowingStateLoss();
        return Unit.a;
    }
}
