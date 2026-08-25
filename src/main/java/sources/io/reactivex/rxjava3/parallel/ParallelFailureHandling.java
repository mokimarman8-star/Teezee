package io.reactivex.rxjava3.parallel;

import yx.c;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public enum ParallelFailureHandling implements c {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // yx.c
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
