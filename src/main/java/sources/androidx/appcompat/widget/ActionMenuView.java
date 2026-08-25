package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements f.b, m {
    private f a;
    private Context b;
    private int c;
    private boolean d;
    private ActionMenuPresenter e;
    private l.a f;
    f.a g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    e l;

    public ActionMenuView(@NonNull Context context) {
        this(context, null);
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.j = (int) (56.0f * f);
        this.k = (int) (f * 4.0f);
        this.b = context;
        this.c = 0;
    }

    static int g(View view, int i, int i2, int i3, int i4) {
        int i6;
        c layoutParams = view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.hasText();
        if (i2 > 0) {
            i6 = 2;
            if (!z2 || i2 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i7 = measuredWidth / i;
                if (measuredWidth % i != 0) {
                    i7++;
                }
                if (!z2 || i7 >= 2) {
                    i6 = i7;
                }
                if (!layoutParams.a && z2) {
                    z = true;
                }
                layoutParams.d = z;
                layoutParams.b = i6;
                view.measure(View.MeasureSpec.makeMeasureSpec(i * i6, 1073741824), makeMeasureSpec);
                return i6;
            }
        }
        i6 = 0;
        if (!layoutParams.a) {
            z = true;
        }
        layoutParams.d = z;
        layoutParams.b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void h(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i6;
        int i7;
        boolean z2;
        boolean z3;
        int i8;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i9 = size - paddingLeft;
        int i10 = this.j;
        int i11 = i9 / i10;
        int i12 = i9 % i10;
        if (i11 == 0) {
            setMeasuredDimension(i9, 0);
            return;
        }
        int i13 = i10 + (i12 / i11);
        int childCount = getChildCount();
        int i14 = 0;
        int i15 = 0;
        boolean z4 = false;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        long j = 0;
        while (i15 < childCount) {
            ActionMenuItemView childAt = getChildAt(i15);
            int i19 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i20 = i16 + 1;
                if (z5) {
                    int i21 = this.k;
                    i8 = i20;
                    r14 = 0;
                    childAt.setPadding(i21, 0, i21, 0);
                } else {
                    i8 = i20;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f = r14;
                cVar.c = r14;
                cVar.b = r14;
                cVar.d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.e = z5 && childAt.hasText();
                int g = g(childAt, i13, cVar.a ? 1 : i11, childMeasureSpec, paddingTop);
                i17 = Math.max(i17, g);
                if (cVar.d) {
                    i18++;
                }
                if (cVar.a) {
                    z4 = true;
                }
                i11 -= g;
                i14 = Math.max(i14, childAt.getMeasuredHeight());
                if (g == 1) {
                    j |= 1 << i15;
                    i14 = i14;
                }
                i16 = i8;
            }
            i15++;
            size2 = i19;
        }
        int i22 = size2;
        boolean z6 = z4 && i16 == 2;
        boolean z7 = false;
        while (i18 > 0 && i11 > 0) {
            int i23 = Integer.MAX_VALUE;
            int i24 = 0;
            int i25 = 0;
            long j2 = 0;
            while (i25 < childCount) {
                boolean z8 = z7;
                c layoutParams = getChildAt(i25).getLayoutParams();
                int i26 = i14;
                if (layoutParams.d) {
                    int i27 = layoutParams.b;
                    if (i27 < i23) {
                        j2 = 1 << i25;
                        i23 = i27;
                        i24 = 1;
                    } else if (i27 == i23) {
                        i24++;
                        j2 |= 1 << i25;
                    }
                }
                i25++;
                i14 = i26;
                z7 = z8;
            }
            z = z7;
            i6 = i14;
            j |= j2;
            if (i24 > i11) {
                i3 = mode;
                i4 = i9;
                break;
            }
            int i28 = i23 + 1;
            int i29 = 0;
            while (i29 < childCount) {
                View childAt2 = getChildAt(i29);
                c layoutParams2 = childAt2.getLayoutParams();
                int i30 = i9;
                int i31 = mode;
                long j3 = 1 << i29;
                if ((j2 & j3) == 0) {
                    if (layoutParams2.b == i28) {
                        j |= j3;
                    }
                    z3 = z6;
                } else {
                    if (z6 && layoutParams2.e && i11 == 1) {
                        int i32 = this.k;
                        z3 = z6;
                        childAt2.setPadding(i32 + i13, 0, i32, 0);
                    } else {
                        z3 = z6;
                    }
                    layoutParams2.b++;
                    layoutParams2.f = true;
                    i11--;
                }
                i29++;
                mode = i31;
                i9 = i30;
                z6 = z3;
            }
            i14 = i6;
            z7 = true;
        }
        i3 = mode;
        i4 = i9;
        z = z7;
        i6 = i14;
        boolean z9 = !z4 && i16 == 1;
        if (i11 <= 0 || j == 0 || (i11 >= i16 - 1 && !z9 && i17 <= 1)) {
            i7 = 0;
            z2 = z;
        } else {
            float bitCount = Long.bitCount(j);
            if (z9) {
                i7 = 0;
            } else {
                i7 = 0;
                if ((j & 1) != 0 && !getChildAt(0).getLayoutParams().e) {
                    bitCount -= 0.5f;
                }
                int i33 = childCount - 1;
                if ((j & (1 << i33)) != 0 && !getChildAt(i33).getLayoutParams().e) {
                    bitCount -= 0.5f;
                }
            }
            int i34 = bitCount > 0.0f ? (int) ((i11 * i13) / bitCount) : i7;
            z2 = z;
            for (int i35 = i7; i35 < childCount; i35++) {
                if ((j & (1 << i35)) != 0) {
                    View childAt3 = getChildAt(i35);
                    c layoutParams3 = childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams3.c = i34;
                        layoutParams3.f = true;
                        if (i35 == 0 && !layoutParams3.e) {
                            ((LinearLayout.LayoutParams) layoutParams3).leftMargin = (-i34) / 2;
                        }
                        z2 = true;
                    } else if (layoutParams3.a) {
                        layoutParams3.c = i34;
                        layoutParams3.f = true;
                        ((LinearLayout.LayoutParams) layoutParams3).rightMargin = (-i34) / 2;
                        z2 = true;
                    } else {
                        if (i35 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams3).leftMargin = i34 / 2;
                        }
                        if (i35 != childCount - 1) {
                            ((LinearLayout.LayoutParams) layoutParams3).rightMargin = i34 / 2;
                        }
                    }
                }
            }
        }
        if (z2) {
            for (int i36 = i7; i36 < childCount; i36++) {
                View childAt4 = getChildAt(i36);
                c layoutParams4 = childAt4.getLayoutParams();
                if (layoutParams4.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams4.b * i13) + layoutParams4.c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i3 != 1073741824 ? i6 : i22);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    protected boolean f(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        a childAt = getChildAt(i - 1);
        a childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = childAt.needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : z | childAt2.needsDividerBefore();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public c generateOverflowButtonLayoutParams() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.a = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.a == null) {
            Context context = getContext();
            f fVar = new f(context);
            this.a = fVar;
            fVar.W(new d(this));
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.e = actionMenuPresenter;
            actionMenuPresenter.M(true);
            ActionMenuPresenter actionMenuPresenter2 = this.e;
            b bVar = this.f;
            if (bVar == null) {
                bVar = new b();
            }
            actionMenuPresenter2.d(bVar);
            this.a.c(this.e, this.b);
            this.e.K(this);
        }
        return this.a;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.e.C();
    }

    public int getPopupTheme() {
        return this.c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        return actionMenuPresenter != null && actionMenuPresenter.D();
    }

    public void initialize(f fVar) {
        this.a = fVar;
    }

    public boolean invokeItem(h hVar) {
        return this.a.O(hVar, 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        return actionMenuPresenter != null && actionMenuPresenter.F();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        return actionMenuPresenter != null && actionMenuPresenter.G();
    }

    public boolean isOverflowReserved() {
        return this.d;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.e;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h(false);
            if (this.e.G()) {
                this.e.D();
                this.e.N();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int i6;
        if (!this.h) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean b = u0.b(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c layoutParams = childAt.getLayoutParams();
                if (layoutParams.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (f(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b) {
                        i6 = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = i6 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        i6 = width - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(i6, i12, width, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    f(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int max = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (b) {
            int width2 = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                c layoutParams2 = childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.a) {
                    int i17 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width2 = i17 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            c layoutParams3 = childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.a) {
                int i20 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + max;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        f fVar;
        boolean z = this.h;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.h = z2;
        if (z != z2) {
            this.i = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.h && (fVar = this.a) != null && size != this.i) {
            this.i = size;
            fVar.N(true);
        }
        int childCount = getChildCount();
        if (this.h && childCount > 0) {
            h(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c layoutParams = getChildAt(i3).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public f peekMenu() {
        return this.a;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.e.J(z);
    }

    public void setMenuCallbacks(l.a aVar, f.a aVar2) {
        this.f = aVar;
        this.g = aVar2;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.l = eVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.e.L(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.d = z;
    }

    public void setPopupTheme(int i) {
        if (this.c != i) {
            this.c = i;
            if (i == 0) {
                this.b = getContext();
            } else {
                this.b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.e = actionMenuPresenter;
        actionMenuPresenter.K(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.e;
        return actionMenuPresenter != null && actionMenuPresenter.N();
    }
}
