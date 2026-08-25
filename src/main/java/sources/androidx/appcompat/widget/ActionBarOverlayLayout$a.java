package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ActionBarOverlayLayout$a extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f701a;

    ActionBarOverlayLayout$a(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f701a = actionBarOverlayLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f701a;
        actionBarOverlayLayout.A = null;
        actionBarOverlayLayout.j = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f701a;
        actionBarOverlayLayout.A = null;
        actionBarOverlayLayout.j = false;
    }
}
