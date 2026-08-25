package androidx.appcompat.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: Access modifiers changed from: protected */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class AbsActionBarView$a implements ViewPropertyAnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean f696a = false;

    /* renamed from: b, reason: collision with root package name */
    int f697b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbsActionBarView f698c;

    protected AbsActionBarView$a(AbsActionBarView absActionBarView) {
        this.f698c = absActionBarView;
    }

    public AbsActionBarView$a a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i5) {
        this.f698c.f = viewPropertyAnimatorCompat;
        this.f697b = i5;
        return this;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
        this.f696a = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        if (this.f696a) {
            return;
        }
        AbsActionBarView absActionBarView = this.f698c;
        absActionBarView.f = null;
        AbsActionBarView.b(absActionBarView, this.f697b);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        AbsActionBarView.a(this.f698c, 0);
        this.f696a = false;
    }
}
