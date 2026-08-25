package kotlinx.coroutines;

import java.util.concurrent.Future;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class l implements m {
    private final Future a;

    public l(Future future) {
        this.a = future;
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable th) {
        this.a.cancel(false);
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.a + ']';
    }
}
