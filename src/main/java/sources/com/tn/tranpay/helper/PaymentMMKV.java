package com.tn.tranpay.helper;

import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.tn.tranpay.bean.CurrencyInfoBean;
import com.tn.tranpay.device.TNDeviceHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PaymentMMKV {
    public static final PaymentMMKV a = new PaymentMMKV();
    private static final Lazy b = LazyKt.b(new Function0<MMKV>() { // from class: com.tn.tranpay.helper.PaymentMMKV$mmkv$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MMKV m139invoke() {
            return MMKV.I("tran_pay");
        }
    });
    private static final Gson c = new Gson();
    private static final SimpleDateFormat d = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

    private PaymentMMKV() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(2:3|(5:5|6|(1:(1:9)(2:31|32))(2:33|(1:35)(1:36))|10|(5:23|24|25|26|27)(5:14|15|16|17|18)))|37|6|(0)(0)|10|(1:12)|23|24|25|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0111, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0112, code lost:
    
        lh.a.e(lh.a.a, "缓存货币信息失败: " + r10.getMessage(), null, 2, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(CurrencyInfoBean currencyInfoBean, Continuation continuation) {
        PaymentMMKV$cacheCurrencyInfoByIP$1 paymentMMKV$cacheCurrencyInfoByIP$1;
        int i;
        PaymentMMKV paymentMMKV;
        String str;
        if (continuation instanceof PaymentMMKV$cacheCurrencyInfoByIP$1) {
            paymentMMKV$cacheCurrencyInfoByIP$1 = (PaymentMMKV$cacheCurrencyInfoByIP$1) continuation;
            int i2 = paymentMMKV$cacheCurrencyInfoByIP$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                paymentMMKV$cacheCurrencyInfoByIP$1.label = i2 - Integer.MIN_VALUE;
                Object obj = paymentMMKV$cacheCurrencyInfoByIP$1.result;
                Object f = IntrinsicsKt.f();
                i = paymentMMKV$cacheCurrencyInfoByIP$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    IPHelper iPHelper = IPHelper.a;
                    paymentMMKV$cacheCurrencyInfoByIP$1.L$0 = this;
                    paymentMMKV$cacheCurrencyInfoByIP$1.L$1 = currencyInfoBean;
                    paymentMMKV$cacheCurrencyInfoByIP$1.label = 1;
                    obj = IPHelper.j(iPHelper, false, paymentMMKV$cacheCurrencyInfoByIP$1, 1, null);
                    if (obj == f) {
                        return f;
                    }
                    paymentMMKV = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    currencyInfoBean = (CurrencyInfoBean) paymentMMKV$cacheCurrencyInfoByIP$1.L$1;
                    paymentMMKV = (PaymentMMKV) paymentMMKV$cacheCurrencyInfoByIP$1.L$0;
                    ResultKt.b(obj);
                }
                str = (String) obj;
                if (str != null || StringsKt.q0(str)) {
                    lh.a aVar = lh.a.a;
                    lh.a.e(aVar, "无法获取IP地址，使用设备ID作为fallback", null, 2, null);
                    String c2 = TNDeviceHelper.a.c();
                    paymentMMKV.h().putString("k_currency_info_ip_cache_device_" + c2 + "_" + d.format(new Date()), c.toJson(currencyInfoBean));
                    lh.a.g(aVar, "使用设备ID缓存货币信息: " + c2, null, 2, null);
                    return Unit.a;
                }
                try {
                    paymentMMKV.h().putString("k_currency_info_ip_cache_" + str + "_" + d.format(new Date()), c.toJson(currencyInfoBean));
                    lh.a.g(lh.a.a, "使用IP地址缓存货币信息: " + str, null, 2, null);
                } catch (Exception e) {
                    lh.a.e(lh.a.a, "缓存货币信息失败: " + e.getMessage(), null, 2, null);
                }
                return Unit.a;
            }
        }
        paymentMMKV$cacheCurrencyInfoByIP$1 = new PaymentMMKV$cacheCurrencyInfoByIP$1(this, continuation);
        Object obj2 = paymentMMKV$cacheCurrencyInfoByIP$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentMMKV$cacheCurrencyInfoByIP$1.label;
        if (i != 0) {
        }
        str = (String) obj2;
        if (str != null) {
        }
        lh.a aVar2 = lh.a.a;
        lh.a.e(aVar2, "无法获取IP地址，使用设备ID作为fallback", null, 2, null);
        String c22 = TNDeviceHelper.a.c();
        paymentMMKV.h().putString("k_currency_info_ip_cache_device_" + c22 + "_" + d.format(new Date()), c.toJson(currencyInfoBean));
        lh.a.g(aVar2, "使用设备ID缓存货币信息: " + c22, null, 2, null);
        return Unit.a;
    }

    public final void b(String str, CurrencyInfoBean currencyInfoBean) {
        Intrinsics.h(str, "region");
        Intrinsics.h(currencyInfoBean, "currencyInfo");
        String str2 = "k_currency_info_cache_" + str;
        String str3 = "k_currency_info_cache_time_" + str;
        try {
            h().putString(str2, c.toJson(currencyInfoBean));
            h().putLong(str3, System.currentTimeMillis());
        } catch (Exception e) {
            lh.a.e(lh.a.a, "缓存region货币信息失败: " + e.getMessage(), null, 2, null);
        }
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        int v0;
        String format = d.format(new Date());
        String[] a2 = h().a();
        if (a2 != null) {
            for (String str : a2) {
                Intrinsics.g(str, "key");
                if (StringsKt.W(str, "k_currency_info_ip_cache_", false, 2, (Object) null) && (v0 = StringsKt.v0(str, "_", 0, false, 6, (Object) null)) != -1 && v0 < str.length() - 1) {
                    String substring = str.substring(v0 + 1);
                    Intrinsics.g(substring, "substring(...)");
                    if (!Intrinsics.c(substring, format)) {
                        a.h().M(str);
                        lh.a.g(lh.a.a, "清除过期IP缓存: " + str, null, 2, null);
                    }
                }
            }
        }
    }

    public final void e() {
        long currentTimeMillis = System.currentTimeMillis();
        String[] a2 = h().a();
        if (a2 != null) {
            for (String str : a2) {
                Intrinsics.g(str, "key");
                if (StringsKt.W(str, "k_currency_info_cache_time_", false, 2, (Object) null)) {
                    PaymentMMKV paymentMMKV = a;
                    long j = paymentMMKV.h().getLong(str, 0L);
                    if (j > 0 && currentTimeMillis - j > 2592000000L) {
                        paymentMMKV.h().M("k_currency_info_cache_" + StringsKt.I0(str, "k_currency_info_cache_time_"));
                        paymentMMKV.h().M(str);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(Continuation continuation) {
        PaymentMMKV$getCachedCurrencyInfoByIP$1 paymentMMKV$getCachedCurrencyInfoByIP$1;
        int i;
        String str;
        PaymentMMKV paymentMMKV;
        String str2;
        String string;
        String string2;
        if (continuation instanceof PaymentMMKV$getCachedCurrencyInfoByIP$1) {
            paymentMMKV$getCachedCurrencyInfoByIP$1 = (PaymentMMKV$getCachedCurrencyInfoByIP$1) continuation;
            int i2 = paymentMMKV$getCachedCurrencyInfoByIP$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                paymentMMKV$getCachedCurrencyInfoByIP$1.label = i2 - Integer.MIN_VALUE;
                Object obj = paymentMMKV$getCachedCurrencyInfoByIP$1.result;
                Object f = IntrinsicsKt.f();
                i = paymentMMKV$getCachedCurrencyInfoByIP$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    String format = d.format(new Date());
                    IPHelper iPHelper = IPHelper.a;
                    paymentMMKV$getCachedCurrencyInfoByIP$1.L$0 = this;
                    paymentMMKV$getCachedCurrencyInfoByIP$1.L$1 = format;
                    paymentMMKV$getCachedCurrencyInfoByIP$1.label = 1;
                    Object j = IPHelper.j(iPHelper, false, paymentMMKV$getCachedCurrencyInfoByIP$1, 1, null);
                    if (j == f) {
                        return f;
                    }
                    str = format;
                    obj = j;
                    paymentMMKV = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) paymentMMKV$getCachedCurrencyInfoByIP$1.L$1;
                    paymentMMKV = (PaymentMMKV) paymentMMKV$getCachedCurrencyInfoByIP$1.L$0;
                    ResultKt.b(obj);
                }
                str2 = (String) obj;
                if (str2 != null && !StringsKt.q0(str2)) {
                    String str3 = "k_currency_info_ip_cache_" + str2 + "_" + str;
                    string2 = paymentMMKV.h().getString(str3, "");
                    if (string2 != null && string2.length() != 0) {
                        try {
                            CurrencyInfoBean currencyInfoBean = (CurrencyInfoBean) c.fromJson(string2, CurrencyInfoBean.class);
                            lh.a.g(lh.a.a, "使用IP地址缓存: " + str2, null, 2, null);
                            return currencyInfoBean;
                        } catch (Exception e) {
                            lh.a.e(lh.a.a, "解析IP缓存失败: " + e.getMessage(), null, 2, null);
                            paymentMMKV.h().M(str3);
                            return null;
                        }
                    }
                }
                String c2 = TNDeviceHelper.a.c();
                String str4 = "k_currency_info_ip_cache_device_" + c2 + "_" + str;
                string = paymentMMKV.h().getString(str4, "");
                if (string == null && string.length() != 0) {
                    try {
                        CurrencyInfoBean currencyInfoBean2 = (CurrencyInfoBean) c.fromJson(string, CurrencyInfoBean.class);
                        lh.a.g(lh.a.a, "使用设备ID fallback缓存: " + c2, null, 2, null);
                        return currencyInfoBean2;
                    } catch (Exception e2) {
                        lh.a.e(lh.a.a, "解析设备ID缓存失败: " + e2.getMessage(), null, 2, null);
                        paymentMMKV.h().M(str4);
                        return null;
                    }
                }
            }
        }
        paymentMMKV$getCachedCurrencyInfoByIP$1 = new PaymentMMKV$getCachedCurrencyInfoByIP$1(this, continuation);
        Object obj2 = paymentMMKV$getCachedCurrencyInfoByIP$1.result;
        Object f2 = IntrinsicsKt.f();
        i = paymentMMKV$getCachedCurrencyInfoByIP$1.label;
        if (i != 0) {
        }
        str2 = (String) obj2;
        if (str2 != null) {
            String str32 = "k_currency_info_ip_cache_" + str2 + "_" + str;
            string2 = paymentMMKV.h().getString(str32, "");
            if (string2 != null) {
                CurrencyInfoBean currencyInfoBean3 = (CurrencyInfoBean) c.fromJson(string2, CurrencyInfoBean.class);
                lh.a.g(lh.a.a, "使用IP地址缓存: " + str2, null, 2, null);
                return currencyInfoBean3;
            }
        }
        String c22 = TNDeviceHelper.a.c();
        String str42 = "k_currency_info_ip_cache_device_" + c22 + "_" + str;
        string = paymentMMKV.h().getString(str42, "");
        return string == null ? null : null;
    }

    public final CurrencyInfoBean g(String str) {
        Intrinsics.h(str, "region");
        String str2 = "k_currency_info_cache_" + str;
        String str3 = "k_currency_info_cache_time_" + str;
        long j = h().getLong(str3, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j == 0 || currentTimeMillis - j > 2592000000L) {
            h().M(str2);
            h().M(str3);
            return null;
        }
        String string = h().getString(str2, "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return (CurrencyInfoBean) c.fromJson(string, CurrencyInfoBean.class);
        } catch (Exception e) {
            lh.a.e(lh.a.a, "解析region缓存失败: " + e.getMessage(), null, 2, null);
            h().M(str2);
            h().M(str3);
            return null;
        }
    }

    public final MMKV h() {
        Object value = b.getValue();
        Intrinsics.g(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }
}
