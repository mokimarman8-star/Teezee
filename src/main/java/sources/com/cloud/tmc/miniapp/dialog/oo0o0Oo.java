package com.cloud.tmc.miniapp.dialog;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.invoke.extension.ExtensionPoint;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.integration.point.PermissionDialogPoint;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.integration.utils.MccMncUtils;
import com.cloud.tmc.integration.utils.MiniForceAddHomeManager;
import com.cloud.tmc.integration.utils.ext.SpannableExtKt;
import com.cloud.tmc.integration.utils.ext.TextViewExtKt;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class oo0o0Oo extends OooO0O0.OooO00o<oo0o0Oo> {
    public final int OooO;
    public final App OooO00o;
    public final BridgeCallback OooO0O0;
    public String OooO0OO;
    public boolean OooO0Oo;
    public boolean OooO0o;
    public boolean OooO0o0;
    public final String OooO0oO;
    public final int OooO0oo;
    public final String OooOO0;
    public final String OooOO0O;
    public final Lazy OooOO0o;
    public final Lazy OooOOO;
    public final Lazy OooOOO0;
    public final Lazy OooOOOO;
    public final Lazy OooOOOo;
    public final Lazy OooOOo;
    public final Lazy OooOOo0;
    public final Lazy OooOOoo;
    public final Lazy OooOo;
    public final Lazy OooOo0;
    public final Lazy OooOo00;
    public final Lazy OooOo0O;
    public final Lazy OooOo0o;
    public final Lazy OooOoO;
    public final Lazy OooOoO0;
    public final Lazy OooOoOO;
    public final Lazy OooOoo;
    public final Lazy OooOoo0;
    public final Lazy OooOooO;
    public final Lazy OooOooo;
    public boolean Oooo;
    public final Lazy Oooo0;
    public final Lazy Oooo000;
    public final Lazy Oooo00O;
    public final Lazy Oooo00o;
    public final Lazy Oooo0O0;
    public final Lazy Oooo0OO;
    public final Lazy Oooo0o;
    public final Lazy Oooo0o0;
    public final Lazy Oooo0oO;
    public final Lazy Oooo0oo;
    public int OoooO0;
    public boolean OoooO00;

    public static final class OooO extends Lambda implements Function0<Group> {
        public OooO() {
            super(0);
        }

        public Object invoke() {
            return oo0o0Oo.this.findViewById(R.id.group_addhome_btn);
        }
    }

    public static final class OooO00o implements OooO0O0.Oooo000 {
        public OooO00o() {
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            oo0o0Oo oo0o0oo = oo0o0Oo.this;
            if (Intrinsics.c(oo0o0oo.OooO0OO, oo0o0oo.OooOO0)) {
                PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                App app = oo0o0Oo.this.OooO00o;
                String appId = app != null ? app.getAppId() : null;
                Bundle bundle = new Bundle();
                App app2 = oo0o0Oo.this.OooO00o;
                bundle.putString("miniappid", app2 != null ? app2.getAppId() : null);
                Unit unit = Unit.a;
                performanceAnalyseProxy.recordForCommon(appId, "miniapp_agreemix_popup_ex", bundle);
                return;
            }
            oo0o0Oo oo0o0oo2 = oo0o0Oo.this;
            if (Intrinsics.c(oo0o0oo2.OooO0OO, oo0o0oo2.OooOO0O)) {
                PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                App app3 = oo0o0Oo.this.OooO00o;
                String appId2 = app3 != null ? app3.getAppId() : null;
                Bundle bundle2 = new Bundle();
                App app4 = oo0o0Oo.this.OooO00o;
                bundle2.putString("miniappid", app4 != null ? app4.getAppId() : null);
                Unit unit2 = Unit.a;
                performanceAnalyseProxy2.recordForCommon(appId2, "miniapp_agree_popup_ex", bundle2);
                return;
            }
            if (oo0o0Oo.this.OooO0Oo) {
                PerformanceAnalyseProxy performanceAnalyseProxy3 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                App app5 = oo0o0Oo.this.OooO00o;
                performanceAnalyseProxy3.recordForCommon(app5 != null ? app5.getAppId() : null, "privacy_ex", new Bundle());
            }
            oo0o0Oo oo0o0oo3 = oo0o0Oo.this;
            if (oo0o0oo3.OooO0o0) {
                if (oo0o0oo3.OooO0o) {
                    PerformanceAnalyseProxy performanceAnalyseProxy4 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                    App app6 = oo0o0Oo.this.OooO00o;
                    String appId3 = app6 != null ? app6.getAppId() : null;
                    Bundle bundle3 = new Bundle();
                    App app7 = oo0o0Oo.this.OooO00o;
                    bundle3.putString("miniappid", app7 != null ? app7.getAppId() : null);
                    bundle3.putString(NativeComponentConstants.KEY_COMPONENT_TYPE, "2");
                    Unit unit3 = Unit.a;
                    performanceAnalyseProxy4.recordForCommon(appId3, "appstart_add_ex", bundle3);
                    return;
                }
                ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
                App app8 = oo0o0Oo.this.OooO00o;
                String appId4 = app8 != null ? app8.getAppId() : null;
                if (appId4 == null) {
                    appId4 = "";
                }
                Bundle bundle4 = new Bundle();
                App app9 = oo0o0Oo.this.OooO00o;
                bundle4.putString("miniappid", app9 != null ? app9.getAppId() : null);
                bundle4.putString(NativeComponentConstants.KEY_COMPONENT_TYPE, "1");
                Unit unit4 = Unit.a;
                reportProxy.forceAthenaReport(appId4, "appstart_add_ex", 3755, bundle4);
            }
        }
    }

    public static final class OooO0O0 implements OooO0O0.OooOOO0 {
        public OooO0O0() {
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOOO0
        public void OooO00o(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            AppContext appContext;
            try {
                App app = oo0o0Oo.this.OooO00o;
                Object context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
                MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
                if (miniAppActivity != null) {
                    miniAppActivity.capsuleSetOnRightClick(true);
                }
            } catch (Throwable th) {
                TmcLogger.e(oo0o0Oo.this.OooO0oO, th);
            }
        }
    }

    public static final class OooO0OO extends Lambda implements Function0<ConstraintLayout> {
        public OooO0OO() {
            super(0);
        }

        public Object invoke() {
            return oo0o0Oo.this.findViewById(R.id.tv_privacy_agreement_container);
        }
    }

    public static final class OooO0o extends Lambda implements Function0<ConstraintLayout> {
        public OooO0o() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return OooO00o.findViewById(R.id.cl_two_in_one_container);
            }
            return null;
        }
    }

    public static final class OooOO0 extends Lambda implements Function0<Group> {
        public OooOO0() {
            super(0);
        }

        public Object invoke() {
            return oo0o0Oo.this.findViewById(R.id.group_privacy_btn);
        }
    }

    public static final class OooOO0O extends Lambda implements Function0<Group> {
        public OooOO0O() {
            super(0);
        }

        public Object invoke() {
            return oo0o0Oo.this.findViewById(R.id.group_privacy_tv);
        }
    }

    public static final class OooOOO extends Lambda implements Function0<ImageView> {
        public OooOOO() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (ImageView) OooO00o.findViewById(R.id.iv_first_privacy_checkbox);
            }
            return null;
        }
    }

    public static final class OooOOO0 extends Lambda implements Function0<Group> {
        public OooOOO0() {
            super(0);
        }

        public Object invoke() {
            return oo0o0Oo.this.findViewById(R.id.group_add_home_layout);
        }
    }

    public static final class OooOOOO extends Lambda implements Function0<ImageView> {
        public OooOOOO() {
            super(0);
        }

        public Object invoke() {
            return (ImageView) oo0o0Oo.this.findViewById(R.id.iv_logo);
        }
    }

    public static final class OooOo extends Lambda implements Function0<NestedScrollView> {
        public OooOo() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return OooO00o.findViewById(R.id.ns_two_in_one_layout);
            }
            return null;
        }
    }

    public static final class OooOo00 extends Lambda implements Function0<ImageView> {
        public OooOo00() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (ImageView) OooO00o.findViewById(R.id.iv_second_privacy_checkbox);
            }
            return null;
        }
    }

    public static final class Oooo0 extends Lambda implements Function0<TextView> {
        public Oooo0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) oo0o0Oo.this.findViewById(R.id.tv_agree);
        }
    }

    public static final class Oooo000 extends Lambda implements Function0<TextView> {
        public Oooo000() {
            super(0);
        }

        public Object invoke() {
            return (TextView) oo0o0Oo.this.findViewById(R.id.tv_addhome_exit);
        }
    }

    public static final class o0000 extends Lambda implements Function0<View> {
        public o0000() {
            super(0);
        }

        public Object invoke() {
            ViewStub viewStub = (ViewStub) oo0o0Oo.this.findViewById(R.id.view_stub_two_in_one);
            if (viewStub != null) {
                return viewStub.inflate();
            }
            return null;
        }
    }

    public static final class o00000 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ oo0o0Oo OooO0O0;
        public final /* synthetic */ boolean OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o00000(String str, oo0o0Oo oo0o0oo, boolean z) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = oo0o0oo;
            this.OooO0OO = z;
        }

        public Object invoke(Object obj) {
            Intrinsics.h((View) obj, "it");
            String str = TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/user-agreement?lang=" : this.OooO00o;
            WebViewActivity.Companion companion = WebViewActivity.Companion;
            Context context = this.OooO0O0.getContext();
            if (!this.OooO0OO) {
                str = UrlKt.appendCommonParamUrl(str, this.OooO0O0.getContext());
            }
            WebViewActivity.Companion.launch$default(companion, context, str, null, null, 12, null);
            return Unit.a;
        }
    }

    public static final class o000000 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ oo0o0Oo OooO0O0;
        public final /* synthetic */ boolean OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o000000(String str, oo0o0Oo oo0o0oo, boolean z) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = oo0o0oo;
            this.OooO0OO = z;
        }

        public Object invoke(Object obj) {
            Intrinsics.h((View) obj, "it");
            String str = TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/user-agreement?lang=" : this.OooO00o;
            WebViewActivity.Companion companion = WebViewActivity.Companion;
            Context context = this.OooO0O0.getContext();
            if (!this.OooO0OO) {
                str = UrlKt.appendCommonParamUrl(str, this.OooO0O0.getContext());
            }
            WebViewActivity.Companion.launch$default(companion, context, str, null, null, 12, null);
            return Unit.a;
        }
    }

    public static final class o000000O extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ oo0o0Oo OooO0O0;
        public final /* synthetic */ boolean OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o000000O(String str, oo0o0Oo oo0o0oo, boolean z) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = oo0o0oo;
            this.OooO0OO = z;
        }

        public Object invoke(Object obj) {
            Intrinsics.h((View) obj, "it");
            String str = TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/privacy-policy?lang=" : this.OooO00o;
            WebViewActivity.Companion companion = WebViewActivity.Companion;
            Context context = this.OooO0O0.getContext();
            if (!this.OooO0OO) {
                str = UrlKt.appendCommonParamUrl(str, this.OooO0O0.getContext());
            }
            WebViewActivity.Companion.launch$default(companion, context, str, null, null, 12, null);
            return Unit.a;
        }
    }

    public static final class o00000O extends Lambda implements Function0<View> {
        public o00000O() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return OooO00o.findViewById(R.id.view_first_click);
            }
            return null;
        }
    }

    public static final class o00000O0 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ oo0o0Oo OooO0O0;
        public final /* synthetic */ boolean OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o00000O0(String str, oo0o0Oo oo0o0oo, boolean z) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = oo0o0oo;
            this.OooO0OO = z;
        }

        public Object invoke(Object obj) {
            Intrinsics.h((View) obj, "it");
            String str = TextUtils.isEmpty(this.OooO00o) ? "https://h5.dlight-app.com/outside/privacy-policy?lang=" : this.OooO00o;
            WebViewActivity.Companion companion = WebViewActivity.Companion;
            Context context = this.OooO0O0.getContext();
            if (!this.OooO0OO) {
                str = UrlKt.appendCommonParamUrl(str, this.OooO0O0.getContext());
            }
            WebViewActivity.Companion.launch$default(companion, context, str, null, null, 12, null);
            return Unit.a;
        }
    }

    public static final class o00000OO extends Lambda implements Function0<View> {
        public o00000OO() {
            super(0);
        }

        public Object invoke() {
            return oo0o0Oo.this.findViewById(R.id.view_navigetion_bar);
        }
    }

    public static final class o0000Ooo extends Lambda implements Function0<View> {
        public o0000Ooo() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return OooO00o.findViewById(R.id.view_second_click);
            }
            return null;
        }
    }

    public static final class o000OOo extends Lambda implements Function0<TextView> {
        public o000OOo() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (TextView) OooO00o.findViewById(R.id.tv_two_in_one_title);
            }
            return null;
        }
    }

    public static final class o000oOoO extends Lambda implements Function0<TextView> {
        public o000oOoO() {
            super(0);
        }

        public Object invoke() {
            return (TextView) oo0o0Oo.this.findViewById(R.id.tv_app_name);
        }
    }

    public static final class o00O0O extends Lambda implements Function0<TextView> {
        public o00O0O() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (TextView) OooO00o.findViewById(R.id.tv_first_privacy_title);
            }
            return null;
        }
    }

    public static final class o00Oo0 extends Lambda implements Function0<TextView> {
        public o00Oo0() {
            super(0);
        }

        public Object invoke() {
            return (TextView) oo0o0Oo.this.findViewById(R.id.tv_privacy_agree);
        }
    }

    public static final class o00Ooo extends Lambda implements Function0<TextView> {
        public o00Ooo() {
            super(0);
        }

        public Object invoke() {
            return (TextView) oo0o0Oo.this.findViewById(R.id.tv_privacy_agreement_please_read);
        }
    }

    public static final class o00oO0o extends Lambda implements Function0<TextView> {
        public o00oO0o() {
            super(0);
        }

        public Object invoke() {
            return (TextView) oo0o0Oo.this.findViewById(R.id.tv_privacy_cancel);
        }
    }

    public static final class o0O0O00 extends Lambda implements Function0<TextView> {
        public o0O0O00() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (TextView) OooO00o.findViewById(R.id.tv_two_in_one_gdpr_content);
            }
            return null;
        }
    }

    public static final class o0OO00O extends Lambda implements Function0<TextView> {
        public o0OO00O() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (TextView) OooO00o.findViewById(R.id.tv_two_in_one_agree);
            }
            return null;
        }
    }

    public static final class o0OOO0o extends Lambda implements Function0<TextView> {
        public o0OOO0o() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (TextView) OooO00o.findViewById(R.id.tv_second_privacy_content);
            }
            return null;
        }
    }

    public static final class o0Oo0oo extends Lambda implements Function0<TextView> {
        public o0Oo0oo() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (TextView) OooO00o.findViewById(R.id.tv_second_privacy_title);
            }
            return null;
        }
    }

    public static final class o0OoOo0 extends Lambda implements Function0<TextView> {
        public o0OoOo0() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (TextView) OooO00o.findViewById(R.id.tv_first_privacy_content);
            }
            return null;
        }
    }

    public static final class o0ooOOo extends Lambda implements Function0<TextView> {
        public o0ooOOo() {
            super(0);
        }

        public Object invoke() {
            return (TextView) oo0o0Oo.this.findViewById(R.id.tv_privacy_gdpr_content);
        }
    }

    public static final class oo000o extends Lambda implements Function0<TextView> {
        public oo000o() {
            super(0);
        }

        public Object invoke() {
            return (TextView) oo0o0Oo.this.findViewById(R.id.tv_privacy_agreement_title);
        }
    }

    /* renamed from: com.cloud.tmc.miniapp.dialog.oo0o0Oo$oo0o0Oo, reason: collision with other inner class name */
    public static final class C0013oo0o0Oo extends Lambda implements Function0<TextView> {
        public C0013oo0o0Oo() {
            super(0);
        }

        public Object invoke() {
            View OooO00o = oo0o0Oo.OooO00o(oo0o0Oo.this);
            if (OooO00o != null) {
                return (TextView) OooO00o.findViewById(R.id.tv_two_in_one_cancel);
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo0o0Oo(Context context, App app, BridgeCallback bridgeCallback) {
        super(context);
        Intrinsics.h(context, "context");
        this.OooO00o = app;
        this.OooO0O0 = bridgeCallback;
        this.OooO0OO = "";
        this.OooO0oO = "PrivacyAgreementDialog";
        this.OooO0oo = 1;
        this.OooO = 2;
        this.OooOO0 = "1";
        this.OooOO0O = "2";
        this.OooOO0o = LazyKt.b(new OooO0OO());
        this.OooOOO0 = LazyKt.b(new oo000o());
        this.OooOOO = LazyKt.b(new o00Ooo());
        this.OooOOOO = LazyKt.b(new OooOOO0());
        this.OooOOOo = LazyKt.b(new OooOOOO());
        this.OooOOo0 = LazyKt.b(new Oooo0());
        this.OooOOo = LazyKt.b(new Oooo000());
        this.OooOOoo = LazyKt.b(new o000oOoO());
        this.OooOo00 = LazyKt.b(new OooOO0O());
        this.OooOo0 = LazyKt.b(new OooOO0());
        this.OooOo0O = LazyKt.b(new o0ooOOo());
        this.OooOo0o = LazyKt.b(new o00Oo0());
        this.OooOo = LazyKt.b(new o00oO0o());
        this.OooOoO0 = LazyKt.b(new o00000OO());
        this.OooOoO = LazyKt.b(new OooO());
        this.OooOoOO = LazyKt.b(new o0000());
        this.OooOoo0 = LazyKt.b(new OooO0o());
        this.OooOoo = LazyKt.b(new OooOo());
        this.OooOooO = LazyKt.b(new o000OOo());
        this.OooOooo = LazyKt.b(new o0OO00O());
        this.Oooo000 = LazyKt.b(new C0013oo0o0Oo());
        this.Oooo00O = LazyKt.b(new OooOOO());
        this.Oooo00o = LazyKt.b(new o00O0O());
        this.Oooo0 = LazyKt.b(new o0OoOo0());
        this.Oooo0O0 = LazyKt.b(new OooOo00());
        this.Oooo0OO = LazyKt.b(new o0Oo0oo());
        this.Oooo0o0 = LazyKt.b(new o0OOO0o());
        this.Oooo0o = LazyKt.b(new o0O0O00());
        this.Oooo0oO = LazyKt.b(new o00000O());
        this.Oooo0oo = LazyKt.b(new o0000Ooo());
        try {
            setContentView(R.layout.mini_layout_privacy_agreement_dialog);
            setBackgroundDimEnabled(true);
            setCancelable(true);
            TextView OooO0o0 = OooO0o0();
            if (OooO0o0 != null) {
                OooO0o0.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        oo0o0Oo.OooO00o(oo0o0Oo.this, view);
                    }
                });
            }
            TextView OooO0oO = OooO0oO();
            if (OooO0oO != null) {
                OooO0oO.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        oo0o0Oo.OooO0O0(oo0o0Oo.this, view);
                    }
                });
            }
            TextView OooO0Oo = OooO0Oo();
            if (OooO0Oo != null) {
                OooO0Oo.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.z
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        oo0o0Oo.OooO0OO(oo0o0Oo.this, view);
                    }
                });
            }
            TextView OooO0OO2 = OooO0OO();
            if (OooO0OO2 != null) {
                OooO0OO2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.a0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        oo0o0Oo.OooO0Oo(oo0o0Oo.this, view);
                    }
                });
            }
            addOnShowListener(new OooO00o());
            addOnCancelListener(new OooO0O0());
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0oO, "updateDialogLayout", th);
        }
    }

    public static final View OooO00o(oo0o0Oo oo0o0oo) {
        return (View) oo0o0oo.OooOoOO.getValue();
    }

    public static final void OooO00o(oo0o0Oo oo0o0oo, View view) {
        Intrinsics.h(oo0o0oo, "this$0");
        oo0o0oo.OooO00o(oo0o0oo.OooO00o, oo0o0oo.OooO0O0, oo0o0oo.OooO);
    }

    public static final void OooO00o(Ref.BooleanRef booleanRef, oo0o0Oo oo0o0oo) {
        Intrinsics.h(booleanRef, "$autoSelect");
        Intrinsics.h(oo0o0oo, "this$0");
        if (booleanRef.element) {
            oo0o0oo.Oooo = true;
            oo0o0oo.OoooO00 = true;
            ImageView OooO00o2 = oo0o0oo.OooO00o();
            if (OooO00o2 != null) {
                OooO00o2.setImageResource(R.drawable.mini_sel_privacy_checkbox_checked);
            }
            ImageView OooO0O02 = oo0o0oo.OooO0O0();
            if (OooO0O02 != null) {
                OooO0O02.setImageResource(R.drawable.mini_sel_privacy_checkbox_checked);
            }
        }
        oo0o0oo.OooOO0();
    }

    public static final void OooO0O0(final oo0o0Oo oo0o0oo) {
        Intrinsics.h(oo0o0oo, "this$0");
        try {
            String mcc = MccMncUtils.getMcc(oo0o0oo.getContext());
            TmcLogger.d(oo0o0oo.OooO0oO, "initAutoCheckStatus mcc:" + mcc);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (mcc.length() == 0) {
                booleanRef.element = true;
            } else {
                if (!StringsKt.c0("310,311,312,313,314,315,316,302,232,206,284,280,230,219,238,248,244,208,262,202,216,272,222,247,246,270,278,204,260,268,231,293,214,240,234,235,286,274,242,228,259,250,404,405", mcc, false, 2, (Object) null)) {
                    booleanRef.element = true;
                }
                MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.INSTANCE;
                String configTargetStr = miniAppConfigHelper.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_PRIVACY_AUTO_BLACK_COUNTRY, "");
                if (configTargetStr.length() <= 0 || !StringsKt.c0(configTargetStr, mcc, false, 2, (Object) null)) {
                    String configTargetStr2 = miniAppConfigHelper.getConfigTargetStr(LauncherMiniAppConfigHelper.KEY_PRIVACY_AUTO_WHITE_COUNTRY, "");
                    if (configTargetStr2.length() > 0 && StringsKt.c0(configTargetStr2, mcc, false, 2, (Object) null)) {
                        booleanRef.element = true;
                    }
                } else {
                    booleanRef.element = false;
                }
            }
            ExecutorUtils.execute(ExecutorType.UI, new Runnable() { // from class: com.cloud.tmc.miniapp.dialog.v
                @Override // java.lang.Runnable
                public final void run() {
                    oo0o0Oo.OooO00o(booleanRef, oo0o0oo);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static final void OooO0O0(oo0o0Oo oo0o0oo, View view) {
        Intrinsics.h(oo0o0oo, "this$0");
        try {
            BridgeCallback bridgeCallback = oo0o0oo.OooO0O0;
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "cancel");
                jsonObject.addProperty("clickBtn", "2");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
            BridgeCallback bridgeCallback2 = oo0o0oo.OooO0O0;
            if (bridgeCallback2 != null) {
                bridgeCallback2.close();
            }
            try {
                if (Intrinsics.c(oo0o0oo.OooO0OO, oo0o0oo.OooOO0O)) {
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                    App app = oo0o0oo.OooO00o;
                    String appId = app != null ? app.getAppId() : null;
                    Bundle bundle = new Bundle();
                    App app2 = oo0o0oo.OooO00o;
                    bundle.putString("miniappid", app2 != null ? app2.getAppId() : null);
                    bundle.putString("content", "0");
                    Unit unit = Unit.a;
                    performanceAnalyseProxy.recordForCommon(appId, "miniapp_agree_popup_click", bundle);
                }
            } catch (Throwable unused) {
            }
            oo0o0oo.dismiss();
        } catch (Throwable th) {
            TmcLogger.e(oo0o0oo.OooO0oO, "tvPrivacyCancel error", th);
        }
    }

    public static final void OooO0OO(oo0o0Oo oo0o0oo, View view) {
        Intrinsics.h(oo0o0oo, "this$0");
        oo0o0oo.OooO00o(oo0o0oo.OooO00o, oo0o0oo.OooO0O0, oo0o0oo.OooO0oo);
    }

    public static final void OooO0Oo(oo0o0Oo oo0o0oo, View view) {
        Intrinsics.h(oo0o0oo, "this$0");
        try {
            BridgeCallback bridgeCallback = oo0o0oo.OooO0O0;
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "cancel");
                jsonObject.addProperty("clickBtn", "4");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
            BridgeCallback bridgeCallback2 = oo0o0oo.OooO0O0;
            if (bridgeCallback2 != null) {
                bridgeCallback2.close();
            }
            oo0o0oo.dismiss();
        } catch (Throwable th) {
            TmcLogger.e(oo0o0oo.OooO0oO, "tvPrivacyCancel error", th);
        }
    }

    public static final void OooO0o(oo0o0Oo oo0o0oo, View view) {
        Intrinsics.h(oo0o0oo, "$this_apply");
        if (oo0o0oo.OoooO00) {
            ImageView OooO0O02 = oo0o0oo.OooO0O0();
            if (OooO0O02 != null) {
                OooO0O02.setImageResource(R.drawable.mini_sel_privacy_checkbox_unchecked);
            }
        } else {
            ImageView OooO0O03 = oo0o0oo.OooO0O0();
            if (OooO0O03 != null) {
                OooO0O03.setImageResource(R.drawable.mini_sel_privacy_checkbox_checked);
            }
        }
        oo0o0oo.OoooO00 = !oo0o0oo.OoooO00;
        oo0o0oo.OooOO0();
    }

    public static final void OooO0o0(oo0o0Oo oo0o0oo, View view) {
        Intrinsics.h(oo0o0oo, "$this_apply");
        if (oo0o0oo.Oooo) {
            ImageView OooO00o2 = oo0o0oo.OooO00o();
            if (OooO00o2 != null) {
                OooO00o2.setImageResource(R.drawable.mini_sel_privacy_checkbox_unchecked);
            }
        } else {
            ImageView OooO00o3 = oo0o0oo.OooO00o();
            if (OooO00o3 != null) {
                OooO00o3.setImageResource(R.drawable.mini_sel_privacy_checkbox_checked);
            }
        }
        oo0o0oo.Oooo = !oo0o0oo.Oooo;
        oo0o0oo.OooOO0();
    }

    public static final void OooO0oO(oo0o0Oo oo0o0oo, View view) {
        Intrinsics.h(oo0o0oo, "$this_apply");
        if (oo0o0oo.Oooo && oo0o0oo.OoooO00) {
            oo0o0oo.OooO00o(oo0o0oo.OooO00o, oo0o0oo.OooO0O0, oo0o0oo.OooO);
        }
    }

    public static final void OooO0oo(oo0o0Oo oo0o0oo, View view) {
        Intrinsics.h(oo0o0oo, "$this_apply");
        try {
            BridgeCallback bridgeCallback = oo0o0oo.OooO0O0;
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "cancel");
                jsonObject.addProperty("clickBtn", "2");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
            BridgeCallback bridgeCallback2 = oo0o0oo.OooO0O0;
            if (bridgeCallback2 != null) {
                bridgeCallback2.close();
            }
            oo0o0oo.dismiss();
        } catch (Throwable th) {
            TmcLogger.e(oo0o0oo.OooO0oO, "tvPrivacyCancel error", th);
        }
    }

    public final void OooO() {
        Window window;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                int navBarHeight = BarUtils.getNavBarHeight();
                if (navBarHeight <= 50) {
                    this.OoooO0 = SizeUtils.dp2px(28.0f);
                    return;
                }
                androidx.appcompat.app.w dialog = getDialog();
                if (dialog == null || (window = dialog.getWindow()) == null) {
                    return;
                }
                OooO00o(window);
                View view = (View) this.OooOoO0.getValue();
                ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
                int dp2px = navBarHeight + SizeUtils.dp2px(16.0f);
                this.OoooO0 = dp2px;
                if (layoutParams != null) {
                    layoutParams.height = dp2px;
                }
                View view2 = (View) this.OooOoO0.getValue();
                if (view2 != null) {
                    view2.setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0oO, th);
        }
    }

    public final ImageView OooO00o() {
        return (ImageView) this.Oooo00O.getValue();
    }

    public final oo0o0Oo OooO00o(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, boolean z3, boolean z4, String str8, String str9, String str10, String str11, boolean z5, boolean z6) {
        Intrinsics.h(str, "title");
        Intrinsics.h(str2, "baseContent");
        Intrinsics.h(str3, "privacyPolocyContent");
        Intrinsics.h(str4, "userAgreementContent");
        Intrinsics.h(str5, "buttonText");
        Intrinsics.h(str6, "privacyPolocyUrl");
        Intrinsics.h(str7, "userAgreementUrl");
        OooO00o(str, i, str2, str3, str4, str5, str6, str7, z, z2, z3, z4, str8, str9, str10, str11, this.OooO00o, z5, z6);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final oo0o0Oo OooO00o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i, boolean z, boolean z2) {
        String str19;
        String str20;
        int i2;
        int i3;
        String str21;
        String str22;
        String str23;
        TextView textView;
        View view;
        View view2;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        Intrinsics.h(str, "privacyDialogType");
        Intrinsics.h(str2, "title");
        Intrinsics.h(str3, "privacyTitle");
        String str24 = str4;
        Intrinsics.h(str24, "baseContent");
        String str25 = str5;
        Intrinsics.h(str25, "privacyPolocyContent");
        Intrinsics.h(str6, "userAgreementContent");
        String str26 = str7;
        Intrinsics.h(str26, "privacyPolocyUrl");
        String str27 = str8;
        Intrinsics.h(str27, "userAgreementUrl");
        Intrinsics.h(str9, "secondPrivacyTitle");
        Intrinsics.h(str10, "secondBaseContent");
        String str28 = str11;
        Intrinsics.h(str28, "secondPrivacyPolocyContent");
        Intrinsics.h(str12, "secondUserAgreementContent");
        Intrinsics.h(str13, "secondPrivacyPolocyUrl");
        Intrinsics.h(str14, "secondUserAgreementUrl");
        Intrinsics.h(str15, "gdprNoticeContent");
        Intrinsics.h(str16, "highlightContent");
        Intrinsics.h(str17, "privacyCancelTv");
        Intrinsics.h(str18, "privacyAgreeTv");
        this.OooO0OO = str;
        if (Intrinsics.c(str, "") ? true : Intrinsics.c(str, this.OooOO0O)) {
            OooO00o(str2, i, str4, str5, str6, "", str7, str8, false, true, false, z, str15, str17, str18, "", true, z2);
            return this;
        }
        if (!Intrinsics.c(str, this.OooOO0)) {
            return this;
        }
        this.OooO0Oo = true;
        this.OooO0o0 = false;
        this.OooO0o = true;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.OooOO0o.getValue();
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        if ((str2.length() > 0) && (textView6 = (TextView) this.OooOooO.getValue()) != null) {
            textView6.setText(str2);
        }
        if ((str3.length() > 0) && (textView5 = (TextView) this.Oooo00o.getValue()) != null) {
            textView5.setText(str3);
        }
        if ((str9.length() > 0) && (textView4 = (TextView) this.Oooo0OO.getValue()) != null) {
            textView4.setText(str9);
        }
        try {
            int dp2px = (getContext().getResources().getDisplayMetrics().heightPixels - SizeUtils.dp2px(260.0f)) - this.OoooO0;
            NestedScrollView nestedScrollView = (NestedScrollView) this.OooOoo.getValue();
            ViewGroup.LayoutParams layoutParams = nestedScrollView != null ? nestedScrollView.getLayoutParams() : null;
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = -2;
            TmcLogger.d(this.OooO0oO, " two in one maxPrivacyHeight:" + dp2px);
            bVar.U = dp2px;
            NestedScrollView nestedScrollView2 = (NestedScrollView) this.OooOoo.getValue();
            if (nestedScrollView2 != null) {
                nestedScrollView2.setLayoutParams(bVar);
            }
        } catch (Throwable unused) {
        }
        String string = str4.length() == 0 ? getString(R.string.mini_two_in_one_first_check_content) : str24;
        if (str6.length() == 0) {
            String string2 = getString(R.string.mini_two_in_one_first_check_user_agreement);
            str19 = string2 == null ? "" : string2;
        } else {
            str19 = str6;
        }
        if (str5.length() == 0) {
            String string3 = getString(R.string.mini_two_in_one_first_check_privacy_policy);
            str25 = string3 == null ? "" : string3;
        }
        if (str8.length() == 0) {
            str27 = "https://h5.dlight-app.com/outside/user-agreement?lang=";
        }
        if (str7.length() == 0) {
            str26 = "https://h5.dlight-app.com/outside/privacy-policy?lang=";
        }
        if (string != null) {
            try {
                str20 = "";
                i2 = 0;
                String str29 = str27;
                i3 = 1;
                try {
                    OooO00o((TextView) this.Oooo0.getValue(), string, StringsKt.o0(string, "#", 0, false, 6, (Object) null), str25, str26, StringsKt.v0(string, "#", 0, false, 6, (Object) null), StringsKt.o0(string, "*", 0, false, 6, (Object) null), str19, str29, StringsKt.v0(string, "*", 0, false, 6, (Object) null), false);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
            if ((str4.length() != 0 ? i3 : i2) != 0) {
                str24 = getString(R.string.mini_two_in_one_secondt_check_content);
            }
            if ((str12.length() != 0 ? i3 : i2) == 0) {
                str21 = getString(R.string.mini_two_in_one_second_check_user_agreement);
                if (str21 == null) {
                    str21 = str20;
                }
            } else {
                str21 = str12;
            }
            if ((str11.length() != 0 ? i3 : i2) != 0) {
                String string4 = getString(R.string.mini_two_in_one_second_check_privacy_policy);
                str28 = string4 == null ? str20 : string4;
            }
            String str30 = (str14.length() != 0 ? i3 : i2) == 0 ? str14 : "https://h5.dlight-app.com/outside/user-agreement?lang=";
            String str31 = (str13.length() != 0 ? i3 : i2) == 0 ? str13 : "https://h5.dlight-app.com/outside/privacy-policy?lang=";
            if (str24 != null) {
                try {
                    OooO00o((TextView) this.Oooo0o0.getValue(), str24, StringsKt.o0(str24, "#", 0, false, 6, (Object) null), str28, str31, StringsKt.v0(str24, "#", 0, false, 6, (Object) null), StringsKt.o0(str24, "*", 0, false, 6, (Object) null), str21, str30, StringsKt.v0(str24, "*", 0, false, 6, (Object) null), true);
                } catch (Throwable unused4) {
                }
            }
            if ((str15.length() != 0 ? i3 : i2) == 0) {
                str22 = getString(R.string.mini_two_in_one_gdpr_notice_content);
                if (str22 == null) {
                    str22 = str20;
                }
            } else {
                str22 = str15;
            }
            if ((str16.length() != 0 ? i3 : i2) == 0) {
                str23 = getString(R.string.mini_two_in_one_gdpr_highlight);
                if (str23 == null) {
                    str23 = str20;
                }
            } else {
                str23 = str16;
            }
            textView = (TextView) this.Oooo0o.getValue();
            if (textView != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) str22);
                try {
                    int o0 = StringsKt.o0(str22, str23, 0, false, 6, (Object) null);
                    int length = str23.length() + o0;
                    if (length > o0) {
                        spannableStringBuilder.setSpan(new StyleSpan(i3), o0, length, 33);
                    }
                } catch (Throwable unused5) {
                }
                textView.setText(new SpannedString(spannableStringBuilder));
            }
            view = (View) this.Oooo0oO.getValue();
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        oo0o0Oo.OooO0o0(oo0o0Oo.this, view3);
                    }
                });
            }
            view2 = (View) this.Oooo0oo.getValue();
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        oo0o0Oo.OooO0o(oo0o0Oo.this, view3);
                    }
                });
            }
            OooO0oo();
            textView2 = (TextView) this.OooOooo.getValue();
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        oo0o0Oo.OooO0oO(oo0o0Oo.this, view3);
                    }
                });
            }
            textView3 = (TextView) this.Oooo000.getValue();
            if (textView3 != null) {
                return this;
            }
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.dialog.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    oo0o0Oo.OooO0oo(oo0o0Oo.this, view3);
                }
            });
            return this;
        }
        str20 = "";
        i3 = 1;
        i2 = 0;
        if ((str4.length() != 0 ? i3 : i2) != 0) {
        }
        if ((str12.length() != 0 ? i3 : i2) == 0) {
        }
        if ((str11.length() != 0 ? i3 : i2) != 0) {
        }
        if ((str14.length() != 0 ? i3 : i2) == 0) {
        }
        if ((str13.length() != 0 ? i3 : i2) == 0) {
        }
        if (str24 != null) {
        }
        if ((str15.length() != 0 ? i3 : i2) == 0) {
        }
        if ((str16.length() != 0 ? i3 : i2) == 0) {
        }
        textView = (TextView) this.Oooo0o.getValue();
        if (textView != null) {
        }
        view = (View) this.Oooo0oO.getValue();
        if (view != null) {
        }
        view2 = (View) this.Oooo0oo.getValue();
        if (view2 != null) {
        }
        OooO0oo();
        textView2 = (TextView) this.OooOooo.getValue();
        if (textView2 != null) {
        }
        textView3 = (TextView) this.Oooo000.getValue();
        if (textView3 != null) {
        }
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

    public final void OooO00o(TextView textView, String str, int i, String str2, String str3, int i2, int i3, String str4, String str5, int i4, boolean z) {
        if (textView != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            try {
                spannableStringBuilder.append(str.subSequence(0, i));
            } catch (Throwable unused) {
            }
            SpannableExtKt.appendClickable(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str4), Integer.valueOf(getColor(R.color.mini_color_primary)), false, new o00000(str5, this, z));
            try {
                spannableStringBuilder.setSpan(new StyleSpan(1), i, str4.length() + i, 33);
            } catch (Throwable unused2) {
            }
            try {
                spannableStringBuilder.append(str.subSequence(i2 + 1, i3));
            } catch (Throwable unused3) {
            }
            SpannableExtKt.appendClickable(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str2), Integer.valueOf(getColor(R.color.mini_color_primary)), false, new o00000O0(str3, this, z));
            try {
                int length = (str4.length() + i3) - 4;
                spannableStringBuilder.setSpan(new StyleSpan(1), length, str2.length() + length, 33);
            } catch (Throwable unused4) {
            }
            try {
                spannableStringBuilder.append(str.subSequence(i4 + 1, str.length()));
            } catch (Throwable unused5) {
            }
            textView.setText(new SpannedString(spannableStringBuilder));
        }
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (textView != null) {
            TextViewExtKt.transparentHighlightColor(textView);
        }
    }

    public final void OooO00o(App app, BridgeCallback bridgeCallback, int i) {
        AppContext appContext;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        AppModel appModel;
        if (FastClickUtil.isFastDoubleClick()) {
            return;
        }
        try {
            try {
                if (this.OooO0Oo) {
                    ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).recordForCommon(app != null ? app.getAppId() : null, "privacy_click", new Bundle());
                    DeviceUtil.INSTANCE.updateIsNewUserStatus("");
                }
                boolean z = this.OooO0o0;
                if (z) {
                    if (z) {
                        DeviceUtil.INSTANCE.updateIsNewUserStatus(app != null ? app.getAppId() : null);
                    }
                    PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
                    String appId = app != null ? app.getAppId() : null;
                    Bundle bundle = new Bundle();
                    bundle.putString("miniappid", app != null ? app.getAppId() : null);
                    bundle.putString(NativeComponentConstants.KEY_COMPONENT_TYPE, this.OooO0o ? "2" : "1");
                    Unit unit = Unit.a;
                    performanceAnalyseProxy.recordForCommon(appId, "appstart_add_click", bundle);
                }
            } catch (Throwable th) {
                try {
                    TmcLogger.e(this.OooO0oO, "callback error", th);
                    return;
                } finally {
                    dismiss();
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0oO, th2);
        }
        try {
            MiniForceAddHomeManager.INSTANCE.noticeClickAllowBtn((app == null || (appModel = app.getAppModel()) == null) ? null : appModel.getAppId());
            if (app != null && (appContext = app.getAppContext()) != null && appContext.getContext() != null) {
                PrivacyBridge.Companion.getClass();
                concurrentHashMap = PrivacyBridge.OooO0O0;
                if (concurrentHashMap.containsKey(app.getAppId())) {
                    concurrentHashMap2 = PrivacyBridge.OooO0O0;
                    concurrentHashMap2.remove(app.getAppId());
                    PermissionDialogPoint create = ExtensionPoint.as(PermissionDialogPoint.class).create();
                    String appId2 = app.getAppId();
                    Intrinsics.g(appId2, "app.appId");
                    create.privacyDialogDismiss(appId2, app.getStartToken());
                }
            }
        } catch (Throwable th3) {
            TmcLogger.e(this.OooO0oO, "privacyDialogDismiss", th3);
        }
        if (i == this.OooO0oo) {
            if (bridgeCallback != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "agreeClick");
                jsonObject.addProperty("clickBtn", "3");
                bridgeCallback.sendSuccessResponse(jsonObject);
            }
            if (bridgeCallback != null) {
                bridgeCallback.close();
            }
        } else if (i == this.OooO) {
            if (bridgeCallback != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("status", "agreeClick");
                jsonObject2.addProperty("clickBtn", "1");
                bridgeCallback.sendSuccessResponse(jsonObject2);
            }
            if (bridgeCallback != null) {
                bridgeCallback.close();
            }
        }
        if (Intrinsics.c(this.OooO0OO, this.OooOO0O)) {
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            String appId3 = app != null ? app.getAppId() : null;
            Bundle bundle2 = new Bundle();
            bundle2.putString("miniappid", app != null ? app.getAppId() : null);
            bundle2.putString("content", "1");
            Unit unit2 = Unit.a;
            performanceAnalyseProxy2.recordForCommon(appId3, "miniapp_agree_popup_click", bundle2);
        }
    }

    public final void OooO00o(String str, int i, String str2, String str3, int i2, int i3, String str4, String str5, int i4, boolean z) {
        TextView OooO0o2 = OooO0o();
        if (OooO0o2 == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(str.subSequence(0, i));
        SpannableExtKt.appendClickable(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str4), Integer.valueOf(getColor(R.color.mini_color_primary)), false, new o000000(str5, this, z));
        try {
            spannableStringBuilder.setSpan(new StyleSpan(1), i, str4.length() + i, 33);
        } catch (Throwable unused) {
        }
        try {
            spannableStringBuilder.append(str.subSequence(i2 + 1, i3));
        } catch (Throwable unused2) {
        }
        SpannableExtKt.appendClickable(spannableStringBuilder, BidiFormatter.getInstance().unicodeWrap(str2), Integer.valueOf(getColor(R.color.mini_color_primary)), false, new o000000O(str3, this, z));
        try {
            int length = (str4.length() + i3) - 4;
            spannableStringBuilder.setSpan(new StyleSpan(1), length, str2.length() + length, 33);
        } catch (Throwable unused3) {
        }
        try {
            spannableStringBuilder.append(str.subSequence(i4 + 1, str.length()));
        } catch (Throwable unused4) {
        }
        OooO0o2.setText(new SpannedString(spannableStringBuilder));
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x017f, code lost:
    
        if (r1 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0165, code lost:
    
        if (r1 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x014b, code lost:
    
        if (r1 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ea, code lost:
    
        if (r2 == null) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OooO00o(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, boolean z3, boolean z4, String str8, String str9, String str10, String str11, App app, boolean z5, boolean z6) {
        int i2;
        String string;
        String str12;
        String string2;
        String str13;
        String string3;
        String str14;
        String string4;
        AppModel appModel;
        TextView textView;
        Unit unit;
        AppModel appModel2;
        String logo;
        Unit unit2;
        Intrinsics.h(str, "title");
        Intrinsics.h(str2, "baseContent");
        Intrinsics.h(str3, "privacyPolocyContent");
        Intrinsics.h(str4, "userAgreementContent");
        Intrinsics.h(str5, "buttonText");
        Intrinsics.h(str6, "privacyPolocyUrl");
        Intrinsics.h(str7, "userAgreementUrl");
        if (z && app != null) {
            app.updateAddHomeShowStatus(100);
        }
        this.OooO0Oo = z2;
        this.OooO0o0 = z;
        this.OooO0o = z3;
        if (z) {
            Group group = (Group) this.OooOOOO.getValue();
            if (group != null) {
                group.setVisibility(0);
            }
            if (app == null || (appModel2 = app.getAppModel()) == null || (logo = appModel2.getLogo()) == null) {
                unit = null;
            } else {
                ImageView imageView = (ImageView) this.OooOOOo.getValue();
                if (imageView != null) {
                    try {
                        ((ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class)).loadImgRoundCorners(getContext(), logo, imageView, SizeUtils.dp2px(14.0f));
                    } catch (Throwable th) {
                        TmcLogger.e(this.OooO0oO, "showAddhomeLayout", th);
                    }
                    unit2 = Unit.a;
                } else {
                    unit2 = null;
                }
                if (unit2 == null) {
                    TmcLogger.d(this.OooO0oO, "privacy dialog add home ,ivLogo is null");
                }
                unit = Unit.a;
            }
            if (unit == null) {
                TmcLogger.d(this.OooO0oO, "privacy dialog add home ,logoUrl is null");
            }
        } else {
            TmcLogger.d(this.OooO0oO, "privacy dialog add home ,showAddHome is false");
            Group group2 = (Group) this.OooOOOO.getValue();
            if (group2 != null) {
                group2.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) this.OooOOO0.getValue();
        if (textView2 != null) {
            textView2.setText(str);
        }
        if (i != 0 && (textView = (TextView) this.OooOOO0.getValue()) != null) {
            textView.setMaxLines(i);
        }
        TextView textView3 = (TextView) this.OooOOoo.getValue();
        if (textView3 != null) {
            textView3.setText((app == null || (appModel = app.getAppModel()) == null) ? null : appModel.getName());
        }
        try {
            if (this.OooO0Oo) {
                Group group3 = (Group) this.OooOo0.getValue();
                if (group3 == null) {
                    i2 = 0;
                } else {
                    i2 = 0;
                    group3.setVisibility(0);
                }
                Group group4 = (Group) this.OooOo00.getValue();
                if (group4 != null) {
                    group4.setVisibility(i2);
                }
                Group group5 = (Group) this.OooOoO.getValue();
                if (group5 != null) {
                    group5.setVisibility(8);
                }
                if (z4) {
                    str12 = str2;
                } else if (z6) {
                    string = getString(R.string.mini_privacy_reading_notice_only_en);
                    if (string == null) {
                        str12 = "";
                    }
                    str12 = string;
                } else {
                    string = getString(R.string.mini_privacy_reading_notice);
                }
                if (z4) {
                    str13 = str3;
                } else if (z6) {
                    string2 = getString(R.string.mini_privacy_privacy_policy_only_en);
                    if (string2 == null) {
                        str13 = "";
                    }
                    str13 = string2;
                } else {
                    string2 = getString(R.string.mini_privacy_privacy_policy);
                }
                if (z4) {
                    str14 = str4;
                } else if (z6) {
                    string3 = getString(R.string.mini_privacy_user_agreement_only_en);
                    if (string3 == null) {
                        str14 = "";
                    }
                    str14 = string3;
                } else {
                    string3 = getString(R.string.mini_privacy_user_agreement);
                }
                OooO00o(str12, StringsKt.o0(str12, "#", 0, false, 6, (Object) null), str13, str6, StringsKt.v0(str12, "#", 0, false, 6, (Object) null), StringsKt.o0(str12, "*", 0, false, 6, (Object) null), str14, str7, StringsKt.v0(str12, "*", 0, false, 6, (Object) null), z5);
                TextView textView4 = (TextView) this.OooOo0O.getValue();
                if (textView4 != null) {
                    if (str8 != null && str8.length() > 0) {
                        string4 = str8;
                    } else if (z6) {
                        string4 = getString(R.string.mini_gdpr_privacy_only_en);
                        if (string4 == null) {
                            string4 = "";
                        }
                    } else {
                        string4 = getString(R.string.mini_gdpr_privacy);
                    }
                    textView4.setText(string4);
                }
                TextView textView5 = (TextView) this.OooOo0O.getValue();
                if (textView5 != null) {
                    textView5.setMovementMethod(ScrollingMovementMethod.getInstance());
                }
                TextView textView6 = (TextView) this.OooOo0o.getValue();
                if (textView6 != null) {
                    textView6.setText(str10);
                }
                TextView textView7 = (TextView) this.OooOo.getValue();
                if (textView7 != null) {
                    textView7.setText(str9);
                }
                TextView OooO0o2 = OooO0o();
                if (OooO0o2 != null) {
                    OooO0o2.setMovementMethod(LinkMovementMethod.getInstance());
                }
                TextView OooO0o3 = OooO0o();
                if (OooO0o3 != null) {
                    TextViewExtKt.transparentHighlightColor(OooO0o3);
                }
            } else {
                Group group6 = (Group) this.OooOo0.getValue();
                if (group6 != null) {
                    group6.setVisibility(8);
                }
                Group group7 = (Group) this.OooOo00.getValue();
                if (group7 != null) {
                    group7.setVisibility(8);
                }
                Group group8 = (Group) this.OooOoO.getValue();
                if (group8 != null) {
                    group8.setVisibility(0);
                }
                TmcLogger.d(this.OooO0oO, "privacy dialog add home ,showPrivacy is false");
            }
        } catch (Throwable th2) {
            TmcLogger.e(this.OooO0oO, "privacy dialog add home error", th2);
        }
        TextView textView8 = (TextView) this.OooOOo0.getValue();
        if (textView8 != null) {
            textView8.setText(str5);
        }
        TextView textView9 = (TextView) this.OooOOo.getValue();
        if (textView9 == null) {
            return;
        }
        textView9.setText(str11);
    }

    public final void OooO00o(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, boolean z2, App app) {
        Intrinsics.h(str, "privacyDialogType");
        Intrinsics.h(str2, "title");
        Intrinsics.h(str3, "baseContent");
        Intrinsics.h(str4, "privacyPolocyContent");
        Intrinsics.h(str5, "userAgreementContent");
        Intrinsics.h(str6, "buttonText");
        Intrinsics.h(str7, "privacyPolocyUrl");
        Intrinsics.h(str8, "userAgreementUrl");
        this.OooO0OO = str;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.OooOO0o.getValue();
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.OooOoo0.getValue();
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        OooO00o(str2, i, str3, str4, str5, str6, str7, str8, false, true, false, z, str9, str10, str11, str12, app, true, z2);
    }

    public final ImageView OooO0O0() {
        return (ImageView) this.Oooo0O0.getValue();
    }

    public final TextView OooO0OO() {
        return (TextView) this.OooOOo.getValue();
    }

    public final TextView OooO0Oo() {
        return (TextView) this.OooOOo0.getValue();
    }

    public final TextView OooO0o() {
        return (TextView) this.OooOOO.getValue();
    }

    public final TextView OooO0o0() {
        return (TextView) this.OooOo0o.getValue();
    }

    public final TextView OooO0oO() {
        return (TextView) this.OooOo.getValue();
    }

    public final void OooO0oo() {
        try {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.miniapp.dialog.w
                @Override // java.lang.Runnable
                public final void run() {
                    oo0o0Oo.OooO0O0(oo0o0Oo.this);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void OooOO0() {
        try {
            Drawable drawable = getDrawable(R.drawable.mini_privacy_button_unclick_bg);
            GradientDrawable gradientDrawable = drawable instanceof GradientDrawable ? (GradientDrawable) drawable : null;
            int color = (this.Oooo && this.OoooO00) ? getColor(R.color.mini_color_primary) : getColor(R.color.mini_two_in_one_agree_unchecked_bg);
            if (gradientDrawable != null) {
                gradientDrawable.setColor(color);
            }
            TextView textView = (TextView) this.OooOooo.getValue();
            if (textView == null) {
                return;
            }
            textView.setBackground(gradientDrawable);
        } catch (Throwable th) {
            TmcLogger.e(this.OooO0oO, th);
        }
    }
}
