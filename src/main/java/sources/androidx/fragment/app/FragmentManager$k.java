package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class FragmentManager$k {
    @Deprecated
    public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
    }

    public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
    }

    public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
    }

    public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
    }

    public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
    }

    public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
    }

    public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
    }

    public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
    }

    public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
    }

    public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
    }

    public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
    }

    public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
    }

    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
    }

    public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
    }
}
