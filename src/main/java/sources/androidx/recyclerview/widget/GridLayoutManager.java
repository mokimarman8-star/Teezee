package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean a;
    int b;
    int[] c;
    View[] d;
    final SparseIntArray e;
    final SparseIntArray f;
    c g;
    final Rect h;
    private boolean i;

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        c0(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        c0(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = false;
        this.b = -1;
        this.e = new SparseIntArray();
        this.f = new SparseIntArray();
        this.g = new a();
        this.h = new Rect();
        c0(RecyclerView.m.getProperties(context, attributeSet, i, i2).b);
    }

    private void K(RecyclerView.t tVar, RecyclerView.x xVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i6 = 0;
        if (z) {
            i4 = 1;
            i3 = i;
            i2 = 0;
        } else {
            i2 = i - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View view = this.d[i2];
            b layoutParams = view.getLayoutParams();
            int X = X(tVar, xVar, getPosition(view));
            layoutParams.b = X;
            layoutParams.a = i6;
            i6 += X;
            i2 += i4;
        }
    }

    private void L() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b layoutParams = getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.e.put(viewLayoutPosition, layoutParams.b());
            this.f.put(viewLayoutPosition, layoutParams.a());
        }
    }

    private void M(int i) {
        this.c = N(this.c, this.b, i);
    }

    static int[] N(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i6 = i2 / i;
        int i7 = i2 % i;
        int i8 = 0;
        for (int i9 = 1; i9 <= i; i9++) {
            i4 += i7;
            if (i4 <= 0 || i - i4 >= i7) {
                i3 = i6;
            } else {
                i3 = i6 + 1;
                i4 -= i;
            }
            i8 += i3;
            iArr[i9] = i8;
        }
        return iArr;
    }

    private void O() {
        this.e.clear();
        this.f.clear();
    }

    private int P(RecyclerView.x xVar) {
        if (getChildCount() != 0 && xVar.b() != 0) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                int b = this.g.b(getPosition(findFirstVisibleChildClosestToStart), this.b);
                int b2 = this.g.b(getPosition(findFirstVisibleChildClosestToEnd), this.b);
                int max = this.mShouldReverseLayout ? Math.max(0, ((this.g.b(xVar.b() - 1, this.b) + 1) - Math.max(b, b2)) - 1) : Math.max(0, Math.min(b, b2));
                if (isSmoothScrollbarEnabled) {
                    return Math.round((max * (Math.abs(this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)) / ((this.g.b(getPosition(findFirstVisibleChildClosestToEnd), this.b) - this.g.b(getPosition(findFirstVisibleChildClosestToStart), this.b)) + 1))) + (this.mOrientationHelper.m() - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)));
                }
                return max;
            }
        }
        return 0;
    }

    private int Q(RecyclerView.x xVar) {
        if (getChildCount() != 0 && xVar.b() != 0) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.g.b(xVar.b() - 1, this.b) + 1;
                }
                int d = this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart);
                int b = this.g.b(getPosition(findFirstVisibleChildClosestToStart), this.b);
                return (int) ((d / ((this.g.b(getPosition(findFirstVisibleChildClosestToEnd), this.b) - b) + 1)) * (this.g.b(xVar.b() - 1, this.b) + 1));
            }
        }
        return 0;
    }

    private void R(RecyclerView.t tVar, RecyclerView.x xVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int W = W(tVar, xVar, aVar.b);
        if (z) {
            while (W > 0) {
                int i2 = aVar.b;
                if (i2 <= 0) {
                    return;
                }
                int i3 = i2 - 1;
                aVar.b = i3;
                W = W(tVar, xVar, i3);
            }
            return;
        }
        int b = xVar.b() - 1;
        int i4 = aVar.b;
        while (i4 < b) {
            int i6 = i4 + 1;
            int W2 = W(tVar, xVar, i6);
            if (W2 <= W) {
                break;
            }
            i4 = i6;
            W = W2;
        }
        aVar.b = i4;
    }

    private void S() {
        View[] viewArr = this.d;
        if (viewArr == null || viewArr.length != this.b) {
            this.d = new View[this.b];
        }
    }

    private int V(RecyclerView.t tVar, RecyclerView.x xVar, int i) {
        if (!xVar.e()) {
            return this.g.b(i, this.b);
        }
        int f = tVar.f(i);
        if (f != -1) {
            return this.g.b(f, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int W(RecyclerView.t tVar, RecyclerView.x xVar, int i) {
        if (!xVar.e()) {
            return this.g.c(i, this.b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int f = tVar.f(i);
        if (f != -1) {
            return this.g.c(f, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int X(RecyclerView.t tVar, RecyclerView.x xVar, int i) {
        if (!xVar.e()) {
            return this.g.f(i);
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int f = tVar.f(i);
        if (f != -1) {
            return this.g.f(f);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void Z(float f, int i) {
        M(Math.max(Math.round(f * this.b), i));
    }

    private void a0(View view, int i, boolean z) {
        int i2;
        int i3;
        b layoutParams = view.getLayoutParams();
        Rect rect = ((RecyclerView.n) layoutParams).mDecorInsets;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i6 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int T = T(layoutParams.a, layoutParams.b);
        if (this.mOrientation == 1) {
            i3 = RecyclerView.m.getChildMeasureSpec(T, i, i6, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i2 = RecyclerView.m.getChildMeasureSpec(this.mOrientationHelper.n(), getHeightMode(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec = RecyclerView.m.getChildMeasureSpec(T, i, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec2 = RecyclerView.m.getChildMeasureSpec(this.mOrientationHelper.n(), getWidthMode(), i6, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i2 = childMeasureSpec;
            i3 = childMeasureSpec2;
        }
        b0(view, i3, i2, z);
    }

    private void b0(View view, int i, int i2, boolean z) {
        RecyclerView.n layoutParams = view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, i, i2, layoutParams) : shouldMeasureChild(view, i, i2, layoutParams)) {
            view.measure(i, i2);
        }
    }

    private void e0() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        M(height - paddingTop);
    }

    int T(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.c;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.c;
        int i3 = this.b;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public int U() {
        return this.b;
    }

    public c Y() {
        return this.g;
    }

    public void c0(int i) {
        if (i == this.b) {
            return;
        }
        this.a = true;
        if (i >= 1) {
            this.b = i;
            this.g.h();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public boolean checkLayoutParams(RecyclerView.n nVar) {
        return nVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.x xVar, LinearLayoutManager.c cVar, RecyclerView.m.c cVar2) {
        int i = this.b;
        for (int i2 = 0; i2 < this.b && cVar.c(xVar) && i > 0; i2++) {
            int i3 = cVar.d;
            cVar2.a(i3, Math.max(0, cVar.g));
            i -= this.g.f(i3);
            cVar.d += cVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.x xVar) {
        return this.i ? P(xVar) : super.computeHorizontalScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int computeHorizontalScrollRange(RecyclerView.x xVar) {
        return this.i ? Q(xVar) : super.computeHorizontalScrollRange(xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int computeVerticalScrollOffset(RecyclerView.x xVar) {
        return this.i ? P(xVar) : super.computeVerticalScrollOffset(xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int computeVerticalScrollRange(RecyclerView.x xVar) {
        return this.i ? Q(xVar) : super.computeVerticalScrollRange(xVar);
    }

    public void d0(c cVar) {
        this.g = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.t tVar, RecyclerView.x xVar, boolean z, boolean z2) {
        int i;
        int i2;
        int childCount = getChildCount();
        int i3 = 1;
        if (z2) {
            i2 = getChildCount() - 1;
            i = -1;
            i3 = -1;
        } else {
            i = childCount;
            i2 = 0;
        }
        int b = xVar.b();
        ensureLayoutState();
        int m = this.mOrientationHelper.m();
        int i4 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        while (i2 != i) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < b && W(tVar, xVar, position) == 0) {
                if (childAt.getLayoutParams().isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.g(childAt) < i4 && this.mOrientationHelper.d(childAt) >= m) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i3;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public RecyclerView.n generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    public RecyclerView.n generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public RecyclerView.n generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public int getColumnCountForAccessibility(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.mOrientation == 1) {
            return this.b;
        }
        if (xVar.b() < 1) {
            return 0;
        }
        return V(tVar, xVar, xVar.b() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.mOrientation == 0) {
            return this.b;
        }
        if (xVar.b() < 1) {
            return 0;
        }
        return V(tVar, xVar, xVar.b() - 1) + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        r21.b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void layoutChunk(androidx.recyclerview.widget.RecyclerView.t r18, androidx.recyclerview.widget.RecyclerView.x r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.layoutChunk(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void onAnchorReady(RecyclerView.t tVar, RecyclerView.x xVar, LinearLayoutManager.a aVar, int i) {
        super.onAnchorReady(tVar, xVar, aVar, i);
        e0();
        if (xVar.b() > 0 && !xVar.e()) {
            R(tVar, xVar, aVar, i);
        }
        S();
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f1, code lost:
    
        if (r13 == (r2 > r7)) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.t r26, androidx.recyclerview.widget.RecyclerView.x r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView.t tVar, RecyclerView.x xVar, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(tVar, xVar, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.t tVar, RecyclerView.x xVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        b layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        b bVar = layoutParams;
        int V = V(tVar, xVar, bVar.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(bVar.a(), bVar.b(), V, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(V, 1, bVar.a(), bVar.b(), false, false));
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.g.h();
        this.g.g();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.g.h();
        this.g.g();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.g.h();
        this.g.g();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.g.h();
        this.g.g();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.g.h();
        this.g.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (xVar.e()) {
            L();
        }
        super.onLayoutChildren(tVar, xVar);
        O();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onLayoutCompleted(RecyclerView.x xVar) {
        super.onLayoutCompleted(xVar);
        this.a = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        e0();
        S();
        return super.scrollHorizontallyBy(i, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        e0();
        S();
        return super.scrollVerticallyBy(i, tVar, xVar);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        if (this.c == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.m.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.c;
            chooseSize = RecyclerView.m.chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.m.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.c;
            chooseSize2 = RecyclerView.m.chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.a;
    }
}
