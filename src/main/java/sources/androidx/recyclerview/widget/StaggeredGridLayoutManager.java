package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.m implements RecyclerView.w.b {
    c[] b;
    m c;
    m d;
    private int e;
    private int f;
    private final g g;
    private BitSet j;
    private boolean o;
    private boolean p;
    private SavedState q;
    private int r;
    private int[] w;
    private int a = -1;
    boolean h = false;
    boolean i = false;
    int k = -1;
    int l = Integer.MIN_VALUE;
    LazySpanLookup m = new LazySpanLookup();
    private int n = 2;
    private final Rect s = new Rect();
    private final a t = new a(this);
    private boolean u = false;
    private boolean v = true;
    private final Runnable x = new 1(this);

    public StaggeredGridLayoutManager(int i, int i2) {
        this.e = i2;
        h0(i);
        this.g = new g();
        x();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.m.d properties = RecyclerView.m.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.a);
        h0(properties.b);
        setReverseLayout(properties.c);
        this.g = new g();
        x();
    }

    private int F(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private void H(RecyclerView.t tVar, RecyclerView.x xVar, boolean z) {
        int i;
        int L = L(Integer.MIN_VALUE);
        if (L != Integer.MIN_VALUE && (i = this.c.i() - L) > 0) {
            int i2 = i - (-scrollBy(-i, tVar, xVar));
            if (!z || i2 <= 0) {
                return;
            }
            this.c.r(i2);
        }
    }

    private void I(RecyclerView.t tVar, RecyclerView.x xVar, boolean z) {
        int m;
        int O = O(Integer.MAX_VALUE);
        if (O != Integer.MAX_VALUE && (m = O - this.c.m()) > 0) {
            int scrollBy = m - scrollBy(m, tVar, xVar);
            if (!z || scrollBy <= 0) {
                return;
            }
            this.c.r(-scrollBy);
        }
    }

    private int L(int i) {
        int p = this.b[0].p(i);
        for (int i2 = 1; i2 < this.a; i2++) {
            int p2 = this.b[i2].p(i);
            if (p2 > p) {
                p = p2;
            }
        }
        return p;
    }

    private int M(int i) {
        int t = this.b[0].t(i);
        for (int i2 = 1; i2 < this.a; i2++) {
            int t2 = this.b[i2].t(i);
            if (t2 > t) {
                t = t2;
            }
        }
        return t;
    }

    private int N(int i) {
        int p = this.b[0].p(i);
        for (int i2 = 1; i2 < this.a; i2++) {
            int p2 = this.b[i2].p(i);
            if (p2 < p) {
                p = p2;
            }
        }
        return p;
    }

    private int O(int i) {
        int t = this.b[0].t(i);
        for (int i2 = 1; i2 < this.a; i2++) {
            int t2 = this.b[i2].t(i);
            if (t2 < t) {
                t = t2;
            }
        }
        return t;
    }

    private c P(g gVar) {
        int i;
        int i2;
        int i3;
        if (X(gVar.e)) {
            i2 = this.a - 1;
            i = -1;
            i3 = -1;
        } else {
            i = this.a;
            i2 = 0;
            i3 = 1;
        }
        c cVar = null;
        if (gVar.e == 1) {
            int m = this.c.m();
            int i4 = Integer.MAX_VALUE;
            while (i2 != i) {
                c cVar2 = this.b[i2];
                int p = cVar2.p(m);
                if (p < i4) {
                    cVar = cVar2;
                    i4 = p;
                }
                i2 += i3;
            }
            return cVar;
        }
        int i6 = this.c.i();
        int i7 = Integer.MIN_VALUE;
        while (i2 != i) {
            c cVar3 = this.b[i2];
            int t = cVar3.t(i6);
            if (t > i7) {
                cVar = cVar3;
                i7 = t;
            }
            i2 += i3;
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void R(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.i
            if (r0 == 0) goto L9
            int r0 = r6.K()
            goto Ld
        L9:
            int r0 = r6.J()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.m
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.m
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.m
            r7.j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.m
            r9.k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.m
            r9.j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.i
            if (r7 == 0) goto L4e
            int r7 = r6.J()
            goto L52
        L4e:
            int r7 = r6.K()
        L52:
            if (r3 > r7) goto L57
            r6.requestLayout()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.R(int, int, int):void");
    }

    private void U(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.s);
        b layoutParams = view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.s;
        int p0 = p0(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.s;
        int p02 = p0(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z ? shouldReMeasureChild(view, p0, p02, layoutParams) : shouldMeasureChild(view, p0, p02, layoutParams)) {
            view.measure(p0, p02);
        }
    }

    private void V(View view, b bVar, boolean z) {
        if (bVar.b) {
            if (this.e == 1) {
                U(view, this.r, RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) bVar).height, true), z);
                return;
            } else {
                U(view, RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) bVar).width, true), this.r, z);
                return;
            }
        }
        if (this.e == 1) {
            U(view, RecyclerView.m.getChildMeasureSpec(this.f, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) bVar).width, false), RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) bVar).height, true), z);
        } else {
            U(view, RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) bVar).width, true), RecyclerView.m.getChildMeasureSpec(this.f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) bVar).height, false), z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0152, code lost:
    
        if (q() != false) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void W(androidx.recyclerview.widget.RecyclerView.t r9, androidx.recyclerview.widget.RecyclerView.x r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.W(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x, boolean):void");
    }

    private boolean X(int i) {
        if (this.e == 0) {
            return (i == -1) != this.i;
        }
        return ((i == -1) == this.i) == isLayoutRTL();
    }

    private void Z(View view) {
        for (int i = this.a - 1; i >= 0; i--) {
            this.b[i].y(view);
        }
    }

    private void a0(RecyclerView.t tVar, g gVar) {
        if (!gVar.a || gVar.i) {
            return;
        }
        if (gVar.b == 0) {
            if (gVar.e == -1) {
                b0(tVar, gVar.g);
                return;
            } else {
                c0(tVar, gVar.f);
                return;
            }
        }
        if (gVar.e != -1) {
            int N = N(gVar.g) - gVar.g;
            c0(tVar, N < 0 ? gVar.f : Math.min(N, gVar.b) + gVar.f);
        } else {
            int i = gVar.f;
            int M = i - M(i);
            b0(tVar, M < 0 ? gVar.g : gVar.g - Math.min(M, gVar.b));
        }
    }

    private void b0(RecyclerView.t tVar, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.c.g(childAt) < i || this.c.q(childAt) < i) {
                return;
            }
            b layoutParams = childAt.getLayoutParams();
            if (layoutParams.b) {
                for (int i2 = 0; i2 < this.a; i2++) {
                    if (this.b[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.a; i3++) {
                    this.b[i3].w();
                }
            } else if (layoutParams.a.a.size() == 1) {
                return;
            } else {
                layoutParams.a.w();
            }
            removeAndRecycleView(childAt, tVar);
        }
    }

    private void c0(RecyclerView.t tVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.c.d(childAt) > i || this.c.p(childAt) > i) {
                return;
            }
            b layoutParams = childAt.getLayoutParams();
            if (layoutParams.b) {
                for (int i2 = 0; i2 < this.a; i2++) {
                    if (this.b[i2].a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.a; i3++) {
                    this.b[i3].x();
                }
            } else if (layoutParams.a.a.size() == 1) {
                return;
            } else {
                layoutParams.a.x();
            }
            removeAndRecycleView(childAt, tVar);
        }
    }

    private int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.e == 1) ? 1 : Integer.MIN_VALUE : this.e == 0 ? 1 : Integer.MIN_VALUE : this.e == 1 ? -1 : Integer.MIN_VALUE : this.e == 0 ? -1 : Integer.MIN_VALUE : (this.e != 1 && isLayoutRTL()) ? -1 : 1 : (this.e != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private void d0() {
        if (this.d.k() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            float e = this.d.e(childAt);
            if (e >= f) {
                if (childAt.getLayoutParams().b()) {
                    e = (e * 1.0f) / this.a;
                }
                f = Math.max(f, e);
            }
        }
        int i2 = this.f;
        int round = Math.round(f * this.a);
        if (this.d.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.d.n());
        }
        n0(round);
        if (this.f == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            b layoutParams = childAt2.getLayoutParams();
            if (!layoutParams.b) {
                if (isLayoutRTL() && this.e == 1) {
                    int i4 = this.a;
                    int i6 = layoutParams.a.e;
                    childAt2.offsetLeftAndRight(((-((i4 - 1) - i6)) * this.f) - ((-((i4 - 1) - i6)) * i2));
                } else {
                    int i7 = layoutParams.a.e;
                    int i8 = this.f * i7;
                    int i9 = i7 * i2;
                    if (this.e == 1) {
                        childAt2.offsetLeftAndRight(i8 - i9);
                    } else {
                        childAt2.offsetTopAndBottom(i8 - i9);
                    }
                }
            }
        }
    }

    private void e0() {
        if (this.e == 1 || !isLayoutRTL()) {
            this.i = this.h;
        } else {
            this.i = !this.h;
        }
    }

    private void g0(int i) {
        g gVar = this.g;
        gVar.e = i;
        gVar.d = this.i != (i == -1) ? -1 : 1;
    }

    private void i0(int i, int i2) {
        for (int i3 = 0; i3 < this.a; i3++) {
            if (!this.b[i3].a.isEmpty()) {
                o0(this.b[i3], i, i2);
            }
        }
    }

    private boolean j0(RecyclerView.x xVar, a aVar) {
        aVar.a = this.o ? F(xVar.b()) : z(xVar.b());
        aVar.b = Integer.MIN_VALUE;
        return true;
    }

    private void k(View view) {
        for (int i = this.a - 1; i >= 0; i--) {
            this.b[i].a(view);
        }
    }

    private void l(a aVar) {
        SavedState savedState = this.q;
        int i = savedState.mSpanOffsetsSize;
        if (i > 0) {
            if (i == this.a) {
                for (int i2 = 0; i2 < this.a; i2++) {
                    this.b[i2].e();
                    SavedState savedState2 = this.q;
                    int i3 = savedState2.mSpanOffsets[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        i3 += savedState2.mAnchorLayoutFromEnd ? this.c.i() : this.c.m();
                    }
                    this.b[i2].z(i3);
                }
            } else {
                savedState.invalidateSpanInfo();
                SavedState savedState3 = this.q;
                savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
            }
        }
        SavedState savedState4 = this.q;
        this.p = savedState4.mLastLayoutRTL;
        setReverseLayout(savedState4.mReverseLayout);
        e0();
        SavedState savedState5 = this.q;
        int i4 = savedState5.mAnchorPosition;
        if (i4 != -1) {
            this.k = i4;
            aVar.c = savedState5.mAnchorLayoutFromEnd;
        } else {
            aVar.c = this.i;
        }
        if (savedState5.mSpanLookupSize > 1) {
            LazySpanLookup lazySpanLookup = this.m;
            lazySpanLookup.a = savedState5.mSpanLookup;
            lazySpanLookup.b = savedState5.mFullSpanItems;
        }
    }

    private void m0(int i, RecyclerView.x xVar) {
        int i2;
        int i3;
        int c;
        g gVar = this.g;
        boolean z = false;
        gVar.b = 0;
        gVar.c = i;
        if (!isSmoothScrolling() || (c = xVar.c()) == -1) {
            i2 = 0;
            i3 = 0;
        } else {
            if (this.i == (c < i)) {
                i2 = this.c.n();
                i3 = 0;
            } else {
                i3 = this.c.n();
                i2 = 0;
            }
        }
        if (getClipToPadding()) {
            this.g.f = this.c.m() - i3;
            this.g.g = this.c.i() + i2;
        } else {
            this.g.g = this.c.h() + i2;
            this.g.f = -i3;
        }
        g gVar2 = this.g;
        gVar2.h = false;
        gVar2.a = true;
        if (this.c.k() == 0 && this.c.h() == 0) {
            z = true;
        }
        gVar2.i = z;
    }

    private void o(View view, b bVar, g gVar) {
        if (gVar.e == 1) {
            if (bVar.b) {
                k(view);
                return;
            } else {
                bVar.a.a(view);
                return;
            }
        }
        if (bVar.b) {
            Z(view);
        } else {
            bVar.a.y(view);
        }
    }

    private void o0(c cVar, int i, int i2) {
        int n = cVar.n();
        if (i == -1) {
            if (cVar.s() + n <= i2) {
                this.j.set(cVar.e, false);
            }
        } else if (cVar.o() - n >= i2) {
            this.j.set(cVar.e, false);
        }
    }

    private int p(int i) {
        if (getChildCount() == 0) {
            return this.i ? 1 : -1;
        }
        return (i < J()) != this.i ? -1 : 1;
    }

    private int p0(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private boolean r(c cVar) {
        if (this.i) {
            if (cVar.o() < this.c.i()) {
                ArrayList arrayList = cVar.a;
                return !cVar.r((View) arrayList.get(arrayList.size() - 1)).b;
            }
        } else if (cVar.s() > this.c.m()) {
            return !cVar.r((View) cVar.a.get(0)).b;
        }
        return false;
    }

    private int s(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.a(xVar, this.c, B(!this.v), A(!this.v), this, this.v);
    }

    private int t(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.b(xVar, this.c, B(!this.v), A(!this.v), this, this.v, this.i);
    }

    private int u(RecyclerView.x xVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.c(xVar, this.c, B(!this.v), A(!this.v), this, this.v);
    }

    private LazySpanLookup.FullSpanItem v(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.a];
        for (int i2 = 0; i2 < this.a; i2++) {
            fullSpanItem.c[i2] = i - this.b[i2].p(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem w(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.c = new int[this.a];
        for (int i2 = 0; i2 < this.a; i2++) {
            fullSpanItem.c[i2] = this.b[i2].t(i) - i;
        }
        return fullSpanItem;
    }

    private void x() {
        this.c = m.b(this, this.e);
        this.d = m.b(this, 1 - this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int y(RecyclerView.t tVar, g gVar, RecyclerView.x xVar) {
        c cVar;
        int e;
        int i;
        int i2;
        int e3;
        boolean z;
        ?? r9 = 0;
        this.j.set(0, this.a, true);
        int i3 = this.g.i ? gVar.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : gVar.e == 1 ? gVar.g + gVar.b : gVar.f - gVar.b;
        i0(gVar.e, i3);
        int i4 = this.i ? this.c.i() : this.c.m();
        boolean z2 = false;
        while (gVar.a(xVar) && (this.g.i || !this.j.isEmpty())) {
            View b = gVar.b(tVar);
            b layoutParams = b.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int g = this.m.g(viewLayoutPosition);
            boolean z3 = g == -1 ? true : r9;
            if (z3) {
                cVar = layoutParams.b ? this.b[r9] : P(gVar);
                this.m.n(viewLayoutPosition, cVar);
            } else {
                cVar = this.b[g];
            }
            c cVar2 = cVar;
            layoutParams.a = cVar2;
            if (gVar.e == 1) {
                addView(b);
            } else {
                addView(b, (int) r9);
            }
            V(b, layoutParams, r9);
            if (gVar.e == 1) {
                int L = layoutParams.b ? L(i4) : cVar2.p(i4);
                int e4 = this.c.e(b) + L;
                if (z3 && layoutParams.b) {
                    LazySpanLookup.FullSpanItem v = v(L);
                    v.b = -1;
                    v.a = viewLayoutPosition;
                    this.m.a(v);
                }
                i = e4;
                e = L;
            } else {
                int O = layoutParams.b ? O(i4) : cVar2.t(i4);
                e = O - this.c.e(b);
                if (z3 && layoutParams.b) {
                    LazySpanLookup.FullSpanItem w = w(O);
                    w.b = 1;
                    w.a = viewLayoutPosition;
                    this.m.a(w);
                }
                i = O;
            }
            if (layoutParams.b && gVar.d == -1) {
                if (z3) {
                    this.u = true;
                } else {
                    if (!(gVar.e == 1 ? m() : n())) {
                        LazySpanLookup.FullSpanItem f = this.m.f(viewLayoutPosition);
                        if (f != null) {
                            f.d = true;
                        }
                        this.u = true;
                    }
                }
            }
            o(b, layoutParams, gVar);
            if (isLayoutRTL() && this.e == 1) {
                int i6 = layoutParams.b ? this.d.i() : this.d.i() - (((this.a - 1) - cVar2.e) * this.f);
                e3 = i6;
                i2 = i6 - this.d.e(b);
            } else {
                int m = layoutParams.b ? this.d.m() : (cVar2.e * this.f) + this.d.m();
                i2 = m;
                e3 = this.d.e(b) + m;
            }
            if (this.e == 1) {
                layoutDecoratedWithMargins(b, i2, e, e3, i);
            } else {
                layoutDecoratedWithMargins(b, e, i2, i, e3);
            }
            if (layoutParams.b) {
                i0(this.g.e, i3);
            } else {
                o0(cVar2, this.g.e, i3);
            }
            a0(tVar, this.g);
            if (this.g.h && b.hasFocusable()) {
                if (layoutParams.b) {
                    this.j.clear();
                } else {
                    z = false;
                    this.j.set(cVar2.e, false);
                    r9 = z;
                    z2 = true;
                }
            }
            z = false;
            r9 = z;
            z2 = true;
        }
        int i7 = r9;
        if (!z2) {
            a0(tVar, this.g);
        }
        int m2 = this.g.e == -1 ? this.c.m() - O(this.c.m()) : L(this.c.i()) - this.c.i();
        return m2 > 0 ? Math.min(gVar.b, m2) : i7;
    }

    private int z(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    View A(boolean z) {
        int m = this.c.m();
        int i = this.c.i();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int g = this.c.g(childAt);
            int d = this.c.d(childAt);
            if (d > m && g < i) {
                if (d <= i || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    View B(boolean z) {
        int m = this.c.m();
        int i = this.c.i();
        int childCount = getChildCount();
        View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int g = this.c.g(childAt);
            if (this.c.d(childAt) > m && g < i) {
                if (g >= m || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    int C() {
        View A = this.i ? A(true) : B(true);
        if (A == null) {
            return -1;
        }
        return getPosition(A);
    }

    public int[] D(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.a];
        } else if (iArr.length < this.a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.a + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.a; i++) {
            iArr[i] = this.b[i].g();
        }
        return iArr;
    }

    public int[] E(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.a];
        } else if (iArr.length < this.a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.a + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.a; i++) {
            iArr[i] = this.b[i].h();
        }
        return iArr;
    }

    public int[] G(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.a];
        } else if (iArr.length < this.a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.a + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.a; i++) {
            iArr[i] = this.b[i].j();
        }
        return iArr;
    }

    int J() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    int K() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public int Q() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View S() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.a
            r2.<init>(r3)
            int r3 = r12.a
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.e
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.i
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.a
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.a
            boolean r9 = r12.r(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.a
            int r9 = r9.e
            r2.clear(r9)
        L52:
            boolean r9 = r8.b
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.i
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.m r10 = r12.c
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.m r11 = r12.c
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.m r10 = r12.c
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.m r11 = r12.c
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.a
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.a
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = r5
            goto L9a
        L99:
            r8 = r4
        L9a:
            if (r3 >= 0) goto L9e
            r9 = r5
            goto L9f
        L9e:
            r9 = r4
        L9f:
            if (r8 == r9) goto La2
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.S():android.view.View");
    }

    public void T() {
        this.m.b();
        requestLayout();
    }

    void Y(int i, RecyclerView.x xVar) {
        int J;
        int i2;
        if (i > 0) {
            J = K();
            i2 = 1;
        } else {
            J = J();
            i2 = -1;
        }
        this.g.a = true;
        m0(J, xVar);
        g0(i2);
        g gVar = this.g;
        gVar.c = J + gVar.d;
        gVar.b = Math.abs(i);
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public boolean canScrollHorizontally() {
        return this.e == 0;
    }

    public boolean canScrollVertically() {
        return this.e == 1;
    }

    public boolean checkLayoutParams(RecyclerView.n nVar) {
        return nVar instanceof b;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.x xVar, RecyclerView.m.c cVar) {
        int p;
        int i3;
        if (this.e != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        Y(i, xVar);
        int[] iArr = this.w;
        if (iArr == null || iArr.length < this.a) {
            this.w = new int[this.a];
        }
        int i4 = 0;
        for (int i6 = 0; i6 < this.a; i6++) {
            g gVar = this.g;
            if (gVar.d == -1) {
                p = gVar.f;
                i3 = this.b[i6].t(p);
            } else {
                p = this.b[i6].p(gVar.g);
                i3 = this.g.g;
            }
            int i7 = p - i3;
            if (i7 >= 0) {
                this.w[i4] = i7;
                i4++;
            }
        }
        Arrays.sort(this.w, 0, i4);
        for (int i8 = 0; i8 < i4 && this.g.a(xVar); i8++) {
            cVar.a(this.g.c, this.w[i8]);
            g gVar2 = this.g;
            gVar2.c += gVar2.d;
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.x xVar) {
        return s(xVar);
    }

    public int computeHorizontalScrollOffset(RecyclerView.x xVar) {
        return t(xVar);
    }

    public int computeHorizontalScrollRange(RecyclerView.x xVar) {
        return u(xVar);
    }

    public PointF computeScrollVectorForPosition(int i) {
        int p = p(i);
        PointF pointF = new PointF();
        if (p == 0) {
            return null;
        }
        if (this.e == 0) {
            pointF.x = p;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = p;
        }
        return pointF;
    }

    public int computeVerticalScrollExtent(RecyclerView.x xVar) {
        return s(xVar);
    }

    public int computeVerticalScrollOffset(RecyclerView.x xVar) {
        return t(xVar);
    }

    public int computeVerticalScrollRange(RecyclerView.x xVar) {
        return u(xVar);
    }

    public void f0(int i) {
        assertNotInLayoutOrScroll(null);
        if (i == this.n) {
            return;
        }
        if (i != 0 && i != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.n = i;
        requestLayout();
    }

    public RecyclerView.n generateDefaultLayoutParams() {
        return this.e == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    public RecyclerView.n generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public RecyclerView.n generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public int getOrientation() {
        return this.e;
    }

    public void h0(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.a) {
            T();
            this.a = i;
            this.j = new BitSet(this.a);
            this.b = new c[this.a];
            for (int i2 = 0; i2 < this.a; i2++) {
                this.b[i2] = new c(this, i2);
            }
            requestLayout();
        }
    }

    public boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    boolean k0(RecyclerView.x xVar, a aVar) {
        int i;
        if (!xVar.e() && (i = this.k) != -1) {
            if (i >= 0 && i < xVar.b()) {
                SavedState savedState = this.q;
                if (savedState == null || savedState.mAnchorPosition == -1 || savedState.mSpanOffsetsSize < 1) {
                    View findViewByPosition = findViewByPosition(this.k);
                    if (findViewByPosition != null) {
                        aVar.a = this.i ? K() : J();
                        if (this.l != Integer.MIN_VALUE) {
                            if (aVar.c) {
                                aVar.b = (this.c.i() - this.l) - this.c.d(findViewByPosition);
                            } else {
                                aVar.b = (this.c.m() + this.l) - this.c.g(findViewByPosition);
                            }
                            return true;
                        }
                        if (this.c.e(findViewByPosition) > this.c.n()) {
                            aVar.b = aVar.c ? this.c.i() : this.c.m();
                            return true;
                        }
                        int g = this.c.g(findViewByPosition) - this.c.m();
                        if (g < 0) {
                            aVar.b = -g;
                            return true;
                        }
                        int i2 = this.c.i() - this.c.d(findViewByPosition);
                        if (i2 < 0) {
                            aVar.b = i2;
                            return true;
                        }
                        aVar.b = Integer.MIN_VALUE;
                    } else {
                        int i3 = this.k;
                        aVar.a = i3;
                        int i4 = this.l;
                        if (i4 == Integer.MIN_VALUE) {
                            aVar.c = p(i3) == 1;
                            aVar.a();
                        } else {
                            aVar.b(i4);
                        }
                        aVar.d = true;
                    }
                } else {
                    aVar.b = Integer.MIN_VALUE;
                    aVar.a = this.k;
                }
                return true;
            }
            this.k = -1;
            this.l = Integer.MIN_VALUE;
        }
        return false;
    }

    void l0(RecyclerView.x xVar, a aVar) {
        if (k0(xVar, aVar) || j0(xVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.a = 0;
    }

    boolean m() {
        int p = this.b[0].p(Integer.MIN_VALUE);
        for (int i = 1; i < this.a; i++) {
            if (this.b[i].p(Integer.MIN_VALUE) != p) {
                return false;
            }
        }
        return true;
    }

    boolean n() {
        int t = this.b[0].t(Integer.MIN_VALUE);
        for (int i = 1; i < this.a; i++) {
            if (this.b[i].t(Integer.MIN_VALUE) != t) {
                return false;
            }
        }
        return true;
    }

    void n0(int i) {
        this.f = i / this.a;
        this.r = View.MeasureSpec.makeMeasureSpec(i, this.d.k());
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            this.b[i2].v(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            this.b[i2].v(i);
        }
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.m.b();
        for (int i = 0; i < this.a; i++) {
            this.b[i].e();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        removeCallbacks(this.x);
        for (int i = 0; i < this.a; i++) {
            this.b[i].e();
        }
        recyclerView.requestLayout();
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        View findContainingItemView;
        View q;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        e0();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        b layoutParams = findContainingItemView.getLayoutParams();
        boolean z = layoutParams.b;
        c cVar = layoutParams.a;
        int K = convertFocusDirectionToLayoutDirection == 1 ? K() : J();
        m0(K, xVar);
        g0(convertFocusDirectionToLayoutDirection);
        g gVar = this.g;
        gVar.c = gVar.d + K;
        gVar.b = (int) (this.c.n() * 0.33333334f);
        g gVar2 = this.g;
        gVar2.h = true;
        gVar2.a = false;
        y(tVar, gVar2, xVar);
        this.o = this.i;
        if (!z && (q = cVar.q(K, convertFocusDirectionToLayoutDirection)) != null && q != findContainingItemView) {
            return q;
        }
        if (X(convertFocusDirectionToLayoutDirection)) {
            for (int i2 = this.a - 1; i2 >= 0; i2--) {
                View q2 = this.b[i2].q(K, convertFocusDirectionToLayoutDirection);
                if (q2 != null && q2 != findContainingItemView) {
                    return q2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.a; i3++) {
                View q3 = this.b[i3].q(K, convertFocusDirectionToLayoutDirection);
                if (q3 != null && q3 != findContainingItemView) {
                    return q3;
                }
            }
        }
        boolean z2 = (this.h ^ true) == (convertFocusDirectionToLayoutDirection == -1);
        if (!z) {
            View findViewByPosition = findViewByPosition(z2 ? cVar.f() : cVar.i());
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (X(convertFocusDirectionToLayoutDirection)) {
            for (int i4 = this.a - 1; i4 >= 0; i4--) {
                if (i4 != cVar.e) {
                    View findViewByPosition2 = findViewByPosition(z2 ? this.b[i4].f() : this.b[i4].i());
                    if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.a; i6++) {
                View findViewByPosition3 = findViewByPosition(z2 ? this.b[i6].f() : this.b[i6].i());
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View B = B(false);
            View A = A(false);
            if (B == null || A == null) {
                return;
            }
            int position = getPosition(B);
            int position2 = getPosition(A);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        R(i, i2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.m.b();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        R(i, i2, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        R(i, i2, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        R(i, i2, 4);
    }

    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.x xVar) {
        W(tVar, xVar, true);
    }

    public void onLayoutCompleted(RecyclerView.x xVar) {
        super.onLayoutCompleted(xVar);
        this.k = -1;
        this.l = Integer.MIN_VALUE;
        this.q = null;
        this.t.c();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.q = savedState;
            if (this.k != -1) {
                savedState.invalidateAnchorPositionInfo();
                this.q.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int t;
        int m;
        int[] iArr;
        if (this.q != null) {
            return new SavedState(this.q);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.h;
        savedState.mAnchorLayoutFromEnd = this.o;
        savedState.mLastLayoutRTL = this.p;
        LazySpanLookup lazySpanLookup = this.m;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.a) == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = iArr;
            savedState.mSpanLookupSize = iArr.length;
            savedState.mFullSpanItems = lazySpanLookup.b;
        }
        if (getChildCount() > 0) {
            savedState.mAnchorPosition = this.o ? K() : J();
            savedState.mVisibleAnchorPosition = C();
            int i = this.a;
            savedState.mSpanOffsetsSize = i;
            savedState.mSpanOffsets = new int[i];
            for (int i2 = 0; i2 < this.a; i2++) {
                if (this.o) {
                    t = this.b[i2].p(Integer.MIN_VALUE);
                    if (t != Integer.MIN_VALUE) {
                        m = this.c.i();
                        t -= m;
                        savedState.mSpanOffsets[i2] = t;
                    } else {
                        savedState.mSpanOffsets[i2] = t;
                    }
                } else {
                    t = this.b[i2].t(Integer.MIN_VALUE);
                    if (t != Integer.MIN_VALUE) {
                        m = this.c.m();
                        t -= m;
                        savedState.mSpanOffsets[i2] = t;
                    } else {
                        savedState.mSpanOffsets[i2] = t;
                    }
                }
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            q();
        }
    }

    boolean q() {
        int J;
        int K;
        if (getChildCount() == 0 || this.n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.i) {
            J = K();
            K = J();
        } else {
            J = J();
            K = K();
        }
        if (J == 0 && S() != null) {
            this.m.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.u) {
            return false;
        }
        int i = this.i ? -1 : 1;
        int i2 = K + 1;
        LazySpanLookup.FullSpanItem e = this.m.e(J, i2, i, true);
        if (e == null) {
            this.u = false;
            this.m.d(i2);
            return false;
        }
        LazySpanLookup.FullSpanItem e3 = this.m.e(J, e.a, i * (-1), true);
        if (e3 == null) {
            this.m.d(e.a);
        } else {
            this.m.d(e3.a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    int scrollBy(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        Y(i, xVar);
        int y = y(tVar, this.g, xVar);
        if (this.g.b >= y) {
            i = i < 0 ? -y : y;
        }
        this.c.r(-i);
        this.o = this.i;
        g gVar = this.g;
        gVar.b = 0;
        a0(tVar, gVar);
        return i;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        return scrollBy(i, tVar, xVar);
    }

    public void scrollToPosition(int i) {
        SavedState savedState = this.q;
        if (savedState != null && savedState.mAnchorPosition != i) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.k = i;
        this.l = Integer.MIN_VALUE;
        requestLayout();
    }

    public int scrollVerticallyBy(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        return scrollBy(i, tVar, xVar);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.e == 1) {
            chooseSize2 = RecyclerView.m.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = RecyclerView.m.chooseSize(i, (this.f * this.a) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.m.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = RecyclerView.m.chooseSize(i2, (this.f * this.a) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.e) {
            return;
        }
        this.e = i;
        m mVar = this.c;
        this.c = this.d;
        this.d = mVar;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.q;
        if (savedState != null && savedState.mReverseLayout != z) {
            savedState.mReverseLayout = z;
        }
        this.h = z;
        requestLayout();
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
        h hVar = new h(recyclerView.getContext());
        hVar.p(i);
        startSmoothScroll(hVar);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.q == null;
    }
}
