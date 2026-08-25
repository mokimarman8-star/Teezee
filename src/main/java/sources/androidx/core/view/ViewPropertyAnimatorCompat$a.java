package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewPropertyAnimatorCompat$a extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimatorListener f7167a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f7168b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimatorCompat f7169c;

    ViewPropertyAnimatorCompat$a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
        this.f7169c = viewPropertyAnimatorCompat;
        this.f7167a = viewPropertyAnimatorListener;
        this.f7168b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f7167a.onAnimationCancel(this.f7168b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f7167a.onAnimationEnd(this.f7168b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f7167a.onAnimationStart(this.f7168b);
    }
}
