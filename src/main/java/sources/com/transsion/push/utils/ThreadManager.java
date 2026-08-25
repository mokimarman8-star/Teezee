package com.transsion.push.utils;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ThreadManager {
    private static Handler b() {
        return b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ExecutorService c() {
        return c.a();
    }

    private static ScheduledExecutorService d() {
        return d.a();
    }

    private static ExecutorService e() {
        return e.a();
    }

    public static final void execute(Runnable runnable) {
        c().execute(runnable);
    }

    public static void executeInBackground(Runnable runnable) {
        execute(runnable);
    }

    public static void executeInDbWriteThread(Runnable runnable) {
        executeInSingle(runnable);
    }

    public static void executeInSingle(Runnable runnable) {
        e().execute(runnable);
    }

    private static Handler f() {
        return g.a();
    }

    public static Executor newSerialExecutor() {
        return new SerialExecutor((a) null);
    }

    public static void postAtTime(Runnable runnable, long j) {
        f().postAtTime(runnable, j);
    }

    public static void postDelayed(Runnable runnable, long j) {
        f().postDelayed(runnable, j);
    }

    public static void postDelayedAndRemoveBefore(Runnable runnable, long j) {
        f().removeCallbacks(runnable);
        f().postDelayed(runnable, j);
    }

    public static void runInEventThread(Runnable runnable) {
        b().post(runnable);
    }

    public static final ScheduledFuture<?> schedule(Runnable runnable, long j) {
        return d().schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public static final <T> ScheduledFuture<T> schedule(Callable<T> callable, long j) {
        return d().schedule(callable, j, TimeUnit.MILLISECONDS);
    }

    public static final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2) {
        return d().scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public static ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2) {
        return d().scheduleWithFixedDelay(runnable, j, j2, TimeUnit.MILLISECONDS);
    }

    public static final Future<?> submit(Runnable runnable) {
        return c().submit(runnable);
    }

    public static final <T> Future<T> submit(Runnable runnable, T t) {
        return c().submit(runnable, t);
    }

    public static final <T> Future<T> submit(Callable<T> callable) {
        return c().submit(callable);
    }

    public static Future<?> submitInSingle(Runnable runnable) {
        return e().submit(runnable);
    }

    public static <T> Future<T> submitInSingle(Runnable runnable, T t) {
        return e().submit(runnable, t);
    }

    public static <T> Future<T> submitInSingle(Callable<T> callable) {
        return e().submit(callable);
    }
}
