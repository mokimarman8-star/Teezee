package t9;

import com.google.android.exoplayer2.util.p0;
import i9.b0;
import i9.c0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class e implements b0 {
    private final c a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;

    public e(c cVar, int i, long j, long j2) {
        this.a = cVar;
        this.b = i;
        this.c = j;
        long j3 = (j2 - j) / cVar.e;
        this.d = j3;
        this.e = b(j3);
    }

    private long b(long j) {
        return p0.N0(j * this.b, 1000000L, this.a.c);
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.e;
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        long r = p0.r((this.a.c * j) / (this.b * 1000000), 0L, this.d - 1);
        long j2 = this.c + (this.a.e * r);
        long b = b(r);
        c0 c0Var = new c0(b, j2);
        if (b >= j || r == this.d - 1) {
            return new b0.a(c0Var);
        }
        long j3 = r + 1;
        return new b0.a(c0Var, new c0(b(j3), this.c + (this.a.e * j3)));
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return true;
    }
}
