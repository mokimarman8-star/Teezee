package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.c;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<c> implements c {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i) {
        super(i);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        c andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                c cVar = get(i);
                c cVar2 = DisposableHelper.DISPOSED;
                if (cVar != cVar2 && (andSet = getAndSet(i, cVar2)) != cVar2 && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public c replaceResource(int i, c cVar) {
        DisposableHelper disposableHelper;
        do {
            disposableHelper = (c) get(i);
            if (disposableHelper == DisposableHelper.DISPOSED) {
                cVar.dispose();
                return null;
            }
        } while (!compareAndSet(i, disposableHelper, cVar));
        return disposableHelper;
    }

    public boolean setResource(int i, c cVar) {
        DisposableHelper disposableHelper;
        do {
            disposableHelper = (c) get(i);
            if (disposableHelper == DisposableHelper.DISPOSED) {
                cVar.dispose();
                return false;
            }
        } while (!compareAndSet(i, disposableHelper, cVar));
        if (disposableHelper == null) {
            return true;
        }
        disposableHelper.dispose();
        return true;
    }
}
