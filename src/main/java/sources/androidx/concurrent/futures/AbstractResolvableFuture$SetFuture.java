package androidx.concurrent.futures;

import com.google.common.util.concurrent.r;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractResolvableFuture$SetFuture<V> implements Runnable {
    final r future;
    final AbstractResolvableFuture owner;

    AbstractResolvableFuture$SetFuture(AbstractResolvableFuture abstractResolvableFuture, r rVar) {
        this.owner = abstractResolvableFuture;
        this.future = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.owner.a != this) {
            return;
        }
        if (AbstractResolvableFuture.f.b(this.owner, this, AbstractResolvableFuture.o(this.future))) {
            AbstractResolvableFuture.l(this.owner);
        }
    }
}
