package p9;

import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.b0;
import i9.c0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class h implements g {
    private final long[] a;
    private final long[] b;
    private final long c;
    private final long d;

    private h(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
    }

    public static h b(long j, long j2, b0.a aVar, d0 d0Var) {
        int D;
        d0Var.Q(10);
        int n = d0Var.n();
        if (n <= 0) {
            return null;
        }
        int i = aVar.d;
        long N0 = p0.N0(n, (i >= 32000 ? 1152 : 576) * 1000000, i);
        int J = d0Var.J();
        int J2 = d0Var.J();
        int J3 = d0Var.J();
        d0Var.Q(2);
        long j3 = j2 + aVar.c;
        long[] jArr = new long[J];
        long[] jArr2 = new long[J];
        int i2 = 0;
        long j4 = j2;
        while (i2 < J) {
            int i3 = J2;
            long j5 = j3;
            jArr[i2] = (i2 * N0) / J;
            jArr2[i2] = Math.max(j4, j5);
            if (J3 == 1) {
                D = d0Var.D();
            } else if (J3 == 2) {
                D = d0Var.J();
            } else if (J3 == 3) {
                D = d0Var.G();
            } else {
                if (J3 != 4) {
                    return null;
                }
                D = d0Var.H();
            }
            j4 += D * i3;
            i2++;
            jArr = jArr;
            J2 = i3;
            j3 = j5;
        }
        long[] jArr3 = jArr;
        if (j != -1 && j != j4) {
            s.i("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new h(jArr3, jArr2, N0, j4);
    }

    @Override // p9.g
    public long a() {
        return this.d;
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.c;
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        int i = p0.i(this.a, j, true, true);
        c0 c0Var = new c0(this.a[i], this.b[i]);
        if (c0Var.a >= j || i == this.a.length - 1) {
            return new b0.a(c0Var);
        }
        int i2 = i + 1;
        return new b0.a(c0Var, new c0(this.a[i2], this.b[i2]));
    }

    @Override // p9.g
    public long getTimeUs(long j) {
        return this.a[p0.i(this.b, j, true, true)];
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return true;
    }
}
