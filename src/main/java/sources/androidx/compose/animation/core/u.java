package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class u implements z {

    /* renamed from: a, reason: collision with root package name */
    private final float f1494a;

    /* renamed from: b, reason: collision with root package name */
    private final float f1495b;

    /* renamed from: c, reason: collision with root package name */
    private final float f1496c;

    /* renamed from: d, reason: collision with root package name */
    private final float f1497d;

    /* renamed from: e, reason: collision with root package name */
    private final float f1498e;

    /* renamed from: f, reason: collision with root package name */
    private final float f1499f;

    public u(float f5, float f6, float f7, float f8) {
        this.f1494a = f5;
        this.f1495b = f6;
        this.f1496c = f7;
        this.f1497d = f8;
        if (!((Float.isNaN(f5) || Float.isNaN(f6) || Float.isNaN(f7) || Float.isNaN(f8)) ? false : true)) {
            k0.a("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f5 + ", " + f6 + ", " + f7 + ", " + f8 + '.');
        }
        long b5 = androidx.compose.ui.graphics.b1.b(0.0f, f6, f8, 1.0f, new float[5], 0);
        this.f1498e = Float.intBitsToFloat((int) (b5 >> 32));
        this.f1499f = Float.intBitsToFloat((int) (b5 & 4294967295L));
    }

    private final void b(float f5) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.f1494a + ", " + this.f1495b + ", " + this.f1496c + ", " + this.f1497d + ") has no solution at " + f5);
    }

    @Override // androidx.compose.animation.core.z
    public float a(float f5) {
        if (f5 <= 0.0f || f5 >= 1.0f) {
            return f5;
        }
        float e5 = androidx.compose.ui.graphics.b1.e(0.0f - f5, this.f1494a - f5, this.f1496c - f5, 1.0f - f5);
        if (Float.isNaN(e5)) {
            b(f5);
        }
        float c5 = androidx.compose.ui.graphics.b1.c(this.f1495b, this.f1497d, e5);
        float f6 = this.f1498e;
        float f7 = this.f1499f;
        if (c5 < f6) {
            c5 = f6;
        }
        return c5 > f7 ? f7 : c5;
    }

    public boolean equals(Object obj) {
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f1494a == uVar.f1494a && this.f1495b == uVar.f1495b && this.f1496c == uVar.f1496c && this.f1497d == uVar.f1497d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f1494a) * 31) + Float.floatToIntBits(this.f1495b)) * 31) + Float.floatToIntBits(this.f1496c)) * 31) + Float.floatToIntBits(this.f1497d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f1494a + ", b=" + this.f1495b + ", c=" + this.f1496c + ", d=" + this.f1497d + ')';
    }
}
