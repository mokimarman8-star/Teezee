package androidx.navigation;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class Navigation {
    public static final Navigation a = new Navigation();

    private Navigation() {
    }

    public static final NavController b(View view) {
        Intrinsics.h(view, "view");
        NavController c = a.c(view);
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    private final NavController c(View view) {
        return (NavController) SequencesKt.t(SequencesKt.z(SequencesKt.h(view, findViewNavController.1.INSTANCE), findViewNavController.2.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController d(View view) {
        Object tag = view.getTag(R$id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    public static final void e(View view, NavController navController) {
        Intrinsics.h(view, "view");
        view.setTag(R$id.nav_controller_view_tag, navController);
    }
}
