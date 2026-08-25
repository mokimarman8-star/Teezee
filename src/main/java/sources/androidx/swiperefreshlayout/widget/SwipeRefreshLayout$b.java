package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SwipeRefreshLayout$b extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f13411a;

    SwipeRefreshLayout$b(SwipeRefreshLayout swipeRefreshLayout) {
        this.f13411a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f5, Transformation transformation) {
        this.f13411a.setAnimationProgress(f5);
    }
}
