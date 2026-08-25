package androidx.drawerlayout.widget;

import a1.a;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.b;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;
import org.mvel2.ast.ASTNode;
import z0.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    static final boolean N;
    private static final boolean O;
    private static boolean P = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private CharSequence A;
    private Object B;
    private boolean C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private final ArrayList H;
    private Rect I;
    private Matrix J;
    private final AccessibilityViewCommand K;
    private final d a;
    private float b;
    private int c;
    private int d;
    private float e;
    private Paint f;
    private final ViewDragHelper g;
    private final ViewDragHelper h;
    private final ViewDragCallback i;
    private final ViewDragCallback j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private e s;
    private List t;
    private float u;
    private float v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private CharSequence z;
    private static final int[] L = {R.attr.colorPrimaryDark};
    static final int[] M = {R.attr.layout_gravity};

    static {
        int i = Build.VERSION.SDK_INT;
        N = true;
        O = true;
        P = i >= 29;
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, null);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new d();
        this.d = -1728053248;
        this.f = new Paint();
        this.m = true;
        this.n = 3;
        this.o = 3;
        this.p = 3;
        this.q = 3;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.K = new a(this);
        setDescendantFocusability(ASTNode.BLOCK_FOR);
        float f = getResources().getDisplayMetrics().density;
        this.c = (int) ((64.0f * f) + 0.5f);
        float f2 = f * 400.0f;
        ViewDragCallback viewDragCallback = new ViewDragCallback(this, 3);
        this.i = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(this, 5);
        this.j = viewDragCallback2;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, viewDragCallback);
        this.g = create;
        create.setEdgeTrackingEnabled(1);
        create.setMinVelocity(f2);
        viewDragCallback.d(create);
        ViewDragHelper create2 = ViewDragHelper.create(this, 1.0f, viewDragCallback2);
        this.h = create2;
        create2.setEdgeTrackingEnabled(2);
        create2.setMinVelocity(f2);
        viewDragCallback2.d(create2);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new c(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            setOnApplyWindowInsetsListener(new b(this));
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(L);
            try {
                this.w = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.R.styleable.DrawerLayout, i, 0);
        try {
            if (obtainStyledAttributes2.hasValue(androidx.drawerlayout.R.styleable.DrawerLayout_elevation)) {
                this.b = obtainStyledAttributes2.getDimension(androidx.drawerlayout.R.styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.b = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.H = new ArrayList();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void B(View view) {
        AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_DISMISS;
        ViewCompat.removeAccessibilityAction(view, accessibilityNodeInfoCompat$AccessibilityActionCompat.getId());
        if (!isDrawerOpen(view) || getDrawerLockMode(view) == 2) {
            return;
        }
        ViewCompat.replaceAccessibilityAction(view, accessibilityNodeInfoCompat$AccessibilityActionCompat, null, this.K);
    }

    private void C(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || t(childAt)) && !(z && childAt == view)) {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            }
        }
    }

    private boolean g(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent m = m(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(m);
            m.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent m(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.J == null) {
                this.J = new Matrix();
            }
            matrix.invert(this.J);
            obtain.transform(this.J);
        }
        return obtain;
    }

    static String n(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private static boolean o(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean p() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).getLayoutParams().c) {
                return true;
            }
        }
        return false;
    }

    private boolean q() {
        return j() != null;
    }

    static boolean r(View view) {
        return (ViewCompat.getImportantForAccessibility(view) == 4 || ViewCompat.getImportantForAccessibility(view) == 2) ? false : true;
    }

    private boolean u(float f, float f2, View view) {
        if (this.I == null) {
            this.I = new Rect();
        }
        view.getHitRect(this.I);
        return this.I.contains((int) f, (int) f2);
    }

    private void v(Drawable drawable, int i) {
        if (drawable == null || !a.h(drawable)) {
            return;
        }
        a.m(drawable, i);
    }

    private Drawable x() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.D;
            if (drawable != null) {
                v(drawable, layoutDirection);
                return this.D;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                v(drawable2, layoutDirection);
                return this.E;
            }
        }
        return this.F;
    }

    private Drawable y() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                v(drawable, layoutDirection);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.D;
            if (drawable2 != null) {
                v(drawable2, layoutDirection);
                return this.D;
            }
        }
        return this.G;
    }

    private void z() {
        if (O) {
            return;
        }
        this.x = x();
        this.y = y();
    }

    void A(View view, float f) {
        f layoutParams = view.getLayoutParams();
        if (f == layoutParams.b) {
            return;
        }
        layoutParams.b = f;
        f(view, f);
    }

    void D(int i, View view) {
        int i2;
        int viewDragState = this.g.getViewDragState();
        int viewDragState2 = this.h.getViewDragState();
        if (viewDragState == 1 || viewDragState2 == 1) {
            i2 = 1;
        } else {
            i2 = 2;
            if (viewDragState != 2 && viewDragState2 != 2) {
                i2 = 0;
            }
        }
        if (view != null && i == 0) {
            float f = view.getLayoutParams().b;
            if (f == 0.0f) {
                d(view);
            } else if (f == 1.0f) {
                e(view);
            }
        }
        if (i2 != this.k) {
            this.k = i2;
            List list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.t.get(size)).c(i2);
                }
            }
        }
    }

    void a() {
        if (this.r) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.r = true;
    }

    public void addDrawerListener(@NonNull e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!t(childAt)) {
                this.H.add(childAt);
            } else if (isDrawerOpen(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
        }
        if (!z) {
            int size = this.H.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) this.H.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.H.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (i() != null || t(view)) {
            ViewCompat.setImportantForAccessibility(view, 4);
        } else {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        if (N) {
            return;
        }
        ViewCompat.setAccessibilityDelegate(view, this.a);
    }

    boolean b(View view, int i) {
        return (k(view) & i) == i;
    }

    void c(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            f layoutParams = childAt.getLayoutParams();
            if (t(childAt) && (!z || layoutParams.c)) {
                z2 |= b(childAt, 3) ? this.g.smoothSlideViewTo(childAt, -childAt.getWidth(), childAt.getTop()) : this.h.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                layoutParams.c = false;
            }
        }
        this.i.c();
        this.j.c();
        if (z2) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public void close() {
        closeDrawer(GravityCompat.START);
    }

    public void closeDrawer(int i) {
        closeDrawer(i, true);
    }

    public void closeDrawer(int i, boolean z) {
        View h = h(i);
        if (h != null) {
            closeDrawer(h, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + n(i));
    }

    public void closeDrawer(@NonNull View view) {
        closeDrawer(view, true);
    }

    public void closeDrawer(@NonNull View view, boolean z) {
        if (!t(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f layoutParams = view.getLayoutParams();
        if (this.m) {
            layoutParams.b = 0.0f;
            layoutParams.d = 0;
        } else if (z) {
            layoutParams.d |= 4;
            if (b(view, 3)) {
                this.g.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
            } else {
                this.h.smoothSlideViewTo(view, getWidth(), view.getTop());
            }
        } else {
            w(view, 0.0f);
            D(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void closeDrawers() {
        c(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, getChildAt(i).getLayoutParams().b);
        }
        this.e = f;
        boolean continueSettling = this.g.continueSettling(true);
        boolean continueSettling2 = this.h.continueSettling(true);
        if (continueSettling || continueSettling2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void d(View view) {
        View rootView;
        f layoutParams = view.getLayoutParams();
        if ((layoutParams.d & 1) == 1) {
            layoutParams.d = 0;
            List list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.t.get(size)).b(view);
                }
            }
            C(view, false);
            B(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (u(x, y, childAt) && !s(childAt) && g(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int height = getHeight();
        boolean s = s(view);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (s) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && o(childAt) && t(childAt) && childAt.getHeight() >= height) {
                    if (b(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.e;
        if (f > 0.0f && s) {
            this.f.setColor((this.d & ViewCompat.MEASURED_SIZE_MASK) | (((int) ((((-16777216) & r2) >>> 24) * f)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.f);
        } else if (this.x != null && b(view, 3)) {
            int intrinsicWidth = this.x.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.g.getEdgeSize(), 1.0f));
            this.x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.x.setAlpha((int) (max * 255.0f));
            this.x.draw(canvas);
        } else if (this.y != null && b(view, 5)) {
            int intrinsicWidth2 = this.y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.h.getEdgeSize(), 1.0f));
            this.y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.y.setAlpha((int) (max2 * 255.0f));
            this.y.draw(canvas);
        }
        return drawChild;
    }

    void e(View view) {
        f layoutParams = view.getLayoutParams();
        if ((layoutParams.d & 1) == 0) {
            layoutParams.d = 1;
            List list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.t.get(size)).a(view);
                }
            }
            C(view, true);
            B(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void f(View view, float f) {
        List list = this.t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((e) this.t.get(size)).d(view, f);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public float getDrawerElevation() {
        if (O) {
            return this.b;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (i == 3) {
            int i2 = this.n;
            if (i2 != 3) {
                return i2;
            }
            int i3 = layoutDirection == 0 ? this.p : this.q;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.o;
            if (i4 != 3) {
                return i4;
            }
            int i6 = layoutDirection == 0 ? this.q : this.p;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        }
        if (i == 8388611) {
            int i7 = this.p;
            if (i7 != 3) {
                return i7;
            }
            int i8 = layoutDirection == 0 ? this.n : this.o;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i9 = this.q;
        if (i9 != 3) {
            return i9;
        }
        int i10 = layoutDirection == 0 ? this.o : this.n;
        if (i10 != 3) {
            return i10;
        }
        return 0;
    }

    public int getDrawerLockMode(@NonNull View view) {
        if (t(view)) {
            return getDrawerLockMode(view.getLayoutParams().a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Nullable
    public CharSequence getDrawerTitle(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.z;
        }
        if (absoluteGravity == 5) {
            return this.A;
        }
        return null;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.w;
    }

    View h(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((k(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    View i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt.getLayoutParams().d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public boolean isDrawerOpen(int i) {
        View h = h(i);
        if (h != null) {
            return isDrawerOpen(h);
        }
        return false;
    }

    public boolean isDrawerOpen(@NonNull View view) {
        if (t(view)) {
            return (view.getLayoutParams().d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(int i) {
        View h = h(i);
        if (h != null) {
            return isDrawerVisible(h);
        }
        return false;
    }

    public boolean isDrawerVisible(@NonNull View view) {
        if (t(view)) {
            return view.getLayoutParams().b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isOpen() {
        return isDrawerOpen(GravityCompat.START);
    }

    View j() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (t(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    int k(View view) {
        return GravityCompat.getAbsoluteGravity(view.getLayoutParams().a, ViewCompat.getLayoutDirection(this));
    }

    float l(View view) {
        return view.getLayoutParams().b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.C || this.w == null) {
            return;
        }
        Object obj = this.B;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.w.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.g
            boolean r1 = r1.shouldInterceptTouchEvent(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.h
            boolean r2 = r2.shouldInterceptTouchEvent(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            androidx.customview.widget.ViewDragHelper r7 = r6.g
            boolean r7 = r7.checkTouchSlop(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.i
            r7.c()
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.j
            r7.c()
            goto L36
        L31:
            r6.c(r2)
            r6.r = r3
        L36:
            r7 = r3
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.u = r0
            r6.v = r7
            float r4 = r6.e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            androidx.customview.widget.ViewDragHelper r4 = r6.g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.findTopChildUnder(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.s(r7)
            if (r7 == 0) goto L5d
            r7 = r2
            goto L5e
        L5d:
            r7 = r3
        L5e:
            r6.r = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.p()
            if (r7 != 0) goto L70
            boolean r7 = r6.r
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !q()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View j = j();
        if (j != null && getDrawerLockMode(j) == 0) {
            closeDrawers();
        }
        return j != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        float f;
        int i6;
        boolean z2 = true;
        this.l = true;
        int i7 = i3 - i;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                f layoutParams = childAt.getLayoutParams();
                if (s(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i9, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b(childAt, 3)) {
                        float f2 = measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.b * f2));
                        f = (measuredWidth + i6) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i7 - r11) / f3;
                        i6 = i7 - ((int) (layoutParams.b * f3));
                    }
                    boolean z3 = f != layoutParams.b ? z2 : false;
                    int i10 = layoutParams.a & 112;
                    if (i10 == 16) {
                        int i11 = i4 - i2;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i14 > i11 - i15) {
                                i12 = (i11 - i15) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i6, i16, measuredWidth + i6, measuredHeight + i16);
                    } else {
                        int i17 = i4 - i2;
                        childAt.layout(i6, (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z3) {
                        A(childAt, f);
                    }
                    int i18 = layoutParams.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
            i8++;
            z2 = true;
        }
        if (P && (rootWindowInsets = getRootWindowInsets()) != null) {
            c systemGestureInsets = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets).getSystemGestureInsets();
            ViewDragHelper viewDragHelper = this.g;
            viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.a));
            ViewDragHelper viewDragHelper2 = this.h;
            viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets.c));
        }
        this.l = false;
        this.m = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z = this.B != null && ViewCompat.getFitsSystemWindows(this);
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int childCount = getChildCount();
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f layoutParams = childAt.getLayoutParams();
                if (z) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.a, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.B;
                        if (absoluteGravity == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.B;
                        if (absoluteGravity == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (s(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else {
                    if (!t(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (O) {
                        float elevation = ViewCompat.getElevation(childAt);
                        float f = this.b;
                        if (elevation != f) {
                            ViewCompat.setElevation(childAt, f);
                        }
                    }
                    int k = k(childAt) & 7;
                    boolean z4 = k == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + n(k) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.c + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View h;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.openDrawerGravity;
        if (i != 0 && (h = h(i)) != null) {
            openDrawer(h);
        }
        int i2 = savedState.lockModeLeft;
        if (i2 != 3) {
            setDrawerLockMode(i2, 3);
        }
        int i3 = savedState.lockModeRight;
        if (i3 != 3) {
            setDrawerLockMode(i3, 5);
        }
        int i4 = savedState.lockModeStart;
        if (i4 != 3) {
            setDrawerLockMode(i4, GravityCompat.START);
        }
        int i6 = savedState.lockModeEnd;
        if (i6 != 3) {
            setDrawerLockMode(i6, GravityCompat.END);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        z();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            f layoutParams = getChildAt(i).getLayoutParams();
            int i2 = layoutParams.d;
            boolean z = i2 == 1;
            boolean z2 = i2 == 2;
            if (z || z2) {
                savedState.openDrawerGravity = layoutParams.a;
                break;
            }
        }
        savedState.lockModeLeft = this.n;
        savedState.lockModeRight = this.o;
        savedState.lockModeStart = this.p;
        savedState.lockModeEnd = this.q;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if (getDrawerLockMode(r7) != 2) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.g
            r0.processTouchEvent(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.h
            r0.processTouchEvent(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5f
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6d
        L1a:
            r6.c(r2)
            r6.r = r1
            goto L6d
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.findTopChildUnder(r4, r5)
            if (r3 == 0) goto L5a
            boolean r3 = r6.s(r3)
            if (r3 == 0) goto L5a
            float r3 = r6.u
            float r0 = r0 - r3
            float r3 = r6.v
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.g
            int r3 = r3.getTouchSlop()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5a
            android.view.View r7 = r6.i()
            if (r7 == 0) goto L5a
            int r7 = r6.getDrawerLockMode(r7)
            r0 = 2
            if (r7 != r0) goto L5b
        L5a:
            r1 = r2
        L5b:
            r6.c(r1)
            goto L6d
        L5f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.u = r0
            r6.v = r7
            r6.r = r1
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void open() {
        openDrawer(GravityCompat.START);
    }

    public void openDrawer(int i) {
        openDrawer(i, true);
    }

    public void openDrawer(int i, boolean z) {
        View h = h(i);
        if (h != null) {
            openDrawer(h, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + n(i));
    }

    public void openDrawer(@NonNull View view) {
        openDrawer(view, true);
    }

    public void openDrawer(@NonNull View view, boolean z) {
        if (!t(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f layoutParams = view.getLayoutParams();
        if (this.m) {
            layoutParams.b = 1.0f;
            layoutParams.d = 1;
            C(view, true);
            B(view);
        } else if (z) {
            layoutParams.d |= 2;
            if (b(view, 3)) {
                this.g.smoothSlideViewTo(view, 0, view.getTop());
            } else {
                this.h.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            w(view, 1.0f);
            D(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void removeDrawerListener(@NonNull e eVar) {
        List list;
        if (eVar == null || (list = this.t) == null) {
            return;
        }
        list.remove(eVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            c(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.l) {
            return;
        }
        super.requestLayout();
    }

    boolean s(View view) {
        return view.getLayoutParams().a == 0;
    }

    public void setChildInsets(Object obj, boolean z) {
        this.B = obj;
        this.C = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.b = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (t(childAt)) {
                ViewCompat.setElevation(childAt, this.b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.s;
        if (eVar2 != null) {
            removeDrawerListener(eVar2);
        }
        if (eVar != null) {
            addDrawerListener(eVar);
        }
        this.s = eVar;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        View h;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
        if (i2 == 3) {
            this.n = i;
        } else if (i2 == 5) {
            this.o = i;
        } else if (i2 == 8388611) {
            this.p = i;
        } else if (i2 == 8388613) {
            this.q = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.g : this.h).cancel();
        }
        if (i != 1) {
            if (i == 2 && (h = h(absoluteGravity)) != null) {
                openDrawer(h);
                return;
            }
            return;
        }
        View h2 = h(absoluteGravity);
        if (h2 != null) {
            closeDrawer(h2);
        }
    }

    public void setDrawerLockMode(int i, @NonNull View view) {
        if (t(view)) {
            setDrawerLockMode(i, view.getLayoutParams().a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(b.getDrawable(getContext(), i), i2);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (O) {
            return;
        }
        if ((i & GravityCompat.START) == 8388611) {
            this.D = drawable;
        } else if ((i & GravityCompat.END) == 8388613) {
            this.E = drawable;
        } else if ((i & 3) == 3) {
            this.F = drawable;
        } else if ((i & 5) != 5) {
            return;
        } else {
            this.G = drawable;
        }
        z();
        invalidate();
    }

    public void setDrawerTitle(int i, @Nullable CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.z = charSequence;
        } else if (absoluteGravity == 5) {
            this.A = charSequence;
        }
    }

    public void setScrimColor(int i) {
        this.d = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.w = i != 0 ? b.getDrawable(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.w = new ColorDrawable(i);
        invalidate();
    }

    boolean t(View view) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(view.getLayoutParams().a, ViewCompat.getLayoutDirection(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    void w(View view, float f) {
        float l = l(view);
        float width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (l * width));
        if (!b(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        A(view, f);
    }
}
