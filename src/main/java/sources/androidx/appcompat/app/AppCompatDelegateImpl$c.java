package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatDelegateImpl$c extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f231a;

    AppCompatDelegateImpl$c(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f231a = appCompatDelegateImpl;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        this.f231a.v.setAlpha(1.0f);
        this.f231a.y.setListener((ViewPropertyAnimatorListener) null);
        this.f231a.y = null;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        this.f231a.v.setVisibility(0);
        if (this.f231a.v.getParent() instanceof View) {
            ViewCompat.requestApplyInsets((View) this.f231a.v.getParent());
        }
    }
}
