package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MenuCompat {

    static class a {
        static void a(Menu menu, boolean z5) {
            menu.setGroupDividerEnabled(z5);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(Menu menu, boolean z5) {
        if (menu instanceof b1.a) {
            ((b1.a) menu).setGroupDividerEnabled(z5);
        } else if (Build.VERSION.SDK_INT >= 28) {
            a.a(menu, z5);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i5) {
        menuItem.setShowAsAction(i5);
    }
}
