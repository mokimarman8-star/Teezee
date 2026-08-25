package g4;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f15445a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f15446b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f15447c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f15448d;

    public b(boolean z5, boolean z6, boolean z7, boolean z8) {
        this.f15445a = z5;
        this.f15446b = z6;
        this.f15447c = z7;
        this.f15448d = z8;
    }

    public final boolean a() {
        return this.f15445a;
    }

    public final boolean b() {
        return this.f15447c;
    }

    public final boolean c() {
        return this.f15448d;
    }

    public final boolean d() {
        return this.f15446b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f15445a == bVar.f15445a && this.f15446b == bVar.f15446b && this.f15447c == bVar.f15447c && this.f15448d == bVar.f15448d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        boolean z5 = this.f15445a;
        ?? r02 = z5;
        if (z5) {
            r02 = 1;
        }
        int i5 = r02 * 31;
        ?? r22 = this.f15446b;
        int i6 = r22;
        if (r22 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r23 = this.f15447c;
        int i8 = r23;
        if (r23 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z6 = this.f15448d;
        return i9 + (z6 ? 1 : z6 ? 1 : 0);
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.f15445a + ", isValidated=" + this.f15446b + ", isMetered=" + this.f15447c + ", isNotRoaming=" + this.f15448d + ')';
    }
}
