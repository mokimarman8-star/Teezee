package androidx.coroutines.impl.utils.futures;

import com.google.common.util.concurrent.r;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AbstractFuture$SetFuture<V> implements Runnable {
    final r future;
    final AbstractFuture owner;

    AbstractFuture$SetFuture(AbstractFuture abstractFuture, r rVar) {
        this.owner = abstractFuture;
        this.future = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.owner.a != this) {
            return;
        }
        if (AbstractFuture.f.b(this.owner, this, AbstractFuture.n(this.future))) {
            AbstractFuture.k(this.owner);
        }
    }
}
