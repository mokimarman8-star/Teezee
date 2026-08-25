package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class LinearLayoutManager extends RecyclerView.m implements RecyclerView.w.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    m mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() != 1 ? LinearLayoutManager.DEBUG : true;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean hasValidAnchor() {
            if (this.mAnchorPosition >= 0) {
                return true;
            }
            return LinearLayoutManager.DEBUG;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, DEBUG);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = DEBUG;
        this.mShouldReverseLayout = DEBUG;
        this.mStackFromEnd = DEBUG;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = DEBUG;
        this.mShouldReverseLayout = DEBUG;
        this.mStackFromEnd = DEBUG;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.m.d properties = RecyclerView.m.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.a);
        setReverseLayout(properties.c);
        setStackFromEnd(properties.d);
    }

    private void A(RecyclerView.t tVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.d(childAt) > i3 || this.mOrientationHelper.p(childAt) > i3) {
                    y(tVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i6 = childCount - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View childAt2 = getChildAt(i7);
            if (this.mOrientationHelper.d(childAt2) > i3 || this.mOrientationHelper.p(childAt2) > i3) {
                y(tVar, i6, i7);
                return;
            }
        }
    }

    private void B() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean C(RecyclerView.t tVar, RecyclerView.x xVar, a aVar) {
        View findReferenceChild;
        int childCount = getChildCount();
        boolean z = DEBUG;
        if (childCount == 0) {
            return DEBUG;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.d(focusedChild, xVar)) {
            aVar.c(focusedChild, getPosition(focusedChild));
            return true;
        }
        boolean z2 = this.mLastStackFromEnd;
        boolean z3 = this.mStackFromEnd;
        if (z2 != z3 || (findReferenceChild = findReferenceChild(tVar, xVar, aVar.d, z3)) == null) {
            return DEBUG;
        }
        aVar.b(findReferenceChild, getPosition(findReferenceChild));
        if (!xVar.e() && supportsPredictiveItemAnimations()) {
            int g = this.mOrientationHelper.g(findReferenceChild);
            int d = this.mOrientationHelper.d(findReferenceChild);
            int m = this.mOrientationHelper.m();
            int i = this.mOrientationHelper.i();
            boolean z4 = d <= m && g < m;
            if (g >= i && d > i) {
                z = true;
            }
            if (z4 || z) {
                if (aVar.d) {
                    m = i;
                }
                aVar.c = m;
            }
        }
        return true;
    }

    private boolean D(RecyclerView.x xVar, a aVar) {
        int i;
        boolean e = xVar.e();
        boolean z = DEBUG;
        if (!e && (i = this.mPendingScrollPosition) != -1) {
            if (i >= 0 && i < xVar.b()) {
                aVar.b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    boolean z2 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    aVar.d = z2;
                    if (z2) {
                        aVar.c = this.mOrientationHelper.i() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        aVar.c = this.mOrientationHelper.m() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z3 = this.mShouldReverseLayout;
                    aVar.d = z3;
                    if (z3) {
                        aVar.c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.c = this.mOrientationHelper.m() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (findViewByPosition == null) {
                    if (getChildCount() > 0) {
                        if ((this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout) {
                            z = true;
                        }
                        aVar.d = z;
                    }
                    aVar.a();
                } else {
                    if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m() < 0) {
                        aVar.c = this.mOrientationHelper.m();
                        aVar.d = DEBUG;
                        return true;
                    }
                    if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                        aVar.c = this.mOrientationHelper.i();
                        aVar.d = true;
                        return true;
                    }
                    aVar.c = aVar.d ? this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.o() : this.mOrientationHelper.g(findViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return DEBUG;
    }

    private void E(RecyclerView.t tVar, RecyclerView.x xVar, a aVar) {
        if (D(xVar, aVar) || C(tVar, xVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.b = this.mStackFromEnd ? xVar.b() - 1 : 0;
    }

    private void F(int i, int i2, boolean z, RecyclerView.x xVar) {
        int m;
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f = i;
        int[] iArr = this.mReusableIntPair;
        boolean z2 = DEBUG;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(xVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i == 1) {
            z2 = true;
        }
        c cVar = this.mLayoutState;
        int i3 = z2 ? max2 : max;
        cVar.h = i3;
        if (!z2) {
            max = max2;
        }
        cVar.i = max;
        if (z2) {
            cVar.h = i3 + this.mOrientationHelper.j();
            View t = t();
            c cVar2 = this.mLayoutState;
            cVar2.e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(t);
            c cVar3 = this.mLayoutState;
            cVar2.d = position + cVar3.e;
            cVar3.b = this.mOrientationHelper.d(t);
            m = this.mOrientationHelper.d(t) - this.mOrientationHelper.i();
        } else {
            View u = u();
            this.mLayoutState.h += this.mOrientationHelper.m();
            c cVar4 = this.mLayoutState;
            cVar4.e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(u);
            c cVar5 = this.mLayoutState;
            cVar4.d = position2 + cVar5.e;
            cVar5.b = this.mOrientationHelper.g(u);
            m = (-this.mOrientationHelper.g(u)) + this.mOrientationHelper.m();
        }
        c cVar6 = this.mLayoutState;
        cVar6.c = i2;
        if (z) {
            cVar6.c = i2 - m;
        }
        cVar6.g = m;
    }

    private void G(int i, int i2) {
        this.mLayoutState.c = this.mOrientationHelper.i() - i2;
        c cVar = this.mLayoutState;
        cVar.e = this.mShouldReverseLayout ? -1 : 1;
        cVar.d = i;
        cVar.f = 1;
        cVar.b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    private void H(a aVar) {
        G(aVar.b, aVar.c);
    }

    private void I(int i, int i2) {
        this.mLayoutState.c = i2 - this.mOrientationHelper.m();
        c cVar = this.mLayoutState;
        cVar.d = i;
        cVar.e = this.mShouldReverseLayout ? 1 : -1;
        cVar.f = -1;
        cVar.b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    private void J(a aVar) {
        I(aVar.b, aVar.c);
    }

    private int k(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.a(xVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int l(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.b(xVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int m(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.c(xVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View n() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View o() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View p() {
        return this.mShouldReverseLayout ? n() : o();
    }

    private View q() {
        return this.mShouldReverseLayout ? o() : n();
    }

    private int r(int i, RecyclerView.t tVar, RecyclerView.x xVar, boolean z) {
        int i2;
        int i3 = this.mOrientationHelper.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -scrollBy(-i3, tVar, xVar);
        int i6 = i + i4;
        if (!z || (i2 = this.mOrientationHelper.i() - i6) <= 0) {
            return i4;
        }
        this.mOrientationHelper.r(i2);
        return i2 + i4;
    }

    private int s(int i, RecyclerView.t tVar, RecyclerView.x xVar, boolean z) {
        int m;
        int m2 = i - this.mOrientationHelper.m();
        if (m2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(m2, tVar, xVar);
        int i3 = i + i2;
        if (!z || (m = i3 - this.mOrientationHelper.m()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.r(-m);
        return i2 - m;
    }

    private View t() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View u() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void v(RecyclerView.t tVar, RecyclerView.x xVar, int i, int i2) {
        if (!xVar.g() || getChildCount() == 0 || xVar.e() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List k = tVar.k();
        int size = k.size();
        int position = getPosition(getChildAt(0));
        int i3 = 0;
        int i4 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView.a0 a0Var = (RecyclerView.a0) k.get(i6);
            if (!a0Var.isRemoved()) {
                if ((a0Var.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                    i3 += this.mOrientationHelper.e(a0Var.itemView);
                } else {
                    i4 += this.mOrientationHelper.e(a0Var.itemView);
                }
            }
        }
        this.mLayoutState.l = k;
        if (i3 > 0) {
            I(getPosition(u()), i);
            c cVar = this.mLayoutState;
            cVar.h = i3;
            cVar.c = 0;
            cVar.a();
            fill(tVar, this.mLayoutState, xVar, DEBUG);
        }
        if (i4 > 0) {
            G(getPosition(t()), i2);
            c cVar2 = this.mLayoutState;
            cVar2.h = i4;
            cVar2.c = 0;
            cVar2.a();
            fill(tVar, this.mLayoutState, xVar, DEBUG);
        }
        this.mLayoutState.l = null;
    }

    private void w() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            StringBuilder sb = new StringBuilder();
            sb.append("item ");
            sb.append(getPosition(childAt));
            sb.append(", coord:");
            sb.append(this.mOrientationHelper.g(childAt));
        }
    }

    private void x(RecyclerView.t tVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            z(tVar, i, i2);
        } else {
            A(tVar, i, i2);
        }
    }

    private void y(RecyclerView.t tVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, tVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, tVar);
            }
        }
    }

    private void z(RecyclerView.t tVar, int i, int i2) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int h = (this.mOrientationHelper.h() - i) + i2;
        if (this.mShouldReverseLayout) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (this.mOrientationHelper.g(childAt) < h || this.mOrientationHelper.q(childAt) < h) {
                    y(tVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i6 = i4; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.g(childAt2) < h || this.mOrientationHelper.q(childAt2) < h) {
                y(tVar, i4, i6);
                return;
            }
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    protected void calculateExtraLayoutSpace(RecyclerView.x xVar, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(xVar);
        if (this.mLayoutState.f == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return DEBUG;
    }

    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return DEBUG;
    }

    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.x xVar, RecyclerView.m.c cVar) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        F(i > 0 ? 1 : -1, Math.abs(i), true, xVar);
        collectPrefetchPositionsForLayoutState(xVar, this.mLayoutState, cVar);
    }

    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i, RecyclerView.m.c cVar) {
        boolean z;
        int i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState == null || !savedState.hasValidAnchor()) {
            B();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z = savedState2.mAnchorLayoutFromEnd;
            i2 = savedState2.mAnchorPosition;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            cVar.a(i2, 0);
            i2 += i3;
        }
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.x xVar, c cVar, RecyclerView.m.c cVar2) {
        int i = cVar.d;
        if (i < 0 || i >= xVar.b()) {
            return;
        }
        cVar2.a(i, Math.max(0, cVar.g));
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.x xVar) {
        return k(xVar);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.x xVar) {
        return l(xVar);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.x xVar) {
        return m(xVar);
    }

    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = DEBUG;
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        int i2 = z != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.x xVar) {
        return k(xVar);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.x xVar) {
        return l(xVar);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.x xVar) {
        return m(xVar);
    }

    int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    c createLayoutState() {
        return new c();
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    int fill(RecyclerView.t tVar, c cVar, RecyclerView.x xVar, boolean z) {
        int i = cVar.c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            x(tVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.c(xVar)) {
                break;
            }
            bVar.a();
            layoutChunk(tVar, xVar, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!bVar.c || cVar.l != null || !xVar.e()) {
                    int i4 = cVar.c;
                    int i6 = bVar.a;
                    cVar.c = i4 - i6;
                    i3 -= i6;
                }
                int i7 = cVar.g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + bVar.a;
                    cVar.g = i8;
                    int i9 = cVar.c;
                    if (i9 < 0) {
                        cVar.g = i8 + i9;
                    }
                    x(tVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, DEBUG);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z, z2) : findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z, z2) : findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), DEBUG, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, DEBUG);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, DEBUG, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if (i2 <= i && i2 >= i) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.g(getChildAt(i)) < this.mOrientationHelper.m()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.mOrientation == 0 ? ((RecyclerView.m) this).mHorizontalBoundCheck.a(i, i2, i3, i4) : ((RecyclerView.m) this).mVerticalBoundCheck.a(i, i2, i3, i4);
    }

    View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.mOrientation == 0 ? ((RecyclerView.m) this).mHorizontalBoundCheck.a(i, i2, i3, i4) : ((RecyclerView.m) this).mVerticalBoundCheck.a(i, i2, i3, i4);
    }

    View findReferenceChild(RecyclerView.t tVar, RecyclerView.x xVar, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z2) {
            i2 = getChildCount() - 1;
            i = -1;
            i3 = -1;
        } else {
            i = childCount;
            i2 = 0;
            i3 = 1;
        }
        int b = xVar.b();
        int m = this.mOrientationHelper.m();
        int i4 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i2 != i) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            int g = this.mOrientationHelper.g(childAt);
            int d = this.mOrientationHelper.d(childAt);
            if (position >= 0 && position < b) {
                if (!childAt.getLayoutParams().isItemRemoved()) {
                    boolean z3 = d <= m && g < m;
                    boolean z4 = g >= i4 && d > i4;
                    if (!z3 && !z4) {
                        return childAt;
                    }
                    if (z) {
                        if (!z4) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    } else {
                        if (!z3) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                        view2 = childAt;
                    }
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i2 += i3;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.n generateDefaultLayoutParams() {
        return new RecyclerView.n(-2, -2);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.x xVar) {
        if (xVar.d()) {
            return this.mOrientationHelper.n();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    protected boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return DEBUG;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(RecyclerView.t tVar, RecyclerView.x xVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int f;
        View d = cVar.d(tVar);
        if (d == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.n layoutParams = d.getLayoutParams();
        if (cVar.l == null) {
            if (this.mShouldReverseLayout == (cVar.f == -1)) {
                addView(d);
            } else {
                addView(d, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f == -1)) {
                addDisappearingView(d);
            } else {
                addDisappearingView(d, 0);
            }
        }
        measureChildWithMargins(d, 0, 0);
        bVar.a = this.mOrientationHelper.e(d);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                f = getWidth() - getPaddingRight();
                i4 = f - this.mOrientationHelper.f(d);
            } else {
                i4 = getPaddingLeft();
                f = this.mOrientationHelper.f(d) + i4;
            }
            if (cVar.f == -1) {
                int i6 = cVar.b;
                i3 = i6;
                i2 = f;
                i = i6 - bVar.a;
            } else {
                int i7 = cVar.b;
                i = i7;
                i2 = f;
                i3 = bVar.a + i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f2 = this.mOrientationHelper.f(d) + paddingTop;
            if (cVar.f == -1) {
                int i8 = cVar.b;
                i2 = i8;
                i = paddingTop;
                i3 = f2;
                i4 = i8 - bVar.a;
            } else {
                int i9 = cVar.b;
                i = paddingTop;
                i2 = bVar.a + i9;
                i3 = f2;
                i4 = i9;
            }
        }
        layoutDecoratedWithMargins(d, i4, i, i2, i3);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            bVar.c = true;
        }
        bVar.d = d.hasFocusable();
    }

    void onAnchorReady(RecyclerView.t tVar, RecyclerView.x xVar, a aVar, int i) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(tVar);
            tVar.c();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        int convertFocusDirectionToLayoutDirection;
        B();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        F(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.n() * MAX_SCROLL_FACTOR), DEBUG, xVar);
        c cVar = this.mLayoutState;
        cVar.g = Integer.MIN_VALUE;
        cVar.a = DEBUG;
        fill(tVar, cVar, xVar, true);
        View q = convertFocusDirectionToLayoutDirection == -1 ? q() : p();
        View u = convertFocusDirectionToLayoutDirection == -1 ? u() : t();
        if (!u.hasFocusable()) {
            return q;
        }
        if (q == null) {
            return null;
        }
        return u;
    }

    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int r;
        int i6;
        View findViewByPosition;
        int g;
        int i7;
        int i8 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && xVar.b() == 0) {
            removeAndRecycleAllViews(tVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.a = DEBUG;
        B();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (!aVar.e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            E(tVar, xVar, aVar2);
            this.mAnchorInfo.e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.g(focusedChild) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(focusedChild) <= this.mOrientationHelper.m())) {
            this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(xVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.m();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (xVar.e() && (i6 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i6)) != null) {
            if (this.mShouldReverseLayout) {
                i7 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                g = this.mPendingScrollPositionOffset;
            } else {
                g = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i9 = i7 - g;
            if (i9 > 0) {
                max += i9;
            } else {
                max2 -= i9;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i8 = 1;
        }
        onAnchorReady(tVar, xVar, aVar3, i8);
        detachAndScrapAttachedViews(tVar);
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.j = xVar.e();
        this.mLayoutState.i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.d) {
            J(aVar4);
            c cVar2 = this.mLayoutState;
            cVar2.h = max;
            fill(tVar, cVar2, xVar, DEBUG);
            c cVar3 = this.mLayoutState;
            i2 = cVar3.b;
            int i10 = cVar3.d;
            int i11 = cVar3.c;
            if (i11 > 0) {
                max2 += i11;
            }
            H(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.h = max2;
            cVar4.d += cVar4.e;
            fill(tVar, cVar4, xVar, DEBUG);
            c cVar5 = this.mLayoutState;
            i = cVar5.b;
            int i12 = cVar5.c;
            if (i12 > 0) {
                I(i10, i2);
                c cVar6 = this.mLayoutState;
                cVar6.h = i12;
                fill(tVar, cVar6, xVar, DEBUG);
                i2 = this.mLayoutState.b;
            }
        } else {
            H(aVar4);
            c cVar7 = this.mLayoutState;
            cVar7.h = max2;
            fill(tVar, cVar7, xVar, DEBUG);
            c cVar8 = this.mLayoutState;
            i = cVar8.b;
            int i13 = cVar8.d;
            int i14 = cVar8.c;
            if (i14 > 0) {
                max += i14;
            }
            J(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.h = max;
            cVar9.d += cVar9.e;
            fill(tVar, cVar9, xVar, DEBUG);
            c cVar10 = this.mLayoutState;
            i2 = cVar10.b;
            int i15 = cVar10.c;
            if (i15 > 0) {
                G(i13, i);
                c cVar11 = this.mLayoutState;
                cVar11.h = i15;
                fill(tVar, cVar11, xVar, DEBUG);
                i = this.mLayoutState.b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int r2 = r(i, tVar, xVar, true);
                i3 = i2 + r2;
                i4 = i + r2;
                r = s(i3, tVar, xVar, DEBUG);
            } else {
                int s = s(i2, tVar, xVar, true);
                i3 = i2 + s;
                i4 = i + s;
                r = r(i4, tVar, xVar, DEBUG);
            }
            i2 = i3 + r;
            i = i4 + r;
        }
        v(tVar, xVar, i2, i);
        if (xVar.e()) {
            this.mAnchorInfo.e();
        } else {
            this.mOrientationHelper.s();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.x xVar) {
        super.onLayoutCompleted(xVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z;
            if (z) {
                View t = t();
                savedState.mAnchorOffset = this.mOrientationHelper.i() - this.mOrientationHelper.d(t);
                savedState.mAnchorPosition = getPosition(t);
            } else {
                View u = u();
                savedState.mAnchorPosition = getPosition(u);
                savedState.mAnchorOffset = this.mOrientationHelper.g(u) - this.mOrientationHelper.m();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        B();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - (this.mOrientationHelper.g(view2) + this.mOrientationHelper.e(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - this.mOrientationHelper.d(view2));
                return;
            }
        }
        if (c == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2) - this.mOrientationHelper.e(view));
        }
    }

    boolean resolveIsInfinite() {
        if (this.mOrientationHelper.k() == 0 && this.mOrientationHelper.h() == 0) {
            return true;
        }
        return DEBUG;
    }

    int scrollBy(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        F(i2, abs, true, xVar);
        c cVar = this.mLayoutState;
        int fill = cVar.g + fill(tVar, cVar, xVar, DEBUG);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.r(-i);
        this.mLayoutState.k = i;
        return i;
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, tVar, xVar);
    }

    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, tVar, xVar);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            m b = m.b(this, i);
            this.mOrientationHelper = b;
            this.mAnchorInfo.a = b;
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    boolean shouldMeasureTwice() {
        if (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) {
            return DEBUG;
        }
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i);
        startSmoothScroll(hVar);
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
            return true;
        }
        return DEBUG;
    }

    void validateChildOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("validating child count ");
        sb.append(getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int g = this.mOrientationHelper.g(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int g2 = this.mOrientationHelper.g(childAt);
                if (position2 < position) {
                    w();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    sb2.append(g2 < g);
                    throw new RuntimeException(sb2.toString());
                }
                if (g2 > g) {
                    w();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int g3 = this.mOrientationHelper.g(childAt2);
            if (position3 < position) {
                w();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("detected invalid position. loc invalid? ");
                sb3.append(g3 < g);
                throw new RuntimeException(sb3.toString());
            }
            if (g3 < g) {
                w();
                throw new RuntimeException("detected invalid location");
            }
        }
    }
}
