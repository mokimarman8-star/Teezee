package com.transsion.baseui.util;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class d {
    private static long a;

    public static final void a(long j, Function0 function0) {
        Intrinsics.h(function0, "clickInvoke");
        if (System.nanoTime() - a > j) {
            a = System.nanoTime();
            function0.invoke();
        }
    }

    public static /* synthetic */ void b(long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 600;
        }
        a(j, function0);
    }
}
