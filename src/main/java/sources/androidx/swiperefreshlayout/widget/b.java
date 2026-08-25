package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.i;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class b extends Drawable implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    private static final Interpolator f13426g = new LinearInterpolator();

    /* renamed from: h, reason: collision with root package name */
    private static final Interpolator f13427h = new o1.b();

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f13428i = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    private final c f13429a;

    /* renamed from: b, reason: collision with root package name */
    private float f13430b;

    /* renamed from: c, reason: collision with root package name */
    private Resources f13431c;

    /* renamed from: d, reason: collision with root package name */
    private Animator f13432d;

    /* renamed from: e, reason: collision with root package name */
    float f13433e;

    /* renamed from: f, reason: collision with root package name */
    boolean f13434f;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f13435a;

        a(c cVar) {
            this.f13435a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(floatValue, this.f13435a);
            b.this.b(floatValue, this.f13435a, false);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.b$b, reason: collision with other inner class name */
    class C0105b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f13437a;

        C0105b(c cVar) {
            this.f13437a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.f13437a, true);
            this.f13437a.A();
            this.f13437a.l();
            b bVar = b.this;
            if (!bVar.f13434f) {
                bVar.f13433e += 1.0f;
                return;
            }
            bVar.f13434f = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f13437a.x(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f13433e = 0.0f;
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final RectF f13439a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        final Paint f13440b;

        /* renamed from: c, reason: collision with root package name */
        final Paint f13441c;

        /* renamed from: d, reason: collision with root package name */
        final Paint f13442d;

        /* renamed from: e, reason: collision with root package name */
        float f13443e;

        /* renamed from: f, reason: collision with root package name */
        float f13444f;

        /* renamed from: g, reason: collision with root package name */
        float f13445g;

        /* renamed from: h, reason: collision with root package name */
        float f13446h;

        /* renamed from: i, reason: collision with root package name */
        int[] f13447i;

        /* renamed from: j, reason: collision with root package name */
        int f13448j;

        /* renamed from: k, reason: collision with root package name */
        float f13449k;

        /* renamed from: l, reason: collision with root package name */
        float f13450l;

        /* renamed from: m, reason: collision with root package name */
        float f13451m;

        /* renamed from: n, reason: collision with root package name */
        boolean f13452n;

        /* renamed from: o, reason: collision with root package name */
        Path f13453o;

        /* renamed from: p, reason: collision with root package name */
        float f13454p;

        /* renamed from: q, reason: collision with root package name */
        float f13455q;

        /* renamed from: r, reason: collision with root package name */
        int f13456r;

        /* renamed from: s, reason: collision with root package name */
        int f13457s;

        /* renamed from: t, reason: collision with root package name */
        int f13458t;

        /* renamed from: u, reason: collision with root package name */
        int f13459u;

        c() {
            Paint paint = new Paint();
            this.f13440b = paint;
            Paint paint2 = new Paint();
            this.f13441c = paint2;
            Paint paint3 = new Paint();
            this.f13442d = paint3;
            this.f13443e = 0.0f;
            this.f13444f = 0.0f;
            this.f13445g = 0.0f;
            this.f13446h = 5.0f;
            this.f13454p = 1.0f;
            this.f13458t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void A() {
            this.f13449k = this.f13443e;
            this.f13450l = this.f13444f;
            this.f13451m = this.f13445g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f13439a;
            float f5 = this.f13455q;
            float f6 = (this.f13446h / 2.0f) + f5;
            if (f5 <= 0.0f) {
                f6 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f13456r * this.f13454p) / 2.0f, this.f13446h / 2.0f);
            }
            rectF.set(rect.centerX() - f6, rect.centerY() - f6, rect.centerX() + f6, rect.centerY() + f6);
            float f7 = this.f13443e;
            float f8 = this.f13445g;
            float f9 = (f7 + f8) * 360.0f;
            float f10 = ((this.f13444f + f8) * 360.0f) - f9;
            this.f13440b.setColor(this.f13459u);
            this.f13440b.setAlpha(this.f13458t);
            float f11 = this.f13446h / 2.0f;
            rectF.inset(f11, f11);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f13442d);
            float f12 = -f11;
            rectF.inset(f12, f12);
            canvas.drawArc(rectF, f9, f10, false, this.f13440b);
            b(canvas, f9, f10, rectF);
        }

        void b(Canvas canvas, float f5, float f6, RectF rectF) {
            if (this.f13452n) {
                Path path = this.f13453o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f13453o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f7 = (this.f13456r * this.f13454p) / 2.0f;
                this.f13453o.moveTo(0.0f, 0.0f);
                this.f13453o.lineTo(this.f13456r * this.f13454p, 0.0f);
                Path path3 = this.f13453o;
                float f8 = this.f13456r;
                float f9 = this.f13454p;
                path3.lineTo((f8 * f9) / 2.0f, this.f13457s * f9);
                this.f13453o.offset((min + rectF.centerX()) - f7, rectF.centerY() + (this.f13446h / 2.0f));
                this.f13453o.close();
                this.f13441c.setColor(this.f13459u);
                this.f13441c.setAlpha(this.f13458t);
                canvas.save();
                canvas.rotate(f5 + f6, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f13453o, this.f13441c);
                canvas.restore();
            }
        }

        int c() {
            return this.f13458t;
        }

        float d() {
            return this.f13444f;
        }

        int e() {
            return this.f13447i[f()];
        }

        int f() {
            return (this.f13448j + 1) % this.f13447i.length;
        }

        float g() {
            return this.f13443e;
        }

        int h() {
            return this.f13447i[this.f13448j];
        }

        float i() {
            return this.f13450l;
        }

        float j() {
            return this.f13451m;
        }

        float k() {
            return this.f13449k;
        }

        void l() {
            t(f());
        }

        void m() {
            this.f13449k = 0.0f;
            this.f13450l = 0.0f;
            this.f13451m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        void n(int i5) {
            this.f13458t = i5;
        }

        void o(float f5, float f6) {
            this.f13456r = (int) f5;
            this.f13457s = (int) f6;
        }

        void p(float f5) {
            if (f5 != this.f13454p) {
                this.f13454p = f5;
            }
        }

        void q(float f5) {
            this.f13455q = f5;
        }

        void r(int i5) {
            this.f13459u = i5;
        }

        void s(ColorFilter colorFilter) {
            this.f13440b.setColorFilter(colorFilter);
        }

        void t(int i5) {
            this.f13448j = i5;
            this.f13459u = this.f13447i[i5];
        }

        void u(int[] iArr) {
            this.f13447i = iArr;
            t(0);
        }

        void v(float f5) {
            this.f13444f = f5;
        }

        void w(float f5) {
            this.f13445g = f5;
        }

        void x(boolean z5) {
            if (this.f13452n != z5) {
                this.f13452n = z5;
            }
        }

        void y(float f5) {
            this.f13443e = f5;
        }

        void z(float f5) {
            this.f13446h = f5;
            this.f13440b.setStrokeWidth(f5);
        }
    }

    public b(Context context) {
        this.f13431c = ((Context) i.g(context)).getResources();
        c cVar = new c();
        this.f13429a = cVar;
        cVar.u(f13428i);
        k(2.5f);
        m();
    }

    private void a(float f5, c cVar) {
        n(f5, cVar);
        float floor = (float) (Math.floor(cVar.j() / 0.8f) + 1.0d);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f5));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((floor - cVar.j()) * f5));
    }

    private int c(float f5, int i5, int i6) {
        return ((((i5 >> 24) & 255) + ((int) ((((i6 >> 24) & 255) - r0) * f5))) << 24) | ((((i5 >> 16) & 255) + ((int) ((((i6 >> 16) & 255) - r1) * f5))) << 16) | ((((i5 >> 8) & 255) + ((int) ((((i6 >> 8) & 255) - r2) * f5))) << 8) | ((i5 & 255) + ((int) (f5 * ((i6 & 255) - r8))));
    }

    private void h(float f5) {
        this.f13430b = f5;
    }

    private void i(float f5, float f6, float f7, float f8) {
        c cVar = this.f13429a;
        float f9 = this.f13431c.getDisplayMetrics().density;
        cVar.z(f6 * f9);
        cVar.q(f5 * f9);
        cVar.t(0);
        cVar.o(f7 * f9, f8 * f9);
    }

    private void m() {
        c cVar = this.f13429a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f13426g);
        ofFloat.addListener(new C0105b(cVar));
        this.f13432d = ofFloat;
    }

    void b(float f5, c cVar, boolean z5) {
        float interpolation;
        float f6;
        if (this.f13434f) {
            a(f5, cVar);
            return;
        }
        if (f5 != 1.0f || z5) {
            float j5 = cVar.j();
            if (f5 < 0.5f) {
                interpolation = cVar.k();
                f6 = (f13427h.getInterpolation(f5 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float k5 = cVar.k() + 0.79f;
                interpolation = k5 - (((1.0f - f13427h.getInterpolation((f5 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f6 = k5;
            }
            float f7 = j5 + (0.20999998f * f5);
            float f8 = (f5 + this.f13433e) * 216.0f;
            cVar.y(interpolation);
            cVar.v(f6);
            cVar.w(f7);
            h(f8);
        }
    }

    public void d(boolean z5) {
        this.f13429a.x(z5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f13430b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f13429a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f5) {
        this.f13429a.p(f5);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f13429a.u(iArr);
        this.f13429a.t(0);
        invalidateSelf();
    }

    public void g(float f5) {
        this.f13429a.w(f5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f13429a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f13432d.isRunning();
    }

    public void j(float f5, float f6) {
        this.f13429a.y(f5);
        this.f13429a.v(f6);
        invalidateSelf();
    }

    public void k(float f5) {
        this.f13429a.z(f5);
        invalidateSelf();
    }

    public void l(int i5) {
        if (i5 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    void n(float f5, c cVar) {
        if (f5 > 0.75f) {
            cVar.r(c((f5 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        this.f13429a.n(i5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13429a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f13432d.cancel();
        this.f13429a.A();
        if (this.f13429a.d() != this.f13429a.g()) {
            this.f13434f = true;
            this.f13432d.setDuration(666L);
            this.f13432d.start();
        } else {
            this.f13429a.t(0);
            this.f13429a.m();
            this.f13432d.setDuration(1332L);
            this.f13432d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f13432d.cancel();
        h(0.0f);
        this.f13429a.x(false);
        this.f13429a.t(0);
        this.f13429a.m();
        invalidateSelf();
    }
}
