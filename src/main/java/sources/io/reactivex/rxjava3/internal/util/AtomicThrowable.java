package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.core.q;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean isTerminated() {
        return get() == ExceptionHelper.a;
    }

    public Throwable terminate() {
        return ExceptionHelper.e(this);
    }

    public boolean tryAddThrowable(Throwable th) {
        return ExceptionHelper.a(this, th);
    }

    public boolean tryAddThrowableOrReport(Throwable th) {
        if (tryAddThrowable(th)) {
            return true;
        }
        dy.a.r(th);
        return false;
    }

    public void tryTerminateAndReport() {
        Throwable terminate = terminate();
        if (terminate == null || terminate == ExceptionHelper.a) {
            return;
        }
        dy.a.r(terminate);
    }

    public void tryTerminateConsumer(i00.c cVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            cVar.onComplete();
        } else if (terminate != ExceptionHelper.a) {
            cVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(io.reactivex.rxjava3.core.b bVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            bVar.onComplete();
        } else if (terminate != ExceptionHelper.a) {
            bVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(io.reactivex.rxjava3.core.d dVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            dVar.onComplete();
        } else if (terminate != ExceptionHelper.a) {
            dVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(io.reactivex.rxjava3.core.h hVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            hVar.onComplete();
        } else if (terminate != ExceptionHelper.a) {
            hVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(o oVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            oVar.onComplete();
        } else if (terminate != ExceptionHelper.a) {
            oVar.onError(terminate);
        }
    }

    public void tryTerminateConsumer(q qVar) {
        Throwable terminate = terminate();
        if (terminate == null || terminate == ExceptionHelper.a) {
            return;
        }
        qVar.onError(terminate);
    }
}
