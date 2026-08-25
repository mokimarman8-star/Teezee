package androidx.compose.material.ripple;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final float f2492a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2493b;

    /* renamed from: c, reason: collision with root package name */
    private final float f2494c;

    /* renamed from: d, reason: collision with root package name */
    private final float f2495d;

    public c(float f5, float f6, float f7, float f8) {
        this.f2492a = f5;
        this.f2493b = f6;
        this.f2494c = f7;
        this.f2495d = f8;
    }

    public final float a() {
        return this.f2492a;
    }

    public final float b() {
        return this.f2493b;
    }

    public final float c() {
        return this.f2494c;
    }

    public final float d() {
        return this.f2495d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f2492a == cVar.f2492a && this.f2493b == cVar.f2493b && this.f2494c == cVar.f2494c && this.f2495d == cVar.f2495d;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f2492a) * 31) + Float.floatToIntBits(this.f2493b)) * 31) + Float.floatToIntBits(this.f2494c)) * 31) + Float.floatToIntBits(this.f2495d);
    }

    public String toString() {
        return "RippleAlpha(draggedAlpha=" + this.f2492a + ", focusedAlpha=" + this.f2493b + ", hoveredAlpha=" + this.f2494c + ", pressedAlpha=" + this.f2495d + ')';
    }
}
