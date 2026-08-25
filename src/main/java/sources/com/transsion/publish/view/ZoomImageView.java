package com.transsion.publish.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ZoomImageView extends AppCompatImageView implements ViewTreeObserver.OnGlobalLayoutListener {
    private boolean d;
    private float e;
    private float f;
    private float g;
    private Matrix h;
    private ScaleGestureDetector i;
    private GestureDetector j;
    private boolean k;
    private ValueAnimator l;
    private OverScroller m;
    private int n;
    private int o;
    private ValueAnimator p;
    private View.OnClickListener q;

    class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            ZoomImageView.this.scale(scaleGestureDetector);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            ZoomImageView.this.scaleEnd(scaleGestureDetector);
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {

        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ZoomImageView.this.m.computeScrollOffset()) {
                    int currX = ZoomImageView.this.m.getCurrX();
                    int i = currX - ZoomImageView.this.n;
                    ZoomImageView.this.n = currX;
                    int currY = ZoomImageView.this.m.getCurrY();
                    int i2 = currY - ZoomImageView.this.o;
                    ZoomImageView.this.o = currY;
                    if (i == 0 || i2 == 0) {
                        return;
                    }
                    ZoomImageView.this.p(i, i2);
                }
            }
        }

        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            ZoomImageView.this.o(motionEvent.getX(), motionEvent.getY());
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            ZoomImageView.this.n = (int) motionEvent2.getX();
            ZoomImageView.this.o = (int) motionEvent2.getY();
            RectF matrixRectF = ZoomImageView.this.getMatrixRectF();
            if (matrixRectF == null) {
                return false;
            }
            int i = ZoomImageView.this.n;
            int i2 = ZoomImageView.this.o;
            int round = Math.round(f);
            int round2 = Math.round(f2);
            int round3 = Math.round(matrixRectF.width());
            int round4 = Math.round(matrixRectF.height());
            if (i != round3 || i2 != round4) {
                ZoomImageView.this.m.fling(i, i2, round, round2, 0, round3, 0, round4, round3, round4);
            }
            if (ZoomImageView.this.p != null && ZoomImageView.this.p.isStarted()) {
                ZoomImageView.this.p.end();
            }
            ZoomImageView.this.p = ValueAnimator.ofFloat(0.0f, 1.0f);
            ZoomImageView.this.p.setDuration(500L);
            ZoomImageView.this.p.addUpdateListener(new a());
            ZoomImageView.this.p.start();
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            ZoomImageView.this.p(-f, -f2);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ZoomImageView.this.q == null) {
                return true;
            }
            ZoomImageView.this.q.onClick(ZoomImageView.this);
            return true;
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float a;
        final /* synthetic */ float b;

        c(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        /* JADX WARN: Type inference failed for: r4v5, types: [android.widget.ImageView, com.transsion.publish.view.ZoomImageView] */
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() / ZoomImageView.this.getScale();
            ZoomImageView.this.h.postScale(floatValue, floatValue, this.a, this.b);
            ?? r4 = ZoomImageView.this;
            r4.setImageMatrix(((ZoomImageView) r4).h);
            ZoomImageView.this.q();
        }
    }

    public ZoomImageView(Context context) {
        this(context, null);
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ZoomImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.k = false;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.m = new OverScroller(context);
        this.h = new Matrix();
        this.i = new ScaleGestureDetector(context, new a());
        this.j = new GestureDetector(context, new b());
    }

    private float getDoubleDrowScale() {
        float scale = getScale();
        if (Math.abs(this.e - scale) < 0.05f) {
            scale = this.e;
        }
        if (Math.abs(this.g - scale) < 0.05f) {
            scale = this.g;
        }
        if (Math.abs(this.f - scale) < 0.05f) {
            scale = this.f;
        }
        float f = this.g;
        if (scale == f) {
            return this.k ? this.f : this.e;
        }
        this.k = scale < f;
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public RectF getMatrixRectF() {
        if (getDrawable() == null) {
            return null;
        }
        RectF rectF = new RectF(0.0f, 0.0f, r0.getMinimumWidth(), r0.getMinimumHeight());
        getImageMatrix().mapRect(rectF);
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getScale() {
        float[] fArr = new float[9];
        this.h.getValues(fArr);
        return fArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(float f, float f2) {
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            r(getDoubleDrowScale(), f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void p(float f, float f2) {
        if (getDrawable() == null) {
            return;
        }
        RectF matrixRectF = getMatrixRectF();
        if (matrixRectF.width() <= getWidth()) {
            f = 0.0f;
        }
        if (matrixRectF.height() <= getHeight()) {
            f2 = 0.0f;
        }
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.h.postTranslate(f, f2);
        setImageMatrix(this.h);
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void q() {
        float f;
        float f2;
        RectF matrixRectF = getMatrixRectF();
        if (matrixRectF == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float width2 = matrixRectF.width();
        float height2 = matrixRectF.height();
        float f3 = matrixRectF.left;
        float f4 = matrixRectF.right;
        float f5 = matrixRectF.top;
        float f6 = matrixRectF.bottom;
        float f7 = 0.0f;
        if (f3 > 0.0f) {
            f = width;
            if (width2 > f) {
                f2 = -f3;
            }
            f2 = ((f * 1.0f) / 2.0f) - (((width2 * 1.0f) / 2.0f) + f3);
        } else {
            f = width;
            if (f4 < f) {
                if (width2 > f) {
                    f2 = f - f4;
                }
                f2 = ((f * 1.0f) / 2.0f) - (((width2 * 1.0f) / 2.0f) + f3);
            } else {
                f2 = 0.0f;
            }
        }
        if (f5 > 0.0f) {
            float f8 = height;
            f7 = height2 > f8 ? -f5 : ((f8 * 1.0f) / 2.0f) - (f5 + ((height2 * 1.0f) / 2.0f));
        } else {
            float f9 = height;
            if (f6 < f9) {
                f7 = height2 > f9 ? f9 - f6 : ((f9 * 1.0f) / 2.0f) - (f5 + ((height2 * 1.0f) / 2.0f));
            }
        }
        this.h.postTranslate(f2, f7);
        setImageMatrix(this.h);
    }

    private void r(float f, float f2, float f3) {
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(getScale(), f);
            this.l = ofFloat;
            ofFloat.setDuration(300L);
            this.l.setInterpolator(new AccelerateInterpolator());
            this.l.addUpdateListener(new c(f2, f3));
            this.l.start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean canScrollHorizontally(int i) {
        RectF matrixRectF = getMatrixRectF();
        if (matrixRectF == null || matrixRectF.isEmpty()) {
            return false;
        }
        return i > 0 ? matrixRectF.right >= ((float) (getWidth() + 1)) : matrixRectF.left <= -1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean canScrollVertically(int i) {
        RectF matrixRectF = getMatrixRectF();
        if (matrixRectF == null || matrixRectF.isEmpty()) {
            return false;
        }
        return i > 0 ? matrixRectF.bottom >= ((float) (getHeight() + 1)) : matrixRectF.top <= -1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.widget.ImageView*/.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.widget.ImageView*/.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.d) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float f = (intrinsicWidth <= width || intrinsicHeight > height) ? 1.0f : (width * 1.0f) / intrinsicWidth;
            if (intrinsicWidth <= width && intrinsicHeight > height) {
                f = (height * 1.0f) / intrinsicHeight;
            }
            if ((intrinsicWidth <= width && intrinsicHeight <= height) || (intrinsicWidth >= width && intrinsicHeight >= height)) {
                f = Math.min((width * 1.0f) / intrinsicWidth, (height * 1.0f) / intrinsicHeight);
            }
            this.e = f;
            this.g = f * 2.0f;
            this.f = f * 4.0f;
            float f2 = (width * 1.0f) / 2.0f;
            float f3 = (height * 1.0f) / 2.0f;
            this.h.postTranslate(f2 - (intrinsicWidth / 2), f3 - (intrinsicHeight / 2));
            Matrix matrix = this.h;
            float f4 = this.e;
            matrix.postScale(f4, f4, f2, f3);
            setImageMatrix(this.h);
            this.d = false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.j.onTouchEvent(motionEvent) | this.i.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void scale(ScaleGestureDetector scaleGestureDetector) {
        if (getDrawable() == null) {
            return;
        }
        getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        this.h.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        setImageMatrix(this.h);
        q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void scaleEnd(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor() * getScale();
        float f = this.e;
        if (scaleFactor < f) {
            r(f, getWidth() / 2, getHeight() / 2);
            return;
        }
        float f2 = this.f;
        if (scaleFactor > f2) {
            r(f2, getWidth() / 2, getHeight() / 2);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }
}
