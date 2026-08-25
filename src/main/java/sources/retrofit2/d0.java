package retrofit2;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
class d0 {

    static final class a extends d0 {
        a() {
        }

        @Override // retrofit2.d0
        Object b(Method method, Class cls, Object obj, Object[] objArr) {
            if (Build.VERSION.SDK_INT >= 26) {
                return t.a(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }

        @Override // retrofit2.d0
        boolean c(Method method) {
            boolean isDefault;
            isDefault = method.isDefault();
            return isDefault;
        }
    }

    static class b extends d0 {
        b() {
        }

        @Override // retrofit2.d0
        String a(Method method, int i) {
            Parameter[] parameters;
            boolean isNamePresent;
            String name;
            parameters = method.getParameters();
            Parameter parameter = parameters[i];
            isNamePresent = parameter.isNamePresent();
            if (!isNamePresent) {
                return super.a(method, i);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("parameter '");
            name = parameter.getName();
            sb.append(name);
            sb.append('\'');
            return sb.toString();
        }

        @Override // retrofit2.d0
        Object b(Method method, Class cls, Object obj, Object[] objArr) {
            return t.a(method, cls, obj, objArr);
        }

        @Override // retrofit2.d0
        boolean c(Method method) {
            boolean isDefault;
            isDefault = method.isDefault();
            return isDefault;
        }
    }

    d0() {
    }

    String a(Method method, int i) {
        return "parameter #" + (i + 1);
    }

    Object b(Method method, Class cls, Object obj, Object[] objArr) {
        throw new AssertionError();
    }

    boolean c(Method method) {
        return false;
    }
}
