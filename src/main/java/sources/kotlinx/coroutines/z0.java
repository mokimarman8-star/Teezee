package kotlinx.coroutines;

import java.util.concurrent.Future;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class z0 implements a1 {
    private final Future a;

    public z0(Future future) {
        this.a = future;
    }

    @Override // kotlinx.coroutines.a1
    public void dispose() {
        this.a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.a + ']';
    }
}
