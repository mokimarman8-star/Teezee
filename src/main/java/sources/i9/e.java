package i9;

import i9.b0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class e implements b0 {
    private final long a;
    private final long b;
    private final int c;
    private final long d;
    private final int e;
    private final long f;
    private final boolean g;

    public e(long j, long j2, int i, int i2, boolean z) {
        this.a = j;
        this.b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        this.g = z;
        if (j == -1) {
            this.d = -1L;
            this.f = -9223372036854775807L;
        } else {
            this.d = j - j2;
            this.f = d(j, j2, i);
        }
    }

    private long b(long j) {
        int i = this.c;
        long j2 = (((j * this.e) / 8000000) / i) * i;
        long j3 = this.d;
        if (j3 != -1) {
            j2 = Math.min(j2, j3 - i);
        }
        return this.b + Math.max(j2, 0L);
    }

    private static long d(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / i;
    }

    public long c(long j) {
        return d(j, this.b, this.e);
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.f;
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        if (this.d == -1 && !this.g) {
            return new b0.a(new c0(0L, this.b));
        }
        long b = b(j);
        long c = c(b);
        c0 c0Var = new c0(c, b);
        if (this.d != -1 && c < j) {
            int i = this.c;
            if (i + b < this.a) {
                long j2 = b + i;
                return new b0.a(c0Var, new c0(c(j2), j2));
            }
        }
        return new b0.a(c0Var);
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return this.d != -1 || this.g;
    }
}
