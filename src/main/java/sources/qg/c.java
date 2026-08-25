package qg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c {
    public static final a b = new a(null);
    private static final c c = new c();
    private ScheduledExecutorService a = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: qg.b
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread c2;
            c2 = c.c(runnable);
            return c2;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return c.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread c(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("Delay-Task-Dispatcher");
        thread.setPriority(10);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ExecutorService executorService, Runnable runnable) {
        executorService.execute(runnable);
    }

    public final void e(long j, final ExecutorService executorService, final Runnable runnable) {
        Intrinsics.h(executorService, "pool");
        Intrinsics.h(runnable, "runnable");
        if (j == 0) {
            executorService.execute(runnable);
            return;
        }
        ScheduledExecutorService scheduledExecutorService = this.a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new Runnable() { // from class: qg.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.f(executorService, runnable);
                }
            }, j, TimeUnit.MICROSECONDS);
        }
    }
}
