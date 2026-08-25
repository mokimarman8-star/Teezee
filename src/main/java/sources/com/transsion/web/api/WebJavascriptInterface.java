package com.transsion.web.api;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.blankj.utilcode.util.Utils;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.therouter.TheRouter;
import com.transsion.mbtools.CalendarBean;
import com.transsion.mbtools.CalendarRemindUtils;
import com.transsion.push.bean.CalendarData;
import com.transsion.push.utils.CalendarRemindHelper;
import com.transsion.web.bean.JsCallbackData;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.ui.AdActivity;
import im.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONObject;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0013\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0015\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0016\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0017\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0018\u0010\u0012J!\u0010\u0019\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0019\u0010\u0012J!\u0010\u001a\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u001a\u0010\u0012J!\u0010\u001b\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u001b\u0010\u0012J!\u0010\u001c\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u001c\u0010\u0012J!\u0010\u001d\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u001d\u0010\u0012J!\u0010\u001e\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u001e\u0010\u0012J\u001f\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001f\u0010\u0012J\u001f\u0010 \u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b \u0010\u0012J\u001f\u0010!\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b!\u0010\u0012J\u001f\u0010\"\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\"\u0010\u0012J\u001f\u0010#\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010\u0012J\u001f\u0010$\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b$\u0010\u0012J\u001f\u0010%\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b%\u0010\u0012J\u001f\u0010&\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b&\u0010\u0012J!\u0010'\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b'\u0010\u0012J\u001f\u0010(\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b(\u0010\u0012J!\u0010)\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b)\u0010\u0012J!\u0010+\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b+\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010,R\u001a\u0010-\u001a\u00020\b8\u0006X\u0086D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00102\u001a\u0004\u0018\u0001018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/transsion/web/api/WebJavascriptInterface;", "Lcom/github/lzyzsd/jsbridge/BridgeWebView$BaseJavascriptInterface;", "Lcom/github/lzyzsd/jsbridge/BridgeWebView;", "customWebView", "<init>", "(Lcom/github/lzyzsd/jsbridge/BridgeWebView;)V", "Lcom/transsion/web/bean/JsCallbackData;", "callback", HttpUrl.FRAGMENT_ENCODE_SET, "callbackId", HttpUrl.FRAGMENT_ENCODE_SET, "postCallback", "(Lcom/transsion/web/bean/JsCallbackData;Ljava/lang/String;)V", "s", "send", "(Ljava/lang/String;)Ljava/lang/String;", "pageName", "startPage", "(Ljava/lang/String;Ljava/lang/String;)V", WebConstants.FIELD_DEEPLINK, "data", "submitFromWeb", "showDetectList", "getUserInfo", "getClientInfo", "openLoading", "closeLoading", "openToast", "closeToast", "goBack", MRAIDPresenter.CLOSE, "getToken", "nativeLogin", "calendarRemind", "enableCalendarRemind", "cancelCalendarRemind", "nativeShare", "h5ShareNative", "openApp", AdActivity.REQUEST_KEY_EXTRA, "getNativeStatusBarHeight", "onMember", "adConfig", "openMbAd", "Lcom/github/lzyzsd/jsbridge/BridgeWebView;", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lqx/a;", "mLoginApi", "Lqx/a;", "getMLoginApi", "()Lqx/a;", "Web_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class WebJavascriptInterface extends BridgeWebView.BaseJavascriptInterface {
    private final String TAG;
    private final BridgeWebView customWebView;
    private final qx.a mLoginApi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebJavascriptInterface(BridgeWebView customWebView) {
        super(customWebView.getCallbacks());
        Intrinsics.h(customWebView, "customWebView");
        this.customWebView = customWebView;
        this.TAG = "WebJavascriptInterface";
        this.mLoginApi = (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit calendarRemind$lambda$7(WebJavascriptInterface webJavascriptInterface, String str) {
        webJavascriptInterface.postCallback(new JsCallbackData(null, "0", 1, null), str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit calendarRemind$lambda$8(WebJavascriptInterface webJavascriptInterface, String str, String it) {
        Intrinsics.h(it, "it");
        webJavascriptInterface.postCallback(new JsCallbackData(it, "-1"), str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cancelCalendarRemind$lambda$11(WebJavascriptInterface webJavascriptInterface, String str) {
        webJavascriptInterface.postCallback(new JsCallbackData(null, "0", 1, null), str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cancelCalendarRemind$lambda$12(WebJavascriptInterface webJavascriptInterface, String str, String it) {
        Intrinsics.h(it, "it");
        webJavascriptInterface.postCallback(new JsCallbackData(it, "-1"), str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enableCalendarRemind$lambda$10(WebJavascriptInterface webJavascriptInterface, String str, String it) {
        Intrinsics.h(it, "it");
        webJavascriptInterface.postCallback(new JsCallbackData(it, "-1"), str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enableCalendarRemind$lambda$9(WebJavascriptInterface webJavascriptInterface, String str) {
        webJavascriptInterface.postCallback(new JsCallbackData("Calendar save successfully", "0"), str);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getClientInfo$lambda$3(WebJavascriptInterface webJavascriptInterface, String str, String str2) {
        webJavascriptInterface.customWebView.sendResponse(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getNativeStatusBarHeight$lambda$15$lambda$14(WebJavascriptInterface webJavascriptInterface, float f, String str) {
        webJavascriptInterface.customWebView.sendResponse(Float.valueOf(f), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getToken$lambda$4(WebJavascriptInterface webJavascriptInterface, String str, String str2) {
        webJavascriptInterface.customWebView.sendResponse(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUserInfo$lambda$2(WebJavascriptInterface webJavascriptInterface, String str, String str2) {
        webJavascriptInterface.customWebView.sendResponse(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nativeLogin$lambda$6(WebJavascriptInterface webJavascriptInterface, Context context, JSONObject jSONObject) {
        qx.a aVar = webJavascriptInterface.mLoginApi;
        if (aVar != null) {
            Intrinsics.e(context);
            Intent p = aVar.p(context);
            if (p != null) {
                Intent putExtra = p.putExtra("source", jSONObject != null ? jSONObject.optString("H5Source") : null);
                if (putExtra != null) {
                    context.startActivity(putExtra);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMember$lambda$16() {
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            b.a.a(bVar, (Function0) null, 1, (Object) null);
        }
    }

    private final void postCallback(final JsCallbackData callback, final String callbackId) {
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.g
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.postCallback$lambda$13(WebJavascriptInterface.this, callback, callbackId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postCallback$lambda$13(WebJavascriptInterface webJavascriptInterface, JsCallbackData jsCallbackData, String str) {
        webJavascriptInterface.customWebView.sendResponse(jsCallbackData, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDetectList$lambda$1(WebJavascriptInterface webJavascriptInterface, String str) {
        webJavascriptInterface.customWebView.sendResponse("submitFromWeb response from native", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitFromWeb$lambda$0(WebJavascriptInterface webJavascriptInterface, String str) {
        webJavascriptInterface.customWebView.sendResponse("submitFromWeb response from native", str);
    }

    @JavascriptInterface
    public final void calendarRemind(String data, final String callbackId) {
        CalendarBean calendarBean;
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        StringBuilder sb = new StringBuilder();
        sb.append("calendarRemind:");
        sb.append(data);
        try {
            calendarBean = (CalendarBean) new Gson().fromJson(data, CalendarBean.class);
        } catch (Exception unused) {
            calendarBean = null;
        }
        if (calendarBean != null) {
            CalendarRemindUtils.a.d(calendarBean, new Function0() { // from class: com.transsion.web.api.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit calendarRemind$lambda$7;
                    calendarRemind$lambda$7 = WebJavascriptInterface.calendarRemind$lambda$7(WebJavascriptInterface.this, callbackId);
                    return calendarRemind$lambda$7;
                }
            }, new Function1() { // from class: com.transsion.web.api.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit calendarRemind$lambda$8;
                    calendarRemind$lambda$8 = WebJavascriptInterface.calendarRemind$lambda$8(WebJavascriptInterface.this, callbackId, (String) obj);
                    return calendarRemind$lambda$8;
                }
            });
            return;
        }
        postCallback(new JsCallbackData("data error:" + data, "-1"), callbackId);
    }

    @JavascriptInterface
    public final void cancelCalendarRemind(String data, final String callbackId) {
        CalendarData calendarData;
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        StringBuilder sb = new StringBuilder();
        sb.append("cancelCalendarRemind:");
        sb.append(data);
        sb.append(" ");
        try {
            calendarData = (CalendarData) new Gson().fromJson(data, CalendarData.class);
        } catch (Exception unused) {
            calendarData = null;
        }
        if (calendarData != null) {
            CalendarRemindHelper.a.k(calendarData, new Function0() { // from class: com.transsion.web.api.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit cancelCalendarRemind$lambda$11;
                    cancelCalendarRemind$lambda$11 = WebJavascriptInterface.cancelCalendarRemind$lambda$11(WebJavascriptInterface.this, callbackId);
                    return cancelCalendarRemind$lambda$11;
                }
            }, new Function1() { // from class: com.transsion.web.api.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit cancelCalendarRemind$lambda$12;
                    cancelCalendarRemind$lambda$12 = WebJavascriptInterface.cancelCalendarRemind$lambda$12(WebJavascriptInterface.this, callbackId, (String) obj);
                    return cancelCalendarRemind$lambda$12;
                }
            });
            return;
        }
        postCallback(new JsCallbackData("data error:" + data, "-1"), callbackId);
    }

    @JavascriptInterface
    public void close(String data, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void closeLoading(String data, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void closeToast(String data, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void deeplink(String deeplink, String callbackId) {
        Intrinsics.h(deeplink, "deeplink");
        Intrinsics.h(callbackId, "callbackId");
        hj.b bVar = hj.b.a;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        hj.b.d(bVar, a, deeplink, (hj.c) null, 4, (Object) null);
    }

    @JavascriptInterface
    public final void enableCalendarRemind(String data, final String callbackId) {
        CalendarData calendarData;
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        StringBuilder sb = new StringBuilder();
        sb.append("enableCalendarRemind data:");
        sb.append(data);
        try {
            calendarData = (CalendarData) new Gson().fromJson(data, CalendarData.class);
        } catch (Exception unused) {
            calendarData = null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("enableCalendarRemind calendarBean:");
        sb2.append(calendarData);
        if (calendarData != null) {
            CalendarRemindHelper.a.h(calendarData, new Function0() { // from class: com.transsion.web.api.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit enableCalendarRemind$lambda$9;
                    enableCalendarRemind$lambda$9 = WebJavascriptInterface.enableCalendarRemind$lambda$9(WebJavascriptInterface.this, callbackId);
                    return enableCalendarRemind$lambda$9;
                }
            }, new Function1() { // from class: com.transsion.web.api.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit enableCalendarRemind$lambda$10;
                    enableCalendarRemind$lambda$10 = WebJavascriptInterface.enableCalendarRemind$lambda$10(WebJavascriptInterface.this, callbackId, (String) obj);
                    return enableCalendarRemind$lambda$10;
                }
            });
            return;
        }
        postCallback(new JsCallbackData("data error:" + data, "-1"), callbackId);
    }

    @JavascriptInterface
    public final void getClientInfo(String data, final String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb = new StringBuilder();
        sb.append("getClientInfo:");
        sb.append(data);
        sb.append(", callbackId: ");
        sb.append(callbackId);
        sb.append(" ");
        sb.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        final String c = jg.b.a.c();
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.m
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.getClientInfo$lambda$3(WebJavascriptInterface.this, c, callbackId);
            }
        });
    }

    public final qx.a getMLoginApi() {
        return this.mLoginApi;
    }

    @JavascriptInterface
    public final void getNativeStatusBarHeight(String data, final String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        try {
            Result$Companion result$Companion = Result.Companion;
            String name = Thread.currentThread().getName();
            StringBuilder sb = new StringBuilder();
            sb.append("getNativeStatBarHeight() --> data = ");
            sb.append(data);
            sb.append(" --> callbackId = ");
            sb.append(callbackId);
            sb.append(" --> thread.name = ");
            sb.append(name);
            if (!TextUtils.isEmpty(callbackId)) {
                final float statusBarHeight = ImmersionBar.getStatusBarHeight(Utils.a()) / Utils.a().getResources().getDisplayMetrics().density;
                this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebJavascriptInterface.getNativeStatusBarHeight$lambda$15$lambda$14(WebJavascriptInterface.this, statusBarHeight, callbackId);
                    }
                });
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
    }

    public final String getTAG() {
        return this.TAG;
    }

    @JavascriptInterface
    public final void getToken(String data, final String callbackId) {
        UserInfo i;
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb = new StringBuilder();
        sb.append("getToken:");
        sb.append(data);
        sb.append(", callbackId: ");
        sb.append(callbackId);
        sb.append(" ");
        sb.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        qx.a aVar = this.mLoginApi;
        final String token = (aVar == null || (i = aVar.i()) == null) ? null : i.getToken();
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.l
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.getToken$lambda$4(WebJavascriptInterface.this, token, callbackId);
            }
        });
    }

    @JavascriptInterface
    public final void getUserInfo(String data, final String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb = new StringBuilder();
        sb.append("getUserInfo:");
        sb.append(data);
        sb.append(", callbackId: ");
        sb.append(callbackId);
        sb.append(" ");
        sb.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        qx.a aVar = this.mLoginApi;
        final String str = null;
        try {
            str = com.blankj.utilcode.util.o.j(aVar != null ? aVar.i() : null);
        } catch (Exception unused) {
        }
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.k
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.getUserInfo$lambda$2(WebJavascriptInterface.this, str, callbackId);
            }
        });
    }

    @JavascriptInterface
    public void goBack(String data, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void h5ShareNative(String data, String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public final void nativeLogin(String data, String callbackId) {
        final JSONObject jSONObject;
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        StringBuilder sb = new StringBuilder();
        sb.append("nativeLogin:");
        sb.append(data);
        final Context context = this.customWebView.getContext();
        try {
            jSONObject = new JSONObject(data);
        } catch (Exception unused) {
            jSONObject = null;
        }
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.h
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.nativeLogin$lambda$6(WebJavascriptInterface.this, context, jSONObject);
            }
        });
    }

    @JavascriptInterface
    public void nativeShare(String data, String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void onMember(String data, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.j
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.onMember$lambda$16();
            }
        });
    }

    @JavascriptInterface
    public void openApp(String data, String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void openLoading(String data, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void openMbAd(String adConfig, final String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
        vw.b bVar = (vw.b) TheRouter.d(vw.b.class, new Object[0]);
        if (bVar != null) {
            bVar.b(adConfig, new vw.a() { // from class: com.transsion.web.api.WebJavascriptInterface$openMbAd$1
                @Override // vw.a
                public void onAdStateCallback(String stateEnum, String message) {
                    BridgeWebView bridgeWebView;
                    Intrinsics.h(stateEnum, "stateEnum");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("state", stateEnum);
                    jSONObject.put("msg", message);
                    bridgeWebView = WebJavascriptInterface.this.customWebView;
                    bridgeWebView.sendResponse(jSONObject.toString(), callbackId);
                }
            });
        }
    }

    @JavascriptInterface
    public void openToast(String data, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public void request(String data, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
    }

    public String send(String s) {
        Intrinsics.h(s, "s");
        return "send";
    }

    @JavascriptInterface
    public final void showDetectList(String data, final String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb = new StringBuilder();
        sb.append("showDetectList:");
        sb.append(data);
        sb.append(", callbackId: ");
        sb.append(callbackId);
        sb.append(" ");
        sb.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.i
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.showDetectList$lambda$1(WebJavascriptInterface.this, callbackId);
            }
        });
    }

    @JavascriptInterface
    public void startPage(String pageName, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
    }

    @JavascriptInterface
    public final void submitFromWeb(String data, final String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        String name = Thread.currentThread().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(data);
        sb.append(", callbackId: ");
        sb.append(callbackId);
        sb.append(" ");
        sb.append(name);
        if (TextUtils.isEmpty(callbackId)) {
            return;
        }
        this.customWebView.post(new Runnable() { // from class: com.transsion.web.api.n
            @Override // java.lang.Runnable
            public final void run() {
                WebJavascriptInterface.submitFromWeb$lambda$0(WebJavascriptInterface.this, callbackId);
            }
        });
    }
}
