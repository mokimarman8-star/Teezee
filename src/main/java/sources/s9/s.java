package s9;

import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.p1;
import java.util.Collections;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class s implements m {
    private final String a;
    private final com.google.android.exoplayer2.util.d0 b;
    private final com.google.android.exoplayer2.util.c0 c;
    private i9.e0 d;
    private String e;
    private p1 f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;
    private String u;

    public s(String str) {
        this.a = str;
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(MemoryConstants.KB);
        this.b = d0Var;
        this.c = new com.google.android.exoplayer2.util.c0(d0Var.d());
        this.k = -9223372036854775807L;
    }

    private static long a(com.google.android.exoplayer2.util.c0 c0Var) {
        return c0Var.h((c0Var.h(2) + 1) * 8);
    }

    private void e(com.google.android.exoplayer2.util.c0 c0Var) {
        if (!c0Var.g()) {
            this.l = true;
            j(c0Var);
        } else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw ParserException.createForMalformedContainer((String) null, (Throwable) null);
        }
        if (this.n != 0) {
            throw ParserException.createForMalformedContainer((String) null, (Throwable) null);
        }
        i(c0Var, h(c0Var));
        if (this.p) {
            c0Var.r((int) this.q);
        }
    }

    private int f(com.google.android.exoplayer2.util.c0 c0Var) {
        int b = c0Var.b();
        a.b e = com.google.android.exoplayer2.audio.a.e(c0Var, true);
        this.u = e.c;
        this.r = e.a;
        this.t = e.b;
        return b - c0Var.b();
    }

    private void g(com.google.android.exoplayer2.util.c0 c0Var) {
        int h = c0Var.h(3);
        this.o = h;
        if (h == 0) {
            c0Var.r(8);
            return;
        }
        if (h == 1) {
            c0Var.r(9);
            return;
        }
        if (h == 3 || h == 4 || h == 5) {
            c0Var.r(6);
        } else {
            if (h != 6 && h != 7) {
                throw new IllegalStateException();
            }
            c0Var.r(1);
        }
    }

    private int h(com.google.android.exoplayer2.util.c0 c0Var) {
        int h;
        if (this.o != 0) {
            throw ParserException.createForMalformedContainer((String) null, (Throwable) null);
        }
        int i = 0;
        do {
            h = c0Var.h(8);
            i += h;
        } while (h == 255);
        return i;
    }

    private void i(com.google.android.exoplayer2.util.c0 c0Var, int i) {
        int e = c0Var.e();
        if ((e & 7) == 0) {
            this.b.P(e >> 3);
        } else {
            c0Var.i(this.b.d(), 0, i * 8);
            this.b.P(0);
        }
        this.d.c(this.b, i);
        long j = this.k;
        if (j != -9223372036854775807L) {
            this.d.e(j, 1, i, 0, null);
            this.k += this.s;
        }
    }

    private void j(com.google.android.exoplayer2.util.c0 c0Var) {
        boolean g;
        int h = c0Var.h(1);
        int h2 = h == 1 ? c0Var.h(1) : 0;
        this.m = h2;
        if (h2 != 0) {
            throw ParserException.createForMalformedContainer((String) null, (Throwable) null);
        }
        if (h == 1) {
            a(c0Var);
        }
        if (!c0Var.g()) {
            throw ParserException.createForMalformedContainer((String) null, (Throwable) null);
        }
        this.n = c0Var.h(6);
        int h3 = c0Var.h(4);
        int h4 = c0Var.h(3);
        if (h3 != 0 || h4 != 0) {
            throw ParserException.createForMalformedContainer((String) null, (Throwable) null);
        }
        if (h == 0) {
            int e = c0Var.e();
            int f = f(c0Var);
            c0Var.p(e);
            byte[] bArr = new byte[(f + 7) / 8];
            c0Var.i(bArr, 0, f);
            p1 E = new p1.b().S(this.e).e0("audio/mp4a-latm").I(this.u).H(this.t).f0(this.r).T(Collections.singletonList(bArr)).V(this.a).E();
            if (!E.equals(this.f)) {
                this.f = E;
                this.s = 1024000000 / E.z;
                this.d.d(E);
            }
        } else {
            c0Var.r(((int) a(c0Var)) - f(c0Var));
        }
        g(c0Var);
        boolean g2 = c0Var.g();
        this.p = g2;
        this.q = 0L;
        if (g2) {
            if (h == 1) {
                this.q = a(c0Var);
            } else {
                do {
                    g = c0Var.g();
                    this.q = (this.q << 8) + c0Var.h(8);
                } while (g);
            }
        }
        if (c0Var.g()) {
            c0Var.r(8);
        }
    }

    private void k(int i) {
        this.b.L(i);
        this.c.n(this.b.d());
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.d);
        while (d0Var.a() > 0) {
            int i = this.g;
            if (i != 0) {
                if (i == 1) {
                    int D = d0Var.D();
                    if ((D & 224) == 224) {
                        this.j = D;
                        this.g = 2;
                    } else if (D != 86) {
                        this.g = 0;
                    }
                } else if (i == 2) {
                    int D2 = ((this.j & (-225)) << 8) | d0Var.D();
                    this.i = D2;
                    if (D2 > this.b.d().length) {
                        k(this.i);
                    }
                    this.h = 0;
                    this.g = 3;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(d0Var.a(), this.i - this.h);
                    d0Var.j(this.c.a, this.h, min);
                    int i2 = this.h + min;
                    this.h = i2;
                    if (i2 == this.i) {
                        this.c.p(0);
                        e(this.c);
                        this.g = 0;
                    }
                }
            } else if (d0Var.D() == 86) {
                this.g = 1;
            }
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        dVar.a();
        this.d = nVar.track(dVar.c(), 1);
        this.e = dVar.b();
    }

    @Override // s9.m
    public void packetFinished() {
    }

    @Override // s9.m
    public void seek() {
        this.g = 0;
        this.k = -9223372036854775807L;
        this.l = false;
    }
}
