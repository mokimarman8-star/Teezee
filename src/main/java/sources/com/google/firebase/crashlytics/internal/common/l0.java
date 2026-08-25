package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class l0 {
    private final AtomicInteger a = new AtomicInteger();
    private final AtomicInteger b = new AtomicInteger();

    public void a() {
        this.b.getAndIncrement();
    }

    public void b() {
        this.a.getAndIncrement();
    }

    public void c() {
        this.b.set(0);
    }
}
