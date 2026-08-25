package j00;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.j0;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class b extends j {
    private final retrofit2.d a;

    private static final class a implements io.reactivex.rxjava3.disposables.c, retrofit2.f {
        private final retrofit2.d a;
        private final o b;
        private volatile boolean c;
        boolean d = false;

        a(retrofit2.d dVar, o oVar) {
            this.a = dVar;
            this.b = oVar;
        }

        @Override // retrofit2.f
        public void a(retrofit2.d dVar, Throwable th) {
            if (dVar.isCanceled()) {
                return;
            }
            try {
                this.b.onError(th);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                dy.a.r(new CompositeException(new Throwable[]{th, th2}));
            }
        }

        @Override // retrofit2.f
        public void b(retrofit2.d dVar, j0 j0Var) {
            if (this.c) {
                return;
            }
            try {
                this.b.onNext(j0Var);
                if (this.c) {
                    return;
                }
                this.d = true;
                this.b.onComplete();
            } catch (Throwable th) {
                io.reactivex.rxjava3.exceptions.a.b(th);
                if (this.d) {
                    dy.a.r(th);
                    return;
                }
                if (this.c) {
                    return;
                }
                try {
                    this.b.onError(th);
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    dy.a.r(new CompositeException(new Throwable[]{th, th2}));
                }
            }
        }

        public void dispose() {
            this.c = true;
            this.a.cancel();
        }

        public boolean isDisposed() {
            return this.c;
        }
    }

    b(retrofit2.d dVar) {
        this.a = dVar;
    }

    protected void D(o oVar) {
        retrofit2.d mo105clone = this.a.mo105clone();
        a aVar = new a(mo105clone, oVar);
        oVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        mo105clone.f(aVar);
    }
}
