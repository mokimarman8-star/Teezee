package androidx.media3.common;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f8643a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8644b;

    public f(int i5, float f5) {
        this.f8643a = i5;
        this.f8644b = f5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f8643a == fVar.f8643a && Float.compare(fVar.f8644b, this.f8644b) == 0;
    }

    public int hashCode() {
        return ((527 + this.f8643a) * 31) + Float.floatToIntBits(this.f8644b);
    }
}
