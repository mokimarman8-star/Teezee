package com.transsion.subroom.activity;

import ai.c;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.v;
import bm.e;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.scene.d;
import com.transsion.baseui.activity.k;
import com.transsion.home.viewmodel.TrendingUGCViewModel;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.push.tpush.PushRegisterManager;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.subroom.R$layout;
import ij.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.mvel2.ast.ASTNode;
import wf.a;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 42\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0019\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u0012J\u000f\u0010\u001b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001d\u0010\u0003R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010)R\u0016\u0010/\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010)R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/transsion/subroom/activity/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "b0", "g0", "", "state", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "maxEcpmObject", "a0", "(Ljava/lang/String;Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;)V", "f0", "Y", "", "isSplashAdLoaded", "h0", "(Z)V", "setStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "hasFocus", "onWindowFocusChanged", "onResume", "onPause", "onDestroy", "Lcom/transsion/ad/bidding/splash/b;", "a", "Lcom/transsion/ad/bidding/splash/b;", "splashManager", "Lcom/transsion/ad/hi/b;", "b", "Lcom/transsion/ad/hi/b;", "hiSdkInitListener", "Landroid/os/Handler;", "c", "Lkotlin/Lazy;", "Z", "()Landroid/os/Handler;", "mHandler", "d", "isBackups", "e", "isAdLoadStarted", "", "f", "J", "startTime", "g", "app_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CustomSplashScreen"})
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class SplashActivity extends AppCompatActivity {
    public static final a g = new a((DefaultConstructorMarker) null);

    /* renamed from: a, reason: from kotlin metadata */
    private com.transsion.ad.bidding.splash.b splashManager;

    /* renamed from: b, reason: from kotlin metadata */
    private com.transsion.ad.hi.b hiSdkInitListener;

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy mHandler = LazyKt.b(new Function0() { // from class: com.transsion.subroom.activity.g0
        public final Object invoke() {
            Handler d0;
            d0 = SplashActivity.d0();
            return d0;
        }
    });

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isBackups;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isAdLoadStarted;

    /* renamed from: f, reason: from kotlin metadata */
    private long startTime;

    private final void Y() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        if (System.currentTimeMillis() - bVar.b().getLong("app_config_fetch_time", 0L) > 1800000) {
            e.p(e.a, null, null, 3, null);
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new fetchAppConfig.1((Continuation) null), 3, (Object) null);
            bVar.b().putLong("app_config_fetch_time", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler Z() {
        return (Handler) this.mHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(String state, BiddingIntermediateMaterialBean maxEcpmObject) {
        com.transsion.ad.bidding.splash.b bVar;
        AbsAdBidding H0;
        Z().removeCallbacksAndMessages(null);
        AppStartReport appStartReport = AppStartReport.a;
        appStartReport.e(new AppStartDotState(AppStartDotState.AD_RENDERING, 0L, 2, null));
        if (this.isBackups) {
            return;
        }
        this.isBackups = true;
        boolean equals = TextUtils.equals("success", state);
        if (TextUtils.equals("time_out", state)) {
            c.a.j("", "", 5, 105, "开屏广告加载超时", (String) null);
        }
        if (!equals) {
            com.transsion.ad.bidding.splash.b bVar2 = this.splashManager;
            if (bVar2 != null) {
                bVar2.U();
            }
            this.splashManager = null;
        }
        if (!equals) {
            com.transsion.startup.pref.consume.c.a.q();
        }
        setStatusBar();
        f0();
        Y();
        h0(equals);
        if (getIntent().getBooleanExtra("without_ad", false)) {
            com.transsion.startup.pref.consume.c.a.q();
            appStartReport.e(new AppStartDotState(AppStartDotState.AD_END, 0L, 2, null));
        } else {
            if (!equals || (bVar = this.splashManager) == null || (H0 = bVar.H0(Integer.valueOf(R$layout.splash_ad_app_layout))) == null) {
                return;
            }
            AbsAdBidding.O0(H0, this, maxEcpmObject, false, 4, (Object) null);
        }
    }

    private final void b0() {
        JsonElement jsonElement;
        h0 h0Var = new h0(this);
        JsonObject b = d.a.b("ColdStartScene");
        Z().postDelayed(h0Var, ((b == null || (jsonElement = b.get("initTimeout")) == null) ? 1 : jsonElement.getAsInt()) * 1000);
        b bVar = new b(this, h0Var);
        this.hiSdkInitListener = bVar;
        HiSavanaAdManager.a.b(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(SplashActivity splashActivity) {
        a.a.f(a.a, "SplashActivity", "HiSavana init timeout, load ad directly.", false, 4, (Object) null);
        splashActivity.g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler d0() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(SplashActivity splashActivity) {
        splashActivity.a0("time_out", null);
    }

    private final void f0() {
        PreloadTrendingData.a aVar = PreloadTrendingData.n;
        aVar.a().z();
        if (g.a.b()) {
            TrendingUGCViewModel.a aVar2 = TrendingUGCViewModel.l;
            Application application = getApplication();
            Intrinsics.g(application, "getApplication(...)");
            TrendingUGCViewModel a = aVar2.a(application);
            if (a != null) {
                a.A(this);
            }
        } else {
            aVar.a().U(this);
        }
        aVar.a().G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        if (this.isAdLoadStarted) {
            return;
        }
        this.isAdLoadStarted = true;
        i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new startSplashAdLoad.1(this, (Continuation) null), 3, (Object) null);
    }

    private final void h0(boolean isSplashAdLoaded) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("isSplashAdLoaded", isSplashAdLoaded);
        startActivity(intent);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SplashActivity$toMain$1(this, null), 3, (Object) null);
        overridePendingTransition(0, 0);
        finish();
    }

    private final void setStatusBar() {
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().clearFlags(ASTNode.ARRAY_TYPE_LITERAL);
        getWindow().getDecorView().setSystemUiVisibility(13312);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppStartReport appStartReport = AppStartReport.a;
        appStartReport.e(new AppStartDotState(AppStartDotState.SPLASH_START, 0L, 2, null));
        e1.a.b.a(this);
        this.startTime = System.currentTimeMillis();
        com.transsion.startup.pref.consume.c cVar = com.transsion.startup.pref.consume.c.a;
        cVar.l(this);
        if (!isTaskRoot() && !Intrinsics.c(getIntent().getStringExtra("from"), "deeplink")) {
            a.a.f(a.a, "SplashActivity", "finish from TaskRoot", false, 4, (Object) null);
            finish();
            return;
        }
        qx.a aVar = (qx.a) TheRouter.d(qx.a.class, new Object[0]);
        if (aVar != null) {
            aVar.n(aVar.o() + 1);
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        if (bVar.b().getBoolean("first_start_not_show_cold_ad", false)) {
            cVar.m();
            appStartReport.e(new AppStartDotState(AppStartDotState.AD_LOADING, 0L, 2, null));
            b0();
            Z().postDelayed(new Runnable() { // from class: com.transsion.subroom.activity.f0
                @Override // java.lang.Runnable
                public final void run() {
                    SplashActivity.e0(SplashActivity.this);
                }
            }, com.transsion.ad.scene.a.a.s("ColdStartScene") * 1000);
        } else {
            cVar.r();
            a0("skip", null);
            bVar.b().putBoolean("first_start_not_show_cold_ad", true);
        }
        PushRegisterManager.a.u();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        k.f((String) null, this, 1, (Object) null);
        com.transsion.ad.bidding.splash.b bVar = this.splashManager;
        if (bVar != null) {
            bVar.K0((oh.a) null);
        }
        com.transsion.ad.hi.b bVar2 = this.hiSdkInitListener;
        if (bVar2 != null) {
            HiSavanaAdManager.a.h(bVar2);
        }
        this.hiSdkInitListener = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        k.k((String) null, this, 1, (Object) null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        k.o((String) null, this, 1, (Object) null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            AppStartReport.a.e(new AppStartDotState(AppStartDotState.SPLASH_RESUME, 0L, 2, null));
        }
    }
}
