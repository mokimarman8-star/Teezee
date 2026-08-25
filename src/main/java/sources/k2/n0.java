package k2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class n0 {

    /* renamed from: c, reason: collision with root package name */
    public static final n0 f16254c = new n0(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f16255a;

    /* renamed from: b, reason: collision with root package name */
    public final long f16256b;

    public n0(long j5, long j6) {
        this.f16255a = j5;
        this.f16256b = j6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n0.class != obj.getClass()) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.f16255a == n0Var.f16255a && this.f16256b == n0Var.f16256b;
    }

    public int hashCode() {
        return (((int) this.f16255a) * 31) + ((int) this.f16256b);
    }

    public String toString() {
        return "[timeUs=" + this.f16255a + ", position=" + this.f16256b + "]";
    }
}
