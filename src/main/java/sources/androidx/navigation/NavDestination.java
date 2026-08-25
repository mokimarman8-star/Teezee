package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/navigation/NavDestination;", "D", "Landroidx/navigation/m;", "", "invoke", "(Landroidx/navigation/m;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
/* renamed from: androidx.navigation.Navigator$onLaunchSingleTop$1, reason: from Kotlin metadata */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class NavDestination extends Lambda implements Function1<m, Unit> {
    public static final NavDestination INSTANCE = new NavDestination();

    NavDestination() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((m) obj);
        return Unit.a;
    }

    public final void invoke(m mVar) {
        Intrinsics.h(mVar, "$this$navOptions");
        mVar.h(true);
    }
}
