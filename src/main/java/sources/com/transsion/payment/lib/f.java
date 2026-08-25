package com.transsion.payment.lib;

import android.app.Application;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog;
import com.transsion.payment.lib.strategy.GoogleStrategy;
import com.transsion.payment.lib.strategy.PaynicornStrategy;
import java.util.Map;
import jg.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.payment.lib.e
        public final Object invoke() {
            f d;
            d = f.d();
            return d;
        }
    });
    private com.transsion.payment.lib.strategy.g a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a() {
            return (f) f.c.getValue();
        }
    }

    public f() {
        b.a aVar = jg.b.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        String e = aVar.e(a2);
        com.transsion.payment.lib.strategy.g googleStrategy = TextUtils.equals(e, "gp") ? new GoogleStrategy() : new PaynicornStrategy();
        this.a = googleStrategy;
        d.a.a("PaymentManager() --> init{} --> channel = " + e + " -- payStrategy = " + googleStrategy.getClass().getSimpleName());
    }

    private final String c() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f d() {
        return new f();
    }

    public final void e(AppCompatActivity appCompatActivity, String str, String str2, boolean z, Map map, b bVar) {
        Intrinsics.h(appCompatActivity, "activity");
        Intrinsics.h(str, "productId");
        Intrinsics.h(bVar, "payCallback");
        CreateOrderReq createOrderReq = new CreateOrderReq(str, str2, z, map);
        b.a aVar = jg.b.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        String e = aVar.e(a2);
        d.a.a(c() + " --> requestPay() --> channel = " + e + " --> orderReq = " + createOrderReq);
        if (TextUtils.equals(e, "gp")) {
            com.transsion.payment.lib.strategy.g gVar = this.a;
            if (gVar != null) {
                gVar.a(appCompatActivity, createOrderReq, z, bVar);
                return;
            }
            return;
        }
        PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog = new PaynicornDuringThePaymentDialog();
        paynicornDuringThePaymentDialog.R0(bVar);
        paynicornDuringThePaymentDialog.S0(createOrderReq);
        paynicornDuringThePaymentDialog.k0(appCompatActivity, "PaynicornDuringThePaymentDialog");
    }

    public final void g() {
        Application a2 = Utils.a();
        com.transsion.payment.lib.strategy.g gVar = this.a;
        if (gVar != null) {
            Intrinsics.e(a2);
            gVar.init(a2);
        }
    }
}
