package com.cloud.tmc.miniapp.widget.photoview;

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

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooOOOO implements View.OnTouchListener, View.OnLayoutChangeListener {
    public final ImageView OooO;
    public GestureDetector OooOO0;
    public com.cloud.tmc.miniapp.widget.photoview.OooO00o OooOO0O;
    public com.cloud.tmc.miniapp.widget.photoview.OooO OooOOo;
    public com.cloud.tmc.miniapp.widget.photoview.OooO0OO OooOOo0;
    public com.cloud.tmc.miniapp.widget.photoview.OooO0o OooOOoo;
    public OooOO0O OooOo;
    public View.OnClickListener OooOo0;
    public OooOOO OooOo00;
    public View.OnLongClickListener OooOo0O;
    public com.cloud.tmc.miniapp.widget.photoview.OooOO0 OooOo0o;
    public OooOO0 OooOoO;
    public OooOOO0 OooOoO0;
    public Interpolator OooO00o = new AccelerateDecelerateInterpolator();
    public int OooO0O0 = 200;
    public float OooO0OO = 1.0f;
    public float OooO0Oo = 1.75f;
    public float OooO0o0 = 3.0f;
    public boolean OooO0o = true;
    public boolean OooO0oO = false;
    public boolean OooO0oo = false;
    public final Matrix OooOO0o = new Matrix();
    public final Matrix OooOOO0 = new Matrix();
    public final Matrix OooOOO = new Matrix();
    public final RectF OooOOOO = new RectF();
    public final float[] OooOOOo = new float[9];
    public int OooOoOO = 2;
    public int OooOoo0 = 2;
    public boolean OooOoo = true;
    public ImageView.ScaleType OooOooO = ImageView.ScaleType.FIT_CENTER;
    public com.cloud.tmc.miniapp.widget.photoview.OooO0O0 OooOooo = new OooO00o();

    public class OooO implements Runnable {
        public final float OooO00o;
        public final float OooO0O0;
        public final long OooO0OO = System.currentTimeMillis();
        public final float OooO0Oo;
        public final float OooO0o0;

        public OooO(float f, float f2, float f3, float f4) {
            this.OooO00o = f3;
            this.OooO0O0 = f4;
            this.OooO0Oo = f;
            this.OooO0o0 = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            float interpolation = OooOOOO.this.OooO00o.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.OooO0OO) * 1.0f) / OooOOOO.this.OooO0O0));
            float f = this.OooO0Oo;
            ((OooO00o) OooOOOO.this.OooOooo).OooO00o((((this.OooO0o0 - f) * interpolation) + f) / OooOOOO.this.OooO0o0(), this.OooO00o, this.OooO0O0, 0.0f, 0.0f);
            if (interpolation < 1.0f) {
                OooOOOO.this.OooO.postOnAnimation(this);
            }
        }
    }

    public class OooO00o implements com.cloud.tmc.miniapp.widget.photoview.OooO0O0 {
        public OooO00o() {
        }

        public void OooO00o(float f, float f2, float f3, float f4, float f5) {
            float OooO0o0 = OooOOOO.this.OooO0o0();
            OooOOOO oooOOOO = OooOOOO.this;
            if (OooO0o0 < oooOOOO.OooO0o0 || f < 1.0f) {
                com.cloud.tmc.miniapp.widget.photoview.OooOO0 oooOO0 = oooOOOO.OooOo0o;
                if (oooOO0 != null) {
                    oooOO0.OooO00o(f, f2, f3);
                }
                OooOOOO.this.OooOOO.postScale(f, f, f2, f3);
                OooOOOO.this.OooOOO.postTranslate(f4, f5);
                OooOOOO.this.OooO00o();
            }
        }
    }

    public class OooO0O0 extends GestureDetector.SimpleOnGestureListener {
        public OooO0O0() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            OooOOOO oooOOOO = OooOOOO.this;
            if (oooOOOO.OooOo == null || oooOOOO.OooO0o0() > 1.0f || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            return OooOOOO.this.OooOo.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            OooOOOO oooOOOO = OooOOOO.this;
            View.OnLongClickListener onLongClickListener = oooOOOO.OooOo0O;
            if (onLongClickListener != null) {
                onLongClickListener.onLongClick(oooOOOO.OooO);
            }
        }
    }

    public class OooO0OO implements GestureDetector.OnDoubleTapListener {
        public OooO0OO() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float OooO0o0 = OooOOOO.this.OooO0o0();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                OooOOOO oooOOOO = OooOOOO.this;
                float f = oooOOOO.OooO0Oo;
                if (OooO0o0 < f) {
                    oooOOOO.OooO00o(f, x, y, true);
                } else {
                    if (OooO0o0 >= f) {
                        float f2 = oooOOOO.OooO0o0;
                        if (OooO0o0 < f2) {
                            oooOOOO.OooO00o(f2, x, y, true);
                        }
                    }
                    oooOOOO.OooO00o(oooOOOO.OooO0OO, x, y, true);
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
            OooOOOO oooOOOO = OooOOOO.this;
            View.OnClickListener onClickListener = oooOOOO.OooOo0;
            if (onClickListener != null) {
                onClickListener.onClick(oooOOOO.OooO);
            }
            RectF OooO0OO = OooOOOO.this.OooO0OO();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            OooOOOO oooOOOO2 = OooOOOO.this;
            OooOOO oooOOO = oooOOOO2.OooOo00;
            if (oooOOO != null) {
                oooOOO.OooO00o(oooOOOO2.OooO, x, y);
            }
            if (OooO0OO == null) {
                return false;
            }
            if (!OooO0OO.contains(x, y)) {
                OooOOOO oooOOOO3 = OooOOOO.this;
                com.cloud.tmc.miniapp.widget.photoview.OooO0o oooO0o = oooOOOO3.OooOOoo;
                if (oooO0o == null) {
                    return false;
                }
                oooO0o.OooO00o(oooOOOO3.OooO);
                return false;
            }
            float width = (x - OooO0OO.left) / OooO0OO.width();
            float height = (y - OooO0OO.top) / OooO0OO.height();
            OooOOOO oooOOOO4 = OooOOOO.this;
            com.cloud.tmc.miniapp.widget.photoview.OooO oooO = oooOOOO4.OooOOo;
            if (oooO == null) {
                return true;
            }
            oooO.OooO00o(oooOOOO4.OooO, width, height);
            return true;
        }
    }

    public static /* synthetic */ class OooO0o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            OooO00o = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OooO00o[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                OooO00o[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                OooO00o[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class OooOO0 implements Runnable {
        public final OverScroller OooO00o;
        public int OooO0O0;
        public int OooO0OO;

        public OooOO0(Context context) {
            this.OooO00o = new OverScroller(context);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.OooO00o.isFinished() && this.OooO00o.computeScrollOffset()) {
                int currX = this.OooO00o.getCurrX();
                int currY = this.OooO00o.getCurrY();
                OooOOOO.this.OooOOO.postTranslate(this.OooO0O0 - currX, this.OooO0OO - currY);
                OooOOOO.this.OooO00o();
                this.OooO0O0 = currX;
                this.OooO0OO = currY;
                OooOOOO.this.OooO.postOnAnimation(this);
            }
        }
    }

    public OooOOOO(ImageView imageView) {
        this.OooO = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.OooOO0O = new com.cloud.tmc.miniapp.widget.photoview.OooO00o(imageView.getContext(), this.OooOooo);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new OooO0O0());
        this.OooOO0 = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new OooO0OO());
    }

    public final int OooO00o(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final RectF OooO00o(Matrix matrix) {
        if (this.OooO.getDrawable() == null) {
            return null;
        }
        this.OooOOOO.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.OooOOOO);
        return this.OooOOOO;
    }

    public final void OooO00o() {
        RectF OooO00o2;
        if (OooO0O0()) {
            Matrix OooO0Oo = OooO0Oo();
            this.OooO.setImageMatrix(OooO0Oo);
            if (this.OooOOo0 == null || (OooO00o2 = OooO00o(OooO0Oo)) == null) {
                return;
            }
            this.OooOOo0.OooO00o(OooO00o2);
        }
    }

    public void OooO00o(float f, float f2, float f3, boolean z) {
        if (f < this.OooO0OO || f > this.OooO0o0) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.OooO.post(new OooO(OooO0o0(), f, f2, f3));
        } else {
            this.OooOOO.setScale(f, f, f2, f3);
            OooO00o();
        }
    }

    public final void OooO00o(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float OooO0O02 = OooO0O0(this.OooO);
        float OooO00o2 = OooO00o(this.OooO);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.OooOO0o.reset();
        float f = intrinsicWidth;
        float f2 = OooO0O02 / f;
        float f3 = intrinsicHeight;
        float f4 = OooO00o2 / f3;
        ImageView.ScaleType scaleType = this.OooOooO;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.OooOO0o.postTranslate((OooO0O02 - f) / 2.0f, (OooO00o2 - f3) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f2, f4);
            this.OooOO0o.postScale(max, max);
            this.OooOO0o.postTranslate((OooO0O02 - (f * max)) / 2.0f, (OooO00o2 - (f3 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f2, f4));
            this.OooOO0o.postScale(min, min);
            this.OooOO0o.postTranslate((OooO0O02 - (f * min)) / 2.0f, (OooO00o2 - (f3 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f, f3);
            RectF rectF2 = new RectF(0.0f, 0.0f, OooO0O02, OooO00o2);
            if (((int) 0.0f) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f3, f);
            }
            int i = OooO0o.OooO00o[this.OooOooO.ordinal()];
            if (i == 1) {
                this.OooOO0o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.OooOO0o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.OooOO0o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.OooOO0o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        OooO0o();
    }

    public final int OooO0O0(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public final boolean OooO0O0() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        RectF OooO00o2 = OooO00o(OooO0Oo());
        if (OooO00o2 == null) {
            return false;
        }
        float height = OooO00o2.height();
        float width = OooO00o2.width();
        float OooO00o3 = OooO00o(this.OooO);
        float f6 = 0.0f;
        if (height <= OooO00o3) {
            int i = OooO0o.OooO00o[this.OooOooO.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f4 = (OooO00o3 - height) / 2.0f;
                    f5 = OooO00o2.top;
                } else {
                    f4 = OooO00o3 - height;
                    f5 = OooO00o2.top;
                }
                f = f4 - f5;
            } else {
                f = -OooO00o2.top;
            }
            this.OooOoo0 = 2;
        } else {
            float f7 = OooO00o2.top;
            if (f7 > 0.0f) {
                this.OooOoo0 = 0;
                f = -f7;
            } else {
                float f10 = OooO00o2.bottom;
                if (f10 < OooO00o3) {
                    this.OooOoo0 = 1;
                    f = OooO00o3 - f10;
                } else {
                    this.OooOoo0 = -1;
                    f = 0.0f;
                }
            }
        }
        float OooO0O02 = OooO0O0(this.OooO);
        if (width <= OooO0O02) {
            int i2 = OooO0o.OooO00o[this.OooOooO.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f2 = (OooO0O02 - width) / 2.0f;
                    f3 = OooO00o2.left;
                } else {
                    f2 = OooO0O02 - width;
                    f3 = OooO00o2.left;
                }
                f6 = f2 - f3;
            } else {
                f6 = -OooO00o2.left;
            }
            this.OooOoOO = 2;
        } else {
            float f11 = OooO00o2.left;
            if (f11 > 0.0f) {
                this.OooOoOO = 0;
                f6 = -f11;
            } else {
                float f12 = OooO00o2.right;
                if (f12 < OooO0O02) {
                    f6 = OooO0O02 - f12;
                    this.OooOoOO = 1;
                } else {
                    this.OooOoOO = -1;
                }
            }
        }
        this.OooOOO.postTranslate(f6, f);
        return true;
    }

    public RectF OooO0OO() {
        OooO0O0();
        return OooO00o(OooO0Oo());
    }

    public final Matrix OooO0Oo() {
        this.OooOOO0.set(this.OooOO0o);
        this.OooOOO0.postConcat(this.OooOOO);
        return this.OooOOO0;
    }

    public final void OooO0o() {
        RectF OooO00o2;
        this.OooOOO.reset();
        this.OooOOO.postRotate(0.0f);
        OooO00o();
        Matrix OooO0Oo = OooO0Oo();
        this.OooO.setImageMatrix(OooO0Oo);
        if (this.OooOOo0 != null && (OooO00o2 = OooO00o(OooO0Oo)) != null) {
            this.OooOOo0.OooO00o(OooO00o2);
        }
        OooO0O0();
    }

    public float OooO0o0() {
        this.OooOOO.getValues(this.OooOOOo);
        float pow = (float) Math.pow(this.OooOOOo[0], 2.0d);
        this.OooOOO.getValues(this.OooOOOo);
        return (float) Math.sqrt(pow + ((float) Math.pow(this.OooOOOo[3], 2.0d)));
    }

    public void OooO0oO() {
        if (this.OooOoo) {
            OooO00o(this.OooO.getDrawable());
        } else {
            OooO0o();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i10) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i10) {
            return;
        }
        OooO00o(this.OooO.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.cloud.tmc.miniapp.widget.photoview.OooO00o oooO00o;
        GestureDetector gestureDetector;
        RectF OooO0OO2;
        if (!this.OooOoo || ((ImageView) view).getDrawable() == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            OooOO0 oooOO0 = this.OooOoO;
            if (oooOO0 != null) {
                oooOO0.OooO00o.forceFinished(true);
                this.OooOoO = null;
            }
        } else if (action == 1 || action == 3) {
            if (OooO0o0() < this.OooO0OO) {
                RectF OooO0OO3 = OooO0OO();
                if (OooO0OO3 != null) {
                    view.post(new OooO(OooO0o0(), this.OooO0OO, OooO0OO3.centerX(), OooO0OO3.centerY()));
                    z = true;
                }
            } else if (OooO0o0() > this.OooO0o0 && (OooO0OO2 = OooO0OO()) != null) {
                view.post(new OooO(OooO0o0(), this.OooO0o0, OooO0OO2.centerX(), OooO0OO2.centerY()));
                z = true;
            }
            oooO00o = this.OooOO0O;
            if (oooO00o != null) {
                boolean isInProgress = oooO00o.OooO0OO.isInProgress();
                com.cloud.tmc.miniapp.widget.photoview.OooO00o oooO00o2 = this.OooOO0O;
                boolean z2 = oooO00o2.OooO0o0;
                try {
                    oooO00o2.OooO0OO.onTouchEvent(motionEvent);
                    oooO00o2.OooO0OO(motionEvent);
                } catch (IllegalArgumentException unused) {
                }
                this.OooO0oO = (!isInProgress && !this.OooOO0O.OooO0OO.isInProgress()) && (!z2 && !this.OooOO0O.OooO0o0);
                z = true;
            }
            gestureDetector = this.OooOO0;
            if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
                z = true;
            }
            this.OooO0oo = motionEvent.getPointerCount() > 1;
            return z;
        }
        z = false;
        oooO00o = this.OooOO0O;
        if (oooO00o != null) {
        }
        gestureDetector = this.OooOO0;
        if (gestureDetector != null) {
            z = true;
        }
        this.OooO0oo = motionEvent.getPointerCount() > 1;
        return z;
    }
}
