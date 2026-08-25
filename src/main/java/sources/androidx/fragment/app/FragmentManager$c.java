package androidx.fragment.app;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.core.view.MenuProvider;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class FragmentManager$c implements MenuProvider {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentManager f8114a;

    FragmentManager$c(FragmentManager fragmentManager) {
        this.f8114a = fragmentManager;
    }

    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        this.f8114a.E(menu, menuInflater);
    }

    public void onMenuClosed(Menu menu) {
        this.f8114a.M(menu);
    }

    public boolean onMenuItemSelected(MenuItem menuItem) {
        return this.f8114a.L(menuItem);
    }

    public void onPrepareMenu(Menu menu) {
        this.f8114a.Q(menu);
    }
}
