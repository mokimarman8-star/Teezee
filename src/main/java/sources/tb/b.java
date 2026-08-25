package tb;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b extends i {
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final long f;

    b(String str, String str2, String str3, String str4, long j) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.e = str4;
        this.f = j;
    }

    @Override // tb.i
    public String c() {
        return this.c;
    }

    @Override // tb.i
    public String d() {
        return this.d;
    }

    @Override // tb.i
    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.b.equals(iVar.e()) && this.c.equals(iVar.c()) && this.d.equals(iVar.d()) && this.e.equals(iVar.g()) && this.f == iVar.f();
    }

    @Override // tb.i
    public long f() {
        return this.f;
    }

    @Override // tb.i
    public String g() {
        return this.e;
    }

    public int hashCode() {
        int hashCode = (((((((this.b.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        long j = this.f;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.b + ", parameterKey=" + this.c + ", parameterValue=" + this.d + ", variantId=" + this.e + ", templateVersion=" + this.f + "}";
    }
}
