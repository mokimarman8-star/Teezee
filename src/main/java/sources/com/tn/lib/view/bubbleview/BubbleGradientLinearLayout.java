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
import android.widget.LinearLayout;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.tn.lib.view.bubbleview.BubbleDrawable;
import com.tn.lib.widget.R;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BubbleGradientLinearLayout extends LinearLayout {
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
            BubbleGradientLinearLayout.this.setX(this.a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.b;
            marginLayoutParams.leftMargin = this.c;
            BubbleGradientLinearLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BubbleGradientLinearLayout.this.setX(this.a);
            ViewGroup.MarginLayoutParams marginLayoutParams = this.b;
            marginLayoutParams.leftMargin = this.c;
            BubbleGradientLinearLayout.this.setLayoutParams(marginLayoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BubbleDrawable.GradientDirection.values().length];
            a = iArr;
            try {
                iArr[BubbleDrawable.GradientDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BubbleDrawable.GradientDirection.TOP_LEFT_BOTTOM_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BubbleDrawable.GradientDirection.TOP_RIGHT_BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BubbleDrawable.GradientDirection.BOTTOM_LEFT_TOP_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[BubbleDrawable.GradientDirection.BOTTOM_RIGHT_TOP_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BubbleGradientLinearLayout(Context context) {
        super(context);
        this.a = "BubbleGradientLinearLayout";
        e(null);
    }

    public BubbleGradientLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "BubbleGradientLinearLayout";
        e(attributeSet);
    }

    private void b() {
        ObjectAnimator objectAnimator = this.t;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.t.cancel();
    }

    private static int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private float[] d(BubbleDrawable.GradientDirection gradientDirection) {
        int i = b.a[gradientDirection.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? new float[]{0.0f, 0.0f, 0.0f, getHeight()} : new float[]{getWidth(), getHeight(), 0.0f, 0.0f} : new float[]{0.0f, getHeight(), getWidth(), 0.0f} : new float[]{getWidth(), 0.0f, 0.0f, getHeight()} : new float[]{0.0f, 0.0f, getWidth(), getHeight()} : new float[]{0.0f, 0.0f, getWidth(), 0.0f};
    }

    private void e(AttributeSet attributeSet) {
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
            this.s = obtainStyledAttributes.getColor(R.styleable.BubbleView_gradientCenterColor, BubbleDrawable.b.y);
            this.w = obtainStyledAttributes.getBoolean(R.styleable.BubbleView_isOpenAnimator, false);
            this.k = BubbleDrawable.ArrowLocation.mapIntToValue(obtainStyledAttributes.getInt(R.styleable.BubbleView_arrowLocation, 0));
            this.l = BubbleDrawable.GradientDirection.mapIntToValue(obtainStyledAttributes.getInt(R.styleable.BubbleView_gradient_orientation, 0));
            this.n = obtainStyledAttributes.getBoolean(R.styleable.BubbleView_arrowCenter, false);
            obtainStyledAttributes.recycle();
            int i = this.s;
            if (i != BubbleDrawable.b.y) {
                this.o = new int[]{this.q, i, this.r};
            } else {
                this.o = new int[]{this.q, this.r};
            }
        }
    }

    private void f() {
        g(getWidth(), getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, int i2) {
        h((int) ((getPaddingLeft() + this.c) - this.e), (int) (((i - getPaddingRight()) - this.c) - this.e), (int) ((getPaddingTop() + this.c) - this.f), (int) (((i2 - getPaddingBottom()) - this.c) - this.f));
        setBackgroundDrawable(this.b);
    }

    private void h(int i, int i2, int i3, int i4) {
        if (i2 < i || i4 < i3) {
            return;
        }
        RectF rectF = new RectF(i, i3, i2, i4);
        this.p = d(this.l);
        BubbleDrawable.b u = new BubbleDrawable.b().B(rectF).t(this.k).z(BubbleDrawable.BubbleType.SHADER).q(this.h).s(this.i).v(this.g).u(this.j);
        float[] fArr = this.p;
        this.b = u.y(fArr[0], fArr[1], fArr[2], fArr[3], this.o).r(this.n).F(this.c).C(this.d).D(this.e).E(this.f).A();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startTransAnim();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        g(i, i2);
    }

    public void setGradientColors(int i, int i2, int i3) {
        this.q = i;
        this.r = i2;
        this.s = i3;
        f();
    }

    public void setLocation(BubbleDrawable.ArrowLocation arrowLocation) {
        this.k = arrowLocation;
        g(getWidth(), getHeight());
    }

    public void setUpBubbleDrawable() {
        setBackgroundDrawable(null);
        post(new Runnable() { // from class: com.tn.lib.view.bubbleview.BubbleGradientLinearLayout.1
            @Override // java.lang.Runnable
            public void run() {
                BubbleGradientLinearLayout bubbleGradientLinearLayout = BubbleGradientLinearLayout.this;
                bubbleGradientLinearLayout.g(bubbleGradientLinearLayout.getWidth(), BubbleGradientLinearLayout.this.getHeight());
            }
        });
    }

    public void setmArrowPosition(float f) {
        this.j = f;
        f();
    }

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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", x - (Math.abs(i) + c(getContext(), 4.0f)), c(getContext(), 4.0f) + x, x - (Math.abs(marginLayoutParams.leftMargin) + c(getContext(), 4.0f)));
            this.u = ofFloat;
            ofFloat.setDuration(100L);
            this.u.setInterpolator(new LinearInterpolator());
            this.u.setRepeatCount(1);
            this.u.addListener(new a(x, marginLayoutParams, i));
        }
        this.v.play(this.u).with(this.t);
        this.v.start();
    }

    public void startTransAnim() {
        if (this.w) {
            if (this.t == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", getY(), getY() - c(getContext(), 6.0f), getY());
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
