package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.i;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class i0 extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    public static final a Key = new a(null);

    public static final class a extends AbstractCoroutineContextKey {
        private a() {
            super(ContinuationInterceptor.k1, new Function1() { // from class: kotlinx.coroutines.h0
                public final Object invoke(Object obj) {
                    i0 d;
                    d = i0.a.d((CoroutineContext.Element) obj);
                    return d;
                }
            });
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final i0 d(CoroutineContext.Element element) {
            if (element instanceof i0) {
                return (i0) element;
            }
            return null;
        }
    }

    public i0() {
        super(ContinuationInterceptor.k1);
    }

    public static /* synthetic */ i0 limitedParallelism$default(i0 i0Var, int i, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return i0Var.limitedParallelism(i, str);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.DefaultImpls.a(this, key);
    }

    public final <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return true;
    }

    @Deprecated
    public /* synthetic */ i0 limitedParallelism(int i) {
        return limitedParallelism(i, null);
    }

    public i0 limitedParallelism(int i, String str) {
        i.a(i);
        return new LimitedDispatcher(this, i, str);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.DefaultImpls.b(this, key);
    }

    @Deprecated
    public final i0 plus(i0 i0Var) {
        return i0Var;
    }

    public final void releaseInterceptedContinuation(Continuation<?> continuation) {
        Intrinsics.f(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((DispatchedContinuation) continuation).release$kotlinx_coroutines_core();
    }

    public String toString() {
        return p0.a(this) + '@' + p0.b(this);
    }
}
