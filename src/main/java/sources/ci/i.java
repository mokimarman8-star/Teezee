package ci;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i {
    public static final i a = new i();

    private i() {
    }

    public static /* synthetic */ void b(i iVar, FragmentManager fragmentManager, int i, Fragment fragment, boolean z, String str, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            str = fragment.getClass().getSimpleName();
        }
        iVar.a(fragmentManager, i, fragment, z2, str);
    }

    private final void c(FragmentManager fragmentManager, w wVar) {
        if (fragmentManager.T0() || fragmentManager.L0()) {
            return;
        }
        try {
            wVar.j();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public final void a(FragmentManager fragmentManager, int i, Fragment fragment, boolean z, String str) {
        Intrinsics.h(fragmentManager, "fragmentManager");
        Intrinsics.h(fragment, "fragment");
        if (fragmentManager.T0() || fragmentManager.L0()) {
            return;
        }
        Fragment k0 = str != null ? fragmentManager.k0(str) : null;
        if (k0 == null || !k0.isAdded()) {
            w p = fragmentManager.p();
            Intrinsics.g(p, "beginTransaction(...)");
            p.t(i, fragment, str);
            if (z) {
                p.g(str);
            }
            c(fragmentManager, p);
        }
    }
}
