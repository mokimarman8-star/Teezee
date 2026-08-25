package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class SwipeRefreshLayout$a implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f13410a;

    SwipeRefreshLayout$a(SwipeRefreshLayout swipeRefreshLayout) {
        this.f13410a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout$j swipeRefreshLayout$j;
        SwipeRefreshLayout swipeRefreshLayout = this.f13410a;
        if (!swipeRefreshLayout.c) {
            swipeRefreshLayout.j();
            return;
        }
        swipeRefreshLayout.C.setAlpha(255);
        this.f13410a.C.start();
        SwipeRefreshLayout swipeRefreshLayout2 = this.f13410a;
        if (swipeRefreshLayout2.I && (swipeRefreshLayout$j = swipeRefreshLayout2.b) != null) {
            swipeRefreshLayout$j.a();
        }
        SwipeRefreshLayout swipeRefreshLayout3 = this.f13410a;
        swipeRefreshLayout3.n = swipeRefreshLayout3.v.getTop();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
