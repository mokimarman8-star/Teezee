package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class g0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z) {
        boolean h = h(coroutineContext);
        boolean h2 = h(coroutineContext2);
        if (!h && !h2) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new e0(ref$ObjectRef, z));
        if (h2) {
            ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).fold(emptyCoroutineContext, new f0());
        }
        return coroutineContext3.plus((CoroutineContext) ref$ObjectRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext e(Ref$ObjectRef ref$ObjectRef, boolean z, CoroutineContext coroutineContext, CoroutineContext.Element element) {
        return coroutineContext.plus(element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext f(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        return coroutineContext.plus(element);
    }

    public static final String g(CoroutineContext coroutineContext) {
        return null;
    }

    private static final boolean h(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, new d0())).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(boolean z, CoroutineContext.Element element) {
        return z;
    }

    public static final CoroutineContext j(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        return !h(coroutineContext2) ? coroutineContext.plus(coroutineContext2) : d(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext k(n0 n0Var, CoroutineContext coroutineContext) {
        CoroutineContext d = d(n0Var.getCoroutineContext(), coroutineContext, true);
        return (d == y0.a() || d.get(ContinuationInterceptor.k1) != null) ? d : d.plus(y0.a());
    }

    public static final q2 l(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof v0) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof q2) {
                return (q2) coroutineStackFrame;
            }
        }
        return null;
    }

    public static final q2 m(Continuation continuation, CoroutineContext coroutineContext, Object obj) {
        if (!(continuation instanceof CoroutineStackFrame) || coroutineContext.get(r2.a) == null) {
            return null;
        }
        q2 l = l((CoroutineStackFrame) continuation);
        if (l != null) {
            l.V(coroutineContext, obj);
        }
        return l;
    }
}
