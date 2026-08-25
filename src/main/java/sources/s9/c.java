package s9;

import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c implements m {
    private final com.google.android.exoplayer2.util.c0 a;
    private final com.google.android.exoplayer2.util.d0 b;
    private final String c;
    private String d;
    private i9.e0 e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private p1 j;
    private int k;
    private long l;

    public c() {
        this(null);
    }

    public c(String str) {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(new byte[128]);
        this.a = c0Var;
        this.b = new com.google.android.exoplayer2.util.d0(c0Var.a);
        this.f = 0;
        this.l = -9223372036854775807L;
        this.c = str;
    }

    private boolean a(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i) {
        int min = Math.min(d0Var.a(), i - this.g);
        d0Var.j(bArr, this.g, min);
        int i2 = this.g + min;
        this.g = i2;
        return i2 == i;
    }

    private void e() {
        this.a.p(0);
        b.b e = com.google.android.exoplayer2.audio.b.e(this.a);
        p1 p1Var = this.j;
        if (p1Var == null || e.d != p1Var.y || e.c != p1Var.z || !p0.c(e.a, p1Var.l)) {
            p1 E = new p1.b().S(this.d).e0(e.a).H(e.d).f0(e.c).V(this.c).E();
            this.j = E;
            this.e.d(E);
        }
        this.k = e.e;
        this.i = (e.f * 1000000) / this.j.z;
    }

    private boolean f(com.google.android.exoplayer2.util.d0 d0Var) {
        while (true) {
            if (d0Var.a() <= 0) {
                return false;
            }
            if (this.h) {
                int D = d0Var.D();
                if (D == 119) {
                    this.h = false;
                    return true;
                }
                this.h = D == 11;
            } else {
                this.h = d0Var.D() == 11;
            }
        }
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.e);
        while (d0Var.a() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(d0Var.a(), this.k - this.g);
                        this.e.c(d0Var, min);
                        int i2 = this.g + min;
                        this.g = i2;
                        int i3 = this.k;
                        if (i2 == i3) {
                            long j = this.l;
                            if (j != -9223372036854775807L) {
                                this.e.e(j, 1, i3, 0, null);
                                this.l += this.i;
                            }
                            this.f = 0;
                        }
                    }
                } else if (a(d0Var, this.b.d(), 128)) {
                    e();
                    this.b.P(0);
                    this.e.c(this.b, 128);
                    this.f = 2;
                }
            } else if (f(d0Var)) {
                this.f = 1;
                this.b.d()[0] = 11;
                this.b.d()[1] = 119;
                this.g = 2;
            }
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = nVar.track(dVar.c(), 1);
    }

    @Override // s9.m
    public void packetFinished() {
    }

    @Override // s9.m
    public void seek() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.l = -9223372036854775807L;
    }
}
