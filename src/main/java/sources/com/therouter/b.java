package com.therouter;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b {
    private final String a;
    private long b;

    public b(String str) {
        Intrinsics.h(str, "trace");
        this.a = str;
        this.b = System.currentTimeMillis();
    }

    public final long a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }
}
