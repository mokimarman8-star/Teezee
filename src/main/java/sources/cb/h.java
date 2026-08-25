package cb;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class h extends g {
    private final float a;

    public h(float f) {
        this.a = f - 0.001f;
    }

    @Override // cb.g
    boolean a() {
        return true;
    }

    @Override // cb.g
    public void b(float f, float f2, float f3, p pVar) {
        float sqrt = (float) ((this.a * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.a, 2.0d) - Math.pow(sqrt, 2.0d));
        pVar.n(f2 - sqrt, ((float) (-((this.a * Math.sqrt(2.0d)) - this.a))) + sqrt2);
        pVar.m(f2, (float) (-((this.a * Math.sqrt(2.0d)) - this.a)));
        pVar.m(f2 + sqrt, ((float) (-((this.a * Math.sqrt(2.0d)) - this.a))) + sqrt2);
    }
}
