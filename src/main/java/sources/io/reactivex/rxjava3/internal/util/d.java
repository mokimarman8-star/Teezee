package io.reactivex.rxjava3.internal.util;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class d {
    public static void a(i00.c cVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(cVar);
        }
    }

    public static void b(i00.c cVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.tryAddThrowableOrReport(th) && atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(cVar);
        }
    }

    public static boolean c(i00.c cVar, Object obj, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(obj);
            if (atomicInteger.decrementAndGet() == 0) {
                return true;
            }
            atomicThrowable.tryTerminateConsumer(cVar);
        }
        return false;
    }
}
