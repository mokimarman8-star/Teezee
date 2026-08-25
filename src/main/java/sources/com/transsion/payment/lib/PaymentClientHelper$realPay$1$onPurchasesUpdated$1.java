package com.transsion.payment.lib;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.bean.CheckPaymentBean;
import com.transsion.payment.lib.bean.CreateOrderRes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.PaymentClientHelper$realPay$1$onPurchasesUpdated$1", f = "PaymentClientHelper.kt", l = {126}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PaymentClientHelper$realPay$1$onPurchasesUpdated$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreateOrderRes $orderRequest;
    final /* synthetic */ b $payCallback;
    final /* synthetic */ PaymentService $paymentService;
    int label;

    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.transsion.payment.lib.PaymentClientHelper$realPay$1$onPurchasesUpdated$1$1", f = "PaymentClientHelper.kt", l = {128}, m = "invokeSuspend")
    /* renamed from: com.transsion.payment.lib.PaymentClientHelper$realPay$1$onPurchasesUpdated$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ CreateOrderRes $orderRequest;
        final /* synthetic */ b $payCallback;
        final /* synthetic */ PaymentService $paymentService;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PaymentService paymentService, CreateOrderRes createOrderRes, b bVar, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$paymentService = paymentService;
            this.$orderRequest = createOrderRes;
            this.$payCallback = bVar;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$paymentService, this.$orderRequest, this.$payCallback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            String addCoin;
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                PaymentService paymentService = this.$paymentService;
                String tradingOrderId = this.$orderRequest.getTradingOrderId();
                this.label = 1;
                obj = paymentService.e(tradingOrderId, this);
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
                d.a.b(PaymentClientHelper.a.b() + " --> realPay() --> orderCheckResult?.code = " + (baseDto != null ? baseDto.getCode() : null) + " -- orderCheckResult?.msg = " + (baseDto != null ? baseDto.getMsg() : null) + " -- 接口请求失败");
                throw new Exception(baseDto != null ? baseDto.getMsg() : null);
            }
            d.a.a(PaymentClientHelper.a.b() + " --> realPay() --> paynicorn 发货成功");
            int i2 = 0;
            this.$payCallback.b(false);
            b bVar = this.$payCallback;
            CheckPaymentBean checkPaymentBean = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean != null && (addCoin = checkPaymentBean.getAddCoin()) != null) {
                i2 = Integer.parseInt(addCoin);
            }
            CheckPaymentBean checkPaymentBean2 = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean2 == null || (str = checkPaymentBean2.getBalanceCoin()) == null) {
                str = BuildConfig.FLAVOR;
            }
            bVar.c(i2, str, this.$orderRequest.getTradingOrderId());
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaymentClientHelper$realPay$1$onPurchasesUpdated$1(b bVar, CreateOrderRes createOrderRes, PaymentService paymentService, Continuation<? super PaymentClientHelper$realPay$1$onPurchasesUpdated$1> continuation) {
        super(2, continuation);
        this.$payCallback = bVar;
        this.$orderRequest = createOrderRes;
        this.$paymentService = paymentService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentClientHelper$realPay$1$onPurchasesUpdated$1(this.$payCallback, this.$orderRequest, this.$paymentService, continuation);
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
                PayUtils payUtils = PayUtils.a;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$paymentService, this.$orderRequest, this.$payCallback, null);
                this.label = 1;
                if (PayUtils.b(payUtils, 0L, 0, anonymousClass1, this, 3, null) == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Exception e) {
            d.a.b(PaymentClientHelper.a.b() + " --> realPay() --> handlePurchase 发货进行中ing --> e = " + e.getMessage());
            this.$payCallback.b(false);
            this.$payCallback.a(Boxing.d(-30), e.getMessage(), false, this.$orderRequest.getTradingOrderId());
        }
        return Unit.a;
    }
}
