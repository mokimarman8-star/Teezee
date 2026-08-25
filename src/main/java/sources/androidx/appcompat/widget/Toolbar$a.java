package androidx.appcompat.widget;

import android.view.MenuItem;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Toolbar$a implements ActionMenuView$e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f950a;

    Toolbar$a(Toolbar toolbar) {
        this.f950a = toolbar;
    }

    @Override // androidx.appcompat.widget.ActionMenuView$e
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.f950a.G.onMenuItemSelected(menuItem)) {
            return true;
        }
        Toolbar$g toolbar$g = this.f950a.I;
        if (toolbar$g != null) {
            return toolbar$g.onMenuItemClick(menuItem);
        }
        return false;
    }
}
