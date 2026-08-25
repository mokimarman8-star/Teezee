package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class j extends i {
    private final r a;

    j(r rVar) {
        this.a = (r) com.google.common.base.m.o(rVar);
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.a.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    public Object get() {
        return this.a.get();
    }

    public Object get(long j, TimeUnit timeUnit) {
        return this.a.get(j, timeUnit);
    }

    public boolean isCancelled() {
        return this.a.isCancelled();
    }

    public boolean isDone() {
        return this.a.isDone();
    }

    public String toString() {
        return this.a.toString();
    }
}
