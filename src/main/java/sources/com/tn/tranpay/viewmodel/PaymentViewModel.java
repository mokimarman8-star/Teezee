package com.tn.tranpay.viewmodel;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.appcompat.app.h;
import androidx.lifecycle.b0;
import androidx.lifecycle.t0;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.gson.Gson;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.TranPayConfiguration;
import com.tn.tranpay.bean.CreateOrderResultContent;
import com.tn.tranpay.bean.CurrencyInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.d;
import com.tn.tranpay.device.TNDeviceHelper;
import com.tn.tranpay.helper.c;
import com.tn.tranpay.network.RetrofitClient;
import com.tn.tranpay.network.b;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import lh.a;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PaymentViewModel extends t0 {
    private t1 b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private d k;
    private final Lazy a = LazyKt.b(new Function0<b>() { // from class: com.tn.tranpay.viewmodel.PaymentViewModel$iPaymentApi$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final b m143invoke() {
            return (b) RetrofitClient.a.d().b(b.class);
        }
    });
    private final Gson l = new Gson();
    private final b0 m = new b0();
    private final b0 n = new b0();
    private final b0 o = new b0();
    private final b0 p = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object B(String str, String str2, String str3, Continuation continuation) {
        PaymentViewModel$handleCancelPay$1 paymentViewModel$handleCancelPay$1;
        int i;
        try {
            if (continuation instanceof PaymentViewModel$handleCancelPay$1) {
                paymentViewModel$handleCancelPay$1 = (PaymentViewModel$handleCancelPay$1) continuation;
                int i2 = paymentViewModel$handleCancelPay$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    paymentViewModel$handleCancelPay$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = paymentViewModel$handleCancelPay$1.result;
                    Object f = IntrinsicsKt.f();
                    i = paymentViewModel$handleCancelPay$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("txnId", str);
                        jSONObject.put("bindToken", str3);
                        jSONObject.put("reason", str2);
                        c.a aVar = c.a;
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.g(jSONObject2, "json.toString()");
                        RequestBody a = aVar.a(jSONObject2);
                        if (a == null) {
                            return null;
                        }
                        b v = v();
                        paymentViewModel$handleCancelPay$1.label = 1;
                        obj = v.d(a, paymentViewModel$handleCancelPay$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return (QueryOrderResultContent) obj;
                }
            }
            if (i != 0) {
            }
            return (QueryOrderResultContent) obj;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th)));
            if (th2 == null) {
                throw new KotlinNothingValueException();
            }
            a.e(a.a, "CancelOrder error is " + th2.getMessage(), null, 2, null);
            return null;
        }
        paymentViewModel$handleCancelPay$1 = new PaymentViewModel$handleCancelPay$1(this, continuation);
        Object obj2 = paymentViewModel$handleCancelPay$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentViewModel$handleCancelPay$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:11:0x0029, B:12:0x0105, B:20:0x004e, B:21:0x0086, B:23:0x0092, B:25:0x00a2, B:27:0x00bb, B:28:0x00c0, B:30:0x00ee, B:35:0x009a, B:39:0x0055, B:41:0x006d), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ee A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:11:0x0029, B:12:0x0105, B:20:0x004e, B:21:0x0086, B:23:0x0092, B:25:0x00a2, B:27:0x00bb, B:28:0x00c0, B:30:0x00ee, B:35:0x009a, B:39:0x0055, B:41:0x006d), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object C(String str, String str2, String str3, String str4, Continuation continuation) {
        PaymentViewModel$handleCashierPay$1 paymentViewModel$handleCashierPay$1;
        int i;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        PaymentViewModel paymentViewModel;
        JSONObject jSONObject3;
        RequestBody a;
        LoadConfigContent loadConfigContent;
        try {
            if (continuation instanceof PaymentViewModel$handleCashierPay$1) {
                paymentViewModel$handleCashierPay$1 = (PaymentViewModel$handleCashierPay$1) continuation;
                int i2 = paymentViewModel$handleCashierPay$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    paymentViewModel$handleCashierPay$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = paymentViewModel$handleCashierPay$1.result;
                    Object f = IntrinsicsKt.f();
                    i = paymentViewModel$handleCashierPay$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        jSONObject = new JSONObject();
                        jSONObject.put("txnId", str);
                        jSONObject.put("payMethod", str2);
                        jSONObject2 = new JSONObject();
                        if (str3 == null) {
                            paymentViewModel = this;
                            if (str4 != null) {
                                jSONObject2.put("CNIC", str4);
                            }
                            jSONObject.put("payInput", jSONObject2);
                            jSONObject.put("pfId", UUID.randomUUID().toString());
                            jSONObject.put("gaid", TNDeviceHelper.a.d());
                            c.a aVar = c.a;
                            String jSONObject4 = jSONObject.toString();
                            Intrinsics.g(jSONObject4, "json.toString()");
                            a = aVar.a(jSONObject4);
                            if (a == null) {
                                return null;
                            }
                            b v = paymentViewModel.v();
                            paymentViewModel$handleCashierPay$1.L$0 = null;
                            paymentViewModel$handleCashierPay$1.L$1 = null;
                            paymentViewModel$handleCashierPay$1.L$2 = null;
                            paymentViewModel$handleCashierPay$1.L$3 = null;
                            paymentViewModel$handleCashierPay$1.L$4 = null;
                            paymentViewModel$handleCashierPay$1.label = 2;
                            obj = v.c(a, paymentViewModel$handleCashierPay$1);
                            if (obj == f) {
                                return f;
                            }
                            return (CreateOrderResultContent) obj;
                        }
                        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.a;
                        paymentViewModel$handleCashierPay$1.L$0 = this;
                        paymentViewModel$handleCashierPay$1.L$1 = str3;
                        paymentViewModel$handleCashierPay$1.L$2 = str4;
                        paymentViewModel$handleCashierPay$1.L$3 = jSONObject;
                        paymentViewModel$handleCashierPay$1.L$4 = jSONObject2;
                        paymentViewModel$handleCashierPay$1.label = 1;
                        Object f2 = tranPayConfiguration.f(paymentViewModel$handleCashierPay$1);
                        if (f2 == f) {
                            return f;
                        }
                        paymentViewModel = this;
                        obj = f2;
                        jSONObject3 = jSONObject;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            return (CreateOrderResultContent) obj;
                        }
                        jSONObject2 = (JSONObject) paymentViewModel$handleCashierPay$1.L$4;
                        jSONObject3 = (JSONObject) paymentViewModel$handleCashierPay$1.L$3;
                        str4 = (String) paymentViewModel$handleCashierPay$1.L$2;
                        str3 = (String) paymentViewModel$handleCashierPay$1.L$1;
                        paymentViewModel = (PaymentViewModel) paymentViewModel$handleCashierPay$1.L$0;
                        ResultKt.b(obj);
                    }
                    CurrencyInfoBean currencyInfoBean = (CurrencyInfoBean) obj;
                    loadConfigContent = (LoadConfigContent) paymentViewModel.m.f();
                    if ((loadConfigContent != null || (r3 = loadConfigContent.getAreaCode()) == null) && (currencyInfoBean == null || (r3 = currencyInfoBean.getMobileCode()) == null)) {
                        String str5 = "";
                    }
                    jSONObject2.put("Phone", str5 + str3);
                    jSONObject = jSONObject3;
                    if (str4 != null) {
                    }
                    jSONObject.put("payInput", jSONObject2);
                    jSONObject.put("pfId", UUID.randomUUID().toString());
                    jSONObject.put("gaid", TNDeviceHelper.a.d());
                    c.a aVar2 = c.a;
                    String jSONObject42 = jSONObject.toString();
                    Intrinsics.g(jSONObject42, "json.toString()");
                    a = aVar2.a(jSONObject42);
                    if (a == null) {
                    }
                }
            }
            if (i != 0) {
            }
            CurrencyInfoBean currencyInfoBean2 = (CurrencyInfoBean) obj;
            loadConfigContent = (LoadConfigContent) paymentViewModel.m.f();
            if (loadConfigContent != null) {
            }
            String str52 = "";
            jSONObject2.put("Phone", str52 + str3);
            jSONObject = jSONObject3;
            if (str4 != null) {
            }
            jSONObject.put("payInput", jSONObject2);
            jSONObject.put("pfId", UUID.randomUUID().toString());
            jSONObject.put("gaid", TNDeviceHelper.a.d());
            c.a aVar22 = c.a;
            String jSONObject422 = jSONObject.toString();
            Intrinsics.g(jSONObject422, "json.toString()");
            a = aVar22.a(jSONObject422);
            if (a == null) {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th)));
            if (th2 == null) {
                throw new KotlinNothingValueException();
            }
            a.e(a.a, "CashierPay error is " + th2.getMessage(), null, 2, null);
            return null;
        }
        paymentViewModel$handleCashierPay$1 = new PaymentViewModel$handleCashierPay$1(this, continuation);
        Object obj2 = paymentViewModel$handleCashierPay$1.result;
        Object f3 = IntrinsicsKt.f();
        i = paymentViewModel$handleCashierPay$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object D(String str, Continuation continuation) {
        PaymentViewModel$handleQuery$1 paymentViewModel$handleQuery$1;
        int i;
        try {
            if (continuation instanceof PaymentViewModel$handleQuery$1) {
                paymentViewModel$handleQuery$1 = (PaymentViewModel$handleQuery$1) continuation;
                int i2 = paymentViewModel$handleQuery$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    paymentViewModel$handleQuery$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = paymentViewModel$handleQuery$1.result;
                    Object f = IntrinsicsKt.f();
                    i = paymentViewModel$handleQuery$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("txnId", str);
                        c.a aVar = c.a;
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.g(jSONObject2, "json.toString()");
                        RequestBody a = aVar.a(jSONObject2);
                        if (a == null) {
                            return null;
                        }
                        b v = v();
                        paymentViewModel$handleQuery$1.label = 1;
                        obj = v.a(a, paymentViewModel$handleQuery$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return (QueryOrderResultContent) obj;
                }
            }
            if (i != 0) {
            }
            return (QueryOrderResultContent) obj;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th)));
            if (th2 == null) {
                throw new KotlinNothingValueException();
            }
            a.e(a.a, "Query error is " + th2.getMessage(), null, 2, null);
            return null;
        }
        paymentViewModel$handleQuery$1 = new PaymentViewModel$handleQuery$1(this, continuation);
        Object obj2 = paymentViewModel$handleQuery$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentViewModel$handleQuery$1.label;
    }

    private final void E(BillingParams billingParams) {
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new PaymentViewModel$loadConfig$1(this, billingParams, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object F(String str, String str2, Continuation continuation) {
        PaymentViewModel$loadConfigBean$1 paymentViewModel$loadConfigBean$1;
        int i;
        try {
            if (continuation instanceof PaymentViewModel$loadConfigBean$1) {
                paymentViewModel$loadConfigBean$1 = (PaymentViewModel$loadConfigBean$1) continuation;
                int i2 = paymentViewModel$loadConfigBean$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    paymentViewModel$loadConfigBean$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = paymentViewModel$loadConfigBean$1.result;
                    Object f = IntrinsicsKt.f();
                    i = paymentViewModel$loadConfigBean$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        Result.Companion companion = Result.Companion;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("txnId", str);
                        if (str2 != null) {
                            jSONObject.put(TmcConstants.KEY_LANGUAGE, str2);
                        } else {
                            try {
                                jSONObject.put(TmcConstants.KEY_LANGUAGE, r(TranPay.a.d()).getLanguage().toString());
                            } catch (Exception e) {
                                a.e(a.a, "Failed to get locale language: " + e.getMessage(), null, 2, null);
                                jSONObject.put(TmcConstants.KEY_LANGUAGE, "en");
                            }
                        }
                        jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                        c.a aVar = c.a;
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.g(jSONObject2, "json.toString()");
                        RequestBody a = aVar.a(jSONObject2);
                        if (a == null) {
                            return null;
                        }
                        b v = v();
                        paymentViewModel$loadConfigBean$1.label = 1;
                        obj = v.b(a, paymentViewModel$loadConfigBean$1);
                        if (obj == f) {
                            return f;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return (LoadConfigContent) obj;
                }
            }
            if (i != 0) {
            }
            return (LoadConfigContent) obj;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.a(th)));
            if (th2 == null) {
                throw new KotlinNothingValueException();
            }
            a.e(a.a, "LoadConfigFailed error is " + th2.getMessage(), null, 2, null);
            return null;
        }
        paymentViewModel$loadConfigBean$1 = new PaymentViewModel$loadConfigBean$1(this, continuation);
        Object obj2 = paymentViewModel$loadConfigBean$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentViewModel$loadConfigBean$1.label;
    }

    public static /* synthetic */ void H(PaymentViewModel paymentViewModel, String str, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 5000;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = 600000;
        }
        paymentViewModel.G(str, j3, j2);
    }

    private final void I(String str) {
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new PaymentViewModel$queryOnce$1(this, str, null), 3, (Object) null);
    }

    public static /* synthetic */ void h(PaymentViewModel paymentViewModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        paymentViewModel.g(str, str2, str3);
    }

    public static /* synthetic */ void k(PaymentViewModel paymentViewModel, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        paymentViewModel.j(str, str2, str3, z);
    }

    private final Locale r(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            Locale a = n0.d.a(h.a(configuration), 0);
            Intrinsics.g(a, "{\n            configuration.locales[0]\n        }");
            return a;
        }
        Locale locale = configuration.locale;
        Intrinsics.g(locale, "{\n            configuration.locale\n        }");
        return locale;
    }

    private final b v() {
        Object value = this.a.getValue();
        Intrinsics.g(value, "<get-iPaymentApi>(...)");
        return (b) value;
    }

    public final String A() {
        return this.c;
    }

    public final void G(String str, long j, long j2) {
        Intrinsics.h(str, "txnId");
        this.b = i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new PaymentViewModel$query$1(j, j2, this, str, null), 3, (Object) null);
    }

    public final void J() {
        t1 t1Var = this.b;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        String str = this.c;
        if (str != null) {
            I(str);
        }
    }

    public final void K(d dVar) {
        this.k = dVar;
    }

    public final void L(boolean z) {
        this.j = z;
    }

    public final void M(boolean z) {
        this.i = z;
    }

    public final void N(String str) {
        this.d = str;
    }

    public final void O(String str) {
        this.h = str;
    }

    public final void P(String str) {
        this.c = str;
    }

    public final void g(String str, String str2, String str3) {
        Intrinsics.h(str, "txnId");
        Intrinsics.h(str2, "reason");
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new PaymentViewModel$cancelPay$1(this, str, str2, str3, null), 3, (Object) null);
    }

    public final void i() {
        t1 t1Var = this.b;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void j(String str, String str2, String str3, boolean z) {
        Intrinsics.h(str, "payMethod");
        this.e = str2;
        this.f = str3;
        this.g = z;
        this.p.n(Boolean.TRUE);
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new PaymentViewModel$cashierPay$1(this, str, str2, str3, null), 3, (Object) null);
    }

    public final void l(BillingParams billingParams) {
        Intrinsics.h(billingParams, "params");
        E(billingParams);
    }

    public final String m() {
        String mobileCode;
        String areaCode;
        LoadConfigContent loadConfigContent = (LoadConfigContent) this.m.f();
        if (loadConfigContent != null && (areaCode = loadConfigContent.getAreaCode()) != null) {
            return areaCode;
        }
        CurrencyInfoBean n = TranPayConfiguration.a.n();
        return (n == null || (mobileCode = n.getMobileCode()) == null) ? "" : mobileCode;
    }

    public final boolean n() {
        return this.g;
    }

    public final d o() {
        return this.k;
    }

    public final String p() {
        return this.f;
    }

    public final b0 q() {
        return this.m;
    }

    public final b0 s() {
        return this.n;
    }

    public final boolean t() {
        return this.j;
    }

    public final boolean u() {
        return this.i;
    }

    public final b0 w() {
        return this.p;
    }

    public final String x() {
        return this.h;
    }

    public final String y() {
        return this.e;
    }

    public final b0 z() {
        return this.o;
    }
}
