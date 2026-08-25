package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class b {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(b bVar) {
        this._prev$volatile = bVar;
    }

    private final b d() {
        b h = h();
        while (h != null && h.k()) {
            h = (b) b.get(h);
        }
        return h;
    }

    private final b e() {
        b f;
        b f2 = f();
        Intrinsics.e(f2);
        while (f2.k() && (f = f2.f()) != null) {
            f2 = f;
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g() {
        return a.get(this);
    }

    public final void c() {
        b.set(this, null);
    }

    public final b f() {
        Object g = g();
        if (g == a.a) {
            return null;
        }
        return (b) g;
    }

    public final b h() {
        return (b) b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return androidx.concurrent.futures.a.a(a, this, (Object) null, a.a);
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            b d = d();
            b e = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            do {
                obj = atomicReferenceFieldUpdater.get(e);
            } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, e, obj, ((b) obj) == null ? null : d));
            if (d != null) {
                a.set(d, e);
            }
            if (!e.k() || e.l()) {
                if (d == null || !d.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(b bVar) {
        return androidx.concurrent.futures.a.a(a, this, (Object) null, bVar);
    }
}
