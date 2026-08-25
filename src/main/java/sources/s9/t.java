package s9;

import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.p1;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class t implements m {
    private final com.google.android.exoplayer2.util.d0 a;
    private final b0.a b;
    private final String c;
    private i9.e0 d;
    private String e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l;

    public t() {
        this(null);
    }

    public t(String str) {
        this.f = 0;
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(4);
        this.a = d0Var;
        d0Var.d()[0] = -1;
        this.b = new b0.a();
        this.l = -9223372036854775807L;
        this.c = str;
    }

    private void a(com.google.android.exoplayer2.util.d0 d0Var) {
        byte[] d = d0Var.d();
        int f = d0Var.f();
        for (int e = d0Var.e(); e < f; e++) {
            byte b = d[e];
            boolean z = (b & 255) == 255;
            boolean z2 = this.i && (b & 224) == 224;
            this.i = z;
            if (z2) {
                d0Var.P(e + 1);
                this.i = false;
                this.a.d()[1] = d[e];
                this.g = 2;
                this.f = 1;
                return;
            }
        }
        d0Var.P(f);
    }

    private void e(com.google.android.exoplayer2.util.d0 d0Var) {
        int min = Math.min(d0Var.a(), this.k - this.g);
        this.d.c(d0Var, min);
        int i = this.g + min;
        this.g = i;
        int i2 = this.k;
        if (i < i2) {
            return;
        }
        long j = this.l;
        if (j != -9223372036854775807L) {
            this.d.e(j, 1, i2, 0, null);
            this.l += this.j;
        }
        this.g = 0;
        this.f = 0;
    }

    private void f(com.google.android.exoplayer2.util.d0 d0Var) {
        int min = Math.min(d0Var.a(), 4 - this.g);
        d0Var.j(this.a.d(), this.g, min);
        int i = this.g + min;
        this.g = i;
        if (i < 4) {
            return;
        }
        this.a.P(0);
        if (!this.b.a(this.a.n())) {
            this.g = 0;
            this.f = 1;
            return;
        }
        this.k = this.b.c;
        if (!this.h) {
            this.j = (r8.g * 1000000) / r8.d;
            this.d.d(new p1.b().S(this.e).e0(this.b.b).W(4096).H(this.b.e).f0(this.b.d).V(this.c).E());
            this.h = true;
        }
        this.a.P(0);
        this.d.c(this.a, 4);
        this.f = 2;
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.d);
        while (d0Var.a() > 0) {
            int i = this.f;
            if (i == 0) {
                a(d0Var);
            } else if (i == 1) {
                f(d0Var);
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                e(d0Var);
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
        this.e = dVar.b();
        this.d = nVar.track(dVar.c(), 1);
    }

    @Override // s9.m
    public void packetFinished() {
    }

    @Override // s9.m
    public void seek() {
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.l = -9223372036854775807L;
    }
}
