package androidx.view;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    private boolean f8312b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8313c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8311a = true;

    /* renamed from: d, reason: collision with root package name */
    private final Queue f8314d = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(i iVar, Runnable runnable) {
        Intrinsics.h(iVar, "this$0");
        Intrinsics.h(runnable, "$runnable");
        iVar.f(runnable);
    }

    private final void f(Runnable runnable) {
        if (!this.f8314d.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables");
        }
        e();
    }

    public final boolean b() {
        return this.f8312b || !this.f8311a;
    }

    public final void c(CoroutineContext coroutineContext, final Runnable runnable) {
        Intrinsics.h(coroutineContext, "context");
        Intrinsics.h(runnable, "runnable");
        a2 p5 = y0.c().p();
        if (p5.isDispatchNeeded(coroutineContext) || b()) {
            p5.dispatch(coroutineContext, new Runnable() { // from class: androidx.lifecycle.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.d(i.this, runnable);
                }
            });
        } else {
            f(runnable);
        }
    }

    public final void e() {
        if (this.f8313c) {
            return;
        }
        try {
            this.f8313c = true;
            while (!this.f8314d.isEmpty() && b()) {
                Runnable runnable = (Runnable) this.f8314d.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        } finally {
            this.f8313c = false;
        }
    }

    public final void g() {
        this.f8312b = true;
        e();
    }

    public final void h() {
        this.f8311a = true;
    }

    public final void i() {
        if (this.f8311a) {
            if (this.f8312b) {
                throw new IllegalStateException("Cannot resume a finished dispatcher");
            }
            this.f8311a = false;
            e();
        }
    }
}
