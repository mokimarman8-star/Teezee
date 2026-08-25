package com.tn.tranpay.fragment;

import com.tn.tranpay.helper.PaymentMMKV;
import com.tn.tranpay.viewmodel.PaymentViewModel;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.fragment.PaySubFragment$setupPayButtonListener$1$1", f = "PaySubFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class PaySubFragment$setupPayButtonListener$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PaySubFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaySubFragment$setupPayButtonListener$1$1(PaySubFragment paySubFragment, Continuation<? super PaySubFragment$setupPayButtonListener$1$1> continuation) {
        super(2, continuation);
        this.this$0 = paySubFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaySubFragment$setupPayButtonListener$1$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        rg.b bVar;
        rg.b bVar2;
        PaymentViewModel i0;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        z = this.this$0.isPayable;
        if (!z) {
            return Unit.a;
        }
        this.this$0.isPayable = false;
        bVar = this.this$0.viewBinding;
        rg.b bVar3 = null;
        if (bVar == null) {
            Intrinsics.y("viewBinding");
            bVar = null;
        }
        String valueOf = String.valueOf(bVar.e.getText());
        bVar2 = this.this$0.viewBinding;
        if (bVar2 == null) {
            Intrinsics.y("viewBinding");
        } else {
            bVar3 = bVar2;
        }
        String valueOf2 = String.valueOf(bVar3.d.getText());
        PaymentMMKV paymentMMKV = PaymentMMKV.a;
        paymentMMKV.h().putString("k_phone_number", valueOf);
        paymentMMKV.h().putString("k_cnic_number", valueOf2);
        i0 = this.this$0.i0();
        PaymentViewModel.k(i0, this.this$0.getPayMethodCode(), valueOf, valueOf2, false, 8, null);
        return Unit.a;
    }
}
