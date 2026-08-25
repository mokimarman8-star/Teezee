package u8;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class a extends b {
    private final long a;

    a(long j) {
        this.a = j;
    }

    @Override // u8.b
    public long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof b) && this.a == ((b) obj).c();
    }

    public int hashCode() {
        long j = this.a;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.a + "}";
    }
}
