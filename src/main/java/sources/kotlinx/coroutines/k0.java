package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class k0 {
    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        try {
            j0 j0Var = (j0) coroutineContext.get(j0.l1);
            if (j0Var != null) {
                j0Var.m(coroutineContext, th);
            } else {
                kotlinx.coroutines.internal.f.a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            kotlinx.coroutines.internal.f.a(coroutineContext, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        ExceptionsKt.a(runtimeException, th);
        return runtimeException;
    }
}
