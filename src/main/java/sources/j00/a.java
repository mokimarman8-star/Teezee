package j00;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.exceptions.CompositeException;
import retrofit2.adapter.rxjava3.HttpException;
import retrofit2.j0;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class a extends j {
    private final j a;

    /* renamed from: j00.a$a, reason: collision with other inner class name */
    private static class C0006a implements o {
        private final o a;
        private boolean b;

        C0006a(o oVar) {
            this.a = oVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(j0 j0Var) {
            if (j0Var.e()) {
                this.a.onNext(j0Var.a());
                return;
            }
            this.b = true;
            HttpException httpException = new HttpException(j0Var);
            try {
                this.a.onError(httpException);
            } catch (Throwable th) {
                io.reactivex.rxjava3.exceptions.a.b(th);
                dy.a.r(new CompositeException(new Throwable[]{httpException, th}));
            }
        }

        public void onComplete() {
            if (this.b) {
                return;
            }
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            if (!this.b) {
                this.a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            dy.a.r(assertionError);
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.c cVar) {
            this.a.onSubscribe(cVar);
        }
    }

    a(j jVar) {
        this.a = jVar;
    }

    protected void D(o oVar) {
        this.a.subscribe(new C0006a(oVar));
    }
}
