package com.tn.tranpay;

import com.tn.tranpay.bean.CurrencyInfoBean;
import com.tn.tranpay.helper.PaymentMMKV;
import com.tn.tranpay.network.BaseDto;
import com.tn.tranpay.network.RetrofitClient;
import com.tn.tranpay.report.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TranPayConfiguration {
    private static String b;
    private static String e;
    private static boolean f;
    private static String h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static boolean m;
    private static CurrencyInfoBean n;
    public static final TranPayConfiguration a = new TranPayConfiguration();
    private static String c = "";
    private static String d = "";
    private static boolean g = true;
    private static final Lazy o = LazyKt.b(new Function0<com.tn.tranpay.network.b>() { // from class: com.tn.tranpay.TranPayConfiguration$iPaymentApi$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final com.tn.tranpay.network.b m120invoke() {
            return (com.tn.tranpay.network.b) RetrofitClient.a.d().b(com.tn.tranpay.network.b.class);
        }
    });

    private TranPayConfiguration() {
    }

    private final void E() {
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new TranPayConfiguration$updateCurrencyInfo$1(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(CurrencyInfoBean currencyInfoBean, Continuation continuation) {
        TranPayConfiguration$cacheCurrencyInfo$1 tranPayConfiguration$cacheCurrencyInfo$1;
        int i2;
        if (continuation instanceof TranPayConfiguration$cacheCurrencyInfo$1) {
            tranPayConfiguration$cacheCurrencyInfo$1 = (TranPayConfiguration$cacheCurrencyInfo$1) continuation;
            int i3 = tranPayConfiguration$cacheCurrencyInfo$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                tranPayConfiguration$cacheCurrencyInfo$1.label = i3 - Integer.MIN_VALUE;
                Object obj = tranPayConfiguration$cacheCurrencyInfo$1.result;
                Object f2 = IntrinsicsKt.f();
                i2 = tranPayConfiguration$cacheCurrencyInfo$1.label;
                if (i2 != 0) {
                    ResultKt.b(obj);
                    String str = e;
                    if (str != null && str.length() != 0) {
                        PaymentMMKV paymentMMKV = PaymentMMKV.a;
                        String str2 = e;
                        Intrinsics.e(str2);
                        paymentMMKV.b(str2, currencyInfoBean);
                        lh.a.g(lh.a.a, "按region缓存货币信息: region=" + e, null, 2, null);
                        return Unit.a;
                    }
                    PaymentMMKV paymentMMKV2 = PaymentMMKV.a;
                    tranPayConfiguration$cacheCurrencyInfo$1.label = 1;
                    if (paymentMMKV2.a(currencyInfoBean, tranPayConfiguration$cacheCurrencyInfo$1) == f2) {
                        return f2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                lh.a.g(lh.a.a, "按IP+日期缓存货币信息", null, 2, null);
                return Unit.a;
            }
        }
        tranPayConfiguration$cacheCurrencyInfo$1 = new TranPayConfiguration$cacheCurrencyInfo$1(this, continuation);
        Object obj2 = tranPayConfiguration$cacheCurrencyInfo$1.result;
        Object f22 = IntrinsicsKt.f();
        i2 = tranPayConfiguration$cacheCurrencyInfo$1.label;
        if (i2 != 0) {
        }
        lh.a.g(lh.a.a, "按IP+日期缓存货币信息", null, 2, null);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(boolean z, Continuation continuation) {
        TranPayConfiguration$fetchAndUpdateCurrencyInfo$1 tranPayConfiguration$fetchAndUpdateCurrencyInfo$1;
        int i2;
        BaseDto baseDto;
        if (continuation instanceof TranPayConfiguration$fetchAndUpdateCurrencyInfo$1) {
            tranPayConfiguration$fetchAndUpdateCurrencyInfo$1 = (TranPayConfiguration$fetchAndUpdateCurrencyInfo$1) continuation;
            int i3 = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.label = i3 - Integer.MIN_VALUE;
                Object obj = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.result;
                Object f2 = IntrinsicsKt.f();
                i2 = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.label;
                if (i2 != 0) {
                    ResultKt.b(obj);
                    tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.Z$0 = z;
                    tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.label = 1;
                    obj = o(tranPayConfiguration$fetchAndUpdateCurrencyInfo$1);
                    if (obj == f2) {
                        return f2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.Z$0;
                    ResultKt.b(obj);
                }
                baseDto = (BaseDto) obj;
                if ((baseDto == null ? (CurrencyInfoBean) baseDto.getData() : null) != null) {
                    if (z) {
                        h.a.c(false);
                    }
                    lh.a.e(lh.a.a, "Failed to update currency info", null, 2, null);
                    return null;
                }
                n = (CurrencyInfoBean) baseDto.getData();
                if (z) {
                    h.a.c(true);
                }
                lh.a.g(lh.a.a, "Currency info updated successfully: " + n, null, 2, null);
                CurrencyInfoBean currencyInfoBean = n;
                j = currencyInfoBean != null ? currencyInfoBean.getCountryCode() : null;
                CurrencyInfoBean currencyInfoBean2 = n;
                k = currencyInfoBean2 != null ? currencyInfoBean2.getCurrency() : null;
                return n;
            }
        }
        tranPayConfiguration$fetchAndUpdateCurrencyInfo$1 = new TranPayConfiguration$fetchAndUpdateCurrencyInfo$1(this, continuation);
        Object obj2 = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.result;
        Object f22 = IntrinsicsKt.f();
        i2 = tranPayConfiguration$fetchAndUpdateCurrencyInfo$1.label;
        if (i2 != 0) {
        }
        baseDto = (BaseDto) obj2;
        if ((baseDto == null ? (CurrencyInfoBean) baseDto.getData() : null) != null) {
        }
    }

    private final Object i(Continuation continuation) {
        String str = e;
        if (str == null || str.length() == 0) {
            return PaymentMMKV.a.f(continuation);
        }
        PaymentMMKV paymentMMKV = PaymentMMKV.a;
        String str2 = e;
        Intrinsics.e(str2);
        return paymentMMKV.g(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|7|(1:(1:(1:(6:12|13|14|15|16|(2:18|19)(2:21|(2:23|24)(1:25)))(2:27|28))(6:29|30|(2:32|(1:34)(2:35|14))|15|16|(0)(0)))(1:36))(2:44|(1:46))|37|(2:39|40)(7:41|(1:43)|30|(0)|15|16|(0)(0))))|49|6|7|(0)(0)|37|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ac, code lost:
    
        r0 = kotlin.Result.Companion;
        r8 = kotlin.Result.constructor-impl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:15:0x00a7, B:29:0x0040, B:30:0x008e, B:32:0x0098, B:41:0x007b), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b A[Catch: all -> 0x0035, TRY_ENTER, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:15:0x00a7, B:29:0x0040, B:30:0x008e, B:32:0x0098, B:41:0x007b), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(Continuation continuation) {
        TranPayConfiguration$getCurrencyInfoBean$1 tranPayConfiguration$getCurrencyInfoBean$1;
        int i2;
        Throwable th;
        CurrencyInfoBean currencyInfoBean;
        BaseDto baseDto;
        CurrencyInfoBean currencyInfoBean2;
        BaseDto baseDto2;
        if (continuation instanceof TranPayConfiguration$getCurrencyInfoBean$1) {
            tranPayConfiguration$getCurrencyInfoBean$1 = (TranPayConfiguration$getCurrencyInfoBean$1) continuation;
            int i3 = tranPayConfiguration$getCurrencyInfoBean$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                tranPayConfiguration$getCurrencyInfoBean$1.label = i3 - Integer.MIN_VALUE;
                Object obj = tranPayConfiguration$getCurrencyInfoBean$1.result;
                Object f2 = IntrinsicsKt.f();
                i2 = tranPayConfiguration$getCurrencyInfoBean$1.label;
                if (i2 != 0) {
                    ResultKt.b(obj);
                    PaymentMMKV.a.c();
                    tranPayConfiguration$getCurrencyInfoBean$1.label = 1;
                    obj = i(tranPayConfiguration$getCurrencyInfoBean$1);
                    if (obj == f2) {
                        return f2;
                    }
                } else if (i2 == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        baseDto2 = (BaseDto) tranPayConfiguration$getCurrencyInfoBean$1.L$0;
                        ResultKt.b(obj);
                        baseDto = baseDto2;
                        Object obj2 = Result.constructor-impl(baseDto);
                        th = Result.exceptionOrNull-impl(obj2);
                        if (th == null) {
                            return obj2;
                        }
                        lh.a.e(lh.a.a, "获取货币信息失败 [" + th.getClass().getSimpleName() + "]: " + th.getMessage(), null, 2, null);
                        if (!f) {
                            return null;
                        }
                        th.printStackTrace();
                        return null;
                    }
                    ResultKt.b(obj);
                    baseDto = (BaseDto) obj;
                    currencyInfoBean2 = (CurrencyInfoBean) baseDto.getData();
                    if (currencyInfoBean2 != null) {
                        TranPayConfiguration tranPayConfiguration = a;
                        tranPayConfiguration$getCurrencyInfoBean$1.L$0 = baseDto;
                        tranPayConfiguration$getCurrencyInfoBean$1.label = 3;
                        if (tranPayConfiguration.d(currencyInfoBean2, tranPayConfiguration$getCurrencyInfoBean$1) == f2) {
                            return f2;
                        }
                        baseDto2 = baseDto;
                        baseDto = baseDto2;
                    }
                    Object obj22 = Result.constructor-impl(baseDto);
                    th = Result.exceptionOrNull-impl(obj22);
                    if (th == null) {
                    }
                }
                currencyInfoBean = (CurrencyInfoBean) obj;
                if (currencyInfoBean == null) {
                    lh.a.g(lh.a.a, "使用缓存的货币信息: " + currencyInfoBean, null, 2, null);
                    return new BaseDto(200, currencyInfoBean);
                }
                Result.Companion companion = Result.Companion;
                com.tn.tranpay.network.b r = a.r();
                String str = e;
                tranPayConfiguration$getCurrencyInfoBean$1.label = 2;
                obj = r.e(str, tranPayConfiguration$getCurrencyInfoBean$1);
                if (obj == f2) {
                    return f2;
                }
                baseDto = (BaseDto) obj;
                currencyInfoBean2 = (CurrencyInfoBean) baseDto.getData();
                if (currencyInfoBean2 != null) {
                }
                Object obj222 = Result.constructor-impl(baseDto);
                th = Result.exceptionOrNull-impl(obj222);
                if (th == null) {
                }
            }
        }
        tranPayConfiguration$getCurrencyInfoBean$1 = new TranPayConfiguration$getCurrencyInfoBean$1(this, continuation);
        Object obj3 = tranPayConfiguration$getCurrencyInfoBean$1.result;
        Object f22 = IntrinsicsKt.f();
        i2 = tranPayConfiguration$getCurrencyInfoBean$1.label;
        if (i2 != 0) {
        }
        currencyInfoBean = (CurrencyInfoBean) obj3;
        if (currencyInfoBean == null) {
        }
    }

    private final com.tn.tranpay.network.b r() {
        Object value = o.getValue();
        Intrinsics.g(value, "<get-iPaymentApi>(...)");
        return (com.tn.tranpay.network.b) value;
    }

    public final void A(boolean z) {
        g = z;
    }

    public final void B(String str) {
        e = str;
    }

    public final void C() {
        E();
    }

    public final void D(BillingParams billingParams) {
        Intrinsics.h(billingParams, "params");
        h = billingParams.getOrderId();
        k = billingParams.getCurrency();
        l = billingParams.getAmount();
        i = billingParams.getTxnId();
    }

    public final Object f(Continuation continuation) {
        CurrencyInfoBean currencyInfoBean = n;
        return currencyInfoBean == null ? e(false, continuation) : currencyInfoBean;
    }

    public final String g() {
        return l;
    }

    public final String h() {
        return c;
    }

    public final String j() {
        return d;
    }

    public final String k() {
        return j;
    }

    public final String l() {
        return b;
    }

    public final String m() {
        return k;
    }

    public final CurrencyInfoBean n() {
        return n;
    }

    public final boolean p() {
        return f;
    }

    public final boolean q() {
        return m;
    }

    public final String s() {
        return h;
    }

    public final String t() {
        return i;
    }

    public final boolean u() {
        return g;
    }

    public final void v(String str) {
        Intrinsics.h(str, "<set-?>");
        c = str;
    }

    public final void w(String str) {
        Intrinsics.h(str, "<set-?>");
        d = str;
    }

    public final void x(String str) {
        b = str;
    }

    public final void y(boolean z) {
        f = z;
    }

    public final void z(boolean z) {
        m = z;
    }
}
