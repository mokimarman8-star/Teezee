package com.therouter.inject;

import com.therouter.TheRouterKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class RouterInjectKt {
    private static final RecyclerBin a = new RecyclerBin();

    private static final void b(String str, Function0 function0) {
        TheRouterKt.c("RouterInject", str, function0);
    }

    static /* synthetic */ void c(String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.therouter.inject.RouterInjectKt$routerInjectDebugLog$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m71invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m71invoke() {
                }
            };
        }
        b(str, function0);
    }
}
