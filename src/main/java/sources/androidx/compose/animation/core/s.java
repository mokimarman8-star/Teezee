package androidx.compose.animation.core;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private double f1490a;

    /* renamed from: b, reason: collision with root package name */
    private double f1491b;

    public s(double d5, double d6) {
        this.f1490a = d5;
        this.f1491b = d6;
    }

    public final double e() {
        return this.f1491b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Double.compare(this.f1490a, sVar.f1490a) == 0 && Double.compare(this.f1491b, sVar.f1491b) == 0;
    }

    public final double f() {
        return this.f1490a;
    }

    public int hashCode() {
        return (r.a(this.f1490a) * 31) + r.a(this.f1491b);
    }

    public String toString() {
        return "ComplexDouble(_real=" + this.f1490a + ", _imaginary=" + this.f1491b + ')';
    }
}
