package io.reactivex.rxjava3.internal.subscriptions;

import i00.d;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class BooleanSubscription extends AtomicBoolean implements d {
    private static final long serialVersionUID = -8127758972444290902L;

    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
