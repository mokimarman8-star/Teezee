package j;

import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c extends e {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f15797c;

    /* renamed from: d, reason: collision with root package name */
    private static final Executor f15798d = new Executor() { // from class: j.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.i(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f15799e = new Executor() { // from class: j.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.j(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private e f15800a;

    /* renamed from: b, reason: collision with root package name */
    private final e f15801b;

    private c() {
        d dVar = new d();
        this.f15801b = dVar;
        this.f15800a = dVar;
    }

    public static Executor g() {
        return f15799e;
    }

    public static c h() {
        if (f15797c != null) {
            return f15797c;
        }
        synchronized (c.class) {
            try {
                if (f15797c == null) {
                    f15797c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f15797c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Runnable runnable) {
        h().d(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Runnable runnable) {
        h().a(runnable);
    }

    @Override // j.e
    public void a(Runnable runnable) {
        this.f15800a.a(runnable);
    }

    @Override // j.e
    public boolean c() {
        return this.f15800a.c();
    }

    @Override // j.e
    public void d(Runnable runnable) {
        this.f15800a.d(runnable);
    }
}
