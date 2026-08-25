package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.a;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    private ColorStateList A;
    private boolean B;
    private boolean C;
    private final ArrayList D;
    private final ArrayList E;
    private final int[] F;
    final MenuHostHelper G;
    private ArrayList H;
    g I;
    private final ActionMenuView.e J;
    private n0 K;
    private ActionMenuPresenter L;
    private e M;
    private l.a N;
    f.a O;
    private boolean P;
    private OnBackInvokedCallback Q;
    private OnBackInvokedDispatcher R;
    private boolean S;
    private final Runnable T;
    ActionMenuView a;
    private TextView b;
    private TextView c;
    private ImageButton d;
    private ImageView e;
    private Drawable f;
    private CharSequence g;
    ImageButton h;
    View i;
    private Context j;
    private int k;
    private int l;
    private int m;
    int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private d0 t;
    private int u;
    private int v;
    private int w;
    private CharSequence x;
    private CharSequence y;
    private ColorStateList z;

    public Toolbar(@NonNull Context context) {
        this(context, null);
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 8388627;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.G = new MenuHostHelper(new Runnable() { // from class: androidx.appcompat.widget.l0
            @Override // java.lang.Runnable
            public final void run() {
                Toolbar.this.invalidateMenu();
            }
        });
        this.H = new ArrayList();
        this.J = new a(this);
        this.T = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        j0 v = j0.v(getContext(), attributeSet, R$styleable.Toolbar, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.Toolbar, attributeSet, v.r(), i, 0);
        this.l = v.n(R$styleable.Toolbar_titleTextAppearance, 0);
        this.m = v.n(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.w = v.l(R$styleable.Toolbar_android_gravity, this.w);
        this.n = v.l(R$styleable.Toolbar_buttonGravity, 48);
        int e = v.e(R$styleable.Toolbar_titleMargin, 0);
        e = v.s(R$styleable.Toolbar_titleMargins) ? v.e(R$styleable.Toolbar_titleMargins, e) : e;
        this.s = e;
        this.r = e;
        this.q = e;
        this.p = e;
        int e3 = v.e(R$styleable.Toolbar_titleMarginStart, -1);
        if (e3 >= 0) {
            this.p = e3;
        }
        int e4 = v.e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (e4 >= 0) {
            this.q = e4;
        }
        int e5 = v.e(R$styleable.Toolbar_titleMarginTop, -1);
        if (e5 >= 0) {
            this.r = e5;
        }
        int e6 = v.e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (e6 >= 0) {
            this.s = e6;
        }
        this.o = v.f(R$styleable.Toolbar_maxButtonHeight, -1);
        int e7 = v.e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int e8 = v.e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int f = v.f(R$styleable.Toolbar_contentInsetLeft, 0);
        int f2 = v.f(R$styleable.Toolbar_contentInsetRight, 0);
        e();
        this.t.e(f, f2);
        if (e7 != Integer.MIN_VALUE || e8 != Integer.MIN_VALUE) {
            this.t.g(e7, e8);
        }
        this.u = v.e(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.v = v.e(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f = v.g(R$styleable.Toolbar_collapseIcon);
        this.g = v.p(R$styleable.Toolbar_collapseContentDescription);
        CharSequence p = v.p(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(p)) {
            setTitle(p);
        }
        CharSequence p2 = v.p(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(p2)) {
            setSubtitle(p2);
        }
        this.j = getContext();
        setPopupTheme(v.n(R$styleable.Toolbar_popupTheme, 0));
        Drawable g = v.g(R$styleable.Toolbar_navigationIcon);
        if (g != null) {
            setNavigationIcon(g);
        }
        CharSequence p3 = v.p(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(p3)) {
            setNavigationContentDescription(p3);
        }
        Drawable g2 = v.g(R$styleable.Toolbar_logo);
        if (g2 != null) {
            setLogo(g2);
        }
        CharSequence p4 = v.p(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(p4)) {
            setLogoDescription(p4);
        }
        if (v.s(R$styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(v.c(R$styleable.Toolbar_titleTextColor));
        }
        if (v.s(R$styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(v.c(R$styleable.Toolbar_subtitleTextColor));
        }
        if (v.s(R$styleable.Toolbar_menu)) {
            inflateMenu(v.n(R$styleable.Toolbar_menu, 0));
        }
        v.x();
    }

    private boolean A(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List list, int i) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, getLayoutDirection());
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                f layoutParams = childAt.getLayoutParams();
                if (layoutParams.b == 0 && A(childAt) && l(((a.a) layoutParams).a) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            f layoutParams2 = childAt2.getLayoutParams();
            if (layoutParams2.b == 0 && A(childAt2) && l(((a.a) layoutParams2).a) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z) {
        f layoutParams = view.getLayoutParams();
        f generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        generateDefaultLayoutParams.b = 1;
        if (!z || this.i == null) {
            addView(view, (ViewGroup.LayoutParams) generateDefaultLayoutParams);
        } else {
            view.setLayoutParams(generateDefaultLayoutParams);
            this.E.add(view);
        }
    }

    private void e() {
        if (this.t == null) {
            this.t = new d0();
        }
    }

    private void f() {
        if (this.e == null) {
            this.e = new AppCompatImageView(getContext());
        }
    }

    private void g() {
        h();
        if (this.a.peekMenu() == null) {
            f menu = this.a.getMenu();
            if (this.M == null) {
                this.M = new e(this);
            }
            this.a.setExpandedActionViewsExclusive(true);
            menu.c(this.M, this.j);
            B();
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new g(getContext());
    }

    private void h() {
        if (this.a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.a = actionMenuView;
            actionMenuView.setPopupTheme(this.k);
            this.a.setOnMenuItemClickListener(this.J);
            this.a.setMenuCallbacks(this.N, new b(this));
            ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            ((a.a) generateDefaultLayoutParams).a = (this.n & 112) | GravityCompat.END;
            this.a.setLayoutParams(generateDefaultLayoutParams);
            c(this.a, false);
        }
    }

    private void i() {
        if (this.d == null) {
            this.d = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            ((a.a) generateDefaultLayoutParams).a = (this.n & 112) | GravityCompat.START;
            this.d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int l(int i) {
        int layoutDirection = getLayoutDirection();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        return (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) ? absoluteGravity : layoutDirection == 1 ? 5 : 3;
    }

    private int m(View view, int i) {
        f layoutParams = view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int n = n(((a.a) layoutParams).a);
        if (n == 48) {
            return getPaddingTop() - i2;
        }
        if (n == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (i3 < i4) {
            i3 = i4;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i6 < i7) {
                i3 = Math.max(0, i3 - (i7 - i6));
            }
        }
        return paddingTop + i3;
    }

    private int n(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.w & 112;
    }

    private int o(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    private int p(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int q(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            View view = (View) list.get(i3);
            f layoutParams = view.getLayoutParams();
            int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i;
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i2;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i7);
            int max3 = Math.max(0, -i6);
            int max4 = Math.max(0, -i7);
            i4 += max + view.getMeasuredWidth() + max2;
            i3++;
            i2 = max4;
            i = max3;
        }
        return i4;
    }

    private boolean r(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    private int s(View view, int i, int[] iArr, int i2) {
        f layoutParams = view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int m = m(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, m, max + measuredWidth, view.getMeasuredHeight() + m);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int t(View view, int i, int[] iArr, int i2) {
        f layoutParams = view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int m = m(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, m, max, view.getMeasuredHeight() + m);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    private int u(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void v(View view, int i, int i2, int i3, int i4, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void w() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.G.onCreateMenu(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.H = currentMenuItems2;
    }

    private void x() {
        removeCallbacks(this.T);
        post(this.T);
    }

    private boolean z() {
        if (!this.P) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (A(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    void B() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a = d.a(this);
            boolean z = hasExpandedActionView() && a != null && isAttachedToWindow() && this.S;
            if (z && this.R == null) {
                if (this.Q == null) {
                    this.Q = d.b(new k0(this));
                }
                d.c(a, this.Q);
                this.R = a;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.R) == null) {
                return;
            }
            d.d(onBackInvokedDispatcher, this.Q);
            this.R = null;
        }
    }

    void a() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView((View) this.E.get(size));
        }
        this.E.clear();
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.G.addMenuProvider(menuProvider);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull u uVar) {
        this.G.addMenuProvider(menuProvider, uVar);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull u uVar, @NonNull Lifecycle.State state) {
        this.G.addMenuProvider(menuProvider, uVar, state);
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.a) != null && actionMenuView.isOverflowReserved();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof f);
    }

    public void collapseActionView() {
        e eVar = this.M;
        h hVar = eVar == null ? null : eVar.b;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    void d() {
        if (this.h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            ((a.a) generateDefaultLayoutParams).a = (this.n & 112) | GravityCompat.START;
            ((f) generateDefaultLayoutParams).b = 2;
            this.h.setLayoutParams(generateDefaultLayoutParams);
            this.h.setOnClickListener(new c(this));
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        d0 d0Var = this.t;
        if (d0Var != null) {
            return d0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.v;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        d0 d0Var = this.t;
        if (d0Var != null) {
            return d0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        d0 d0Var = this.t;
        if (d0Var != null) {
            return d0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        d0 d0Var = this.t;
        if (d0Var != null) {
            return d0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.u;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        f peekMenu;
        ActionMenuView actionMenuView = this.a;
        return (actionMenuView == null || (peekMenu = actionMenuView.peekMenu()) == null || !peekMenu.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        g();
        return this.a.getMenu();
    }

    @Nullable
    View getNavButtonView() {
        return this.d;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.L;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        g();
        return this.a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    @Nullable
    final TextView getSubtitleTextView() {
        return this.c;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    @Nullable
    final TextView getTitleTextView() {
        return this.b;
    }

    public t getWrapper() {
        if (this.K == null) {
            this.K = new n0(this, true);
        }
        return this.K;
    }

    public boolean hasExpandedActionView() {
        e eVar = this.M;
        return (eVar == null || eVar.b == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.hideOverflowMenu();
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    @Override // androidx.core.view.MenuHost
    public void invalidateMenu() {
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        w();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.S;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.b;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof a.a ? new f((a.a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        B();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.T);
        B();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02a1 A[LOOP:0: B:41:0x029f->B:42:0x02a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c3 A[LOOP:1: B:45:0x02c1->B:46:0x02c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02fc A[LOOP:2: B:54:0x02fa->B:55:0x02fc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.F;
        boolean b = u0.b(this);
        int i11 = !b ? 1 : 0;
        if (A(this.d)) {
            v(this.d, i, 0, i2, 0, this.o);
            i3 = this.d.getMeasuredWidth() + o(this.d);
            i4 = Math.max(0, this.d.getMeasuredHeight() + p(this.d));
            i6 = View.combineMeasuredStates(0, this.d.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i6 = 0;
        }
        if (A(this.h)) {
            v(this.h, i, 0, i2, 0, this.o);
            i3 = this.h.getMeasuredWidth() + o(this.h);
            i4 = Math.max(i4, this.h.getMeasuredHeight() + p(this.h));
            i6 = View.combineMeasuredStates(i6, this.h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i3);
        iArr[b ? 1 : 0] = Math.max(0, currentContentInsetStart - i3);
        if (A(this.a)) {
            v(this.a, i, max, i2, 0, this.o);
            i7 = this.a.getMeasuredWidth() + o(this.a);
            i4 = Math.max(i4, this.a.getMeasuredHeight() + p(this.a));
            i6 = View.combineMeasuredStates(i6, this.a.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[i11] = Math.max(0, currentContentInsetEnd - i7);
        if (A(this.i)) {
            max2 += u(this.i, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.i.getMeasuredHeight() + p(this.i));
            i6 = View.combineMeasuredStates(i6, this.i.getMeasuredState());
        }
        if (A(this.e)) {
            max2 += u(this.e, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.e.getMeasuredHeight() + p(this.e));
            i6 = View.combineMeasuredStates(i6, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getLayoutParams().b == 0 && A(childAt)) {
                max2 += u(childAt, i, max2, i2, 0, iArr);
                i4 = Math.max(i4, childAt.getMeasuredHeight() + p(childAt));
                i6 = View.combineMeasuredStates(i6, childAt.getMeasuredState());
            }
        }
        int i13 = this.r + this.s;
        int i14 = this.p + this.q;
        if (A(this.b)) {
            u(this.b, i, max2 + i14, i2, i13, iArr);
            int measuredWidth = this.b.getMeasuredWidth() + o(this.b);
            i8 = this.b.getMeasuredHeight() + p(this.b);
            i9 = View.combineMeasuredStates(i6, this.b.getMeasuredState());
            i10 = measuredWidth;
        } else {
            i8 = 0;
            i9 = i6;
            i10 = 0;
        }
        if (A(this.c)) {
            i10 = Math.max(i10, u(this.c, i, max2 + i14, i2, i8 + i13, iArr));
            i8 += this.c.getMeasuredHeight() + p(this.c);
            i9 = View.combineMeasuredStates(i9, this.c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i10 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, (-16777216) & i9), z() ? 0 : View.resolveSizeAndState(Math.max(Math.max(i4, i8) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i9 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.a;
        f peekMenu = actionMenuView != null ? actionMenuView.peekMenu() : null;
        int i = savedState.expandedMenuItemId;
        if (i != 0 && this.M != null && peekMenu != null && (findItem = peekMenu.findItem(i)) != null) {
            findItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            x();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        e();
        this.t.f(i == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        h hVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        e eVar = this.M;
        if (eVar != null && (hVar = eVar.b) != null) {
            savedState.expandedMenuItemId = hVar.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.G.removeMenuProvider(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.S != z) {
            this.S = z;
            B();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            d();
        }
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(g.a.b(getContext(), i));
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            d();
            this.h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f);
            }
        }
    }

    public void setCollapsible(boolean z) {
        this.P = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.u) {
            this.u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        e();
        this.t.e(i, i2);
    }

    public void setContentInsetsRelative(int i, int i2) {
        e();
        this.t.g(i, i2);
    }

    public void setLogo(int i) {
        setLogo(g.a.b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!r(this.e)) {
                c(this.e, true);
            }
        } else {
            ImageView imageView = this.e;
            if (imageView != null && r(imageView)) {
                removeView(this.e);
                this.E.remove(this.e);
            }
        }
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setMenu(f fVar, ActionMenuPresenter actionMenuPresenter) {
        if (fVar == null && this.a == null) {
            return;
        }
        h();
        f peekMenu = this.a.peekMenu();
        if (peekMenu == fVar) {
            return;
        }
        if (peekMenu != null) {
            peekMenu.R(this.L);
            peekMenu.R(this.M);
        }
        if (this.M == null) {
            this.M = new e(this);
        }
        actionMenuPresenter.J(true);
        if (fVar != null) {
            fVar.c(actionMenuPresenter, this.j);
            fVar.c(this.M, this.j);
        } else {
            actionMenuPresenter.k(this.j, null);
            this.M.k(this.j, (f) null);
            actionMenuPresenter.h(true);
            this.M.h(true);
        }
        this.a.setPopupTheme(this.k);
        this.a.setPresenter(actionMenuPresenter);
        this.L = actionMenuPresenter;
        B();
    }

    public void setMenuCallbacks(l.a aVar, f.a aVar2) {
        this.N = aVar;
        this.O = aVar2;
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(aVar, aVar2);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            o0.a(this.d, charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(g.a.b(getContext(), i));
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            i();
            if (!r(this.d)) {
                c(this.d, true);
            }
        } else {
            ImageButton imageButton = this.d;
            if (imageButton != null && r(imageButton)) {
                removeView(this.d);
                this.E.remove(this.d);
            }
        }
        ImageButton imageButton2 = this.d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        i();
        this.d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(g gVar) {
        this.I = gVar;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        g();
        this.a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.c;
            if (textView != null && r(textView)) {
                removeView(this.c);
                this.E.remove(this.c);
            }
        } else {
            if (this.c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.m;
                if (i != 0) {
                    this.c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
            }
            if (!r(this.c)) {
                c(this.c, true);
            }
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.m = i;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.b;
            if (textView != null && r(textView)) {
                removeView(this.b);
                this.E.remove(this.b);
            }
        } else {
            if (this.b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.l;
                if (i != 0) {
                    this.b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.z;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
            }
            if (!r(this.b)) {
                c(this.b, true);
            }
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.x = charSequence;
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.p = i;
        this.r = i2;
        this.q = i3;
        this.s = i4;
        requestLayout();
    }

    public void setTitleMarginBottom(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.l = i;
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.z = colorStateList;
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.showOverflowMenu();
    }

    void y() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getLayoutParams().b != 2 && childAt != this.a) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }
}
