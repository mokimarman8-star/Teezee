package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class JobSupport$b implements p1 {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(JobSupport$b.class, "_isCompleting$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(JobSupport$b.class, Object.class, "_rootCause$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(JobSupport$b.class, Object.class, "_exceptionsHolder$volatile");
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile;
    private volatile /* synthetic */ Object _rootCause$volatile;
    private final b2 a;

    public JobSupport$b(b2 b2Var, boolean z, Throwable th) {
        this.a = b2Var;
        this._isCompleting$volatile = z ? 1 : 0;
        this._rootCause$volatile = th;
    }

    private final ArrayList c() {
        return new ArrayList(4);
    }

    private final Object d() {
        return d.get(this);
    }

    private final void n(Object obj) {
        d.set(this, obj);
    }

    public final void a(Throwable th) {
        Throwable e = e();
        if (e == null) {
            o(th);
            return;
        }
        if (th == e) {
            return;
        }
        Object d2 = d();
        if (d2 == null) {
            n(th);
            return;
        }
        if (d2 instanceof Throwable) {
            if (th == d2) {
                return;
            }
            ArrayList c2 = c();
            c2.add(d2);
            c2.add(th);
            n(c2);
            return;
        }
        if (d2 instanceof ArrayList) {
            ((ArrayList) d2).add(th);
            return;
        }
        throw new IllegalStateException(("State is " + d2).toString());
    }

    @Override // kotlinx.coroutines.p1
    public b2 b() {
        return this.a;
    }

    public final Throwable e() {
        return (Throwable) c.get(this);
    }

    public final boolean i() {
        return e() != null;
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return e() == null;
    }

    public final boolean j() {
        return b.get(this) != 0;
    }

    public final boolean k() {
        kotlinx.coroutines.internal.z zVar;
        Object d2 = d();
        zVar = x1.e;
        return d2 == zVar;
    }

    public final List l(Throwable th) {
        ArrayList arrayList;
        kotlinx.coroutines.internal.z zVar;
        Object d2 = d();
        if (d2 == null) {
            arrayList = c();
        } else if (d2 instanceof Throwable) {
            ArrayList c2 = c();
            c2.add(d2);
            arrayList = c2;
        } else {
            if (!(d2 instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + d2).toString());
            }
            arrayList = (ArrayList) d2;
        }
        Throwable e = e();
        if (e != null) {
            arrayList.add(0, e);
        }
        if (th != null && !Intrinsics.c(th, e)) {
            arrayList.add(th);
        }
        zVar = x1.e;
        n(zVar);
        return arrayList;
    }

    public final void m(boolean z) {
        b.set(this, z ? 1 : 0);
    }

    public final void o(Throwable th) {
        c.set(this, th);
    }

    public String toString() {
        return "Finishing[cancelling=" + i() + ", completing=" + j() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + b() + ']';
    }
}
