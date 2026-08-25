package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class m {
    public static final a e = new a(null);
    private static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");
    public static final z h = new z("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    private final int a;
    private final boolean b;
    private final int c;
    private final /* synthetic */ AtomicReferenceArray d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i) {
            return d(j, 1073741823L) | i;
        }

        public final long c(long j, int i) {
            return d(j, 1152921503533105152L) | (i << 30);
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }
    }

    public static final class b {
        public final int a;

        public b(int i) {
            this.a = i;
        }
    }

    public m(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    private final m b(long j) {
        m mVar = new m(this.a * 2, this.b);
        int i = (int) (1073741823 & j);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.c;
            if ((i & i3) == (i3 & i2)) {
                g.set(mVar, e.d(j, 1152921504606846976L));
                return mVar;
            }
            Object obj = f().get(this.c & i);
            if (obj == null) {
                obj = new b(i);
            }
            mVar.f().set(mVar.c & i, obj);
            i++;
        }
    }

    private final m c(long j) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        while (true) {
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar != null) {
                return mVar;
            }
            androidx.concurrent.futures.a.a(f, this, (Object) null, b(j));
        }
    }

    private final m e(int i, Object obj) {
        Object obj2 = f().get(this.c & i);
        if (!(obj2 instanceof b) || ((b) obj2).a != i) {
            return null;
        }
        f().set(i & this.c, obj);
        return this;
    }

    private final /* synthetic */ AtomicReferenceArray f() {
        return this.d;
    }

    private final long k() {
        long j;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j2));
        return j2;
    }

    private final m n(int i, int i2) {
        long j;
        int i3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j = atomicLongFieldUpdater.get(this);
            i3 = (int) (1073741823 & j);
            if ((1152921504606846976L & j) != 0) {
                return l();
            }
        } while (!g.compareAndSet(this, j, e.b(j, i2)));
        f().set(this.c & i3, null);
        return null;
    }

    public final int a(Object obj) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return e.a(j);
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.b && f().get(i2 & i3) != null) {
                int i4 = this.a;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    break;
                }
            } else if (g.compareAndSet(this, j, e.c(j, (i2 + 1) & 1073741823))) {
                f().set(i2 & i3, obj);
                m mVar = this;
                while ((g.get(mVar) & 1152921504606846976L) != 0 && (mVar = mVar.l().e(i2, obj)) != null) {
                }
                return 0;
            }
        }
        return 1;
    }

    public final boolean d() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int g() {
        long j = g.get(this);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final boolean j() {
        long j = g.get(this);
        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final m l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j) != 0) {
                return h;
            }
            int i = (int) (1073741823 & j);
            int i2 = this.c;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) == (i2 & i)) {
                return null;
            }
            Object obj = f().get(this.c & i);
            if (obj == null) {
                if (this.b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i3 = (i + 1) & 1073741823;
                if (g.compareAndSet(this, j, e.b(j, i3))) {
                    f().set(this.c & i, null);
                    return obj;
                }
                if (this.b) {
                    m mVar = this;
                    do {
                        mVar = mVar.n(i, i3);
                    } while (mVar != null);
                    return obj;
                }
            }
        }
    }
}
