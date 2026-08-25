package s9;

import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class y {
    private boolean c;
    private boolean d;
    private boolean e;
    private final l0 a = new l0(0);
    private long f = -9223372036854775807L;
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private final com.google.android.exoplayer2.util.d0 b = new com.google.android.exoplayer2.util.d0();

    y() {
    }

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(i9.m mVar) {
        this.b.M(p0.f);
        this.c = true;
        mVar.resetPeekPosition();
        return 0;
    }

    private int f(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    private int h(i9.m mVar, i9.a0 a0Var) {
        int min = (int) Math.min(20000L, mVar.getLength());
        long j = 0;
        if (mVar.getPosition() != j) {
            a0Var.a = j;
            return 1;
        }
        this.b.L(min);
        mVar.resetPeekPosition();
        mVar.peekFully(this.b.d(), 0, min);
        this.f = i(this.b);
        this.d = true;
        return 0;
    }

    private long i(com.google.android.exoplayer2.util.d0 d0Var) {
        int f = d0Var.f();
        for (int e = d0Var.e(); e < f - 3; e++) {
            if (f(d0Var.d(), e) == 442) {
                d0Var.P(e + 4);
                long l = l(d0Var);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int j(i9.m mVar, i9.a0 a0Var) {
        long length = mVar.getLength();
        int min = (int) Math.min(20000L, length);
        long j = length - min;
        if (mVar.getPosition() != j) {
            a0Var.a = j;
            return 1;
        }
        this.b.L(min);
        mVar.resetPeekPosition();
        mVar.peekFully(this.b.d(), 0, min);
        this.g = k(this.b);
        this.e = true;
        return 0;
    }

    private long k(com.google.android.exoplayer2.util.d0 d0Var) {
        int e = d0Var.e();
        for (int f = d0Var.f() - 4; f >= e; f--) {
            if (f(d0Var.d(), f) == 442) {
                d0Var.P(f + 4);
                long l = l(d0Var);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long l(com.google.android.exoplayer2.util.d0 d0Var) {
        int e = d0Var.e();
        if (d0Var.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        d0Var.j(bArr, 0, 9);
        d0Var.P(e);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    private static long m(byte[] bArr) {
        byte b = bArr[0];
        long j = (((b & 56) >> 3) << 30) | ((b & 3) << 28) | ((bArr[1] & 255) << 20);
        byte b2 = bArr[2];
        return j | (((b2 & 248) >> 3) << 15) | ((b2 & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public long c() {
        return this.h;
    }

    public l0 d() {
        return this.a;
    }

    public boolean e() {
        return this.c;
    }

    public int g(i9.m mVar, i9.a0 a0Var) {
        if (!this.e) {
            return j(mVar, a0Var);
        }
        if (this.g == -9223372036854775807L) {
            return b(mVar);
        }
        if (!this.d) {
            return h(mVar, a0Var);
        }
        long j = this.f;
        if (j == -9223372036854775807L) {
            return b(mVar);
        }
        long b = this.a.b(this.g) - this.a.b(j);
        this.h = b;
        if (b < 0) {
            com.google.android.exoplayer2.util.s.i("PsDurationReader", "Invalid duration: " + this.h + ". Using TIME_UNSET instead.");
            this.h = -9223372036854775807L;
        }
        return b(mVar);
    }
}
