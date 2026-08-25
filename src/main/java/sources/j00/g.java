package j00;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.e;
import retrofit2.j0;
import retrofit2.k0;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class g extends e.a {
    private final Scheduler a;
    private final boolean b;

    private g(Scheduler scheduler, boolean z) {
        this.a = scheduler;
        this.b = z;
    }

    public static g d(Scheduler scheduler) {
        if (scheduler != null) {
            return new g(scheduler, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.e.a
    public retrofit2.e a(Type type, Annotation[] annotationArr, k0 k0Var) {
        Type type2;
        boolean z;
        boolean z2;
        Class c = e.a.c(type);
        if (c == io.reactivex.rxjava3.core.a.class) {
            return new f(Void.class, this.a, this.b, false, true, false, false, false, true);
        }
        boolean z3 = c == io.reactivex.rxjava3.core.e.class;
        boolean z4 = c == p.class;
        boolean z5 = c == io.reactivex.rxjava3.core.g.class;
        if (c != j.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type b = e.a.b(0, (ParameterizedType) type);
        Class c2 = e.a.c(b);
        if (c2 == j0.class) {
            if (!(b instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            type2 = e.a.b(0, (ParameterizedType) b);
            z2 = false;
            z = false;
        } else if (c2 != d.class) {
            type2 = b;
            z = true;
            z2 = false;
        } else {
            if (!(b instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            type2 = e.a.b(0, (ParameterizedType) b);
            z2 = true;
            z = false;
        }
        return new f(type2, this.a, this.b, z2, z, z3, z4, z5, false);
    }
}
