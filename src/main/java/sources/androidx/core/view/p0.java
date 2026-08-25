package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class p0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f7288a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f7289b;

    public /* synthetic */ p0(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f7288a = viewPropertyAnimatorUpdateListener;
        this.f7289b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewPropertyAnimatorCompat.a(this.f7288a, this.f7289b, valueAnimator);
    }
}
