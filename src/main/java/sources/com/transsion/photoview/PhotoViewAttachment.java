package com.transsion.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class PhotoViewAttachment implements View.OnTouchListener, View.OnLayoutChangeListener {
    private final ImageView h;
    private GestureDetector i;
    private com.transsion.photoview.b j;
    private n k;
    private View.OnClickListener q;
    private View.OnLongClickListener r;
    private FlingRunnable s;
    private float v;
    private final com.transsion.photoview.c y;
    private Interpolator a = new AccelerateDecelerateInterpolator();
    private int b = 200;
    private float c = 1.0f;
    private float d = 1.75f;
    private float e = 3.0f;
    private boolean f = true;
    private boolean g = false;
    private final Matrix l = new Matrix();
    private final Matrix m = new Matrix();
    private final Matrix n = new Matrix();
    private final RectF o = new RectF();
    private final float[] p = new float[9];
    private int t = 2;
    private int u = 2;
    private boolean w = true;
    private ImageView.ScaleType x = ImageView.ScaleType.FIT_CENTER;

    private class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.mFocalX = f3;
            this.mFocalY = f4;
            this.mZoomStart = f;
            this.mZoomEnd = f2;
        }

        private float interpolate() {
            return PhotoViewAttachment.this.a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.mStartTime) * 1.0f) / PhotoViewAttachment.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float interpolate = interpolate();
            float f = this.mZoomStart;
            PhotoViewAttachment.this.y.d((f + ((this.mZoomEnd - f) * interpolate)) / PhotoViewAttachment.this.M(), this.mFocalX, this.mFocalY);
            if (interpolate < 1.0f) {
                com.transsion.photoview.a.a(PhotoViewAttachment.this.h, this);
            }
        }
    }

    private class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF D = PhotoViewAttachment.this.D();
            if (D == null) {
                return;
            }
            int round = Math.round(-D.left);
            float f = i;
            if (f < D.width()) {
                i6 = Math.round(D.width() - f);
                i5 = 0;
            } else {
                i5 = round;
                i6 = i5;
            }
            int round2 = Math.round(-D.top);
            float f2 = i2;
            if (f2 < D.height()) {
                i8 = Math.round(D.height() - f2);
                i7 = 0;
            } else {
                i7 = round2;
                i8 = i7;
            }
            this.mCurrentX = round;
            this.mCurrentY = round2;
            if (round == i6 && round2 == i8) {
                return;
            }
            this.mScroller.fling(round, round2, i3, i4, i5, i6, i7, i8, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttachment.this.n.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                PhotoViewAttachment.this.A();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                com.transsion.photoview.a.a(PhotoViewAttachment.this.h, this);
            }
        }
    }

    class a implements com.transsion.photoview.c {
        a() {
        }

        @Override // com.transsion.photoview.c
        public void b(float f, float f2) {
            if (PhotoViewAttachment.this.j.g()) {
                return;
            }
            PhotoViewAttachment.j(PhotoViewAttachment.this);
            PhotoViewAttachment.this.n.postTranslate(f, f2);
            PhotoViewAttachment.this.A();
            ViewParent parent = PhotoViewAttachment.this.h.getParent();
            if (!PhotoViewAttachment.this.f || PhotoViewAttachment.this.j.g() || PhotoViewAttachment.this.g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((PhotoViewAttachment.this.t == 2 || ((PhotoViewAttachment.this.t == 0 && f >= 1.0f) || ((PhotoViewAttachment.this.t == 1 && f <= -1.0f) || ((PhotoViewAttachment.this.u == 0 && f2 >= 1.0f) || (PhotoViewAttachment.this.u == 1 && f2 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
                PhotoViewAttachment.this.k.e(PhotoViewAttachment.this.M(), PhotoViewAttachment.this.j.d(), PhotoViewAttachment.this.j.e());
            }
        }

        @Override // com.transsion.photoview.c
        public void c(float f, float f2, float f3, float f4, float f5) {
            if (PhotoViewAttachment.this.k.h()) {
                return;
            }
            if (PhotoViewAttachment.this.M() < PhotoViewAttachment.this.e || f < 1.0f) {
                PhotoViewAttachment.m(PhotoViewAttachment.this);
                PhotoViewAttachment.this.n.postScale(f, f, f2, f3);
                PhotoViewAttachment.this.n.postTranslate(f4, f5);
                PhotoViewAttachment.this.A();
            }
        }

        @Override // com.transsion.photoview.c
        public void d(float f, float f2, float f3) {
            c(f, f2, f3, 0.0f, 0.0f);
        }

        @Override // com.transsion.photoview.c
        public void e(float f, float f2, float f3, float f4) {
            PhotoViewAttachment photoViewAttachment = PhotoViewAttachment.this;
            photoViewAttachment.s = photoViewAttachment.new FlingRunnable(photoViewAttachment.h.getContext());
            FlingRunnable flingRunnable = PhotoViewAttachment.this.s;
            PhotoViewAttachment photoViewAttachment2 = PhotoViewAttachment.this;
            int I = photoViewAttachment2.I(photoViewAttachment2.h);
            PhotoViewAttachment photoViewAttachment3 = PhotoViewAttachment.this;
            flingRunnable.fling(I, photoViewAttachment3.H(photoViewAttachment3.h), (int) f3, (int) f4);
            PhotoViewAttachment.this.h.post(PhotoViewAttachment.this.s);
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            PhotoViewAttachment.o(PhotoViewAttachment.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoViewAttachment.this.r != null) {
                PhotoViewAttachment.this.r.onLongClick(PhotoViewAttachment.this.h);
            }
        }
    }

    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float M = PhotoViewAttachment.this.M();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (M < PhotoViewAttachment.this.K()) {
                    PhotoViewAttachment photoViewAttachment = PhotoViewAttachment.this;
                    photoViewAttachment.m0(photoViewAttachment.K(), x, y, true);
                } else if (M < PhotoViewAttachment.this.K() || M >= PhotoViewAttachment.this.J()) {
                    PhotoViewAttachment photoViewAttachment2 = PhotoViewAttachment.this;
                    photoViewAttachment2.m0(photoViewAttachment2.L(), x, y, true);
                } else {
                    PhotoViewAttachment photoViewAttachment3 = PhotoViewAttachment.this;
                    photoViewAttachment3.m0(photoViewAttachment3.J(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (PhotoViewAttachment.this.q != null) {
                PhotoViewAttachment.this.q.onClick(PhotoViewAttachment.this.h);
            }
            RectF D = PhotoViewAttachment.this.D();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            PhotoViewAttachment.r(PhotoViewAttachment.this);
            if (D == null) {
                return false;
            }
            if (!D.contains(x, y)) {
                PhotoViewAttachment.k(PhotoViewAttachment.this);
                return false;
            }
            D.width();
            D.height();
            PhotoViewAttachment.l(PhotoViewAttachment.this);
            return true;
        }
    }

    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public PhotoViewAttachment(ImageView imageView) {
        a aVar = new a();
        this.y = aVar;
        this.h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.v = 0.0f;
        this.j = new com.transsion.photoview.b(imageView.getContext(), aVar);
        Q(imageView);
        this.k = new n(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (B()) {
            V(F());
        }
    }

    private boolean B() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        RectF E = E(F());
        if (E == null) {
            return false;
        }
        float height = E.height();
        float width = E.width();
        float H = H(this.h);
        float f6 = 0.0f;
        if (height <= H) {
            int i = d.a[this.x.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f4 = (H - height) / 2.0f;
                    f5 = E.top;
                } else {
                    f4 = H - height;
                    f5 = E.top;
                }
                f = f4 - f5;
            } else {
                f = -E.top;
            }
            this.u = 2;
        } else {
            float f7 = E.top;
            if (f7 > 0.0f) {
                this.u = 0;
                f = -f7;
            } else {
                float f8 = E.bottom;
                if (f8 < H) {
                    this.u = 1;
                    f = H - f8;
                } else {
                    this.u = -1;
                    f = 0.0f;
                }
            }
        }
        float I = I(this.h);
        if (width <= I) {
            int i2 = d.a[this.x.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f2 = (I - width) / 2.0f;
                    f3 = E.left;
                } else {
                    f2 = I - width;
                    f3 = E.left;
                }
                f6 = f2 - f3;
            } else {
                f6 = -E.left;
            }
            this.t = 2;
        } else {
            float f9 = E.left;
            if (f9 > 0.0f) {
                this.t = 0;
                f6 = -f9;
            } else {
                float f10 = E.right;
                if (f10 < I) {
                    f6 = I - f10;
                    this.t = 1;
                } else {
                    this.t = -1;
                }
            }
        }
        this.n.postTranslate(f6, f);
        return true;
    }

    private RectF E(Matrix matrix) {
        if (this.h.getDrawable() == null) {
            return null;
        }
        this.o.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.o);
        return this.o;
    }

    private Matrix F() {
        this.m.set(this.l);
        this.m.postConcat(this.n);
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingStart()) - imageView.getPaddingEnd();
    }

    private float P(Matrix matrix, int i) {
        matrix.getValues(this.p);
        return this.p[i];
    }

    private void Q(ImageView imageView) {
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private void S() {
        this.n.reset();
        j0(this.v);
        V(F());
        B();
    }

    private void V(Matrix matrix) {
        this.h.setImageMatrix(matrix);
    }

    static /* bridge */ /* synthetic */ j j(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ e k(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ f l(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ g m(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ h o(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ k r(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    private void u0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float I = I(this.h);
        float H = H(this.h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.l.reset();
        float f = intrinsicWidth;
        float f2 = I / f;
        float f3 = intrinsicHeight;
        float f4 = H / f3;
        ImageView.ScaleType scaleType = this.x;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.l.postTranslate((I - f) / 2.0f, (H - f3) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f2, f4);
            this.l.postScale(max, max);
            this.l.postTranslate((I - (f * max)) / 2.0f, (H - (f3 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f2, f4));
            this.l.postScale(min, min);
            this.l.postTranslate((I - (f * min)) / 2.0f, (H - (f3 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f, f3);
            RectF rectF2 = new RectF(0.0f, 0.0f, I, H);
            if (((int) this.v) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f3, f);
            }
            int i = d.a[this.x.ordinal()];
            if (i == 1) {
                this.l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        S();
    }

    private void z() {
        FlingRunnable flingRunnable = this.s;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.s = null;
        }
    }

    public void C(Matrix matrix) {
        matrix.set(F());
    }

    public RectF D() {
        B();
        return E(F());
    }

    public Matrix G() {
        return this.m;
    }

    public float J() {
        return this.e;
    }

    public float K() {
        return this.d;
    }

    public float L() {
        return this.c;
    }

    public float M() {
        return (float) Math.sqrt(((float) Math.pow(P(this.n, 0), 2.0d)) + ((float) Math.pow(P(this.n, 3), 2.0d)));
    }

    public ImageView.ScaleType N() {
        return this.x;
    }

    public void O(Matrix matrix) {
        matrix.set(this.n);
    }

    public boolean R() {
        return this.w;
    }

    public void T(boolean z) {
        this.f = z;
    }

    public boolean U(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.h.getDrawable() == null) {
            return false;
        }
        this.n.set(matrix);
        A();
        return true;
    }

    public void W(float f) {
        o.a(this.c, this.d, f);
        this.e = f;
    }

    public void X(float f) {
        o.a(this.c, f, this.e);
        this.d = f;
    }

    public void Y(float f) {
        o.a(f, this.d, this.e);
        this.c = f;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void a0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void b0(View.OnLongClickListener onLongClickListener) {
        this.r = onLongClickListener;
    }

    public void c0(com.transsion.photoview.d dVar) {
    }

    public void d0(e eVar) {
    }

    public void e0(f fVar) {
    }

    public void f0(g gVar) {
    }

    public void g0(h hVar) {
    }

    public void h0(j jVar) {
    }

    public void i0(k kVar) {
    }

    public void j0(float f) {
        this.n.postRotate(f % 360.0f);
        A();
    }

    public void k0(float f) {
        this.n.setRotate(f % 360.0f);
        A();
    }

    public void l0(float f) {
        n0(f, false);
    }

    public void m0(float f, float f2, float f3, boolean z) {
        if (f < this.c || f > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.h.post(new AnimatedZoomRunnable(M(), f, f2, f3));
        } else {
            this.n.setScale(f, f, f2, f3);
            A();
        }
    }

    public void n0(float f, boolean z) {
        m0(f, this.h.getRight() / 2.0f, this.h.getBottom() / 2.0f, z);
    }

    public void o0(float f, float f2, float f3) {
        o.a(f, f2, f3);
        this.c = f;
        this.d = f2;
        this.e = f3;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        u0(this.h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.transsion.photoview.b bVar;
        boolean z2;
        GestureDetector gestureDetector;
        RectF D;
        boolean z3 = false;
        if (!this.w || !o.d((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            z();
        } else if (action == 1 || action == 3) {
            if (M() < this.c) {
                RectF D2 = D();
                if (D2 != null) {
                    view.post(new AnimatedZoomRunnable(M(), this.c, D2.centerX(), D2.centerY()));
                    z = true;
                }
                z = false;
            } else {
                if (M() > this.e && (D = D()) != null) {
                    view.post(new AnimatedZoomRunnable(M(), this.e, D.centerX(), D.centerY()));
                    z = true;
                }
                z = false;
            }
            this.k.d();
            bVar = this.j;
            if (bVar == null) {
                boolean g = bVar.g();
                boolean f = this.j.f();
                boolean h = this.j.h(motionEvent);
                boolean z4 = (g || this.j.g()) ? false : true;
                boolean z5 = (f || this.j.f()) ? false : true;
                if (z4 && z5) {
                    z3 = true;
                }
                this.g = z3;
                z2 = h;
            } else {
                z2 = z;
            }
            gestureDetector = this.i;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        z = false;
        bVar = this.j;
        if (bVar == null) {
        }
        gestureDetector = this.i;
        return gestureDetector == null ? z2 : z2;
    }

    public void p0(ImageView.ScaleType scaleType) {
        if (!o.e(scaleType) || scaleType == this.x) {
            return;
        }
        this.x = scaleType;
        t0();
    }

    public void q0(i iVar) {
        n nVar = this.k;
        if (nVar != null) {
            nVar.k(iVar);
        }
    }

    public void r0(int i) {
        this.b = i;
    }

    public void s0(boolean z) {
        this.w = z;
        t0();
    }

    public void t0() {
        if (this.w) {
            u0(this.h.getDrawable());
        } else {
            S();
        }
    }
}
