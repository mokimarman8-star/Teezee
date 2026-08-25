package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.f;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements c, d {
    f a;
    volatile boolean b;

    @Override // io.reactivex.rxjava3.disposables.d
    public boolean a(c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    @Override // io.reactivex.rxjava3.disposables.d
    public boolean b(c cVar) {
        Objects.requireNonNull(cVar, "disposable is null");
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        f fVar = this.a;
                        if (fVar == null) {
                            fVar = new f();
                            this.a = fVar;
                        }
                        fVar.a(cVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // io.reactivex.rxjava3.disposables.d
    public boolean c(c cVar) {
        Objects.requireNonNull(cVar, "disposable is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return false;
                }
                f fVar = this.a;
                if (fVar != null && fVar.e(cVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public void d() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
                f fVar = this.a;
                this.a = null;
                e(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                f fVar = this.a;
                this.a = null;
                e(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void e(f fVar) {
        if (fVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : fVar.b()) {
            if (obj instanceof c) {
                try {
                    ((c) obj).dispose();
                } catch (Throwable th) {
                    io.reactivex.rxjava3.exceptions.a.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.g((Throwable) arrayList.get(0));
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.b;
    }
}
