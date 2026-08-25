package com.tn.tranpay.helper;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.tn.lib.tranpay.R;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.TranPayConfiguration;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PayUtils {
    public static final PayUtils a = new PayUtils();
    private static final Map b;

    public static final class a {
        private final String a;
        private final List b;
        private final List c;
        private final String d;

        public a(String str, List list, List list2, String str2) {
            Intrinsics.h(str, "packageName");
            Intrinsics.h(list, "schemes");
            this.a = str;
            this.b = list;
            this.c = list2;
            this.d = str2;
        }

        public /* synthetic */ a(String str, List list, List list2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str2);
        }

        public final String a() {
            return this.d;
        }

        public final String b() {
            return this.a;
        }

        public final List c() {
            return this.b;
        }

        public final List d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && Intrinsics.c(this.d, aVar.d);
        }

        public int hashCode() {
            int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            List list = this.c;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            String str = this.d;
            return hashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "PaymentAppConfig(packageName=" + this.a + ", schemes=" + this.b + ", webFallbacks=" + this.c + ", intentScheme=" + this.d + ")";
        }
    }

    public static final class b {
        public static final b a;
        private static Map b;

        static {
            b bVar = new b();
            a = bVar;
            b = new LinkedHashMap();
            bVar.d();
        }

        private b() {
        }

        private final void d() {
            b.clear();
            b.putAll(PayUtils.b);
        }

        public final a a(String str, String str2) {
            Intrinsics.h(str, "scheme");
            Intrinsics.h(str2, "host");
            for (Map.Entry entry : b.entrySet()) {
                String str3 = (String) entry.getKey();
                a aVar = (a) entry.getValue();
                List c = aVar.c();
                String lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.g(lowerCase, "toLowerCase(...)");
                if (c.contains(lowerCase)) {
                    lh.a.g(lh.a.a, "PaymentAppConfigManager --> findMatchingConfig() --> 匹配到应用: " + str3 + " (scheme: " + str + ")", null, 2, null);
                    return aVar;
                }
                List d = aVar.d();
                if (d != null) {
                    Iterator it = d.iterator();
                    while (it.hasNext()) {
                        String str4 = (String) CollectionsKt.k0(StringsKt.S0(StringsKt.Q(StringsKt.Q((String) it.next(), "https://", "", false, 4, (Object) null), "http://", "", false, 4, (Object) null), new String[]{"/"}, false, 0, 6, (Object) null));
                        if (str4 == null) {
                            str4 = "";
                        }
                        if (str4.length() > 0 && StringsKt.a0(str2, str4, true)) {
                            lh.a.g(lh.a.a, "PaymentAppConfigManager --> findMatchingConfig() --> 匹配到应用: " + str3 + " (webFallback: " + str4 + ")", null, 2, null);
                            return aVar;
                        }
                    }
                }
            }
            return null;
        }

        public final a b(String str) {
            Intrinsics.h(str, "packageName");
            return (a) b.get(str);
        }

        public final String c(String str) {
            Intrinsics.h(str, "scheme");
            for (Map.Entry entry : b.entrySet()) {
                String str2 = (String) entry.getKey();
                List c = ((a) entry.getValue()).c();
                String lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.g(lowerCase, "toLowerCase(...)");
                if (c.contains(lowerCase)) {
                    return str2;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        String str = null;
        int i = 12;
        List list = null;
        b = MapsKt.l(new Pair[]{TuplesKt.a("com.gojek.app", new a("com.gojek.app", CollectionsKt.e("gojek"), CollectionsKt.o(new String[]{"https://gojek.link", "https://gopay.co.id/app"}), null, 8, defaultConstructorMarker)), TuplesKt.a("com.telkom.mwallet", new a("com.telkom.mwallet", CollectionsKt.e("linkaja"), null, 0 == true ? 1 : 0, 12, defaultConstructorMarker)), TuplesKt.a("id.dana.app", new a("id.dana.app", CollectionsKt.e("dana"), 0 == true ? 1 : 0, null, 12, null)), TuplesKt.a("com.ovo.app", new a("com.ovo.app", CollectionsKt.e("ovo"), 0 == true ? 1 : 0, null, 12, null)), TuplesKt.a("com.shopee.payment", new a("com.shopee.payment", CollectionsKt.o(new String[]{"shopeepay", "shopeeid"}), 0 == true ? 1 : 0, null, 12, null)), TuplesKt.a("com.tngdigital.tngo", new a("com.tngdigital.tngo", CollectionsKt.e("tng"), 0 == true ? 1 : 0, null, 12, null)), TuplesKt.a("my.com.asiainsurance.boost", new a("my.com.asiainsurance.boost", CollectionsKt.e("boost"), 0 == true ? 1 : 0, null, 12, null)), TuplesKt.a("com.grabtaxi.passenger", new a("com.grabtaxi.passenger", CollectionsKt.e("grabpay"), 0 == true ? 1 : 0, null, 12, null)), TuplesKt.a("sg.gov.tech.paynow", new a("sg.gov.tech.paynow", CollectionsKt.e("paynow"), 0 == true ? 1 : 0, null, 12, null)), TuplesKt.a("th.co.truemoney.wallet", new a("th.co.truemoney.wallet", CollectionsKt.e("truemoney"), CollectionsKt.e("https://tmn.app.link"), str, 8, defaultConstructorMarker2)), TuplesKt.a("th.co.promptpay", new a("th.co.promptpay", CollectionsKt.e("promptpay"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.linecorp.rabbitlinepay", new a("com.linecorp.rabbitlinepay", CollectionsKt.e("rabbitlinepay"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.globe.gcash.android", new a("com.globe.gcash.android", CollectionsKt.e("gcash"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.paymaya", new a("com.paymaya", CollectionsKt.e("paymaya"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("ph.coins.btc", new a("ph.coins.btc", CollectionsKt.e("coins"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.mservice.momotransfer", new a("com.mservice.momotransfer", CollectionsKt.e("momo"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.vng.zalopay", new a("com.vng.zalopay", CollectionsKt.e("zalopay"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.viettel.viettelpay", new a("com.viettel.viettelpay", CollectionsKt.e("viettelpay"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.ascendmoney.mobile", new a("com.ascendmoney.mobile", CollectionsKt.e("ascendmoney"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.eg.android.AlipayGphone", new a("com.eg.android.AlipayGphone", CollectionsKt.o(new String[]{"alipay", "alipays"}), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.tencent.mm", new a("com.tencent.mm", CollectionsKt.o(new String[]{"weixin", "wechat"}), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.paypal.android.p2pmobile", new a("com.paypal.android.p2pmobile", CollectionsKt.e("paypal"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("net.one97.paytm", new a("net.one97.paytm", CollectionsKt.o(new String[]{"paytmmp", "paytmgn"}), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.phonepe.app", new a("com.phonepe.app", CollectionsKt.e("phonepe"), list, str, i, defaultConstructorMarker2)), TuplesKt.a("com.techlogix.mobilinkcustomer", new a("com.techlogix.mobilinkcustomer", CollectionsKt.e("jazzcash"), list, "intent://deeplink#Intent;scheme=jazzcash;package=com.techlogix.mobilinkcustomer;end", 4, defaultConstructorMarker2))});
    }

    private PayUtils() {
    }

    public static /* synthetic */ boolean e(PayUtils payUtils, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "tran_pay";
        }
        return payUtils.d(str, str2);
    }

    private final String f(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (Intrinsics.c(lowerCase, "gopay")) {
            return "com.gojek.app";
        }
        return null;
    }

    private final boolean h(Uri uri) {
        String host;
        String scheme = uri.getScheme();
        if (scheme == null || (host = uri.getHost()) == null) {
            return false;
        }
        lh.a aVar = lh.a.a;
        lh.a.g(aVar, "PayUtils --> handleDeepLinkGeneric() --> scheme = " + scheme + ", host = " + host + ", uri = " + uri, null, 2, null);
        a a2 = b.a.a(scheme, host);
        if (a2 != null) {
            return k(uri, a2);
        }
        if (Intrinsics.c(scheme, "intent")) {
            return i(uri);
        }
        if (!Intrinsics.c(scheme, "https") && !Intrinsics.c(scheme, "http")) {
            if (CollectionsKt.o(new String[]{"http", "https"}).contains(scheme)) {
                return false;
            }
            String uri2 = uri.toString();
            Intrinsics.g(uri2, "uri.toString()");
            return s(uri2, true);
        }
        if (l(uri)) {
            return true;
        }
        lh.a.g(aVar, "PayUtils --> handleDeepLinkGeneric() --> 未知 " + scheme + " 链接，尝试通用处理: " + uri, null, 2, null);
        String uri3 = uri.toString();
        Intrinsics.g(uri3, "uri.toString()");
        return s(uri3, true);
    }

    private final boolean i(Uri uri) {
        lh.a aVar = lh.a.a;
        lh.a.g(aVar, "PayUtils --> handleIntentScheme() --> 处理 intent:// 协议: " + uri, null, 2, null);
        try {
            Intent parseUri = Intent.parseUri(uri.toString(), 1);
            parseUri.addFlags(268435456);
            TranPay tranPay = TranPay.a;
            if (tranPay.d().getPackageManager().resolveActivity(parseUri, 0) != null) {
                tranPay.d().startActivity(parseUri);
                lh.a.g(aVar, "PayUtils --> handleIntentScheme() --> 成功启动 intent:// 协议", null, 2, null);
                return true;
            }
            lh.a.k(aVar, "PayUtils --> handleIntentScheme() --> 没有应用可以处理此 intent", null, 2, null);
            String str = parseUri.getPackage();
            if (str != null && str.length() != 0) {
                lh.a.g(aVar, "PayUtils --> handleIntentScheme() --> 尝试跳转应用市场: " + str, null, 2, null);
                return r(this, str, false, 2, null);
            }
            return false;
        } catch (Exception e) {
            lh.a.e(lh.a.a, "PayUtils --> handleIntentScheme() --> 启动失败: " + e.getMessage(), null, 2, null);
            return false;
        }
    }

    private final boolean j(String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        boolean z = false;
        if (scheme == null) {
            return false;
        }
        lh.a aVar = lh.a.a;
        lh.a.g(aVar, "PayUtils --> handleNoAppFound() --> 尝试处理未匹配的 DeepLink: scheme = " + scheme, null, 2, null);
        String c = b.a.c(scheme);
        if (c == null) {
            c = f(scheme);
        }
        if (c == null) {
            lh.a.k(aVar, "PayUtils --> handleNoAppFound() --> 未知协议: " + scheme + "，尝试通用方式打开", null, 2, null);
            try {
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(268435456);
                TranPay.a.d().startActivity(intent);
                lh.a.g(aVar, "PayUtils --> handleNoAppFound() --> 通用方式打开成功", null, 2, null);
                return true;
            } catch (Exception e) {
                lh.a.k(lh.a.a, "PayUtils --> handleNoAppFound() --> 通用方式打开失败: " + e.getMessage() + "，返回 false（已阻止 WebView 加载）", null, 2, null);
                return false;
            }
        }
        if (!e(this, c, null, 2, null)) {
            lh.a.g(aVar, "PayUtils --> handleNoAppFound() --> 应用未安装，跳转应用市场: " + c, null, 2, null);
            return r(this, c, false, 2, null);
        }
        lh.a.g(aVar, "PayUtils --> handleNoAppFound() --> 应用已安装但无法直接处理此 DeepLink: " + c, null, 2, null);
        lh.a.g(aVar, "PayUtils --> handleNoAppFound() --> DeepLink: " + parse, null, 2, null);
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW", parse);
            intent2.addFlags(268435456);
            TranPay.a.d().startActivity(intent2);
            lh.a.g(aVar, "PayUtils --> handleNoAppFound() --> 系统默认方式成功打开", null, 2, null);
            z = true;
        } catch (Exception e2) {
            lh.a.k(lh.a.a, "PayUtils --> handleNoAppFound() --> 系统默认方式失败: " + e2.getMessage() + "，尝试其他方式", null, 2, null);
        }
        if (!z) {
            a b2 = b.a.b(c);
            if ((b2 != null ? b2.a() : null) != null) {
                lh.a.g(lh.a.a, "PayUtils --> handleNoAppFound() --> 尝试使用配置的 intentScheme: " + b2.a(), null, 2, null);
                Uri parse2 = Uri.parse(b2.a());
                Intrinsics.g(parse2, "parse(config.intentScheme)");
                if (i(parse2)) {
                    return true;
                }
            }
        }
        return z;
    }

    private final boolean k(Uri uri, a aVar) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            return false;
        }
        lh.a aVar2 = lh.a.a;
        lh.a.g(aVar2, "PayUtils --> handlePaymentAppDeepLink() --> 处理 " + aVar.b() + " deeplink", null, 2, null);
        if (Intrinsics.c(scheme, "https") ? true : Intrinsics.c(scheme, "http")) {
            String uri2 = uri.toString();
            Intrinsics.g(uri2, "uri.toString()");
            return t(uri2, aVar.b());
        }
        String uri3 = uri.toString();
        Intrinsics.g(uri3, "uri.toString()");
        boolean s = s(uri3, true);
        if (!s) {
            if (aVar.a() != null) {
                lh.a.g(aVar2, "PayUtils --> handlePaymentAppDeepLink() --> 尝试使用配置的 intentScheme: " + aVar.a(), null, 2, null);
                Uri parse = Uri.parse(aVar.a());
                Intrinsics.g(parse, "parse(config.intentScheme)");
                if (i(parse)) {
                    return true;
                }
            }
            if (aVar.d() != null) {
                return u(uri, aVar);
            }
        }
        return s;
    }

    private final boolean l(Uri uri) {
        String host = uri.getHost();
        if (host == null) {
            return false;
        }
        List o = CollectionsKt.o(new String[]{"gojek.link", "gopay.co.id", "alipay.com", "paypal.com", "paytm.com", "phonepe.com", "linkaja.id", "app.link", "onelink.me"});
        if (!(o instanceof Collection) || !o.isEmpty()) {
            Iterator it = o.iterator();
            while (it.hasNext()) {
                if (StringsKt.a0(host, (String) it.next(), true)) {
                    lh.a.g(lh.a.a, "PayUtils --> handleWebPaymentLink() --> 已知支付应用 Web 链接: " + host, null, 2, null);
                    String uri2 = uri.toString();
                    Intrinsics.g(uri2, "uri.toString()");
                    return s(uri2, true);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function0 function0, DialogInterface dialogInterface, int i) {
        Intrinsics.h(function0, "$onConfirm");
        dialogInterface.dismiss();
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function0 function0, DialogInterface dialogInterface, int i) {
        Intrinsics.h(function0, "$onCancel");
        dialogInterface.dismiss();
        function0.invoke();
    }

    public static /* synthetic */ boolean r(PayUtils payUtils, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return payUtils.q(str, z);
    }

    private final boolean t(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        if (!e(this, str2, null, 2, null)) {
            lh.a.g(lh.a.a, "PayUtils --> tryStartAppDirectly() --> 应用未安装: " + str2 + "，尝试通用方式打开", null, 2, null);
            return s(str, true);
        }
        lh.a aVar = lh.a.a;
        lh.a.g(aVar, "PayUtils --> tryStartAppDirectly() --> 应用已安装: " + str2 + "，直接启动", null, 2, null);
        intent.setPackage(str2);
        TranPay tranPay = TranPay.a;
        if (tranPay.d().getPackageManager().resolveActivity(intent, 65536) == null) {
            lh.a.k(aVar, "PayUtils --> tryStartAppDirectly() --> 应用无法直接处理链接，尝试系统默认方式", null, 2, null);
            intent.setPackage(null);
            try {
                tranPay.d().startActivity(intent);
                lh.a.g(aVar, "PayUtils --> tryStartAppDirectly() --> 成功用系统默认方式打开", null, 2, null);
                return true;
            } catch (Exception e) {
                lh.a.e(lh.a.a, "PayUtils --> tryStartAppDirectly() --> 系统默认方式也失败: " + e.getMessage(), null, 2, null);
                return false;
            }
        }
        try {
            tranPay.d().startActivity(intent);
            lh.a.g(aVar, "PayUtils --> tryStartAppDirectly() --> 成功启动应用: " + str2, null, 2, null);
            return true;
        } catch (Exception e2) {
            lh.a.e(lh.a.a, "PayUtils --> tryStartAppDirectly() --> 启动失败: " + e2.getMessage(), null, 2, null);
            return false;
        }
    }

    private final boolean u(Uri uri, a aVar) {
        String path = uri.getPath();
        if (path == null) {
            return false;
        }
        String query = uri.getQuery();
        if (query == null) {
            query = "";
        }
        List d = aVar.d();
        if (d == null) {
            return false;
        }
        Iterator it = d.iterator();
        while (it.hasNext()) {
            String str = ((String) it.next()) + path + UrlUtils.QUESTION_MARK + query;
            lh.a.g(lh.a.a, "PayUtils --> tryWebFallbacks() --> 尝试 Web 回退: " + str, null, 2, null);
            if (s(str, true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(String str, String str2) {
        Object obj;
        Intrinsics.h(str2, "tag");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(TranPay.a.d().getPackageManager().getPackageInfo(str == null ? "" : str, 0) != null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            if (TranPayConfiguration.a.p()) {
                lh.a.a.b("PayUtils --> checkAppInstalled() --> 应用未安装 [包名: " + str + "] [异常类型: " + th2.getClass().getSimpleName() + "]", str2);
            }
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean g(String str) {
        Intrinsics.h(str, "link");
        Uri parse = Uri.parse(str);
        Intrinsics.g(parse, "uri");
        return h(parse);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00e5 -> B:11:0x003c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(long j, long j2, Function1 function1, Continuation continuation) {
        PayUtils$retryWithFixedIntervalAndTimeLimit$1 payUtils$retryWithFixedIntervalAndTimeLimit$1;
        int i;
        long j3;
        PayUtils$retryWithFixedIntervalAndTimeLimit$1 payUtils$retryWithFixedIntervalAndTimeLimit$12;
        long currentTimeMillis;
        long j4;
        Function1 function12;
        long j5;
        long j6;
        Function1 function13;
        Exception e;
        if (continuation instanceof PayUtils$retryWithFixedIntervalAndTimeLimit$1) {
            payUtils$retryWithFixedIntervalAndTimeLimit$1 = (PayUtils$retryWithFixedIntervalAndTimeLimit$1) continuation;
            int i2 = payUtils$retryWithFixedIntervalAndTimeLimit$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                payUtils$retryWithFixedIntervalAndTimeLimit$1.label = i2 - Integer.MIN_VALUE;
                Object obj = payUtils$retryWithFixedIntervalAndTimeLimit$1.result;
                Object f = IntrinsicsKt.f();
                i = payUtils$retryWithFixedIntervalAndTimeLimit$1.label;
                int i3 = 1;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j6 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$2;
                        j3 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$1;
                        j5 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$0;
                        function13 = (Function1) payUtils$retryWithFixedIntervalAndTimeLimit$1.L$0;
                        ResultKt.b(obj);
                        Function1 function14 = function13;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12 = payUtils$retryWithFixedIntervalAndTimeLimit$1;
                        function12 = function14;
                        long j7 = j6;
                        j4 = j5;
                        currentTimeMillis = j7;
                        i3 = 1;
                        try {
                        } catch (Exception e2) {
                            e = e2;
                            PayUtils$retryWithFixedIntervalAndTimeLimit$1 payUtils$retryWithFixedIntervalAndTimeLimit$13 = payUtils$retryWithFixedIntervalAndTimeLimit$12;
                            function13 = function12;
                            payUtils$retryWithFixedIntervalAndTimeLimit$1 = payUtils$retryWithFixedIntervalAndTimeLimit$13;
                            long j10 = j4;
                            j6 = currentTimeMillis;
                            j5 = j10;
                            if ((System.currentTimeMillis() - j6) + j5 <= j3) {
                            }
                        }
                        i0 a2 = y0.a();
                        PayUtils$retryWithFixedIntervalAndTimeLimit$2 payUtils$retryWithFixedIntervalAndTimeLimit$2 = new PayUtils$retryWithFixedIntervalAndTimeLimit$2(function12, null);
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.L$0 = function12;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.J$0 = j4;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.J$1 = j3;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.J$2 = currentTimeMillis;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.label = i3;
                        obj = i.g(a2, payUtils$retryWithFixedIntervalAndTimeLimit$2, payUtils$retryWithFixedIntervalAndTimeLimit$12);
                        if (obj == f) {
                            return f;
                        }
                        PayUtils$retryWithFixedIntervalAndTimeLimit$1 payUtils$retryWithFixedIntervalAndTimeLimit$14 = payUtils$retryWithFixedIntervalAndTimeLimit$12;
                        function13 = function12;
                        payUtils$retryWithFixedIntervalAndTimeLimit$1 = payUtils$retryWithFixedIntervalAndTimeLimit$14;
                        long j11 = j4;
                        j6 = currentTimeMillis;
                        j5 = j11;
                        lh.a.c(lh.a.a, "Action succeeded", null, 2, null);
                        return obj;
                    }
                    j6 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$2;
                    j3 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$1;
                    j5 = payUtils$retryWithFixedIntervalAndTimeLimit$1.J$0;
                    function13 = (Function1) payUtils$retryWithFixedIntervalAndTimeLimit$1.L$0;
                    try {
                        ResultKt.b(obj);
                    } catch (Exception e3) {
                        e = e3;
                        if ((System.currentTimeMillis() - j6) + j5 <= j3) {
                            lh.a.g(lh.a.a, "Exceeded maximum retry time", null, 2, null);
                            throw new TimeoutException("Exceeded maximum retry time");
                        }
                        lh.a.e(lh.a.a, "Action failed: " + e.getMessage() + ". Retrying in " + j5 + "ms", null, 2, null);
                        payUtils$retryWithFixedIntervalAndTimeLimit$1.L$0 = function13;
                        payUtils$retryWithFixedIntervalAndTimeLimit$1.J$0 = j5;
                        payUtils$retryWithFixedIntervalAndTimeLimit$1.J$1 = j3;
                        payUtils$retryWithFixedIntervalAndTimeLimit$1.J$2 = j6;
                        payUtils$retryWithFixedIntervalAndTimeLimit$1.label = 2;
                        if (u0.a(j5, payUtils$retryWithFixedIntervalAndTimeLimit$1) == f) {
                            return f;
                        }
                        Function1 function142 = function13;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12 = payUtils$retryWithFixedIntervalAndTimeLimit$1;
                        function12 = function142;
                        long j72 = j6;
                        j4 = j5;
                        currentTimeMillis = j72;
                        i3 = 1;
                        i0 a22 = y0.a();
                        PayUtils$retryWithFixedIntervalAndTimeLimit$2 payUtils$retryWithFixedIntervalAndTimeLimit$22 = new PayUtils$retryWithFixedIntervalAndTimeLimit$2(function12, null);
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.L$0 = function12;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.J$0 = j4;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.J$1 = j3;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.J$2 = currentTimeMillis;
                        payUtils$retryWithFixedIntervalAndTimeLimit$12.label = i3;
                        obj = i.g(a22, payUtils$retryWithFixedIntervalAndTimeLimit$22, payUtils$retryWithFixedIntervalAndTimeLimit$12);
                        if (obj == f) {
                        }
                    }
                    lh.a.c(lh.a.a, "Action succeeded", null, 2, null);
                    return obj;
                }
                ResultKt.b(obj);
                j3 = j2;
                payUtils$retryWithFixedIntervalAndTimeLimit$12 = payUtils$retryWithFixedIntervalAndTimeLimit$1;
                currentTimeMillis = System.currentTimeMillis();
                j4 = j;
                function12 = function1;
                i0 a222 = y0.a();
                PayUtils$retryWithFixedIntervalAndTimeLimit$2 payUtils$retryWithFixedIntervalAndTimeLimit$222 = new PayUtils$retryWithFixedIntervalAndTimeLimit$2(function12, null);
                payUtils$retryWithFixedIntervalAndTimeLimit$12.L$0 = function12;
                payUtils$retryWithFixedIntervalAndTimeLimit$12.J$0 = j4;
                payUtils$retryWithFixedIntervalAndTimeLimit$12.J$1 = j3;
                payUtils$retryWithFixedIntervalAndTimeLimit$12.J$2 = currentTimeMillis;
                payUtils$retryWithFixedIntervalAndTimeLimit$12.label = i3;
                obj = i.g(a222, payUtils$retryWithFixedIntervalAndTimeLimit$222, payUtils$retryWithFixedIntervalAndTimeLimit$12);
                if (obj == f) {
                }
            }
        }
        payUtils$retryWithFixedIntervalAndTimeLimit$1 = new PayUtils$retryWithFixedIntervalAndTimeLimit$1(this, continuation);
        Object obj2 = payUtils$retryWithFixedIntervalAndTimeLimit$1.result;
        Object f2 = IntrinsicsKt.f();
        i = payUtils$retryWithFixedIntervalAndTimeLimit$1.label;
        int i32 = 1;
        if (i == 0) {
        }
    }

    public final void n(Context context, final Function0 function0, final Function0 function02) {
        Intrinsics.h(context, "context");
        Intrinsics.h(function0, "onConfirm");
        Intrinsics.h(function02, "onCancel");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.pay_abandon_transaction));
        builder.setPositiveButton(context.getString(R.string.pay_confirm), new DialogInterface.OnClickListener() { // from class: com.tn.tranpay.helper.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PayUtils.o(function0, dialogInterface, i);
            }
        });
        builder.setNegativeButton(context.getString(R.string.pay_cancel), new DialogInterface.OnClickListener() { // from class: com.tn.tranpay.helper.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PayUtils.p(function02, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    public final boolean q(String str, boolean z) {
        String str2;
        Intrinsics.h(str, "packageName");
        try {
            if (z) {
                str2 = "market://details?id=" + str;
            } else {
                str2 = "market://details?id=" + str;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
            intent.addFlags(268435456);
            TranPay.a.d().startActivity(intent);
            lh.a.g(lh.a.a, "PayUtils --> startAppMarket() --> 成功启动应用市场: " + str, null, 2, null);
            return true;
        } catch (Exception e) {
            lh.a aVar = lh.a.a;
            lh.a.e(aVar, "PayUtils --> startAppMarket() --> 启动应用市场失败: " + e, null, 2, null);
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
                intent2.addFlags(268435456);
                TranPay.a.d().startActivity(intent2);
                lh.a.g(aVar, "PayUtils --> startAppMarket() --> 使用 Google Play 启动: " + str, null, 2, null);
                return true;
            } catch (Exception e2) {
                lh.a.e(lh.a.a, "PayUtils --> startAppMarket() --> Google Play 也失败: " + e2, null, 2, null);
                return false;
            }
        }
    }

    public final boolean s(String str, boolean z) {
        Intrinsics.h(str, "url");
        if (str.length() == 0) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (z) {
                intent.addFlags(268435456);
            }
            TranPay tranPay = TranPay.a;
            if (tranPay.d().getPackageManager().resolveActivity(intent, 0) == null) {
                lh.a.k(lh.a.a, "PayUtils --> startUrl() --> 没有应用能处理: " + str, null, 2, null);
                return j(str);
            }
            tranPay.d().startActivity(intent);
            lh.a.g(lh.a.a, "PayUtils --> startUrl() --> 成功启动: " + str, null, 2, null);
            return true;
        } catch (ActivityNotFoundException e) {
            lh.a.e(lh.a.a, "PayUtils --> startUrl() --> ActivityNotFoundException: " + e, null, 2, null);
            return j(str);
        } catch (Exception e2) {
            lh.a.e(lh.a.a, "PayUtils --> startUrl() --> 启动失败: " + e2, null, 2, null);
            return false;
        }
    }
}
