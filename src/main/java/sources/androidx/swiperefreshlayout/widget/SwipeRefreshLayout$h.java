package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SwipeRefreshLayout$h extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f13419a;

    SwipeRefreshLayout$h(SwipeRefreshLayout swipeRefreshLayout) {
        this.f13419a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f5, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f13419a;
        float f6 = swipeRefreshLayout.y;
        swipeRefreshLayout.setAnimationProgress(f6 + ((-f6) * f5));
        this.f13419a.h(f5);
    }
}
