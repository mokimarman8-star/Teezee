package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class r1 extends w1 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(r1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;
    private final Function1 e;

    public r1(Function1 function1) {
        this.e = function1;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return true;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th) {
        if (f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }
}
