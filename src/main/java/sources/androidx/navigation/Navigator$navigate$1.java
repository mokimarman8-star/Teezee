package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/navigation/NavBackStackEntry;", "D", "Landroidx/navigation/NavDestination;", "backStackEntry", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class Navigator$navigate$1 extends Lambda implements Function1<NavBackStackEntry, NavBackStackEntry> {
    final /* synthetic */ l $navOptions;
    final /* synthetic */ Navigator$a $navigatorExtras;
    final /* synthetic */ Navigator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Navigator$navigate$1(Navigator navigator, l lVar, Navigator$a navigator$a) {
        super(1);
        this.this$0 = navigator;
        this.$navOptions = lVar;
    }

    public final NavBackStackEntry invoke(NavBackStackEntry navBackStackEntry) {
        NavDestination d5;
        Intrinsics.h(navBackStackEntry, "backStackEntry");
        NavDestination f5 = navBackStackEntry.f();
        if (!(f5 instanceof NavDestination)) {
            f5 = null;
        }
        if (f5 != null && (d5 = this.this$0.d(f5, navBackStackEntry.d(), this.$navOptions, (Navigator$a) null)) != null) {
            return Intrinsics.c(d5, f5) ? navBackStackEntry : this.this$0.b().a(d5, d5.f(navBackStackEntry.d()));
        }
        return null;
    }
}
