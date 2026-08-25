package com.google.common.util.concurrent;

import com.google.common.collect.q2;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class k extends q2 implements Future {
    protected k() {
    }

    public boolean cancel(boolean z) {
        return l().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return l().get();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return l().get(j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return l().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return l().isDone();
    }

    protected abstract Future l();
}
