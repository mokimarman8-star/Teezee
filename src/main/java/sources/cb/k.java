package cb;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class k extends g {
    private final g a;
    private final float b;

    public k(g gVar, float f) {
        this.a = gVar;
        this.b = f;
    }

    @Override // cb.g
    boolean a() {
        return this.a.a();
    }

    @Override // cb.g
    public void b(float f, float f2, float f3, p pVar) {
        this.a.b(f, f2 - this.b, f3, pVar);
    }
}
