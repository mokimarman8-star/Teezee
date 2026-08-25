package androidx.coroutines.impl.utils.futures;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractFuture$g {

    /* renamed from: c, reason: collision with root package name */
    static final AbstractFuture$g f14108c = new AbstractFuture$g(false);

    /* renamed from: a, reason: collision with root package name */
    volatile Thread f14109a;

    /* renamed from: b, reason: collision with root package name */
    volatile AbstractFuture$g f14110b;

    AbstractFuture$g() {
        AbstractFuture.f.e(this, Thread.currentThread());
    }

    AbstractFuture$g(boolean z5) {
    }

    void a(AbstractFuture$g abstractFuture$g) {
        AbstractFuture.f.d(this, abstractFuture$g);
    }

    void b() {
        Thread thread = this.f14109a;
        if (thread != null) {
            this.f14109a = null;
            LockSupport.unpark(thread);
        }
    }
}
