package com.transsion.commercialization.task.treasure;

import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import com.transsion.memberapi.MemberSource;
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
@DebugMetadata(c = "com.transsion.commercialization.task.treasure.TreasureStyleADialog$typeMember$1$1$1$1", f = "TreasureStyleADialog.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TreasureStyleADialog$typeMember$1$1$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TreasureStyleADialog this$0;

    public static final class a implements im.c {
        final /* synthetic */ TreasureStyleADialog a;

        a(TreasureStyleADialog treasureStyleADialog) {
            this.a = treasureStyleADialog;
        }

        @Override // im.c
        public void a() {
            wj.h.a.a(this.a.getClassTag() + " --> typeMember() --> 开通会员失败");
        }

        @Override // im.c
        public void onSuccess() {
            wj.g gVar = this.a.listener;
            if (gVar != null) {
                gVar.onSuccess();
            }
            this.a.dismissAllowingStateLoss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TreasureStyleADialog$typeMember$1$1$1$1(TreasureStyleADialog treasureStyleADialog, Continuation<? super TreasureStyleADialog$typeMember$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = treasureStyleADialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TreasureStyleADialog$typeMember$1$1$1$1(this.this$0, continuation);
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
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            im.b$a.c(bVar, this.this$0.getActivity(), MemberSource.THREE_IN_ONE_POPUP, new a(this.this$0), false, null, 24, null);
        }
        return Unit.a;
    }
}
