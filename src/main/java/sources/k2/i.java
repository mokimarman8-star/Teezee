package k2;

import k2.m0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class i implements m0 {

    /* renamed from: a, reason: collision with root package name */
    private final long f16197a;

    /* renamed from: b, reason: collision with root package name */
    private final long f16198b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16199c;

    /* renamed from: d, reason: collision with root package name */
    private final long f16200d;

    /* renamed from: e, reason: collision with root package name */
    private final int f16201e;

    /* renamed from: f, reason: collision with root package name */
    private final long f16202f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f16203g;

    public i(long j5, long j6, int i5, int i6, boolean z5) {
        this.f16197a = j5;
        this.f16198b = j6;
        this.f16199c = i6 == -1 ? 1 : i6;
        this.f16201e = i5;
        this.f16203g = z5;
        if (j5 == -1) {
            this.f16200d = -1L;
            this.f16202f = -9223372036854775807L;
        } else {
            this.f16200d = j5 - j6;
            this.f16202f = d(j5, j6, i5);
        }
    }

    private long b(long j5) {
        int i5 = this.f16199c;
        long j6 = (((j5 * this.f16201e) / 8000000) / i5) * i5;
        long j7 = this.f16200d;
        if (j7 != -1) {
            j6 = Math.min(j6, j7 - i5);
        }
        return this.f16198b + Math.max(j6, 0L);
    }

    private static long d(long j5, long j6, int i5) {
        return (Math.max(0L, j5 - j6) * 8000000) / i5;
    }

    public long c(long j5) {
        return d(j5, this.f16198b, this.f16201e);
    }

    @Override // k2.m0
    public long getDurationUs() {
        return this.f16202f;
    }

    @Override // k2.m0
    public m0.a getSeekPoints(long j5) {
        if (this.f16200d == -1 && !this.f16203g) {
            return new m0.a(new n0(0L, this.f16198b));
        }
        long b5 = b(j5);
        long c5 = c(b5);
        n0 n0Var = new n0(c5, b5);
        if (this.f16200d != -1 && c5 < j5) {
            int i5 = this.f16199c;
            if (i5 + b5 < this.f16197a) {
                long j6 = b5 + i5;
                return new m0.a(n0Var, new n0(c(j6), j6));
            }
        }
        return new m0.a(n0Var);
    }

    @Override // k2.m0
    public boolean isSeekable() {
        return this.f16200d != -1 || this.f16203g;
    }
}
