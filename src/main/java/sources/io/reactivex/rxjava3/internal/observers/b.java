package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class b extends CountDownLatch implements o, io.reactivex.rxjava3.disposables.c {
    Object a;
    Throwable b;
    io.reactivex.rxjava3.disposables.c c;
    volatile boolean d;

    public b() {
        super(1);
    }

    public final Object a() {
        if (getCount() != 0) {
            try {
                io.reactivex.rxjava3.internal.util.b.a();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.g(e);
            }
        }
        Throwable th = this.b;
        if (th == null) {
            return this.a;
        }
        throw ExceptionHelper.g(th);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final void dispose() {
        this.d = true;
        io.reactivex.rxjava3.disposables.c cVar = this.c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final boolean isDisposed() {
        return this.d;
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
        this.c = cVar;
        if (this.d) {
            cVar.dispose();
        }
    }
}
