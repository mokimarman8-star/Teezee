package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d extends Scheduler {
    private static final RxThreadFactory d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));
    final ThreadFactory c;

    public d() {
        this(d);
    }

    public d(ThreadFactory threadFactory) {
        this.c = threadFactory;
    }

    public Scheduler.Worker c() {
        return new e(this.c);
    }
}
