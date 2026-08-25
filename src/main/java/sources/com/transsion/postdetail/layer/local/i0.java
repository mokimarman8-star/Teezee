package com.transsion.postdetail.layer.local;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.postdetail.ui.view.AdCountDownView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i0 {
    public static final a v = new a(null);
    private static final Lazy w = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.d0
        public final Object invoke() {
            i0 j;
            j = i0.j();
            return j;
        }
    });
    private long a;
    private long b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private AdCountDownView j;
    private AppCompatImageView k;
    private Function1 l;
    private Function0 m;
    private int q;
    private int n = 15;
    private int o = 15;
    private long p = 180000;
    private Handler r = new Handler(Looper.getMainLooper());
    private int s = 1;
    private int t = 1;
    private final Runnable u = new Runnable() { // from class: com.transsion.postdetail.layer.local.e0
        @Override // java.lang.Runnable
        public final void run() {
            i0.i(i0.this);
        }
    };

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i0 a() {
            return (i0) i0.w.getValue();
        }
    }

    private final void h() {
        this.r.postDelayed(this.u, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(i0 i0Var) {
        int i;
        if (i0Var.q < 1) {
            i0Var.m();
            return;
        }
        int i2 = i0Var.i == 1 ? i0Var.s : i0Var.t;
        if (com.transsion.ad.scene.b.a.k() && i0Var.o - i0Var.q >= i2 && ((i = i0Var.i) == 1 || i == 3)) {
            AppCompatImageView appCompatImageView = i0Var.k;
            if (appCompatImageView != null) {
                uf.c.k(appCompatImageView);
            }
            a.a.f(wf.a.a, "LocalVideoLandAdControl", "countdownRunnable, show adCloseView", false, 4, (Object) null);
        }
        AdCountDownView adCountDownView = i0Var.j;
        if (adCountDownView != null) {
            int i3 = i0Var.q;
            i0Var.q = i3 - 1;
            adCountDownView.refreshCountDown(i3);
        }
        i0Var.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i0 j() {
        return new i0();
    }

    private final boolean l() {
        return this.e;
    }

    private final void m() {
        a.a aVar = wf.a.a;
        a.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, curAdType = " + this.i, false, 4, (Object) null);
        int i = this.i;
        if (i == 1) {
            this.c = this.d;
            Function0 function0 = this.m;
            if (function0 != null) {
                function0.invoke();
            }
            AdCountDownView adCountDownView = this.j;
            if (adCountDownView != null) {
                adCountDownView.setVisibility(8);
            }
            if (k()) {
                a.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, start finish, show end", false, 4, (Object) null);
                g(this.i);
                v(3, new Function1() { // from class: com.transsion.postdetail.layer.local.f0
                    public final Object invoke(Object obj) {
                        Unit n;
                        n = i0.n(((Integer) obj).intValue());
                        return n;
                    }
                });
                return;
            } else if (l()) {
                a.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, start finish, show pause", false, 4, (Object) null);
                g(this.i);
                v(2, new Function1() { // from class: com.transsion.postdetail.layer.local.g0
                    public final Object invoke(Object obj) {
                        Unit o;
                        o = i0.o(((Integer) obj).intValue());
                        return o;
                    }
                });
                return;
            } else {
                a.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, start finish now", false, 4, (Object) null);
                Function1 function1 = this.l;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(this.i));
                    return;
                }
                return;
            }
        }
        if (i == 2) {
            a.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, pause finish now", false, 4, (Object) null);
            Function1 function12 = this.l;
            if (function12 != null) {
                function12.invoke(Integer.valueOf(this.i));
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        this.f = true;
        this.g = false;
        AdCountDownView adCountDownView2 = this.j;
        if (adCountDownView2 != null) {
            adCountDownView2.setVisibility(8);
        }
        if (l()) {
            a.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, end finish , show pause", false, 4, (Object) null);
            g(this.i);
            v(2, new Function1() { // from class: com.transsion.postdetail.layer.local.h0
                public final Object invoke(Object obj) {
                    Unit p;
                    p = i0.p(((Integer) obj).intValue());
                    return p;
                }
            });
        } else {
            a.a.f(aVar, "LocalVideoLandAdControl", "onCountdownFinish, end finish now", false, 4, (Object) null);
            Function1 function13 = this.l;
            if (function13 != null) {
                function13.invoke(Integer.valueOf(this.i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(int i) {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(int i) {
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(int i) {
        return Unit.a;
    }

    private final void q(Function1 function1) {
        w(this.o);
    }

    private final void r(Function1 function1) {
        AdCountDownView adCountDownView = this.j;
        if (adCountDownView != null) {
            adCountDownView.refreshCountDown(-1);
        }
        AdCountDownView adCountDownView2 = this.j;
        if (adCountDownView2 != null) {
            adCountDownView2.setVisibility(0);
        }
        a.a.f(wf.a.a, "LocalVideoLandAdControl", "onShowPauseAd", false, 4, (Object) null);
    }

    private final void s(Function1 function1) {
        a.a.f(wf.a.a, "LocalVideoLandAdControl", "onShowStartAd", false, 4, (Object) null);
        w(this.n);
    }

    private final void u() {
        this.r.removeCallbacksAndMessages(this.u);
    }

    private final void w(int i) {
        a.a.f(wf.a.a, "LocalVideoLandAdControl", "startCountdown, countdownTime = " + i, false, 4, (Object) null);
        this.q = i;
        AdCountDownView adCountDownView = this.j;
        if (adCountDownView != null) {
            adCountDownView.setVisibility(0);
        }
        this.r.post(this.u);
    }

    public final void g(int i) {
        a.a.f(wf.a.a, "LocalVideoLandAdControl", "----closeLandAd, adType = " + i, false, 4, (Object) null);
        this.i = 0;
        u();
        AppCompatImageView appCompatImageView = this.k;
        if (appCompatImageView != null) {
            uf.c.g(appCompatImageView);
        }
    }

    public final boolean k() {
        if (this.f || this.g || this.a - this.b > this.p) {
            return false;
        }
        if (!this.h) {
            this.h = true;
        }
        return true;
    }

    public final void t(long j, long j2) {
        this.b = j;
        this.a = j2;
    }

    public final void v(int i, Function1 function1) {
        a.a.f(wf.a.a, "LocalVideoLandAdControl", "----showLandAd, adType = " + i, false, 4, (Object) null);
        this.i = i;
        if (i == 1) {
            s(function1);
        } else if (i == 2) {
            r(function1);
        } else {
            if (i != 3) {
                return;
            }
            q(function1);
        }
    }
}
