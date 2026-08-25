package p9;

import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.b0;
import i9.c0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class i implements g {
    private final long a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final long[] f;

    private i(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    private i(long j, int i, long j2, long j3, long[] jArr) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }

    public static i b(long j, long j2, b0.a aVar, d0 d0Var) {
        int H;
        int i = aVar.g;
        int i2 = aVar.d;
        int n = d0Var.n();
        if ((n & 1) != 1 || (H = d0Var.H()) == 0) {
            return null;
        }
        long N0 = p0.N0(H, i * 1000000, i2);
        if ((n & 6) != 6) {
            return new i(j2, aVar.c, N0);
        }
        long F = d0Var.F();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = d0Var.D();
        }
        if (j != -1) {
            long j3 = j2 + F;
            if (j != j3) {
                s.i("XingSeeker", "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new i(j2, aVar.c, N0, F, jArr);
    }

    private long c(int i) {
        return (this.c * i) / 100;
    }

    @Override // p9.g
    public long a() {
        return this.e;
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.c;
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        if (!isSeekable()) {
            return new b0.a(new c0(0L, this.a + this.b));
        }
        long r = p0.r(j, 0L, this.c);
        double d = (r * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                double d3 = ((long[]) com.google.android.exoplayer2.util.a.i(this.f))[i];
                d2 = d3 + ((d - i) * ((i == 99 ? 256.0d : r3[i + 1]) - d3));
            }
        }
        return new b0.a(new c0(r, this.a + p0.r(Math.round((d2 / 256.0d) * this.d), this.b, this.d - 1)));
    }

    @Override // p9.g
    public long getTimeUs(long j) {
        long j2 = j - this.a;
        if (!isSeekable() || j2 <= this.b) {
            return 0L;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.a.i(this.f);
        double d = (j2 * 256.0d) / this.d;
        int i = p0.i(jArr, (long) d, true, true);
        long c = c(i);
        long j3 = jArr[i];
        int i2 = i + 1;
        long c2 = c(i2);
        return c + Math.round((j3 == (i == 99 ? 256L : jArr[i2]) ? 0.0d : (d - j3) / (r0 - j3)) * (c2 - c));
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return this.f != null;
    }
}
