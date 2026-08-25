package com.cloud.tmc.miniapp.dialog;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.ext.SpannableExtKt;
import com.cloud.tmc.integration.utils.ext.TextViewExtKt;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.bridge.PrivacyBridge;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniutils.util.BarUtils;
import com.cloud.tmc.miniutils.util.SizeUtils;
import com.google.gson.JsonObject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class o0O0O00 extends OooO0O0.OooO00o<oo0o0Oo> {
    public final App OooO00o;
    public final BridgeCallback OooO0O0;
    public final Lazy OooO0OO;
    public final Lazy OooO0Oo;
    public final Lazy OooO0o;
    public final Lazy OooO0o0;
    public final Lazy OooO0oO;

    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        public Object invoke() {
            return (TextView) o0O0O00.this.findViewById(R.id.tv_privacy_agreement_title);
        }
    }

    public static final class OooO00o implements OooO0O0.Oooo000 {
        public OooO00o() {
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = o0O0O00.this.OooO00o;
            String appId = app != null ? app.getAppId() : null;
            Bundle bundle = new Bundle();
            App app2 = o0O0O00.this.OooO00o;
            bundle.putString("miniappid", app2 != null ? app2.getAppId() : null);
            Unit unit = Unit.a;
            performanceAnalyseProxy.recordForCommon(appId, "miniapp_agree_popup_ex", bundle);
        }
    }

    public static final class OooO0O0 implements OooO0O0.OooOOO0 {
        public OooO0O0() {
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOOO0
        public void OooO00o(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            AppContext appContext;
            try {
                App app = o0O0O00.this.OooO00o;
                Object context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
                MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
                if (miniAppActivity != null) {
                    miniAppActivity.capsuleSetOnRightClick(true);
                }
            } catch (Throwable th) {
                TmcLogger.e("PrivacyAgreementSimpleDialog", th);
            }
        }
    }

    public static final class OooO0OO extends Lambda implements Function0<TextView> {
        public OooO0OO() {
            super(0);
        }

        public Object invoke() {
            return (TextView) o0O0O00.this.findViewById(R.id.tv_privacy_agree);
        }
    }

    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        public Object invoke() {
            return (TextView) o0O0O00.this.findViewById(R.id.tv_privacy_agreement_please_read);
        }
    }

    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) o0O0O00.this.findViewById(R.id.tv_privacy_cancel);
        }
    }

    public static final class OooOO0O extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o0O0O00 OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooOO0O(String str, o0O0O00 o0o0o00) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o0o0o00;
        }

        public Object invoke(Object obj) {
            Intrinsics.h((View) obj, "it");
            WebViewActivity.Companion.launch$default(WebViewActivity.Companion, this.OooO0O0.getContext(), UrlKt.appendCommonParamUrl(TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/user-agreement?lang=" : this.OooO00o, this.OooO0O0.getContext()), null, null, 12, null);
            return Unit.a;
        }
    }

    public static final class OooOOO extends Lambda implements Function0<View> {
        public OooOOO() {
            super(0);
        }

        public Object invoke() {
            return o0O0O00.this.findViewById(R.id.view_navigetion_bar);
        }
    }

    public static final class OooOOO0 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o0O0O00 OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooOOO0(String str, o0O0O00 o0o0o00) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o0o0o00;
        }

        public Object invoke(Object obj) {
            Intrinsics.h((View) obj, "it");
            WebViewActivity.Companion.launch$default(WebViewActivity.Companion, this.OooO0O0.getContext(), UrlKt.appendCommonParamUrl(TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/privacy-policy?lang=" : this.OooO00o, this.OooO0O0.getContext()), null, null, 12, null);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0O0O00(Context context, App app, BridgeCallback bridgeCallback) {
        super(context);
        Intrinsics.h(context, "context");
        this.OooO00o = app;
        this.OooO0O0 = bridgeCallback;
        this.OooO0OO = LazyKt.b(new OooO());
        this.OooO0Oo = LazyKt.b(new OooO0o());
        this.OooO0o0 = LazyKt.b(new OooOO0());
        this.OooO0o = LazyKt.b(new OooO0OO());
        this.OooO0oO = LazyKt.b(new OooOOO());
        try {
            setContentView(R.layout.mini_layout_privacy_agreement_smiple_dialog);
            setBackgroundDimEnabled(true);
            setCancelable(true);
            TextView OooO00o2 = OooO00o();
            if (OooO00o2 != null) {
                OooO00o2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o0O0O00.OooO00o(o0O0O00.this, view);
                    }
                });
            }
            TextView OooO0OO2 = OooO0OO();
            if (OooO0OO2 != null) {
                OooO0OO2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        o0O0O00.OooO0O0(o0O0O00.this, view);
                    }
                });
            }
            addOnShowListener(new OooO00o());
            addOnCancelListener(new OooO0O0());
        } catch (Throwable th) {
            TmcLogger.e("PrivacyAgreementSimpleDialog", "updateDialogLayout", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0091 A[Catch: all -> 0x008b, TRY_ENTER, TryCatch #2 {all -> 0x008b, blocks: (B:12:0x0091, B:14:0x00a7, B:15:0x00aa, B:17:0x00b2, B:18:0x00b8, B:20:0x00c3, B:21:0x00c7, B:37:0x0085, B:42:0x0038, B:5:0x0016, B:7:0x001e, B:8:0x0026, B:28:0x003d, B:30:0x0043, B:32:0x0049, B:34:0x005c), top: B:4:0x0016, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a7 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:12:0x0091, B:14:0x00a7, B:15:0x00aa, B:17:0x00b2, B:18:0x00b8, B:20:0x00c3, B:21:0x00c7, B:37:0x0085, B:42:0x0038, B:5:0x0016, B:7:0x001e, B:8:0x0026, B:28:0x003d, B:30:0x0043, B:32:0x0049, B:34:0x005c), top: B:4:0x0016, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b2 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:12:0x0091, B:14:0x00a7, B:15:0x00aa, B:17:0x00b2, B:18:0x00b8, B:20:0x00c3, B:21:0x00c7, B:37:0x0085, B:42:0x0038, B:5:0x0016, B:7:0x001e, B:8:0x0026, B:28:0x003d, B:30:0x0043, B:32:0x0049, B:34:0x005c), top: B:4:0x0016, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c3 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:12:0x0091, B:14:0x00a7, B:15:0x00aa, B:17:0x00b2, B:18:0x00b8, B:20:0x00c3, B:21:0x00c7, B:37:0x0085, B:42:0x0038, B:5:0x0016, B:7:0x001e, B:8:0x0026, B:28:0x003d, B:30:0x0043, B:32:0x0049, B:34:0x005c), top: B:4:0x0016, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OooO00o(o0O0O00 o0o0o00, View view) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        Intrinsics.h(o0o0o00, "this$0");
        App app = o0o0o00.OooO00o;
        BridgeCallback bridgeCallback = o0o0o00.OooO0O0;
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        try {
            try {
                ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).recordForCommon(app != null ? app.getAppId() : null, "privacy_click", new Bundle());
                DeviceUtil.INSTANCE.updateIsNewUserStatus("");
            } finally {
                if (app != null) {
                }
                if (bridgeCallback != null) {
                }
                if (bridgeCallback != null) {
                }
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                if (app == null) {
                }
                Bundle bundle = new Bundle();
                bundle.putString("miniappid", app != null ? app.getAppId() : null);
                bundle.putString("content", "1");
                Unit unit = Unit.a;
                performanceAnalyseProxy.recordForCommon(r2, "miniapp_agree_popup_click", bundle);
            }
            if (app != null) {
                try {
                    AppContext appContext = app.getAppContext();
                    if (appContext != null && appContext.getContext() != null) {
                        PrivacyBridge.Companion.getClass();
                        concurrentHashMap = PrivacyBridge.OooO0OO;
                        if (concurrentHashMap.containsKey(app.getAppId())) {
                            concurrentHashMap2 = PrivacyBridge.OooO0OO;
                            concurrentHashMap2.remove(app.getAppId());
                            PermissionDialogPoint create = ExtensionPoint.as(PermissionDialogPoint.class).create();
                            String appId = app.getAppId();
                            Intrinsics.g(appId, "app.appId");
                            create.privacyDialogDismiss(appId, app.getStartToken());
                        }
                    }
                } catch (Throwable th) {
                    TmcLogger.e("PrivacyAgreementSimpleDialog", "privacyDialogDismiss", th);
                }
            }
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "agreeClick");
                jsonObject.addProperty("clickBtn", "1");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
            if (bridgeCallback != null) {
                bridgeCallback.close();
            }
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            String appId2 = app == null ? app.getAppId() : null;
            Bundle bundle2 = new Bundle();
            bundle2.putString("miniappid", app != null ? app.getAppId() : null);
            bundle2.putString("content", "1");
            Unit unit2 = Unit.a;
            performanceAnalyseProxy2.recordForCommon(appId2, "miniapp_agree_popup_click", bundle2);
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final void OooO0O0(o0O0O00 o0o0o00, View view) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        Intrinsics.h(o0o0o00, "this$0");
        try {
            BridgeCallback bridgeCallback = o0o0o00.OooO0O0;
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "cancel");
                jsonObject.addProperty("clickBtn", "2");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
            BridgeCallback bridgeCallback2 = o0o0o00.OooO0O0;
            if (bridgeCallback2 != null) {
                bridgeCallback2.close();
            }
            try {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                App app = o0o0o00.OooO00o;
                String appId = app != null ? app.getAppId() : null;
                Bundle bundle = new Bundle();
                App app2 = o0o0o00.OooO00o;
                bundle.putString("miniappid", app2 != null ? app2.getAppId() : null);
                bundle.putString("content", "0");
                Unit unit = Unit.a;
                performanceAnalyseProxy.recordForCommon(appId, "miniapp_agree_popup_click", bundle);
            } catch (Throwable unused) {
            }
            o0o0o00.dismiss();
            PrivacyBridge.Companion.getClass();
            concurrentHashMap = PrivacyBridge.OooO0OO;
            App app3 = o0o0o00.OooO00o;
            if (concurrentHashMap.containsKey(app3 != null ? app3.getAppId() : null)) {
                concurrentHashMap2 = PrivacyBridge.OooO0OO;
                App app4 = o0o0o00.OooO00o;
                TypeIntrinsics.d(concurrentHashMap2).remove(app4 != null ? app4.getAppId() : null);
            }
        } catch (Throwable th) {
            TmcLogger.e("PrivacyAgreementSimpleDialog", "tvPrivacyCancel error", th);
        }
    }

    public final TextView OooO00o() {
        return (TextView) this.OooO0o.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
    
        if (r26.length() <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        r0 = OooO0OO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        r0.setText(r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
    
        if (r2 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x009e, code lost:
    
        if (r2 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0085, code lost:
    
        if (r1 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final o0O0O00 OooO00o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, boolean z, boolean z2) {
        String string;
        String string2;
        String string3;
        String str9;
        TextView OooO00o2;
        TextView textView;
        Intrinsics.h(str, "title");
        String str10 = str3;
        Intrinsics.h(str10, "privacyPolocyContent");
        Intrinsics.h(str4, "userAgreementContent");
        Intrinsics.h(str5, "privacyPolocyUrl");
        Intrinsics.h(str6, "userAgreementUrl");
        try {
            TextView textView2 = (TextView) this.OooO0OO.getValue();
            if (textView2 != null) {
                textView2.setText(str);
            }
            if (i != 0 && (textView = (TextView) this.OooO0OO.getValue()) != null) {
                textView.setMaxLines(i);
            }
            if (str8 != null && str8.length() > 0 && (OooO00o2 = OooO00o()) != null) {
                OooO00o2.setText(str8);
            }
            if (z) {
                string = str2;
            } else if (z2) {
                string = getString(R.string.mini_privacy_reading_notice_only_en);
                if (string == null) {
                    string = "";
                }
            } else {
                string = getString(R.string.mini_privacy_reading_notice);
            }
            if (!z) {
                if (z2) {
                    string2 = getString(R.string.mini_privacy_privacy_policy_only_en);
                    if (string2 == null) {
                        str10 = "";
                    }
                    str10 = string2;
                } else {
                    string2 = getString(R.string.mini_privacy_privacy_policy);
                }
            }
            if (z) {
                str9 = str4;
            } else if (z2) {
                string3 = getString(R.string.mini_privacy_user_agreement_only_en);
                if (string3 == null) {
                    str9 = "";
                }
                str9 = string3;
            } else {
                string3 = getString(R.string.mini_privacy_user_agreement);
            }
            if (string != null) {
                OooO00o(string, StringsKt.o0(string, "#", 0, false, 6, (Object) null), str10, str5, StringsKt.v0(string, "#", 0, false, 6, (Object) null), StringsKt.o0(string, "*", 0, false, 6, (Object) null), str9, str6, StringsKt.v0(string, "*", 0, false, 6, (Object) null));
            }
            TextView OooO00o3 = OooO00o();
            if (OooO00o3 != null) {
                OooO00o3.setText(str8);
            }
            TextView OooO0OO2 = OooO0OO();
            if (OooO0OO2 != null) {
                OooO0OO2.setText(str7);
            }
            TextView OooO0O02 = OooO0O0();
            if (OooO0O02 != null) {
                OooO0O02.setMovementMethod(LinkMovementMethod.getInstance());
            }
            TextView OooO0O03 = OooO0O0();
            if (OooO0O03 != null) {
                TextViewExtKt.transparentHighlightColor(OooO0O03);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public final void OooO00o(Window window) {
        Intrinsics.h(window, "window");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            l.a(window, false);
        }
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 512);
        window.setNavigationBarColor(0);
        Object systemService = getContext().getSystemService("uimode");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
        ((UiModeManager) systemService).getNightMode();
        Intrinsics.h(window, "window");
        if (i >= 26) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 16);
        }
    }

    public final void OooO00o(String str, int i, String str2, String str3, int i2, int i3, String str4, String str5, int i4) {
        TextView OooO0O02 = OooO0O0();
        if (OooO0O02 == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(str.subSequence(0, i));
        SpannableExtKt.appendClickable(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str4), Integer.valueOf(getColor(R.color.mini_color_primary)), false, new OooOO0O(str5, this));
        try {
            spannableStringBuilder.setSpan(new StyleSpan(1), i, str4.length() + i, 33);
        } catch (Throwable unused) {
        }
        try {
            spannableStringBuilder.append(str.subSequence(i2 + 1, i3));
        } catch (Throwable unused2) {
        }
        SpannableExtKt.appendClickable(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str2), Integer.valueOf(getColor(R.color.mini_color_primary)), false, new OooOOO0(str3, this));
        try {
            int length = (i3 + str4.length()) - 4;
            spannableStringBuilder.setSpan(new StyleSpan(1), length, str2.length() + length, 33);
        } catch (Throwable unused3) {
        }
        try {
            spannableStringBuilder.append(str.subSequence(i4 + 1, str.length()));
        } catch (Throwable unused4) {
        }
        OooO0O02.setText(new SpannedString(spannableStringBuilder));
    }

    public final TextView OooO0O0() {
        return (TextView) this.OooO0Oo.getValue();
    }

    public final TextView OooO0OO() {
        return (TextView) this.OooO0o0.getValue();
    }

    public final void OooO0Oo() {
        Window window;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                int navBarHeight = BarUtils.getNavBarHeight();
                if (navBarHeight <= 50) {
                    SizeUtils.dp2px(28.0f);
                    return;
                }
                androidx.appcompat.app.w dialog = getDialog();
                if (dialog == null || (window = dialog.getWindow()) == null) {
                    return;
                }
                OooO00o(window);
                View view = (View) this.OooO0oO.getValue();
                ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
                int dp2px = navBarHeight + SizeUtils.dp2px(16.0f);
                if (layoutParams != null) {
                    layoutParams.height = dp2px;
                }
                View view2 = (View) this.OooO0oO.getValue();
                if (view2 != null) {
                    view2.setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            TmcLogger.e("PrivacyAgreementSimpleDialog", th);
        }
    }
}
