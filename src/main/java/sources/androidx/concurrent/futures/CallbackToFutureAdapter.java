package androidx.concurrent.futures;

import com.google.common.util.concurrent.r;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class CallbackToFutureAdapter {

    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        Object f5579a;

        /* renamed from: b, reason: collision with root package name */
        c f5580b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.concurrent.futures.b f5581c = androidx.concurrent.futures.b.y();

        /* renamed from: d, reason: collision with root package name */
        private boolean f5582d;

        a() {
        }

        private void d() {
            this.f5579a = null;
            this.f5580b = null;
            this.f5581c = null;
        }

        void a() {
            this.f5579a = null;
            this.f5580b = null;
            this.f5581c.u(null);
        }

        public boolean b(Object obj) {
            this.f5582d = true;
            c cVar = this.f5580b;
            boolean z5 = cVar != null && cVar.c(obj);
            if (z5) {
                d();
            }
            return z5;
        }

        public boolean c() {
            this.f5582d = true;
            c cVar = this.f5580b;
            boolean z5 = cVar != null && cVar.b(true);
            if (z5) {
                d();
            }
            return z5;
        }

        public boolean e(Throwable th) {
            this.f5582d = true;
            c cVar = this.f5580b;
            boolean z5 = cVar != null && cVar.d(th);
            if (z5) {
                d();
            }
            return z5;
        }

        protected void finalize() {
            androidx.concurrent.futures.b bVar;
            c cVar = this.f5580b;
            if (cVar != null && !cVar.isDone()) {
                cVar.d(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f5579a));
            }
            if (this.f5582d || (bVar = this.f5581c) == null) {
                return;
            }
            bVar.u(null);
        }
    }

    public interface b {
        Object a(a aVar);
    }

    private static final class c implements r {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference f5583a;

        /* renamed from: b, reason: collision with root package name */
        private final AbstractResolvableFuture f5584b = new a();

        class a extends AbstractResolvableFuture {
            a() {
            }

            protected String r() {
                a aVar = (a) c.this.f5583a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f5579a + "]";
            }
        }

        c(a aVar) {
            this.f5583a = new WeakReference(aVar);
        }

        public void addListener(Runnable runnable, Executor executor) {
            this.f5584b.addListener(runnable, executor);
        }

        boolean b(boolean z5) {
            return this.f5584b.cancel(z5);
        }

        boolean c(Object obj) {
            return this.f5584b.u(obj);
        }

        public boolean cancel(boolean z5) {
            a aVar = (a) this.f5583a.get();
            boolean cancel = this.f5584b.cancel(z5);
            if (cancel && aVar != null) {
                aVar.a();
            }
            return cancel;
        }

        boolean d(Throwable th) {
            return this.f5584b.v(th);
        }

        public Object get() {
            return this.f5584b.get();
        }

        public Object get(long j5, TimeUnit timeUnit) {
            return this.f5584b.get(j5, timeUnit);
        }

        public boolean isCancelled() {
            return this.f5584b.isCancelled();
        }

        public boolean isDone() {
            return this.f5584b.isDone();
        }

        public String toString() {
            return this.f5584b.toString();
        }
    }

    public static r a(b bVar) {
        a aVar = new a();
        c cVar = new c(aVar);
        aVar.f5580b = cVar;
        aVar.f5579a = bVar.getClass();
        try {
            Object a5 = bVar.a(aVar);
            if (a5 != null) {
                aVar.f5579a = a5;
            }
        } catch (Exception e5) {
            cVar.d(e5);
        }
        return cVar;
    }
}
