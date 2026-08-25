package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    private static final int f7300r = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    final View f7303c;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f7304d;

    /* renamed from: g, reason: collision with root package name */
    private int f7307g;

    /* renamed from: h, reason: collision with root package name */
    private int f7308h;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7312l;

    /* renamed from: m, reason: collision with root package name */
    boolean f7313m;

    /* renamed from: n, reason: collision with root package name */
    boolean f7314n;

    /* renamed from: o, reason: collision with root package name */
    boolean f7315o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7316p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7317q;

    /* renamed from: a, reason: collision with root package name */
    final a f7301a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final Interpolator f7302b = new AccelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    private float[] f7305e = {0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    private float[] f7306f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i, reason: collision with root package name */
    private float[] f7309i = {0.0f, 0.0f};

    /* renamed from: j, reason: collision with root package name */
    private float[] f7310j = {0.0f, 0.0f};

    /* renamed from: k, reason: collision with root package name */
    private float[] f7311k = {Float.MAX_VALUE, Float.MAX_VALUE};

    private class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.f7315o) {
                if (autoScrollHelper.f7313m) {
                    autoScrollHelper.f7313m = false;
                    autoScrollHelper.f7301a.m();
                }
                a aVar = AutoScrollHelper.this.f7301a;
                if (aVar.h() || !AutoScrollHelper.this.u()) {
                    AutoScrollHelper.this.f7315o = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.f7314n) {
                    autoScrollHelper2.f7314n = false;
                    autoScrollHelper2.c();
                }
                aVar.a();
                AutoScrollHelper.this.j(aVar.b(), aVar.c());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.f7303c, this);
            }
        }
    }

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f7318a;

        /* renamed from: b, reason: collision with root package name */
        private int f7319b;

        /* renamed from: c, reason: collision with root package name */
        private float f7320c;

        /* renamed from: d, reason: collision with root package name */
        private float f7321d;

        /* renamed from: j, reason: collision with root package name */
        private float f7327j;

        /* renamed from: k, reason: collision with root package name */
        private int f7328k;

        /* renamed from: e, reason: collision with root package name */
        private long f7322e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f7326i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f7323f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f7324g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f7325h = 0;

        a() {
        }

        private float e(long j5) {
            if (j5 < this.f7322e) {
                return 0.0f;
            }
            long j6 = this.f7326i;
            if (j6 < 0 || j5 < j6) {
                return AutoScrollHelper.e((j5 - r0) / this.f7318a, 0.0f, 1.0f) * 0.5f;
            }
            float f5 = this.f7327j;
            return (1.0f - f5) + (f5 * AutoScrollHelper.e((j5 - j6) / this.f7328k, 0.0f, 1.0f));
        }

        private float g(float f5) {
            return ((-4.0f) * f5 * f5) + (f5 * 4.0f);
        }

        public void a() {
            if (this.f7323f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float g5 = g(e(currentAnimationTimeMillis));
            long j5 = currentAnimationTimeMillis - this.f7323f;
            this.f7323f = currentAnimationTimeMillis;
            float f5 = j5 * g5;
            this.f7324g = (int) (this.f7320c * f5);
            this.f7325h = (int) (f5 * this.f7321d);
        }

        public int b() {
            return this.f7324g;
        }

        public int c() {
            return this.f7325h;
        }

        public int d() {
            float f5 = this.f7320c;
            return (int) (f5 / Math.abs(f5));
        }

        public int f() {
            float f5 = this.f7321d;
            return (int) (f5 / Math.abs(f5));
        }

        public boolean h() {
            return this.f7326i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f7326i + ((long) this.f7328k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f7328k = AutoScrollHelper.f((int) (currentAnimationTimeMillis - this.f7322e), 0, this.f7319b);
            this.f7327j = e(currentAnimationTimeMillis);
            this.f7326i = currentAnimationTimeMillis;
        }

        public void j(int i5) {
            this.f7319b = i5;
        }

        public void k(int i5) {
            this.f7318a = i5;
        }

        public void l(float f5, float f6) {
            this.f7320c = f5;
            this.f7321d = f6;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f7322e = currentAnimationTimeMillis;
            this.f7326i = -1L;
            this.f7323f = currentAnimationTimeMillis;
            this.f7327j = 0.5f;
            this.f7324g = 0;
            this.f7325h = 0;
        }
    }

    public AutoScrollHelper(View view) {
        this.f7303c = view;
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        float f6 = (int) ((1575.0f * f5) + 0.5f);
        o(f6, f6);
        float f7 = (int) ((f5 * 315.0f) + 0.5f);
        p(f7, f7);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f7300r);
        r(500);
        q(500);
    }

    private float d(int i5, float f5, float f6, float f7) {
        float h5 = h(this.f7305e[i5], f6, this.f7306f[i5], f5);
        if (h5 == 0.0f) {
            return 0.0f;
        }
        float f8 = this.f7309i[i5];
        float f9 = this.f7310j[i5];
        float f10 = this.f7311k[i5];
        float f11 = f8 * f7;
        return h5 > 0.0f ? e(h5 * f11, f9, f10) : -e((-h5) * f11, f9, f10);
    }

    static float e(float f5, float f6, float f7) {
        return f5 > f7 ? f7 : f5 < f6 ? f6 : f5;
    }

    static int f(int i5, int i6, int i7) {
        return i5 > i7 ? i7 : i5 < i6 ? i6 : i5;
    }

    private float g(float f5, float f6) {
        if (f6 == 0.0f) {
            return 0.0f;
        }
        int i5 = this.f7307g;
        if (i5 == 0 || i5 == 1) {
            if (f5 < f6) {
                if (f5 >= 0.0f) {
                    return 1.0f - (f5 / f6);
                }
                if (this.f7315o && i5 == 1) {
                    return 1.0f;
                }
            }
        } else if (i5 == 2 && f5 < 0.0f) {
            return f5 / (-f6);
        }
        return 0.0f;
    }

    private float h(float f5, float f6, float f7, float f8) {
        float interpolation;
        float e5 = e(f5 * f6, 0.0f, f7);
        float g5 = g(f6 - f8, e5) - g(f8, e5);
        if (g5 < 0.0f) {
            interpolation = -this.f7302b.getInterpolation(-g5);
        } else {
            if (g5 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f7302b.getInterpolation(g5);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f7313m) {
            this.f7315o = false;
        } else {
            this.f7301a.i();
        }
    }

    private void v() {
        int i5;
        if (this.f7304d == null) {
            this.f7304d = new ScrollAnimationRunnable();
        }
        this.f7315o = true;
        this.f7313m = true;
        if (this.f7312l || (i5 = this.f7308h) <= 0) {
            this.f7304d.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.f7303c, this.f7304d, i5);
        }
        this.f7312l = true;
    }

    public abstract boolean a(int i5);

    public abstract boolean b(int i5);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f7303c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i5, int i6);

    public AutoScrollHelper k(int i5) {
        this.f7308h = i5;
        return this;
    }

    public AutoScrollHelper l(int i5) {
        this.f7307g = i5;
        return this;
    }

    public AutoScrollHelper m(boolean z5) {
        if (this.f7316p && !z5) {
            i();
        }
        this.f7316p = z5;
        return this;
    }

    public AutoScrollHelper n(float f5, float f6) {
        float[] fArr = this.f7306f;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    public AutoScrollHelper o(float f5, float f6) {
        float[] fArr = this.f7311k;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f7316p) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            i();
            return this.f7317q && this.f7315o;
        }
        this.f7314n = true;
        this.f7312l = false;
        this.f7301a.l(d(0, motionEvent.getX(), view.getWidth(), this.f7303c.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f7303c.getHeight()));
        if (!this.f7315o && u()) {
            v();
        }
        if (this.f7317q) {
            return false;
        }
    }

    public AutoScrollHelper p(float f5, float f6) {
        float[] fArr = this.f7310j;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    public AutoScrollHelper q(int i5) {
        this.f7301a.j(i5);
        return this;
    }

    public AutoScrollHelper r(int i5) {
        this.f7301a.k(i5);
        return this;
    }

    public AutoScrollHelper s(float f5, float f6) {
        float[] fArr = this.f7305e;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    public AutoScrollHelper t(float f5, float f6) {
        float[] fArr = this.f7309i;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    boolean u() {
        a aVar = this.f7301a;
        int f5 = aVar.f();
        int d5 = aVar.d();
        return (f5 != 0 && b(f5)) || (d5 != 0 && a(d5));
    }
}
