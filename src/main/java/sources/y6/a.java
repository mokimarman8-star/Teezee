package y6;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    private int a = 10;
    private AtomicInteger b = new AtomicInteger(0);

    public final boolean a() {
        return this.b.get() >= this.a;
    }

    public final void b() {
        this.b.set(0);
    }

    public final void c(Function0 function0) {
        Intrinsics.h(function0, "downCallBack");
        if (this.b.incrementAndGet() >= this.a) {
            function0.invoke();
        }
    }
}
