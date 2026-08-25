package androidx.core.view.insets;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class Protection {
    private static final long DEFAULT_DURATION_IN = 333;
    private static final long DEFAULT_DURATION_OUT = 166;
    private final a mAttributes = new a();
    private Object mController;
    private z0.c mInsets;
    private z0.c mInsetsIgnoringVisibility;
    private final int mSide;
    private float mSystemAlpha;
    private float mSystemInsetAmount;
    private float mUserAlpha;
    private ValueAnimator mUserAlphaAnimator;
    private float mUserInsetAmount;
    private ValueAnimator mUserInsetAmountAnimator;
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_IN = new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_OUT = new PathInterpolator(0.6f, 0.0f, 1.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_IN = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_OUT = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f7251a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f7252b = -1;

        /* renamed from: c, reason: collision with root package name */
        private z0.c f7253c = z0.c.f18717e;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7254d = false;

        /* renamed from: e, reason: collision with root package name */
        private Drawable f7255e = null;

        /* renamed from: f, reason: collision with root package name */
        private float f7256f = 0.0f;

        /* renamed from: g, reason: collision with root package name */
        private float f7257g = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        private float f7258h = 1.0f;

        /* renamed from: i, reason: collision with root package name */
        private InterfaceC0052a f7259i;

        /* renamed from: androidx.core.view.insets.Protection$a$a, reason: collision with other inner class name */
        interface InterfaceC0052a {
            void a(int i5);

            void b(z0.c cVar);

            void c(float f5);

            void d(int i5);

            void e(float f5);

            void f(float f5);

            void g(Drawable drawable);

            void onVisibilityChanged(boolean z5);
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A(int i5) {
            if (this.f7251a != i5) {
                this.f7251a = i5;
                InterfaceC0052a interfaceC0052a = this.f7259i;
                if (interfaceC0052a != null) {
                    interfaceC0052a.d(i5);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f5) {
            if (this.f7258h != f5) {
                this.f7258h = f5;
                InterfaceC0052a interfaceC0052a = this.f7259i;
                if (interfaceC0052a != null) {
                    interfaceC0052a.c(f5);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(Drawable drawable) {
            this.f7255e = drawable;
            InterfaceC0052a interfaceC0052a = this.f7259i;
            if (interfaceC0052a != null) {
                interfaceC0052a.g(drawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(int i5) {
            if (this.f7252b != i5) {
                this.f7252b = i5;
                InterfaceC0052a interfaceC0052a = this.f7259i;
                if (interfaceC0052a != null) {
                    interfaceC0052a.a(i5);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(z0.c cVar) {
            if (this.f7253c.equals(cVar)) {
                return;
            }
            this.f7253c = cVar;
            InterfaceC0052a interfaceC0052a = this.f7259i;
            if (interfaceC0052a != null) {
                interfaceC0052a.b(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(float f5) {
            if (this.f7256f != f5) {
                this.f7256f = f5;
                InterfaceC0052a interfaceC0052a = this.f7259i;
                if (interfaceC0052a != null) {
                    interfaceC0052a.e(f5);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y(float f5) {
            if (this.f7257g != f5) {
                this.f7257g = f5;
                InterfaceC0052a interfaceC0052a = this.f7259i;
                if (interfaceC0052a != null) {
                    interfaceC0052a.f(f5);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(boolean z5) {
            if (this.f7254d != z5) {
                this.f7254d = z5;
                InterfaceC0052a interfaceC0052a = this.f7259i;
                if (interfaceC0052a != null) {
                    interfaceC0052a.onVisibilityChanged(z5);
                }
            }
        }

        float k() {
            return this.f7258h;
        }

        Drawable l() {
            return this.f7255e;
        }

        int m() {
            return this.f7252b;
        }

        z0.c n() {
            return this.f7253c;
        }

        float o() {
            return this.f7256f;
        }

        float p() {
            return this.f7257g;
        }

        int q() {
            return this.f7251a;
        }

        boolean r() {
            return this.f7254d;
        }

        void t(InterfaceC0052a interfaceC0052a) {
            if (this.f7259i != null && interfaceC0052a != null) {
                throw new IllegalStateException("Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?");
            }
            this.f7259i = interfaceC0052a;
        }
    }

    public Protection(int i5) {
        z0.c cVar = z0.c.f18717e;
        this.mInsets = cVar;
        this.mInsetsIgnoringVisibility = cVar;
        this.mSystemAlpha = 1.0f;
        this.mUserAlpha = 1.0f;
        this.mSystemInsetAmount = 1.0f;
        this.mUserInsetAmount = 1.0f;
        this.mController = null;
        this.mUserAlphaAnimator = null;
        this.mUserInsetAmountAnimator = null;
        if (i5 == 1 || i5 == 2 || i5 == 4 || i5 == 8) {
            this.mSide = i5;
            return;
        }
        throw new IllegalArgumentException("Unexpected side: " + i5);
    }

    private void cancelUserAlphaAnimation() {
        ValueAnimator valueAnimator = this.mUserAlphaAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mUserAlphaAnimator = null;
        }
    }

    private void cancelUserInsetsAmountAnimation() {
        ValueAnimator valueAnimator = this.mUserInsetAmountAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mUserInsetAmountAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateAlpha$0(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateInsetsAmount$1(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void setAlphaInternal(float f5) {
        this.mUserAlpha = f5;
        updateAlpha();
    }

    private void setInsetAmountInternal(float f5) {
        this.mUserInsetAmount = f5;
        updateInsetAmount();
    }

    private void updateAlpha() {
        this.mAttributes.s(this.mSystemAlpha * this.mUserAlpha);
    }

    private void updateInsetAmount() {
        float f5 = this.mUserInsetAmount * this.mSystemInsetAmount;
        int i5 = this.mSide;
        if (i5 == 1) {
            this.mAttributes.x((-(1.0f - f5)) * r1.f7251a);
            return;
        }
        if (i5 == 2) {
            this.mAttributes.y((-(1.0f - f5)) * r1.f7252b);
        } else if (i5 == 4) {
            this.mAttributes.x((1.0f - f5) * r1.f7251a);
        } else {
            if (i5 != 8) {
                return;
            }
            this.mAttributes.y((1.0f - f5) * r1.f7252b);
        }
    }

    public void animateAlpha(float f5) {
        cancelUserAlphaAnimation();
        float f6 = this.mUserAlpha;
        if (f5 == f6) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f6, f5);
        this.mUserAlphaAnimator = ofFloat;
        if (this.mUserAlpha < f5) {
            ofFloat.setDuration(DEFAULT_DURATION_IN);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_IN);
        } else {
            ofFloat.setDuration(DEFAULT_DURATION_OUT);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_OUT);
        }
        this.mUserAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.insets.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Protection.this.lambda$animateAlpha$0(valueAnimator);
            }
        });
        this.mUserAlphaAnimator.start();
    }

    public void animateInsetsAmount(float f5) {
        cancelUserInsetsAmountAnimation();
        float f6 = this.mUserInsetAmount;
        if (f5 == f6) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f6, f5);
        this.mUserInsetAmountAnimator = ofFloat;
        if (this.mUserInsetAmount < f5) {
            ofFloat.setDuration(DEFAULT_DURATION_IN);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_IN);
        } else {
            ofFloat.setDuration(DEFAULT_DURATION_OUT);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_OUT);
        }
        this.mUserInsetAmountAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.insets.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Protection.this.lambda$animateInsetsAmount$1(valueAnimator);
            }
        });
        this.mUserInsetAmountAnimator.start();
    }

    void dispatchColorHint(int i5) {
    }

    z0.c dispatchInsets(z0.c cVar, z0.c cVar2, z0.c cVar3) {
        this.mInsets = cVar;
        this.mInsetsIgnoringVisibility = cVar2;
        this.mAttributes.w(cVar3);
        return updateLayout();
    }

    public float getAlpha() {
        return this.mUserAlpha;
    }

    a getAttributes() {
        return this.mAttributes;
    }

    Object getController() {
        return this.mController;
    }

    public float getInsetAmount() {
        return this.mUserInsetAmount;
    }

    public int getSide() {
        return this.mSide;
    }

    int getThickness(int i5) {
        return i5;
    }

    boolean occupiesCorners() {
        return false;
    }

    public void setAlpha(float f5) {
        if (f5 >= 0.0f && f5 <= 1.0f) {
            cancelUserAlphaAnimation();
            setAlphaInternal(f5);
        } else {
            throw new IllegalArgumentException("Alpha must in a range of [0, 1]. Got: " + f5);
        }
    }

    void setController(Object obj) {
        this.mController = obj;
    }

    void setDrawable(Drawable drawable) {
        this.mAttributes.u(drawable);
    }

    public void setInsetAmount(float f5) {
        if (f5 >= 0.0f && f5 <= 1.0f) {
            cancelUserInsetsAmountAnimation();
            setInsetAmountInternal(f5);
        } else {
            throw new IllegalArgumentException("Inset amount must in a range of [0, 1]. Got: " + f5);
        }
    }

    void setSystemAlpha(float f5) {
        this.mSystemAlpha = f5;
        updateAlpha();
    }

    void setSystemInsetAmount(float f5) {
        this.mSystemInsetAmount = f5;
        updateInsetAmount();
    }

    void setSystemVisible(boolean z5) {
        this.mAttributes.z(z5);
    }

    z0.c updateLayout() {
        int i5;
        z0.c cVar = z0.c.f18717e;
        int i6 = this.mSide;
        if (i6 == 1) {
            i5 = this.mInsets.f18718a;
            this.mAttributes.A(getThickness(this.mInsetsIgnoringVisibility.f18718a));
            if (occupiesCorners()) {
                cVar = z0.c.c(getThickness(i5), 0, 0, 0);
            }
        } else if (i6 == 2) {
            i5 = this.mInsets.f18719b;
            this.mAttributes.v(getThickness(this.mInsetsIgnoringVisibility.f18719b));
            if (occupiesCorners()) {
                cVar = z0.c.c(0, getThickness(i5), 0, 0);
            }
        } else if (i6 == 4) {
            i5 = this.mInsets.f18720c;
            this.mAttributes.A(getThickness(this.mInsetsIgnoringVisibility.f18720c));
            if (occupiesCorners()) {
                cVar = z0.c.c(0, 0, getThickness(i5), 0);
            }
        } else if (i6 != 8) {
            i5 = 0;
        } else {
            i5 = this.mInsets.f18721d;
            this.mAttributes.v(getThickness(this.mInsetsIgnoringVisibility.f18721d));
            if (occupiesCorners()) {
                cVar = z0.c.c(0, 0, 0, getThickness(i5));
            }
        }
        setSystemVisible(i5 > 0);
        setSystemAlpha(i5 > 0 ? 1.0f : 0.0f);
        setSystemInsetAmount(i5 > 0 ? 1.0f : 0.0f);
        return cVar;
    }
}
