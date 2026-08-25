package ba;

import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c implements j {
    private final com.google.android.exoplayer2.source.rtsp.j a;
    private e0 c;
    private int d;
    private long f;
    private long g;
    private final c0 b = new c0();
    private long e = -9223372036854775807L;

    public c(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.a = jVar;
    }

    private void d() {
        if (this.d > 0) {
            e();
        }
    }

    private void e() {
        ((e0) p0.j(this.c)).e(this.f, 1, this.d, 0, null);
        this.d = 0;
    }

    private void f(d0 d0Var, boolean z, int i, long j) {
        int a = d0Var.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.c)).c(d0Var, a);
        this.d += a;
        this.f = j;
        if (z && i == 3) {
            e();
        }
    }

    private void g(d0 d0Var, int i, long j) {
        this.b.n(d0Var.d());
        this.b.s(2);
        for (int i2 = 0; i2 < i; i2++) {
            b.b e = com.google.android.exoplayer2.audio.b.e(this.b);
            ((e0) com.google.android.exoplayer2.util.a.e(this.c)).c(d0Var, e.e);
            ((e0) p0.j(this.c)).e(j, 1, e.e, 0, null);
            j += (e.f / e.c) * 1000000;
            this.b.s(e.e);
        }
    }

    private void h(d0 d0Var, long j) {
        int a = d0Var.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.c)).c(d0Var, a);
        ((e0) p0.j(this.c)).e(j, 1, a, 0, null);
    }

    private static long i(long j, long j2, long j3, int i) {
        return j + p0.N0(j2 - j3, 1000000L, i);
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        int D = d0Var.D() & 3;
        int D2 = d0Var.D() & 255;
        long i2 = i(this.g, j, this.e, this.a.b);
        if (D == 0) {
            d();
            if (D2 == 1) {
                h(d0Var, i2);
                return;
            } else {
                g(d0Var, D2, i2);
                return;
            }
        }
        if (D == 1 || D == 2) {
            d();
        } else if (D != 3) {
            throw new IllegalArgumentException(String.valueOf(D));
        }
        f(d0Var, z, D, i2);
    }

    @Override // ba.j
    public void b(long j, int i) {
        com.google.android.exoplayer2.util.a.g(this.e == -9223372036854775807L);
        this.e = j;
    }

    @Override // ba.j
    public void c(n nVar, int i) {
        e0 track = nVar.track(i, 1);
        this.c = track;
        track.d(this.a.c);
    }

    @Override // ba.j
    public void seek(long j, long j2) {
        this.e = j;
        this.g = j2;
    }
}
