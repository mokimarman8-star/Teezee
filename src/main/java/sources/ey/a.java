package ey;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.Executor;
import yx.k;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class a {
    static final Scheduler a = dy.a.i(new h());
    static final Scheduler b = dy.a.f(new b());
    static final Scheduler c = dy.a.g(new c());
    static final Scheduler d = TrampolineScheduler.g();
    static final Scheduler e = dy.a.h(new f());

    /* renamed from: ey.a$a, reason: collision with other inner class name */
    static final class C0056a {
        static final Scheduler a = new io.reactivex.rxjava3.internal.schedulers.a();
    }

    static final class b implements k {
        b() {
        }

        @Override // yx.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return C0056a.a;
        }
    }

    static final class c implements k {
        c() {
        }

        @Override // yx.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return d.a;
        }
    }

    static final class d {
        static final Scheduler a = new IoScheduler();
    }

    static final class e {
        static final Scheduler a = new io.reactivex.rxjava3.internal.schedulers.d();
    }

    static final class f implements k {
        f() {
        }

        @Override // yx.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return e.a;
        }
    }

    static final class g {
        static final Scheduler a = new io.reactivex.rxjava3.internal.schedulers.h();
    }

    static final class h implements k {
        h() {
        }

        @Override // yx.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Scheduler get() {
            return g.a;
        }
    }

    public static Scheduler a(Executor executor) {
        return b(executor, false, false);
    }

    public static Scheduler b(Executor executor, boolean z, boolean z2) {
        return dy.a.e(executor, z, z2);
    }

    public static Scheduler c() {
        return dy.a.s(c);
    }

    public static Scheduler d() {
        return dy.a.u(a);
    }
}
