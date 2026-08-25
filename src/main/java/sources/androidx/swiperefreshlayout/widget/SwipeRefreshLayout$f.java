package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SwipeRefreshLayout$f extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f13417a;

    SwipeRefreshLayout$f(SwipeRefreshLayout swipeRefreshLayout) {
        this.f13417a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f5, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f13417a;
        int abs = !swipeRefreshLayout.K ? swipeRefreshLayout.A - Math.abs(swipeRefreshLayout.z) : swipeRefreshLayout.A;
        SwipeRefreshLayout swipeRefreshLayout2 = this.f13417a;
        this.f13417a.setTargetOffsetTopAndBottom((swipeRefreshLayout2.x + ((int) ((abs - r1) * f5))) - swipeRefreshLayout2.v.getTop());
        this.f13417a.C.e(1.0f - f5);
    }
}
