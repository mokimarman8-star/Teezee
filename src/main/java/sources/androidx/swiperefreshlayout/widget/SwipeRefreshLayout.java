package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.b;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.j;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent3, NestedScrollingParent2, NestedScrollingChild3, NestedScrollingChild2, NestedScrollingParent, NestedScrollingChild {
    public static final int DEFAULT = 1;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    public static final int LARGE = 0;
    private static final String P = "SwipeRefreshLayout";
    private static final int[] Q = {R.attr.enabled};
    int A;
    int B;
    b C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    private Animation H;
    boolean I;
    private int J;
    boolean K;
    private boolean L;
    private Animation.AnimationListener M;
    private final Animation N;
    private final Animation O;
    private View a;
    j b;
    boolean c;
    private int d;
    private float e;
    private float f;
    private final NestedScrollingParentHelper g;
    private final NestedScrollingChildHelper h;
    private final int[] i;
    private final int[] j;
    private final int[] k;
    private boolean l;
    private int m;
    int n;
    private float o;
    private float p;
    private boolean q;
    private int r;
    boolean s;
    private boolean t;
    private final DecelerateInterpolator u;
    a v;
    private int w;
    protected int x;
    float y;
    protected int z;

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.e = -1.0f;
        this.i = new int[2];
        this.j = new int[2];
        this.k = new int[2];
        this.r = -1;
        this.w = -1;
        this.M = new a(this);
        this.N = new f(this);
        this.O = new g(this);
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.m = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.J = (int) (displayMetrics.density * 40.0f);
        c();
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.A = i;
        this.e = i;
        this.g = new NestedScrollingParentHelper(this);
        this.h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.J;
        this.n = i2;
        this.z = i2;
        h(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Q);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void a(int i, Animation.AnimationListener animationListener) {
        this.x = i;
        this.N.reset();
        this.N.setDuration(200L);
        this.N.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.b(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.N);
    }

    private void b(int i, Animation.AnimationListener animationListener) {
        if (this.s) {
            q(i, animationListener);
            return;
        }
        this.x = i;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.b(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.O);
    }

    private void c() {
        this.v = new a(getContext());
        b bVar = new b(getContext());
        this.C = bVar;
        bVar.l(1);
        this.v.setImageDrawable(this.C);
        this.v.setVisibility(8);
        addView(this.v);
    }

    private void d() {
        if (this.a == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.v)) {
                    this.a = childAt;
                    return;
                }
            }
        }
    }

    private void e(float f) {
        if (f > this.e) {
            k(true, true);
            return;
        }
        this.c = false;
        this.C.j(0.0f, 0.0f);
        b(this.n, !this.s ? new e(this) : null);
        this.C.d(false);
    }

    private boolean f(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void g(float f) {
        this.C.d(true);
        float min = Math.min(1.0f, Math.abs(f / this.e));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.e;
        int i = this.B;
        if (i <= 0) {
            i = this.K ? this.A - this.z : this.A;
        }
        float f2 = i;
        double max2 = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i2 = this.z + ((int) ((f2 * min) + (f2 * pow * 2.0f)));
        if (this.v.getVisibility() != 0) {
            this.v.setVisibility(0);
        }
        if (!this.s) {
            this.v.setScaleX(1.0f);
            this.v.setScaleY(1.0f);
        }
        if (this.s) {
            setAnimationProgress(Math.min(1.0f, f / this.e));
        }
        if (f < this.e) {
            if (this.C.getAlpha() > 76 && !f(this.F)) {
                o();
            }
        } else if (this.C.getAlpha() < 255 && !f(this.G)) {
            n();
        }
        this.C.j(0.0f, Math.min(0.8f, max * 0.8f));
        this.C.e(Math.min(1.0f, max));
        this.C.g((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i2 - this.n);
    }

    private void i(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            this.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void k(boolean z, boolean z2) {
        if (this.c != z) {
            this.I = z2;
            d();
            this.c = z;
            if (z) {
                a(this.n, this.M);
            } else {
                p(this.M);
            }
        }
    }

    private Animation l(int i, int i2) {
        Animation dVar = new d(this, i, i2);
        dVar.setDuration(300L);
        this.v.b((Animation.AnimationListener) null);
        this.v.clearAnimation();
        this.v.startAnimation(dVar);
        return dVar;
    }

    private void m(float f) {
        float f2 = this.p;
        float f3 = f - f2;
        int i = this.d;
        if (f3 <= i || this.q) {
            return;
        }
        this.o = f2 + i;
        this.q = true;
        this.C.setAlpha(76);
    }

    private void n() {
        this.G = l(this.C.getAlpha(), 255);
    }

    private void o() {
        this.F = l(this.C.getAlpha(), 76);
    }

    private void q(int i, Animation.AnimationListener animationListener) {
        this.x = i;
        this.y = this.v.getScaleX();
        h hVar = new h(this);
        this.H = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.v.b(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.H);
    }

    private void r(Animation.AnimationListener animationListener) {
        this.v.setVisibility(0);
        this.C.setAlpha(255);
        b bVar = new b(this);
        this.D = bVar;
        bVar.setDuration(this.m);
        if (animationListener != null) {
            this.v.b(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.D);
    }

    private void setColorViewAlpha(int i) {
        this.v.getBackground().setAlpha(i);
        this.C.setAlpha(i);
    }

    public boolean canChildScrollUp() {
        View view = this.a;
        return view instanceof ListView ? j.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.h.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.h.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.h.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return i3 == 0 && dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i6, @NonNull int[] iArr2) {
        if (i6 == 0) {
            this.h.dispatchNestedScroll(i, i2, i3, i4, iArr, i6, iArr2);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.h.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i6) {
        return i6 == 0 && this.h.dispatchNestedScroll(i, i2, i3, i4, iArr, i6);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.w;
        return i3 < 0 ? i2 : i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.g.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.J;
    }

    public int getProgressViewEndOffset() {
        return this.A;
    }

    public int getProgressViewStartOffset() {
        return this.z;
    }

    void h(float f) {
        setTargetOffsetTopAndBottom((this.x + ((int) ((this.z - r0) * f))) - this.v.getTop());
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.h.hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return i == 0 && hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.h.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.c;
    }

    void j() {
        this.v.clearAnimation();
        this.C.stop();
        this.v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.z - this.n);
        }
        this.n = this.v.getTop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d();
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || canChildScrollUp() || this.c || this.l) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.r;
                    if (i == -1) {
                        Log.e(P, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    m(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        i(motionEvent);
                    }
                }
            }
            this.q = false;
            this.r = -1;
        } else {
            setTargetOffsetTopAndBottom(this.z - this.v.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.r = pointerId;
            this.q = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.p = motionEvent.getY(findPointerIndex2);
        }
        return this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.a == null) {
            d();
        }
        View view = this.a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.v.getMeasuredWidth();
        int measuredHeight2 = this.v.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.n;
        this.v.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a == null) {
            d();
        }
        View view = this.a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.v.measure(View.MeasureSpec.makeMeasureSpec(this.J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.J, 1073741824));
        this.w = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.v) {
                this.w = i3;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.f;
            if (f > 0.0f) {
                float f2 = i2;
                if (f2 > f) {
                    iArr[1] = (int) f;
                    this.f = 0.0f;
                } else {
                    this.f = f - f2;
                    iArr[1] = i2;
                }
                g(this.f);
            }
        }
        if (this.K && i2 > 0 && this.f == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.v.setVisibility(8);
        }
        int[] iArr2 = this.i;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.k);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i6) {
        onNestedScroll(view, i, i2, i3, i4, i6, this.k);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i6, @NonNull int[] iArr) {
        if (i6 != 0) {
            return;
        }
        int i7 = iArr[1];
        dispatchNestedScroll(i, i2, i3, i4, this.j, i6, iArr);
        int i8 = i4 - (iArr[1] - i7);
        if ((i8 == 0 ? i4 + this.j[1] : i8) >= 0 || canChildScrollUp()) {
            return;
        }
        float abs = this.f + Math.abs(r1);
        this.f = abs;
        g(abs);
        iArr[1] = iArr[1] + i8;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.g.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.f = 0.0f;
        this.l = true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.c);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.t || this.c || (i & 2) == 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            return onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.g.onStopNestedScroll(view);
        this.l = false;
        float f = this.f;
        if (f > 0.0f) {
            e(f);
            this.f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || canChildScrollUp() || this.c || this.l) {
            return false;
        }
        if (actionMasked == 0) {
            this.r = motionEvent.getPointerId(0);
            this.q = false;
        } else {
            if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.r);
                if (findPointerIndex < 0) {
                    Log.e(P, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.q) {
                    float y = (motionEvent.getY(findPointerIndex) - this.o) * 0.5f;
                    this.q = false;
                    e(y);
                }
                this.r = -1;
                return false;
            }
            if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
                if (findPointerIndex2 < 0) {
                    Log.e(P, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(findPointerIndex2);
                m(y2);
                if (this.q) {
                    float f = (y2 - this.o) * 0.5f;
                    if (f <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    g(f);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(P, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.r = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    i(motionEvent);
                }
            }
        }
        return true;
    }

    void p(Animation.AnimationListener animationListener) {
        c cVar = new c(this);
        this.E = cVar;
        cVar.setDuration(150L);
        this.v.b(animationListener);
        this.v.clearAnimation();
        this.v.startAnimation(this.E);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent;
        View view = this.a;
        if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        } else {
            if (this.L || (parent = getParent()) == null) {
                return;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    void setAnimationProgress(float f) {
        this.v.setScaleX(f);
        this.v.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        d();
        this.C.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = b.getColor(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.e = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        j();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z) {
        this.L = z;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.h.setNestedScrollingEnabled(z);
    }

    public void setOnChildScrollUpCallback(@Nullable i iVar) {
    }

    public void setOnRefreshListener(@Nullable j jVar) {
        this.b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.v.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(b.getColor(getContext(), i));
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.A = i;
        this.s = z;
        this.v.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.s = z;
        this.z = i;
        this.A = i2;
        this.K = true;
        j();
        this.c = false;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.c == z) {
            k(z, false);
            return;
        }
        this.c = z;
        setTargetOffsetTopAndBottom((!this.K ? this.A + this.z : this.A) - this.n);
        this.I = false;
        r(this.M);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.J = (int) (displayMetrics.density * 40.0f);
            }
            this.v.setImageDrawable(null);
            this.C.l(i);
            this.v.setImageDrawable(this.C);
        }
    }

    public void setSlingshotDistance(int i) {
        this.B = i;
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.v.bringToFront();
        ViewCompat.offsetTopAndBottom(this.v, i);
        this.n = this.v.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.h.startNestedScroll(i);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return i2 == 0 && startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.h.stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        if (i == 0) {
            stopNestedScroll();
        }
    }
}
