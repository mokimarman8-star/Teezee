package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager$k;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class FragmentStateAdapter$2 extends FragmentManager$k {
    final /* synthetic */ FragmentStateAdapter this$0;
    final /* synthetic */ FrameLayout val$container;
    final /* synthetic */ Fragment val$fragment;

    FragmentStateAdapter$2(FragmentStateAdapter fragmentStateAdapter, Fragment fragment, FrameLayout frameLayout) {
        this.this$0 = fragmentStateAdapter;
        this.val$fragment = fragment;
        this.val$container = frameLayout;
    }

    @Override // androidx.fragment.app.FragmentManager$k
    public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        if (fragment == this.val$fragment) {
            fragmentManager.N1(this);
            this.this$0.addViewToContainer(view, this.val$container);
        }
    }
}
