package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class q {
    public static final void b(SafeCollector safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new o(safeCollector))).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(SafeCollector safeCollector, int i, CoroutineContext.Element element) {
        t1.b key = element.getKey();
        t1 t1Var = safeCollector.collectContext.get(key);
        if (key != t1.m1) {
            if (element != t1Var) {
                return Integer.MIN_VALUE;
            }
            return i + 1;
        }
        t1 t1Var2 = t1Var;
        Intrinsics.f(element, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        t1 d = d((t1) element, t1Var2);
        if (d == t1Var2) {
            return t1Var2 == null ? i : i + 1;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + d + ", expected child of " + t1Var2 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }

    public static final t1 d(t1 t1Var, t1 t1Var2) {
        while (t1Var != null) {
            if (t1Var == t1Var2 || !(t1Var instanceof v)) {
                return t1Var;
            }
            t1Var = ((v) t1Var).getParent();
        }
        return null;
    }
}
