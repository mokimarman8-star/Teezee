package androidx.viewpager.widget;

import android.view.View;
import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewPager$ViewPositionComparator implements Comparator<View> {
    ViewPager$ViewPositionComparator() {
    }

    @Override // java.util.Comparator
    public int compare(View view, View view2) {
        ViewPager$e viewPager$e = (ViewPager$e) view.getLayoutParams();
        ViewPager$e viewPager$e2 = (ViewPager$e) view2.getLayoutParams();
        boolean z5 = viewPager$e.f13744a;
        return z5 != viewPager$e2.f13744a ? z5 ? 1 : -1 : viewPager$e.f13748e - viewPager$e2.f13748e;
    }
}
