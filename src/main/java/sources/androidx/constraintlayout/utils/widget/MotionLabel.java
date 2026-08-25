package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.c;
import androidx.constraintlayout.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class MotionLabel extends View implements c {
    static String V = "MotionLabel";
    private float A;
    private float B;
    private float C;
    private Drawable D;
    Matrix E;
    private Bitmap F;
    private BitmapShader G;
    private Matrix H;
    private float I;
    private float J;
    private float K;
    private float L;
    Paint M;
    private int N;
    Rect O;
    Paint P;
    float Q;
    float R;
    float S;
    float T;
    float U;

    /* renamed from: a, reason: collision with root package name */
    TextPaint f6487a;

    /* renamed from: b, reason: collision with root package name */
    Path f6488b;

    /* renamed from: c, reason: collision with root package name */
    private int f6489c;

    /* renamed from: d, reason: collision with root package name */
    private int f6490d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6491e;

    /* renamed from: f, reason: collision with root package name */
    private float f6492f;

    /* renamed from: g, reason: collision with root package name */
    private float f6493g;

    /* renamed from: h, reason: collision with root package name */
    ViewOutlineProvider f6494h;

    /* renamed from: i, reason: collision with root package name */
    RectF f6495i;

    /* renamed from: j, reason: collision with root package name */
    private float f6496j;

    /* renamed from: k, reason: collision with root package name */
    private float f6497k;

    /* renamed from: l, reason: collision with root package name */
    private int f6498l;

    /* renamed from: m, reason: collision with root package name */
    private int f6499m;

    /* renamed from: n, reason: collision with root package name */
    private float f6500n;

    /* renamed from: o, reason: collision with root package name */
    private String f6501o;

    /* renamed from: p, reason: collision with root package name */
    boolean f6502p;

    /* renamed from: q, reason: collision with root package name */
    private Rect f6503q;

    /* renamed from: r, reason: collision with root package name */
    private int f6504r;

    /* renamed from: s, reason: collision with root package name */
    private int f6505s;

    /* renamed from: t, reason: collision with root package name */
    private int f6506t;

    /* renamed from: u, reason: collision with root package name */
    private int f6507u;

    /* renamed from: v, reason: collision with root package name */
    private String f6508v;

    /* renamed from: w, reason: collision with root package name */
    private Layout f6509w;

    /* renamed from: x, reason: collision with root package name */
    private int f6510x;

    /* renamed from: y, reason: collision with root package name */
    private int f6511y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f6512z;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), (Math.min(r3, r4) * MotionLabel.this.f6492f) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.f6493g);
        }
    }

    public MotionLabel(Context context) {
        super(context);
        this.f6487a = new TextPaint();
        this.f6488b = new Path();
        this.f6489c = 65535;
        this.f6490d = 65535;
        this.f6491e = false;
        this.f6492f = 0.0f;
        this.f6493g = Float.NaN;
        this.f6496j = 48.0f;
        this.f6497k = Float.NaN;
        this.f6500n = 0.0f;
        this.f6501o = "Hello World";
        this.f6502p = true;
        this.f6503q = new Rect();
        this.f6504r = 1;
        this.f6505s = 1;
        this.f6506t = 1;
        this.f6507u = 1;
        this.f6510x = 8388659;
        this.f6511y = 0;
        this.f6512z = false;
        this.I = Float.NaN;
        this.J = Float.NaN;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        f(context, null);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6487a = new TextPaint();
        this.f6488b = new Path();
        this.f6489c = 65535;
        this.f6490d = 65535;
        this.f6491e = false;
        this.f6492f = 0.0f;
        this.f6493g = Float.NaN;
        this.f6496j = 48.0f;
        this.f6497k = Float.NaN;
        this.f6500n = 0.0f;
        this.f6501o = "Hello World";
        this.f6502p = true;
        this.f6503q = new Rect();
        this.f6504r = 1;
        this.f6505s = 1;
        this.f6506t = 1;
        this.f6507u = 1;
        this.f6510x = 8388659;
        this.f6511y = 0;
        this.f6512z = false;
        this.I = Float.NaN;
        this.J = Float.NaN;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        f(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f6487a = new TextPaint();
        this.f6488b = new Path();
        this.f6489c = 65535;
        this.f6490d = 65535;
        this.f6491e = false;
        this.f6492f = 0.0f;
        this.f6493g = Float.NaN;
        this.f6496j = 48.0f;
        this.f6497k = Float.NaN;
        this.f6500n = 0.0f;
        this.f6501o = "Hello World";
        this.f6502p = true;
        this.f6503q = new Rect();
        this.f6504r = 1;
        this.f6505s = 1;
        this.f6506t = 1;
        this.f6507u = 1;
        this.f6510x = 8388659;
        this.f6511y = 0;
        this.f6512z = false;
        this.I = Float.NaN;
        this.J = Float.NaN;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        f(context, attributeSet);
    }

    private void c(float f5, float f6, float f7, float f8) {
        if (this.H == null) {
            return;
        }
        this.B = f7 - f5;
        this.C = f8 - f6;
        k();
    }

    private void f(Context context, AttributeSet attributeSet) {
        h(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.f6508v = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.f6497k = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f6497k);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.f6496j = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f6496j);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.f6498l = obtainStyledAttributes.getInt(index, this.f6498l);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.f6499m = obtainStyledAttributes.getInt(index, this.f6499m);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.f6489c = obtainStyledAttributes.getColor(index, this.f6489c);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.f6493g);
                    this.f6493g = dimension;
                    setRound(dimension);
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f5 = obtainStyledAttributes.getFloat(index, this.f6492f);
                    this.f6492f = f5;
                    setRoundPercent(f5);
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.f6511y = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.f6490d = obtainStyledAttributes.getInt(index, this.f6490d);
                    this.f6491e = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.f6500n = obtainStyledAttributes.getDimension(index, this.f6500n);
                    this.f6491e = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.D = obtainStyledAttributes.getDrawable(index);
                    this.f6491e = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.R = obtainStyledAttributes.getFloat(index, this.R);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.S = obtainStyledAttributes.getFloat(index, this.S);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.K = obtainStyledAttributes.getFloat(index, this.K);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.L = obtainStyledAttributes.getFloat(index, this.L);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.U = obtainStyledAttributes.getFloat(index, this.U);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.T = obtainStyledAttributes.getFloat(index, this.T);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.I = obtainStyledAttributes.getDimension(index, this.I);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.J = obtainStyledAttributes.getDimension(index, this.J);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.N = obtainStyledAttributes.getInt(index, this.N);
                }
            }
            obtainStyledAttributes.recycle();
        }
        j();
        i();
    }

    private void g(String str, int i5, int i6) {
        Typeface typeface;
        if (str != null) {
            typeface = Typeface.create(str, i6);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        if (i5 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i5 == 2) {
            typeface = Typeface.SERIF;
        } else if (i5 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        if (i6 <= 0) {
            this.f6487a.setFakeBoldText(false);
            this.f6487a.setTextSkewX(0.0f);
            setTypeface(typeface);
        } else {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i6) : Typeface.create(typeface, i6);
            setTypeface(defaultFromStyle);
            int i7 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i6;
            this.f6487a.setFakeBoldText((i7 & 1) != 0);
            this.f6487a.setTextSkewX((i7 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    private float getHorizontalOffset() {
        float f5 = Float.isNaN(this.f6497k) ? 1.0f : this.f6496j / this.f6497k;
        TextPaint textPaint = this.f6487a;
        String str = this.f6501o;
        return (((((Float.isNaN(this.B) ? getMeasuredWidth() : this.B) - getPaddingLeft()) - getPaddingRight()) - (f5 * textPaint.measureText(str, 0, str.length()))) * (this.K + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f5 = Float.isNaN(this.f6497k) ? 1.0f : this.f6496j / this.f6497k;
        Paint.FontMetrics fontMetrics = this.f6487a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.C) ? getMeasuredHeight() : this.C) - getPaddingTop()) - getPaddingBottom();
        float f6 = fontMetrics.descent;
        float f7 = fontMetrics.ascent;
        return (((measuredHeight - ((f6 - f7) * f5)) * (1.0f - this.L)) / 2.0f) - (f5 * f7);
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f6487a;
        int i5 = typedValue.data;
        this.f6489c = i5;
        textPaint.setColor(i5);
    }

    private void j() {
        if (this.D != null) {
            this.H = new Matrix();
            int intrinsicWidth = this.D.getIntrinsicWidth();
            int intrinsicHeight = this.D.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.J) ? 128 : (int) this.J;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.I) ? 128 : (int) this.I;
            }
            if (this.N != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.F = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.F);
            this.D.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.D.setFilterBitmap(true);
            this.D.draw(canvas);
            if (this.N != 0) {
                this.F = d(this.F, 4);
            }
            Bitmap bitmap = this.F;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.G = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void k() {
        float f5 = Float.isNaN(this.R) ? 0.0f : this.R;
        float f6 = Float.isNaN(this.S) ? 0.0f : this.S;
        float f7 = Float.isNaN(this.T) ? 1.0f : this.T;
        float f8 = Float.isNaN(this.U) ? 0.0f : this.U;
        this.H.reset();
        float width = this.F.getWidth();
        float height = this.F.getHeight();
        float f9 = Float.isNaN(this.J) ? this.B : this.J;
        float f10 = Float.isNaN(this.I) ? this.C : this.I;
        float f11 = f7 * (width * f10 < height * f9 ? f9 / width : f10 / height);
        this.H.postScale(f11, f11);
        float f12 = width * f11;
        float f13 = f9 - f12;
        float f14 = f11 * height;
        float f15 = f10 - f14;
        if (!Float.isNaN(this.I)) {
            f15 = this.I / 2.0f;
        }
        if (!Float.isNaN(this.J)) {
            f13 = this.J / 2.0f;
        }
        this.H.postTranslate((((f5 * f13) + f9) - f12) * 0.5f, (((f6 * f15) + f10) - f14) * 0.5f);
        this.H.postRotate(f8, f9 / 2.0f, f10 / 2.0f);
        this.G.setLocalMatrix(this.H);
    }

    Bitmap d(Bitmap bitmap, int i5) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i6 = 0; i6 < i5 && width >= 32 && height >= 32; i6++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    void e(float f5) {
        if (this.f6491e || f5 != 1.0f) {
            this.f6488b.reset();
            String str = this.f6501o;
            int length = str.length();
            this.f6487a.getTextBounds(str, 0, length, this.f6503q);
            this.f6487a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f6488b);
            if (f5 != 1.0f) {
                Log.v(V, androidx.constraintlayout.motion.widget.a.a() + " scale " + f5);
                Matrix matrix = new Matrix();
                matrix.postScale(f5, f5);
                this.f6488b.transform(matrix);
            }
            Rect rect = this.f6503q;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.f6502p = false;
        }
    }

    public float getRound() {
        return this.f6493g;
    }

    public float getRoundPercent() {
        return this.f6492f;
    }

    public float getScaleFromTextSize() {
        return this.f6497k;
    }

    public float getTextBackgroundPanX() {
        return this.R;
    }

    public float getTextBackgroundPanY() {
        return this.S;
    }

    public float getTextBackgroundRotate() {
        return this.U;
    }

    public float getTextBackgroundZoom() {
        return this.T;
    }

    public int getTextOutlineColor() {
        return this.f6490d;
    }

    public float getTextPanX() {
        return this.K;
    }

    public float getTextPanY() {
        return this.L;
    }

    public float getTextureHeight() {
        return this.I;
    }

    public float getTextureWidth() {
        return this.J;
    }

    public Typeface getTypeface() {
        return this.f6487a.getTypeface();
    }

    void i() {
        this.f6504r = getPaddingLeft();
        this.f6505s = getPaddingRight();
        this.f6506t = getPaddingTop();
        this.f6507u = getPaddingBottom();
        g(this.f6508v, this.f6499m, this.f6498l);
        this.f6487a.setColor(this.f6489c);
        this.f6487a.setStrokeWidth(this.f6500n);
        this.f6487a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f6487a.setFlags(128);
        setTextSize(this.f6496j);
        this.f6487a.setAntiAlias(true);
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void layout(float f5, float f6, float f7, float f8) {
        int i5 = (int) (f5 + 0.5f);
        this.A = f5 - i5;
        int i6 = (int) (f7 + 0.5f);
        int i7 = i6 - i5;
        int i8 = (int) (f8 + 0.5f);
        int i9 = (int) (0.5f + f6);
        int i10 = i8 - i9;
        float f9 = f7 - f5;
        this.B = f9;
        float f10 = f8 - f6;
        this.C = f10;
        c(f5, f6, f7, f8);
        if (getMeasuredHeight() == i10 && getMeasuredWidth() == i7) {
            super.layout(i5, i9, i6, i8);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
            super.layout(i5, i9, i6, i8);
        }
        if (this.f6512z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f6487a);
                this.Q = this.P.getTextSize();
            }
            this.B = f9;
            this.C = f10;
            Paint paint = this.P;
            String str = this.f6501o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            float height = this.O.height() * 1.3f;
            float f11 = (f9 - this.f6505s) - this.f6504r;
            float f12 = (f10 - this.f6507u) - this.f6506t;
            float width = this.O.width();
            if (width * f12 > height * f11) {
                this.f6487a.setTextSize((this.Q * f11) / width);
            } else {
                this.f6487a.setTextSize((this.Q * f12) / height);
            }
            if (this.f6491e || !Float.isNaN(this.f6497k)) {
                e(Float.isNaN(this.f6497k) ? 1.0f : this.f6496j / this.f6497k);
            }
        }
    }

    @Override // android.view.View
    public void layout(int i5, int i6, int i7, int i8) {
        super.layout(i5, i6, i7, i8);
        boolean isNaN = Float.isNaN(this.f6497k);
        float f5 = isNaN ? 1.0f : this.f6496j / this.f6497k;
        this.B = i7 - i5;
        this.C = i8 - i6;
        if (this.f6512z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f6487a);
                this.Q = this.P.getTextSize();
            }
            Paint paint = this.P;
            String str = this.f6501o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            int width = this.O.width();
            int height = (int) (this.O.height() * 1.3f);
            float f6 = (this.B - this.f6505s) - this.f6504r;
            float f7 = (this.C - this.f6507u) - this.f6506t;
            if (isNaN) {
                float f8 = width;
                float f9 = height;
                if (f8 * f7 > f9 * f6) {
                    this.f6487a.setTextSize((this.Q * f6) / f8);
                } else {
                    this.f6487a.setTextSize((this.Q * f7) / f9);
                }
            } else {
                float f10 = width;
                float f11 = height;
                f5 = f10 * f7 > f11 * f6 ? f6 / f10 : f7 / f11;
            }
        }
        if (this.f6491e || !isNaN) {
            c(i5, i6, i7, i8);
            e(f5);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f5 = Float.isNaN(this.f6497k) ? 1.0f : this.f6496j / this.f6497k;
        super.onDraw(canvas);
        if (!this.f6491e && f5 == 1.0f) {
            canvas.drawText(this.f6501o, this.A + this.f6504r + getHorizontalOffset(), this.f6506t + getVerticalOffset(), this.f6487a);
            return;
        }
        if (this.f6502p) {
            e(f5);
        }
        if (this.E == null) {
            this.E = new Matrix();
        }
        if (!this.f6491e) {
            float horizontalOffset = this.f6504r + getHorizontalOffset();
            float verticalOffset = this.f6506t + getVerticalOffset();
            this.E.reset();
            this.E.preTranslate(horizontalOffset, verticalOffset);
            this.f6488b.transform(this.E);
            this.f6487a.setColor(this.f6489c);
            this.f6487a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f6487a.setStrokeWidth(this.f6500n);
            canvas.drawPath(this.f6488b, this.f6487a);
            this.E.reset();
            this.E.preTranslate(-horizontalOffset, -verticalOffset);
            this.f6488b.transform(this.E);
            return;
        }
        this.M.set(this.f6487a);
        this.E.reset();
        float horizontalOffset2 = this.f6504r + getHorizontalOffset();
        float verticalOffset2 = this.f6506t + getVerticalOffset();
        this.E.postTranslate(horizontalOffset2, verticalOffset2);
        this.E.preScale(f5, f5);
        this.f6488b.transform(this.E);
        if (this.G != null) {
            this.f6487a.setFilterBitmap(true);
            this.f6487a.setShader(this.G);
        } else {
            this.f6487a.setColor(this.f6489c);
        }
        this.f6487a.setStyle(Paint.Style.FILL);
        this.f6487a.setStrokeWidth(this.f6500n);
        canvas.drawPath(this.f6488b, this.f6487a);
        if (this.G != null) {
            this.f6487a.setShader(null);
        }
        this.f6487a.setColor(this.f6490d);
        this.f6487a.setStyle(Paint.Style.STROKE);
        this.f6487a.setStrokeWidth(this.f6500n);
        canvas.drawPath(this.f6488b, this.f6487a);
        this.E.reset();
        this.E.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f6488b.transform(this.E);
        this.f6487a.set(this.M);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        this.f6512z = false;
        this.f6504r = getPaddingLeft();
        this.f6505s = getPaddingRight();
        this.f6506t = getPaddingTop();
        this.f6507u = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f6487a;
            String str = this.f6501o;
            textPaint.getTextBounds(str, 0, str.length(), this.f6503q);
            if (mode != 1073741824) {
                size = (int) (this.f6503q.width() + 0.99999f);
            }
            size += this.f6504r + this.f6505s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.f6487a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f6506t + this.f6507u + fontMetricsInt;
            }
        } else if (this.f6511y != 0) {
            this.f6512z = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i5) {
        if ((i5 & 8388615) == 0) {
            i5 |= 8388611;
        }
        if ((i5 & 112) == 0) {
            i5 |= 48;
        }
        if (i5 != this.f6510x) {
            invalidate();
        }
        this.f6510x = i5;
        int i6 = i5 & 112;
        if (i6 == 48) {
            this.L = -1.0f;
        } else if (i6 != 80) {
            this.L = 0.0f;
        } else {
            this.L = 1.0f;
        }
        int i7 = i5 & 8388615;
        if (i7 != 3) {
            if (i7 != 5) {
                if (i7 != 8388611) {
                    if (i7 != 8388613) {
                        this.K = 0.0f;
                        return;
                    }
                }
            }
            this.K = 1.0f;
            return;
        }
        this.K = -1.0f;
    }

    public void setRound(float f5) {
        if (Float.isNaN(f5)) {
            this.f6493g = f5;
            float f6 = this.f6492f;
            this.f6492f = -1.0f;
            setRoundPercent(f6);
            return;
        }
        boolean z5 = this.f6493g != f5;
        this.f6493g = f5;
        if (f5 != 0.0f) {
            if (this.f6488b == null) {
                this.f6488b = new Path();
            }
            if (this.f6495i == null) {
                this.f6495i = new RectF();
            }
            if (this.f6494h == null) {
                b bVar = new b();
                this.f6494h = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f6495i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f6488b.reset();
            Path path = this.f6488b;
            RectF rectF = this.f6495i;
            float f7 = this.f6493g;
            path.addRoundRect(rectF, f7, f7, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f5) {
        boolean z5 = this.f6492f != f5;
        this.f6492f = f5;
        if (f5 != 0.0f) {
            if (this.f6488b == null) {
                this.f6488b = new Path();
            }
            if (this.f6495i == null) {
                this.f6495i = new RectF();
            }
            if (this.f6494h == null) {
                a aVar = new a();
                this.f6494h = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f6492f) / 2.0f;
            this.f6495i.set(0.0f, 0.0f, width, height);
            this.f6488b.reset();
            this.f6488b.addRoundRect(this.f6495i, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z5) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f5) {
        this.f6497k = f5;
    }

    public void setText(CharSequence charSequence) {
        this.f6501o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f5) {
        this.R = f5;
        k();
        invalidate();
    }

    public void setTextBackgroundPanY(float f5) {
        this.S = f5;
        k();
        invalidate();
    }

    public void setTextBackgroundRotate(float f5) {
        this.U = f5;
        k();
        invalidate();
    }

    public void setTextBackgroundZoom(float f5) {
        this.T = f5;
        k();
        invalidate();
    }

    public void setTextFillColor(int i5) {
        this.f6489c = i5;
        invalidate();
    }

    public void setTextOutlineColor(int i5) {
        this.f6490d = i5;
        this.f6491e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f5) {
        this.f6500n = f5;
        this.f6491e = true;
        if (Float.isNaN(f5)) {
            this.f6500n = 1.0f;
            this.f6491e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f5) {
        this.K = f5;
        invalidate();
    }

    public void setTextPanY(float f5) {
        this.L = f5;
        invalidate();
    }

    public void setTextSize(float f5) {
        this.f6496j = f5;
        Log.v(V, androidx.constraintlayout.motion.widget.a.a() + "  " + f5 + " / " + this.f6497k);
        TextPaint textPaint = this.f6487a;
        if (!Float.isNaN(this.f6497k)) {
            f5 = this.f6497k;
        }
        textPaint.setTextSize(f5);
        e(Float.isNaN(this.f6497k) ? 1.0f : this.f6496j / this.f6497k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f5) {
        this.I = f5;
        k();
        invalidate();
    }

    public void setTextureWidth(float f5) {
        this.J = f5;
        k();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.f6487a.getTypeface() != typeface) {
            this.f6487a.setTypeface(typeface);
            if (this.f6509w != null) {
                this.f6509w = null;
                requestLayout();
                invalidate();
            }
        }
    }
}
