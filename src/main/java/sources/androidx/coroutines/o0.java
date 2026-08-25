package androidx.coroutines;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f13233a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque f13234b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f13235c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f13236d;

    public o0(Executor executor) {
        Intrinsics.h(executor, "executor");
        this.f13233a = executor;
        this.f13234b = new ArrayDeque();
        this.f13236d = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Runnable runnable, o0 o0Var) {
        try {
            runnable.run();
        } finally {
            o0Var.c();
        }
    }

    public final void c() {
        synchronized (this.f13236d) {
            try {
                Object poll = this.f13234b.poll();
                Runnable runnable = (Runnable) poll;
                this.f13235c = runnable;
                if (poll != null) {
                    this.f13233a.execute(runnable);
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        Intrinsics.h(runnable, "command");
        synchronized (this.f13236d) {
            try {
                this.f13234b.offer(new Runnable() { // from class: androidx.room.n0
                    @Override // java.lang.Runnable
                    public final void run() {
                        o0.b(runnable, this);
                    }
                });
                if (this.f13235c == null) {
                    c();
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
