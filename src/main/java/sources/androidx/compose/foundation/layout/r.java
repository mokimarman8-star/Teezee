package androidx.compose.foundation.layout;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final int f1873a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1874b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1875c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1876d;

    public r(int i5, int i6, int i7, int i8) {
        this.f1873a = i5;
        this.f1874b = i6;
        this.f1875c = i7;
        this.f1876d = i8;
    }

    public final int a() {
        return this.f1876d;
    }

    public final int b() {
        return this.f1873a;
    }

    public final int c() {
        return this.f1875c;
    }

    public final int d() {
        return this.f1874b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f1873a == rVar.f1873a && this.f1874b == rVar.f1874b && this.f1875c == rVar.f1875c && this.f1876d == rVar.f1876d;
    }

    public int hashCode() {
        return (((((this.f1873a * 31) + this.f1874b) * 31) + this.f1875c) * 31) + this.f1876d;
    }

    public String toString() {
        return "InsetsValues(left=" + this.f1873a + ", top=" + this.f1874b + ", right=" + this.f1875c + ", bottom=" + this.f1876d + ')';
    }
}
