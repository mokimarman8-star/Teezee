package cb;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f extends e {
    float a = -1.0f;

    @Override // cb.e
    public void b(p pVar, float f, float f2, float f3) {
        pVar.o(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d = f3;
        double d2 = f2;
        pVar.m((float) (Math.sin(Math.toRadians(f)) * d * d2), (float) (Math.sin(Math.toRadians(90.0f - f)) * d * d2));
    }
}
