package b9;

import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class t implements w8.b {
    private final iy.a a;
    private final iy.a b;
    private final iy.a c;
    private final iy.a d;

    public t(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    public static t a(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4) {
        return new t(aVar, aVar2, aVar3, aVar4);
    }

    public static s c(Executor executor, c9.d dVar, u uVar, d9.a aVar) {
        return new s(executor, dVar, uVar, aVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s get() {
        return c((Executor) this.a.get(), (c9.d) this.b.get(), (u) this.c.get(), (d9.a) this.d.get());
    }
}
