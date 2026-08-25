package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ViewCompat$i {
    public static WindowInsetsCompat a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
        windowInsetsCompat.setRootWindowInsets(windowInsetsCompat);
        windowInsetsCompat.copyRootViewBounds(view.getRootView());
        return windowInsetsCompat;
    }

    static int b(View view) {
        return view.getScrollIndicators();
    }

    static void c(View view, int i5) {
        view.setScrollIndicators(i5);
    }

    static void d(View view, int i5, int i6) {
        view.setScrollIndicators(i5, i6);
    }
}
