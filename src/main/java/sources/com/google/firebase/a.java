package com.google.firebase;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class a extends n {
    private final long a;
    private final long b;
    private final long c;

    a(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    @Override // com.google.firebase.n
    public long b() {
        return this.b;
    }

    @Override // com.google.firebase.n
    public long c() {
        return this.a;
    }

    @Override // com.google.firebase.n
    public long d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.a == nVar.c() && this.b == nVar.b() && this.c == nVar.d();
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.c;
        return i ^ ((int) ((j3 >>> 32) ^ j3));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.a + ", elapsedRealtime=" + this.b + ", uptimeMillis=" + this.c + "}";
    }
}
