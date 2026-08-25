package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SwipeRefreshLayout$g extends Animation {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f13418a;

    SwipeRefreshLayout$g(SwipeRefreshLayout swipeRefreshLayout) {
        this.f13418a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f5, Transformation transformation) {
        this.f13418a.h(f5);
    }
}
