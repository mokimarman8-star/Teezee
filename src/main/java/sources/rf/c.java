package rf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class c {
    public static final a c = new a(null);
    private ExecutorService a;
    private ScheduledExecutorService b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return b.a.a();
        }
    }

    private static final class b {
        public static final b a = new b();
        private static final c b = new c(null);

        private b() {
        }

        public final c a() {
            return b;
        }
    }

    private c() {
        c();
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void c() {
        if (this.a == null) {
            this.a = Executors.newCachedThreadPool();
        }
        if (this.b == null) {
            this.b = Executors.newSingleThreadScheduledExecutor();
        }
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService;
        try {
            ExecutorService executorService2 = this.a;
            Boolean valueOf = executorService2 == null ? null : Boolean.valueOf(executorService2.isShutdown());
            Intrinsics.e(valueOf);
            if (!valueOf.booleanValue() && (executorService = this.a) != null) {
                executorService.execute(runnable);
            }
        } catch (RejectedExecutionException e) {
            rf.b.a.e(e);
        }
    }

    public final void b(Runnable runnable) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.b;
            if (scheduledExecutorService != null && scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService scheduledExecutorService2 = this.b;
            if (scheduledExecutorService2 == null) {
                return;
            }
            scheduledExecutorService2.execute(runnable);
        } catch (Throwable th) {
            rf.b.a.e(th);
        }
    }

    public final void d(Runnable runnable, long j, TimeUnit timeUnit) {
        Intrinsics.h(timeUnit, "unit");
        try {
            ScheduledExecutorService scheduledExecutorService = this.b;
            if (scheduledExecutorService != null && scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService scheduledExecutorService2 = this.b;
            if (scheduledExecutorService2 == null) {
                return;
            }
            scheduledExecutorService2.schedule(runnable, j, timeUnit);
        } catch (Throwable th) {
            rf.b.a.e(th);
        }
    }
}
