package com.cloud.sdk.commonutil.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.cloud.sdk.commonutil.R$styleable;
import com.cloud.sdk.commonutil.util.c;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TranCircleImageView extends ImageView {
    public static final int BOTTOM = 2;
    public static final int CENTER = 1;
    public static final int FITXY = 3;
    public static final int TOP = 0;
    private Context a;
    private Paint b;
    private Paint c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private int s;
    private boolean t;
    private int u;

    public TranCircleImageView(Context context) {
        super(context);
        initData();
    }

    public TranCircleImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        e(attributeSet);
    }

    private void a(Canvas canvas, RectF rectF, Paint paint, float f) {
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{g(this.i, f), g(this.j, f), g(this.k, f), g(this.l, f), g(this.o, f), g(this.p, f), g(this.m, f), g(this.n, f)}, Path.Direction.CW);
        path.close();
        canvas.drawPath(path, paint);
    }

    private boolean b(Drawable drawable) {
        return drawable != null && drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0;
    }

    private Bitmap c(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            c.Log().e("TranCircleImageView", Log.getStackTraceString(th));
            return null;
        }
    }

    private Rect d(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i8 = width * i2;
        int i9 = i * height;
        int i10 = 0;
        int[] iArr = {width, height};
        if (i8 == i9) {
            return new Rect(0, 0, width, height);
        }
        if (i8 > i9) {
            iArr[0] = i9 / i2;
        } else if (i8 < i9) {
            iArr[1] = i8 / i;
        }
        boolean z = width > iArr[0];
        int i11 = this.u;
        if (i11 != 0) {
            if (i11 == 1) {
                i4 = z ? (width - iArr[0]) / 2 : 0;
                i3 = z ? 0 : (height - iArr[1]) / 2;
                width = z ? (width + iArr[0]) / 2 : iArr[0];
                height = z ? iArr[1] : (height + iArr[1]) / 2;
            } else if (i11 == 2) {
                i4 = z ? (width - iArr[0]) / 2 : 0;
                i3 = z ? 0 : height - iArr[1];
                width = z ? (width + iArr[0]) / 2 : iArr[0];
                if (z) {
                    height = iArr[1];
                }
            } else if (i11 != 3) {
                height = 0;
                width = 0;
                i3 = 0;
            } else {
                i3 = 0;
            }
            i10 = i4;
        } else {
            int i12 = z ? (width - iArr[0]) / 2 : 0;
            width = z ? (width + iArr[0]) / 2 : iArr[0];
            i3 = 0;
            i10 = i12;
            height = iArr[1];
        }
        return new Rect(i10, i3, width, height);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, R$styleable.TranCircleImageView);
        this.d = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_radiusYL, 0.0f);
        this.e = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topLeftRadiusYL, 0.0f);
        this.f = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topRightRadiusYL, 0.0f);
        this.g = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomLeftRadiusYL, 0.0f);
        this.h = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomRightRadiusYL, 0.0f);
        this.u = obtainStyledAttributes.getInt(R$styleable.TranCircleImageView_scaleTypeYL, 0);
        this.q = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_borderWidthYL, 0.0f);
        this.r = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_borderSpaceYL, 0.0f);
        this.s = obtainStyledAttributes.getColor(R$styleable.TranCircleImageView_borderColorYL, -1);
        this.i = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topLeftRadius_xYL, 0.0f);
        this.j = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topLeftRadius_yYL, 0.0f);
        this.k = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topRightRadius_xYL, 0.0f);
        this.l = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_topRightRadius_yYL, 0.0f);
        this.m = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomLeftRadius_xYL, 0.0f);
        this.n = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomLeftRadius_yYL, 0.0f);
        this.o = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomRightRadius_xYL, 0.0f);
        this.p = obtainStyledAttributes.getDimension(R$styleable.TranCircleImageView_bottomRightRadius_yYL, 0.0f);
        obtainStyledAttributes.recycle();
        initData();
    }

    private void f() {
        float f = this.d;
        if (f != 0.0f) {
            float f2 = this.e;
            if (f2 == 0.0f) {
                f2 = f;
            }
            this.e = f2;
            float f3 = this.f;
            if (f3 == 0.0f) {
                f3 = f;
            }
            this.f = f3;
            float f4 = this.g;
            if (f4 == 0.0f) {
                f4 = f;
            }
            this.g = f4;
            float f8 = this.h;
            if (f8 != 0.0f) {
                f = f8;
            }
            this.h = f;
        }
        float f9 = this.i;
        if (f9 == 0.0f) {
            f9 = this.e;
        }
        this.i = f9;
        float f10 = this.j;
        if (f10 == 0.0f) {
            f10 = this.e;
        }
        this.j = f10;
        float f11 = this.k;
        if (f11 == 0.0f) {
            f11 = this.f;
        }
        this.k = f11;
        float f12 = this.l;
        if (f12 == 0.0f) {
            f12 = this.f;
        }
        this.l = f12;
        float f13 = this.m;
        if (f13 == 0.0f) {
            f13 = this.g;
        }
        this.m = f13;
        float f14 = this.n;
        if (f14 == 0.0f) {
            f14 = this.g;
        }
        this.n = f14;
        float f15 = this.o;
        if (f15 == 0.0f) {
            f15 = this.h;
        }
        this.o = f15;
        float f16 = this.p;
        if (f16 == 0.0f) {
            f16 = this.h;
        }
        this.p = f16;
    }

    private float g(float f, float f2) {
        return Math.max(f - f2, 0.0f);
    }

    public Paint getBorderPaint() {
        return this.c;
    }

    public Paint getPaint() {
        return this.b;
    }

    public void initData() {
        f();
        this.t = (this.q == 0.0f && this.r == 0.0f && this.i == 0.0f && this.j == 0.0f && this.k == 0.0f && this.l == 0.0f && this.m == 0.0f && this.n == 0.0f && this.o == 0.0f && this.p == 0.0f) ? false : true;
        this.b = new Paint(1);
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.q);
        this.c.setColor(this.s);
        if (this.t) {
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            if (this.q != 0.0f) {
                RectF rectF = new RectF(paddingLeft, paddingTop, measuredWidth - paddingRight, measuredHeight - paddingBottom);
                float f = this.q / 2.0f;
                rectF.inset(f, f);
                a(canvas, rectF, this.c, f);
            }
            if (!b(drawable) || !this.t) {
                super.onDraw(canvas);
                return;
            }
            RectF rectF2 = new RectF(paddingLeft, paddingTop, measuredWidth - paddingRight, measuredHeight - paddingBottom);
            float f2 = this.q + this.r;
            float f3 = f2 > 1.0f ? f2 - 1.0f : 0.0f;
            rectF2.inset(f3, f3);
            int saveLayer = canvas.saveLayer(rectF2, null, 31);
            a(canvas, rectF2, this.b, f3);
            Paint paint = this.b;
            if (paint != null) {
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            Bitmap c = c(drawable);
            canvas.drawBitmap(c, d(c, (int) rectF2.width(), (int) rectF2.height()), rectF2, this.b);
            Paint paint2 = this.b;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restoreToCount(saveLayer);
        } catch (Throwable th) {
            c.Log().e("TranCircleImageView", Log.getStackTraceString(th));
        }
    }

    public void setBorderColor(int i) {
        this.s = i;
        Paint paint = this.c;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setBorderSpace(float f) {
        this.r = f;
    }

    public void setBorderWidth(float f) {
        this.q = f;
        Paint paint = this.c;
        if (paint != null) {
            paint.setStrokeWidth(f);
        }
    }

    public void setBottomLeftRadius(float f) {
        setBottomLeftRadius_x(f);
        setBottomLeftRadius_y(f);
    }

    public void setBottomLeftRadius_x(float f) {
        this.m = f;
    }

    public void setBottomLeftRadius_y(float f) {
        this.n = f;
    }

    public void setBottomRightRadius(float f) {
        setBottomRightRadius_x(f);
        setBottomRightRadius_y(f);
    }

    public void setBottomRightRadius_x(float f) {
        this.o = f;
    }

    public void setBottomRightRadius_y(float f) {
        this.p = f;
    }

    public void setCircle(boolean z) {
        this.t = z;
    }

    public void setRadius(float f) {
        setTopLeftRadius(f);
        setTopRightRadius(f);
        setBottomLeftRadius(f);
        setBottomRightRadius(f);
    }

    public void setStyleType(int i) {
        this.u = i;
    }

    public void setTopLeftRadius(float f) {
        setTopLeftRadius_x(f);
        setTopLeftRadius_y(f);
    }

    public void setTopLeftRadius_x(float f) {
        this.i = f;
    }

    public void setTopLeftRadius_y(float f) {
        this.j = f;
    }

    public void setTopRightRadius(float f) {
        setTopRightRadius_x(f);
        setTopRightRadius_y(f);
    }

    public void setTopRightRadius_x(float f) {
        this.k = f;
    }

    public void setTopRightRadius_y(float f) {
        this.l = f;
    }
}
