package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m2;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class g0 {
    public static final z a = new z("NO_THREAD_ELEMENTS");
    private static final Function2 b = new Function2() { // from class: kotlinx.coroutines.internal.d0
        public final Object invoke(Object obj, Object obj2) {
            Object d2;
            d2 = g0.d(obj, (CoroutineContext.Element) obj2);
            return d2;
        }
    };
    private static final Function2 c = new Function2() { // from class: kotlinx.coroutines.internal.e0
        public final Object invoke(Object obj, Object obj2) {
            m2 e;
            e = g0.e((m2) obj, (CoroutineContext.Element) obj2);
            return e;
        }
    };
    private static final Function2 d = new Function2() { // from class: kotlinx.coroutines.internal.f0
        public final Object invoke(Object obj, Object obj2) {
            m0 h;
            h = g0.h((m0) obj, (CoroutineContext.Element) obj2);
            return h;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Object obj, CoroutineContext.Element element) {
        if (!(element instanceof m2)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int intValue = num != null ? num.intValue() : 1;
        return intValue == 0 ? element : Integer.valueOf(intValue + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m2 e(m2 m2Var, CoroutineContext.Element element) {
        if (m2Var != null) {
            return m2Var;
        }
        if (element instanceof m2) {
            return (m2) element;
        }
        return null;
    }

    public static final void f(CoroutineContext coroutineContext, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof m0) {
            ((m0) obj).b(coroutineContext);
            return;
        }
        Object fold = coroutineContext.fold(null, c);
        Intrinsics.f(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((m2) fold).k(coroutineContext, obj);
    }

    public static final Object g(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, b);
        Intrinsics.e(fold);
        return fold;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m0 h(m0 m0Var, CoroutineContext.Element element) {
        if (element instanceof m2) {
            m2 m2Var = (m2) element;
            m0Var.a(m2Var, m2Var.o(m0Var.a));
        }
        return m0Var;
    }

    public static final Object i(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = g(coroutineContext);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new m0(coroutineContext, ((Number) obj).intValue()), d);
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((m2) obj).o(coroutineContext);
    }
}
