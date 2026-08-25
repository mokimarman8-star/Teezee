package com.transsion.publish.view.clip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ClipImageView extends BaseClipImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static float SCALE_MAX = 4.0f;
    private static float t = 2.0f;
    private float d;
    private boolean e;
    private final float[] f;
    private ScaleGestureDetector g;
    private final Matrix h;
    private GestureDetector i;
    private boolean j;
    private int k;
    private float l;
    private float m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;

    private class AutoScaleRunnable implements Runnable {
        static final float BIGGER = 1.07f;
        static final float SMALLER = 0.93f;
        private float mTargetScale;
        private float tmpScale;
        private float x;
        private float y;

        public AutoScaleRunnable(float f, float f2, float f3) {
            this.mTargetScale = f;
            this.x = f2;
            this.y = f3;
            if (ClipImageView.this.getScale() < this.mTargetScale) {
                this.tmpScale = BIGGER;
            } else {
                this.tmpScale = SMALLER;
            }
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.ImageView, com.transsion.publish.view.clip.ClipImageView] */
        /* JADX WARN: Type inference failed for: r0v9, types: [android.widget.ImageView, com.transsion.publish.view.clip.ClipImageView] */
        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = ClipImageView.this.h;
            float f = this.tmpScale;
            matrix.postScale(f, f, this.x, this.y);
            ClipImageView.this.g();
            ?? r0 = ClipImageView.this;
            r0.setImageMatrix(((ClipImageView) r0).h);
            float scale = ClipImageView.this.getScale();
            float f2 = this.tmpScale;
            if ((f2 > 1.0f && scale < this.mTargetScale) || (f2 < 1.0f && this.mTargetScale < scale)) {
                ClipImageView.this.postDelayed(this, 16L);
                return;
            }
            float f3 = this.mTargetScale / scale;
            ClipImageView.this.h.postScale(f3, f3, this.x, this.y);
            ClipImageView.this.g();
            ?? r02 = ClipImageView.this;
            r02.setImageMatrix(((ClipImageView) r02).h);
            ClipImageView.this.j = false;
        }
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, com.transsion.publish.view.clip.ClipImageView] */
        /* JADX WARN: Type inference failed for: r2v4, types: [android.view.View, com.transsion.publish.view.clip.ClipImageView] */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (ClipImageView.this.j) {
                return true;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (ClipImageView.this.getScale() < ClipImageView.t) {
                ?? r2 = ClipImageView.this;
                r2.postDelayed(new AutoScaleRunnable(ClipImageView.t, x, y), 16L);
                ClipImageView.this.j = true;
            } else {
                ?? r22 = ClipImageView.this;
                r22.postDelayed(new AutoScaleRunnable(((ClipImageView) r22).d, x, y), 16L);
                ClipImageView.this.j = true;
            }
            return true;
        }
    }

    public ClipImageView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1.0f;
        this.e = true;
        this.f = new float[9];
        this.g = null;
        this.h = new Matrix();
        this.p = 16;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.i = new GestureDetector(context, new a());
        this.g = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void g() {
        float f;
        RectF matrixRectF = getMatrixRectF();
        int width = getWidth();
        int height = getHeight();
        double width2 = matrixRectF.width() + 0.01d;
        int i = this.p;
        if (width2 >= width - (i * 2)) {
            float f2 = matrixRectF.left;
            f = f2 > ((float) i) ? (-f2) + i : 0.0f;
            float f3 = matrixRectF.right;
            if (f3 < width - i) {
                f = (width - i) - f3;
            }
        } else {
            f = 0.0f;
        }
        double height2 = matrixRectF.height() + 0.01d;
        int i2 = this.s;
        if (height2 >= height - (i2 * 2)) {
            float f4 = matrixRectF.top;
            r4 = f4 > ((float) i2) ? (-f4) + i2 : 0.0f;
            float f5 = matrixRectF.bottom;
            if (f5 < height - i2) {
                r4 = (height - i2) - f5;
            }
        }
        this.h.postTranslate(f, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RectF getMatrixRectF() {
        Matrix matrix = this.h;
        RectF rectF = new RectF();
        if (getDrawable() != null) {
            rectF.set(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    private boolean h(float f, float f2) {
        return Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.k);
    }

    public Bitmap clip() {
        return clip(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bitmap clip(Rect rect) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        return rect == null ? Bitmap.createBitmap(createBitmap, this.p, this.s, getWidth() - (this.p * 2), getWidth() - (this.p * 2)) : (rect.width() <= 0 || rect.height() <= 0) ? createBitmap : Bitmap.createBitmap(createBitmap, rect.left, rect.top, rect.width(), rect.height());
    }

    public final float getScale() {
        this.h.getValues(this.f);
        return this.f[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.widget.ImageView*/.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.widget.ImageView*/.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        if (!this.e || (drawable = getDrawable()) == null) {
            return;
        }
        if (this.q == 0) {
            this.s = (getHeight() - (getWidth() - (this.p * 2))) / 2;
        } else {
            this.p = (getWidth() - this.q) / 2;
            this.s = (getHeight() - this.r) / 2;
        }
        float width = getWidth();
        float height = getHeight();
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float max = Math.max((getWidth() - (this.p * 2)) / intrinsicWidth, (getHeight() - (this.s * 2)) / intrinsicHeight);
        this.d = max;
        t = max * 2.0f;
        SCALE_MAX = 4.0f * max;
        this.h.postTranslate((width - intrinsicWidth) / 2.0f, (height - intrinsicHeight) / 2.0f);
        this.h.postScale(max, max, getWidth() / 2, getHeight() / 2);
        setImageMatrix(this.h);
        this.e = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() == null) {
            return true;
        }
        float f = SCALE_MAX;
        if ((scale < f && scaleFactor > 1.0f) || (scale > this.d && scaleFactor < 1.0f)) {
            float f2 = scaleFactor * scale;
            float f3 = this.d;
            if (f2 < f3) {
                scaleFactor = f3 / scale;
            }
            if (scaleFactor * scale > f) {
                scaleFactor = f / scale;
            }
            this.h.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            g();
            setImageMatrix(this.h);
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        if (r10 != 3) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.i.onTouchEvent(motionEvent)) {
            return true;
        }
        this.g.onTouchEvent(motionEvent);
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            f += motionEvent.getX(i);
            f2 += motionEvent.getY(i);
        }
        float f3 = pointerCount;
        float f4 = f / f3;
        float f5 = f2 / f3;
        if (pointerCount != this.o) {
            this.n = false;
            this.l = f4;
            this.m = f5;
        }
        this.o = pointerCount;
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float f6 = f4 - this.l;
                float f7 = f5 - this.m;
                if (!this.n) {
                    this.n = h(f6, f7);
                }
                if (this.n && getDrawable() != null) {
                    RectF matrixRectF = getMatrixRectF();
                    if (matrixRectF.width() <= getWidth() - (this.p * 2)) {
                        f6 = 0.0f;
                    }
                    this.h.postTranslate(f6, matrixRectF.height() > ((float) (getHeight() - (this.s * 2))) ? f7 : 0.0f);
                    g();
                    setImageMatrix(this.h);
                }
                this.l = f4;
                this.m = f5;
            }
            return true;
        }
        this.o = 0;
        return true;
    }

    public void setCropWH(int i, int i2) {
        this.q = i;
        this.r = i2;
    }
}
