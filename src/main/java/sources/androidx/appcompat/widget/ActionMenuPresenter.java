package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.q;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class ActionMenuPresenter extends b implements ActionProvider.SubUiVisibilityListener {
    OpenOverflowRunnable A;
    private b B;
    final e C;
    int D;
    c k;
    private Drawable l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private final SparseBooleanArray x;
    d y;
    a z;

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.x = new SparseBooleanArray();
        this.C = new e(this);
    }

    private View B(MenuItem menuItem) {
        ViewGroup viewGroup = ((b) this).i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            m.a childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof m.a) && childAt.getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        return D() | E();
    }

    public Drawable C() {
        c cVar = this.k;
        if (cVar != null) {
            return cVar.getDrawable();
        }
        if (this.m) {
            return this.l;
        }
        return null;
    }

    public boolean D() {
        View view;
        Runnable runnable = this.A;
        if (runnable != null && (view = ((b) this).i) != null) {
            view.removeCallbacks(runnable);
            this.A = null;
            return true;
        }
        d dVar = this.y;
        if (dVar == null) {
            return false;
        }
        dVar.b();
        return true;
    }

    public boolean E() {
        a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean F() {
        return this.A != null || G();
    }

    public boolean G() {
        d dVar = this.y;
        return dVar != null && dVar.d();
    }

    public boolean H() {
        return this.n;
    }

    public void I(Configuration configuration) {
        if (!this.s) {
            this.r = a.b(((b) this).b).d();
        }
        f fVar = ((b) this).c;
        if (fVar != null) {
            fVar.N(true);
        }
    }

    public void J(boolean z) {
        this.v = z;
    }

    public void K(ActionMenuView actionMenuView) {
        ((b) this).i = actionMenuView;
        actionMenuView.initialize(((b) this).c);
    }

    public void L(Drawable drawable) {
        c cVar = this.k;
        if (cVar != null) {
            cVar.setImageDrawable(drawable);
        } else {
            this.m = true;
            this.l = drawable;
        }
    }

    public void M(boolean z) {
        this.n = z;
        this.o = true;
    }

    public boolean N() {
        f fVar;
        if (!this.n || G() || (fVar = ((b) this).c) == null || ((b) this).i == null || this.A != null || fVar.B().isEmpty()) {
            return false;
        }
        Runnable openOverflowRunnable = new OpenOverflowRunnable(this, new d(this, ((b) this).b, ((b) this).c, this.k, true));
        this.A = openOverflowRunnable;
        ((b) this).i.post(openOverflowRunnable);
        return true;
    }

    public void b(f fVar, boolean z) {
        A();
        super.b(fVar, z);
    }

    public void e(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = ((b) this).c.findItem(i)) != null) {
            f((q) findItem.getSubMenu());
        }
    }

    public boolean f(q qVar) {
        boolean z = false;
        if (!qVar.hasVisibleItems()) {
            return false;
        }
        q qVar2 = qVar;
        while (qVar2.j0() != ((b) this).c) {
            qVar2 = (q) qVar2.j0();
        }
        View B = B(qVar2.getItem());
        if (B == null) {
            return false;
        }
        this.D = qVar.getItem().getItemId();
        int size = qVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = qVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        a aVar = new a(this, ((b) this).b, qVar, B);
        this.z = aVar;
        aVar.g(z);
        this.z.k();
        super.f(qVar);
        return true;
    }

    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.D;
        return savedState;
    }

    public void h(boolean z) {
        super.h(z);
        ((b) this).i.requestLayout();
        f fVar = ((b) this).c;
        boolean z2 = false;
        if (fVar != null) {
            ArrayList u = fVar.u();
            int size = u.size();
            for (int i = 0; i < size; i++) {
                ActionProvider a = ((h) u.get(i)).a();
                if (a != null) {
                    a.setSubUiVisibilityListener(this);
                }
            }
        }
        f fVar2 = ((b) this).c;
        ArrayList B = fVar2 != null ? fVar2.B() : null;
        if (this.n && B != null) {
            int size2 = B.size();
            if (size2 == 1) {
                z2 = !((h) B.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.k == null) {
                this.k = new c(this, ((b) this).a);
            }
            m mVar = (ViewGroup) this.k.getParent();
            if (mVar != ((b) this).i) {
                if (mVar != null) {
                    mVar.removeView(this.k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) ((b) this).i;
                actionMenuView.addView((View) this.k, (ViewGroup.LayoutParams) actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            c cVar = this.k;
            if (cVar != null) {
                m parent = cVar.getParent();
                ViewGroup viewGroup = ((b) this).i;
                if (parent == viewGroup) {
                    viewGroup.removeView(this.k);
                }
            }
        }
        ((ActionMenuView) ((b) this).i).setOverflowReserved(this.n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public boolean i() {
        ArrayList arrayList;
        int i;
        int i2;
        int i3;
        ?? r0;
        int i4;
        ActionMenuPresenter actionMenuPresenter = this;
        f fVar = ((b) actionMenuPresenter).c;
        View view = null;
        int i6 = 0;
        if (fVar != null) {
            arrayList = fVar.G();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i7 = actionMenuPresenter.r;
        int i8 = actionMenuPresenter.q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) ((b) actionMenuPresenter).i;
        boolean z = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            h hVar = (h) arrayList.get(i11);
            if (hVar.o()) {
                i9++;
            } else if (hVar.n()) {
                i10++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.v && hVar.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (actionMenuPresenter.n && (z || i10 + i9 > i7)) {
            i7--;
        }
        int i12 = i7 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.t) {
            int i13 = actionMenuPresenter.w;
            i3 = i8 / i13;
            i2 = i13 + ((i8 % i13) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < i) {
            h hVar2 = (h) arrayList.get(i14);
            if (hVar2.o()) {
                View p = actionMenuPresenter.p(hVar2, view, viewGroup);
                if (actionMenuPresenter.t) {
                    i3 -= ActionMenuView.g(p, i2, i3, makeMeasureSpec, i6);
                } else {
                    p.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = p.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i15 == 0) {
                    i15 = measuredWidth;
                }
                int groupId = hVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                hVar2.u(true);
                r0 = i6;
                i4 = i;
            } else if (hVar2.n()) {
                int groupId2 = hVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i12 > 0 || z2) && i8 > 0 && (!actionMenuPresenter.t || i3 > 0);
                boolean z4 = z3;
                i4 = i;
                if (z3) {
                    View p2 = actionMenuPresenter.p(hVar2, null, viewGroup);
                    if (actionMenuPresenter.t) {
                        int g = ActionMenuView.g(p2, i2, i3, makeMeasureSpec, 0);
                        i3 -= g;
                        if (g == 0) {
                            z4 = false;
                        }
                    } else {
                        p2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = p2.getMeasuredWidth();
                    i8 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    z3 = z5 & (!actionMenuPresenter.t ? i8 + i15 <= 0 : i8 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i16 = 0; i16 < i14; i16++) {
                        h hVar3 = (h) arrayList.get(i16);
                        if (hVar3.getGroupId() == groupId2) {
                            if (hVar3.l()) {
                                i12++;
                            }
                            hVar3.u(false);
                        }
                    }
                }
                if (z3) {
                    i12--;
                }
                hVar2.u(z3);
                r0 = 0;
            } else {
                r0 = i6;
                i4 = i;
                hVar2.u((boolean) r0);
            }
            i14++;
            i6 = r0;
            i = i4;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    public void k(Context context, f fVar) {
        super.k(context, fVar);
        Resources resources = context.getResources();
        a b = a.b(context);
        if (!this.o) {
            this.n = b.h();
        }
        if (!this.u) {
            this.p = b.c();
        }
        if (!this.s) {
            this.r = b.d();
        }
        int i = this.p;
        if (this.n) {
            if (this.k == null) {
                c cVar = new c(this, ((b) this).a);
                this.k = cVar;
                if (this.m) {
                    cVar.setImageDrawable(this.l);
                    this.l = null;
                    this.m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.k.getMeasuredWidth();
        } else {
            this.k = null;
        }
        this.q = i;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void l(h hVar, m.a aVar) {
        aVar.initialize(hVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) ((b) this).i);
        if (this.B == null) {
            this.B = new b(this);
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    public boolean n(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.k) {
            return false;
        }
        return super.n(viewGroup, i);
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.f((q) null);
            return;
        }
        f fVar = ((b) this).c;
        if (fVar != null) {
            fVar.e(false);
        }
    }

    public View p(h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.j()) {
            actionView = super.p(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public m q(ViewGroup viewGroup) {
        m mVar = ((b) this).i;
        m q = super.q(viewGroup);
        if (mVar != q) {
            ((ActionMenuView) q).setPresenter(this);
        }
        return q;
    }

    public boolean s(int i, h hVar) {
        return hVar.l();
    }
}
