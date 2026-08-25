package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.b;
import kotlinx.coroutines.c;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    public static final a h = new a((DefaultConstructorMarker) null);
    private static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");
    public static final z l = new z("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;
    public final int a;
    public final int b;
    public final long c;
    private volatile /* synthetic */ long controlState$volatile;
    public final String d;
    public final c e;
    public final c f;
    public final u g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u0016J\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u001d\u001a\u00060\u0004j\u0002`\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\fJ\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0007¢\u0006\u0004\b(\u0010\tJ\u0015\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\u0007¢\u0006\u0004\b-\u0010\u001aR*\u0010.\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010=R\u0016\u0010F\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010/R\u0016\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010GR\u0012\u0010K\u001a\u00020H8Æ\u0002¢\u0006\u0006\u001a\u0004\bI\u0010JR\b\u0010M\u001a\u00020L8\u0006¨\u0006N"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "", "index", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "", "tryAcquireCpuPermit", "()Z", "", "runWorker", "()V", "tryPark", "inStack", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "park", "tryTerminateWorker", "findBlockingTask", "()Lkotlinx/coroutines/scheduling/Task;", "findCpuTask", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "pollGlobalQueues", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "trySteal", "(I)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "", "runSingleTask", "()J", "isIo", "upperBound", "nextInt", "(I)I", "mayHaveLocalTasks", "findTask", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "Lkotlinx/coroutines/scheduling/i;", "localQueue", "Lkotlinx/coroutines/scheduling/i;", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "Lkotlinx/atomicfu/AtomicInt;", "workerCtl", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension
    public final class Worker extends Thread {
        private static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        private volatile int indexInArray;

        @JvmField
        public final i localQueue;

        @JvmField
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;

        @JvmField
        public WorkerState state;
        private final Ref$ObjectRef<Task> stolenTask;
        private long terminationDeadline;
        private volatile /* synthetic */ int workerCtl$volatile;

        private Worker() {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.localQueue = new i();
            this.stolenTask = new Ref$ObjectRef<>();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.l;
            int nanoTime = (int) System.nanoTime();
            this.rngState = nanoTime == 0 ? 42 : nanoTime;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
        }

        private final void executeTask(Task task) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                this.state = WorkerState.BLOCKING;
            }
            if (!task.taskContext) {
                CoroutineScheduler.this.v(task);
                return;
            }
            if (tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.y();
            }
            CoroutineScheduler.this.v(task);
            CoroutineScheduler.o().addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.state != WorkerState.TERMINATED) {
                this.state = WorkerState.DORMANT;
            }
        }

        private final Task findAnyTask(boolean scanLocalQueue) {
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            if (scanLocalQueue) {
                boolean z = nextInt(CoroutineScheduler.this.a * 2) == 0;
                if (z && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                Task k = this.localQueue.k();
                if (k != null) {
                    return k;
                }
                if (!z && (pollGlobalQueues = pollGlobalQueues()) != null) {
                    return pollGlobalQueues;
                }
            } else {
                Task pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        private final Task findBlockingTask() {
            Task l = this.localQueue.l();
            if (l != null) {
                return l;
            }
            Task task = (Task) CoroutineScheduler.this.f.e();
            return task == null ? trySteal(1) : task;
        }

        private final Task findCpuTask() {
            Task n = this.localQueue.n();
            if (n != null) {
                return n;
            }
            Task task = (Task) CoroutineScheduler.this.f.e();
            return task == null ? trySteal(2) : task;
        }

        private final /* synthetic */ int getWorkerCtl$volatile() {
            return this.workerCtl$volatile;
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.l;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.c);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            if (nextInt(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.e.e();
                return task != null ? task : (Task) CoroutineScheduler.this.f.e();
            }
            Task task2 = (Task) CoroutineScheduler.this.f.e();
            return task2 != null ? task2 : (Task) CoroutineScheduler.this.e.e();
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            tryPark();
                        } else if (z) {
                            tryReleaseCpu(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        private final /* synthetic */ void setWorkerCtl$volatile(int i) {
            this.workerCtl$volatile = i;
        }

        private final boolean tryAcquireCpuPermit() {
            long j;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater o = CoroutineScheduler.o();
            do {
                j = o.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.o().compareAndSet(coroutineScheduler, j, j - 4398046511104L));
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.t(this);
                return;
            }
            workerCtl$volatile$FU.set(this, -1);
            while (inStack() && workerCtl$volatile$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final Task trySteal(int stealingMode) {
            int i = (int) (CoroutineScheduler.o().get(CoroutineScheduler.this) & 2097151);
            if (i < 2) {
                return null;
            }
            int nextInt = nextInt(i);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j = Long.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                nextInt++;
                if (nextInt > i) {
                    nextInt = 1;
                }
                Worker worker = (Worker) coroutineScheduler.g.b(nextInt);
                if (worker != null && worker != this) {
                    long s = worker.localQueue.s(stealingMode, this.stolenTask);
                    if (s == -1) {
                        Ref$ObjectRef<Task> ref$ObjectRef = this.stolenTask;
                        Task task = ref$ObjectRef.element;
                        ref$ObjectRef.element = null;
                        return task;
                    }
                    if (s > 0) {
                        j = Math.min(j, s);
                    }
                }
            }
            if (j == Long.MAX_VALUE) {
                j = 0;
            }
            this.minDelayUntilStealableTaskNs = j;
            return null;
        }

        private final void tryTerminateWorker() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.g) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.o().get(coroutineScheduler) & 2097151)) <= coroutineScheduler.a) {
                        return;
                    }
                    if (workerCtl$volatile$FU.compareAndSet(this, -1, 1)) {
                        int i = this.indexInArray;
                        setIndexInArray(0);
                        coroutineScheduler.u(this, i, 0);
                        int andDecrement = (int) (CoroutineScheduler.o().getAndDecrement(coroutineScheduler) & 2097151);
                        if (andDecrement != i) {
                            Object b = coroutineScheduler.g.b(andDecrement);
                            Intrinsics.e(b);
                            Worker worker = (Worker) b;
                            coroutineScheduler.g.c(i, worker);
                            worker.setIndexInArray(i);
                            coroutineScheduler.u(worker, andDecrement, i);
                        }
                        coroutineScheduler.g.c(andDecrement, (Object) null);
                        Unit unit = Unit.a;
                        this.state = WorkerState.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Task findTask(boolean mayHaveLocalTasks) {
            return tryAcquireCpuPermit() ? findAnyTask(mayHaveLocalTasks) : findBlockingTask();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final boolean isIo() {
            return this.state == WorkerState.BLOCKING;
        }

        public final int nextInt(int upperBound) {
            int i = this.rngState;
            int i2 = i ^ (i << 13);
            int i3 = i2 ^ (i2 >> 17);
            int i4 = i3 ^ (i3 << 5);
            this.rngState = i4;
            int i6 = upperBound - 1;
            return (i6 & upperBound) == 0 ? i4 & i6 : (i4 & Integer.MAX_VALUE) % upperBound;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        public final long runSingleTask() {
            boolean z = this.state == WorkerState.CPU_ACQUIRED;
            Task findCpuTask = z ? findCpuTask() : findBlockingTask();
            if (findCpuTask == null) {
                long j = this.minDelayUntilStealableTaskNs;
                if (j == 0) {
                    return -1L;
                }
                return j;
            }
            CoroutineScheduler.this.v(findCpuTask);
            if (!z) {
                CoroutineScheduler.o().addAndGet(CoroutineScheduler.this, -2097152L);
            }
            return 0L;
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.d);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(WorkerState newState) {
            WorkerState workerState = this.state;
            boolean z = workerState == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.o().addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WorkerState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WorkerState[] $VALUES;
        public static final WorkerState CPU_ACQUIRED = new WorkerState("CPU_ACQUIRED", 0);
        public static final WorkerState BLOCKING = new WorkerState("BLOCKING", 1);
        public static final WorkerState PARKING = new WorkerState("PARKING", 2);
        public static final WorkerState DORMANT = new WorkerState("DORMANT", 3);
        public static final WorkerState TERMINATED = new WorkerState("TERMINATED", 4);

        private static final /* synthetic */ WorkerState[] $values() {
            return new WorkerState[]{CPU_ACQUIRED, BLOCKING, PARKING, DORMANT, TERMINATED};
        }

        static {
            WorkerState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private WorkerState(String str, int i) {
        }

        public static EnumEntries<WorkerState> getEntries() {
            return $ENTRIES;
        }

        public static WorkerState valueOf(String str) {
            return (WorkerState) Enum.valueOf(WorkerState.class, str);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) $VALUES.clone();
        }
    }

    public CoroutineScheduler(int i2, int i3, long j2, String str) {
        this.a = i2;
        this.b = i3;
        this.c = j2;
        this.d = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.e = new c();
        this.f = new c();
        this.g = new u((i2 + 1) * 2);
        this.controlState$volatile = i2 << 42;
        this._isTerminated$volatile = 0;
    }

    private final Task S(Worker worker, Task task, boolean z) {
        WorkerState workerState;
        if (worker == null || (workerState = worker.state) == WorkerState.TERMINATED) {
            return task;
        }
        if (!task.taskContext && workerState == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.a(task, z);
    }

    private final boolean T(long j2) {
        if (RangesKt.e(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.a) {
            int h2 = h();
            if (h2 == 1 && this.a > 1) {
                h();
            }
            if (h2 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean W(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = j.get(coroutineScheduler);
        }
        return coroutineScheduler.T(j2);
    }

    private final boolean X() {
        Worker s;
        do {
            s = s();
            if (s == null) {
                return false;
            }
        } while (!Worker.workerCtl$volatile$FU.compareAndSet(s, -1, 0));
        LockSupport.unpark(s);
        return true;
    }

    private final boolean f(Task task) {
        return task.taskContext ? this.f.a(task) : this.e.a(task);
    }

    private final int h() {
        synchronized (this.g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j2 = j.get(this);
                int i2 = (int) (j2 & 2097151);
                int e = RangesKt.e(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
                if (e >= this.a) {
                    return 0;
                }
                if (i2 >= this.b) {
                    return 0;
                }
                int i3 = ((int) (o().get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.g.b(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                Worker worker = new Worker(this, i3);
                this.g.c(i3, worker);
                if (i3 != ((int) (2097151 & j.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = e + 1;
                worker.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final Worker k() {
        Thread currentThread = Thread.currentThread();
        Worker worker = currentThread instanceof Worker ? (Worker) currentThread : null;
        if (worker == null || !Intrinsics.c(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public static /* synthetic */ void m(CoroutineScheduler coroutineScheduler, Runnable runnable, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        coroutineScheduler.l(runnable, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater o() {
        return j;
    }

    private final int r(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != l) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    private final Worker s() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            Worker worker = (Worker) this.g.b((int) (2097151 & j2));
            if (worker == null) {
                return null;
            }
            long j3 = (2097152 + j2) & (-2097152);
            int r = r(worker);
            if (r >= 0 && i.compareAndSet(this, j2, r | j3)) {
                worker.setNextParkedWorker(l);
                return worker;
            }
        }
    }

    private final void x(long j2, boolean z) {
        if (z || X() || T(j2)) {
            return;
        }
        X();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        w(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m(this, runnable, false, false, 6, null);
    }

    public final boolean isTerminated() {
        return k.get(this) != 0;
    }

    public final Task j(Runnable runnable, boolean z) {
        long a = g.f.a();
        if (!(runnable instanceof Task)) {
            return g.b(runnable, a, z);
        }
        Task task = (Task) runnable;
        task.submissionTime = a;
        task.taskContext = z;
        return task;
    }

    public final void l(Runnable runnable, boolean z, boolean z2) {
        b a = c.a();
        if (a != null) {
            a.d();
        }
        Task j2 = j(runnable, z);
        boolean z3 = j2.taskContext;
        long addAndGet = z3 ? j.addAndGet(this, 2097152L) : 0L;
        Worker k2 = k();
        Task S = S(k2, j2, z2);
        if (S != null && !f(S)) {
            throw new RejectedExecutionException(this.d + " was terminated");
        }
        boolean z4 = z2 && k2 != null;
        if (z3) {
            x(addAndGet, z4);
        } else {
            if (z4) {
                return;
            }
            y();
        }
    }

    public final boolean t(Worker worker) {
        long j2;
        int indexInArray;
        if (worker.getNextParkedWorker() != l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            indexInArray = worker.getIndexInArray();
            worker.setNextParkedWorker(this.g.b((int) (2097151 & j2)));
        } while (!i.compareAndSet(this, j2, ((2097152 + j2) & (-2097152)) | indexInArray));
        return true;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a = this.g.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < a; i8++) {
            Worker worker = (Worker) this.g.b(i8);
            if (worker != null) {
                int i9 = worker.localQueue.i();
                int i10 = b.a[worker.state.ordinal()];
                if (i10 == 1) {
                    i4++;
                } else if (i10 == 2) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i9);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i10 == 3) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i9);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i10 == 4) {
                    i6++;
                    if (i9 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i9);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (i10 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i7++;
                }
            }
        }
        long j2 = j.get(this);
        return this.d + '@' + p0.b(this) + "[Pool Size {core = " + this.a + ", max = " + this.b + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i6 + ", terminated = " + i7 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.e.c() + ", global blocking queue size = " + this.f.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final void u(Worker worker, int i2, int i3) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                i4 = i3 == 0 ? r(worker) : i3;
            }
            if (i4 >= 0 && i.compareAndSet(this, j2, j3 | i4)) {
                return;
            }
        }
    }

    public final void v(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
                b a = c.a();
                if (a == null) {
                }
            } finally {
                b a2 = c.a();
                if (a2 != null) {
                    a2.e();
                }
            }
        }
    }

    public final void w(long j2) {
        int i2;
        Task task;
        if (k.compareAndSet(this, 0, 1)) {
            Worker k2 = k();
            synchronized (this.g) {
                i2 = (int) (o().get(this) & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    Object b = this.g.b(i3);
                    Intrinsics.e(b);
                    Worker worker = (Worker) b;
                    if (worker != k2) {
                        while (worker.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(worker);
                            worker.join(j2);
                        }
                        worker.localQueue.j(this.f);
                    }
                    if (i3 == i2) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.f.b();
            this.e.b();
            while (true) {
                if (k2 != null) {
                    task = k2.findTask(true);
                    if (task != null) {
                        continue;
                        v(task);
                    }
                }
                task = (Task) this.e.e();
                if (task == null && (task = (Task) this.f.e()) == null) {
                    break;
                }
                v(task);
            }
            if (k2 != null) {
                k2.tryReleaseCpu(WorkerState.TERMINATED);
            }
            i.set(this, 0L);
            j.set(this, 0L);
        }
    }

    public final void y() {
        if (X() || W(this, 0L, 1, null)) {
            return;
        }
        X();
    }
}
