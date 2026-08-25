package fj;

import com.therouter.router.RouteItem;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements mf.b {
    private final mf.b a;
    private final RouteItem b;
    private final AtomicBoolean c;
    private final AtomicBoolean d;
    private final AtomicBoolean e;

    public a(mf.b bVar, RouteItem routeItem) {
        Intrinsics.h(bVar, "delegate");
        Intrinsics.h(routeItem, "postcard");
        this.a = bVar;
        this.b = routeItem;
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
    }

    public void a(RouteItem routeItem) {
        Intrinsics.h(routeItem, "postcard");
        if (this.c.get()) {
            return;
        }
        this.d.set(true);
    }

    public final boolean b() {
        if (this.c.get() || !this.d.get() || !this.e.compareAndSet(false, true)) {
            return false;
        }
        this.a.a(this.b);
        return true;
    }

    public final void c() {
        this.c.set(true);
    }
}
