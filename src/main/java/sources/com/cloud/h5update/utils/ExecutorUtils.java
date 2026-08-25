package com.cloud.h5update.utils;

import android.os.Handler;
import android.os.Looper;
import com.cloud.h5update.utils.ExecutorUtils$mainE$2;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class ExecutorUtils {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private static AtomicInteger b = new AtomicInteger();
    private static final Lazy c = LazyKt.b(ExecutorUtils$ioE$2.INSTANCE);
    private static AtomicInteger d = new AtomicInteger();
    private static final Lazy e = LazyKt.b(ExecutorUtils$computationE$2.INSTANCE);
    private static AtomicInteger f = new AtomicInteger();
    private static final Lazy g = LazyKt.b(ExecutorUtils$newE$2.INSTANCE);
    private static final Lazy h = LazyKt.b(ExecutorUtils$singleE$2.INSTANCE);
    private static AtomicInteger i = new AtomicInteger();
    private static final Lazy j = LazyKt.b(ExecutorUtils$scheduledE$2.INSTANCE);
    private static final Lazy k = LazyKt.b(new Function0<ExecutorUtils$mainE$2.a>() { // from class: com.cloud.h5update.utils.ExecutorUtils$mainE$2

        public static final class a extends AbstractExecutorService {
            private final Handler a = new Handler(Looper.getMainLooper());

            a() {
            }

            @Override // java.util.concurrent.ExecutorService
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void shutdown() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.concurrent.ExecutorService
            public boolean awaitTermination(long j, TimeUnit timeUnit) {
                Intrinsics.h(timeUnit, "unit");
                return false;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                Intrinsics.h(runnable, "command");
                this.a.post(runnable);
            }

            @Override // java.util.concurrent.ExecutorService
            public boolean isShutdown() {
                return false;
            }

            @Override // java.util.concurrent.ExecutorService
            public boolean isTerminated() {
                return false;
            }

            @Override // java.util.concurrent.ExecutorService
            public List shutdownNow() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final a m45invoke() {
            return new a();
        }
    });

    private static final ExecutorService f() {
        return (ExecutorService) c.getValue();
    }

    public static final ExecutorService g() {
        return f();
    }
}
