package androidx.media3.exoplayer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class z3 {

    /* renamed from: c, reason: collision with root package name */
    public static final z3 f12073c = new z3(0, false);

    /* renamed from: a, reason: collision with root package name */
    public final int f12074a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12075b;

    public z3(int i5, boolean z5) {
        this.f12074a = i5;
        this.f12075b = z5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z3.class != obj.getClass()) {
            return false;
        }
        z3 z3Var = (z3) obj;
        return this.f12074a == z3Var.f12074a && this.f12075b == z3Var.f12075b;
    }

    public int hashCode() {
        return (this.f12074a << 1) + (this.f12075b ? 1 : 0);
    }
}
