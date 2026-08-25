package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AppCompatDelegateImpl$6 implements Runnable {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    class a extends ViewPropertyAnimatorListenerAdapter {
        a() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            AppCompatDelegateImpl$6.this.this$0.v.setAlpha(1.0f);
            AppCompatDelegateImpl$6.this.this$0.y.setListener((ViewPropertyAnimatorListener) null);
            AppCompatDelegateImpl$6.this.this$0.y = null;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            AppCompatDelegateImpl$6.this.this$0.v.setVisibility(0);
        }
    }

    AppCompatDelegateImpl$6(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        appCompatDelegateImpl.w.showAtLocation(appCompatDelegateImpl.v, 55, 0, 0);
        this.this$0.m0();
        if (!this.this$0.X0()) {
            this.this$0.v.setAlpha(1.0f);
            this.this$0.v.setVisibility(0);
        } else {
            this.this$0.v.setAlpha(0.0f);
            AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
            appCompatDelegateImpl2.y = ViewCompat.animate(appCompatDelegateImpl2.v).alpha(1.0f);
            this.this$0.y.setListener(new a());
        }
    }
}
