package androidx.compose.ui.graphics.colorspace;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final float f3422a;

    /* renamed from: b, reason: collision with root package name */
    private final float f3423b;

    public y(float f5, float f6) {
        this.f3422a = f5;
        this.f3423b = f6;
    }

    public y(float f5, float f6, float f7) {
        this(f5, f6, f7, f5 + f6 + f7);
    }

    private y(float f5, float f6, float f7, float f8) {
        this(f5 / f8, f6 / f8);
    }

    public final float a() {
        return this.f3422a;
    }

    public final float b() {
        return this.f3423b;
    }

    public final float[] c() {
        float f5 = this.f3422a;
        float f6 = this.f3423b;
        return new float[]{f5 / f6, 1.0f, ((1.0f - f5) - f6) / f6};
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Float.compare(this.f3422a, yVar.f3422a) == 0 && Float.compare(this.f3423b, yVar.f3423b) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f3422a) * 31) + Float.floatToIntBits(this.f3423b);
    }

    public String toString() {
        return "WhitePoint(x=" + this.f3422a + ", y=" + this.f3423b + ')';
    }
}
