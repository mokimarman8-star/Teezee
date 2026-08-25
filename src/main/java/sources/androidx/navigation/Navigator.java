package androidx.navigation;

import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class Navigator {
    private r a;
    private boolean b;

    public abstract NavDestination a();

    protected final r b() {
        r rVar = this.a;
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached");
    }

    public final boolean c() {
        return this.b;
    }

    public NavDestination d(NavDestination navDestination, Bundle bundle, l lVar, a aVar) {
        Intrinsics.h(navDestination, "destination");
        return navDestination;
    }

    public void e(List list, l lVar, a aVar) {
        Intrinsics.h(list, "entries");
        Iterator it = SequencesKt.r(SequencesKt.y(CollectionsKt.Z(list), new navigate.1(this, lVar, aVar))).iterator();
        while (it.hasNext()) {
            b().h((NavBackStackEntry) it.next());
        }
    }

    public void f(r rVar) {
        Intrinsics.h(rVar, "state");
        this.a = rVar;
        this.b = true;
    }

    public void g(NavBackStackEntry navBackStackEntry) {
        Intrinsics.h(navBackStackEntry, "backStackEntry");
        NavDestination f = navBackStackEntry.f();
        if (!(f instanceof NavDestination)) {
            f = null;
        }
        if (f == null) {
            return;
        }
        d(f, null, n.a(onLaunchSingleTop.1.INSTANCE), null);
        b().f(navBackStackEntry);
    }

    public void h(Bundle bundle) {
        Intrinsics.h(bundle, "savedState");
    }

    public Bundle i() {
        return null;
    }

    public void j(NavBackStackEntry navBackStackEntry, boolean z) {
        Intrinsics.h(navBackStackEntry, "popUpTo");
        List list = (List) b().b().getValue();
        if (!list.contains(navBackStackEntry)) {
            throw new IllegalStateException(("popBackStack was called with " + navBackStackEntry + " which does not exist in back stack " + list).toString());
        }
        ListIterator listIterator = list.listIterator(list.size());
        NavBackStackEntry navBackStackEntry2 = null;
        while (k()) {
            navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
            if (Intrinsics.c(navBackStackEntry2, navBackStackEntry)) {
                break;
            }
        }
        if (navBackStackEntry2 != null) {
            b().g(navBackStackEntry2, z);
        }
    }

    public boolean k() {
        return true;
    }
}
