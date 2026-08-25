package com.tn.lib.view.bubbleview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BubbleGradientConstrainLayout extends ConstraintLayout {
    private final String a;
    private BubbleDrawable b;
    private float c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private BubbleDrawable.ArrowLocation k;
    private BubbleDrawable.GradientDirection l;
    private int m;
    private boolean n;
    private int[] o;
    private float[] p;
    private int q;
    private int r;
    private int s;
    private ObjectAnimator t;
    private ObjectAnimator u;
    private AnimatorSet v;
    private boolean w;

    class a implements Animator.AnimatorListener {
        final /* synthetic */ float a;
        final /* synthetic */ ViewGroup.MarginLayoutParams b;
        final /* synthetic */ int c;

        a(float f, ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            this.a = f;
            this.b = marginLayoutParams;
            this.c = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            BubbleGradientConstrainLayout.this.setX(this.a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.b;
            marginLayoutParams.leftMargin = this.c;
            BubbleGradientConstrainLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BubbleGradientConstrainLayout.this.setX(this.a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.b;
            marginLayoutParams.leftMargin = this.c;
            BubbleGradientConstrainLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public BubbleGradientConstrainLayout(Context context) {
        super(context);
        this.a = "BubbleGradientLinearLayout";
        l(null);
    }

    public BubbleGradientConstrainLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "BubbleGradientLinearLayout";
        l(attributeSet);
    }

    private void i() {
        ObjectAnimator objectAnimator = this.t;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.t.cancel();
    }

    private static int j(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private float[] k(BubbleDrawable.GradientDirection gradientDirection) {
        return gradientDirection == BubbleDrawable.GradientDirection.getDefault() ? new float[]{0.0f, 0.0f, 0.0f, getHeight()} : new float[]{0.0f, 0.0f, getWidth(), 0.0f};
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l(AttributeSet attributeSet) {
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleView);
            this.c = obtainStyledAttributes.getDimension(R.styleable.BubbleView_shadowRadius, BubbleDrawable.b.A);
            this.d = obtainStyledAttributes.getColor(R.styleable.BubbleView_shadowColor, BubbleDrawable.b.B);
            this.e = obtainStyledAttributes.getDimension(R.styleable.BubbleView_shadowOffsetX, BubbleDrawable.b.C);
            this.f = obtainStyledAttributes.getDimension(R.styleable.BubbleView_shadowOffsetY, BubbleDrawable.b.C);
            this.g = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowWidth, BubbleDrawable.b.u);
            this.i = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowHeight, BubbleDrawable.b.v);
            this.h = obtainStyledAttributes.getDimension(R.styleable.BubbleView_angle, BubbleDrawable.b.w);
            this.j = obtainStyledAttributes.getDimension(R.styleable.BubbleView_arrowPosition, BubbleDrawable.b.x);
            this.m = obtainStyledAttributes.getColor(R.styleable.BubbleView_bubbleColor, BubbleDrawable.b.y);
            this.q = obtainStyledAttributes.getColor(R.styleable.BubbleView_gradientStartColor, BubbleDrawable.b.y);
            this.r = obtainStyledAttributes.getColor(R.styleable.BubbleView_gradientEndColor, BubbleDrawable.b.y);
            this.s = obtainStyledAttributes.getColor(R.styleable.BubbleView_gradientCenterColor, -1);
            this.w = obtainStyledAttributes.getBoolean(R.styleable.BubbleView_isOpenAnimator, false);
            this.k = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R.styleable.BubbleView_arrowLocation, 0));
            this.l = BubbleDrawable.GradientDirection.mapIntToValue(obtainStyledAttributes.getInt(R.styleable.BubbleView_gradient_orientation, 0));
            this.n = obtainStyledAttributes.getBoolean(R.styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
            int i = this.s;
            if (i > 0) {
                this.o = new int[]{this.q, i, this.r};
            } else {
                this.o = new int[]{this.q, this.r};
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m() {
        n(getWidth(), getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void n(int i, int i2) {
        o((int) ((getPaddingLeft() + this.c) - this.e), (int) (((i - getPaddingRight()) - this.c) - this.e), (int) ((getPaddingTop() + this.c) - this.f), (int) (((i2 - getPaddingBottom()) - this.c) - this.f));
        setBackgroundDrawable(this.b);
    }

    private void o(int i, int i2, int i3, int i4) {
        if (i2 < i || i4 < i3) {
            return;
        }
        RectF rectF = new RectF(i, i3, i2, i4);
        this.p = k(this.l);
        BubbleDrawable.b u = new BubbleDrawable.b().B(rectF).t(this.k).z(BubbleDrawable.BubbleType.SHADER).q(this.h).s(this.i).v(this.g).u(this.j);
        float[] fArr = this.p;
        this.b = u.y(fArr[0], fArr[1], fArr[2], fArr[3], this.o).r(this.n).F(this.c).C(this.d).D(this.e).E(this.f).A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        startTransAnim();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super/*android.view.ViewGroup*/.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        n(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLocation(BubbleDrawable.ArrowLocation arrowLocation) {
        this.k = arrowLocation;
        n(getWidth(), getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setUpBubbleDrawable() {
        setBackgroundDrawable(null);
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleGradientConstrainLayout.1
            /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.tn.lib.view.bubbleview.BubbleGradientConstrainLayout] */
            @Override // java.lang.Runnable
            public void run() {
                ?? r0 = BubbleGradientConstrainLayout.this;
                r0.n(r0.getWidth(), BubbleGradientConstrainLayout.this.getHeight());
            }
        });
    }

    public void setmArrowPosition(float f) {
        this.j = f;
        m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startShowRemindAnim() {
        AnimatorSet animatorSet = this.v;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.v = null;
        }
        this.v = new AnimatorSet();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        float x = getX();
        int i = marginLayoutParams.leftMargin;
        if (this.u == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", x - (Math.abs(i) + j(getContext(), 4.0f)), j(getContext(), 4.0f) + x, x - (Math.abs(marginLayoutParams.leftMargin) + j(getContext(), 4.0f)));
            this.u = ofFloat;
            ofFloat.setDuration(100L);
            this.u.setInterpolator(new LinearInterpolator());
            this.u.setRepeatCount(1);
            this.u.addListener(new a(x, marginLayoutParams, i));
        }
        this.v.play(this.u).with(this.t);
        this.v.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startTransAnim() {
        if (this.w) {
            if (this.t == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", getY(), getY() - j(getContext(), 6.0f), getY());
                this.t = ofFloat;
                ofFloat.setDuration(ToastStrategy.SHORT_DURATION_TIMEOUT);
                this.t.setInterpolator(new LinearInterpolator());
                this.t.setRepeatCount(-1);
            }
            if (this.t.isStarted()) {
                return;
            }
            this.t.start();
        }
    }
}
