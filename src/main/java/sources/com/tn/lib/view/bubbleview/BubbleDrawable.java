package com.tn.lib.view.bubbleview;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BubbleDrawable extends Drawable {
    private RectF a;
    private Path b;
    private Path c;
    private BitmapShader d;
    private Paint e;
    private Paint f;
    private float g;
    private int h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private int o;
    private Bitmap p;
    private ArrowLocation q;
    private BubbleType r;
    private boolean s;
    private int t;
    float u;
    float v;
    float w;
    float x;
    int[] y;

    public enum ArrowLocation {
        LEFT(0),
        RIGHT(1),
        TOP(2),
        BOTTOM(3),
        NONE(4);

        private int mValue;

        ArrowLocation(int i) {
            this.mValue = i;
        }

        public static ArrowLocation getDefault() {
            return LEFT;
        }

        public static ArrowLocation mapIntToValue(int i) {
            for (ArrowLocation arrowLocation : values()) {
                if (i == arrowLocation.getIntValue()) {
                    return arrowLocation;
                }
            }
            return getDefault();
        }

        public int getIntValue() {
            return this.mValue;
        }
    }

    public enum BubbleType {
        COLOR,
        BITMAP,
        SHADER
    }

    public enum GradientDirection {
        VERTICAL(0),
        HORIZONTAL(1),
        TOP_LEFT_BOTTOM_RIGHT(2),
        TOP_RIGHT_BOTTOM_LEFT(3),
        BOTTOM_LEFT_TOP_RIGHT(4),
        BOTTOM_RIGHT_TOP_LEFT(5);

        private int mValue;

        GradientDirection(int i) {
            this.mValue = i;
        }

        public static GradientDirection getDefault() {
            return VERTICAL;
        }

        public static GradientDirection mapIntToValue(int i) {
            for (GradientDirection gradientDirection : values()) {
                if (i == gradientDirection.getIntValue()) {
                    return gradientDirection;
                }
            }
            return getDefault();
        }

        public int getIntValue() {
            return this.mValue;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[BubbleType.values().length];
            b = iArr;
            try {
                iArr[BubbleType.SHADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[BubbleType.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[BubbleType.BITMAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ArrowLocation.values().length];
            a = iArr2;
            try {
                iArr2[ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ArrowLocation.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static class b {
        public static float A = 0.0f;
        public static int B = -1291845632;
        public static float C = 0.0f;
        public static float u = 25.0f;
        public static float v = 25.0f;
        public static float w = 20.0f;
        public static float x = 50.0f;
        public static int y = -65536;
        public static int z = 255;
        private RectF a;
        private float b = A;
        private int c = B;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        private int j;
        private int k;
        private Bitmap l;
        private BubbleType m;
        private ArrowLocation n;
        private boolean o;
        float p;
        float q;
        float r;
        float s;
        int[] t;

        public b() {
            float f = C;
            this.d = f;
            this.e = f;
            this.f = u;
            this.g = w;
            this.h = v;
            this.i = x;
            this.j = y;
            this.k = z;
            this.m = BubbleType.COLOR;
            this.n = ArrowLocation.LEFT;
        }

        public BubbleDrawable A() {
            if (this.a != null) {
                return new BubbleDrawable(this);
            }
            throw new IllegalArgumentException("BubbleDrawable Rect can not be null");
        }

        public b B(RectF rectF) {
            this.a = rectF;
            return this;
        }

        public b C(int i) {
            this.c = i;
            return this;
        }

        public b D(float f) {
            this.d = f;
            return this;
        }

        public b E(float f) {
            this.e = f;
            return this;
        }

        public b F(float f) {
            this.b = f;
            return this;
        }

        public b p(int i) {
            this.k = i;
            return this;
        }

        public b q(float f) {
            this.g = f * 2.0f;
            return this;
        }

        public b r(boolean z2) {
            this.o = z2;
            return this;
        }

        public b s(float f) {
            this.h = f;
            return this;
        }

        public b t(ArrowLocation arrowLocation) {
            this.n = arrowLocation;
            return this;
        }

        public b u(float f) {
            this.i = f;
            return this;
        }

        public b v(float f) {
            this.f = f;
            return this;
        }

        public b w(Bitmap bitmap) {
            this.l = bitmap;
            z(BubbleType.BITMAP);
            return this;
        }

        public b x(int i) {
            this.j = i;
            z(BubbleType.COLOR);
            return this;
        }

        public b y(float f, float f2, float f3, float f4, int[] iArr) {
            this.p = f;
            this.q = f2;
            this.r = f3;
            this.s = f4;
            this.t = iArr;
            z(BubbleType.SHADER);
            return this;
        }

        public b z(BubbleType bubbleType) {
            this.m = bubbleType;
            return this;
        }
    }

    private BubbleDrawable(b bVar) {
        this.b = new Path();
        this.c = new Path();
        this.e = new Paint(1);
        this.f = new Paint();
        this.t = 255;
        this.g = bVar.b;
        this.h = bVar.c;
        this.i = bVar.d;
        this.j = bVar.e;
        this.a = bVar.a;
        this.l = bVar.g;
        this.t = bVar.k;
        this.m = bVar.h;
        this.k = bVar.f;
        this.n = bVar.i;
        this.o = bVar.j;
        this.p = bVar.l;
        this.q = bVar.n;
        this.r = bVar.m;
        this.s = bVar.o;
        this.u = bVar.p;
        this.v = bVar.q;
        this.w = bVar.r;
        this.x = bVar.s;
        this.y = bVar.t;
    }

    private void a(Canvas canvas) {
        int i = a.b[this.r.ordinal()];
        if (i == 1) {
            this.e.setShader(new LinearGradient(this.u, this.v, this.w, this.x, this.y, (float[]) null, Shader.TileMode.CLAMP));
        } else if (i == 2) {
            this.e.setColor(this.o);
        } else if (i == 3) {
            if (this.p == null) {
                return;
            }
            if (this.d == null) {
                Bitmap bitmap = this.p;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.d = new BitmapShader(bitmap, tileMode, tileMode);
            }
            this.e.setShader(this.d);
            g();
        }
        e(this.q, this.b);
        if (this.g > 0.0f) {
            this.f.setColor(0);
            this.f.setAlpha(Math.abs(this.t));
            this.f.setAntiAlias(true);
            this.f.setShadowLayer(this.g, this.i, this.j, this.h);
            this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
            canvas.drawPath(this.b, this.f);
        }
        canvas.drawPath(this.b, this.e);
    }

    private void b(RectF rectF, Path path) {
        if (this.s) {
            this.n = ((rectF.right - rectF.left) / 2.0f) - (this.k / 2.0f);
        }
        path.moveTo(rectF.left + this.l, rectF.top);
        path.lineTo(rectF.width() - this.l, rectF.top);
        float f = rectF.right;
        float f2 = this.l;
        float f3 = rectF.top;
        path.arcTo(new RectF(f - f2, f3, f, f2 + f3), 270.0f, 90.0f);
        path.lineTo(rectF.right, (rectF.bottom - this.m) - this.l);
        float f4 = rectF.right;
        float f5 = this.l;
        float f6 = rectF.bottom;
        float f7 = this.m;
        path.arcTo(new RectF(f4 - f5, (f6 - f5) - f7, f4, f6 - f7), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.k + this.n, rectF.bottom - this.m);
        path.lineTo(rectF.left + this.n + (this.k / 2.0f), rectF.bottom);
        path.lineTo(rectF.left + this.n, rectF.bottom - this.m);
        path.lineTo(rectF.left + Math.min(this.l, this.n), rectF.bottom - this.m);
        float f10 = rectF.left;
        float f11 = rectF.bottom;
        float f12 = this.l;
        float f13 = this.m;
        path.arcTo(new RectF(f10, (f11 - f12) - f13, f12 + f10, f11 - f13), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.l);
        float f14 = rectF.left;
        float f15 = rectF.top;
        float f16 = this.l;
        path.arcTo(new RectF(f14, f15, f16 + f14, f16 + f15), 180.0f, 90.0f);
        path.close();
    }

    private void c(RectF rectF, Path path) {
        if (this.s) {
            this.n = ((rectF.bottom - rectF.top) / 2.0f) - (this.k / 2.0f);
        }
        path.moveTo(this.k + rectF.left + this.l, rectF.top);
        path.lineTo(rectF.width() - this.l, rectF.top);
        float f = rectF.right;
        float f2 = this.l;
        float f3 = rectF.top;
        path.arcTo(new RectF(f - f2, f3, f, f2 + f3), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.l);
        float f4 = rectF.right;
        float f5 = this.l;
        float f6 = rectF.bottom;
        path.arcTo(new RectF(f4 - f5, f6 - f5, f4, f6), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.k + this.l, rectF.bottom);
        float f7 = rectF.left;
        float f10 = this.k;
        float f11 = rectF.bottom;
        float f12 = this.l;
        path.arcTo(new RectF(f7 + f10, f11 - f12, f12 + f7 + f10, f11), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.k, this.m + this.n);
        path.lineTo(rectF.left, this.n + (this.m / 2.0f));
        path.lineTo(rectF.left + this.k, this.n);
        path.lineTo(rectF.left + this.k, rectF.top + this.l);
        float f13 = rectF.left;
        float f14 = this.k;
        float f15 = rectF.top;
        float f16 = this.l;
        path.arcTo(new RectF(f13 + f14, f15, f13 + f16 + f14, f16 + f15), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path) {
        if (this.s) {
            this.n = ((rectF.right - rectF.left) / 2.0f) - (this.k / 2.0f);
        }
        path.moveTo(rectF.left + this.l, rectF.top);
        path.lineTo(rectF.width() - this.l, rectF.top);
        float f = rectF.right;
        float f2 = this.l;
        float f3 = rectF.top;
        path.arcTo(new RectF(f - f2, f3, f, f2 + f3), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.l);
        float f4 = rectF.right;
        float f5 = this.l;
        float f6 = rectF.bottom;
        path.arcTo(new RectF(f4 - f5, f6 - f5, f4, f6), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.l, rectF.bottom);
        float f7 = rectF.left;
        float f10 = rectF.bottom;
        float f11 = this.l;
        path.arcTo(new RectF(f7, f10 - f11, f11 + f7, f10), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.l);
        float f12 = rectF.left;
        float f13 = rectF.top;
        float f14 = this.l;
        path.arcTo(new RectF(f12, f13, f14 + f12, f14 + f13), 180.0f, 90.0f);
        path.close();
    }

    private void e(ArrowLocation arrowLocation, Path path) {
        int i = a.a[arrowLocation.ordinal()];
        if (i == 1) {
            c(this.a, path);
            return;
        }
        if (i == 2) {
            f(this.a, path);
            return;
        }
        if (i == 3) {
            h(this.a, path);
        } else if (i == 4) {
            b(this.a, path);
        } else {
            if (i != 5) {
                return;
            }
            d(this.a, path);
        }
    }

    private void f(RectF rectF, Path path) {
        if (this.s) {
            this.n = ((rectF.bottom - rectF.top) / 2.0f) - (this.k / 2.0f);
        }
        path.moveTo(rectF.left + this.l, rectF.top);
        path.lineTo((rectF.width() - this.l) - this.k, rectF.top);
        float f = rectF.right;
        float f2 = this.l;
        float f3 = this.k;
        float f4 = rectF.top;
        path.arcTo(new RectF((f - f2) - f3, f4, f - f3, f2 + f4), 270.0f, 90.0f);
        path.lineTo(rectF.right - this.k, this.n);
        path.lineTo(rectF.right, this.n + (this.m / 2.0f));
        path.lineTo(rectF.right - this.k, this.n + this.m);
        path.lineTo(rectF.right - this.k, rectF.bottom - this.l);
        float f5 = rectF.right;
        float f6 = this.l;
        float f7 = this.k;
        float f10 = rectF.bottom;
        path.arcTo(new RectF((f5 - f6) - f7, f10 - f6, f5 - f7, f10), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.k, rectF.bottom);
        float f11 = rectF.left;
        float f12 = rectF.bottom;
        float f13 = this.l;
        path.arcTo(new RectF(f11, f12 - f13, f13 + f11, f12), 90.0f, 90.0f);
        float f14 = rectF.left;
        float f15 = rectF.top;
        float f16 = this.l;
        path.arcTo(new RectF(f14, f15, f16 + f14, f16 + f15), 180.0f, 90.0f);
        path.close();
    }

    private void g() {
        Matrix matrix = new Matrix();
        matrix.set(null);
        matrix.postScale(getIntrinsicWidth() / this.p.getWidth(), getIntrinsicHeight() / this.p.getHeight());
        RectF rectF = this.a;
        matrix.postTranslate(rectF.left, rectF.top);
        this.d.setLocalMatrix(matrix);
    }

    private void h(RectF rectF, Path path) {
        if (this.s) {
            this.n = ((rectF.right - rectF.left) / 2.0f) - (this.k / 2.0f);
        }
        path.moveTo(rectF.left + Math.min(this.n, this.l), rectF.top + this.m);
        path.lineTo(rectF.left + this.n, rectF.top + this.m);
        path.lineTo(rectF.left + (this.k / 2.0f) + this.n, rectF.top);
        path.lineTo(rectF.left + this.k + this.n, rectF.top + this.m);
        path.lineTo(rectF.right - this.l, rectF.top + this.m);
        float f = rectF.right;
        float f2 = this.l;
        float f3 = rectF.top;
        float f4 = this.m;
        path.arcTo(new RectF(f - f2, f3 + f4, f, f2 + f3 + f4), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.l);
        float f5 = rectF.right;
        float f6 = this.l;
        float f7 = rectF.bottom;
        path.arcTo(new RectF(f5 - f6, f7 - f6, f5, f7), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.l, rectF.bottom);
        float f10 = rectF.left;
        float f11 = rectF.bottom;
        float f12 = this.l;
        path.arcTo(new RectF(f10, f11 - f12, f12 + f10, f11), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.m + this.l);
        float f13 = rectF.left;
        float f14 = rectF.top;
        float f15 = this.m;
        float f16 = this.l;
        path.arcTo(new RectF(f13, f14 + f15, f16 + f13, f16 + f14 + f15), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.t = i;
        this.e.setAlpha(i);
        this.f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
        this.f.setColorFilter(colorFilter);
    }
}
