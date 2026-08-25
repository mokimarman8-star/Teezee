package s9;

import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import i9.a;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class x extends i9.a {

    private static final class b implements a.f {
        private final l0 a;
        private final com.google.android.exoplayer2.util.d0 b;

        private b(l0 l0Var) {
            this.a = l0Var;
            this.b = new com.google.android.exoplayer2.util.d0();
        }

        private a.e c(com.google.android.exoplayer2.util.d0 d0Var, long j, long j2) {
            int i = -1;
            int i2 = -1;
            long j3 = -9223372036854775807L;
            while (d0Var.a() >= 4) {
                if (x.k(d0Var.d(), d0Var.e()) != 442) {
                    d0Var.Q(1);
                } else {
                    d0Var.Q(4);
                    long l = y.l(d0Var);
                    if (l != -9223372036854775807L) {
                        long b = this.a.b(l);
                        if (b > j) {
                            return j3 == -9223372036854775807L ? a.e.d(b, j2) : a.e.e(j2 + i2);
                        }
                        if (100000 + b > j) {
                            return a.e.e(j2 + d0Var.e());
                        }
                        i2 = d0Var.e();
                        j3 = b;
                    }
                    d(d0Var);
                    i = d0Var.e();
                }
            }
            return j3 != -9223372036854775807L ? a.e.f(j3, j2 + i) : a.e.d;
        }

        private static void d(com.google.android.exoplayer2.util.d0 d0Var) {
            int k;
            int f = d0Var.f();
            if (d0Var.a() < 10) {
                d0Var.P(f);
                return;
            }
            d0Var.Q(9);
            int D = d0Var.D() & 7;
            if (d0Var.a() < D) {
                d0Var.P(f);
                return;
            }
            d0Var.Q(D);
            if (d0Var.a() < 4) {
                d0Var.P(f);
                return;
            }
            if (x.k(d0Var.d(), d0Var.e()) == 443) {
                d0Var.Q(4);
                int J = d0Var.J();
                if (d0Var.a() < J) {
                    d0Var.P(f);
                    return;
                }
                d0Var.Q(J);
            }
            while (d0Var.a() >= 4 && (k = x.k(d0Var.d(), d0Var.e())) != 442 && k != 441 && (k >>> 8) == 1) {
                d0Var.Q(4);
                if (d0Var.a() < 2) {
                    d0Var.P(f);
                    return;
                }
                d0Var.P(Math.min(d0Var.f(), d0Var.e() + d0Var.J()));
            }
        }

        @Override // i9.a.f
        public void a() {
            this.b.M(p0.f);
        }

        @Override // i9.a.f
        public a.e b(i9.m mVar, long j) {
            long position = mVar.getPosition();
            int min = (int) Math.min(20000L, mVar.getLength() - position);
            this.b.L(min);
            mVar.peekFully(this.b.d(), 0, min);
            return c(this.b, j, position);
        }
    }

    public x(l0 l0Var, long j, long j2) {
        super(new a.b(), new b(l0Var), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
