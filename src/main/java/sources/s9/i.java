package s9;

import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.Collections;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class i implements m {
    private static final byte[] v = {73, 68, 51};
    private final boolean a;
    private final com.google.android.exoplayer2.util.c0 b;
    private final com.google.android.exoplayer2.util.d0 c;
    private final String d;
    private String e;
    private i9.e0 f;
    private i9.e0 g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private i9.e0 t;
    private long u;

    public i(boolean z) {
        this(z, null);
    }

    public i(boolean z, String str) {
        this.b = new com.google.android.exoplayer2.util.c0(new byte[7]);
        this.c = new com.google.android.exoplayer2.util.d0(Arrays.copyOf(v, 10));
        q();
        this.m = -1;
        this.n = -1;
        this.q = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.a = z;
        this.d = str;
    }

    private void a() {
        com.google.android.exoplayer2.util.a.e(this.f);
        p0.j(this.t);
        p0.j(this.g);
    }

    private void e(com.google.android.exoplayer2.util.d0 d0Var) {
        if (d0Var.a() == 0) {
            return;
        }
        this.b.a[0] = d0Var.d()[d0Var.e()];
        this.b.p(2);
        int h = this.b.h(4);
        int i = this.n;
        if (i != -1 && h != i) {
            o();
            return;
        }
        if (!this.l) {
            this.l = true;
            this.m = this.o;
            this.n = h;
        }
        r();
    }

    private boolean f(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        d0Var.P(i + 1);
        if (!u(d0Var, this.b.a, 1)) {
            return false;
        }
        this.b.p(4);
        int h = this.b.h(1);
        int i2 = this.m;
        if (i2 != -1 && h != i2) {
            return false;
        }
        if (this.n != -1) {
            if (!u(d0Var, this.b.a, 1)) {
                return true;
            }
            this.b.p(2);
            if (this.b.h(4) != this.n) {
                return false;
            }
            d0Var.P(i + 2);
        }
        if (!u(d0Var, this.b.a, 4)) {
            return true;
        }
        this.b.p(14);
        int h2 = this.b.h(13);
        if (h2 < 7) {
            return false;
        }
        byte[] d = d0Var.d();
        int f = d0Var.f();
        int i3 = i + h2;
        if (i3 >= f) {
            return true;
        }
        byte b = d[i3];
        if (b == -1) {
            int i4 = i3 + 1;
            if (i4 == f) {
                return true;
            }
            return j((byte) -1, d[i4]) && ((d[i4] & 8) >> 3) == h;
        }
        if (b != 73) {
            return false;
        }
        int i5 = i3 + 1;
        if (i5 == f) {
            return true;
        }
        if (d[i5] != 68) {
            return false;
        }
        int i6 = i3 + 2;
        return i6 == f || d[i6] == 51;
    }

    private boolean g(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i) {
        int min = Math.min(d0Var.a(), i - this.i);
        d0Var.j(bArr, this.i, min);
        int i2 = this.i + min;
        this.i = i2;
        return i2 == i;
    }

    private void h(com.google.android.exoplayer2.util.d0 d0Var) {
        byte[] d = d0Var.d();
        int e = d0Var.e();
        int f = d0Var.f();
        while (e < f) {
            int i = e + 1;
            byte b = d[e];
            int i2 = b & 255;
            if (this.j == 512 && j((byte) -1, (byte) i2) && (this.l || f(d0Var, e - 1))) {
                this.o = (b & 8) >> 3;
                this.k = (b & 1) == 0;
                if (this.l) {
                    r();
                } else {
                    p();
                }
                d0Var.P(i);
                return;
            }
            int i3 = this.j;
            int i4 = i2 | i3;
            if (i4 == 329) {
                this.j = 768;
            } else if (i4 == 511) {
                this.j = 512;
            } else if (i4 == 836) {
                this.j = MemoryConstants.KB;
            } else if (i4 == 1075) {
                s();
                d0Var.P(i);
                return;
            } else if (i3 != 256) {
                this.j = 256;
            }
            e = i;
        }
        d0Var.P(e);
    }

    private boolean j(byte b, byte b2) {
        return k(((b & 255) << 8) | (b2 & 255));
    }

    public static boolean k(int i) {
        return (i & 65526) == 65520;
    }

    private void l() {
        this.b.p(0);
        if (this.p) {
            this.b.r(10);
        } else {
            int i = 2;
            int h = this.b.h(2) + 1;
            if (h != 2) {
                com.google.android.exoplayer2.util.s.i("AdtsReader", "Detected audio object type: " + h + ", but assuming AAC LC.");
            } else {
                i = h;
            }
            this.b.r(5);
            byte[] b = com.google.android.exoplayer2.audio.a.b(i, this.n, this.b.h(3));
            a.b f = com.google.android.exoplayer2.audio.a.f(b);
            p1 E = new p1.b().S(this.e).e0("audio/mp4a-latm").I(f.c).H(f.b).f0(f.a).T(Collections.singletonList(b)).V(this.d).E();
            this.q = 1024000000 / E.z;
            this.f.d(E);
            this.p = true;
        }
        this.b.r(4);
        int h2 = this.b.h(13);
        int i2 = h2 - 7;
        if (this.k) {
            i2 = h2 - 9;
        }
        t(this.f, this.q, 0, i2);
    }

    private void m() {
        this.g.c(this.c, 10);
        this.c.P(6);
        t(this.g, 0L, 10, this.c.C() + 10);
    }

    private void n(com.google.android.exoplayer2.util.d0 d0Var) {
        int min = Math.min(d0Var.a(), this.r - this.i);
        this.t.c(d0Var, min);
        int i = this.i + min;
        this.i = i;
        int i2 = this.r;
        if (i == i2) {
            long j = this.s;
            if (j != -9223372036854775807L) {
                this.t.e(j, 1, i2, 0, null);
                this.s += this.u;
            }
            q();
        }
    }

    private void o() {
        this.l = false;
        q();
    }

    private void p() {
        this.h = 1;
        this.i = 0;
    }

    private void q() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }

    private void r() {
        this.h = 3;
        this.i = 0;
    }

    private void s() {
        this.h = 2;
        this.i = v.length;
        this.r = 0;
        this.c.P(0);
    }

    private void t(i9.e0 e0Var, long j, int i, int i2) {
        this.h = 4;
        this.i = i;
        this.t = e0Var;
        this.u = j;
        this.r = i2;
    }

    private boolean u(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i) {
        if (d0Var.a() < i) {
            return false;
        }
        d0Var.j(bArr, 0, i);
        return true;
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        a();
        while (d0Var.a() > 0) {
            int i = this.h;
            if (i == 0) {
                h(d0Var);
            } else if (i == 1) {
                e(d0Var);
            } else if (i != 2) {
                if (i == 3) {
                    if (g(d0Var, this.b.a, this.k ? 7 : 5)) {
                        l();
                    }
                } else {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    n(d0Var);
                }
            } else if (g(d0Var, this.c.d(), 10)) {
                m();
            }
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if (j != -9223372036854775807L) {
            this.s = j;
        }
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        dVar.a();
        this.e = dVar.b();
        i9.e0 track = nVar.track(dVar.c(), 1);
        this.f = track;
        this.t = track;
        if (!this.a) {
            this.g = new i9.k();
            return;
        }
        dVar.a();
        i9.e0 track2 = nVar.track(dVar.c(), 5);
        this.g = track2;
        track2.d(new p1.b().S(dVar.b()).e0("application/id3").E());
    }

    public long i() {
        return this.q;
    }

    @Override // s9.m
    public void packetFinished() {
    }

    @Override // s9.m
    public void seek() {
        this.s = -9223372036854775807L;
        o();
    }
}
