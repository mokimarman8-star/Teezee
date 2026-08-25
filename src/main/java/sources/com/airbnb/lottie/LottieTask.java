package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import x4.f;
import x4.g;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class LottieTask {
    public static Executor e = Executors.newCachedThreadPool(new g());
    private final Set a;
    private final Set b;
    private final Handler c;
    private volatile q0 d;

    private static class LottieFutureTask<T> extends FutureTask<q0> {
        private LottieTask lottieTask;

        LottieFutureTask(LottieTask lottieTask, Callable<q0> callable) {
            super(callable);
            this.lottieTask = lottieTask;
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                if (isCancelled()) {
                    return;
                }
                try {
                    this.lottieTask.l(get());
                } catch (InterruptedException | ExecutionException e) {
                    this.lottieTask.l(new q0(e));
                }
            } finally {
                this.lottieTask = null;
            }
        }
    }

    public LottieTask(Object obj) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        l(new q0(obj));
    }

    public LottieTask(Callable callable) {
        this(callable, false);
    }

    LottieTask(Callable callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (!z) {
            e.execute(new LottieFutureTask(this, callable));
            return;
        }
        try {
            l((q0) callable.call());
        } catch (Throwable th) {
            l(new q0(th));
        }
    }

    private synchronized void f(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            f.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((m0) it.next()).onResult(th);
        }
    }

    private void g() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h();
        } else {
            this.c.post(new r0(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        q0 q0Var = this.d;
        if (q0Var == null) {
            return;
        }
        if (q0Var.b() != null) {
            i(q0Var.b());
        } else {
            f(q0Var.a());
        }
    }

    private synchronized void i(Object obj) {
        Iterator it = new ArrayList(this.a).iterator();
        while (it.hasNext()) {
            ((m0) it.next()).onResult(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(q0 q0Var) {
        if (this.d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.d = q0Var;
        g();
    }

    public synchronized LottieTask c(m0 m0Var) {
        try {
            q0 q0Var = this.d;
            if (q0Var != null && q0Var.a() != null) {
                m0Var.onResult(q0Var.a());
            }
            this.b.add(m0Var);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized LottieTask d(m0 m0Var) {
        try {
            q0 q0Var = this.d;
            if (q0Var != null && q0Var.b() != null) {
                m0Var.onResult(q0Var.b());
            }
            this.a.add(m0Var);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public q0 e() {
        return this.d;
    }

    public synchronized LottieTask j(m0 m0Var) {
        this.b.remove(m0Var);
        return this;
    }

    public synchronized LottieTask k(m0 m0Var) {
        this.a.remove(m0Var);
        return this;
    }
}
