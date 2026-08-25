package ba;

import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b implements j {
    private final com.google.android.exoplayer2.source.rtsp.j a;
    private final c0 b = new c0();
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private long g;
    private e0 h;
    private long i;

    public b(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.a = jVar;
        this.c = jVar.b;
        String str = (String) com.google.android.exoplayer2.util.a.e((String) jVar.d.get("mode"));
        if (com.google.common.base.a.a(str, "AAC-hbr")) {
            this.d = 13;
            this.e = 3;
        } else {
            if (!com.google.common.base.a.a(str, "AAC-lbr")) {
                throw new UnsupportedOperationException("AAC mode not supported");
            }
            this.d = 6;
            this.e = 2;
        }
        this.f = this.e + this.d;
    }

    private static void d(e0 e0Var, long j, int i) {
        e0Var.e(j, 1, i, 0, null);
    }

    private static long e(long j, long j2, long j3, int i) {
        return j + p0.N0(j2 - j3, 1000000L, i);
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        com.google.android.exoplayer2.util.a.e(this.h);
        short z2 = d0Var.z();
        int i2 = z2 / this.f;
        long e = e(this.i, j, this.g, this.c);
        this.b.m(d0Var);
        if (i2 == 1) {
            int h = this.b.h(this.d);
            this.b.r(this.e);
            this.h.c(d0Var, d0Var.a());
            if (z) {
                d(this.h, e, h);
                return;
            }
            return;
        }
        d0Var.Q((z2 + 7) / 8);
        for (int i3 = 0; i3 < i2; i3++) {
            int h2 = this.b.h(this.d);
            this.b.r(this.e);
            this.h.c(d0Var, h2);
            d(this.h, e, h2);
            e += p0.N0(i2, 1000000L, this.c);
        }
    }

    @Override // ba.j
    public void b(long j, int i) {
        this.g = j;
    }

    @Override // ba.j
    public void c(n nVar, int i) {
        e0 track = nVar.track(i, 1);
        this.h = track;
        track.d(this.a.c);
    }

    @Override // ba.j
    public void seek(long j, long j2) {
        this.g = j;
        this.i = j2;
    }
}
