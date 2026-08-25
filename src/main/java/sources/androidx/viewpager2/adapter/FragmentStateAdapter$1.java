package androidx.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.view.r;
import androidx.view.u;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class FragmentStateAdapter$1 implements r {
    final /* synthetic */ FragmentStateAdapter this$0;
    final /* synthetic */ FragmentViewHolder val$holder;

    FragmentStateAdapter$1(FragmentStateAdapter fragmentStateAdapter, FragmentViewHolder fragmentViewHolder) {
        this.this$0 = fragmentStateAdapter;
        this.val$holder = fragmentViewHolder;
    }

    @Override // androidx.view.r
    public void onStateChanged(@NonNull u uVar, @NonNull Lifecycle.Event event) {
        if (this.this$0.shouldDelayFragmentTransactions()) {
            return;
        }
        uVar.getLifecycle().d(this);
        if (ViewCompat.isAttachedToWindow(this.val$holder.getContainer())) {
            this.this$0.placeFragmentInViewHolder(this.val$holder);
        }
    }
}
