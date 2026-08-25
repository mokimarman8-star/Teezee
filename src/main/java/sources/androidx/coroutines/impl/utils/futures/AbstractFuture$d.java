package androidx.coroutines.impl.utils.futures;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractFuture$d {

    /* renamed from: d, reason: collision with root package name */
    static final AbstractFuture$d f14099d = new AbstractFuture$d(null, null);

    /* renamed from: a, reason: collision with root package name */
    final Runnable f14100a;

    /* renamed from: b, reason: collision with root package name */
    final Executor f14101b;

    /* renamed from: c, reason: collision with root package name */
    AbstractFuture$d f14102c;

    AbstractFuture$d(Runnable runnable, Executor executor) {
        this.f14100a = runnable;
        this.f14101b = executor;
    }
}
