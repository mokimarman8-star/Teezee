package com.bytedance.adsdk.sP;

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

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Fmk<T> {
    public static Executor Sj = Executors.newCachedThreadPool();
    private final Handler EjP;
    private volatile aa<T> HiB;
    private final Set<Ym<Throwable>> TKC;
    private final Set<Ym<T>> sP;

    private class Sj extends FutureTask<aa<T>> {
        Sj(Callable<aa<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                Fmk.this.Sj((aa) get());
            } catch (InterruptedException | ExecutionException e) {
                Fmk.this.Sj(new aa(e));
            }
        }
    }

    public Fmk(Callable<aa<T>> callable) {
        this(callable, false);
    }

    Fmk(Callable<aa<T>> callable, boolean z) {
        this.sP = new LinkedHashSet(1);
        this.TKC = new LinkedHashSet(1);
        this.EjP = new Handler(Looper.getMainLooper());
        this.HiB = null;
        if (!z) {
            Sj.execute(new Sj(callable));
            return;
        }
        try {
            Sj((aa) callable.call());
        } catch (Throwable th) {
            Sj((aa) new aa<>(th));
        }
    }

    private void Sj() {
        this.EjP.post(new Runnable() { // from class: com.bytedance.adsdk.sP.Fmk.1
            @Override // java.lang.Runnable
            public void run() {
                aa aaVar = Fmk.this.HiB;
                if (aaVar == null) {
                    return;
                }
                if (aaVar.Sj() != null) {
                    Fmk.this.Sj((Fmk) aaVar.Sj());
                } else {
                    Fmk.this.Sj(aaVar.sP());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(aa<T> aaVar) {
        if (this.HiB != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.HiB = aaVar;
        Sj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sj(T t) {
        Iterator it = new ArrayList(this.sP).iterator();
        while (it.hasNext()) {
            ((Ym) it.next()).Sj(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sj(Throwable th) {
        ArrayList arrayList = new ArrayList(this.TKC);
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Ym) it.next()).Sj(th);
        }
    }

    public synchronized Fmk<T> EjP(Ym<Throwable> ym) {
        this.TKC.remove(ym);
        return this;
    }

    public synchronized Fmk<T> Sj(Ym<T> ym) {
        try {
            aa<T> aaVar = this.HiB;
            if (aaVar != null && aaVar.Sj() != null) {
                ym.Sj(aaVar.Sj());
            }
            this.sP.add(ym);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized Fmk<T> TKC(Ym<Throwable> ym) {
        try {
            aa<T> aaVar = this.HiB;
            if (aaVar != null && aaVar.sP() != null) {
                ym.Sj(aaVar.sP());
            }
            this.TKC.add(ym);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized Fmk<T> sP(Ym<T> ym) {
        this.sP.remove(ym);
        return this;
    }
}
