package o6;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class d {
    private final Executor a;
    private final Executor b;
    private final DiffUtil.e c;

    public static final class a {
        public static final C0151a d = new C0151a(null);
        private static final Object e = new Object();
        private static Executor f;
        private final DiffUtil.e a;
        private Executor b;
        private Executor c;

        /* renamed from: o6.d$a$a, reason: collision with other inner class name */
        public static final class C0151a {
            private C0151a() {
            }

            public /* synthetic */ C0151a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(DiffUtil.e eVar) {
            Intrinsics.h(eVar, "mDiffCallback");
            this.a = eVar;
        }

        public final d a() {
            if (this.c == null) {
                synchronized (e) {
                    try {
                        if (f == null) {
                            f = Executors.newFixedThreadPool(2);
                        }
                        Unit unit = Unit.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.c = f;
            }
            Executor executor = this.b;
            Executor executor2 = this.c;
            Intrinsics.e(executor2);
            return new d(executor, executor2, this.a);
        }
    }

    public d(Executor executor, Executor executor2, DiffUtil.e eVar) {
        Intrinsics.h(executor2, "backgroundThreadExecutor");
        Intrinsics.h(eVar, "diffCallback");
        this.a = executor;
        this.b = executor2;
        this.c = eVar;
    }

    public final Executor a() {
        return this.b;
    }

    public final DiffUtil.e b() {
        return this.c;
    }

    public final Executor c() {
        return this.a;
    }
}
