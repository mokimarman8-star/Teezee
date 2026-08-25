package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
abstract class l0 {
    l0() {
    }

    static l0 b(k0 k0Var, Class cls, Method method) {
        i0 b = i0.b(k0Var, cls, method);
        Type genericReturnType = method.getGenericReturnType();
        if (o0.j(genericReturnType)) {
            throw o0.n(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return u.f(k0Var, method, b);
        }
        throw o0.n(method, "Service methods cannot return void.", new Object[0]);
    }

    abstract Object a(Object obj, Object[] objArr);
}
