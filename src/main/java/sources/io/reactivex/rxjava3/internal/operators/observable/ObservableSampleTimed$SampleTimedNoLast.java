package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ObservableSampleTimed$SampleTimedNoLast<T> extends ObservableSampleTimed$SampleTimedObserver<T> {
    private static final long serialVersionUID = -7139995637533111443L;

    ObservableSampleTimed$SampleTimedNoLast(io.reactivex.rxjava3.core.o oVar, long j, TimeUnit timeUnit, Scheduler scheduler, yx.f fVar) {
        super(oVar, j, timeUnit, scheduler, fVar);
    }

    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver
    void complete() {
        this.downstream.onComplete();
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }
}
