package androidx.concurrent.futures;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractResolvableFuture$c {

    /* renamed from: c, reason: collision with root package name */
    static final AbstractResolvableFuture$c f5563c;

    /* renamed from: d, reason: collision with root package name */
    static final AbstractResolvableFuture$c f5564d;

    /* renamed from: a, reason: collision with root package name */
    final boolean f5565a;

    /* renamed from: b, reason: collision with root package name */
    final Throwable f5566b;

    static {
        if (AbstractResolvableFuture.d) {
            f5564d = null;
            f5563c = null;
        } else {
            f5564d = new AbstractResolvableFuture$c(false, null);
            f5563c = new AbstractResolvableFuture$c(true, null);
        }
    }

    AbstractResolvableFuture$c(boolean z5, Throwable th) {
        this.f5565a = z5;
        this.f5566b = th;
    }
}
