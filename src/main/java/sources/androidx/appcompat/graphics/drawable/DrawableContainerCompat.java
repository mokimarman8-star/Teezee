package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DrawableContainerCompat extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private c f343a;

    /* renamed from: b, reason: collision with root package name */
    private Rect f344b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f345c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f346d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f348f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f350h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f351i;

    /* renamed from: j, reason: collision with root package name */
    private long f352j;

    /* renamed from: k, reason: collision with root package name */
    private long f353k;

    /* renamed from: l, reason: collision with root package name */
    private b f354l;

    /* renamed from: e, reason: collision with root package name */
    private int f347e = 255;

    /* renamed from: g, reason: collision with root package name */
    private int f349g = -1;

    private static class a {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static class b implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        private Drawable.Callback f355a;

        b() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f355a;
            this.f355a = null;
            return callback;
        }

        public b b(Drawable.Callback callback) {
            this.f355a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
            Drawable.Callback callback = this.f355a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j5);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f355a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class c extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a, reason: collision with root package name */
        final DrawableContainerCompat f356a;

        /* renamed from: b, reason: collision with root package name */
        Resources f357b;

        /* renamed from: c, reason: collision with root package name */
        int f358c;

        /* renamed from: d, reason: collision with root package name */
        int f359d;

        /* renamed from: e, reason: collision with root package name */
        int f360e;

        /* renamed from: f, reason: collision with root package name */
        SparseArray f361f;

        /* renamed from: g, reason: collision with root package name */
        Drawable[] f362g;

        /* renamed from: h, reason: collision with root package name */
        int f363h;

        /* renamed from: i, reason: collision with root package name */
        boolean f364i;

        /* renamed from: j, reason: collision with root package name */
        boolean f365j;

        /* renamed from: k, reason: collision with root package name */
        Rect f366k;

        /* renamed from: l, reason: collision with root package name */
        boolean f367l;

        /* renamed from: m, reason: collision with root package name */
        boolean f368m;

        /* renamed from: n, reason: collision with root package name */
        int f369n;

        /* renamed from: o, reason: collision with root package name */
        int f370o;

        /* renamed from: p, reason: collision with root package name */
        int f371p;

        /* renamed from: q, reason: collision with root package name */
        int f372q;

        /* renamed from: r, reason: collision with root package name */
        boolean f373r;

        /* renamed from: s, reason: collision with root package name */
        int f374s;

        /* renamed from: t, reason: collision with root package name */
        boolean f375t;

        /* renamed from: u, reason: collision with root package name */
        boolean f376u;

        /* renamed from: v, reason: collision with root package name */
        boolean f377v;

        /* renamed from: w, reason: collision with root package name */
        boolean f378w;

        /* renamed from: x, reason: collision with root package name */
        boolean f379x;

        /* renamed from: y, reason: collision with root package name */
        boolean f380y;

        /* renamed from: z, reason: collision with root package name */
        int f381z;

        c(c cVar, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            this.f364i = false;
            this.f367l = false;
            this.f379x = true;
            this.A = 0;
            this.B = 0;
            this.f356a = drawableContainerCompat;
            this.f357b = resources != null ? resources : cVar != null ? cVar.f357b : null;
            int f5 = DrawableContainerCompat.f(resources, cVar != null ? cVar.f358c : 0);
            this.f358c = f5;
            if (cVar == null) {
                this.f362g = new Drawable[10];
                this.f363h = 0;
                return;
            }
            this.f359d = cVar.f359d;
            this.f360e = cVar.f360e;
            this.f377v = true;
            this.f378w = true;
            this.f364i = cVar.f364i;
            this.f367l = cVar.f367l;
            this.f379x = cVar.f379x;
            this.f380y = cVar.f380y;
            this.f381z = cVar.f381z;
            this.A = cVar.A;
            this.B = cVar.B;
            this.C = cVar.C;
            this.D = cVar.D;
            this.E = cVar.E;
            this.F = cVar.F;
            this.G = cVar.G;
            this.H = cVar.H;
            this.I = cVar.I;
            if (cVar.f358c == f5) {
                if (cVar.f365j) {
                    this.f366k = cVar.f366k != null ? new Rect(cVar.f366k) : null;
                    this.f365j = true;
                }
                if (cVar.f368m) {
                    this.f369n = cVar.f369n;
                    this.f370o = cVar.f370o;
                    this.f371p = cVar.f371p;
                    this.f372q = cVar.f372q;
                    this.f368m = true;
                }
            }
            if (cVar.f373r) {
                this.f374s = cVar.f374s;
                this.f373r = true;
            }
            if (cVar.f375t) {
                this.f376u = cVar.f376u;
                this.f375t = true;
            }
            Drawable[] drawableArr = cVar.f362g;
            this.f362g = new Drawable[drawableArr.length];
            this.f363h = cVar.f363h;
            SparseArray sparseArray = cVar.f361f;
            if (sparseArray != null) {
                this.f361f = sparseArray.clone();
            } else {
                this.f361f = new SparseArray(this.f363h);
            }
            int i5 = this.f363h;
            for (int i6 = 0; i6 < i5; i6++) {
                Drawable drawable = drawableArr[i6];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f361f.put(i6, constantState);
                    } else {
                        this.f362g[i6] = drawableArr[i6];
                    }
                }
            }
        }

        private void e() {
            SparseArray sparseArray = this.f361f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i5 = 0; i5 < size; i5++) {
                    this.f362g[this.f361f.keyAt(i5)] = t(((Drawable.ConstantState) this.f361f.valueAt(i5)).newDrawable(this.f357b));
                }
                this.f361f = null;
            }
        }

        private Drawable t(Drawable drawable) {
            a1.a.m(drawable, this.f381z);
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f356a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i5 = this.f363h;
            if (i5 >= this.f362g.length) {
                o(i5, i5 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f356a);
            this.f362g[i5] = drawable;
            this.f363h++;
            this.f360e = drawable.getChangingConfigurations() | this.f360e;
            p();
            this.f366k = null;
            this.f365j = false;
            this.f368m = false;
            this.f377v = false;
            return i5;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i5 = this.f363h;
                Drawable[] drawableArr = this.f362g;
                for (int i6 = 0; i6 < i5; i6++) {
                    Drawable drawable = drawableArr[i6];
                    if (drawable != null && a1.a.b(drawable)) {
                        a1.a.a(drawableArr[i6], theme);
                        this.f360e |= drawableArr[i6].getChangingConfigurations();
                    }
                }
                z(a.c(theme));
            }
        }

        public boolean c() {
            if (this.f377v) {
                return this.f378w;
            }
            e();
            this.f377v = true;
            int i5 = this.f363h;
            Drawable[] drawableArr = this.f362g;
            for (int i6 = 0; i6 < i5; i6++) {
                if (drawableArr[i6].getConstantState() == null) {
                    this.f378w = false;
                    return false;
                }
            }
            this.f378w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i5 = this.f363h;
            Drawable[] drawableArr = this.f362g;
            for (int i6 = 0; i6 < i5; i6++) {
                Drawable drawable = drawableArr[i6];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f361f.get(i6);
                    if (constantState != null && a.a(constantState)) {
                        return true;
                    }
                } else if (a1.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f368m = true;
            e();
            int i5 = this.f363h;
            Drawable[] drawableArr = this.f362g;
            this.f370o = -1;
            this.f369n = -1;
            this.f372q = 0;
            this.f371p = 0;
            for (int i6 = 0; i6 < i5; i6++) {
                Drawable drawable = drawableArr[i6];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f369n) {
                    this.f369n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f370o) {
                    this.f370o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f371p) {
                    this.f371p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f372q) {
                    this.f372q = minimumHeight;
                }
            }
        }

        final int f() {
            return this.f362g.length;
        }

        public final Drawable g(int i5) {
            int indexOfKey;
            Drawable drawable = this.f362g[i5];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f361f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i5)) < 0) {
                return null;
            }
            Drawable t5 = t(((Drawable.ConstantState) this.f361f.valueAt(indexOfKey)).newDrawable(this.f357b));
            this.f362g[i5] = t5;
            this.f361f.removeAt(indexOfKey);
            if (this.f361f.size() == 0) {
                this.f361f = null;
            }
            return t5;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f359d | this.f360e;
        }

        public final int h() {
            return this.f363h;
        }

        public final int i() {
            if (!this.f368m) {
                d();
            }
            return this.f370o;
        }

        public final int j() {
            if (!this.f368m) {
                d();
            }
            return this.f372q;
        }

        public final int k() {
            if (!this.f368m) {
                d();
            }
            return this.f371p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f364i) {
                return null;
            }
            Rect rect2 = this.f366k;
            if (rect2 != null || this.f365j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i5 = this.f363h;
            Drawable[] drawableArr = this.f362g;
            for (int i6 = 0; i6 < i5; i6++) {
                if (drawableArr[i6].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i7 = rect3.left;
                    if (i7 > rect.left) {
                        rect.left = i7;
                    }
                    int i8 = rect3.top;
                    if (i8 > rect.top) {
                        rect.top = i8;
                    }
                    int i9 = rect3.right;
                    if (i9 > rect.right) {
                        rect.right = i9;
                    }
                    int i10 = rect3.bottom;
                    if (i10 > rect.bottom) {
                        rect.bottom = i10;
                    }
                }
            }
            this.f365j = true;
            this.f366k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f368m) {
                d();
            }
            return this.f369n;
        }

        public final int n() {
            if (this.f373r) {
                return this.f374s;
            }
            e();
            int i5 = this.f363h;
            Drawable[] drawableArr = this.f362g;
            int opacity = i5 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i6 = 1; i6 < i5; i6++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i6].getOpacity());
            }
            this.f374s = opacity;
            this.f373r = true;
            return opacity;
        }

        public void o(int i5, int i6) {
            Drawable[] drawableArr = new Drawable[i6];
            Drawable[] drawableArr2 = this.f362g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i5);
            }
            this.f362g = drawableArr;
        }

        void p() {
            this.f373r = false;
            this.f375t = false;
        }

        public final boolean q() {
            return this.f367l;
        }

        public final boolean r() {
            if (this.f375t) {
                return this.f376u;
            }
            e();
            int i5 = this.f363h;
            Drawable[] drawableArr = this.f362g;
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                if (i6 >= i5) {
                    break;
                }
                if (drawableArr[i6].isStateful()) {
                    z5 = true;
                    break;
                }
                i6++;
            }
            this.f376u = z5;
            this.f375t = true;
            return z5;
        }

        abstract void s();

        public final void u(boolean z5) {
            this.f367l = z5;
        }

        public final void v(int i5) {
            this.A = i5;
        }

        public final void w(int i5) {
            this.B = i5;
        }

        final boolean x(int i5, int i6) {
            int i7 = this.f363h;
            Drawable[] drawableArr = this.f362g;
            boolean z5 = false;
            for (int i8 = 0; i8 < i7; i8++) {
                Drawable drawable = drawableArr[i8];
                if (drawable != null) {
                    boolean m5 = a1.a.m(drawable, i5);
                    if (i8 == i6) {
                        z5 = m5;
                    }
                }
            }
            this.f381z = i5;
            return z5;
        }

        public final void y(boolean z5) {
            this.f364i = z5;
        }

        final void z(Resources resources) {
            if (resources != null) {
                this.f357b = resources;
                int f5 = DrawableContainerCompat.f(resources, this.f358c);
                int i5 = this.f358c;
                this.f358c = f5;
                if (i5 != f5) {
                    this.f368m = false;
                    this.f365j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f354l == null) {
            this.f354l = new b();
        }
        drawable.setCallback(this.f354l.b(drawable.getCallback()));
        try {
            if (this.f343a.A <= 0 && this.f348f) {
                drawable.setAlpha(this.f347e);
            }
            c cVar = this.f343a;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    a1.a.o(drawable, cVar.F);
                }
                c cVar2 = this.f343a;
                if (cVar2.I) {
                    a1.a.p(drawable, cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f343a.f379x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            a1.a.m(drawable, a1.a.f(this));
            a1.a.j(drawable, this.f343a.C);
            Rect rect = this.f344b;
            if (rect != null) {
                a1.a.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.f354l.a());
        } catch (Throwable th) {
            drawable.setCallback(this.f354l.a());
            throw th;
        }
    }

    private boolean e() {
        return isAutoMirrored() && a1.a.f(this) == 1;
    }

    static int f(Resources resources, int i5) {
        if (resources != null) {
            i5 = resources.getDisplayMetrics().densityDpi;
        }
        if (i5 == 0) {
            return 160;
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(boolean z5) {
        boolean z6;
        Drawable drawable;
        boolean z7 = true;
        this.f348f = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f345c;
        if (drawable2 != null) {
            long j5 = this.f352j;
            if (j5 != 0) {
                if (j5 > uptimeMillis) {
                    drawable2.setAlpha(((255 - (((int) ((j5 - uptimeMillis) * 255)) / this.f343a.A)) * this.f347e) / 255);
                    z6 = true;
                    drawable = this.f346d;
                    if (drawable == null) {
                        long j6 = this.f353k;
                        if (j6 != 0) {
                            if (j6 > uptimeMillis) {
                                drawable.setAlpha(((((int) ((j6 - uptimeMillis) * 255)) / this.f343a.B) * this.f347e) / 255);
                                if (z5 && z7) {
                                    scheduleSelf(this.f351i, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                            drawable.setVisible(false, false);
                            this.f346d = null;
                            this.f353k = 0L;
                        }
                    } else {
                        this.f353k = 0L;
                    }
                    z7 = z6;
                    if (z5) {
                        return;
                    } else {
                        return;
                    }
                }
                drawable2.setAlpha(this.f347e);
                this.f352j = 0L;
            }
        } else {
            this.f352j = 0L;
        }
        z6 = false;
        drawable = this.f346d;
        if (drawable == null) {
        }
        z7 = z6;
        if (z5) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f343a.b(theme);
    }

    c b() {
        return this.f343a;
    }

    int c() {
        return this.f349g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f343a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f345c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f346d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean g(int i5) {
        Runnable runnable;
        if (i5 == this.f349g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f343a.B > 0) {
            Drawable drawable = this.f346d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f345c;
            if (drawable2 != null) {
                this.f346d = drawable2;
                this.f353k = this.f343a.B + uptimeMillis;
            } else {
                this.f346d = null;
                this.f353k = 0L;
            }
        } else {
            Drawable drawable3 = this.f345c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i5 >= 0) {
            c cVar = this.f343a;
            if (i5 < cVar.f363h) {
                Drawable g5 = cVar.g(i5);
                this.f345c = g5;
                this.f349g = i5;
                if (g5 != null) {
                    int i6 = this.f343a.A;
                    if (i6 > 0) {
                        this.f352j = uptimeMillis + i6;
                    }
                    d(g5);
                }
                if (this.f352j == 0 || this.f353k != 0) {
                    runnable = this.f351i;
                    if (runnable != null) {
                        this.f351i = new Runnable() { // from class: androidx.appcompat.graphics.drawable.DrawableContainerCompat.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DrawableContainerCompat.this.a(true);
                                DrawableContainerCompat.this.invalidateSelf();
                            }
                        };
                    } else {
                        unscheduleSelf(runnable);
                    }
                    a(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.f345c = null;
        this.f349g = -1;
        if (this.f352j == 0) {
        }
        runnable = this.f351i;
        if (runnable != null) {
        }
        a(true);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f347e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f343a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f343a.c()) {
            return null;
        }
        this.f343a.f359d = getChangingConfigurations();
        return this.f343a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f345c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f344b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f343a.q()) {
            return this.f343a.i();
        }
        Drawable drawable = this.f345c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f343a.q()) {
            return this.f343a.m();
        }
        Drawable drawable = this.f345c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f343a.q()) {
            return this.f343a.j();
        }
        Drawable drawable = this.f345c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f343a.q()) {
            return this.f343a.k();
        }
        Drawable drawable = this.f345c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f345c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f343a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f345c;
        if (drawable != null) {
            a.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect l5 = this.f343a.l();
        if (l5 != null) {
            rect.set(l5);
            padding = (l5.right | ((l5.left | l5.top) | l5.bottom)) != 0;
        } else {
            Drawable drawable = this.f345c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i5 = rect.left;
            rect.left = rect.right;
            rect.right = i5;
        }
        return padding;
    }

    void h(c cVar) {
        this.f343a = cVar;
        int i5 = this.f349g;
        if (i5 >= 0) {
            Drawable g5 = cVar.g(i5);
            this.f345c = g5;
            if (g5 != null) {
                d(g5);
            }
        }
        this.f346d = null;
    }

    final void i(Resources resources) {
        this.f343a.z(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f343a;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable != this.f345c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f343a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f343a.r();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z5;
        Drawable drawable = this.f346d;
        boolean z6 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f346d = null;
            z5 = true;
        } else {
            z5 = false;
        }
        Drawable drawable2 = this.f345c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f348f) {
                this.f345c.setAlpha(this.f347e);
            }
        }
        if (this.f353k != 0) {
            this.f353k = 0L;
            z5 = true;
        }
        if (this.f352j != 0) {
            this.f352j = 0L;
        } else {
            z6 = z5;
        }
        if (z6) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f350h && super.mutate() == this) {
            c b5 = b();
            b5.s();
            h(b5);
            this.f350h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f346d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f345c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i5) {
        return this.f343a.x(i5, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i5) {
        Drawable drawable = this.f346d;
        if (drawable != null) {
            return drawable.setLevel(i5);
        }
        Drawable drawable2 = this.f345c;
        if (drawable2 != null) {
            return drawable2.setLevel(i5);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f346d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f345c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        if (drawable != this.f345c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        if (this.f348f && this.f347e == i5) {
            return;
        }
        this.f348f = true;
        this.f347e = i5;
        Drawable drawable = this.f345c;
        if (drawable != null) {
            if (this.f352j == 0) {
                drawable.setAlpha(i5);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z5) {
        c cVar = this.f343a;
        if (cVar.C != z5) {
            cVar.C = z5;
            Drawable drawable = this.f345c;
            if (drawable != null) {
                a1.a.j(drawable, z5);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f343a;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f345c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z5) {
        c cVar = this.f343a;
        if (cVar.f379x != z5) {
            cVar.f379x = z5;
            Drawable drawable = this.f345c;
            if (drawable != null) {
                drawable.setDither(z5);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f5, float f6) {
        Drawable drawable = this.f345c;
        if (drawable != null) {
            a1.a.k(drawable, f5, f6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i5, int i6, int i7, int i8) {
        Rect rect = this.f344b;
        if (rect == null) {
            this.f344b = new Rect(i5, i6, i7, i8);
        } else {
            rect.set(i5, i6, i7, i8);
        }
        Drawable drawable = this.f345c;
        if (drawable != null) {
            a1.a.l(drawable, i5, i6, i7, i8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i5) {
        setTintList(ColorStateList.valueOf(i5));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f343a;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            a1.a.o(this.f345c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f343a;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            a1.a.p(this.f345c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        boolean visible = super.setVisible(z5, z6);
        Drawable drawable = this.f346d;
        if (drawable != null) {
            drawable.setVisible(z5, z6);
        }
        Drawable drawable2 = this.f345c;
        if (drawable2 != null) {
            drawable2.setVisible(z5, z6);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f345c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
