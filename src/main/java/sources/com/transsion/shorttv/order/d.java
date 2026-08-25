package com.transsion.shorttv.order;

import android.content.Context;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPayClient;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.order.bean.CenterCreateTradingOrderRespEntity;
import com.transsion.shorttv.order.bean.CreatePaynicornOrderReqBean;
import com.transsion.shorttv.order.bean.PrePayInfoBean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    public static final d a = new d();

    public static final class a implements com.tn.tranpay.d {
        final /* synthetic */ Function2 a;
        final /* synthetic */ Function0 b;

        a(Function2 function2, Function0 function0) {
            this.a = function2;
            this.b = function0;
        }

        public void a(com.tn.tranpay.b bVar, com.tn.tranpay.c cVar) {
            Intrinsics.h(bVar, "result");
            c cVar2 = c.a;
            d dVar = d.a;
            cVar2.a(dVar.b() + " --> onPurchasesUpdated() --> result = " + bVar + " -- purchase = " + cVar);
            if (com.tn.tranpay.a.a.a(bVar.b()) && cVar != null) {
                cVar2.a(dVar.b() + " --> onPurchasesUpdated() --> paynicorn result --> 轮询Paynicorn支付结果 ....");
                this.b.invoke();
                return;
            }
            cVar2.b(dVar.b() + " --> onPurchasesUpdated() --> paynicorn result is cancel");
            int b = bVar.b();
            if (b == 1) {
                this.a.invoke(Integer.valueOf(com.transsion.moviedetail.adapter.c.H), "onPurchasesUpdated() --> 取消支付");
                return;
            }
            if (b != 4) {
                this.a.invoke(1004, "onPurchasesUpdated() --> 支付失败");
                return;
            }
            cVar2.a(dVar.b() + " --> onPurchasesUpdated() --> processing--> paynicorn result --> 轮询Paynicorn支付结果 ....");
            this.a.invoke(1003, "onPurchasesUpdated() --> 支付进行中");
        }
    }

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b() {
        String simpleName = d.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void c(Context context, CenterCreateTradingOrderRespEntity centerCreateTradingOrderRespEntity, Function2 function2, Function0 function0) {
        String str;
        Boolean payByLocalCurrency;
        String txnId;
        String description;
        String orderId;
        Double price;
        Intrinsics.h(function2, "payFail");
        Intrinsics.h(function0, "orderCheck4Paynicorn");
        PrePayInfoBean prePayInfo = centerCreateTradingOrderRespEntity != null ? centerCreateTradingOrderRespEntity.getPrePayInfo() : null;
        if (prePayInfo == null || (price = prePayInfo.getPrice()) == null || (str = price.toString()) == null) {
            str = "0";
        }
        BillingParams billingParams = new BillingParams((centerCreateTradingOrderRespEntity == null || (txnId = centerCreateTradingOrderRespEntity.getTxnId()) == null) ? BuildConfig.FLAVOR : txnId, str, (prePayInfo == null || (orderId = prePayInfo.getOrderId()) == null) ? BuildConfig.FLAVOR : orderId, (prePayInfo == null || (description = prePayInfo.getDescription()) == null) ? BuildConfig.FLAVOR : description, prePayInfo != null ? prePayInfo.getCurrency() : null, prePayInfo != null ? prePayInfo.getReferenceNo() : null, prePayInfo != null ? prePayInfo.getMemo() : null, (String) null, (String) null, false, (prePayInfo == null || (payByLocalCurrency = prePayInfo.getPayByLocalCurrency()) == null) ? false : payByLocalCurrency.booleanValue(), 384, (DefaultConstructorMarker) null);
        if (context != null) {
            TranPayClient.a.b(context, billingParams, new a(function2, function0));
        }
    }

    public final void d(Context context, CreatePaynicornOrderReqBean createPaynicornOrderReqBean, b bVar) {
        c.a.a(b() + " -->  --> purchase() --> 开始购买流程");
        if (context != null && createPaynicornOrderReqBean != null) {
            new PurchaseDialog().F0(createPaynicornOrderReqBean).p0(bVar).i0(context, "PurchaseDialog");
        } else if (bVar != null) {
            bVar.a("-1", "context == null || orderReq == null");
        }
    }
}
