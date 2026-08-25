package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import z3.h;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class l0 {
    private final RoomDatabase a;
    private final AtomicBoolean b;
    private final Lazy c;

    public l0(RoomDatabase roomDatabase) {
        Intrinsics.h(roomDatabase, "database");
        this.a = roomDatabase;
        this.b = new AtomicBoolean(false);
        this.c = LazyKt.b(new Function0() { // from class: androidx.room.k0
            public final Object invoke() {
                h i;
                i = l0.i(l0.this);
                return i;
            }
        });
    }

    private final h d() {
        return this.a.m(e());
    }

    private final h f() {
        return (h) this.c.getValue();
    }

    private final h g(boolean z) {
        return z ? f() : d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h i(l0 l0Var) {
        return l0Var.d();
    }

    public h b() {
        c();
        return g(this.b.compareAndSet(false, true));
    }

    protected void c() {
        this.a.i();
    }

    protected abstract String e();

    public void h(h hVar) {
        Intrinsics.h(hVar, "statement");
        if (hVar == f()) {
            this.b.set(false);
        }
    }
}
