package io.reactivex.rxjava3.internal.schedulers;

import java.util.concurrent.ThreadFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class IoScheduler$a extends e {
    long c;

    IoScheduler$a(ThreadFactory threadFactory) {
        super(threadFactory);
        this.c = 0L;
    }

    public long e() {
        return this.c;
    }

    public void f(long j) {
        this.c = j;
    }
}
