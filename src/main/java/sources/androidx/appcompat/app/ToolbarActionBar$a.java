package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar$g;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ToolbarActionBar$a implements Toolbar$g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ToolbarActionBar f251a;

    ToolbarActionBar$a(ToolbarActionBar toolbarActionBar) {
        this.f251a = toolbarActionBar;
    }

    @Override // androidx.appcompat.widget.Toolbar$g
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f251a.b.onMenuItemSelected(0, menuItem);
    }
}
