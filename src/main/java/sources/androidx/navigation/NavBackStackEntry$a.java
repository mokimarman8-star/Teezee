package androidx.navigation;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class NavBackStackEntry$a {
    private NavBackStackEntry$a() {
    }

    public /* synthetic */ NavBackStackEntry$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ NavBackStackEntry b(NavBackStackEntry$a navBackStackEntry$a, Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2, int i5, Object obj) {
        String str2;
        Bundle bundle3 = (i5 & 4) != 0 ? null : bundle;
        Lifecycle.State state2 = (i5 & 8) != 0 ? Lifecycle.State.CREATED : state;
        p pVar2 = (i5 & 16) != 0 ? null : pVar;
        if ((i5 & 32) != 0) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "randomUUID().toString()");
            str2 = uuid;
        } else {
            str2 = str;
        }
        return navBackStackEntry$a.a(context, navDestination, bundle3, state2, pVar2, str2, (i5 & 64) != 0 ? null : bundle2);
    }

    public final NavBackStackEntry a(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, p pVar, String str, Bundle bundle2) {
        Intrinsics.h(navDestination, "destination");
        Intrinsics.h(state, "hostLifecycleState");
        Intrinsics.h(str, "id");
        return new NavBackStackEntry(context, navDestination, bundle, state, pVar, str, bundle2, (DefaultConstructorMarker) null);
    }
}
