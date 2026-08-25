package io.reactivex.rxjava3.internal.observers;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c extends b {
    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th) {
        if (this.a == null) {
            this.b = th;
        }
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(Object obj) {
        if (this.a == null) {
            this.a = obj;
            this.c.dispose();
            countDown();
        }
    }
}
