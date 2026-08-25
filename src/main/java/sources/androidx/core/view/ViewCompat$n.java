package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ViewCompat$n {
    static WindowInsets a(View view, WindowInsets windowInsets) {
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    static int b(View view) {
        return view.getImportantForContentCapture();
    }

    static CharSequence c(View view) {
        return view.getStateDescription();
    }

    public static WindowInsetsControllerCompat d(View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController);
        }
        return null;
    }

    static boolean e(View view) {
        return view.isImportantForContentCapture();
    }

    static void f(View view, int i5) {
        view.setImportantForContentCapture(i5);
    }

    static void g(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}
