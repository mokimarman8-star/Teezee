package androidx.coroutines.impl.utils.futures;

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
public abstract class AbstractFuture implements r {
    static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger e = Logger.getLogger(AbstractFuture.class.getName());
    static final b f;
    private static final Object g;
    volatile Object a;
    volatile d b;
    volatile g c;

    static {
        e fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
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

    protected AbstractFuture() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(StringBuilder sb) {
        try {
            Object o = o(this);
            sb.append("SUCCESS, result=[");
            sb.append(w(o));
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

    private static CancellationException d(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static Object g(Object obj) {
        obj.getClass();
        return obj;
    }

    private d h(d dVar) {
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

    static void k(AbstractFuture abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.r();
            abstractFuture.c();
            d h = abstractFuture.h(dVar);
            while (h != null) {
                dVar = h.c;
                SetFuture setFuture = h.a;
                if (setFuture instanceof SetFuture) {
                    SetFuture setFuture2 = setFuture;
                    abstractFuture = setFuture2.owner;
                    if (abstractFuture.a == setFuture2) {
                        if (f.b(abstractFuture, setFuture2, n(setFuture2.future))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    l(setFuture, h.b);
                }
                h = dVar;
            }
            return;
        }
    }

    private static void l(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e3) {
            e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    private Object m(Object obj) {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).a);
        }
        if (obj == g) {
            return null;
        }
        return obj;
    }

    static Object n(r rVar) {
        if (rVar instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) rVar).a;
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
            Object o = o(rVar);
            return o == null ? g : o;
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

    private static Object o(Future future) {
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

    private void r() {
        g gVar;
        do {
            gVar = this.c;
        } while (!f.c(this, gVar, g.c));
        while (gVar != null) {
            gVar.b();
            gVar = gVar.b;
        }
    }

    private void s(g gVar) {
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
        g(runnable);
        g(executor);
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
        l(runnable, executor);
    }

    protected void c() {
    }

    public final boolean cancel(boolean z) {
        Object obj = this.a;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        c cVar = d ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.d;
        AbstractFuture abstractFuture = this;
        boolean z2 = false;
        while (true) {
            if (f.b(abstractFuture, obj, cVar)) {
                if (z) {
                    abstractFuture.p();
                }
                k(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                r rVar = ((SetFuture) obj).future;
                if (!(rVar instanceof AbstractFuture)) {
                    rVar.cancel(z);
                    return true;
                }
                abstractFuture = (AbstractFuture) rVar;
                obj = abstractFuture.a;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = abstractFuture.a;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
    }

    public final Object get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.a;
        if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
            return m(obj2);
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
                            s(gVar2);
                            throw new InterruptedException();
                        }
                        obj = this.a;
                    } while (!((obj != null) & (!(obj instanceof SetFuture))));
                    return m(obj);
                }
                gVar = this.c;
            } while (gVar != g.c);
        }
        return m(this.a);
    }

    public final Object get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return m(obj);
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
                                s(gVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return m(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        s(gVar2);
                    } else {
                        gVar = this.c;
                    }
                } while (gVar != g.c);
            }
            return m(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                return m(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String abstractFuture = toString();
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
        throw new TimeoutException(str + " for " + abstractFuture);
    }

    public final boolean isCancelled() {
        return this.a instanceof c;
    }

    public final boolean isDone() {
        return (!(r0 instanceof SetFuture)) & (this.a != null);
    }

    protected void p() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String q() {
        Object obj = this.a;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + w(((SetFuture) obj).future) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean t(Object obj) {
        if (obj == null) {
            obj = g;
        }
        if (!f.b(this, (Object) null, obj)) {
            return false;
        }
        k(this);
        return true;
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
                str = q();
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

    protected boolean u(Throwable th) {
        if (!f.b(this, (Object) null, new Failure((Throwable) g(th)))) {
            return false;
        }
        k(this);
        return true;
    }

    protected boolean v(r rVar) {
        Failure failure;
        g(rVar);
        Object obj = this.a;
        if (obj == null) {
            if (rVar.isDone()) {
                if (!f.b(this, (Object) null, n(rVar))) {
                    return false;
                }
                k(this);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, rVar);
            if (f.b(this, (Object) null, setFuture)) {
                try {
                    rVar.addListener(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.b;
                    }
                    f.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.a;
        }
        if (obj instanceof c) {
            rVar.cancel(((c) obj).a);
        }
        return false;
    }
}
