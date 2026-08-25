package io.reactivex.rxjava3.internal.subscriptions;

import i00.d;
import io.reactivex.rxjava3.disposables.c;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<d> implements c {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        d andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                d dVar = get(i);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (dVar != subscriptionHelper && (andSet = getAndSet(i, subscriptionHelper)) != subscriptionHelper && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public d replaceResource(int i, d dVar) {
        d dVar2;
        do {
            dVar2 = get(i);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar == null) {
                    return null;
                }
                dVar.cancel();
                return null;
            }
        } while (!compareAndSet(i, dVar2, dVar));
        return dVar2;
    }

    public boolean setResource(int i, d dVar) {
        d dVar2;
        do {
            dVar2 = get(i);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!compareAndSet(i, dVar2, dVar));
        if (dVar2 == null) {
            return true;
        }
        dVar2.cancel();
        return true;
    }
}
