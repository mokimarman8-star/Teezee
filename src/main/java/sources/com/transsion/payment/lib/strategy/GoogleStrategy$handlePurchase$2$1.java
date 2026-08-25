package com.transsion.payment.lib.strategy;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.CheckPaymentBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$handlePurchase$2$1", f = "GoogleStrategy.kt", l = {289}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class GoogleStrategy$handlePurchase$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $gpOrderId;
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $productId;
    final /* synthetic */ String $purchaseToken;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleStrategy$handlePurchase$2$1(GoogleStrategy googleStrategy, String str, String str2, String str3, String str4, Continuation<? super GoogleStrategy$handlePurchase$2$1> continuation) {
        super(1, continuation);
        this.this$0 = googleStrategy;
        this.$productId = str;
        this.$purchaseToken = str2;
        this.$orderId = str3;
        this.$gpOrderId = str4;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new GoogleStrategy$handlePurchase$2$1(this.this$0, this.$productId, this.$purchaseToken, this.$orderId, this.$gpOrderId, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        PaymentService z;
        com.transsion.payment.lib.b bVar;
        com.transsion.payment.lib.b bVar2;
        com.transsion.payment.lib.b bVar3;
        String str;
        String addCoin;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            z = this.this$0.z();
            String str2 = this.$productId;
            String str3 = this.$purchaseToken;
            String str4 = this.$orderId;
            String str5 = this.$gpOrderId;
            this.label = 1;
            obj = z.g(str2, str3, str4, str5, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        BaseDto baseDto = (BaseDto) obj;
        if (!Intrinsics.c(baseDto != null ? baseDto.getCode() : null, "0")) {
            throw new Exception(baseDto != null ? baseDto.getMsg() : null);
        }
        bVar = this.this$0.j;
        int i2 = 0;
        if (bVar != null) {
            bVar.b(false);
        }
        com.transsion.payment.lib.d dVar = com.transsion.payment.lib.d.a;
        dVar.a("Will callback success");
        bVar2 = this.this$0.j;
        if (bVar2 != null) {
            CheckPaymentBean checkPaymentBean = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean != null && (addCoin = checkPaymentBean.getAddCoin()) != null) {
                i2 = Integer.parseInt(addCoin);
            }
            CheckPaymentBean checkPaymentBean2 = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean2 == null || (str = checkPaymentBean2.getBalanceCoin()) == null) {
                str = BuildConfig.FLAVOR;
            }
            bVar2.c(i2, str, this.$orderId);
        }
        bVar3 = this.this$0.j;
        dVar.a("Has callback " + bVar3);
        this.this$0.j = null;
        dVar.a("handlePurchase 发货成功");
        return Unit.a;
    }
}
