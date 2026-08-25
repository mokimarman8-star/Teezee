package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface n extends Continuation {

    public static final class a {
        public static /* synthetic */ boolean a(n nVar, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return nVar.cancel(th);
        }
    }

    boolean cancel(Throwable th);

    void completeResume(Object obj);

    void invokeOnCancellation(Function1 function1);

    boolean isActive();

    boolean isCompleted();

    void resume(Object obj, Function1 function1);

    void resume(Object obj, Function3 function3);

    void resumeUndispatched(i0 i0Var, Object obj);

    Object tryResume(Object obj, Object obj2, Function3 function3);

    Object tryResumeWithException(Throwable th);
}
