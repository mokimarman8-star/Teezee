package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class Functions {
    static final yx.h a = new g();
    public static final Runnable b = new EmptyRunnable();
    public static final yx.a c = new b();
    static final yx.f d = new c();
    public static final yx.f e = new e();
    public static final yx.f f = new k();
    public static final yx.i g = new d();
    static final yx.j h = new l();
    static final yx.j i = new f();
    static final yx.k j = new j();
    public static final yx.f k = new i();

    static final class EmptyRunnable implements Runnable {
        EmptyRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class a implements yx.h {
        final yx.g a;

        a(yx.g gVar) {
            this.a = gVar;
        }

        @Override // yx.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 3) {
                return this.a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    static final class b implements yx.a {
        b() {
        }

        @Override // yx.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class c implements yx.f {
        c() {
        }

        @Override // yx.f
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class d implements yx.i {
        d() {
        }
    }

    static final class e implements yx.f {
        e() {
        }

        @Override // yx.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            dy.a.r(th);
        }
    }

    static final class f implements yx.j {
        f() {
        }

        @Override // yx.j
        public boolean a(Object obj) {
            return false;
        }
    }

    static final class g implements yx.h {
        g() {
        }

        @Override // yx.h
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class h implements Callable, yx.k, yx.h {
        final Object a;

        h(Object obj) {
            this.a = obj;
        }

        @Override // yx.h
        public Object apply(Object obj) {
            return this.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.a;
        }

        @Override // yx.k
        public Object get() {
            return this.a;
        }
    }

    static final class i implements yx.f {
        i() {
        }

        @Override // yx.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(i00.d dVar) {
            dVar.request(Long.MAX_VALUE);
        }
    }

    static final class j implements yx.k {
        j() {
        }

        @Override // yx.k
        public Object get() {
            return null;
        }
    }

    static final class k implements yx.f {
        k() {
        }

        @Override // yx.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            dy.a.r(new OnErrorNotImplementedException(th));
        }
    }

    static final class l implements yx.j {
        l() {
        }

        @Override // yx.j
        public boolean a(Object obj) {
            return true;
        }
    }

    public static yx.f a() {
        return d;
    }

    public static yx.k b(Object obj) {
        return new h(obj);
    }

    public static yx.h c(yx.g gVar) {
        return new a(gVar);
    }
}
