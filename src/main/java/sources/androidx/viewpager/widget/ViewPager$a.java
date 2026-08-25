package androidx.viewpager.widget;

import android.view.animation.Interpolator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewPager$a implements Interpolator {
    ViewPager$a() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f5) {
        float f6 = f5 - 1.0f;
        return (f6 * f6 * f6 * f6 * f6) + 1.0f;
    }
}
