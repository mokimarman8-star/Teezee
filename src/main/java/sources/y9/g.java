package y9;

import z9.i;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class g implements e {
    private final i9.d a;
    private final long b;

    public g(i9.d dVar, long j) {
        this.a = dVar;
        this.b = j;
    }

    @Override // y9.e
    public long a(long j, long j2) {
        return this.a.d[(int) j];
    }

    @Override // y9.e
    public long b(long j, long j2) {
        return 0L;
    }

    @Override // y9.e
    public long c(long j, long j2) {
        return -9223372036854775807L;
    }

    @Override // y9.e
    public i d(long j) {
        return new i(null, this.a.c[(int) j], r0.b[r8]);
    }

    @Override // y9.e
    public long e(long j, long j2) {
        return this.a.b(j + this.b);
    }

    @Override // y9.e
    public long f(long j) {
        return this.a.a;
    }

    @Override // y9.e
    public boolean g() {
        return true;
    }

    @Override // y9.e
    public long getTimeUs(long j) {
        return this.a.e[(int) j] - this.b;
    }

    @Override // y9.e
    public long h() {
        return 0L;
    }

    @Override // y9.e
    public long i(long j, long j2) {
        return this.a.a;
    }
}
