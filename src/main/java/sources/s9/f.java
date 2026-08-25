package s9;

import com.google.android.exoplayer2.audio.c;
import com.google.android.exoplayer2.p1;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class f implements m {
    private final com.google.android.exoplayer2.util.c0 a;
    private final com.google.android.exoplayer2.util.d0 b;
    private final String c;
    private String d;
    private i9.e0 e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private p1 k;
    private int l;
    private long m;

    public f() {
        this(null);
    }

    public f(String str) {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(new byte[16]);
        this.a = c0Var;
        this.b = new com.google.android.exoplayer2.util.d0(c0Var.a);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = false;
        this.m = -9223372036854775807L;
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
        c.b d = com.google.android.exoplayer2.audio.c.d(this.a);
        p1 p1Var = this.k;
        if (p1Var == null || d.c != p1Var.y || d.b != p1Var.z || !"audio/ac4".equals(p1Var.l)) {
            p1 E = new p1.b().S(this.d).e0("audio/ac4").H(d.c).f0(d.b).V(this.c).E();
            this.k = E;
            this.e.d(E);
        }
        this.l = d.d;
        this.j = (d.e * 1000000) / this.k.z;
    }

    private boolean f(com.google.android.exoplayer2.util.d0 d0Var) {
        int D;
        while (true) {
            if (d0Var.a() <= 0) {
                return false;
            }
            if (this.h) {
                D = d0Var.D();
                this.h = D == 172;
                if (D == 64 || D == 65) {
                    break;
                }
            } else {
                this.h = d0Var.D() == 172;
            }
        }
        this.i = D == 65;
        return true;
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.e);
        while (d0Var.a() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(d0Var.a(), this.l - this.g);
                        this.e.c(d0Var, min);
                        int i2 = this.g + min;
                        this.g = i2;
                        int i3 = this.l;
                        if (i2 == i3) {
                            long j = this.m;
                            if (j != -9223372036854775807L) {
                                this.e.e(j, 1, i3, 0, null);
                                this.m += this.j;
                            }
                            this.f = 0;
                        }
                    }
                } else if (a(d0Var, this.b.d(), 16)) {
                    e();
                    this.b.P(0);
                    this.e.c(this.b, 16);
                    this.f = 2;
                }
            } else if (f(d0Var)) {
                this.f = 1;
                this.b.d()[0] = -84;
                this.b.d()[1] = (byte) (this.i ? 65 : 64);
                this.g = 2;
            }
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
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
        this.i = false;
        this.m = -9223372036854775807L;
    }
}
