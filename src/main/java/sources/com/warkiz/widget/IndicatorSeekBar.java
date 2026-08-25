package com.warkiz.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class IndicatorSeekBar extends View {
    private float[] A;
    private int A0;
    private boolean B;
    private Drawable B0;
    private boolean C;
    private Bitmap C0;
    private boolean D;
    private int D0;
    private int E;
    private boolean E0;
    private String[] F;
    private float F0;
    private float[] G;
    private int G0;
    private float[] H;
    private boolean H0;
    private float I;
    private boolean I0;
    private int J;
    private Typeface K;
    private int L;
    private int M;
    private int N;
    private CharSequence[] O;
    private d P;
    private int Q;
    private int R;
    private boolean S;
    private int T;
    private View U;
    private View V;
    private int W;
    private Context a;
    private String a0;
    private Paint b;
    private float[] b0;
    private TextPaint c;
    private int c0;
    private e d;
    private int d0;
    private Rect e;
    private int e0;
    private float f;
    private float f0;
    private float g;
    private Bitmap g0;
    private float h;
    private Bitmap h0;
    private float i;
    private Drawable i0;
    private boolean j;
    private int j0;
    private f k;
    private boolean k0;
    private int l;
    private boolean l0;
    private int m;
    private int m0;
    private int n;
    private boolean n0;
    private int o;
    private RectF o0;
    private float p;
    private RectF p0;
    private float q;
    private int q0;
    private boolean r;
    private int r0;
    private float s;
    private int s0;
    private float t;
    private int t0;
    private float u;
    private int[] u0;
    private boolean v;
    private boolean v0;
    private int w;
    private float w0;
    private boolean x;
    private float x0;
    private boolean y;
    private Bitmap y0;
    private boolean z;
    private int z0;

    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float a;
        final /* synthetic */ int b;

        a(float f, int i) {
            this.a = f;
            this.b = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IndicatorSeekBar indicatorSeekBar = IndicatorSeekBar.this;
            indicatorSeekBar.g = indicatorSeekBar.u;
            if (this.a - IndicatorSeekBar.this.A[this.b] > 0.0f) {
                IndicatorSeekBar.this.u = this.a - ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else {
                IndicatorSeekBar.this.u = this.a + ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
            IndicatorSeekBar indicatorSeekBar2 = IndicatorSeekBar.this;
            indicatorSeekBar2.X(indicatorSeekBar2.u);
            IndicatorSeekBar.this.setSeekListener(false);
            if (IndicatorSeekBar.this.P != null && IndicatorSeekBar.this.S) {
                IndicatorSeekBar.this.P.j();
                IndicatorSeekBar.this.a0();
            }
            IndicatorSeekBar.this.invalidate();
        }
    }

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = -1.0f;
        this.i = -1.0f;
        this.w = 1;
        this.a = context;
        A(context, attributeSet);
        D();
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = -1.0f;
        this.i = -1.0f;
        this.w = 1;
        this.a = context;
        A(context, attributeSet);
        D();
    }

    private void A(Context context, AttributeSet attributeSet) {
        com.warkiz.widget.a aVar = new com.warkiz.widget.a(context);
        if (attributeSet == null) {
            l(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IndicatorSeekBar);
        this.s = obtainStyledAttributes.getFloat(R$styleable.IndicatorSeekBar_isb_max, aVar.b);
        this.t = obtainStyledAttributes.getFloat(R$styleable.IndicatorSeekBar_isb_min, aVar.c);
        this.u = obtainStyledAttributes.getFloat(R$styleable.IndicatorSeekBar_isb_progress, aVar.d);
        this.v = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_progress_value_float, aVar.e);
        this.x = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_user_seekable, aVar.h);
        this.j = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_clear_default_padding, aVar.j);
        this.y = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_only_thumb_draggable, aVar.i);
        this.z = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_seek_smoothly, aVar.f);
        this.B = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_r2l, aVar.g);
        this.q0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_track_background_size, aVar.q);
        this.r0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_track_progress_size, aVar.s);
        this.s0 = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_track_background_color, aVar.r);
        this.t0 = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_track_progress_color, aVar.t);
        this.n0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_track_rounded_corners, aVar.u);
        this.A0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_thumb_size, aVar.x);
        this.B0 = obtainStyledAttributes.getDrawable(R$styleable.IndicatorSeekBar_isb_thumb_drawable);
        this.I0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        L(obtainStyledAttributes.getColorStateList(R$styleable.IndicatorSeekBar_isb_thumb_color), aVar.y);
        this.E0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_show_thumb_text, aVar.w);
        this.G0 = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_thumb_text_color, aVar.v);
        this.c0 = obtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_ticks_count, aVar.H);
        this.j0 = obtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_show_tick_marks_type, aVar.I);
        this.m0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_tick_marks_size, aVar.K);
        N(obtainStyledAttributes.getColorStateList(R$styleable.IndicatorSeekBar_isb_tick_marks_color), aVar.J);
        this.i0 = obtainStyledAttributes.getDrawable(R$styleable.IndicatorSeekBar_isb_tick_marks_drawable);
        this.l0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.N);
        this.k0 = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.M);
        this.C = obtainStyledAttributes.getBoolean(R$styleable.IndicatorSeekBar_isb_show_tick_texts, aVar.B);
        this.J = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_tick_texts_size, aVar.D);
        O(obtainStyledAttributes.getColorStateList(R$styleable.IndicatorSeekBar_isb_tick_texts_color), aVar.C);
        this.O = obtainStyledAttributes.getTextArray(R$styleable.IndicatorSeekBar_isb_tick_texts_array);
        J(obtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.F);
        this.W = obtainStyledAttributes.getInt(R$styleable.IndicatorSeekBar_isb_show_indicator, aVar.k);
        this.Q = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_indicator_color, aVar.l);
        this.T = obtainStyledAttributes.getDimensionPixelSize(R$styleable.IndicatorSeekBar_isb_indicator_text_size, aVar.n);
        this.R = obtainStyledAttributes.getColor(R$styleable.IndicatorSeekBar_isb_indicator_text_color, aVar.m);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.U = View.inflate(this.a, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.V = View.inflate(this.a, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    private void B() {
        if (this.j) {
            return;
        }
        int a2 = g.a(this.a, 16.0f);
        if (getPaddingLeft() == 0) {
            setPadding(a2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (getPaddingRight() == 0) {
            setPadding(getPaddingLeft(), getPaddingTop(), a2, getPaddingBottom());
        }
    }

    private void C() {
        int i = this.W;
        if (i != 0 && this.P == null) {
            d dVar = new d(this.a, this, this.Q, i, this.T, this.R, this.U, this.V);
            this.P = dVar;
            this.U = dVar.d();
        }
    }

    private void D() {
        E();
        int i = this.q0;
        int i2 = this.r0;
        if (i > i2) {
            this.q0 = i2;
        }
        if (this.B0 == null) {
            float f = this.A0 / 2.0f;
            this.w0 = f;
            this.x0 = f * 1.2f;
        } else {
            float min = Math.min(g.a(this.a, 30.0f), this.A0) / 2.0f;
            this.w0 = min;
            this.x0 = min;
        }
        if (this.i0 == null) {
            this.f0 = this.m0 / 2.0f;
        } else {
            this.f0 = Math.min(g.a(this.a, 30.0f), this.m0) / 2.0f;
        }
        this.f = Math.max(this.x0, this.f0) * 2.0f;
        G();
        S();
        this.g = this.u;
        q();
        this.o0 = new RectF();
        this.p0 = new RectF();
        B();
        C();
    }

    private void E() {
        float f = this.s;
        float f2 = this.t;
        if (f < f2) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.u < f2) {
            this.u = f2;
        }
        if (this.u > f) {
            this.u = f;
        }
    }

    private void F() {
        this.n = getMeasuredWidth();
        this.l = getPaddingStart();
        this.m = getPaddingEnd();
        this.o = getPaddingTop();
        float f = (this.n - this.l) - this.m;
        this.p = f;
        this.q = f / (this.c0 + (-1) > 0 ? r1 - 1 : 1);
    }

    private void G() {
        if (this.b == null) {
            this.b = new Paint();
        }
        if (this.n0) {
            this.b.setStrokeCap(Paint.Cap.ROUND);
        }
        this.b.setAntiAlias(true);
        int i = this.q0;
        if (i > this.r0) {
            this.r0 = i;
        }
    }

    private void H() {
        if (this.c == null) {
            TextPaint textPaint = new TextPaint();
            this.c = textPaint;
            textPaint.setAntiAlias(true);
            this.c.setTextAlign(Paint.Align.CENTER);
            this.c.setTextSize(this.J);
        }
        if (this.e == null) {
            this.e = new Rect();
        }
    }

    private void I() {
        int i = this.c0;
        if (i == 0) {
            return;
        }
        if (this.C) {
            this.F = new String[i];
        }
        for (int i2 = 0; i2 < this.b0.length; i2++) {
            if (this.C) {
                this.F[i2] = z(i2);
                TextPaint textPaint = this.c;
                String str = this.F[i2];
                textPaint.getTextBounds(str, 0, str.length(), this.e);
                this.G[i2] = this.e.width();
                this.H[i2] = this.l + (this.q * i2);
            }
            this.b0[i2] = this.l + (this.q * i2);
        }
    }

    private void J(int i, Typeface typeface) {
        if (i == 0) {
            this.K = Typeface.DEFAULT;
            return;
        }
        if (i == 1) {
            this.K = Typeface.MONOSPACE;
            return;
        }
        if (i == 2) {
            this.K = Typeface.SANS_SERIF;
            return;
        }
        if (i == 3) {
            this.K = Typeface.SERIF;
        } else if (typeface == null) {
            this.K = Typeface.DEFAULT;
        } else {
            this.K = typeface;
        }
    }

    private void K() {
        Drawable drawable = this.B0;
        if (drawable == null) {
            return;
        }
        if (!(drawable instanceof StateListDrawable)) {
            Bitmap w = w(drawable, true);
            this.y0 = w;
            this.C0 = w;
            return;
        }
        try {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            Class<?> cls = stateListDrawable.getClass();
            int intValue = ((Integer) cls.getMethod("getStateCount", null).invoke(stateListDrawable, null)).intValue();
            if (intValue != 2) {
                throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
            }
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getStateSet", cls2);
            Method method2 = cls.getMethod("getStateDrawable", cls2);
            for (int i = 0; i < intValue; i++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                if (iArr.length <= 0) {
                    this.y0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                } else {
                    if (iArr[0] != 16842919) {
                        throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                    }
                    this.C0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                }
            }
        } catch (Exception unused) {
            Bitmap w2 = w(this.B0, true);
            this.y0 = w2;
            this.C0 = w2;
        }
    }

    private void L(ColorStateList colorStateList, int i) {
        if (colorStateList == null) {
            this.z0 = i;
            this.D0 = i;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i2 = iArr2[0];
                this.z0 = i2;
                this.D0 = i2;
            } else {
                if (iArr.length != 2) {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                }
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int[] iArr3 = iArr[i3];
                    if (iArr3.length == 0) {
                        this.D0 = iArr2[i3];
                    } else {
                        if (iArr3[0] != 16842919) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                        }
                        this.z0 = iArr2[i3];
                    }
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void M() {
        Drawable drawable = this.i0;
        if (!(drawable instanceof StateListDrawable)) {
            Bitmap w = w(drawable, false);
            this.g0 = w;
            this.h0 = w;
            return;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        try {
            Class<?> cls = stateListDrawable.getClass();
            int intValue = ((Integer) cls.getMethod("getStateCount", null).invoke(stateListDrawable, null)).intValue();
            if (intValue != 2) {
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            }
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getStateSet", cls2);
            Method method2 = cls.getMethod("getStateDrawable", cls2);
            for (int i = 0; i < intValue; i++) {
                int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                if (iArr.length <= 0) {
                    this.g0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                } else {
                    if (iArr[0] != 16842913) {
                        throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                    }
                    this.h0 = w((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                }
            }
        } catch (Exception unused) {
            Bitmap w2 = w(this.i0, false);
            this.g0 = w2;
            this.h0 = w2;
        }
    }

    private void N(ColorStateList colorStateList, int i) {
        if (colorStateList == null) {
            this.e0 = i;
            this.d0 = i;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i2 = iArr2[0];
                this.e0 = i2;
                this.d0 = i2;
            } else {
                if (iArr.length != 2) {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                }
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int[] iArr3 = iArr[i3];
                    if (iArr3.length == 0) {
                        this.d0 = iArr2[i3];
                    } else {
                        if (iArr3[0] != 16842913) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                        }
                        this.e0 = iArr2[i3];
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Something wrong happened when parsing thumb selector color." + e.getMessage());
        }
    }

    private void O(ColorStateList colorStateList, int i) {
        if (colorStateList == null) {
            this.M = i;
            this.L = i;
            this.N = i;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr == null || iArr2 == null) {
                return;
            }
            if (iArr.length == 1) {
                int i2 = iArr2[0];
                this.M = i2;
                this.L = i2;
                this.N = i2;
                return;
            }
            if (iArr.length != 3) {
                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
            }
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int[] iArr3 = iArr[i3];
                if (iArr3.length == 0) {
                    this.M = iArr2[i3];
                } else {
                    int i4 = iArr3[0];
                    if (i4 == 16842913) {
                        this.L = iArr2[i3];
                    } else {
                        if (i4 != 16843623) {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                        }
                        this.N = iArr2[i3];
                    }
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void P() {
        if (!this.B) {
            RectF rectF = this.o0;
            rectF.left = this.l;
            rectF.top = this.o + this.x0;
            rectF.right = (((this.u - this.t) * this.p) / getAmplitude()) + this.l;
            RectF rectF2 = this.o0;
            float f = rectF2.top;
            rectF2.bottom = f;
            RectF rectF3 = this.p0;
            rectF3.left = rectF2.right;
            rectF3.top = f;
            rectF3.right = this.n - this.m;
            rectF3.bottom = f;
            return;
        }
        RectF rectF4 = this.p0;
        int i = this.l;
        rectF4.left = i;
        rectF4.top = this.o + this.x0;
        rectF4.right = i + (this.p * (1.0f - ((this.u - this.t) / getAmplitude())));
        RectF rectF5 = this.p0;
        float f2 = rectF5.top;
        rectF5.bottom = f2;
        RectF rectF6 = this.o0;
        rectF6.left = rectF5.right;
        rectF6.top = f2;
        rectF6.right = this.n - this.m;
        rectF6.bottom = f2;
    }

    private boolean Q(float f, float f2) {
        if (this.h == -1.0f) {
            this.h = g.a(this.a, 5.0f);
        }
        float f3 = this.l;
        float f4 = this.h;
        boolean z = f >= f3 - (f4 * 2.0f) && f <= ((float) (this.n - this.m)) + (2.0f * f4);
        float f5 = this.o0.top;
        float f6 = this.x0;
        return z && ((f2 > ((f5 - f6) - f4) ? 1 : (f2 == ((f5 - f6) - f4) ? 0 : -1)) >= 0 && (f2 > ((f5 + f6) + f4) ? 1 : (f2 == ((f5 + f6) + f4) ? 0 : -1)) <= 0);
    }

    private boolean R(float f) {
        X(this.u);
        float f2 = this.B ? this.p0.right : this.o0.right;
        int i = this.A0;
        return f2 - (((float) i) / 2.0f) <= f && f <= f2 + (((float) i) / 2.0f);
    }

    private void S() {
        if (T()) {
            H();
            this.c.setTypeface(this.K);
            this.c.getTextBounds("j", 0, 1, this.e);
            this.E = this.e.height() + g.a(this.a, 3.0f);
        }
    }

    private boolean T() {
        return this.E0 || (this.c0 != 0 && this.C);
    }

    private boolean U() {
        return this.v ? this.g != this.u : Math.round(this.g) != Math.round(this.u);
    }

    private void V(MotionEvent motionEvent) {
        X(n(o(k(motionEvent))));
        setSeekListener(true);
        invalidate();
        Z();
    }

    private void W() {
        P();
        if (T()) {
            this.c.getTextBounds("j", 0, 1, this.e);
            float round = this.o + this.f + Math.round(this.e.height() - this.c.descent()) + g.a(this.a, 3.0f);
            this.I = round;
            this.F0 = round;
        }
        if (this.b0 == null) {
            return;
        }
        I();
        if (this.c0 > 2) {
            float f = this.A[getClosestIndex()];
            this.u = f;
            this.g = f;
        }
        X(this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(float f) {
        if (this.B) {
            this.p0.right = this.l + (this.p * (1.0f - ((f - this.t) / getAmplitude())));
            this.o0.left = this.p0.right;
            return;
        }
        this.o0.right = (((f - this.t) * this.p) / getAmplitude()) + this.l;
        this.p0.left = this.o0.right;
    }

    private void Z() {
        if (this.S) {
            a0();
            return;
        }
        d dVar = this.P;
        if (dVar == null) {
            return;
        }
        dVar.g();
        if (this.P.i()) {
            this.P.p(getThumbCenterX());
        } else {
            this.P.o(getThumbCenterX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        d dVar;
        int i;
        if (!this.S || (dVar = this.P) == null) {
            return;
        }
        dVar.l(getIndicatorTextString());
        int i2 = 0;
        this.U.measure(0, 0);
        int measuredWidth = this.U.getMeasuredWidth();
        float thumbCenterX = getThumbCenterX();
        if (this.i == -1.0f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                this.i = displayMetrics.widthPixels;
            }
        }
        float f = measuredWidth / 2;
        float f2 = f + thumbCenterX;
        int i3 = this.n;
        if (f2 > i3) {
            i2 = i3 - measuredWidth;
            i = (int) ((thumbCenterX - i2) - f);
        } else if (thumbCenterX - f < 0.0f) {
            i = -((int) (f - thumbCenterX));
        } else {
            i2 = (int) (getThumbCenterX() - f);
            i = 0;
        }
        this.P.r(i2);
        this.P.q(i);
    }

    private float getAmplitude() {
        float f = this.s;
        float f2 = this.t;
        if (f - f2 > 0.0f) {
            return f - f2;
        }
        return 1.0f;
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.s - this.t);
        int i = 0;
        int i2 = 0;
        while (true) {
            float[] fArr = this.A;
            if (i >= fArr.length) {
                return i2;
            }
            float abs2 = Math.abs(fArr[i] - this.u);
            if (abs2 <= abs) {
                i2 = i;
                abs = abs2;
            }
            i++;
        }
    }

    private int getLeftSideTickColor() {
        return this.B ? this.d0 : this.e0;
    }

    private int getLeftSideTickTextsColor() {
        return this.B ? this.M : this.L;
    }

    private int getLeftSideTrackSize() {
        return this.B ? this.q0 : this.r0;
    }

    private int getRightSideTickColor() {
        return this.B ? this.e0 : this.d0;
    }

    private int getRightSideTickTextsColor() {
        return this.B ? this.L : this.M;
    }

    private int getRightSideTrackSize() {
        return this.B ? this.r0 : this.q0;
    }

    private float getThumbCenterX() {
        return this.B ? this.p0.right : this.o0.right;
    }

    private int getThumbPosOnTick() {
        if (this.c0 != 0) {
            return Math.round((getThumbCenterX() - this.l) / this.q);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.c0 != 0) {
            return (getThumbCenterX() - this.l) / this.q;
        }
        return 0.0f;
    }

    private float k(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int i = this.l;
        if (x >= i) {
            float x2 = motionEvent.getX();
            int i2 = this.n;
            int i3 = this.m;
            if (x2 <= i2 - i3) {
                return motionEvent.getX();
            }
            i = i2 - i3;
        }
        return i;
    }

    private void l(com.warkiz.widget.a aVar) {
        this.s = aVar.b;
        this.t = aVar.c;
        this.u = aVar.d;
        this.v = aVar.e;
        this.c0 = aVar.H;
        this.z = aVar.f;
        this.B = aVar.g;
        this.x = aVar.h;
        this.j = aVar.j;
        this.y = aVar.i;
        this.W = aVar.k;
        this.Q = aVar.l;
        this.R = aVar.m;
        this.T = aVar.n;
        this.U = aVar.o;
        this.V = aVar.p;
        this.q0 = aVar.q;
        this.s0 = aVar.r;
        this.r0 = aVar.s;
        this.t0 = aVar.t;
        this.n0 = aVar.u;
        this.A0 = aVar.x;
        this.B0 = aVar.A;
        this.G0 = aVar.v;
        L(aVar.z, aVar.y);
        this.E0 = aVar.w;
        this.j0 = aVar.I;
        this.m0 = aVar.K;
        this.i0 = aVar.L;
        this.k0 = aVar.M;
        this.l0 = aVar.N;
        N(aVar.O, aVar.J);
        this.C = aVar.B;
        this.J = aVar.D;
        this.O = aVar.E;
        this.K = aVar.F;
        O(aVar.G, aVar.C);
    }

    private boolean m() {
        if (this.c0 < 3 || !this.z || !this.I0) {
            return false;
        }
        int closestIndex = getClosestIndex();
        float f = this.u;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f - this.A[closestIndex]));
        ofFloat.start();
        ofFloat.addUpdateListener(new a(f, closestIndex));
        return true;
    }

    private float n(float f) {
        this.g = this.u;
        float amplitude = this.t + ((getAmplitude() * (f - this.l)) / this.p);
        this.u = amplitude;
        return amplitude;
    }

    private float o(float f) {
        if (this.c0 > 2 && !this.z) {
            f = this.l + (this.q * Math.round((f - this.l) / this.q));
        }
        return this.B ? (this.p - f) + (this.l * 2) : f;
    }

    private f p(boolean z) {
        String[] strArr;
        if (this.k == null) {
            this.k = new f(this);
        }
        this.k.b = getProgress();
        this.k.c = getProgressFloat();
        this.k.d = z;
        if (this.c0 > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.C && (strArr = this.F) != null) {
                this.k.f = strArr[thumbPosOnTick];
            }
            if (this.B) {
                this.k.e = (this.c0 - thumbPosOnTick) - 1;
            } else {
                this.k.e = thumbPosOnTick;
            }
        }
        return this.k;
    }

    private void q() {
        int i = this.c0;
        if (i < 0 || i > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.c0);
        }
        if (i == 0) {
            return;
        }
        this.b0 = new float[i];
        if (this.C) {
            this.H = new float[i];
            this.G = new float[i];
        }
        this.A = new float[i];
        int i2 = 0;
        while (true) {
            float[] fArr = this.A;
            if (i2 >= fArr.length) {
                return;
            }
            float f = this.t;
            fArr[i2] = f + ((i2 * (this.s - f)) / (this.c0 + (-1) > 0 ? r4 - 1 : 1));
            i2++;
        }
    }

    private void r(Canvas canvas) {
        if (this.H0) {
            return;
        }
        float thumbCenterX = getThumbCenterX();
        if (this.B0 == null) {
            if (this.r) {
                this.b.setColor(this.D0);
            } else {
                this.b.setColor(this.z0);
            }
            canvas.drawCircle(thumbCenterX, this.o0.top, this.r ? this.x0 : this.w0, this.b);
            return;
        }
        if (this.y0 == null || this.C0 == null) {
            K();
        }
        if (this.y0 == null || this.C0 == null) {
            throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
        }
        this.b.setAlpha(255);
        if (this.r) {
            canvas.drawBitmap(this.C0, thumbCenterX - (r1.getWidth() / 2.0f), this.o0.top - (this.C0.getHeight() / 2.0f), this.b);
        } else {
            canvas.drawBitmap(this.y0, thumbCenterX - (r1.getWidth() / 2.0f), this.o0.top - (this.y0.getHeight() / 2.0f), this.b);
        }
    }

    private void s(Canvas canvas) {
        if (this.E0) {
            if (!this.C || this.c0 <= 2) {
                this.c.setColor(this.G0);
                canvas.drawText(y(this.u), getThumbCenterX(), this.F0, this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.d != null && U()) {
            this.d.c(p(z));
        }
    }

    private void t(Canvas canvas) {
        Bitmap bitmap;
        if (this.c0 != 0) {
            if (this.j0 == 0 && this.i0 == null) {
                return;
            }
            float thumbCenterX = getThumbCenterX();
            for (int i = 0; i < this.b0.length; i++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.l0 || thumbCenterX < this.b0[i]) && ((!this.k0 || (i != 0 && i != this.b0.length - 1)) && (i != getThumbPosOnTick() || this.c0 <= 2 || this.z))) {
                    float f = i;
                    if (f <= thumbPosOnTickFloat) {
                        this.b.setColor(getLeftSideTickColor());
                    } else {
                        this.b.setColor(getRightSideTickColor());
                    }
                    if (this.i0 != null) {
                        if (this.h0 == null || this.g0 == null) {
                            M();
                        }
                        Bitmap bitmap2 = this.h0;
                        if (bitmap2 == null || (bitmap = this.g0) == null) {
                            throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
                        }
                        if (f <= thumbPosOnTickFloat) {
                            canvas.drawBitmap(bitmap2, this.b0[i] - (bitmap.getWidth() / 2.0f), this.o0.top - (this.g0.getHeight() / 2.0f), this.b);
                        } else {
                            canvas.drawBitmap(bitmap, this.b0[i] - (bitmap.getWidth() / 2.0f), this.o0.top - (this.g0.getHeight() / 2.0f), this.b);
                        }
                    } else {
                        int i2 = this.j0;
                        if (i2 == 1) {
                            canvas.drawCircle(this.b0[i], this.o0.top, this.f0, this.b);
                        } else if (i2 == 3) {
                            int a2 = g.a(this.a, 1.0f);
                            float leftSideTrackSize = thumbCenterX >= this.b0[i] ? getLeftSideTrackSize() : getRightSideTrackSize();
                            float f2 = this.b0[i];
                            float f3 = a2;
                            float f4 = this.o0.top;
                            float f5 = leftSideTrackSize / 2.0f;
                            canvas.drawRect(f2 - f3, f4 - f5, f2 + f3, f4 + f5, this.b);
                        } else if (i2 == 2) {
                            float f6 = this.b0[i];
                            int i3 = this.m0;
                            float f7 = this.o0.top;
                            canvas.drawRect(f6 - (i3 / 2.0f), f7 - (i3 / 2.0f), f6 + (i3 / 2.0f), f7 + (i3 / 2.0f), this.b);
                        }
                    }
                }
            }
        }
    }

    private void u(Canvas canvas) {
        if (this.F == null) {
            return;
        }
        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
        int i = 0;
        while (true) {
            if (i >= this.F.length) {
                return;
            }
            if (!this.D || i == 0 || i == r2.length - 1) {
                if (i == getThumbPosOnTick() && i == thumbPosOnTickFloat) {
                    this.c.setColor(this.N);
                } else if (i < thumbPosOnTickFloat) {
                    this.c.setColor(getLeftSideTickTextsColor());
                } else {
                    this.c.setColor(getRightSideTickTextsColor());
                }
                int length = this.B ? (this.F.length - i) - 1 : i;
                if (i == 0) {
                    canvas.drawText(this.F[length], this.H[i] + (this.G[length] / 2.0f), this.I, this.c);
                } else {
                    String[] strArr = this.F;
                    if (i == strArr.length - 1) {
                        canvas.drawText(strArr[length], this.H[i] - (this.G[length] / 2.0f), this.I, this.c);
                    } else {
                        canvas.drawText(strArr[length], this.H[i], this.I, this.c);
                    }
                }
            }
            i++;
        }
    }

    private void v(Canvas canvas) {
        if (!this.v0) {
            this.b.setColor(this.t0);
            this.b.setStrokeWidth(this.r0);
            RectF rectF = this.o0;
            canvas.drawLine(rectF.left, rectF.top, rectF.right, rectF.bottom, this.b);
            this.b.setColor(this.s0);
            this.b.setStrokeWidth(this.q0);
            RectF rectF2 = this.p0;
            canvas.drawLine(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.b);
            return;
        }
        int i = this.c0;
        int i2 = i + (-1) > 0 ? i - 1 : 1;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.B) {
                this.b.setColor(this.u0[(i2 - i3) - 1]);
            } else {
                this.b.setColor(this.u0[i3]);
            }
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            float f = i3;
            if (f < thumbPosOnTickFloat) {
                int i4 = i3 + 1;
                if (thumbPosOnTickFloat < i4) {
                    float thumbCenterX = getThumbCenterX();
                    this.b.setStrokeWidth(getLeftSideTrackSize());
                    float f2 = this.b0[i3];
                    RectF rectF3 = this.o0;
                    canvas.drawLine(f2, rectF3.top, thumbCenterX, rectF3.bottom, this.b);
                    this.b.setStrokeWidth(getRightSideTrackSize());
                    RectF rectF4 = this.o0;
                    canvas.drawLine(thumbCenterX, rectF4.top, this.b0[i4], rectF4.bottom, this.b);
                }
            }
            if (f < thumbPosOnTickFloat) {
                this.b.setStrokeWidth(getLeftSideTrackSize());
            } else {
                this.b.setStrokeWidth(getRightSideTrackSize());
            }
            float[] fArr = this.b0;
            float f3 = fArr[i3];
            RectF rectF5 = this.o0;
            canvas.drawLine(f3, rectF5.top, fArr[i3 + 1], rectF5.bottom, this.b);
        }
    }

    private Bitmap w(Drawable drawable, boolean z) {
        int intrinsicHeight;
        if (drawable == null) {
            return null;
        }
        int a2 = g.a(this.a, 30.0f);
        if (drawable.getIntrinsicWidth() > a2) {
            int i = z ? this.A0 : this.m0;
            intrinsicHeight = x(drawable, i);
            if (i > a2) {
                intrinsicHeight = x(drawable, a2);
            } else {
                a2 = i;
            }
        } else {
            a2 = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(a2, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static com.warkiz.widget.a with(@NonNull Context context) {
        return new com.warkiz.widget.a(context);
    }

    private int x(Drawable drawable, int i) {
        return Math.round(((i * 1.0f) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
    }

    private String y(float f) {
        return this.v ? c.b(f, this.w) : String.valueOf(Math.round(f));
    }

    private String z(int i) {
        CharSequence[] charSequenceArr = this.O;
        return charSequenceArr == null ? y(this.A[i]) : i < charSequenceArr.length ? String.valueOf(charSequenceArr[i]) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    void Y() {
        this.U.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.warkiz.widget.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.U.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.a0();
                IndicatorSeekBar.this.U.setVisibility(0);
            }
        }, 300L);
    }

    public void customSectionTrackColor(@NonNull b bVar) {
        int i = this.c0;
        int i2 = i + (-1) > 0 ? i - 1 : 1;
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = this.s0;
        }
        this.v0 = bVar.a(iArr);
        this.u0 = iArr;
        invalidate();
    }

    public void customTickTexts(@NonNull String[] strArr) {
        this.O = strArr;
        if (this.F != null) {
            int i = 0;
            while (i < this.F.length) {
                String valueOf = i < strArr.length ? String.valueOf(strArr[i]) : HttpUrl.FRAGMENT_ENCODE_SET;
                int i2 = this.B ? (this.c0 - 1) - i : i;
                this.F[i2] = valueOf;
                TextPaint textPaint = this.c;
                if (textPaint != null && this.e != null) {
                    textPaint.getTextBounds(valueOf, 0, valueOf.length(), this.e);
                    this.G[i2] = this.e.width();
                }
                i++;
            }
            invalidate();
        }
    }

    public void customTickTextsTypeface(@NonNull Typeface typeface) {
        this.K = typeface;
        S();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public d getIndicator() {
        return this.P;
    }

    View getIndicatorContentView() {
        return this.U;
    }

    String getIndicatorTextString() {
        String[] strArr;
        String str = this.a0;
        if (str == null || !str.contains("${TICK_TEXT}")) {
            String str2 = this.a0;
            if (str2 != null && str2.contains("${PROGRESS}")) {
                return this.a0.replace("${PROGRESS}", y(this.u));
            }
        } else if (this.c0 > 2 && (strArr = this.F) != null) {
            return this.a0.replace("${TICK_TEXT}", strArr[getThumbPosOnTick()]);
        }
        return y(this.u);
    }

    public float getMax() {
        return this.s;
    }

    public float getMin() {
        return this.t;
    }

    public e getOnSeekChangeListener() {
        return this.d;
    }

    public int getProgress() {
        return Math.round(this.u);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.u).setScale(this.w, 4).floatValue();
    }

    public int getTickCount() {
        return this.c0;
    }

    public void hideThumb(boolean z) {
        this.H0 = z;
        invalidate();
    }

    public void hideThumbText(boolean z) {
        this.E0 = !z;
        invalidate();
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        v(canvas);
        t(canvas);
        u(canvas);
        r(canvas);
        s(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(View.resolveSize(g.a(this.a, 170.0f), i), Math.round(this.f + getPaddingTop() + getPaddingBottom()) + this.E);
        F();
        W();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        setProgress(bundle.getFloat("isb_progress"));
        super.onRestoreInstanceState(bundle.getParcelable("isb_instance_state"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("isb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.u);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new Runnable() { // from class: com.warkiz.widget.IndicatorSeekBar.1
            @Override // java.lang.Runnable
            public void run() {
                IndicatorSeekBar.this.requestLayout();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if (r0 != 3) goto L37;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.x || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    V(motionEvent);
                }
            }
            this.r = false;
            e eVar = this.d;
            if (eVar != null) {
                eVar.b(this);
            }
            if (!m()) {
                invalidate();
            }
            d dVar = this.P;
            if (dVar != null) {
                dVar.f();
            }
        } else {
            performClick();
            float x = motionEvent.getX();
            if (Q(x, motionEvent.getY())) {
                if (this.y && !R(x)) {
                    return false;
                }
                this.r = true;
                e eVar2 = this.d;
                if (eVar2 != null) {
                    eVar2.a(this);
                }
                V(motionEvent);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setDecimalScale(int i) {
        this.w = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z == isEnabled()) {
            return;
        }
        super.setEnabled(z);
        if (isEnabled()) {
            setAlpha(1.0f);
            if (this.S) {
                this.U.setAlpha(1.0f);
                return;
            }
            return;
        }
        setAlpha(0.3f);
        if (this.S) {
            this.U.setAlpha(0.3f);
        }
    }

    void setIndicatorStayAlways(boolean z) {
        this.S = z;
    }

    public void setIndicatorTextFormat(String str) {
        this.a0 = str;
        I();
        a0();
    }

    public synchronized void setMax(float f) {
        this.s = Math.max(this.t, f);
        E();
        q();
        W();
        invalidate();
        a0();
    }

    public synchronized void setMin(float f) {
        this.t = Math.min(this.s, f);
        E();
        q();
        W();
        invalidate();
        a0();
    }

    public void setOnSeekChangeListener(@NonNull e eVar) {
        this.d = eVar;
    }

    public synchronized void setProgress(float f) {
        try {
            this.g = this.u;
            float f2 = this.t;
            if (f >= f2) {
                f2 = this.s;
                if (f > f2) {
                }
                this.u = f;
                if (!this.z && this.c0 > 2) {
                    this.u = this.A[getClosestIndex()];
                }
                setSeekListener(false);
                X(this.u);
                postInvalidate();
                a0();
            }
            f = f2;
            this.u = f;
            if (!this.z) {
                this.u = this.A[getClosestIndex()];
            }
            setSeekListener(false);
            X(this.u);
            postInvalidate();
            a0();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setR2L(boolean z) {
        this.B = z;
        requestLayout();
        invalidate();
        a0();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.I0 = z;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.B0 = null;
            this.y0 = null;
            this.C0 = null;
        } else {
            this.B0 = drawable;
            float min = Math.min(g.a(this.a, 30.0f), this.A0) / 2.0f;
            this.w0 = min;
            this.x0 = min;
            this.f = Math.max(min, this.f0) * 2.0f;
            K();
        }
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i) {
        int i2 = this.c0;
        if (i2 < 0 || i2 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.c0);
        }
        this.c0 = i;
        q();
        I();
        F();
        W();
        invalidate();
        a0();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.i0 = null;
            this.g0 = null;
            this.h0 = null;
        } else {
            this.i0 = drawable;
            float min = Math.min(g.a(this.a, 30.0f), this.m0) / 2.0f;
            this.f0 = min;
            this.f = Math.max(this.x0, min) * 2.0f;
            M();
        }
        invalidate();
    }

    public void setUserSeekAble(boolean z) {
        this.x = z;
    }

    public void showBothEndsTickTextsOnly(boolean z) {
        this.D = z;
    }

    public void thumbColor(int i) {
        this.z0 = i;
        this.D0 = i;
        invalidate();
    }

    public void thumbColorStateList(@NonNull ColorStateList colorStateList) {
        L(colorStateList, this.z0);
        invalidate();
    }

    public void tickMarksColor(int i) {
        this.e0 = i;
        this.d0 = i;
        invalidate();
    }

    public void tickMarksColor(@NonNull ColorStateList colorStateList) {
        N(colorStateList, this.e0);
        invalidate();
    }

    public void tickTextsColor(int i) {
        this.M = i;
        this.L = i;
        this.N = i;
        invalidate();
    }

    public void tickTextsColorStateList(@NonNull ColorStateList colorStateList) {
        O(colorStateList, this.L);
        invalidate();
    }
}
