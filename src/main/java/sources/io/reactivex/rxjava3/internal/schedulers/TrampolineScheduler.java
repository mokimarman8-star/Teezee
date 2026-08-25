package io.reactivex.rxjava3.internal.schedulers;

import dy.a;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class TrampolineScheduler extends Scheduler {
    private static final TrampolineScheduler c = new TrampolineScheduler();

    TrampolineScheduler() {
    }

    public static TrampolineScheduler g() {
        return c;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new TrampolineWorker();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public c d(Runnable runnable) {
        a.t(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public c e(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            a.t(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            a.r(e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
