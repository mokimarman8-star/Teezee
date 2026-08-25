package a9;

import b9.u;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class d implements w8.b {
    private final iy.a a;
    private final iy.a b;
    private final iy.a c;
    private final iy.a d;
    private final iy.a e;

    public d(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4, iy.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    public static d a(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4, iy.a aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, v8.d dVar, u uVar, c9.d dVar2, d9.a aVar) {
        return new c(executor, dVar, uVar, dVar2, aVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c((Executor) this.a.get(), (v8.d) this.b.get(), (u) this.c.get(), (c9.d) this.d.get(), (d9.a) this.e.get());
    }
}
