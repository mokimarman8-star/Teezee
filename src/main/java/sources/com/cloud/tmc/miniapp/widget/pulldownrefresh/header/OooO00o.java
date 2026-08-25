package com.cloud.tmc.miniapp.widget.pulldownrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.MiniRefreshState;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class OooO00o extends com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0 implements OooOO0 {
    public boolean OooO;
    public int OooO0Oo;
    public boolean OooO0o;
    public int OooO0o0;
    public boolean OooO0oO;
    public boolean OooO0oo;
    public Path OooOO0;
    public Paint OooOO0O;
    public int OooOO0o;
    public int OooOOO;
    public int OooOOO0;
    public int OooOOOO;
    public float OooOOOo;
    public float OooOOo;
    public float OooOOo0;
    public float OooOOoo;
    public Animator OooOo;
    public float OooOo0;
    public int OooOo00;
    public float OooOo0O;
    public float OooOo0o;
    public RectF OooOoO0;

    /* renamed from: com.cloud.tmc.miniapp.widget.pulldownrefresh.header.OooO00o$OooO00o, reason: collision with other inner class name */
    public static /* synthetic */ class C0034OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[MiniRefreshState.values().length];
            OooO00o = iArr;
            try {
                iArr[MiniRefreshState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OooO00o[MiniRefreshState.PULL_DOWN_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class OooO0O0 implements ValueAnimator.AnimatorUpdateListener {
        public byte OooO00o;

        public OooO0O0(byte b) {
            this.OooO00o = b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b = this.OooO00o;
            if (b == 0) {
                OooO00o.this.OooOo0o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b) {
                OooO00o oooO00o = OooO00o.this;
                if (oooO00o.OooO0oo) {
                    valueAnimator.cancel();
                    return;
                }
                oooO00o.OooOOO0 = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
            } else if (2 == b) {
                OooO00o.this.OooOOOo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b) {
                OooO00o.this.OooOOoo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b) {
                OooO00o.this.OooOo00 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            OooO00o.this.invalidate();
        }
    }

    public OooO00o(Context context, AttributeSet attributeSet) {
        super(context, null, 0);
        this.OooO = false;
        this.OooOOO = -1;
        this.OooOOOO = 0;
        this.OooOo00 = 0;
        this.OooOo0 = 0.0f;
        this.OooOo0O = 0.0f;
        this.OooOo0o = 0.0f;
        this.OooOoO0 = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.OooO0O0 = com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0o0;
        this.OooOO0 = new Path();
        Paint paint = new Paint();
        this.OooOO0O = paint;
        paint.setAntiAlias(true);
        this.OooOOo = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(7.0f);
        this.OooOo0 = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(20.0f);
        this.OooOo0O = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(7.0f);
        this.OooOO0O.setStrokeWidth(com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(3.0f));
        setMinimumHeight(com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(100.0f));
        if (isInEditMode()) {
            this.OooOO0o = 1000;
            this.OooOo0o = 1.0f;
            this.OooOo00 = 270;
        } else {
            this.OooOo0o = 0.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.MiniBezierRadarHeader);
        this.OooO = obtainStyledAttributes.getBoolean(R.styleable.MiniBezierRadarHeader_srlEnableHorizontalDrag, this.OooO);
        OooO00o(obtainStyledAttributes.getColor(R.styleable.MiniBezierRadarHeader_srlAccentColor, -1));
        OooO0O0(obtainStyledAttributes.getColor(R.styleable.MiniBezierRadarHeader_srlPrimaryColor, -14540254));
        this.OooO0oO = obtainStyledAttributes.hasValue(R.styleable.MiniBezierRadarHeader_srlAccentColor);
        this.OooO0o = obtainStyledAttributes.hasValue(R.styleable.MiniBezierRadarHeader_srlPrimaryColor);
        obtainStyledAttributes.recycle();
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public int OooO00o(@NonNull OooOOO oooOOO, boolean z) {
        Animator animator = this.OooOo;
        if (animator != null) {
            animator.removeAllListeners();
            this.OooOo.end();
            this.OooOo = null;
        }
        int width = getWidth();
        int i = this.OooOOOO;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.OooOo0, (float) Math.sqrt(((i * i) + (width * width)) * 1.0d));
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new OooO0O0((byte) 3));
        ofFloat.start();
        return 400;
    }

    public OooO00o OooO00o(int i) {
        this.OooO0Oo = i;
        this.OooO0oO = true;
        return this;
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public void OooO00o(float f, int i, int i2) {
        this.OooOOO = i;
        invalidate();
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public void OooO00o(@NonNull OooOOO oooOOO, int i, int i2) {
        this.OooOO0o = i - 1;
        this.OooO0oo = false;
        com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0 oooO0O0 = new com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0(1);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(oooO0O0);
        ofFloat.addUpdateListener(new OooO0O0((byte) 2));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(oooO0O0);
        ofFloat2.addUpdateListener(new OooO0O0((byte) 0));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        ofInt.setDuration(720L);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new OooO0O0((byte) 4));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofInt);
        animatorSet.start();
        int i3 = this.OooOOO0;
        float f = i3;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i3, 0, -((int) (0.8f * f)), 0, -((int) (f * 0.4f)), 0);
        ofInt2.addUpdateListener(new OooO0O0((byte) 1));
        ofInt2.setInterpolator(new com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0(1));
        ofInt2.setDuration(800L);
        ofInt2.start();
        this.OooOo = animatorSet;
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO0o
    public void OooO00o(@NonNull OooOOO oooOOO, @NonNull MiniRefreshState miniRefreshState, @NonNull MiniRefreshState miniRefreshState2) {
        int i = C0034OooO00o.OooO00o[miniRefreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.OooOOOo = 1.0f;
            this.OooOo0o = 0.0f;
            this.OooOOoo = 0.0f;
        }
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public void OooO00o(boolean z, float f, int i, int i2, int i3) {
        this.OooOOOO = i;
        if (z || this.OooO0oo) {
            this.OooO0oo = true;
            this.OooOO0o = Math.min(i2, i);
            this.OooOOO0 = (int) (Math.max(0, i - i2) * 1.9f);
            this.OooOOo0 = f;
            invalidate();
        }
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public boolean OooO00o() {
        return this.OooO;
    }

    public OooO00o OooO0O0(int i) {
        this.OooO0o0 = i;
        this.OooO0o = true;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        int width = getWidth();
        int height = isInEditMode() ? getHeight() : this.OooOOOO;
        this.OooOO0.reset();
        this.OooOO0.lineTo(0.0f, this.OooOO0o);
        Path path = this.OooOO0;
        int i = this.OooOOO;
        float f2 = i >= 0 ? i : width / 2.0f;
        float f3 = width;
        path.quadTo(f2, this.OooOOO0 + r4, f3, this.OooOO0o);
        this.OooOO0.lineTo(f3, 0.0f);
        this.OooOO0O.setColor(this.OooO0o0);
        canvas.drawPath(this.OooOO0, this.OooOO0O);
        if (this.OooOOOo > 0.0f) {
            this.OooOO0O.setColor(this.OooO0Oo);
            float f4 = height;
            float f5 = f4 / com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO0O0;
            float f6 = (f3 * 1.0f) / 7.0f;
            float f7 = this.OooOOo0;
            float f10 = (f6 * f7) - (f7 > 1.0f ? ((f7 - 1.0f) * f6) / f7 : 0.0f);
            float f11 = f4 - (f7 > 1.0f ? (((f7 - 1.0f) * f4) / 2.0f) / f7 : 0.0f);
            int i2 = 0;
            while (i2 < 7) {
                int i3 = i2 + 1;
                int i4 = i2 - 3;
                float f12 = f3;
                this.OooOO0O.setAlpha((int) ((1.0d - (1.0d / Math.pow((f5 / 800.0d) + 1.0d, 15.0d))) * this.OooOOOo * ((float) ((1.0d - ((Math.abs(i4) / 7.0d) * 2.0d)) * 255.0d))));
                float f13 = (1.0f - (1.0f / ((f5 / 10.0f) + 1.0f))) * this.OooOOo;
                canvas.drawCircle((i4 * f10) + ((f12 / 2.0f) - (f13 / 2.0f)), f11 / 2.0f, f13, this.OooOO0O);
                i2 = i3;
                f3 = f12;
            }
            f = f3;
            this.OooOO0O.setAlpha(255);
        } else {
            f = f3;
        }
        if (this.OooOo != null || isInEditMode()) {
            float f14 = this.OooOo0;
            float f15 = this.OooOo0o;
            float f16 = f14 * f15;
            float f17 = this.OooOo0O * f15;
            this.OooOO0O.setColor(this.OooO0Oo);
            Paint paint = this.OooOO0O;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            float f18 = f / 2.0f;
            float f19 = height / 2.0f;
            canvas.drawCircle(f18, f19, f16, this.OooOO0O);
            Paint paint2 = this.OooOO0O;
            Paint.Style style2 = Paint.Style.STROKE;
            paint2.setStyle(style2);
            float f20 = f16 + f17;
            canvas.drawCircle(f18, f19, f20, this.OooOO0O);
            this.OooOO0O.setColor((this.OooO0o0 & 16777215) | 1426063360);
            this.OooOO0O.setStyle(style);
            this.OooOoO0.set(f18 - f16, f19 - f16, f18 + f16, f16 + f19);
            canvas.drawArc(this.OooOoO0, 270.0f, this.OooOo00, true, this.OooOO0O);
            this.OooOO0O.setStyle(style2);
            this.OooOoO0.set(f18 - f20, f19 - f20, f18 + f20, f19 + f20);
            canvas.drawArc(this.OooOoO0, 270.0f, this.OooOo00, false, this.OooOO0O);
            this.OooOO0O.setStyle(style);
        }
        if (this.OooOOoo > 0.0f) {
            this.OooOO0O.setColor(this.OooO0Oo);
            canvas.drawCircle(f / 2.0f, height / 2.0f, this.OooOOoo, this.OooOO0O);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.OooOo;
        if (animator != null) {
            animator.removeAllListeners();
            this.OooOo.end();
            this.OooOo = null;
        }
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !this.OooO0o) {
            this.OooO0o0 = iArr[0];
            this.OooO0o = false;
        }
        if (iArr.length <= 1 || this.OooO0oO) {
            return;
        }
        this.OooO0Oo = iArr[1];
        this.OooO0oO = false;
    }
}
