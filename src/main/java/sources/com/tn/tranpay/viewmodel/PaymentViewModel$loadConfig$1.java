package com.tn.tranpay.viewmodel;

import com.google.gson.Gson;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lh.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel$loadConfig$1", f = "PaymentViewModel.kt", l = {121}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class PaymentViewModel$loadConfig$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BillingParams $params;
    int label;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaymentViewModel$loadConfig$1(PaymentViewModel paymentViewModel, BillingParams billingParams, Continuation<? super PaymentViewModel$loadConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentViewModel;
        this.$params = billingParams;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentViewModel$loadConfig$1(this.this$0, this.$params, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Gson gson;
        Map<String, String> h;
        List<MediumInputBean> medium;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            PaymentViewModel paymentViewModel = this.this$0;
            String txnId = this.$params.getTxnId();
            String language = this.$params.getLanguage();
            this.label = 1;
            obj = paymentViewModel.F(txnId, language, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        LoadConfigContent loadConfigContent = (LoadConfigContent) obj;
        a aVar = a.a;
        gson = this.this$0.l;
        a.g(aVar, "GetPaymentMethods result = " + gson.toJson(loadConfigContent), null, 2, null);
        if (loadConfigContent == null || (h = loadConfigContent.getLanguagePackage()) == null) {
            h = MapsKt.h();
        }
        if (loadConfigContent != null && (medium = loadConfigContent.getMedium()) != null) {
            for (MediumInputBean mediumInputBean : medium) {
                a.c(a.a, "The medium.name: " + mediumInputBean.getName() + ", " + mediumInputBean.getCode(), null, 2, null);
                List<InputInfoBean> inputs = mediumInputBean.getInputs();
                if (inputs != null) {
                    for (InputInfoBean inputInfoBean : inputs) {
                        String str = h.get(inputInfoBean.getTips());
                        String str2 = h.get(inputInfoBean.getHint());
                        a.c(a.a, "InputTip: " + str + ", hint: " + str2, null, 2, null);
                        String realHint = inputInfoBean.getRealHint();
                        if (realHint != null) {
                            str2 = realHint;
                        } else if (str2 == null) {
                            str2 = inputInfoBean.getHint();
                        }
                        inputInfoBean.setRealHint(str2);
                        String realTips = inputInfoBean.getRealTips();
                        if (realTips != null) {
                            str = realTips;
                        } else if (str == null) {
                            str = inputInfoBean.getTips();
                        }
                        inputInfoBean.setRealTips(str);
                    }
                }
            }
        }
        if (loadConfigContent != null) {
            this.this$0.q().n(loadConfigContent);
        } else {
            this.this$0.q().n((Object) null);
        }
        return Unit.a;
    }
}
