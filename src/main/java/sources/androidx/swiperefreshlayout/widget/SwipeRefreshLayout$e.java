package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SwipeRefreshLayout$e implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f13416a;

    SwipeRefreshLayout$e(SwipeRefreshLayout swipeRefreshLayout) {
        this.f13416a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f13416a;
        if (swipeRefreshLayout.s) {
            return;
        }
        swipeRefreshLayout.p((Animation.AnimationListener) null);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
