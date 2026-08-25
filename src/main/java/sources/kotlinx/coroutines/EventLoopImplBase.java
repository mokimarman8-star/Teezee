package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.k0;
import kotlinx.coroutines.internal.l0;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.t0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class EventLoopImplBase extends f1 implements t0 {
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _queue$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _delayed$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _isCompleted$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted$volatile");

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "nanoTime", "Lkotlinx/coroutines/n;", "", "cont", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/n;)V", "run", "()V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/n;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension
    private final class DelayedResumeTask extends DelayedTask {
        private final n cont;

        public DelayedResumeTask(long j, n nVar) {
            super(j);
            this.cont = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.a);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010)2\f\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010)8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00060"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/a1;", "Lkotlinx/coroutines/internal/l0;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "nanoTime", "<init>", "(J)V", "other", "", "compareTo", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "now", "", "timeToExecute", "(J)Z", "Lkotlinx/coroutines/EventLoopImplBase$a;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "scheduleTask", "(JLkotlinx/coroutines/EventLoopImplBase$a;Lkotlinx/coroutines/EventLoopImplBase;)I", "", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "J", "_heap", "Ljava/lang/Object;", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "Lkotlinx/coroutines/internal/k0;", "value", "getHeap", "()Lkotlinx/coroutines/internal/k0;", "setHeap", "(Lkotlinx/coroutines/internal/k0;)V", "heap", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, a1, l0 {
        private volatile Object _heap;
        private int index = -1;

        @JvmField
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        @Override // java.lang.Comparable
        public int compareTo(DelayedTask other) {
            long j = this.nanoTime - other.nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == h1.b()) {
                        return;
                    }
                    a aVar = obj instanceof a ? (a) obj : null;
                    if (aVar != null) {
                        aVar.h(this);
                    }
                    this._heap = h1.b();
                    Unit unit = Unit.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public k0 getHeap() {
            Object obj = this._heap;
            if (obj instanceof k0) {
                return (k0) obj;
            }
            return null;
        }

        public int getIndex() {
            return this.index;
        }

        public final int scheduleTask(long now, a delayed, EventLoopImplBase eventLoop) {
            synchronized (this) {
                if (this._heap == h1.b()) {
                    return 2;
                }
                synchronized (delayed) {
                    try {
                        DelayedTask delayedTask = (DelayedTask) delayed.b();
                        if (eventLoop.isCompleted()) {
                            return 1;
                        }
                        if (delayedTask == null) {
                            delayed.c = now;
                        } else {
                            long j = delayedTask.nanoTime;
                            if (j - now < 0) {
                                now = j;
                            }
                            if (now - delayed.c > 0) {
                                delayed.c = now;
                            }
                        }
                        long j2 = this.nanoTime;
                        long j3 = delayed.c;
                        if (j2 - j3 < 0) {
                            this.nanoTime = j3;
                        }
                        delayed.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public void setHeap(k0 k0Var) {
            if (this._heap == h1.b()) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = k0Var;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public final boolean timeToExecute(long now) {
            return now - this.nanoTime >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    private final void S(boolean z) {
        _isCompleted$volatile$FU.set(this, z ? 1 : 0);
    }

    private final boolean T(DelayedTask delayedTask) {
        a aVar = (a) _delayed$volatile$FU.get(this);
        return (aVar != null ? (DelayedTask) aVar.f() : null) == delayedTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        return _isCompleted$volatile$FU.get(this) != 0;
    }

    private final void q() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (a.a(_queue$volatile$FU, this, null, h1.a())) {
                    return;
                }
            } else if (obj instanceof m) {
                ((m) obj).d();
                return;
            } else {
                if (obj == h1.a()) {
                    return;
                }
                m mVar = new m(8, true);
                Intrinsics.f(obj, "null cannot be cast to non-null type java.lang.Runnable");
                mVar.a((Runnable) obj);
                if (a.a(_queue$volatile$FU, this, obj, mVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable r() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof m) {
                Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                m mVar = (m) obj;
                Object m = mVar.m();
                if (m != m.h) {
                    return (Runnable) m;
                }
                a.a(_queue$volatile$FU, this, obj, mVar.l());
            } else {
                if (obj == h1.a()) {
                    return null;
                }
                if (a.a(_queue$volatile$FU, this, obj, null)) {
                    Intrinsics.f(obj, "null cannot be cast to non-null type java.lang.Runnable");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final void s() {
        l0 l0Var;
        a aVar = (a) _delayed$volatile$FU.get(this);
        if (aVar == null || aVar.e()) {
            return;
        }
        b a = c.a();
        long a2 = a != null ? a.a() : System.nanoTime();
        do {
            synchronized (aVar) {
                try {
                    l0 b = aVar.b();
                    if (b != null) {
                        DelayedTask delayedTask = (DelayedTask) b;
                        l0Var = delayedTask.timeToExecute(a2) ? t(delayedTask) : false ? aVar.i(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (((DelayedTask) l0Var) != null);
    }

    private final boolean t(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _queue$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (a.a(_queue$volatile$FU, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof m) {
                Intrinsics.f(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                m mVar = (m) obj;
                int a = mVar.a(runnable);
                if (a == 0) {
                    return true;
                }
                if (a == 1) {
                    a.a(_queue$volatile$FU, this, obj, mVar.l());
                } else if (a == 2) {
                    return false;
                }
            } else {
                if (obj == h1.a()) {
                    return false;
                }
                m mVar2 = new m(8, true);
                Intrinsics.f(obj, "null cannot be cast to non-null type java.lang.Runnable");
                mVar2.a((Runnable) obj);
                mVar2.a(runnable);
                if (a.a(_queue$volatile$FU, this, obj, mVar2)) {
                    return true;
                }
            }
        }
    }

    private final void x() {
        DelayedTask delayedTask;
        b a = c.a();
        long a2 = a != null ? a.a() : System.nanoTime();
        while (true) {
            a aVar = (a) _delayed$volatile$FU.get(this);
            if (aVar == null || (delayedTask = (DelayedTask) aVar.j()) == null) {
                return;
            } else {
                reschedule(a2, delayedTask);
            }
        }
    }

    private final int y(long j, DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        a aVar = (a) _delayed$volatile$FU.get(this);
        if (aVar == null) {
            a.a(_delayed$volatile$FU, this, null, new a(j));
            Object obj = _delayed$volatile$FU.get(this);
            Intrinsics.e(obj);
            aVar = (a) obj;
        }
        return delayedTask.scheduleTask(j, aVar, this);
    }

    @Deprecated
    public Object delay(long j, Continuation<? super Unit> continuation) {
        return t0.a.a(this, j, continuation);
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        s();
        if (t(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    protected long getNextTime() {
        DelayedTask delayedTask;
        if (super/*kotlinx.coroutines.e1*/.getNextTime() == 0) {
            return 0L;
        }
        Object obj = _queue$volatile$FU.get(this);
        if (obj != null) {
            if (!(obj instanceof m)) {
                return obj == h1.a() ? Long.MAX_VALUE : 0L;
            }
            if (!((m) obj).j()) {
                return 0L;
            }
        }
        a aVar = (a) _delayed$volatile$FU.get(this);
        if (aVar == null || (delayedTask = (DelayedTask) aVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j = delayedTask.nanoTime;
        b a = c.a();
        return RangesKt.f(j - (a != null ? a.a() : System.nanoTime()), 0L);
    }

    public a1 invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return t0.a.b(this, j, runnable, coroutineContext);
    }

    protected boolean isEmpty() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        a aVar = (a) _delayed$volatile$FU.get(this);
        if (aVar != null && !aVar.e()) {
            return false;
        }
        Object obj = _queue$volatile$FU.get(this);
        if (obj != null) {
            if (obj instanceof m) {
                return ((m) obj).j();
            }
            if (obj != h1.a()) {
                return false;
            }
        }
        return true;
    }

    public long processNextEvent() {
        if (processUnconfinedEvent()) {
            return 0L;
        }
        s();
        Runnable r = r();
        if (r == null) {
            return getNextTime();
        }
        r.run();
        return 0L;
    }

    protected final void resetAll() {
        _queue$volatile$FU.set(this, null);
        _delayed$volatile$FU.set(this, null);
    }

    public final void schedule(long j, DelayedTask delayedTask) {
        int y = y(j, delayedTask);
        if (y == 0) {
            if (T(delayedTask)) {
                unpark();
            }
        } else if (y == 1) {
            reschedule(j, delayedTask);
        } else if (y != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    protected final a1 scheduleInvokeOnTimeout(long j, Runnable runnable) {
        long c = h1.c(j);
        if (c >= 4611686018427387903L) {
            return d2.a;
        }
        b a = c.a();
        long a2 = a != null ? a.a() : System.nanoTime();
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(c + a2, runnable);
        schedule(a2, delayedRunnableTask);
        return delayedRunnableTask;
    }

    public void scheduleResumeAfterDelay(long j, n nVar) {
        long c = h1.c(j);
        if (c < 4611686018427387903L) {
            b a = c.a();
            long a2 = a != null ? a.a() : System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(c + a2, nVar);
            schedule(a2, delayedResumeTask);
            q.a(nVar, delayedResumeTask);
        }
    }

    public void shutdown() {
        o2.a.c();
        S(true);
        q();
        while (processNextEvent() <= 0) {
        }
        x();
    }
}
