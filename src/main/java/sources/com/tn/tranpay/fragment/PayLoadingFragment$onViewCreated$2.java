package com.tn.tranpay.fragment;

import com.blankj.utilcode.util.NetworkUtils;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.viewmodel.PaymentViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.fragment.PayLoadingFragment$onViewCreated$2", f = "PayLoadingFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class PayLoadingFragment$onViewCreated$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PayLoadingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayLoadingFragment$onViewCreated$2(PayLoadingFragment payLoadingFragment, Continuation<? super PayLoadingFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = payLoadingFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PayLoadingFragment$onViewCreated$2(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        PaymentViewModel paymentViewModel;
        BillingParams f0;
        PaymentViewModel paymentViewModel2;
        BillingParams f02;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (NetworkUtils.n()) {
            paymentViewModel = this.this$0.viewModel;
            f0 = this.this$0.f0();
            paymentViewModel.P(f0.getTxnId());
            paymentViewModel2 = this.this$0.viewModel;
            f02 = this.this$0.f0();
            paymentViewModel2.l(f02);
        } else {
            PayLoadingFragment.e0(this.this$0, -2, "No network connection", null, 4, null);
        }
        return Unit.a;
    }
}
