package j00;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.j0;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class c extends j {
    private final retrofit2.d a;

    private static final class a implements io.reactivex.rxjava3.disposables.c {
        private final retrofit2.d a;
        private volatile boolean b;

        a(retrofit2.d dVar) {
            this.a = dVar;
        }

        public void dispose() {
            this.b = true;
            this.a.cancel();
        }

        public boolean isDisposed() {
            return this.b;
        }
    }

    c(retrofit2.d dVar) {
        this.a = dVar;
    }

    protected void D(o oVar) {
        boolean z;
        retrofit2.d mo105clone = this.a.mo105clone();
        a aVar = new a(mo105clone);
        oVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        try {
            j0 execute = mo105clone.execute();
            if (!aVar.isDisposed()) {
                oVar.onNext(execute);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                oVar.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                io.reactivex.rxjava3.exceptions.a.b(th);
                if (z) {
                    dy.a.r(th);
                    return;
                }
                if (aVar.isDisposed()) {
                    return;
                }
                try {
                    oVar.onError(th);
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.exceptions.a.b(th2);
                    dy.a.r(new CompositeException(new Throwable[]{th, th2}));
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
