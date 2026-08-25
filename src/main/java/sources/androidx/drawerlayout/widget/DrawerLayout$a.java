package androidx.drawerlayout.widget;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class DrawerLayout$a implements AccessibilityViewCommand {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DrawerLayout f7799a;

    DrawerLayout$a(DrawerLayout drawerLayout) {
        this.f7799a = drawerLayout;
    }

    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        if (!this.f7799a.isDrawerOpen(view) || this.f7799a.getDrawerLockMode(view) == 2) {
            return false;
        }
        this.f7799a.closeDrawer(view);
        return true;
    }
}
