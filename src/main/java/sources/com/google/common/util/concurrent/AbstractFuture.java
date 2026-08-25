package com.google.common.util.concurrent;

import com.google.common.base.m;
import com.google.common.base.p;
import ib.a;
import ib.b;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class AbstractFuture extends a implements r {
    private static final b ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    static final q log;
    private volatile d listeners;
    private volatile Object value;
    private volatile j waiters;

    private static final class Failure {
        static final Failure b = new Failure(new 1("Failure occurred while trying to finish a future."));
        final Throwable a;

        Failure(Throwable th) {
            this.a = (Throwable) m.o(th);
        }
    }

    private static final class SetFuture<V> implements Runnable {
        final r future;
        final AbstractFuture owner;

        SetFuture(AbstractFuture abstractFuture, r rVar) {
            this.owner = abstractFuture;
            this.future = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.b(this.owner, this, AbstractFuture.o(this.future))) {
                AbstractFuture.l(this.owner, AbstractFuture.GENERATE_CANCELLATION_CAUSES);
            }
        }
    }

    static {
        boolean z;
        b fVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = GENERATE_CANCELLATION_CAUSES;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        log = new q(AbstractFuture.class);
        Throwable th = null;
        try {
            fVar = new i((a) null);
            e = null;
        } catch (Error | Exception e) {
            e = e;
            try {
                fVar = new e(AtomicReferenceFieldUpdater.newUpdater(j.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(j.class, j.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, j.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            } catch (Error | Exception e3) {
                fVar = new f((a) null);
                th = e3;
            }
        }
        ATOMIC_HELPER = fVar;
        if (th != null) {
            q qVar = log;
            Logger a = qVar.a();
            Level level = Level.SEVERE;
            a.log(level, "UnsafeAtomicHelper is broken!", e);
            qVar.a().log(level, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    protected AbstractFuture() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(StringBuilder sb) {
        try {
            Object p = p(this);
            sb.append("SUCCESS, result=[");
            d(sb, p);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (Exception e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private void c(StringBuilder sb) {
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            sb.append(", setFuture=[");
            g(sb, ((SetFuture) obj).future);
            sb.append("]");
        } else {
            try {
                str = p.a(pendingToString());
            } catch (Exception | StackOverflowError e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            b(sb);
        }
    }

    private void d(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void g(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Exception e) {
            e = e;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        } catch (StackOverflowError e3) {
            e = e3;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    private static CancellationException h(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private d k(d dVar) {
        d dVar2 = dVar;
        d d = ATOMIC_HELPER.d(this, d.d);
        while (d != null) {
            d dVar3 = d.c;
            d.c = dVar2;
            dVar2 = d;
            d = dVar3;
        }
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(AbstractFuture abstractFuture, boolean z) {
        d dVar = null;
        while (true) {
            abstractFuture.q();
            if (z) {
                abstractFuture.interruptTask();
                z = GENERATE_CANCELLATION_CAUSES;
            }
            abstractFuture.afterDone();
            d k = abstractFuture.k(dVar);
            while (k != null) {
                dVar = k.c;
                Runnable runnable = k.a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable2;
                    abstractFuture = setFuture.owner;
                    if (abstractFuture.value == setFuture) {
                        if (ATOMIC_HELPER.b(abstractFuture, setFuture, o(setFuture.future))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = k.b;
                    Objects.requireNonNull(executor);
                    m(runnable2, executor);
                }
                k = dVar;
            }
            return;
        }
    }

    private static void m(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            log.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    private Object n(Object obj) {
        if (obj instanceof c) {
            throw h("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).a);
        }
        return obj == NULL ? u.b() : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object o(r rVar) {
        Throwable a;
        if (rVar instanceof g) {
            Object obj = ((AbstractFuture) rVar).value;
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.a) {
                    obj = cVar.b != null ? new c(GENERATE_CANCELLATION_CAUSES, cVar.b) : c.d;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        }
        if ((rVar instanceof a) && (a = b.a((a) rVar)) != null) {
            return new Failure(a);
        }
        boolean isCancelled = rVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            c cVar2 = c.d;
            Objects.requireNonNull(cVar2);
            return cVar2;
        }
        try {
            Object p = p(rVar);
            if (!isCancelled) {
                return p == null ? NULL : p;
            }
            return new c(GENERATE_CANCELLATION_CAUSES, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + rVar));
        } catch (Error e) {
            e = e;
            return new Failure(e);
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new c(GENERATE_CANCELLATION_CAUSES, e3);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + rVar, e3));
        } catch (ExecutionException e4) {
            if (!isCancelled) {
                return new Failure(e4.getCause());
            }
            return new c(GENERATE_CANCELLATION_CAUSES, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + rVar, e4));
        } catch (Exception e5) {
            e = e5;
            return new Failure(e);
        }
    }

    private static Object p(Future future) {
        Object obj;
        boolean z = GENERATE_CANCELLATION_CAUSES;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void q() {
        for (j e = ATOMIC_HELPER.e(this, j.c); e != null; e = e.b) {
            e.b();
        }
    }

    private void r(j jVar) {
        jVar.a = null;
        while (true) {
            j jVar2 = this.waiters;
            if (jVar2 == j.c) {
                return;
            }
            j jVar3 = null;
            while (jVar2 != null) {
                j jVar4 = jVar2.b;
                if (jVar2.a != null) {
                    jVar3 = jVar2;
                } else if (jVar3 != null) {
                    jVar3.b = jVar4;
                    if (jVar3.a == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.c(this, jVar2, jVar4)) {
                    break;
                }
                jVar2 = jVar4;
            }
            return;
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        d dVar;
        m.p(runnable, "Runnable was null.");
        m.p(executor, "Executor was null.");
        if (!isDone() && (dVar = this.listeners) != d.d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.c = dVar;
                if (ATOMIC_HELPER.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.listeners;
                }
            } while (dVar != d.d);
        }
        m(runnable, executor);
    }

    protected void afterDone() {
    }

    public boolean cancel(boolean z) {
        c cVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return GENERATE_CANCELLATION_CAUSES;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cVar = new c(z, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z ? c.c : c.d;
            Objects.requireNonNull(cVar);
        }
        AbstractFuture abstractFuture = this;
        boolean z2 = false;
        while (true) {
            if (ATOMIC_HELPER.b(abstractFuture, obj, cVar)) {
                l(abstractFuture, z);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                r rVar = ((SetFuture) obj).future;
                if (!(rVar instanceof g)) {
                    rVar.cancel(z);
                    return true;
                }
                abstractFuture = (AbstractFuture) rVar;
                obj = abstractFuture.value;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
    }

    public Object get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return n(obj2);
        }
        j jVar = this.waiters;
        if (jVar != j.c) {
            j jVar2 = new j();
            do {
                jVar2.a(jVar);
                if (ATOMIC_HELPER.c(this, jVar, jVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            r(jVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return n(obj);
                }
                jVar = this.waiters;
            } while (jVar != j.c);
        }
        Object obj3 = this.value;
        Objects.requireNonNull(obj3);
        return n(obj3);
    }

    public Object get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null ? true : GENERATE_CANCELLATION_CAUSES) && (!(obj instanceof SetFuture))) {
            return n(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            j jVar = this.waiters;
            if (jVar != j.c) {
                j jVar2 = new j();
                do {
                    jVar2.a(jVar);
                    if (ATOMIC_HELPER.c(this, jVar, jVar2)) {
                        do {
                            v.a(this, nanos);
                            if (Thread.interrupted()) {
                                r(jVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null ? true : GENERATE_CANCELLATION_CAUSES) && (!(obj2 instanceof SetFuture))) {
                                return n(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        r(jVar2);
                    } else {
                        jVar = this.waiters;
                    }
                } while (jVar != j.c);
            }
            Object obj3 = this.value;
            Objects.requireNonNull(obj3);
            return n(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.value;
            if ((obj4 != null ? true : GENERATE_CANCELLATION_CAUSES) && (!(obj4 instanceof SetFuture))) {
                return n(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String abstractFuture = toString();
        String obj5 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj5.toLowerCase(locale);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = (convert == 0 || nanos2 > 1000) ? true : GENERATE_CANCELLATION_CAUSES;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + abstractFuture);
    }

    protected void interruptTask() {
    }

    public boolean isCancelled() {
        return this.value instanceof c;
    }

    public boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.value != null ? true : GENERATE_CANCELLATION_CAUSES);
    }

    final void maybePropagateCancellationTo(Future<?> future) {
        if ((future != null ? true : GENERATE_CANCELLATION_CAUSES) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean set(Object obj) {
        if (obj == null) {
            obj = NULL;
        }
        if (!ATOMIC_HELPER.b(this, (Object) null, obj)) {
            return GENERATE_CANCELLATION_CAUSES;
        }
        l(this, GENERATE_CANCELLATION_CAUSES);
        return true;
    }

    protected boolean setException(Throwable th) {
        if (!ATOMIC_HELPER.b(this, (Object) null, new Failure((Throwable) m.o(th)))) {
            return GENERATE_CANCELLATION_CAUSES;
        }
        l(this, GENERATE_CANCELLATION_CAUSES);
        return true;
    }

    protected boolean setFuture(r rVar) {
        Failure failure;
        m.o(rVar);
        Object obj = this.value;
        if (obj == null) {
            if (rVar.isDone()) {
                if (!ATOMIC_HELPER.b(this, (Object) null, o(rVar))) {
                    return GENERATE_CANCELLATION_CAUSES;
                }
                l(this, GENERATE_CANCELLATION_CAUSES);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, rVar);
            if (ATOMIC_HELPER.b(this, (Object) null, setFuture)) {
                try {
                    rVar.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Error | Exception unused) {
                        failure = Failure.b;
                    }
                    ATOMIC_HELPER.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            rVar.cancel(((c) obj).a);
        }
        return GENERATE_CANCELLATION_CAUSES;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            c(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    protected final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof g)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof Failure) {
            return ((Failure) obj).a;
        }
        return null;
    }

    protected final boolean wasInterrupted() {
        Object obj = this.value;
        if ((obj instanceof c) && ((c) obj).a) {
            return true;
        }
        return GENERATE_CANCELLATION_CAUSES;
    }
}
