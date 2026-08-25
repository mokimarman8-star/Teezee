package c9;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class n0 implements w8.b {
    private final iy.a a;
    private final iy.a b;
    private final iy.a c;
    private final iy.a d;
    private final iy.a e;

    public n0(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4, iy.a aVar5) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    public static n0 a(iy.a aVar, iy.a aVar2, iy.a aVar3, iy.a aVar4, iy.a aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(e9.a aVar, e9.a aVar2, Object obj, Object obj2, iy.a aVar3) {
        return new m0(aVar, aVar2, (e) obj, (v0) obj2, aVar3);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((e9.a) this.a.get(), (e9.a) this.b.get(), this.c.get(), this.d.get(), this.e);
    }
}
