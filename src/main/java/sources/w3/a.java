package w3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f18142a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f18143b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f18144c;

    public a(Function0 function0) {
        Intrinsics.h(function0, "closeAction");
        this.f18142a = function0;
        this.f18143b = new AtomicInteger(0);
        this.f18144c = new AtomicBoolean(false);
    }

    private final boolean b() {
        return this.f18144c.get();
    }

    public final boolean a() {
        synchronized (this) {
            if (b()) {
                return false;
            }
            this.f18143b.incrementAndGet();
            return true;
        }
    }

    public final void c() {
        synchronized (this) {
            this.f18143b.decrementAndGet();
            if (this.f18143b.get() < 0) {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
            Unit unit = Unit.a;
        }
    }
}
