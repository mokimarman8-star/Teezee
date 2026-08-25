package androidx.appcompat.app;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatDelegateImpl$a implements OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f229a;

    AppCompatDelegateImpl$a(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f229a = appCompatDelegateImpl;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        int h12 = this.f229a.h1(windowInsetsCompat, (Rect) null);
        if (systemWindowInsetTop != h12) {
            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), h12, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        }
        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
    }
}
