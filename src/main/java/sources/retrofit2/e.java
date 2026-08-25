package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public interface e {

    public static abstract class a {
        protected static Type b(int i, ParameterizedType parameterizedType) {
            return o0.g(i, parameterizedType);
        }

        protected static Class c(Type type) {
            return o0.h(type);
        }

        public abstract e a(Type type, Annotation[] annotationArr, k0 k0Var);
    }

    Type a();

    Object b(d dVar);
}
