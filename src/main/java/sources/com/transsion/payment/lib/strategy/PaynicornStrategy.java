package com.transsion.payment.lib.strategy;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.b0;
import com.transsion.payment.lib.PaymentClientHelper;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.payment.lib.strategy.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PaynicornStrategy implements g {
    private final b0 a = new b0();
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.payment.lib.strategy.h
        public final Object invoke() {
            PaymentService j;
            j = PaynicornStrategy.j();
            return j;
        }
    });
    private n0 c = o0.a(y0.b());

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentService i() {
        return (PaymentService) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaymentService j() {
        return new PaymentService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(AppCompatActivity appCompatActivity, CreateOrderRes createOrderRes, com.transsion.payment.lib.b bVar) {
        PaymentClientHelper.a.d(appCompatActivity, createOrderRes, bVar, i());
    }

    @Override // com.transsion.payment.lib.strategy.g
    public void a(AppCompatActivity appCompatActivity, CreateOrderReq createOrderReq, boolean z, com.transsion.payment.lib.b bVar) {
        Intrinsics.h(appCompatActivity, "activity");
        Intrinsics.h(createOrderReq, "orderRequest");
        Intrinsics.h(bVar, "payCallback");
        com.transsion.payment.lib.d.a.a(h() + " --> requestPay() --> 请求接口创建订单....");
        bVar.b(true);
        i.d(this.c, (CoroutineContext) null, (CoroutineStart) null, new PaynicornStrategy$requestPay$1(this, createOrderReq, appCompatActivity, bVar, null), 3, (Object) null);
    }

    @Override // com.transsion.payment.lib.strategy.g
    public void b(Boolean bool, com.transsion.payment.lib.b bVar, Function0 function0) {
        g();
    }

    public void g() {
        i.d(this.c, (CoroutineContext) null, (CoroutineStart) null, new PaynicornStrategy$fetchSkuList$1(this, null), 3, (Object) null);
    }

    public String h() {
        return g.a.a(this);
    }

    @Override // com.transsion.payment.lib.strategy.g
    public void init(Application application) {
        Intrinsics.h(application, "application");
        PaymentClientHelper.a.c();
    }
}
