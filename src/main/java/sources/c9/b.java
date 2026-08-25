package c9;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b extends k {
    private final long a;
    private final com.google.android.datatransport.runtime.o b;
    private final com.google.android.datatransport.runtime.i c;

    b(long j, com.google.android.datatransport.runtime.o oVar, com.google.android.datatransport.runtime.i iVar) {
        this.a = j;
        if (oVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.b = oVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.c = iVar;
    }

    @Override // c9.k
    public com.google.android.datatransport.runtime.i b() {
        return this.c;
    }

    @Override // c9.k
    public long c() {
        return this.a;
    }

    @Override // c9.k
    public com.google.android.datatransport.runtime.o d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a == kVar.c() && this.b.equals(kVar.d()) && this.c.equals(kVar.b());
    }

    public int hashCode() {
        long j = this.a;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.b + ", event=" + this.c + "}";
    }
}
