package am;

import com.therouter.router.RouteItem;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class a {
    public final void a(RouteItem routeItem, mf.b bVar) {
        Intrinsics.h(routeItem, "postcard");
        Intrinsics.h(bVar, "callback");
        e.a.d(routeItem.getPath(), routeItem.getExtras());
        bVar.a(routeItem);
    }
}
