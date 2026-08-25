package qg;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class i implements og.b, og.a {
    private og.b a;
    private Executor b;
    private og.a c;

    public i(og.b bVar, Executor executor, og.a aVar) {
        this.a = bVar;
        this.b = executor;
        this.c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(i iVar, String str) {
        og.b bVar = iVar.a;
        if (bVar != null) {
            bVar.onCompleted(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(i iVar, String str, Throwable th) {
        og.b bVar = iVar.a;
        if (bVar != null) {
            bVar.b(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(i iVar, Throwable th) {
        og.a aVar = iVar.c;
        if (aVar != null) {
            aVar.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(i iVar, String str) {
        og.b bVar = iVar.a;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(i iVar) {
        try {
            og.a aVar = iVar.c;
            if (aVar != null) {
                aVar.onSuccess();
            }
        } catch (Throwable th) {
            iVar.c(th);
        }
    }

    @Override // og.b
    public void a(final String str) {
        Executor executor;
        Intrinsics.h(str, "threadName");
        if (this.a == null || (executor = this.b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: qg.d
            @Override // java.lang.Runnable
            public final void run() {
                i.l(i.this, str);
            }
        });
    }

    @Override // og.b
    public void b(final String str, final Throwable th) {
        Executor executor;
        Intrinsics.h(str, "threadName");
        Intrinsics.h(th, "throwable");
        c(th);
        if (this.a == null || (executor = this.b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: qg.f
            @Override // java.lang.Runnable
            public final void run() {
                i.j(i.this, str, th);
            }
        });
    }

    @Override // og.a
    public void c(final Throwable th) {
        Executor executor;
        Intrinsics.h(th, "t");
        if (this.c == null || (executor = this.b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: qg.h
            @Override // java.lang.Runnable
            public final void run() {
                i.k(i.this, th);
            }
        });
    }

    @Override // og.b
    public void onCompleted(final String str) {
        Executor executor;
        Intrinsics.h(str, "threadName");
        if (this.a == null || (executor = this.b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: qg.g
            @Override // java.lang.Runnable
            public final void run() {
                i.i(i.this, str);
            }
        });
    }

    @Override // og.a
    public void onSuccess() {
        Executor executor;
        if (this.c == null || (executor = this.b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: qg.e
            @Override // java.lang.Runnable
            public final void run() {
                i.m(i.this);
            }
        });
    }
}
