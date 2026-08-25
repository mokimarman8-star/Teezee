package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.view.r;
import androidx.view.u;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class FragmentStateAdapter$4 implements r {
    final /* synthetic */ FragmentStateAdapter this$0;
    final /* synthetic */ Handler val$handler;
    final /* synthetic */ Runnable val$runnable;

    FragmentStateAdapter$4(FragmentStateAdapter fragmentStateAdapter, Handler handler, Runnable runnable) {
        this.this$0 = fragmentStateAdapter;
        this.val$handler = handler;
        this.val$runnable = runnable;
    }

    @Override // androidx.view.r
    public void onStateChanged(@NonNull u uVar, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.val$handler.removeCallbacks(this.val$runnable);
            uVar.getLifecycle().d(this);
        }
    }
}
