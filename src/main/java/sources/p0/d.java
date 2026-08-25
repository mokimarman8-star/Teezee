package p0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f16866a = new d();

    private d() {
    }

    public final float a(float f5, float f6, float f7, float f8, float f9) {
        return b(f5, f6, Math.max(0.0f, Math.min(1.0f, c(f7, f8, f9))));
    }

    public final float b(float f5, float f6, float f7) {
        return f5 + ((f6 - f5) * f7);
    }

    public final float c(float f5, float f6, float f7) {
        if (f5 == f6) {
            return 0.0f;
        }
        return (f7 - f5) / (f6 - f5);
    }
}
