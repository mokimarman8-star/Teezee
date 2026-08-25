package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class x0 implements Executor {
    public final i0 a;

    public x0(i0 i0Var) {
        this.a = i0Var;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        i0 i0Var = this.a;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (i0Var.isDispatchNeeded(emptyCoroutineContext)) {
            this.a.dispatch(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.a.toString();
    }
}
