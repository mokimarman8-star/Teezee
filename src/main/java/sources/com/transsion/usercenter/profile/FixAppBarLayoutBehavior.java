package com.transsion.usercenter.profile;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.transsion.usercenter.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class FixAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private View A;
    private d B;
    private int C;
    private int D;
    private boolean E;
    private VelocityTracker F;
    private int G;
    private RecyclerView H;
    private boolean q;
    private boolean r;
    private float s;
    private float t;
    private int u;
    private int v;
    private int w;
    private int[] x;
    private View y;
    private ViewPager2 z;

    class a extends AppBarLayout.Behavior.a {
        a() {
        }

        public boolean a(AppBarLayout appBarLayout) {
            return true;
        }
    }

    class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        public void onPageSelected(int i) {
            super.onPageSelected(i);
            View childAt = FixAppBarLayoutBehavior.this.z.getChildAt(i);
            if (childAt != null) {
                FixAppBarLayoutBehavior.this.F0(childAt);
            }
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FixAppBarLayoutBehavior.this.r = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public interface d {
        void a(float f, boolean z);
    }

    public FixAppBarLayoutBehavior() {
        this.r = false;
        this.x = null;
        this.C = -1;
        this.D = -1;
        this.E = false;
        R0();
    }

    public FixAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = false;
        this.x = null;
        this.C = -1;
        this.D = -1;
        this.E = false;
        R0();
    }

    private void D0() {
        ViewPager2 viewPager2 = this.z;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new b());
        }
    }

    private boolean E0() {
        RecyclerView.m layoutManager;
        RecyclerView recyclerView = this.H;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return true;
        }
        View findViewByPosition = layoutManager.findViewByPosition(0);
        return findViewByPosition != null && findViewByPosition.getTop() >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                RecyclerView childAt = viewGroup.getChildAt(i);
                if (childAt instanceof RecyclerView) {
                    this.H = childAt;
                }
            }
        }
    }

    private boolean H0() {
        return this.y != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(AppBarLayout appBarLayout, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.y.setScaleX(floatValue);
        this.y.setScaleY(floatValue);
        O0(appBarLayout, (int) ((1.0f - valueAnimator.getAnimatedFraction()) * this.u));
        if (this.B != null) {
            this.B.a(Math.min((floatValue - 1.0f) / 0.3f, 1.0f), true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r0 != 3) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean M0(AppBarLayout appBarLayout, MotionEvent motionEvent) {
        float f;
        int actionMasked = motionEvent.getActionMasked();
        if (this.D < 0) {
            this.D = ViewConfiguration.get(appBarLayout.getContext()).getScaledTouchSlop();
        }
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.F;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.F.computeCurrentVelocity(1000);
                    f = this.F.getYVelocity(this.C);
                } else {
                    f = 0.0f;
                }
                this.q = f <= 100.0f;
                P0(appBarLayout);
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.C);
                if (findPointerIndex < 0) {
                    wf.a.a.i("FixAppBarLayoutBehavior", "Error processing scroll; pointer index for id " + this.C + " not found. Did any MotionEvents get skipped?", false);
                } else {
                    int y = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    int i = this.G - y;
                    if (!this.E) {
                        int abs = Math.abs(i);
                        int i2 = this.D;
                        if (abs > i2) {
                            this.E = true;
                            i = i > 0 ? i - i2 : i + i2;
                        }
                    }
                    if (this.E) {
                        this.G = y;
                        if (G0(y)) {
                            return Q0(appBarLayout, appBarLayout, i);
                        }
                        if (E0()) {
                            return Q0(appBarLayout, appBarLayout, i);
                        }
                    }
                }
            }
            this.E = false;
            this.C = -1;
            VelocityTracker velocityTracker2 = this.F;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.F = null;
            }
        } else {
            this.C = motionEvent.getPointerId(0);
            this.G = (int) (motionEvent.getY() + 0.5f);
            if (this.F == null) {
                this.F = VelocityTracker.obtain();
            }
        }
        VelocityTracker velocityTracker3 = this.F;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return false;
    }

    private void O0(ViewGroup viewGroup, int i) {
        int childCount = viewGroup.getChildCount();
        int[] iArr = this.x;
        if (iArr == null || iArr.length != childCount) {
            this.x = new int[childCount];
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null) {
                    this.x[i2] = childAt.getTop();
                } else {
                    this.x[i2] = -1;
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = viewGroup.getChildAt(i3);
            if (childAt2.getId() != R$id.toolbar) {
                if (childAt2.getId() == R$id.collapsing) {
                    O0((ViewGroup) childAt2, i);
                } else if (this.x[i3] >= 0) {
                    childAt2.getMeasuredHeight();
                    childAt2.setTranslationY(i);
                }
            }
        }
        ViewPager2 viewPager2 = this.z;
        if (viewPager2 != null) {
            viewPager2.setTranslationY(i);
        }
    }

    private void P0(final AppBarLayout appBarLayout) {
        if (!H0() || this.r || this.t <= 0.0f) {
            return;
        }
        this.r = true;
        this.t = 0.0f;
        if (this.q) {
            ValueAnimator duration = ValueAnimator.ofFloat(this.s, 1.0f).setDuration(300L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.usercenter.profile.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FixAppBarLayoutBehavior.this.I0(appBarLayout, valueAnimator);
                }
            });
            duration.addListener(new c());
            duration.start();
            return;
        }
        this.y.setScaleX(1.0f);
        this.y.setScaleY(1.0f);
        O0(appBarLayout, 0);
        this.r = false;
        d dVar = this.B;
        if (dVar != null) {
            dVar.a(0.0f, true);
        }
    }

    private boolean Q0(AppBarLayout appBarLayout, View view, int i) {
        if (this.r || !H0() || ((i >= 0 || appBarLayout.getBottom() < this.v) && (i <= 0 || appBarLayout.getBottom() <= this.v))) {
            return false;
        }
        float f = this.t + (-i);
        this.t = f;
        float min = Math.min(f, 500.0f);
        this.t = min;
        float max = Math.max(1.0f, (min / 500.0f) + 1.0f);
        this.s = max;
        this.u = (int) ((this.w / 2) * (max - 1.0f));
        this.y.setScaleX(max);
        this.y.setScaleY(this.s);
        O0(appBarLayout, this.u);
        view.setScrollY(0);
        if (this.B == null) {
            return true;
        }
        this.B.a(Math.min((this.s - 1.0f) / 0.3f, 1.0f), false);
        return true;
    }

    private void R0() {
        u0(new a());
    }

    private void T0(int i, AppBarLayout appBarLayout, View view, int i2) {
        if (i2 == 1) {
            int E = E();
            if ((i >= 0 || E != 0) && (i <= 0 || E != (-appBarLayout.getTotalScrollRange()))) {
                return;
            }
            ViewCompat.stopNestedScroll(view, 1);
        }
    }

    public boolean G0(int i) {
        View view = this.A;
        return view == null || i < view.getTop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        if (r0 != 3) goto L35;
     */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        int findPointerIndex;
        wf.a.a.c("FixAppBarLayoutBehavior", "---onInterceptTouchEvent isOnInterceptTouchEvent: " + super.k(coordinatorLayout, appBarLayout, motionEvent), false);
        if (!H0()) {
            return super.k(coordinatorLayout, appBarLayout, motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.D < 0) {
            this.D = ViewConfiguration.get(appBarLayout.getContext()).getScaledTouchSlop();
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.C;
                    if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                        int y = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                        if (Math.abs(this.G - y) > this.D) {
                            this.E = true;
                            this.G = y;
                            return true;
                        }
                    }
                }
            }
            this.E = false;
            this.C = -1;
            VelocityTracker velocityTracker = this.F;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.F = null;
            }
        } else {
            this.E = false;
            if (coordinatorLayout.isPointInChildBounds(appBarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.C = motionEvent.getPointerId(0);
                this.G = (int) (motionEvent.getY() + 0.5f);
                if (this.F == null) {
                    this.F = VelocityTracker.obtain();
                }
            }
        }
        VelocityTracker velocityTracker2 = this.F;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return super.k(coordinatorLayout, appBarLayout, motionEvent);
    }

    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public boolean o(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2) {
        if (f2 > 100.0f) {
            this.q = false;
        }
        return super/*androidx.coordinatorlayout.widget.CoordinatorLayout.c*/.o(coordinatorLayout, appBarLayout, view, f, f2);
    }

    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        super/*androidx.coordinatorlayout.widget.CoordinatorLayout.c*/.s(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        T0(i4, appBarLayout, view, i5);
    }

    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public boolean D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        wf.a.a.c("FixAppBarLayoutBehavior", appBarLayout.getScrollY() + "   onTouchEvent " + motionEvent.toString(), false);
        if (H0() && M0(appBarLayout, motionEvent)) {
            return true;
        }
        return super.D(coordinatorLayout, appBarLayout, motionEvent);
    }

    public void S0(d dVar) {
        this.B = dVar;
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        boolean k0 = super.k0(coordinatorLayout, appBarLayout, i);
        if (this.y == null) {
            View findViewWithTag = coordinatorLayout.findViewWithTag("largeScale");
            this.y = findViewWithTag;
            if (findViewWithTag != null) {
                appBarLayout.setClipChildren(false);
                this.w = this.y.getHeight();
            }
        }
        if (this.z == null) {
            this.z = coordinatorLayout.findViewWithTag("viewPager");
            D0();
        }
        if (this.A == null) {
            this.A = coordinatorLayout.findViewWithTag("emptyView");
        }
        this.v = appBarLayout.getHeight();
        this.x = null;
        return k0;
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (E0() && Q0(appBarLayout, view, i2)) {
            return;
        }
        super.m0(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        T0(i2, appBarLayout, view, i3);
    }

    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        this.q = true;
        return super.q0(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        if (H0()) {
            P0(appBarLayout);
        }
        super.r0(coordinatorLayout, appBarLayout, view, i);
    }
}
