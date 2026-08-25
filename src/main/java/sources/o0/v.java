package o0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class v implements p0.a {

    /* renamed from: a, reason: collision with root package name */
    private final float f16671a;

    public v(float f5) {
        this.f16671a = f5;
    }

    @Override // p0.a
    public float a(float f5) {
        return f5 / this.f16671a;
    }

    @Override // p0.a
    public float b(float f5) {
        return f5 * this.f16671a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && Float.compare(this.f16671a, ((v) obj).f16671a) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f16671a);
    }

    public String toString() {
        return "LinearFontScaleConverter(fontScale=" + this.f16671a + ')';
    }
}
