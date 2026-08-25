package e0;

import androidx.collection.s;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private long f14958a;

    /* renamed from: b, reason: collision with root package name */
    private float f14959b;

    public a(long j5, float f5) {
        this.f14958a = j5;
        this.f14959b = f5;
    }

    public final float a() {
        return this.f14959b;
    }

    public final long b() {
        return this.f14958a;
    }

    public final void c(float f5) {
        this.f14959b = f5;
    }

    public final void d(long j5) {
        this.f14958a = j5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14958a == aVar.f14958a && Float.compare(this.f14959b, aVar.f14959b) == 0;
    }

    public int hashCode() {
        return (s.a(this.f14958a) * 31) + Float.floatToIntBits(this.f14959b);
    }

    public String toString() {
        return "DataPointAtTime(time=" + this.f14958a + ", dataPoint=" + this.f14959b + ')';
    }
}
