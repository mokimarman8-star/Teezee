package com.cloud.hisavana.sdk;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class r1 {
    public static final r1 a = new r1();
    private static final AtomicLong b = new AtomicLong(0);
    private static final ConcurrentHashMap c = new ConcurrentHashMap();

    private r1() {
    }

    private final long a() {
        return b.incrementAndGet();
    }

    public final long b(a aVar) {
        Intrinsics.h(aVar, "observer");
        long a2 = a();
        if (b4.c()) {
            b4.b().d("Rewarded", "registerObserver " + a2);
        }
        c.put(Long.valueOf(a2), aVar);
        return a2;
    }

    public final void c(long j) {
        if (b4.c()) {
            b4.b().d("Rewarded", "unregisterObserver " + j);
        }
        try {
            c.remove(Long.valueOf(j));
        } catch (Exception e) {
            b4.b().w("Rewarded", "Failed to unregister observer: " + e.getMessage(), e);
        }
    }

    public final void d(long j, String str, Object obj) {
        Intrinsics.h(str, "event");
        if (b4.c()) {
            b4.b().d("Rewarded", "broadcast " + j + ", " + str);
        }
        try {
            a aVar = (a) c.get(Long.valueOf(j));
            if (aVar != null) {
                aVar.a(j, str, obj);
            }
        } catch (Exception e) {
            b4.b().e("Rewarded", "Error in observer.onEvent: " + e.getMessage());
        }
    }
}
