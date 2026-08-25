package jn;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import com.blankj.utilcode.util.y;
import com.tn.lib.widget.R;
import com.transsion.player.view.R$id;
import com.transsion.player.view.R$layout;
import com.transsion.player.view.R$mipmap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m implements n {
    private final Context b;
    private final ViewGroup c;
    private final String d;
    private com.transsion.player.orplayer.f e;
    private final View f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;
    private float k;
    private Function2 l;
    private float m;
    private float n;
    private boolean o;
    private final Runnable p;

    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.h(view, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.h(view, "v");
            int c = m.this.c();
            if (c > 100) {
                qi.h hVar = qi.h.a;
                hVar.q(hVar.h(), "volume_max", MapsKt.f(new Pair("volume", String.valueOf(c))));
            }
        }
    }

    public static final class b implements r {
        b() {
        }

        public void onStateChanged(u uVar, Lifecycle.Event event) {
            Intrinsics.h(uVar, "source");
            Intrinsics.h(event, "event");
            if (event == Lifecycle.Event.ON_RESUME) {
                ViewGroup viewGroup = m.this.c;
                if (viewGroup != null) {
                    viewGroup.setFocusableInTouchMode(true);
                    viewGroup.requestFocus();
                }
                c.a.d();
            }
        }
    }

    public m(Context context, ViewGroup viewGroup) {
        Intrinsics.h(context, "context");
        this.b = context;
        this.c = viewGroup;
        this.d = "VideoBrightnessVolume";
        this.f = LayoutInflater.from(context).inflate(R$layout.orplayer_layout_brightness_volume, viewGroup, false);
        this.g = LazyKt.b(new Function0() { // from class: jn.g
            public final Object invoke() {
                ImageView B;
                B = m.B(m.this);
                return B;
            }
        });
        this.h = LazyKt.b(new Function0() { // from class: jn.h
            public final Object invoke() {
                ProgressBar q;
                q = m.q(m.this);
                return q;
            }
        });
        this.i = LazyKt.b(new Function0() { // from class: jn.i
            public final Object invoke() {
                ProgressBar D;
                D = m.D(m.this);
                return D;
            }
        });
        this.j = LazyKt.b(new Function0() { // from class: jn.j
            public final Object invoke() {
                View F;
                F = m.F(m.this);
                return F;
            }
        });
        if (viewGroup == null) {
            Log.e("VideoBrightnessVolume", " error: rootView is null !!!");
        }
        this.k = (y.c() / 3.0f) / 25.0f;
        if (viewGroup != null) {
            viewGroup.setOnKeyListener(new View.OnKeyListener() { // from class: jn.k
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    boolean o;
                    o = m.o(m.this, view, i, keyEvent);
                    return o;
                }
            });
        }
        if (viewGroup != null) {
            viewGroup.addOnAttachStateChangeListener(new a());
        }
        C();
        this.p = new Runnable() { // from class: jn.l
            @Override // java.lang.Runnable
            public final void run() {
                m.r(m.this);
            }
        };
    }

    private final void A() {
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.removeCallbacks(this.p);
            View view = this.f;
            Intrinsics.g(view, "progressRootView");
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageView B(m mVar) {
        return (ImageView) mVar.f.findViewById(R$id.bvIV);
    }

    private final void C() {
        ComponentActivity componentActivity = this.b;
        if (componentActivity instanceof ComponentActivity) {
            componentActivity.getLifecycle().a(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProgressBar D(m mVar) {
        return (ProgressBar) mVar.f.findViewById(R$id.secProgress);
    }

    private final void E(boolean z, int i) {
        if (i < 0) {
            return;
        }
        x().setImageResource(i == 0 ? z ? R$mipmap.ic_volume_0 : R$mipmap.ic_brightness_33 : i <= 33 ? z ? R$mipmap.ic_volume_33 : R$mipmap.ic_brightness_33 : i <= 66 ? z ? R$mipmap.ic_volume_66 : R$mipmap.ic_brightness_66 : i <= 100 ? z ? R$mipmap.ic_volume_66 : R$mipmap.ic_brightness_100 : z ? R$mipmap.ic_volume_100 : R$mipmap.ic_brightness_100);
        v().setProgress(i);
        int h = RangesKt.h(RangesKt.e(i - 100, 0), 100);
        y().setVisibility(h > 0 ? 0 : 8);
        y().setProgress(h);
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View F(m mVar) {
        return mVar.f.findViewById(R$id.tipsLL);
    }

    private final void G(int i) {
        com.transsion.player.orplayer.f fVar;
        int c = c();
        int k = c.a.k(i);
        if (k <= 100 && (fVar = this.e) != null) {
            fVar.setVolume(1.0f);
        }
        Function2 function2 = this.l;
        if (function2 != null) {
            function2.invoke(Boolean.TRUE, Integer.valueOf(k));
        }
        E(true, k);
        s(k, c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(m mVar, View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i == 24) {
            int c = mVar.c();
            mVar.G((91 > c || c >= 100) ? 10 : 100 - c);
        } else {
            if (i != 25) {
                return false;
            }
            mVar.G(-10);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProgressBar q(m mVar) {
        return (ProgressBar) mVar.f.findViewById(R$id.bvProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(m mVar) {
        mVar.A();
    }

    private final void s(int i, int i2) {
        com.transsion.player.orplayer.f fVar;
        if (i > 100 && (fVar = this.e) != null) {
            fVar.setVolume(i / 100.0f);
        }
        t(i, i2);
    }

    private final void t(int i, int i2) {
        if (i2 >= 100 || i != 100) {
            return;
        }
        z().setVisibility(0);
        z().postDelayed(new Runnable() { // from class: jn.f
            @Override // java.lang.Runnable
            public final void run() {
                m.u(m.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(m mVar) {
        mVar.z().setVisibility(8);
    }

    private final ProgressBar v() {
        Object value = this.h.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (ProgressBar) value;
    }

    private final ImageView x() {
        Object value = this.g.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (ImageView) value;
    }

    private final ProgressBar y() {
        Object value = this.i.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (ProgressBar) value;
    }

    private final View z() {
        Object value = this.j.getValue();
        Intrinsics.g(value, "getValue(...)");
        return (View) value;
    }

    @Override // jn.n
    public void a(float f, float f2) {
        Context context = this.b;
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        float f3 = 1.0f;
        float f4 = f + (f2 * 1.0f);
        if (f4 <= 0.0f) {
            f3 = 0.0f;
        } else if (f4 < 1.0f) {
            f3 = f4;
        }
        attributes.screenBrightness = f3;
        window.setAttributes(attributes);
        Function2 function2 = this.l;
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, Integer.valueOf((int) (100 * f3)));
        }
        E(false, (int) (f3 * 100));
    }

    @Override // jn.n
    public float b() {
        Context context = this.b;
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        Window window = ((Activity) context).getWindow();
        if (window == null) {
            return 0.0f;
        }
        float f = window.getAttributes().screenBrightness;
        return f == -1.0f ? w() : f;
    }

    @Override // jn.n
    public int c() {
        return c.a.e();
    }

    @Override // jn.n
    public void d(float f, float f2, int i) {
        if (this.m != f) {
            this.n = f;
            this.m = f;
        }
        if (i <= 0) {
            i = y.c();
        }
        int i2 = (int) ((((this.n - f2) * 80.0f) / i) + 0.5f);
        if (Math.abs(i2) == 0) {
            return;
        }
        this.n = f2;
        G(i2);
    }

    @Override // jn.n
    public void e(com.transsion.player.orplayer.f fVar) {
        this.e = fVar;
    }

    @Override // jn.n
    public void f(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("show:");
        sb.append(z);
        if (this.c == null) {
            return;
        }
        if (!z) {
            A();
            return;
        }
        View view = this.f;
        Intrinsics.g(view, "progressRootView");
        view.setVisibility(0);
        try {
            Result.Companion companion = Result.Companion;
            if (!Intrinsics.c(this.c.getChildAt(r4.getChildCount() - 1), this.f)) {
                this.c.removeView(this.f);
            }
            ViewGroup viewGroup = this.c;
            View view2 = this.f;
            Intrinsics.g(view2, "progressRootView");
            if (viewGroup.indexOfChild(view2) == -1) {
                this.c.addView(this.f);
            }
            if (this.o) {
                ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = com.blankj.utilcode.util.d.c() + ((int) this.b.getResources().getDimension(R.dimen.toolbar_height));
                    this.f.setLayoutParams(marginLayoutParams);
                }
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        this.c.removeCallbacks(this.p);
        this.c.postDelayed(this.p, 500L);
    }

    @Override // jn.n
    public void g() {
        this.o = true;
    }

    public float w() {
        Context context = this.b;
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        try {
            return (Settings.System.getFloat(((Activity) context).getContentResolver(), "screen_brightness") * 1.0f) / 255;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }
}
