package com.transsion.payment.lib.strategy;

import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.b;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.bean.CreateOrderRes;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$requestPay$1$2", f = "GoogleStrategy.kt", l = {95}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class GoogleStrategy$requestPay$1$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ CreateOrderReq $createOrderReq;
    final /* synthetic */ com.transsion.payment.lib.b $payCallback;
    final /* synthetic */ boolean $subscriptOrder;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleStrategy$requestPay$1$2(GoogleStrategy googleStrategy, CreateOrderReq createOrderReq, AppCompatActivity appCompatActivity, boolean z, com.transsion.payment.lib.b bVar, Continuation<? super GoogleStrategy$requestPay$1$2> continuation) {
        super(2, continuation);
        this.this$0 = googleStrategy;
        this.$createOrderReq = createOrderReq;
        this.$activity = appCompatActivity;
        this.$subscriptOrder = z;
        this.$payCallback = bVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleStrategy$requestPay$1$2(this.this$0, this.$createOrderReq, this.$activity, this.$subscriptOrder, this.$payCallback, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        PaymentService z;
        String code;
        String str;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            z = this.this$0.z();
            String productId = this.$createOrderReq.getProductId();
            String cpFrontPage = this.$createOrderReq.getCpFrontPage();
            Map<String, String> extStrJson = this.$createOrderReq.getExtStrJson();
            this.label = 1;
            obj = z.h(productId, cpFrontPage, extStrJson, this);
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
        if (Intrinsics.c(baseDto != null ? baseDto.getCode() : null, "0")) {
            CreateOrderRes createOrderRes = (CreateOrderRes) baseDto.getData();
            if (!TextUtils.isEmpty(createOrderRes != null ? createOrderRes.getTradingOrderId() : null)) {
                CreateOrderRes createOrderRes2 = (CreateOrderRes) baseDto.getData();
                if (createOrderRes2 == null || (str = createOrderRes2.getTradingOrderId()) == null) {
                    str = BuildConfig.FLAVOR;
                }
                this.this$0.G(this.$activity, this.$createOrderReq.getProductId(), str, this.$subscriptOrder, this.$payCallback);
                return Unit.a;
            }
        }
        b.a.a(this.$payCallback, (baseDto == null || (code = baseDto.getCode()) == null) ? null : Boxing.d(Integer.parseInt(code)), String.valueOf(baseDto != null ? baseDto.getMsg() : null), false, null, 8, null);
        return Unit.a;
    }
}
