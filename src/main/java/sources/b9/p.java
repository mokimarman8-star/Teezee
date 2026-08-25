package b9;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class p implements w8.b {
    private final iy.a a;
    private final iy.a b;
    private final iy.a c;
    private final iy.a d;
    private final iy.a e;
    private final iy.a f;
    private final iy.a g;
    private final iy.a h;
    private final iy.a i;

    public p(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4, iy.a aVar5, iy.a aVar6, iy.a aVar7, iy.a aVar8, iy.a aVar9) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
    }

    public static p a(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4, iy.a aVar5, iy.a aVar6, iy.a aVar7, iy.a aVar8, iy.a aVar9) {
        return new p(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static o c(Context context, v8.d dVar, c9.d dVar2, u uVar, Executor executor, d9.a aVar, e9.a aVar2, e9.a aVar3, c9.c cVar) {
        return new o(context, dVar, dVar2, uVar, executor, aVar, aVar2, aVar3, cVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o get() {
        return c((Context) this.a.get(), (v8.d) this.b.get(), (c9.d) this.c.get(), (u) this.d.get(), (Executor) this.e.get(), (d9.a) this.f.get(), (e9.a) this.g.get(), (e9.a) this.h.get(), (c9.c) this.i.get());
    }
}
