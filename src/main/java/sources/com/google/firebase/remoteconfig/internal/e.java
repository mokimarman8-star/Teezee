package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e {
    private static final Map d = new HashMap();
    private static final Executor e = new v3.m();
    private final Executor a;
    private final r b;
    private Task c = null;

    private static class b implements OnSuccessListener, OnFailureListener, OnCanceledListener {
        private final CountDownLatch a;

        private b() {
            this.a = new CountDownLatch(1);
        }

        public boolean a(long j, TimeUnit timeUnit) {
            return this.a.await(j, timeUnit);
        }

        public void onCanceled() {
            this.a.countDown();
        }

        public void onFailure(Exception exc) {
            this.a.countDown();
        }

        public void onSuccess(Object obj) {
            this.a.countDown();
        }
    }

    private e(Executor executor, r rVar) {
        this.a = executor;
        this.b = rVar;
    }

    private static Object c(Task task, long j, TimeUnit timeUnit) {
        b bVar = new b();
        Executor executor = e;
        task.addOnSuccessListener(executor, bVar);
        task.addOnFailureListener(executor, bVar);
        task.addOnCanceledListener(executor, bVar);
        if (!bVar.a(j, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    public static synchronized e h(Executor executor, r rVar) {
        e eVar;
        synchronized (e.class) {
            try {
                String b2 = rVar.b();
                Map map = d;
                if (!map.containsKey(b2)) {
                    map.put(b2, new e(executor, rVar));
                }
                eVar = (e) map.get(b2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void i(f fVar) {
        return this.b.e(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task j(boolean z, f fVar, Void r3) {
        if (z) {
            m(fVar);
        }
        return Tasks.forResult(fVar);
    }

    private synchronized void m(f fVar) {
        this.c = Tasks.forResult(fVar);
    }

    public void d() {
        synchronized (this) {
            this.c = Tasks.forResult((Object) null);
        }
        this.b.a();
    }

    public synchronized Task e() {
        try {
            Task task = this.c;
            if (task != null) {
                if (task.isComplete() && !this.c.isSuccessful()) {
                }
            }
            Executor executor = this.a;
            final r rVar = this.b;
            Objects.requireNonNull(rVar);
            this.c = Tasks.call(executor, new Callable() { // from class: com.google.firebase.remoteconfig.internal.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return r.this.d();
                }
            });
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    public f f() {
        return g(5L);
    }

    f g(long j) {
        synchronized (this) {
            try {
                Task task = this.c;
                if (task == null || !task.isSuccessful()) {
                    try {
                        return (f) c(e(), j, TimeUnit.SECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                        return null;
                    }
                }
                return (f) this.c.getResult();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Task k(f fVar) {
        return l(fVar, true);
    }

    public Task l(final f fVar, final boolean z) {
        return Tasks.call(this.a, new Callable() { // from class: com.google.firebase.remoteconfig.internal.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void i;
                i = e.this.i(fVar);
                return i;
            }
        }).onSuccessTask(this.a, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.d
            public final Task then(Object obj) {
                Task j;
                j = e.this.j(z, fVar, (Void) obj);
                return j;
            }
        });
    }
}
