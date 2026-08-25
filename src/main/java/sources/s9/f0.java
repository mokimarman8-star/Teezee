package s9;

import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class f0 {
    private final int a;
    private boolean d;
    private boolean e;
    private boolean f;
    private final l0 b = new l0(0);
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private long i = -9223372036854775807L;
    private final com.google.android.exoplayer2.util.d0 c = new com.google.android.exoplayer2.util.d0();

    f0(int i) {
        this.a = i;
    }

    private int a(i9.m mVar) {
        this.c.M(p0.f);
        this.d = true;
        mVar.resetPeekPosition();
        return 0;
    }

    private int f(i9.m mVar, i9.a0 a0Var, int i) {
        int min = (int) Math.min(this.a, mVar.getLength());
        long j = 0;
        if (mVar.getPosition() != j) {
            a0Var.a = j;
            return 1;
        }
        this.c.L(min);
        mVar.resetPeekPosition();
        mVar.peekFully(this.c.d(), 0, min);
        this.g = g(this.c, i);
        this.e = true;
        return 0;
    }

    private long g(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        int f = d0Var.f();
        for (int e = d0Var.e(); e < f; e++) {
            if (d0Var.d()[e] == 71) {
                long c = j0.c(d0Var, e, i);
                if (c != -9223372036854775807L) {
                    return c;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int h(i9.m mVar, i9.a0 a0Var, int i) {
        long length = mVar.getLength();
        int min = (int) Math.min(this.a, length);
        long j = length - min;
        if (mVar.getPosition() != j) {
            a0Var.a = j;
            return 1;
        }
        this.c.L(min);
        mVar.resetPeekPosition();
        mVar.peekFully(this.c.d(), 0, min);
        this.h = i(this.c, i);
        this.f = true;
        return 0;
    }

    private long i(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        int e = d0Var.e();
        int f = d0Var.f();
        for (int i2 = f - 188; i2 >= e; i2--) {
            if (j0.b(d0Var.d(), e, f, i2)) {
                long c = j0.c(d0Var, i2, i);
                if (c != -9223372036854775807L) {
                    return c;
                }
            }
        }
        return -9223372036854775807L;
    }

    public long b() {
        return this.i;
    }

    public l0 c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public int e(i9.m mVar, i9.a0 a0Var, int i) {
        if (i <= 0) {
            return a(mVar);
        }
        if (!this.f) {
            return h(mVar, a0Var, i);
        }
        if (this.h == -9223372036854775807L) {
            return a(mVar);
        }
        if (!this.e) {
            return f(mVar, a0Var, i);
        }
        long j = this.g;
        if (j == -9223372036854775807L) {
            return a(mVar);
        }
        long b = this.b.b(this.h) - this.b.b(j);
        this.i = b;
        if (b < 0) {
            com.google.android.exoplayer2.util.s.i("TsDurationReader", "Invalid duration: " + this.i + ". Using TIME_UNSET instead.");
            this.i = -9223372036854775807L;
        }
        return a(mVar);
    }
}
