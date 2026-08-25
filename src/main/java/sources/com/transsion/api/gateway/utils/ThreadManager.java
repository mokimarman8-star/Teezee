package com.transsion.api.gateway.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ThreadManager {
    public static final String TAG = "ThreadManager";

    private ThreadManager() {
    }

    public static final void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    public static void executeInBackground(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void executeInDbWriteThread(Runnable runnable) {
        executeInSingle(runnable);
    }

    public static void executeInSingle(Runnable runnable) {
        getSingleExecutor().execute(runnable);
    }

    private static Handler getEventThreadHandler() {
        return EventHandlerThreadHolder.access$600();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ExecutorService getExecutor() {
        return ExecutorHolder.access$000();
    }

    private static ScheduledExecutorService getScheduledExecutor() {
        return ScheduledExecutorHolder.access$200();
    }

    private static ExecutorService getSingleExecutor() {
        return SingleExecutorHolder.access$100();
    }

    private static Handler getTimerThreadHandler() {
        return TimerHandlerThreadHolder.access$500();
    }

    public static Executor newSerialExecutor() {
        return new SerialExecutor((1) null);
    }

    public static void postAtTime(Runnable runnable, long j) {
        getTimerThreadHandler().postAtTime(runnable, j);
    }

    public static void postDelayed(Runnable runnable, long j) {
        getTimerThreadHandler().postDelayed(runnable, j);
    }

    public static void postDelayedAndRemoveBefore(Runnable runnable, long j) {
        getTimerThreadHandler().removeCallbacks(runnable);
        getTimerThreadHandler().postDelayed(runnable, j);
    }

    public static void runInEventThread(Runnable runnable) {
        getEventThreadHandler().post(runnable);
    }

    public static final ScheduledFuture<?> schedule(Runnable runnable, long j) {
        return getScheduledExecutor().schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public static final <T> ScheduledFuture<T> schedule(Callable<T> callable, long j) {
        return getScheduledExecutor().schedule(callable, j, TimeUnit.MILLISECONDS);
    }

    public static final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2) {
        return getScheduledExecutor().scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public static ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2) {
        return getScheduledExecutor().scheduleWithFixedDelay(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public static final Future<?> submit(Runnable runnable) {
        return getExecutor().submit(runnable);
    }

    public static final <T> Future<T> submit(Runnable runnable, T t) {
        return getExecutor().submit(runnable, t);
    }

    public static final <T> Future<T> submit(Callable<T> callable) {
        return getExecutor().submit(callable);
    }

    public static Future<?> submitInSingle(Runnable runnable) {
        return getSingleExecutor().submit(runnable);
    }

    public static <T> Future<T> submitInSingle(Runnable runnable, T t) {
        return getSingleExecutor().submit(runnable, t);
    }

    public static <T> Future<T> submitInSingle(Callable<T> callable) {
        return getSingleExecutor().submit(callable);
    }
}
