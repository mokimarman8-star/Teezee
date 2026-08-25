package cy;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a implements o, c {
    final AtomicReference a = new AtomicReference();

    protected void a() {
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final void dispose() {
        DisposableHelper.dispose(this.a);
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public final boolean isDisposed() {
        return this.a.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onSubscribe(c cVar) {
        if (io.reactivex.rxjava3.internal.util.c.d(this.a, cVar, getClass())) {
            a();
        }
    }
}
