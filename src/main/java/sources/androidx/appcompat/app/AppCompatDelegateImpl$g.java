package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.b;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatDelegateImpl$g implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private b.a f234a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f235b;

    class a extends ViewPropertyAnimatorListenerAdapter {
        a() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            AppCompatDelegateImpl$g.this.f235b.v.setVisibility(8);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl$g.this.f235b;
            PopupWindow popupWindow = appCompatDelegateImpl.w;
            if (popupWindow != null) {
                popupWindow.dismiss();
            } else if (appCompatDelegateImpl.v.getParent() instanceof View) {
                ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl$g.this.f235b.v.getParent());
            }
            AppCompatDelegateImpl$g.this.f235b.v.killMode();
            AppCompatDelegateImpl$g.this.f235b.y.setListener((ViewPropertyAnimatorListener) null);
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl$g.this.f235b;
            appCompatDelegateImpl2.y = null;
            ViewCompat.requestApplyInsets(appCompatDelegateImpl2.B);
        }
    }

    public AppCompatDelegateImpl$g(AppCompatDelegateImpl appCompatDelegateImpl, b.a aVar) {
        this.f235b = appCompatDelegateImpl;
        this.f234a = aVar;
    }

    @Override // androidx.appcompat.view.b.a
    public void a(androidx.appcompat.view.b bVar) {
        this.f234a.a(bVar);
        AppCompatDelegateImpl appCompatDelegateImpl = this.f235b;
        if (appCompatDelegateImpl.w != null) {
            appCompatDelegateImpl.l.getDecorView().removeCallbacks(this.f235b.x);
        }
        AppCompatDelegateImpl appCompatDelegateImpl2 = this.f235b;
        if (appCompatDelegateImpl2.v != null) {
            appCompatDelegateImpl2.m0();
            AppCompatDelegateImpl appCompatDelegateImpl3 = this.f235b;
            appCompatDelegateImpl3.y = ViewCompat.animate(appCompatDelegateImpl3.v).alpha(0.0f);
            this.f235b.y.setListener(new a());
        }
        AppCompatDelegateImpl appCompatDelegateImpl4 = this.f235b;
        d dVar = appCompatDelegateImpl4.n;
        if (dVar != null) {
            dVar.onSupportActionModeFinished(appCompatDelegateImpl4.u);
        }
        AppCompatDelegateImpl appCompatDelegateImpl5 = this.f235b;
        appCompatDelegateImpl5.u = null;
        ViewCompat.requestApplyInsets(appCompatDelegateImpl5.B);
        this.f235b.f1();
    }

    @Override // androidx.appcompat.view.b.a
    public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
        return this.f234a.b(bVar, menu);
    }

    @Override // androidx.appcompat.view.b.a
    public boolean c(androidx.appcompat.view.b bVar, MenuItem menuItem) {
        return this.f234a.c(bVar, menuItem);
    }

    @Override // androidx.appcompat.view.b.a
    public boolean d(androidx.appcompat.view.b bVar, Menu menu) {
        ViewCompat.requestApplyInsets(this.f235b.B);
        return this.f234a.d(bVar, menu);
    }
}
