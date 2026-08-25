package androidx.appcompat.widget;

import android.R;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.l;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import org.mvel2.ast.ASTNode;
import z0.c;

@SuppressLint({"UnknownNullness"})
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements s, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    static final int[] G = {R$attr.actionBarSize, R.attr.windowContentOverlay};
    private static final WindowInsetsCompat H = new WindowInsetsCompat.Builder().setSystemWindowInsets(c.c(0, 1, 0, 1)).build();
    private static final Rect I = new Rect();
    ViewPropertyAnimator A;
    final AnimatorListenerAdapter B;
    private final Runnable C;
    private final Runnable D;
    private final NestedScrollingParentHelper E;
    private final d F;
    private int a;
    private int b;
    private ContentFrameLayout c;
    ActionBarContainer d;
    private t e;
    private Drawable f;
    private boolean g;
    private boolean h;
    private boolean i;
    boolean j;
    private int k;
    private int l;
    private final Rect m;
    private final Rect n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private WindowInsetsCompat u;
    private WindowInsetsCompat v;
    private WindowInsetsCompat w;
    private WindowInsetsCompat x;
    private b y;
    private OverScroller z;

    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.m = new Rect();
        this.n = new Rect();
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.u = windowInsetsCompat;
        this.v = windowInsetsCompat;
        this.w = windowInsetsCompat;
        this.x = windowInsetsCompat;
        this.B = new a(this);
        this.C = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.f();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.A = actionBarOverlayLayout.d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.B);
            }
        };
        this.D = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.f();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.A = actionBarOverlayLayout.d.animate().translationY(-ActionBarOverlayLayout.this.d.getHeight()).setListener(ActionBarOverlayLayout.this.B);
            }
        };
        g(context);
        this.E = new NestedScrollingParentHelper(this);
        d dVar = new d(context);
        this.F = dVar;
        addView(dVar);
    }

    private void a() {
        f();
        this.D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$c r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.c) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = r0
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = r0
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = r0
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.b(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    private boolean c() {
        ViewCompat.computeSystemWindowInsets(this.F, H, this.p);
        return !this.p.equals(I);
    }

    private t e(View view) {
        if (view instanceof t) {
            return (t) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void g(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        this.a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.z = new OverScroller(context);
    }

    private void h() {
        f();
        postDelayed(this.D, 600L);
    }

    private void i() {
        f();
        postDelayed(this.C, 600L);
    }

    private void k() {
        f();
        this.C.run();
    }

    private boolean l(float f) {
        this.z.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.z.getFinalY() > this.d.getHeight();
    }

    public boolean canShowOverflowMenu() {
        j();
        return this.e.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    public void dismissPopups() {
        j();
        this.e.k();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.f != null) {
            int bottom = this.d.getVisibility() == 0 ? (int) (this.d.getBottom() + this.d.getTranslationY() + 0.5f) : 0;
            this.f.setBounds(0, bottom, getWidth(), this.f.getIntrinsicHeight() + bottom);
            this.f.draw(canvas);
        }
    }

    void f() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    @Override // android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.E.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        j();
        return this.e.getTitle();
    }

    public boolean hasIcon() {
        j();
        return this.e.f();
    }

    public boolean hasLogo() {
        j();
        return this.e.q();
    }

    public boolean hideOverflowMenu() {
        j();
        return this.e.hideOverflowMenu();
    }

    public void initFeature(int i) {
        j();
        if (i == 2) {
            this.e.i();
        } else if (i == 5) {
            this.e.s();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.i;
    }

    public boolean isInOverlayMode() {
        return this.g;
    }

    public boolean isOverflowMenuShowPending() {
        j();
        return this.e.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        j();
        return this.e.isOverflowMenuShowing();
    }

    void j() {
        if (this.c == null) {
            this.c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.e = e(findViewById(R$id.action_bar));
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        j();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, this);
        boolean b = b(this.d, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, windowInsetsCompat, this.m);
        Rect rect = this.m;
        WindowInsetsCompat inset = windowInsetsCompat.inset(rect.left, rect.top, rect.right, rect.bottom);
        this.u = inset;
        boolean z = true;
        if (!this.v.equals(inset)) {
            this.v = this.u;
            b = true;
        }
        if (this.n.equals(this.m)) {
            z = b;
        } else {
            this.n.set(this.m);
        }
        if (z) {
            requestLayout();
        }
        return windowInsetsCompat.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                c layoutParams = childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        j();
        measureChildWithMargins(this.d, i, 0, i2, 0);
        c layoutParams = this.d.getLayoutParams();
        int max = Math.max(0, this.d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & ASTNode.COLLECTION) != 0;
        if (z) {
            measuredHeight = this.a;
            if (this.h && this.d.getTabContainer() != null) {
                measuredHeight += this.a;
            }
        } else {
            measuredHeight = this.d.getVisibility() != 8 ? this.d.getMeasuredHeight() : 0;
        }
        this.o.set(this.m);
        this.w = this.u;
        if (this.g || z || !c()) {
            this.w = new WindowInsetsCompat.Builder(this.w).setSystemWindowInsets(c.c(this.w.getSystemWindowInsetLeft(), this.w.getSystemWindowInsetTop() + measuredHeight, this.w.getSystemWindowInsetRight(), this.w.getSystemWindowInsetBottom())).build();
        } else {
            Rect rect = this.o;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.w = this.w.inset(0, measuredHeight, 0, 0);
        }
        b(this.c, this.o, true, true, true, true);
        if (!this.x.equals(this.w)) {
            WindowInsetsCompat windowInsetsCompat = this.w;
            this.x = windowInsetsCompat;
            ViewCompat.dispatchApplyWindowInsets(this.c, windowInsetsCompat);
        }
        measureChildWithMargins(this.c, i, 0, i2, 0);
        c layoutParams2 = this.c.getLayoutParams();
        int max3 = Math.max(max, this.c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.i || !z) {
            return false;
        }
        if (l(f2)) {
            a();
        } else {
            k();
        }
        this.j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i6 = this.k + i2;
        this.k = i6;
        setActionBarHideOffset(i6);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i6, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.E.onNestedScrollAccepted(view, view2, i);
        this.k = getActionBarHideOffset();
        f();
        b bVar = this.y;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.d.getVisibility() != 0) {
            return false;
        }
        return this.i;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        if (this.i && !this.j) {
            if (this.k <= this.d.getHeight()) {
                i();
            } else {
                h();
            }
        }
        b bVar = this.y;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        j();
        int i2 = this.l ^ i;
        this.l = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & ASTNode.COLLECTION) != 0;
        b bVar = this.y;
        if (bVar != null) {
            bVar.d(!z2);
            if (z || !z2) {
                this.y.a();
            } else {
                this.y.e();
            }
        }
        if ((i2 & ASTNode.COLLECTION) == 0 || this.y == null) {
            return;
        }
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.b = i;
        b bVar = this.y;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        j();
        this.e.p(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        j();
        this.e.m(sparseArray);
    }

    public void setActionBarHideOffset(int i) {
        f();
        this.d.setTranslationY(-Math.max(0, Math.min(i, this.d.getHeight())));
    }

    public void setActionBarVisibilityCallback(b bVar) {
        this.y = bVar;
        if (getWindowToken() != null) {
            this.y.b(this.b);
            int i = this.l;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.h = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.i) {
            this.i = z;
            if (z) {
                return;
            }
            f();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        j();
        this.e.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        j();
        this.e.setIcon(drawable);
    }

    public void setLogo(int i) {
        j();
        this.e.n(i);
    }

    public void setMenu(Menu menu, l.a aVar) {
        j();
        this.e.setMenu(menu, aVar);
    }

    public void setMenuPrepared() {
        j();
        this.e.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.g = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        j();
        this.e.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        j();
        this.e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        j();
        return this.e.showOverflowMenu();
    }
}
