package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i {
    private static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "lastScheduledTask$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(i.class, "producerIndex$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(i.class, "consumerIndex$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(i.class, "blockingTasksInBuffer$volatile");
    private final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    private final Task b(Task task) {
        if (e() == 127) {
            return task;
        }
        if (task.taskContext) {
            e.incrementAndGet(this);
        }
        int i = c.get(this) & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, task);
        c.incrementAndGet(this);
        return null;
    }

    private final void c(Task task) {
        if (task == null || !task.taskContext) {
            return;
        }
        e.decrementAndGet(this);
    }

    private final int e() {
        return c.get(this) - d.get(this);
    }

    private final Task m() {
        Task task;
        while (true) {
            int i = d.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (task = (Task) this.a.getAndSet(i2, null)) != null) {
                c(task);
                return task;
            }
        }
    }

    private final boolean o(c cVar) {
        Task m = m();
        if (m == null) {
            return false;
        }
        cVar.a(m);
        return true;
    }

    private final Task p(boolean z) {
        Task task;
        do {
            task = (Task) b.get(this);
            if (task == null || task.taskContext != z) {
                int i = d.get(this);
                int i2 = c.get(this);
                while (i != i2) {
                    if (z && e.get(this) == 0) {
                        return null;
                    }
                    i2--;
                    Task r = r(i2, z);
                    if (r != null) {
                        return r;
                    }
                }
                return null;
            }
        } while (!androidx.concurrent.futures.a.a(b, this, task, (Object) null));
        return task;
    }

    private final Task q(int i) {
        int i2 = d.get(this);
        int i3 = c.get(this);
        boolean z = i == 1;
        while (i2 != i3) {
            if (z && e.get(this) == 0) {
                return null;
            }
            int i4 = i2 + 1;
            Task r = r(i2, z);
            if (r != null) {
                return r;
            }
            i2 = i4;
        }
        return null;
    }

    private final Task r(int i, boolean z) {
        int i2 = i & 127;
        Task task = (Task) this.a.get(i2);
        if (task == null || task.taskContext != z || !kotlinx.coroutines.channels.i.a(this.a, i2, task, null)) {
            return null;
        }
        if (z) {
            e.decrementAndGet(this);
        }
        return task;
    }

    private final long t(int i, Ref.ObjectRef objectRef) {
        Task task;
        do {
            task = (Task) b.get(this);
            if (task == null) {
                return -2L;
            }
            if (((task.taskContext ? 1 : 2) & i) == 0) {
                return -2L;
            }
            long a = g.f.a() - task.submissionTime;
            long j = g.b;
            if (a < j) {
                return j - a;
            }
        } while (!androidx.concurrent.futures.a.a(b, this, task, (Object) null));
        objectRef.element = task;
        return -1L;
    }

    public final Task a(Task task, boolean z) {
        if (z) {
            return b(task);
        }
        Task task2 = (Task) b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return b(task2);
    }

    public final int i() {
        return b.get(this) != null ? e() + 1 : e();
    }

    public final void j(c cVar) {
        Task task = (Task) b.getAndSet(this, null);
        if (task != null) {
            cVar.a(task);
        }
        while (o(cVar)) {
        }
    }

    public final Task k() {
        Task task = (Task) b.getAndSet(this, null);
        return task == null ? m() : task;
    }

    public final Task l() {
        return p(true);
    }

    public final Task n() {
        return p(false);
    }

    public final long s(int i, Ref.ObjectRef objectRef) {
        Task m = i == 3 ? m() : q(i);
        if (m == null) {
            return t(i, objectRef);
        }
        objectRef.element = m;
        return -1L;
    }
}
