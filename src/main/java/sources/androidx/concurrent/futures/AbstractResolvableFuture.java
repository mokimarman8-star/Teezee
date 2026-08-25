package androidx.concurrent.futures;

import com.google.common.util.concurrent.r;
import java.util.Locale;
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
public abstract class AbstractResolvableFuture implements r {
    static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger e = Logger.getLogger(AbstractResolvableFuture.class.getName());
    static final b f;
    private static final Object g;
    volatile Object a;
    volatile d b;
    volatile g c;

    static {
        e fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f();
        }
        f = fVar;
        if (th != null) {
            e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        g = new Object();
    }

    protected AbstractResolvableFuture() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(StringBuilder sb) {
        try {
            Object p = p(this);
            sb.append("SUCCESS, result=[");
            sb.append(w(p));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e4) {
            sb.append("FAILURE, cause=[");
            sb.append(e4.getCause());
            sb.append("]");
        }
    }

    private static CancellationException g(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static Object h(Object obj) {
        obj.getClass();
        return obj;
    }

    private d k(d dVar) {
        d dVar2;
        do {
            dVar2 = this.b;
        } while (!f.a(this, dVar2, d.d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.c;
            dVar4.c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    static void l(AbstractResolvableFuture abstractResolvableFuture) {
        d dVar = null;
        while (true) {
            abstractResolvableFuture.s();
            abstractResolvableFuture.d();
            d k = abstractResolvableFuture.k(dVar);
            while (k != null) {
                dVar = k.c;
                SetFuture setFuture = k.a;
                if (setFuture instanceof SetFuture) {
                    SetFuture setFuture2 = setFuture;
                    abstractResolvableFuture = setFuture2.owner;
                    if (abstractResolvableFuture.a == setFuture2) {
                        if (f.b(abstractResolvableFuture, setFuture2, o(setFuture2.future))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    m(setFuture, k.b);
                }
                k = dVar;
            }
            return;
        }
    }

    private static void m(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e3) {
            e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    private Object n(Object obj) {
        if (obj instanceof c) {
            throw g("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).a);
        }
        if (obj == g) {
            return null;
        }
        return obj;
    }

    static Object o(r rVar) {
        if (rVar instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) rVar).a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.a ? cVar.b != null ? new c(false, cVar.b) : c.d : obj;
        }
        boolean isCancelled = rVar.isCancelled();
        if ((!d) && isCancelled) {
            return c.d;
        }
        try {
            Object p = p(rVar);
            return p == null ? g : p;
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new c(false, e3);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + rVar, e3));
        } catch (ExecutionException e4) {
            return new Failure(e4.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    static Object p(Future future) {
        Object obj;
        boolean z = false;
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

    private void s() {
        g gVar;
        do {
            gVar = this.c;
        } while (!f.c(this, gVar, g.c));
        while (gVar != null) {
            gVar.b();
            gVar = gVar.b;
        }
    }

    private void t(g gVar) {
        gVar.a = null;
        while (true) {
            g gVar2 = this.c;
            if (gVar2 == g.c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.b;
                if (gVar2.a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.b = gVar4;
                    if (gVar3.a == null) {
                        break;
                    }
                } else if (!f.c(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    private String w(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        h(runnable);
        h(executor);
        d dVar = this.b;
        if (dVar != d.d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.c = dVar;
                if (f.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.b;
                }
            } while (dVar != d.d);
        }
        m(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        Object obj = this.a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        c cVar = d ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.d;
        AbstractResolvableFuture abstractResolvableFuture = this;
        boolean z2 = false;
        while (true) {
            if (f.b(abstractResolvableFuture, obj, cVar)) {
                if (z) {
                    abstractResolvableFuture.q();
                }
                l(abstractResolvableFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                r rVar = ((SetFuture) obj).future;
                if (!(rVar instanceof AbstractResolvableFuture)) {
                    rVar.cancel(z);
                    return true;
                }
                abstractResolvableFuture = (AbstractResolvableFuture) rVar;
                obj = abstractResolvableFuture.a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = abstractResolvableFuture.a;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
    }

    protected void d() {
    }

    public final Object get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.a;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return n(obj2);
        }
        g gVar = this.c;
        if (gVar != g.c) {
            g gVar2 = new g();
            do {
                gVar2.a(gVar);
                if (f.c(this, gVar, gVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            t(gVar2);
                            throw new InterruptedException();
                        }
                        obj = this.a;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return n(obj);
                }
                gVar = this.c;
            } while (gVar != g.c);
        }
        return n(this.a);
    }

    public final Object get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return n(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar = this.c;
            if (gVar != g.c) {
                g gVar2 = new g();
                do {
                    gVar2.a(gVar);
                    if (f.c(this, gVar, gVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                t(gVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return n(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        t(gVar2);
                    } else {
                        gVar = this.c;
                    }
                } while (gVar != g.c);
            }
            return n(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return n(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String abstractResolvableFuture = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
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
        throw new TimeoutException(str + " for " + abstractResolvableFuture);
    }

    public final boolean isCancelled() {
        return this.a instanceof c;
    }

    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.a != null);
    }

    protected void q() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String r() {
        Object obj = this.a;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + w(((SetFuture) obj).future) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                str = r();
            } catch (RuntimeException e3) {
                str = "Exception thrown from implementation: " + e3.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                b(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected boolean u(Object obj) {
        if (obj == null) {
            obj = g;
        }
        if (!f.b(this, (Object) null, obj)) {
            return false;
        }
        l(this);
        return true;
    }

    protected boolean v(Throwable th) {
        if (!f.b(this, (Object) null, new Failure((Throwable) h(th)))) {
            return false;
        }
        l(this);
        return true;
    }

    protected final boolean x() {
        Object obj = this.a;
        return (obj instanceof c) && ((c) obj).a;
    }
}
