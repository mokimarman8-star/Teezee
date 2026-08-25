package androidx.concurrent.futures;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractResolvableFuture$Failure {

    /* renamed from: b, reason: collision with root package name */
    static final AbstractResolvableFuture$Failure f5561b = new AbstractResolvableFuture$Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture$Failure.1
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    final Throwable f5562a;

    AbstractResolvableFuture$Failure(Throwable th) {
        this.f5562a = (Throwable) AbstractResolvableFuture.h(th);
    }
}
