package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.util.i;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(int i5) {
        i.e(i5, "Margin must be non-negative");
        this.mMarginPx = i5;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewPager2 parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    public void transformPage(@NonNull View view, float f5) {
        ViewPager2 requireViewPager = requireViewPager(view);
        float f6 = this.mMarginPx * f5;
        if (requireViewPager.getOrientation() != 0) {
            view.setTranslationY(f6);
            return;
        }
        if (requireViewPager.isRtl()) {
            f6 = -f6;
        }
        view.setTranslationX(f6);
    }
}
