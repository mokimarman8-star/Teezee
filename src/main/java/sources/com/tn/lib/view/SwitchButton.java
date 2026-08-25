package com.tn.lib.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.tn.lib.widget.R;
import com.tn.lib.widget.R$style;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class SwitchButton extends View implements View.OnClickListener {
    private float a;
    private int b;
    private int c;
    private int d;
    private Paint e;
    private Paint f;
    private int g;
    private int h;
    private int i;
    private float j;
    private RectF k;
    private int l;
    private boolean m;
    private float n;
    private State o;
    private d p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;

    private enum State {
        OPEN,
        CLOSE
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwitchButton.this.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SwitchButton.this.postInvalidate();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwitchButton.this.b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SwitchButton.this.f.setColor(SwitchButton.this.b);
            SwitchButton.this.postInvalidate();
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwitchButton.this.setClickable(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SwitchButton.this.setClickable(false);
        }
    }

    public interface d {
        void a(SwitchButton switchButton, boolean z);
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 10.0f;
        this.u = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwitchView, i, R$style.def_switch_view);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.SwitchView_switch_bg_color) {
                this.b = obtainStyledAttributes.getColor(index, -16777216);
            } else if (index == R.styleable.SwitchView_switch_ball_color) {
                this.d = obtainStyledAttributes.getColor(index, -16777216);
            } else if (index == R.styleable.SwitchView_switch_checked_bg_color) {
                this.c = obtainStyledAttributes.getColor(index, -16777216);
            } else if (index == R.styleable.SwitchView_switch_radius) {
                this.j = obtainStyledAttributes.getInteger(index, 10);
            } else if (index == R.styleable.SwitchView_switch_gradient_start_color) {
                this.s = obtainStyledAttributes.getColor(index, -16777216);
            } else if (index == R.styleable.SwitchView_switch_gradient_end_color) {
                this.t = obtainStyledAttributes.getColor(index, -16777216);
            }
        }
        obtainStyledAttributes.recycle();
        i();
    }

    private void e(int i, int i2, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, i2);
        ofFloat.addUpdateListener(new a());
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i3), Integer.valueOf(i4));
        ofObject.addUpdateListener(new b());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofObject);
        animatorSet.setDuration(50L);
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    private Paint f(int i, int i2, Paint.Style style, int i3) {
        Paint paint = new Paint(1);
        paint.setColor(i);
        paint.setStrokeWidth(i3);
        paint.setDither(true);
        paint.setTextSize(i2);
        paint.setStyle(style);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        return paint;
    }

    private void g(Canvas canvas) {
        this.e.setColor(this.d);
        canvas.drawCircle(this.n, this.i, this.j, this.e);
    }

    private void h(Canvas canvas) {
        if (this.o != State.OPEN) {
            RectF rectF = this.k;
            int i = this.i;
            canvas.drawRoundRect(rectF, i, i, this.f);
        } else {
            Paint paint = new Paint();
            paint.setShader(new LinearGradient(0.0f, 0.0f, this.h, 0.0f, this.s, this.t, Shader.TileMode.CLAMP));
            RectF rectF2 = this.k;
            int i2 = this.i;
            canvas.drawRoundRect(rectF2, i2, i2, paint);
        }
    }

    private void i() {
        this.q = this.b;
        this.r = this.c;
        int i = this.d;
        Paint.Style style = Paint.Style.FILL;
        this.e = f(i, 0, style, 0);
        this.f = f(this.b, 0, style, 0);
        this.o = State.CLOSE;
        setOnClickListener(this);
        this.f.setColor(this.b);
        this.j = zg.h.a.a(getContext(), this.j);
    }

    public boolean isChecked() {
        return this.m;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.u) {
            State state = this.o;
            State state2 = State.CLOSE;
            State state3 = state == state2 ? State.OPEN : state2;
            this.o = state3;
            if (state3 == state2) {
                e(this.l, this.i, this.r, this.q);
            } else {
                e(this.i, this.l, this.q, this.r);
            }
            d dVar = this.p;
            if (dVar != null) {
                dVar.a(this, this.o == State.OPEN);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        h(canvas);
        g(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 44.0f, getResources().getDisplayMetrics()), MemoryConstants.GB);
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()), MemoryConstants.GB);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.g = i2;
        this.h = i;
        this.a = (i * 1.0f) / 30.0f;
        int i5 = i2 / 2;
        this.i = i5;
        int i6 = i - i5;
        this.l = i6;
        this.n = this.m ? i6 : i5;
        this.k = new RectF(0.0f, 0.0f, this.h, this.g);
    }

    public void setChecked(boolean z) {
        this.m = z;
        State state = z ? State.OPEN : State.CLOSE;
        if (this.o == state) {
            return;
        }
        this.o = state;
        if (z && this.l == 0) {
            this.n = zg.h.a.a(getContext(), 32.0f);
            int i = this.r;
            this.b = i;
            this.f.setColor(i);
            postInvalidate();
        } else if (state == State.CLOSE) {
            e(this.l, this.i, this.r, this.q);
        } else {
            e(this.i, this.l, this.q, this.r);
        }
        d dVar = this.p;
        if (dVar != null) {
            dVar.a(this, this.o == State.OPEN);
        }
    }

    public void setColor(Integer num, Integer num2, Integer num3) {
        this.q = num.intValue();
        this.r = num2.intValue();
        this.d = num3.intValue();
        this.e.setColor(num3.intValue());
        postInvalidate();
    }

    public void setEnable(boolean z) {
        this.u = z;
    }

    public void setGradientColors(int i, int i2, Integer num) {
        this.s = i;
        this.t = i2;
        this.d = num.intValue();
        postInvalidate();
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.p = dVar;
    }
}
