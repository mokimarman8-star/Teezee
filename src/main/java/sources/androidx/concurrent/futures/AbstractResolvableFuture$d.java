package androidx.concurrent.futures;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractResolvableFuture$d {

    /* renamed from: d, reason: collision with root package name */
    static final AbstractResolvableFuture$d f5567d = new AbstractResolvableFuture$d(null, null);

    /* renamed from: a, reason: collision with root package name */
    final Runnable f5568a;

    /* renamed from: b, reason: collision with root package name */
    final Executor f5569b;

    /* renamed from: c, reason: collision with root package name */
    AbstractResolvableFuture$d f5570c;

    AbstractResolvableFuture$d(Runnable runnable, Executor executor) {
        this.f5568a = runnable;
        this.f5569b = executor;
    }
}
