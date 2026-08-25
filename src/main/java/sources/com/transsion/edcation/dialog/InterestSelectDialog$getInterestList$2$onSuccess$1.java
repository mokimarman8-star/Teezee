package com.transsion.edcation.dialog;

import android.widget.ProgressBar;
import com.transsion.edcation.bean.InterestBean;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.dialog.InterestSelectDialog$getInterestList$2$onSuccess$1", f = "InterestSelectDialog.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class InterestSelectDialog$getInterestList$2$onSuccess$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<InterestBean> $list;
    int label;
    final /* synthetic */ InterestSelectDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InterestSelectDialog$getInterestList$2$onSuccess$1(InterestSelectDialog interestSelectDialog, List<InterestBean> list, Continuation<? super InterestSelectDialog$getInterestList$2$onSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = interestSelectDialog;
        this.$list = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InterestSelectDialog$getInterestList$2$onSuccess$1(this.this$0, this.$list, continuation);
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
        this.this$0.s0(this.$list);
        ProgressBar progressBar = InterestSelectDialog.p0(this.this$0).c;
        Intrinsics.g(progressBar, "loadView");
        uf.c.g(progressBar);
        return Unit.a;
    }
}
