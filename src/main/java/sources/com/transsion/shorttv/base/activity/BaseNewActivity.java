package com.transsion.shorttv.base.activity;

import android.app.Activity;
import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.lifecycle.v;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.locale.d;
import com.transsion.shorttv.base.widget.NoNetworkBigView;
import com.transsion.shorttv.base.widget.k;
import f4.a;
import hr.e;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ur.j;
import yg.l;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0014\u0010\u0006J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0006J\u001f\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0017H\u0016¢\u0006\u0004\b,\u0010 J\u000f\u0010-\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010 J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0017H\u0016¢\u0006\u0004\b1\u0010 J\u000f\u00102\u001a\u00020\u0017H\u0016¢\u0006\u0004\b2\u0010 J\u000f\u00103\u001a\u00020\u0017H\u0016¢\u0006\u0004\b3\u0010 J\u000f\u00104\u001a\u00020\u0017H\u0016¢\u0006\u0004\b4\u0010 J\u000f\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u0010\u0006J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0007¢\u0006\u0004\b9\u0010\u0006J\r\u0010:\u001a\u00020\u0007¢\u0006\u0004\b:\u0010\u0006J\u000f\u0010<\u001a\u00020;H&¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0007H&¢\u0006\u0004\b>\u0010\u0006J\u000f\u0010?\u001a\u00020\u0007H&¢\u0006\u0004\b?\u0010\u0006J\u000f\u0010@\u001a\u00020\u0007H&¢\u0006\u0004\b@\u0010\u0006J\u000f\u0010A\u001a\u00020\u0007H&¢\u0006\u0004\bA\u0010\u0006J\u000f\u0010B\u001a\u00020\u0007H&¢\u0006\u0004\bB\u0010\u0006R$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010N\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010E\u001a\u0004\bL\u0010G\"\u0004\bM\u0010IR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010UR\u001d\u0010^\u001a\u0004\u0018\u00010Y8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]¨\u0006_"}, d2 = {"Lcom/transsion/shorttv/base/activity/BaseNewActivity;", "Lf4/a;", "T", "Lcom/transsion/shorttv/base/activity/BaseMusicFloatActivity;", "Lhr/e;", "<init>", "()V", BuildConfig.FLAVOR, "setStatusBar", "Landroid/content/Context;", "newBase", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onStop", "onDestroy", "Landroid/view/MotionEvent;", "event", BuildConfig.FLAVOR, "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "setView", "Lcom/gyf/immersionbar/ImmersionBar;", "with", "k0", "(Lcom/gyf/immersionbar/ImmersionBar;)V", "setImmersionStatusBar", "()Z", "Landroid/app/Activity;", "context", "Z", "(Landroid/app/Activity;)V", "onDisconnected", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "d0", "isChangeStatusBar", BuildConfig.FLAVOR, "statusColor", "()I", "isStatusDark", "isTranslucent", "e0", "isAttach", "g0", "Landroid/view/View;", "W", "()Landroid/view/View;", "i0", "j0", BuildConfig.FLAVOR, "V", "()Ljava/lang/String;", "b0", "c0", "a0", "f0", "retryLoadData", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "getLlRootView", "()Landroid/widget/FrameLayout;", "setLlRootView", "(Landroid/widget/FrameLayout;)V", "llRootView", "e", "getFlStateView", "setFlStateView", "flStateView", "Landroid/widget/ProgressBar;", "f", "Landroid/widget/ProgressBar;", "progressBar", BuildConfig.FLAVOR, "g", "F", "downY", "h", "moveY", "Lqi/b;", "i", "Lkotlin/Lazy;", "getLogViewConfig", "()Lqi/b;", "logViewConfig", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BaseNewActivity<T extends f4.a> extends BaseMusicFloatActivity<T> implements hr.e {

    /* renamed from: d, reason: from kotlin metadata */
    private FrameLayout llRootView;

    /* renamed from: e, reason: from kotlin metadata */
    private FrameLayout flStateView;

    /* renamed from: f, reason: from kotlin metadata */
    private ProgressBar progressBar;

    /* renamed from: g, reason: from kotlin metadata */
    private float downY;

    /* renamed from: h, reason: from kotlin metadata */
    private float moveY;

    /* renamed from: i, reason: from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.base.activity.d
        public final Object invoke() {
            qi.b h0;
            h0 = BaseNewActivity.h0(BaseNewActivity.this);
            return h0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(BaseNewActivity baseNewActivity) {
        baseNewActivity.retryLoadData();
        k.b(baseNewActivity.getPageName());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(BaseNewActivity baseNewActivity) {
        k.c(baseNewActivity.getPageName());
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.b h0(BaseNewActivity baseNewActivity) {
        return baseNewActivity.newLogViewConfig();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setStatusBar() {
        if (setImmersionStatusBar()) {
            ImmersionBar with = ImmersionBar.with(this);
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
            with.fitsSystemWindows(e0());
            Intrinsics.e(with);
            k0(with);
            with.init();
        }
    }

    public abstract String V();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.transsion.shorttv.base.widget.NoNetworkBigView] */
    public View W() {
        ?? noNetworkBigView = new NoNetworkBigView(this);
        noNetworkBigView.showTitle(true, V());
        noNetworkBigView.retry(new Function0() { // from class: com.transsion.shorttv.base.activity.e
            public final Object invoke() {
                Unit X;
                X = BaseNewActivity.X(BaseNewActivity.this);
                return X;
            }
        });
        noNetworkBigView.goToSetting(new Function0() { // from class: com.transsion.shorttv.base.activity.f
            public final Object invoke() {
                Unit Y;
                Y = BaseNewActivity.Y(BaseNewActivity.this);
                return Y;
            }
        });
        k.a(getPageName());
        return noNetworkBigView;
    }

    public void Z(Activity context) {
        try {
            Result.Companion companion = Result.Companion;
            Object systemService = context != null ? context.getSystemService("input_method") : null;
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            Result.constructor-impl(Boolean.valueOf(((InputMethodManager) systemService).hideSoftInputFromWindow(context.getWindow().getDecorView().getWindowToken(), 0)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public abstract void a0();

    protected void attachBaseContext(Context newBase) {
        if (newBase == null) {
            super.attachBaseContext(newBase);
        } else {
            d.b bVar = com.transsion.shorttv.base.locale.d.f;
            super.attachBaseContext(bVar.i(newBase, bVar.e().h()));
        }
    }

    public abstract void b0();

    public abstract void c0();

    public boolean d0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.shorttv.base.activity.BaseMusicFloatActivity
    public boolean dispatchTouchEvent(MotionEvent event) {
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.downY = event.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float rawY = event.getRawY();
            this.moveY = rawY;
            if (Math.abs(rawY - this.downY) > 50.0f) {
                j P = P();
                if (P != null) {
                    P.b();
                }
                Z(this);
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public boolean e0() {
        return true;
    }

    public abstract void f0();

    public void g0() {
    }

    @Override // hr.e
    public qi.b getLogViewConfig() {
        return (qi.b) this.logViewConfig.getValue();
    }

    public final void i0() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            cr.b.a(frameLayout);
        }
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

    public final void j0() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void k0(ImmersionBar with) {
        Intrinsics.h(with, "with");
    }

    public qi.b newLogViewConfig() {
        return e.a.a(this);
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        super.onConnected(network, networkCapabilities);
        v.a(this).b(new BaseNewActivity$onConnected$1(this, null));
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        b0();
        c0();
        a0();
        if (l.a.e()) {
            f0();
        }
        g0();
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    public void onDisconnected() {
        super.onDisconnected();
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    public void onPause() {
        super.onPause();
        e.a.b(this);
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    public void onResume() {
        j P;
        super.onResume();
        e.a.c(this);
        if (!isAttach() || (P = P()) == null) {
            return;
        }
        P.a(new WeakReference(this));
    }

    protected void onStop() {
        j P;
        super.onStop();
        if (!isAttach() || (P = P()) == null) {
            return;
        }
        P.e(new WeakReference(this));
    }

    public abstract void retryLoadData();

    public boolean setImmersionStatusBar() {
        return true;
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    protected void setView() {
        setContentView(R.layout.short_tv_default_base_layout);
        this.llRootView = (FrameLayout) findViewById(R.id.llRootView);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.flContent);
        if (frameLayout != null) {
            frameLayout.addView(getMViewBinding().getRoot());
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.flStateView);
        if (frameLayout2 == null) {
            frameLayout2 = null;
        } else if (d0() && !l.a.e()) {
            frameLayout2.setVisibility(0);
            frameLayout2.addView(W());
        }
        this.flStateView = frameLayout2;
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public int statusColor() {
        return R.color.image_skeleton;
    }
}
