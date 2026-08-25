package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.Response;
import retrofit2.o0;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
abstract class u extends l0 {
    private final i0 a;
    private final Call.Factory b;
    private final k c;

    static final class a extends u {
        private final e d;

        a(i0 i0Var, Call.Factory factory, k kVar, e eVar) {
            super(i0Var, factory, kVar);
            this.d = eVar;
        }

        @Override // retrofit2.u
        protected Object c(d dVar, Object[] objArr) {
            return this.d.b(dVar);
        }
    }

    static final class b extends u {
        private final e d;
        private final boolean e;
        private final boolean f;

        b(i0 i0Var, Call.Factory factory, k kVar, e eVar, boolean z, boolean z2) {
            super(i0Var, factory, kVar);
            this.d = eVar;
            this.e = z;
            this.f = z2;
        }

        @Override // retrofit2.u
        protected Object c(d dVar, Object[] objArr) {
            d dVar2 = (d) this.d.b(dVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return this.f ? KotlinExtensions.d(dVar2, continuation) : this.e ? KotlinExtensions.b(dVar2, continuation) : KotlinExtensions.a(dVar2, continuation);
            } catch (LinkageError e) {
                throw e;
            } catch (ThreadDeath e3) {
                throw e3;
            } catch (VirtualMachineError e4) {
                throw e4;
            } catch (Throwable th) {
                return KotlinExtensions.e(th, continuation);
            }
        }
    }

    static final class c extends u {
        private final e d;

        c(i0 i0Var, Call.Factory factory, k kVar, e eVar) {
            super(i0Var, factory, kVar);
            this.d = eVar;
        }

        @Override // retrofit2.u
        protected Object c(d dVar, Object[] objArr) {
            d dVar2 = (d) this.d.b(dVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.c(dVar2, continuation);
            } catch (Exception e) {
                return KotlinExtensions.e(e, continuation);
            }
        }
    }

    u(i0 i0Var, Call.Factory factory, k kVar) {
        this.a = i0Var;
        this.b = factory;
        this.c = kVar;
    }

    private static e d(k0 k0Var, Method method, Type type, Annotation[] annotationArr) {
        try {
            return k0Var.a(type, annotationArr);
        } catch (RuntimeException e) {
            throw o0.o(method, e, "Unable to create call adapter for %s", type);
        }
    }

    private static k e(k0 k0Var, Method method, Type type) {
        try {
            return k0Var.h(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw o0.o(method, e, "Unable to create converter for %s", type);
        }
    }

    static u f(k0 k0Var, Method method, i0 i0Var) {
        Type genericReturnType;
        boolean z;
        boolean z2;
        boolean m;
        boolean z3 = i0Var.l;
        Annotation[] annotations = method.getAnnotations();
        if (z3) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type f = o0.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (o0.h(f) == j0.class && (f instanceof ParameterizedType)) {
                f = o0.g(0, (ParameterizedType) f);
                z = true;
                m = false;
            } else {
                if (o0.h(f) == d.class) {
                    throw o0.n(method, "Suspend functions should not return Call, as they already execute asynchronously.\nChange its return type to %s", o0.g(0, (ParameterizedType) f));
                }
                m = o0.m(f);
                z = false;
            }
            genericReturnType = new o0.b(null, d.class, f);
            annotations = n0.a(annotations);
            z2 = m;
        } else {
            genericReturnType = method.getGenericReturnType();
            z = false;
            z2 = false;
        }
        e d = d(k0Var, method, genericReturnType, annotations);
        Type a2 = d.a();
        if (a2 == Response.class) {
            throw o0.n(method, "'" + o0.h(a2).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (a2 == j0.class) {
            throw o0.n(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (i0Var.d.equals("HEAD") && !Void.class.equals(a2) && !o0.m(a2)) {
            throw o0.n(method, "HEAD method must use Void or Unit as response type.", new Object[0]);
        }
        k e = e(k0Var, method, a2);
        Call.Factory factory = k0Var.b;
        return !z3 ? new a(i0Var, factory, e, d) : z ? new c(i0Var, factory, e, d) : new b(i0Var, factory, e, d, false, z2);
    }

    @Override // retrofit2.l0
    final Object a(Object obj, Object[] objArr) {
        return c(new w(this.a, obj, objArr, this.b, this.c), objArr);
    }

    protected abstract Object c(d dVar, Object[] objArr);
}
