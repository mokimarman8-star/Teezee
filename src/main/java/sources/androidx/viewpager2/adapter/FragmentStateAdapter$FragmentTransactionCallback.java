package androidx.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class FragmentStateAdapter$FragmentTransactionCallback {

    @NonNull
    private static final OnPostEventListener NO_OP = new OnPostEventListener() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentTransactionCallback.1
        @Override // androidx.viewpager2.adapter.FragmentStateAdapter$FragmentTransactionCallback.OnPostEventListener
        public void onPost() {
        }
    };

    public interface OnPostEventListener {
        void onPost();
    }

    @NonNull
    public OnPostEventListener onFragmentMaxLifecyclePreUpdated(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        return NO_OP;
    }

    @NonNull
    public OnPostEventListener onFragmentPreAdded(@NonNull Fragment fragment) {
        return NO_OP;
    }

    @NonNull
    public OnPostEventListener onFragmentPreRemoved(@NonNull Fragment fragment) {
        return NO_OP;
    }

    @NonNull
    @FragmentStateAdapter$ExperimentalFragmentStateAdapterApi
    public OnPostEventListener onFragmentPreSavedInstanceState(@NonNull Fragment fragment) {
        return NO_OP;
    }
}
