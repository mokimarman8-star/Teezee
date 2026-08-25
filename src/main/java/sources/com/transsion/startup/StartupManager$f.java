package com.transsion.startup;

import com.therouter.TheRouter;
import com.therouter.router.RouteItem;
import com.transsion.moviedetailapi.g;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mf.b;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class StartupManager$f implements mf.f {
    StartupManager$f() {
    }

    public void a(RouteItem routeItem, b callback) {
        Object obj;
        Unit unit;
        Intrinsics.h(routeItem, "routeItem");
        Intrinsics.h(callback, "callback");
        a.a.f(wf.a.a, "TheRouter-Interceptor", "process path :" + routeItem.getPath() + ", extras:" + routeItem.getExtras(), false, 4, (Object) null);
        fj.a aVar = new fj.a(callback, routeItem);
        Unit unit2 = null;
        try {
            Result$Companion result$Companion = Result.Companion;
            io.b bVar = (io.b) TheRouter.d(io.b.class, new Object[0]);
            if (bVar != null) {
                bVar.a(routeItem, aVar);
                unit = Unit.a;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
        try {
            g gVar = (g) TheRouter.d(g.class, new Object[0]);
            if (gVar != null) {
                gVar.a(routeItem, aVar);
                unit2 = Unit.a;
            }
            Result.constructor-impl(unit2);
        } catch (Throwable th2) {
            Result$Companion result$Companion3 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
        try {
            obj = Result.constructor-impl(Boolean.valueOf(aVar.b()));
        } catch (Throwable th3) {
            Result$Companion result$Companion4 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th3));
        }
        Throwable th4 = Result.exceptionOrNull-impl(obj);
        if (th4 != null) {
            a.a.f(wf.a.a, "TheRouter-replace", "intercepted  " + th4.getMessage(), false, 4, (Object) null);
        }
    }
}
