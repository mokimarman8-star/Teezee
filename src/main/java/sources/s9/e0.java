package s9;

import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import i9.a;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class e0 extends i9.a {

    private static final class a implements a.f {
        private final l0 a;
        private final com.google.android.exoplayer2.util.d0 b = new com.google.android.exoplayer2.util.d0();
        private final int c;
        private final int d;

        public a(int i, l0 l0Var, int i2) {
            this.c = i;
            this.a = l0Var;
            this.d = i2;
        }

        private a.e c(com.google.android.exoplayer2.util.d0 d0Var, long j, long j2) {
            int a;
            int a2;
            int f = d0Var.f();
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (d0Var.a() >= 188 && (a2 = (a = j0.a(d0Var.d(), d0Var.e(), f)) + 188) <= f) {
                long c = j0.c(d0Var, a, this.c);
                if (c != -9223372036854775807L) {
                    long b = this.a.b(c);
                    if (b > j) {
                        return j5 == -9223372036854775807L ? a.e.d(b, j2) : a.e.e(j2 + j4);
                    }
                    if (100000 + b > j) {
                        return a.e.e(j2 + a);
                    }
                    j4 = a;
                    j5 = b;
                }
                d0Var.P(a2);
                j3 = a2;
            }
            return j5 != -9223372036854775807L ? a.e.f(j5, j2 + j3) : a.e.d;
        }

        @Override // i9.a.f
        public void a() {
            this.b.M(p0.f);
        }

        @Override // i9.a.f
        public a.e b(i9.m mVar, long j) {
            long position = mVar.getPosition();
            int min = (int) Math.min(this.d, mVar.getLength() - position);
            this.b.L(min);
            mVar.peekFully(this.b.d(), 0, min);
            return c(this.b, j, position);
        }
    }

    public e0(l0 l0Var, long j, long j2, int i, int i2) {
        super(new a.b(), new a(i, l0Var, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}
