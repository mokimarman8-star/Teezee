package androidx.drawerlayout.widget;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class DrawerLayout$b implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DrawerLayout f7800a;

    DrawerLayout$b(DrawerLayout drawerLayout) {
        this.f7800a = drawerLayout;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
