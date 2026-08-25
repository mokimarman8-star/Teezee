package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewCompat$g {
    static WindowInsets a(View view, WindowInsets windowInsets) {
        return ViewGroupCompat.sCompatInsetsDispatchInstalled ? ViewGroupCompat.dispatchApplyWindowInsets(view, windowInsets) : view.dispatchApplyWindowInsets(windowInsets);
    }

    static WindowInsets b(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    static void c(View view) {
        view.requestApplyInsets();
    }
}
