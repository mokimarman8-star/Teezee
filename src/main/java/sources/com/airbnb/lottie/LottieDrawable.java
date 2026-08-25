package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import q4.a;
import q4.b;
import r4.d;
import w4.v;
import x4.f;
import x4.g;
import x4.i;
import x4.k;
import y4.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    private static final boolean S;
    private static final List T;
    private static final Executor U;
    private Canvas A;
    private Rect B;
    private RectF C;
    private Paint D;
    private Rect E;
    private Rect F;
    private RectF G;
    private RectF H;
    private Matrix I;
    private Matrix J;
    private boolean K;
    private AsyncUpdates L;
    private final ValueAnimator.AnimatorUpdateListener M;
    private final Semaphore N;
    private Handler O;
    private Runnable P;
    private final Runnable Q;
    private float R;
    private h a;
    private final i b;
    private boolean c;
    private boolean d;
    private boolean e;
    private OnVisibleAction f;
    private final ArrayList g;
    private b h;
    private String i;
    private a j;
    private Map k;
    String l;
    a m;
    private final k0 n;
    private boolean o;
    private boolean p;
    private com.airbnb.lottie.model.layer.b q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private RenderMode w;
    private boolean x;
    private final Matrix y;
    private Bitmap z;

    private enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    static {
        S = Build.VERSION.SDK_INT <= 25;
        T = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
        U = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) new LinkedBlockingQueue(), (ThreadFactory) new g());
    }

    public LottieDrawable() {
        i iVar = new i();
        this.b = iVar;
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = OnVisibleAction.NONE;
        this.g = new ArrayList();
        this.n = new k0();
        this.o = false;
        this.p = true;
        this.r = 255;
        this.v = false;
        this.w = RenderMode.AUTOMATIC;
        this.x = false;
        this.y = new Matrix();
        this.K = false;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LottieDrawable.this.p0(valueAnimator);
            }
        };
        this.M = animatorUpdateListener;
        this.N = new Semaphore(1);
        this.Q = new Runnable() { // from class: com.airbnb.lottie.g0
            @Override // java.lang.Runnable
            public final void run() {
                LottieDrawable.this.r0();
            }
        };
        this.R = -3.4028235E38f;
        iVar.addUpdateListener(animatorUpdateListener);
    }

    private void A() {
        h hVar = this.a;
        if (hVar == null) {
            return;
        }
        this.x = this.w.useSoftwareRendering(Build.VERSION.SDK_INT, hVar.q(), hVar.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(int i, int i2, h hVar) {
        i1(i, i2);
    }

    private boolean A1() {
        h hVar = this.a;
        if (hVar == null) {
            return false;
        }
        float f = this.R;
        float l = this.b.l();
        this.R = l;
        return Math.abs(l - f) * hVar.d() >= 50.0f;
    }

    private void B(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(float f, float f2, h hVar) {
        l1(f, f2);
    }

    private void C(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(int i, h hVar) {
        m1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(String str, h hVar) {
        n1(str);
    }

    private void E(Canvas canvas) {
        com.airbnb.lottie.model.layer.b bVar = this.q;
        h hVar = this.a;
        if (bVar == null || hVar == null) {
            return;
        }
        this.y.reset();
        if (!getBounds().isEmpty()) {
            this.y.preScale(r2.width() / hVar.b().width(), r2.height() / hVar.b().height());
            this.y.preTranslate(r2.left, r2.top);
        }
        bVar.h(canvas, this.y, this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(float f, h hVar) {
        o1(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(float f, h hVar) {
        r1(f);
    }

    private void H(int i, int i2) {
        Bitmap bitmap = this.z;
        if (bitmap == null || bitmap.getWidth() < i || this.z.getHeight() < i2) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.z = createBitmap;
            this.A.setBitmap(createBitmap);
            this.K = true;
            return;
        }
        if (this.z.getWidth() > i || this.z.getHeight() > i2) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.z, 0, 0, i, i2);
            this.z = createBitmap2;
            this.A.setBitmap(createBitmap2);
            this.K = true;
        }
    }

    private void I() {
        if (this.A != null) {
            return;
        }
        this.A = new Canvas();
        this.H = new RectF();
        this.I = new Matrix();
        this.J = new Matrix();
        this.B = new Rect();
        this.C = new RectF();
        this.D = new n4.a();
        this.E = new Rect();
        this.F = new Rect();
        this.G = new RectF();
    }

    private void N0(Canvas canvas, com.airbnb.lottie.model.layer.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        I();
        canvas.getMatrix(this.I);
        canvas.getClipBounds(this.B);
        B(this.B, this.C);
        this.I.mapRect(this.C);
        C(this.C, this.B);
        if (this.p) {
            this.H.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            bVar.f(this.H, (Matrix) null, false);
        }
        this.I.mapRect(this.H);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        R0(this.H, width, height);
        if (!j0()) {
            RectF rectF = this.H;
            Rect rect = this.B;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int ceil = (int) Math.ceil(this.H.width());
        int ceil2 = (int) Math.ceil(this.H.height());
        if (ceil <= 0 || ceil2 <= 0) {
            return;
        }
        H(ceil, ceil2);
        if (this.K) {
            this.y.set(this.I);
            this.y.preScale(width, height);
            Matrix matrix = this.y;
            RectF rectF2 = this.H;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.z.eraseColor(0);
            bVar.h(this.A, this.y, this.r);
            this.I.invert(this.J);
            this.J.mapRect(this.G, this.H);
            C(this.G, this.F);
        }
        this.E.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.z, this.E, this.F, this.D);
    }

    private Context P() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private a Q() {
        if (getCallback() == null) {
            return null;
        }
        if (this.j == null) {
            a aVar = new a(getCallback(), this.m);
            this.j = aVar;
            String str = this.l;
            if (str != null) {
                aVar.c(str);
            }
        }
        return this.j;
    }

    private void R0(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private b S() {
        b bVar = this.h;
        if (bVar != null && !bVar.b(P())) {
            this.h = null;
        }
        if (this.h == null) {
            this.h = new b(getCallback(), this.i, (b) null, this.a.j());
        }
        return this.h;
    }

    private r4.g W() {
        Iterator it = T.iterator();
        r4.g gVar = null;
        while (it.hasNext()) {
            gVar = this.a.l((String) it.next());
            if (gVar != null) {
                break;
            }
        }
        return gVar;
    }

    private boolean j0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (((View) callback).getParent() instanceof ViewGroup) {
            return !((ViewGroup) r0).getClipChildren();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(d dVar, Object obj, c cVar, h hVar) {
        v(dVar, obj, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(ValueAnimator valueAnimator) {
        if (K()) {
            invalidateSelf();
            return;
        }
        com.airbnb.lottie.model.layer.b bVar = this.q;
        if (bVar != null) {
            bVar.M(this.b.l());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0() {
        com.airbnb.lottie.model.layer.b bVar = this.q;
        if (bVar == null) {
            return;
        }
        try {
            this.N.acquire();
            bVar.M(this.b.l());
            if (S && this.K) {
                if (this.O == null) {
                    this.O = new Handler(Looper.getMainLooper());
                    this.P = new a0(this);
                }
                this.O.post(this.P);
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            this.N.release();
            throw th;
        }
        this.N.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(h hVar) {
        H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(h hVar) {
        P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(int i, h hVar) {
        a1(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(String str, h hVar) {
        g1(str);
    }

    private boolean w() {
        return this.c || this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(int i, h hVar) {
        f1(i);
    }

    private void x() {
        h hVar = this.a;
        if (hVar == null) {
            return;
        }
        com.airbnb.lottie.model.layer.b bVar = new com.airbnb.lottie.model.layer.b(this, v.a(hVar), hVar.k(), hVar);
        this.q = bVar;
        if (this.t) {
            bVar.K(true);
        }
        this.q.S(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(float f, h hVar) {
        h1(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(String str, h hVar) {
        j1(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(String str, String str2, boolean z, h hVar) {
        k1(str, str2, z);
    }

    public Bitmap B1(String str, Bitmap bitmap) {
        b S2 = S();
        if (S2 == null) {
            f.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap e = S2.e(str, bitmap);
        invalidateSelf();
        return e;
    }

    public boolean C1() {
        return this.k == null && this.a.c().p() > 0;
    }

    public void D() {
    }

    public void F(LottieFeatureFlag lottieFeatureFlag, boolean z) {
        boolean a = this.n.a(lottieFeatureFlag, z);
        if (this.a == null || !a) {
            return;
        }
        x();
    }

    public void G() {
        this.g.clear();
        this.b.k();
        if (isVisible()) {
            return;
        }
        this.f = OnVisibleAction.NONE;
    }

    public void G0() {
        this.g.clear();
        this.b.s();
        if (isVisible()) {
            return;
        }
        this.f = OnVisibleAction.NONE;
    }

    public void H0() {
        if (this.q == null) {
            this.g.add(new h0(this));
            return;
        }
        A();
        if (w() || c0() == 0) {
            if (isVisible()) {
                this.b.t();
                this.f = OnVisibleAction.NONE;
            } else {
                this.f = OnVisibleAction.PLAY;
            }
        }
        if (w()) {
            return;
        }
        r4.g W = W();
        if (W != null) {
            a1((int) W.b);
        } else {
            a1((int) (e0() < 0.0f ? Y() : X()));
        }
        this.b.k();
        if (isVisible()) {
            return;
        }
        this.f = OnVisibleAction.NONE;
    }

    public void I0() {
        this.b.removeAllListeners();
    }

    public AsyncUpdates J() {
        AsyncUpdates asyncUpdates = this.L;
        return asyncUpdates != null ? asyncUpdates : d.d();
    }

    public void J0() {
        this.b.removeAllUpdateListeners();
        this.b.addUpdateListener(this.M);
    }

    public boolean K() {
        return J() == AsyncUpdates.ENABLED;
    }

    public void K0(Animator.AnimatorListener animatorListener) {
        this.b.removeListener(animatorListener);
    }

    public Bitmap L(String str) {
        b S2 = S();
        if (S2 != null) {
            return S2.a(str);
        }
        return null;
    }

    public void L0(Animator.AnimatorPauseListener animatorPauseListener) {
        this.b.removePauseListener(animatorPauseListener);
    }

    public boolean M() {
        return this.v;
    }

    public void M0(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.b.removeUpdateListener(animatorUpdateListener);
    }

    public boolean N() {
        return this.p;
    }

    public h O() {
        return this.a;
    }

    public List O0(d dVar) {
        if (this.q == null) {
            f.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.q.c(dVar, 0, arrayList, new d(new String[0]));
        return arrayList;
    }

    public void P0() {
        if (this.q == null) {
            this.g.add(new b0(this));
            return;
        }
        A();
        if (w() || c0() == 0) {
            if (isVisible()) {
                this.b.x();
                this.f = OnVisibleAction.NONE;
            } else {
                this.f = OnVisibleAction.RESUME;
            }
        }
        if (w()) {
            return;
        }
        a1((int) (e0() < 0.0f ? Y() : X()));
        this.b.k();
        if (isVisible()) {
            return;
        }
        this.f = OnVisibleAction.NONE;
    }

    public void Q0() {
        this.b.y();
    }

    public int R() {
        return (int) this.b.m();
    }

    public void S0(boolean z) {
        this.u = z;
    }

    public String T() {
        return this.i;
    }

    public void T0(AsyncUpdates asyncUpdates) {
        this.L = asyncUpdates;
    }

    public l0 U(String str) {
        h hVar = this.a;
        if (hVar == null) {
            return null;
        }
        return (l0) hVar.j().get(str);
    }

    public void U0(boolean z) {
        if (z != this.v) {
            this.v = z;
            invalidateSelf();
        }
    }

    public boolean V() {
        return this.o;
    }

    public void V0(boolean z) {
        if (z != this.p) {
            this.p = z;
            com.airbnb.lottie.model.layer.b bVar = this.q;
            if (bVar != null) {
                bVar.S(z);
            }
            invalidateSelf();
        }
    }

    public boolean W0(h hVar) {
        if (this.a == hVar) {
            return false;
        }
        this.K = true;
        z();
        this.a = hVar;
        x();
        this.b.z(hVar);
        r1(this.b.getAnimatedFraction());
        Iterator it = new ArrayList(this.g).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.a(hVar);
            }
            it.remove();
        }
        this.g.clear();
        hVar.v(this.s);
        A();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public float X() {
        return this.b.o();
    }

    public void X0(String str) {
        this.l = str;
        a Q = Q();
        if (Q != null) {
            Q.c(str);
        }
    }

    public float Y() {
        return this.b.p();
    }

    public void Y0(a aVar) {
        this.m = aVar;
        a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.d(aVar);
        }
    }

    public PerformanceTracker Z() {
        h hVar = this.a;
        if (hVar != null) {
            return hVar.n();
        }
        return null;
    }

    public void Z0(Map map) {
        if (map == this.k) {
            return;
        }
        this.k = map;
        invalidateSelf();
    }

    public float a0() {
        return this.b.l();
    }

    public void a1(int i) {
        if (this.a == null) {
            this.g.add(new t(this, i));
        } else {
            this.b.A(i);
        }
    }

    public RenderMode b0() {
        return this.x ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public void b1(boolean z) {
        this.d = z;
    }

    public int c0() {
        return this.b.getRepeatCount();
    }

    public void c1(b bVar) {
        b bVar2 = this.h;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    public int d0() {
        return this.b.getRepeatMode();
    }

    public void d1(String str) {
        this.i = str;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        com.airbnb.lottie.model.layer.b bVar = this.q;
        if (bVar == null) {
            return;
        }
        boolean K = K();
        if (K) {
            try {
                this.N.acquire();
            } catch (InterruptedException unused) {
                if (d.g()) {
                    d.c("Drawable#draw");
                }
                if (!K) {
                    return;
                }
                this.N.release();
                if (bVar.P() == this.b.l()) {
                    return;
                }
            } catch (Throwable th) {
                if (d.g()) {
                    d.c("Drawable#draw");
                }
                if (K) {
                    this.N.release();
                    if (bVar.P() != this.b.l()) {
                        U.execute(this.Q);
                    }
                }
                throw th;
            }
        }
        if (d.g()) {
            d.b("Drawable#draw");
        }
        if (K && A1()) {
            r1(this.b.l());
        }
        if (this.e) {
            try {
                if (this.x) {
                    N0(canvas, bVar);
                } else {
                    E(canvas);
                }
            } catch (Throwable th2) {
                f.b("Lottie crashed in draw!", th2);
            }
        } else if (this.x) {
            N0(canvas, bVar);
        } else {
            E(canvas);
        }
        this.K = false;
        if (d.g()) {
            d.c("Drawable#draw");
        }
        if (K) {
            this.N.release();
            if (bVar.P() == this.b.l()) {
                return;
            }
            U.execute(this.Q);
        }
    }

    public float e0() {
        return this.b.q();
    }

    public void e1(boolean z) {
        this.o = z;
    }

    public t0 f0() {
        return null;
    }

    public void f1(int i) {
        if (this.a == null) {
            this.g.add(new w(this, i));
        } else {
            this.b.B(i + 0.99f);
        }
    }

    public Typeface g0(r4.b bVar) {
        Map map = this.k;
        if (map != null) {
            String a = bVar.a();
            if (map.containsKey(a)) {
                return (Typeface) map.get(a);
            }
            String b = bVar.b();
            if (map.containsKey(b)) {
                return (Typeface) map.get(b);
            }
            String str = bVar.a() + "-" + bVar.c();
            if (map.containsKey(str)) {
                return (Typeface) map.get(str);
            }
        }
        a Q = Q();
        if (Q != null) {
            return Q.b(bVar);
        }
        return null;
    }

    public void g1(String str) {
        h hVar = this.a;
        if (hVar == null) {
            this.g.add(new d0(this, str));
            return;
        }
        r4.g l = hVar.l(str);
        if (l != null) {
            f1((int) (l.b + l.c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        h hVar = this.a;
        if (hVar == null) {
            return -1;
        }
        return hVar.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        h hVar = this.a;
        if (hVar == null) {
            return -1;
        }
        return hVar.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h0() {
        com.airbnb.lottie.model.layer.b bVar = this.q;
        return bVar != null && bVar.Q();
    }

    public void h1(float f) {
        h hVar = this.a;
        if (hVar == null) {
            this.g.add(new z(this, f));
        } else {
            this.b.B(k.i(hVar.p(), this.a.f(), f));
        }
    }

    public boolean i0() {
        com.airbnb.lottie.model.layer.b bVar = this.q;
        return bVar != null && bVar.R();
    }

    public void i1(int i, int i2) {
        if (this.a == null) {
            this.g.add(new v(this, i, i2));
        } else {
            this.b.C(i, i2 + 0.99f);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback;
        if (this.K) {
            return;
        }
        this.K = true;
        if ((!S || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return k0();
    }

    public void j1(String str) {
        h hVar = this.a;
        if (hVar == null) {
            this.g.add(new s(this, str));
            return;
        }
        r4.g l = hVar.l(str);
        if (l != null) {
            int i = (int) l.b;
            i1(i, ((int) l.c) + i);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public boolean k0() {
        i iVar = this.b;
        if (iVar == null) {
            return false;
        }
        return iVar.isRunning();
    }

    public void k1(String str, String str2, boolean z) {
        h hVar = this.a;
        if (hVar == null) {
            this.g.add(new c0(this, str, str2, z));
            return;
        }
        r4.g l = hVar.l(str);
        if (l == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) l.b;
        r4.g l2 = this.a.l(str2);
        if (l2 != null) {
            i1(i, (int) (l2.b + (z ? 1.0f : 0.0f)));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
    }

    boolean l0() {
        if (isVisible()) {
            return this.b.isRunning();
        }
        OnVisibleAction onVisibleAction = this.f;
        return onVisibleAction == OnVisibleAction.PLAY || onVisibleAction == OnVisibleAction.RESUME;
    }

    public void l1(float f, float f2) {
        h hVar = this.a;
        if (hVar == null) {
            this.g.add(new u(this, f, f2));
        } else {
            i1((int) k.i(hVar.p(), this.a.f(), f), (int) k.i(this.a.p(), this.a.f(), f2));
        }
    }

    public boolean m0() {
        return this.u;
    }

    public void m1(int i) {
        if (this.a == null) {
            this.g.add(new x(this, i));
        } else {
            this.b.D(i);
        }
    }

    public boolean n0(LottieFeatureFlag lottieFeatureFlag) {
        return this.n.b(lottieFeatureFlag);
    }

    public void n1(String str) {
        h hVar = this.a;
        if (hVar == null) {
            this.g.add(new e0(this, str));
            return;
        }
        r4.g l = hVar.l(str);
        if (l != null) {
            m1((int) l.b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void o1(float f) {
        h hVar = this.a;
        if (hVar == null) {
            this.g.add(new i0(this, f));
        } else {
            m1((int) k.i(hVar.p(), this.a.f(), f));
        }
    }

    public void p1(boolean z) {
        if (this.t == z) {
            return;
        }
        this.t = z;
        com.airbnb.lottie.model.layer.b bVar = this.q;
        if (bVar != null) {
            bVar.K(z);
        }
    }

    public void q1(boolean z) {
        this.s = z;
        h hVar = this.a;
        if (hVar != null) {
            hVar.v(z);
        }
    }

    public void r1(float f) {
        if (this.a == null) {
            this.g.add(new j0(this, f));
            return;
        }
        if (d.g()) {
            d.b("Drawable#setProgress");
        }
        this.b.A(this.a.h(f));
        if (d.g()) {
            d.c("Drawable#setProgress");
        }
    }

    public void s(Animator.AnimatorListener animatorListener) {
        this.b.addListener(animatorListener);
    }

    public void s1(RenderMode renderMode) {
        this.w = renderMode;
        A();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.r = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        f.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            OnVisibleAction onVisibleAction = this.f;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                H0();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                P0();
            }
        } else if (this.b.isRunning()) {
            G0();
            this.f = OnVisibleAction.RESUME;
        } else if (isVisible) {
            this.f = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        H0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        G();
    }

    public void t(Animator.AnimatorPauseListener animatorPauseListener) {
        this.b.addPauseListener(animatorPauseListener);
    }

    public void t1(int i) {
        this.b.setRepeatCount(i);
    }

    public void u(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.b.addUpdateListener(animatorUpdateListener);
    }

    public void u1(int i) {
        this.b.setRepeatMode(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void v(d dVar, Object obj, c cVar) {
        com.airbnb.lottie.model.layer.b bVar = this.q;
        if (bVar == null) {
            this.g.add(new y(this, dVar, obj, cVar));
            return;
        }
        boolean z = true;
        if (dVar == d.c) {
            bVar.d(obj, cVar);
        } else if (dVar.d() != null) {
            dVar.d().d(obj, cVar);
        } else {
            List O0 = O0(dVar);
            for (int i = 0; i < O0.size(); i++) {
                ((d) O0.get(i)).d().d(obj, cVar);
            }
            z = true ^ O0.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (obj == p0.E) {
                r1(a0());
            }
        }
    }

    public void v1(boolean z) {
        this.e = z;
    }

    public void w1(float f) {
        this.b.E(f);
    }

    public void x1(Boolean bool) {
        this.c = bool.booleanValue();
    }

    public void y() {
        this.g.clear();
        this.b.cancel();
        if (isVisible()) {
            return;
        }
        this.f = OnVisibleAction.NONE;
    }

    public void y1(t0 t0Var) {
    }

    public void z() {
        if (this.b.isRunning()) {
            this.b.cancel();
            if (!isVisible()) {
                this.f = OnVisibleAction.NONE;
            }
        }
        this.a = null;
        this.q = null;
        this.h = null;
        this.R = -3.4028235E38f;
        this.b.j();
        invalidateSelf();
    }

    public void z1(boolean z) {
        this.b.F(z);
    }
}
