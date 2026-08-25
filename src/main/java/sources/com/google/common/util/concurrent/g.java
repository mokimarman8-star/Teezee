package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class g {
    private static final q c = new q(g.class);
    private a a;
    private boolean b;

    private static final class a {
        final Runnable a;
        final Executor b;
        a c;

        a(Runnable runnable, Executor executor, a aVar) {
            this.a = runnable;
            this.b = executor;
            this.c = aVar;
        }
    }

    private static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            c.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        com.google.common.base.m.p(runnable, "Runnable was null.");
        com.google.common.base.m.p(executor, "Executor was null.");
        synchronized (this) {
            try {
                if (this.b) {
                    c(runnable, executor);
                } else {
                    this.a = new a(runnable, executor, this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                a aVar = this.a;
                a aVar2 = null;
                this.a = null;
                while (aVar != null) {
                    a aVar3 = aVar.c;
                    aVar.c = aVar2;
                    aVar2 = aVar;
                    aVar = aVar3;
                }
                while (aVar2 != null) {
                    c(aVar2.a, aVar2.b);
                    aVar2 = aVar2.c;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
