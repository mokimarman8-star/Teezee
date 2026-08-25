package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class f {
    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        Iterator it = e.a().iterator();
        while (it.hasNext()) {
            try {
                ((kotlinx.coroutines.j0) it.next()).m(coroutineContext, th);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th2) {
                e.b(kotlinx.coroutines.k0.b(th, th2));
            }
        }
        try {
            ExceptionsKt.a(th, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused2) {
        }
        e.b(th);
    }
}
