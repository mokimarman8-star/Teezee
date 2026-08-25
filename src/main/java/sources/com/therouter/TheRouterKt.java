package com.therouter;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class TheRouterKt {
    private static boolean a = false;
    private static boolean b = true;

    public static final void c(String str, String str2, Function0 function0) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        Intrinsics.h(function0, "block");
        if (TheRouter.m()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TheRouter::");
            sb2.append(str);
            function0.invoke();
            return;
        }
        TheRouter.f().invoke("TheRouter::" + str, str2);
    }

    public static /* synthetic */ void d(String str, String str2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.therouter.TheRouterKt$debug$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m63invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m63invoke() {
                }
            };
        }
        c(str, str2, function0);
    }

    public static final void e(String str, String str2, Function0 function0) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        Intrinsics.h(function0, "block");
        if (TheRouter.m()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TheRouter::");
            sb2.append(str);
            function0.invoke();
        }
    }

    public static /* synthetic */ void f(String str, String str2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.therouter.TheRouterKt$debugOnly$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m64invoke();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m64invoke() {
                }
            };
        }
        e(str, str2, function0);
    }

    public static final boolean g() {
        return b;
    }

    public static final void h(boolean z, String str, String str2) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        if (z) {
            return;
        }
        if (TheRouter.m()) {
            throw new IllegalArgumentException("TheRouter::" + str + "::" + str2);
        }
        TheRouter.f().invoke("TheRouter::" + str, str2);
    }
}
