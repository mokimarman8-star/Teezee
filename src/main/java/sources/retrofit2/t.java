package retrofit2;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
abstract class t {
    private static Constructor a;

    static Object a(Method method, Class cls, Object obj, Object[] objArr) {
        MethodHandle unreflectSpecial;
        MethodHandle bindTo;
        Object invokeWithArguments;
        Constructor constructor = a;
        if (constructor == null) {
            constructor = o.a().getDeclaredConstructor(Class.class, Integer.TYPE);
            constructor.setAccessible(true);
            a = constructor;
        }
        unreflectSpecial = p.a(constructor.newInstance(cls, -1)).unreflectSpecial(method, cls);
        bindTo = unreflectSpecial.bindTo(obj);
        invokeWithArguments = bindTo.invokeWithArguments(objArr);
        return invokeWithArguments;
    }
}
