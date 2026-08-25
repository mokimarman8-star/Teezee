package j00;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.j0;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class e extends j {
    private final j a;

    private static class a implements o {
        private final o a;

        a(o oVar) {
            this.a = oVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(j0 j0Var) {
            this.a.onNext(d.b(j0Var));
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            try {
                this.a.onNext(d.a(th));
                this.a.onComplete();
            } catch (Throwable th2) {
                try {
                    this.a.onError(th2);
                } catch (Throwable th3) {
                    io.reactivex.rxjava3.exceptions.a.b(th3);
                    dy.a.r(new CompositeException(new Throwable[]{th2, th3}));
                }
            }
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            this.a.onSubscribe(cVar);
        }
    }

    e(j jVar) {
        this.a = jVar;
    }

    protected void D(o oVar) {
        this.a.subscribe(new a(oVar));
    }
}
