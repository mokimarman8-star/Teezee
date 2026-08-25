package com.transsion.payment.lib;

import android.app.Application;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.TranPayClient;
import com.tn.tranpay.logger.LogLevel;
import com.transsion.gslb.BuildConfig;
import com.transsion.payment.lib.b;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.payment.lib.bean.PrePayInfo;
import java.util.Locale;
import jg.b;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PaymentClientHelper {
    public static final PaymentClientHelper a = new PaymentClientHelper();

    public static final class a implements com.tn.tranpay.d {
        final /* synthetic */ Function2 a;
        final /* synthetic */ Function0 b;

        a(Function2 function2, Function0 function0) {
            this.a = function2;
            this.b = function0;
        }

        public void a(com.tn.tranpay.b bVar, com.tn.tranpay.c cVar) {
            Intrinsics.h(bVar, "result");
            d dVar = d.a;
            dVar.a("onPurchasesUpdated " + bVar + ", " + cVar);
            if (com.tn.tranpay.a.a.a(bVar.b()) && cVar != null) {
                dVar.a(PaymentClientHelper.a.b() + " --> observe() --> paynicorn result --> 轮询Paynicorn支付结果 ....");
                this.b.invoke();
                return;
            }
            PaymentClientHelper paymentClientHelper = PaymentClientHelper.a;
            dVar.b(paymentClientHelper.b() + " --> realPay() --> paynicorn result is cancel");
            int b = bVar.b();
            if (b == 1) {
                this.a.invoke(Integer.valueOf(com.transsion.moviedetail.adapter.c.H), "observe() --> 取消支付");
                return;
            }
            if (b != 4) {
                this.a.invoke(1004, "observe() --> 支付失败");
                return;
            }
            dVar.a(paymentClientHelper.b() + " --> processing--> paynicorn result --> 轮询Paynicorn支付结果 ....");
            this.a.invoke(1003, "observe() --> 支付进行中");
        }
    }

    private PaymentClientHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b() {
        String simpleName = PaymentClientHelper.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void c() {
        String str;
        String str2;
        String string;
        MMKV c = mg.a.a.c();
        String str3 = null;
        if (c == null || (string = c.getString("custom_local_iso", BuildConfig.FLAVOR)) == null) {
            str = null;
        } else {
            str = string.toUpperCase(Locale.ROOT);
            Intrinsics.g(str, "toUpperCase(...)");
        }
        if (TextUtils.isEmpty(str)) {
            String g = tg.b.a.g();
            if (g != null) {
                str3 = g.toUpperCase(Locale.ROOT);
                Intrinsics.g(str3, "toUpperCase(...)");
            }
            str2 = str3;
        } else {
            str2 = str;
        }
        b.a aVar = jg.b.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        String e = aVar.e(a2);
        if (e == null) {
            e = "gp";
        }
        String str4 = e;
        TranPay tranPay = TranPay.a;
        Application a3 = Utils.a();
        Intrinsics.g(a3, "getApp(...)");
        TranPay.c(tranPay, a3, "3100484", c.a.b(), str4, LogLevel.DEBUG, false, false, str2, (com.tn.tranpay.e) null, 320, (Object) null);
        tranPay.a(new PayLoggerPlugin());
    }

    public final void d(AppCompatActivity appCompatActivity, final CreateOrderRes createOrderRes, final b bVar, final PaymentService paymentService) {
        Intrinsics.h(appCompatActivity, "activity");
        Intrinsics.h(createOrderRes, "orderRequest");
        Intrinsics.h(bVar, "payCallback");
        Intrinsics.h(paymentService, "paymentService");
        d.a.a(b() + " --> requestPay() --> 请求到数据 --> realPay() --> 打开端内WebView --> 展示收银台");
        PrePayInfo prePayInfo = createOrderRes.getPrePayInfo();
        if ((prePayInfo != null ? prePayInfo.getOrderId() : null) == null || prePayInfo.getDescription() == null) {
            b.a.a(bVar, 1001, "订单信息异常", false, null, 8, null);
            return;
        }
        bVar.b(false);
        String price = prePayInfo.getPrice();
        if (price == null) {
            price = "0";
        }
        String str = price;
        String orderId = prePayInfo.getOrderId();
        String str2 = orderId == null ? BuildConfig.FLAVOR : orderId;
        String description = prePayInfo.getDescription();
        String str3 = description == null ? BuildConfig.FLAVOR : description;
        String txnId = createOrderRes.getTxnId();
        String currency = prePayInfo.getCurrency();
        String referenceNo = prePayInfo.getReferenceNo();
        String str4 = referenceNo == null ? BuildConfig.FLAVOR : referenceNo;
        String memo = prePayInfo.getMemo();
        Boolean payByLocalCurrency = prePayInfo.getPayByLocalCurrency();
        TranPayClient.a.c(appCompatActivity, new BillingParams(txnId, str, str2, str3, currency, str4, memo, (String) null, (String) null, false, payByLocalCurrency != null ? payByLocalCurrency.booleanValue() : false, 384, (DefaultConstructorMarker) null), new com.tn.tranpay.d() { // from class: com.transsion.payment.lib.PaymentClientHelper$realPay$1
            public void a(com.tn.tranpay.b bVar2, com.tn.tranpay.c cVar) {
                Intrinsics.h(bVar2, "result");
                d dVar = d.a;
                dVar.a("onPurchasesUpdated " + bVar2 + ", " + cVar);
                if (com.tn.tranpay.a.a.a(bVar2.b()) && cVar != null) {
                    dVar.a(PaymentClientHelper.a.b() + " --> realPay() --> paynicorn result --> 轮询Paynicorn支付结果 ....");
                    b.this.b(true);
                    i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PaymentClientHelper$realPay$1$onPurchasesUpdated$1(b.this, createOrderRes, paymentService, null), 3, (Object) null);
                    return;
                }
                PaymentClientHelper paymentClientHelper = PaymentClientHelper.a;
                dVar.b(paymentClientHelper.b() + " --> realPay() --> paynicorn result is cancel");
                b.this.b(false);
                int b = bVar2.b();
                if (b == 1) {
                    b.this.a(Integer.valueOf(com.transsion.moviedetail.adapter.c.H), bVar2.a(), false, createOrderRes.getTradingOrderId());
                    return;
                }
                if (b != 4) {
                    b.this.a(1004, "observe() --> 支付失败", false, createOrderRes.getTradingOrderId());
                    return;
                }
                dVar.a(paymentClientHelper.b() + " --> processing--> paynicorn result --> 轮询Paynicorn支付结果 ....");
                b.this.a(1003, "orderCheck4Paynicorn() --> code = 400 -- 支付未完成", false, createOrderRes.getTradingOrderId());
            }
        });
    }

    public final void e(AppCompatActivity appCompatActivity, CreateOrderRes createOrderRes, Function2 function2, Function0 function0) {
        Intrinsics.h(function2, "payFail");
        Intrinsics.h(function0, "orderCheck4Paynicorn");
        d.a.a(b() + " --> requestPay() --> 请求到数据 --> realPay() --> 打开端内WebView --> 展示收银台");
        PrePayInfo prePayInfo = createOrderRes != null ? createOrderRes.getPrePayInfo() : null;
        if ((prePayInfo != null ? prePayInfo.getOrderId() : null) == null || prePayInfo.getDescription() == null) {
            function2.invoke(1001, "realPay() --> 打开端内WebView --> 展示收银台 -- > activity == null");
            return;
        }
        String price = prePayInfo.getPrice();
        if (price == null) {
            price = "0";
        }
        String str = price;
        String orderId = prePayInfo.getOrderId();
        String str2 = orderId == null ? BuildConfig.FLAVOR : orderId;
        String description = prePayInfo.getDescription();
        String str3 = description == null ? BuildConfig.FLAVOR : description;
        String txnId = createOrderRes.getTxnId();
        String currency = prePayInfo.getCurrency();
        String referenceNo = prePayInfo.getReferenceNo();
        String memo = prePayInfo.getMemo();
        Boolean payByLocalCurrency = prePayInfo.getPayByLocalCurrency();
        BillingParams billingParams = new BillingParams(txnId, str, str2, str3, currency, referenceNo, memo, (String) null, (String) null, false, payByLocalCurrency != null ? payByLocalCurrency.booleanValue() : false, 384, (DefaultConstructorMarker) null);
        if (appCompatActivity != null) {
            TranPayClient.a.c(appCompatActivity, billingParams, new a(function2, function0));
        }
    }
}
