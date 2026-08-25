package com.therouter.router;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class g {
    private final Navigator a;
    private final Function0 b;

    public g(Navigator navigator, Function0 function0) {
        Intrinsics.h(navigator, "navigator");
        Intrinsics.h(function0, "action");
        this.a = navigator;
        this.b = function0;
    }

    public final Function0 a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        return obj instanceof g ? Intrinsics.c(((g) obj).a, this.a) : super.equals(obj);
    }

    public int hashCode() {
        return this.a.hashCode() + 1;
    }
}
