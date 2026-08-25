package com.cloud.config.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ThreadPoolExecutor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class ExecutorUtils$computationE$2 extends Lambda implements Function0<ThreadPoolExecutor> {
    public static final ExecutorUtils$computationE$2 INSTANCE = new ExecutorUtils$computationE$2();

    ExecutorUtils$computationE$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final Thread m20invoke$lambda0(final Runnable runnable) {
        AtomicInteger atomicInteger;
        atomicInteger = ExecutorUtils.computationA;
        return ThreadsKt.b(false, false, (ClassLoader) null, Intrinsics.q("COMPUTATION ", Integer.valueOf(atomicInteger.incrementAndGet())), 5, new Function0<Unit>() { // from class: com.cloud.config.utils.ExecutorUtils$computationE$2$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m22invoke();
                return Unit.a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m22invoke() {
                runnable.run();
            }
        }, 6, (Object) null);
    }

    public final ThreadPoolExecutor invoke() {
        int i;
        int i2;
        i = ExecutorUtils.CPU_CORE;
        i2 = ExecutorUtils.CPU_CORE;
        return new ThreadPoolExecutor(i, i2, 0L, TimeUnit.NANOSECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.cloud.config.utils.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m20invoke$lambda0;
                m20invoke$lambda0 = ExecutorUtils$computationE$2.m20invoke$lambda0(runnable);
                return m20invoke$lambda0;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }
}
