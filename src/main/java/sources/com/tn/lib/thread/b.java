package com.tn.lib.thread;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b {
    public static final b a = new b();
    private static final List b = new ArrayList();

    private b() {
    }

    public final void a(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        e eVar = new e(runnable);
        a.a.a().add(eVar);
        if (Intrinsics.c(Looper.getMainLooper(), Looper.myLooper())) {
            Looper.myQueue().addIdleHandler(eVar);
        } else {
            Looper.getMainLooper().getQueue().addIdleHandler(eVar);
        }
    }
}
