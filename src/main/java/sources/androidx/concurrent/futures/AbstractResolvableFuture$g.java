package androidx.concurrent.futures;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractResolvableFuture$g {

    /* renamed from: c, reason: collision with root package name */
    static final AbstractResolvableFuture$g f5576c = new AbstractResolvableFuture$g(false);

    /* renamed from: a, reason: collision with root package name */
    volatile Thread f5577a;

    /* renamed from: b, reason: collision with root package name */
    volatile AbstractResolvableFuture$g f5578b;

    AbstractResolvableFuture$g() {
        AbstractResolvableFuture.f.e(this, Thread.currentThread());
    }

    AbstractResolvableFuture$g(boolean z5) {
    }

    void a(AbstractResolvableFuture$g abstractResolvableFuture$g) {
        AbstractResolvableFuture.f.d(this, abstractResolvableFuture$g);
    }

    void b() {
        Thread thread = this.f5577a;
        if (thread != null) {
            this.f5577a = null;
            LockSupport.unpark(thread);
        }
    }
}
