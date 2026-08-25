package androidx.coroutines.support;

import android.os.SystemClock;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;
import z3.d;
import z3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AutoCloser {

    /* renamed from: l, reason: collision with root package name */
    public static final a f13243l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final b f13244a;

    /* renamed from: b, reason: collision with root package name */
    private e f13245b;

    /* renamed from: c, reason: collision with root package name */
    private n0 f13246c;

    /* renamed from: d, reason: collision with root package name */
    private Function0 f13247d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f13248e;

    /* renamed from: f, reason: collision with root package name */
    private final long f13249f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicInteger f13250g;

    /* renamed from: h, reason: collision with root package name */
    private AtomicLong f13251h;

    /* renamed from: i, reason: collision with root package name */
    private d f13252i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13253j;

    /* renamed from: k, reason: collision with root package name */
    private t1 f13254k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        long a();
    }

    public AutoCloser(long j5, TimeUnit timeUnit, b bVar) {
        Intrinsics.h(timeUnit, "timeUnit");
        Intrinsics.h(bVar, "watch");
        this.f13244a = bVar;
        this.f13248e = new Object();
        this.f13249f = timeUnit.toMillis(j5);
        this.f13250g = new AtomicInteger(0);
        this.f13251h = new AtomicLong(bVar.a());
    }

    public /* synthetic */ AutoCloser(long j5, TimeUnit timeUnit, b bVar, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, timeUnit, (i5 & 4) != 0 ? new b() { // from class: androidx.room.support.a
            @Override // androidx.room.support.AutoCloser.b
            public final long a() {
                long b5;
                b5 = AutoCloser.b();
                return b5;
            }
        } : bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long b() {
        return SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        synchronized (this.f13248e) {
            try {
                if (this.f13244a.a() - this.f13251h.get() < this.f13249f) {
                    return;
                }
                if (this.f13250g.get() != 0) {
                    return;
                }
                Function0 function0 = this.f13247d;
                if (function0 == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should  have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                function0.invoke();
                d dVar = this.f13252i;
                if (dVar != null && dVar.isOpen()) {
                    dVar.close();
                }
                this.f13252i = null;
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        synchronized (this.f13248e) {
            try {
                this.f13253j = true;
                t1 t1Var = this.f13254k;
                if (t1Var != null) {
                    t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
                }
                this.f13254k = null;
                d dVar = this.f13252i;
                if (dVar != null) {
                    dVar.close();
                }
                this.f13252i = null;
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        n0 n0Var;
        int decrementAndGet = this.f13250g.decrementAndGet();
        if (decrementAndGet < 0) {
            throw new IllegalStateException("Unbalanced reference count.");
        }
        this.f13251h.set(this.f13244a.a());
        if (decrementAndGet == 0) {
            n0 n0Var2 = this.f13246c;
            if (n0Var2 == null) {
                Intrinsics.y("coroutineScope");
                n0Var = null;
            } else {
                n0Var = n0Var2;
            }
            this.f13254k = i.d(n0Var, (CoroutineContext) null, (CoroutineStart) null, new AutoCloser$decrementCountAndScheduleClose$2(this, null), 3, (Object) null);
        }
    }

    public final Object h(Function1 function1) {
        Intrinsics.h(function1, "block");
        try {
            return function1.invoke(j());
        } finally {
            g();
        }
    }

    public final d i() {
        return this.f13252i;
    }

    public final d j() {
        t1 t1Var = this.f13254k;
        e eVar = null;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f13254k = null;
        this.f13250g.incrementAndGet();
        if (this.f13253j) {
            throw new IllegalStateException("Attempting to open already closed database.");
        }
        synchronized (this.f13248e) {
            d dVar = this.f13252i;
            if (dVar != null && dVar.isOpen()) {
                return dVar;
            }
            e eVar2 = this.f13245b;
            if (eVar2 == null) {
                Intrinsics.y("delegateOpenHelper");
            } else {
                eVar = eVar2;
            }
            d writableDatabase = eVar.getWritableDatabase();
            this.f13252i = writableDatabase;
            return writableDatabase;
        }
    }

    public final void k(n0 n0Var) {
        Intrinsics.h(n0Var, "coroutineScope");
        this.f13246c = n0Var;
    }

    public final void l(e eVar) {
        Intrinsics.h(eVar, "delegateOpenHelper");
        if (eVar instanceof AutoClosingRoomOpenHelper) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f13245b = eVar;
    }

    public final boolean m() {
        return !this.f13253j;
    }

    public final void n(Function0 function0) {
        Intrinsics.h(function0, "onAutoClose");
        this.f13247d = function0;
    }
}
