package com.transsion.baseui.activity;

import android.app.Activity;
import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.v;
import com.gyf.immersionbar.ImmersionBar;
import com.therouter.TheRouter;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.o;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.locale.d;
import com.transsion.baselib.report.g;
import com.transsion.baseui.R$id;
import com.transsion.baseui.R$layout;
import f4.a;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import uf.c;
import yg.l;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0014\u0010\u0006J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\u0006J\u000f\u0010 \u001a\u00020\u0017H\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\u0006J\u001f\u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010!J\u000f\u0010.\u001a\u00020\u0017H\u0016¢\u0006\u0004\b.\u0010!J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0017H\u0016¢\u0006\u0004\b2\u0010!J\u000f\u00103\u001a\u00020\u0017H\u0016¢\u0006\u0004\b3\u0010!J\u000f\u00104\u001a\u00020\u0017H\u0016¢\u0006\u0004\b4\u0010!J\u000f\u00105\u001a\u00020\u0017H\u0016¢\u0006\u0004\b5\u0010!J\u000f\u00106\u001a\u00020\u0017H\u0016¢\u0006\u0004\b6\u0010!J\u000f\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0004\b7\u0010\u0006J\u000f\u00109\u001a\u000208H\u0016¢\u0006\u0004\b9\u0010:J\u0011\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020;H\u0016¢\u0006\u0004\b>\u0010=J\u0011\u0010?\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b?\u0010=J\r\u0010@\u001a\u00020\u0007¢\u0006\u0004\b@\u0010\u0006J\r\u0010A\u001a\u00020\u0007¢\u0006\u0004\bA\u0010\u0006J\r\u0010B\u001a\u00020\u0007¢\u0006\u0004\bB\u0010\u0006J\r\u0010C\u001a\u00020\u0007¢\u0006\u0004\bC\u0010\u0006J\r\u0010D\u001a\u00020\u0007¢\u0006\u0004\bD\u0010\u0006J\r\u0010E\u001a\u00020\u0007¢\u0006\u0004\bE\u0010\u0006J\u000f\u0010F\u001a\u000208H&¢\u0006\u0004\bF\u0010:J\u000f\u0010G\u001a\u00020\u0007H&¢\u0006\u0004\bG\u0010\u0006J\u000f\u0010H\u001a\u00020\u0007H&¢\u0006\u0004\bH\u0010\u0006J\u000f\u0010I\u001a\u00020\u0007H&¢\u0006\u0004\bI\u0010\u0006J\u000f\u0010J\u001a\u00020\u0007H&¢\u0006\u0004\bJ\u0010\u0006J\u000f\u0010K\u001a\u00020\u0007H&¢\u0006\u0004\bK\u0010\u0006R$\u0010S\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010W\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010N\u001a\u0004\bU\u0010P\"\u0004\bV\u0010RR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010aR\u001d\u0010j\u001a\u0004\u0018\u00010e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lcom/transsion/baseui/activity/BaseNewActivity;", "Lf4/a;", "T", "Lcom/transsion/baseui/activity/BaseMusicFloatActivity;", "Lcom/transsion/baselib/report/g;", "<init>", "()V", "", "setStatusBar", "Landroid/content/Context;", "newBase", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onStop", "onDestroy", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "setView", "Lcom/gyf/immersionbar/ImmersionBar;", "with", "B0", "(Lcom/gyf/immersionbar/ImmersionBar;)V", "t0", "setImmersionStatusBar", "()Z", "Landroid/app/Activity;", "context", "j0", "(Landroid/app/Activity;)V", "onDisconnected", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "n0", "isChangeStatusBar", "", "statusColor", "()I", "isStatusDark", "isTranslucent", "o0", "isAttach", "A0", "q0", "", "a0", "()Ljava/lang/String;", "Landroid/view/View;", "b0", "()Landroid/view/View;", "g0", "d0", "s0", "u0", "v0", "w0", "x0", "y0", "f0", "l0", "m0", "k0", "p0", "retryLoadData", "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", "c0", "()Landroid/widget/FrameLayout;", "setLlRootView", "(Landroid/widget/FrameLayout;)V", "llRootView", "b", "getFlStateView", "setFlStateView", "flStateView", "Landroid/widget/ProgressBar;", "c", "Landroid/widget/ProgressBar;", "progressBar", "d", "Landroid/view/View;", "loadingView", "", "e", "F", "downY", "f", "moveY", "Lqi/b;", "g", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class BaseNewActivity<T extends a> extends BaseMusicFloatActivity<T> implements g {
    public static final int h = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private FrameLayout llRootView;

    /* renamed from: b, reason: from kotlin metadata */
    private FrameLayout flStateView;

    /* renamed from: c, reason: from kotlin metadata */
    private ProgressBar progressBar;

    /* renamed from: d, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: e, reason: from kotlin metadata */
    private float downY;

    /* renamed from: f, reason: from kotlin metadata */
    private float moveY;

    /* renamed from: g, reason: from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new h(this));

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e0(BaseNewActivity baseNewActivity, View view) {
        baseNewActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit h0(BaseNewActivity baseNewActivity) {
        baseNewActivity.retryLoadData();
        o.b(baseNewActivity.getPageName());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit i0(BaseNewActivity baseNewActivity) {
        o.c(baseNewActivity.getPageName());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.b r0(BaseNewActivity baseNewActivity) {
        return baseNewActivity.newLogViewConfig();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setStatusBar() {
        if (setImmersionStatusBar()) {
            ImmersionBar with = ImmersionBar.with((Activity) this);
            if (isChangeStatusBar()) {
                with.statusBarColor(statusColor());
            }
            if (isTranslucent()) {
                with.statusBarAlpha(0.0f);
            } else {
                with.statusBarAlpha(1.0f);
            }
            if (isStatusDark()) {
                with.statusBarDarkFont(true);
            } else {
                with.statusBarDarkFont(false);
            }
            with.fitsSystemWindows(o0());
            Intrinsics.e(with);
            B0(with);
            with.init();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(BaseNewActivity baseNewActivity) {
        baseNewActivity.x0();
    }

    public boolean A0() {
        return false;
    }

    public void B0(ImmersionBar with) {
        Intrinsics.h(with, "with");
    }

    public String a0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context newBase) {
        if (newBase == null) {
            super/*androidx.appcompat.app.AppCompatActivity*/.attachBaseContext(newBase);
        } else {
            d.b bVar = d.f;
            super/*androidx.appcompat.app.AppCompatActivity*/.attachBaseContext(bVar.k(newBase, bVar.e().j()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View b0() {
        StateView stateView = new StateView(this);
        if (A0()) {
            stateView.setFitsSystemWindows(true);
        }
        stateView.showData(2, 1, true, f0(), a0());
        return stateView;
    }

    /* renamed from: c0, reason: from getter */
    public final FrameLayout getLlRootView() {
        return this.llRootView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View d0() {
        if (this.loadingView == null) {
            View inflate = LayoutInflater.from(this).inflate(R$layout.default_base_loading_layout, (ViewGroup) this.flStateView, false);
            ((AppCompatImageView) inflate.findViewById(R$id.ivBack)).setOnClickListener(new j(this));
            this.loadingView = inflate;
        }
        return this.loadingView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent event) {
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.downY = event.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float rawY = event.getRawY();
            this.moveY = rawY;
            if (Math.abs(rawY - this.downY) > 50.0f) {
                ep.b bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0]);
                if (bVar != null) {
                    bVar.b();
                }
                j0(this);
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public abstract String f0();

    /* JADX WARN: Multi-variable type inference failed */
    public View g0() {
        NoNetworkBigView noNetworkBigView = new NoNetworkBigView(this);
        noNetworkBigView.showTitle(true, f0());
        noNetworkBigView.retry(new f(this));
        noNetworkBigView.goToSetting(new g(this));
        o.a(getPageName());
        return noNetworkBigView;
    }

    public qi.b getLogViewConfig() {
        return (qi.b) this.logViewConfig.getValue();
    }

    public boolean isAttach() {
        return true;
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return true;
    }

    public boolean isTranslucent() {
        return false;
    }

    public void j0(Activity context) {
        try {
            Result.Companion companion = Result.Companion;
            Object systemService = context != null ? context.getSystemService("input_method") : null;
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            Result.m34constructorimpl(Boolean.valueOf(((InputMethodManager) systemService).hideSoftInputFromWindow(context.getWindow().getDecorView().getWindowToken(), 0)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m34constructorimpl(ResultKt.a(th));
        }
    }

    public abstract void k0();

    public abstract void l0();

    public abstract void m0();

    public boolean n0() {
        return true;
    }

    public qi.b newLogViewConfig() {
        return g.a.a(this);
    }

    public boolean o0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onConnected(network, networkCapabilities);
        v.a(this).b(new onConnected.1(this, (Continuation) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onCreate(savedInstanceState);
        setStatusBar();
        l0();
        m0();
        k0();
        if (l.a.e()) {
            p0();
        }
        q0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDisconnected() {
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onDisconnected();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super/*com.transsion.baseui.activity.BaseCommonActivity*/.onPause();
        g.a.b(this);
    }

    public void onResume() {
        ep.b bVar;
        super.onResume();
        g.a.c(this);
        if (!isAttach() || (bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0])) == null) {
            return;
        }
        bVar.g(new WeakReference(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        ep.b bVar;
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (!isAttach() || (bVar = (ep.b) TheRouter.d(ep.b.class, new Object[0])) == null) {
            return;
        }
        bVar.i(new WeakReference(this));
    }

    public abstract void p0();

    public void q0() {
    }

    public abstract void retryLoadData();

    public final void s0() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            c.e(frameLayout);
        }
    }

    public boolean setImmersionStatusBar() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setView() {
        setContentView(R$layout.default_base_layout);
        this.llRootView = (FrameLayout) findViewById(R$id.llRootView);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.flContent);
        if (frameLayout != null) {
            frameLayout.addView(getMViewBinding().getRoot());
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.flStateView);
        if (frameLayout2 == null) {
            frameLayout2 = null;
        } else if (n0() && !l.a.e()) {
            frameLayout2.setVisibility(0);
            frameLayout2.addView(g0());
        }
        this.flStateView = frameLayout2;
        this.progressBar = (ProgressBar) findViewById(R$id.progressBar);
    }

    public int statusColor() {
        return R$color.bg_01;
    }

    public final void t0() {
        setStatusBar();
    }

    public final void u0() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final void v0() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(b0());
        }
    }

    public final void w0() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(d0());
        }
    }

    public final void x0() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(0);
            frameLayout.addView(g0());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y0() {
        getMViewBinding().getRoot().postDelayed(new i(this), 200L);
    }
}
