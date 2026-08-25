package com.google.common.util.concurrent;

import com.google.common.util.concurrent.i;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class TimeoutFuture extends i.a {
    private r a;
    private ScheduledFuture b;

    private static final class Fire<V> implements Runnable {
        TimeoutFuture timeoutFutureRef;

        Fire(TimeoutFuture timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            r rVar;
            TimeoutFuture timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture == null || (rVar = timeoutFuture.a) == null) {
                return;
            }
            this.timeoutFutureRef = null;
            if (rVar.isDone()) {
                timeoutFuture.setFuture(rVar);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = timeoutFuture.b;
                timeoutFuture.b = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                        }
                    } catch (Throwable th) {
                        timeoutFuture.setException(new TimeoutFutureException(str));
                        throw th;
                    }
                }
                timeoutFuture.setException(new TimeoutFutureException(str + ": " + rVar));
            } finally {
                rVar.cancel(true);
            }
        }
    }

    private static final class TimeoutFutureException extends TimeoutException {
        private TimeoutFutureException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    private TimeoutFuture(r rVar) {
        this.a = (r) com.google.common.base.m.o(rVar);
    }

    static r v(r rVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(rVar);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.b = scheduledExecutorService.schedule(fire, j, timeUnit);
        rVar.addListener(fire, MoreExecutors.a());
        return timeoutFuture;
    }

    protected void afterDone() {
        maybePropagateCancellationTo(this.a);
        ScheduledFuture scheduledFuture = this.b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.a = null;
        this.b = null;
    }

    protected String pendingToString() {
        r rVar = this.a;
        ScheduledFuture scheduledFuture = this.b;
        if (rVar == null) {
            return null;
        }
        String str = "inputFuture=[" + rVar + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
