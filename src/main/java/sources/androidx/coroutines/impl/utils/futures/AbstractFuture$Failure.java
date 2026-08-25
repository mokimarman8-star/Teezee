package androidx.coroutines.impl.utils.futures;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractFuture$Failure {

    /* renamed from: b, reason: collision with root package name */
    static final AbstractFuture$Failure f14093b = new AbstractFuture$Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.futures.AbstractFuture$Failure.1
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    final Throwable f14094a;

    AbstractFuture$Failure(Throwable th) {
        this.f14094a = (Throwable) AbstractFuture.g(th);
    }
}
