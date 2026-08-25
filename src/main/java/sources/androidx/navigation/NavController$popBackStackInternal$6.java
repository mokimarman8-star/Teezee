package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class NavController$popBackStackInternal$6 extends Lambda implements Function1<NavDestination, NavDestination> {
    public static final NavController$popBackStackInternal$6 INSTANCE = new NavController$popBackStackInternal$6();

    NavController$popBackStackInternal$6() {
        super(1);
    }

    public final NavDestination invoke(NavDestination navDestination) {
        Intrinsics.h(navDestination, "destination");
        NavGraph p5 = navDestination.p();
        if (p5 != null && p5.G() == navDestination.n()) {
            return navDestination.p();
        }
        return null;
    }
}
