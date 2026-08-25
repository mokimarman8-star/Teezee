package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FlowableSampleTimed$SampleTimedNoLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    private static final long serialVersionUID = -7139995637533111443L;

    FlowableSampleTimed$SampleTimedNoLast(i00.c cVar, long j, TimeUnit timeUnit, Scheduler scheduler, yx.f fVar) {
        super(cVar, j, timeUnit, scheduler, fVar);
    }

    @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed$SampleTimedSubscriber
    void complete() {
        this.downstream.onComplete();
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }
}
