package fy;

import i00.d;
import io.reactivex.rxjava3.core.f;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a implements f, c {
    final AtomicReference a = new AtomicReference();

    protected void a() {
        ((d) this.a.get()).request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final void dispose() {
        SubscriptionHelper.cancel(this.a);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final boolean isDisposed() {
        return this.a.get() == SubscriptionHelper.CANCELLED;
    }

    public final void onSubscribe(d dVar) {
        if (io.reactivex.rxjava3.internal.util.c.c(this.a, dVar, getClass())) {
            a();
        }
    }
}
