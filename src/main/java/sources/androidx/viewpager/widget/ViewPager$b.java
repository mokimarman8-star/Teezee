package androidx.viewpager.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewPager$b implements OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f13737a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewPager f13738b;

    ViewPager$b(ViewPager viewPager) {
        this.f13738b = viewPager;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        if (onApplyWindowInsets.isConsumed()) {
            return onApplyWindowInsets;
        }
        Rect rect = this.f13737a;
        rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
        rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
        rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
        rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
        int childCount = this.f13738b.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(this.f13738b.getChildAt(i5), onApplyWindowInsets);
            rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
            rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
            rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
            rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
        }
        return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
    }
}
