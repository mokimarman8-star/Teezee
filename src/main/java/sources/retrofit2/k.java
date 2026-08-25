package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public interface k {

    public static abstract class a {
        protected static Type a(int i, ParameterizedType parameterizedType) {
            return o0.g(i, parameterizedType);
        }

        protected static Class b(Type type) {
            return o0.h(type);
        }

        public k c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, k0 k0Var) {
            return null;
        }

        public k d(Type type, Annotation[] annotationArr, k0 k0Var) {
            return null;
        }

        public k e(Type type, Annotation[] annotationArr, k0 k0Var) {
            return null;
        }
    }

    Object convert(Object obj);
}
