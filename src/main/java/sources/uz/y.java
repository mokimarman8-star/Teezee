package uz;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class y {
    y() {
    }

    public static byte c(y yVar, byte b, byte b2) {
        int i = (b & 255) >> 3;
        int i2 = (b & 7) << 2;
        return (byte) ((yVar.f()[(((yVar.e() * b2) + ((yVar.a()[i] >> i2) & 15)) & 255) >> 3] >> ((((b2 * yVar.e()) + ((yVar.a()[i] >> i2) & 15)) & 7) << 2)) & 15);
    }

    public abstract int[] a();

    public abstract String b();

    public abstract boolean d();

    public abstract int e();

    public abstract int[] f();
}
