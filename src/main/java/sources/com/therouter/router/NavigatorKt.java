package com.therouter.router;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class NavigatorKt {
    private static final LinkedList a = new LinkedList();
    private static final HashMap b = new HashMap();
    private static final List c = new ArrayList();
    private static final List d = new ArrayList();
    private static final List e = new ArrayList();
    private static mf.c f = new mf.c();
    private static Function2 g = new Function2<RouteItem, Function1<? super RouteItem, ? extends Unit>, Unit>() { // from class: com.therouter.router.NavigatorKt$routerInterceptor$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((RouteItem) obj, (Function1<? super RouteItem, Unit>) obj2);
            return Unit.a;
        }

        public final void invoke(RouteItem routeItem, Function1<? super RouteItem, Unit> function1) {
            Intrinsics.h(routeItem, "route");
            Intrinsics.h(function1, "callback");
            function1.invoke(routeItem);
        }
    };

    public static final void h(mf.e eVar) {
        Intrinsics.h(eVar, "interceptor");
        List list = d;
        list.add(eVar);
        Collections.sort(list, new Comparator() { // from class: com.therouter.router.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i;
                i = NavigatorKt.i((mf.e) obj, (mf.e) obj2);
                return i;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(mf.e eVar, mf.e eVar2) {
        if (eVar == null) {
            return -1;
        }
        if (eVar2 == null) {
            return 1;
        }
        return eVar2.a() - eVar.a();
    }

    public static final HashMap j() {
        return b;
    }

    public static final void k() {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a().invoke();
        }
        a.clear();
    }

    public static final void l(final mf.f fVar) {
        Intrinsics.h(fVar, "interceptor");
        g = new Function2<RouteItem, Function1<? super RouteItem, ? extends Unit>, Unit>() { // from class: com.therouter.router.NavigatorKt$setRouterInterceptor$1

            public static final class a implements mf.b {
                final /* synthetic */ Function1 a;

                a(Function1 function1) {
                    this.a = function1;
                }

                @Override // mf.b
                public void a(RouteItem routeItem) {
                    Intrinsics.h(routeItem, "routeItem");
                    this.a.invoke(routeItem);
                }
            }

            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((RouteItem) obj, (Function1<? super RouteItem, Unit>) obj2);
                return Unit.a;
            }

            public final void invoke(RouteItem routeItem, Function1<? super RouteItem, Unit> function1) {
                Intrinsics.h(routeItem, "route");
                Intrinsics.h(function1, "callback");
                mf.f.this.a(routeItem, new a(function1));
            }
        };
    }
}
