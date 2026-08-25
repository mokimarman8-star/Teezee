package androidx.datastore.flow;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: androidx.datastore.core.b, reason: case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class C0190b {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f7468a;

    public C0190b(int i5) {
        this.f7468a = new AtomicInteger(i5);
    }

    public final int a() {
        return this.f7468a.decrementAndGet();
    }

    public final int b() {
        return this.f7468a.get();
    }

    public final int c() {
        return this.f7468a.getAndIncrement();
    }

    public final int d() {
        return this.f7468a.incrementAndGet();
    }
}
