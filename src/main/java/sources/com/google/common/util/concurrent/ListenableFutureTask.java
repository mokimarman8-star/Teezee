package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class ListenableFutureTask<V> extends FutureTask<V> implements r {
    private final g executionList;

    ListenableFutureTask(Runnable runnable, V v) {
        super(runnable, v);
        this.executionList = new g();
    }

    ListenableFutureTask(Callable<V> callable) {
        super(callable);
        this.executionList = new g();
    }

    public static <V> ListenableFutureTask<V> create(Runnable runnable, V v) {
        return new ListenableFutureTask<>(runnable, v);
    }

    public static <V> ListenableFutureTask<V> create(Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    @Override // com.google.common.util.concurrent.r
    public void addListener(Runnable runnable, Executor executor) {
        this.executionList.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.executionList.b();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        return nanos <= 2147483647999999999L ? (V) super.get(j, timeUnit) : (V) super.get(Math.min(nanos, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }
}
