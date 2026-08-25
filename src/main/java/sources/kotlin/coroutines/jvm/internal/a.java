package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class a {
    public static final a a = new a();
    private static final C0073a b = new C0073a(null, null, null);
    private static C0073a c;

    /* renamed from: kotlin.coroutines.jvm.internal.a$a, reason: collision with other inner class name */
    private static final class C0073a {
        public final Method a;
        public final Method b;
        public final Method c;

        public C0073a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    private a() {
    }

    private final C0073a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            C0073a c0073a = new C0073a(Class.class.getDeclaredMethod("getModule", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            c = c0073a;
            return c0073a;
        } catch (Exception unused) {
            C0073a c0073a2 = b;
            c = c0073a2;
            return c0073a2;
        }
    }

    public final String b(BaseContinuationImpl continuation) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        Intrinsics.h(continuation, "continuation");
        C0073a c0073a = c;
        if (c0073a == null) {
            c0073a = a(continuation);
        }
        if (c0073a == b || (method = c0073a.a) == null || (invoke = method.invoke(continuation.getClass(), null)) == null || (method2 = c0073a.b) == null || (invoke2 = method2.invoke(invoke, null)) == null) {
            return null;
        }
        Method method3 = c0073a.c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
