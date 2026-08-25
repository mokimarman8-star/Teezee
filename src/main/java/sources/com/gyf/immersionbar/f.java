package com.gyf.immersionbar;

import android.R;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class f implements ViewTreeObserver.OnGlobalLayoutListener {
    private ImmersionBar a;
    private Window b;
    private View c;
    private View d;
    private View e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View] */
    f(ImmersionBar immersionBar) {
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.a = immersionBar;
        Window window = immersionBar.getWindow();
        this.b = window;
        View decorView = window.getDecorView();
        this.c = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
        if (immersionBar.isDialogFragment()) {
            Fragment supportFragment = immersionBar.getSupportFragment();
            if (supportFragment != null) {
                this.e = supportFragment.getView();
            } else {
                android.app.Fragment fragment = immersionBar.getFragment();
                if (fragment != null) {
                    this.e = fragment.getView();
                }
            }
        } else {
            DrawerLayout childAt = frameLayout.getChildAt(0);
            this.e = childAt;
            if (childAt != null && (childAt instanceof DrawerLayout)) {
                this.e = childAt.getChildAt(0);
            }
        }
        View view = this.e;
        if (view != null) {
            this.f = view.getPaddingLeft();
            this.g = this.e.getPaddingTop();
            this.h = this.e.getPaddingRight();
            this.i = this.e.getPaddingBottom();
        }
        ?? r4 = this.e;
        this.d = r4 != 0 ? r4 : frameLayout;
    }

    void a() {
        if (this.k) {
            this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.k = false;
        }
    }

    void b() {
        if (this.k) {
            if (this.e != null) {
                this.d.setPadding(this.f, this.g, this.h, this.i);
            } else {
                this.d.setPadding(this.a.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), this.a.getPaddingBottom());
            }
        }
    }

    void c(int i) {
        this.b.setSoftInputMode(i);
        if (this.k) {
            return;
        }
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.k = true;
    }

    void d() {
        this.j = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ba, code lost:
    
        if ((r3 - r1) > r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGlobalLayout() {
        ImmersionBar immersionBar = this.a;
        if (immersionBar == null || immersionBar.getBarParams() == null || !this.a.getBarParams().F) {
            return;
        }
        a barConfig = this.a.getBarConfig();
        int d = barConfig.n() ? barConfig.d() : barConfig.g();
        Rect rect = new Rect();
        this.c.getWindowVisibleDisplayFrame(rect);
        int height = this.d.getHeight() - rect.bottom;
        if (height == this.j) {
            return;
        }
        this.j = height;
        int i = 0;
        int i2 = 1;
        if (!ImmersionBar.checkFitsSystemWindows(this.b.getDecorView().findViewById(R.id.content))) {
            if (this.e != null) {
                if (this.a.getBarParams().E) {
                    height += this.a.getActionBarHeight() + barConfig.k();
                }
                if (this.a.getBarParams().y) {
                    height += barConfig.k();
                }
                if (height > d) {
                    i = height + this.i;
                } else {
                    i2 = 0;
                }
                this.d.setPadding(this.f, this.g, this.h, i);
                i = i2;
                this.a.getBarParams().getClass();
                if (i == 0 && this.a.getBarParams().j != BarHide.FLAG_SHOW_BAR) {
                    this.a.setBar();
                }
                if (i != 0) {
                    this.a.fitsParentBarKeyboard();
                    return;
                }
                return;
            }
            int paddingBottom = this.a.getPaddingBottom();
            int i3 = height - d;
            if (i3 > d) {
                paddingBottom = i3 + d;
                i = 1;
            }
            this.d.setPadding(this.a.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), paddingBottom);
            this.a.getBarParams().getClass();
            if (i == 0) {
                this.a.setBar();
            }
            if (i != 0) {
            }
        }
    }
}
