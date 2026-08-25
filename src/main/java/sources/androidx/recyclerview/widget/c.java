package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f12925a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f12926b;

    /* renamed from: c, reason: collision with root package name */
    private final DiffUtil.e f12927c;

    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        private static final Object f12928d = new Object();

        /* renamed from: e, reason: collision with root package name */
        private static Executor f12929e;

        /* renamed from: a, reason: collision with root package name */
        private Executor f12930a;

        /* renamed from: b, reason: collision with root package name */
        private Executor f12931b;

        /* renamed from: c, reason: collision with root package name */
        private final DiffUtil.e f12932c;

        public a(DiffUtil.e eVar) {
            this.f12932c = eVar;
        }

        public c a() {
            if (this.f12931b == null) {
                synchronized (f12928d) {
                    try {
                        if (f12929e == null) {
                            f12929e = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.f12931b = f12929e;
            }
            return new c(this.f12930a, this.f12931b, this.f12932c);
        }
    }

    c(Executor executor, Executor executor2, DiffUtil.e eVar) {
        this.f12925a = executor;
        this.f12926b = executor2;
        this.f12927c = eVar;
    }

    public Executor a() {
        return this.f12926b;
    }

    public DiffUtil.e b() {
        return this.f12927c;
    }

    public Executor c() {
        return this.f12925a;
    }
}
