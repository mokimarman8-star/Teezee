package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.c0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class g {
    public static final String a = a0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
    public static final long b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static f f;

    static {
        long f2;
        int e2;
        int e3;
        long f3;
        f2 = c0.f("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        b = f2;
        e2 = c0.e("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.e(a0.a(), 2), 1, 0, 8, null);
        c = e2;
        e3 = c0.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        d = e3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f3 = c0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        e = timeUnit.toNanos(f3);
        f = d.a;
    }

    public static final Task b(Runnable runnable, long j, boolean z) {
        return new TaskImpl(runnable, j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(boolean z) {
        return z ? "Blocking" : "Non-blocking";
    }
}
