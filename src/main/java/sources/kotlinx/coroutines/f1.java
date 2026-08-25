package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.EventLoopImplBase;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class f1 extends e1 {
    protected abstract Thread getThread();

    protected void reschedule(long j, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(j, delayedTask);
    }

    protected final void unpark() {
        b bVar;
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            bVar = c.a;
            if (bVar != null) {
                bVar.f(thread);
            } else {
                LockSupport.unpark(thread);
            }
        }
    }
}
