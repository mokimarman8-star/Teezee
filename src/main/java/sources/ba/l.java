package ba;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class l implements j {
    private final com.google.android.exoplayer2.source.rtsp.j a;
    private e0 b;
    private long c = -9223372036854775807L;
    private int d = -1;
    private int e = -1;
    private long f = -9223372036854775807L;
    private long g = 0;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;

    public l(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.a = jVar;
    }

    private void d() {
        e0 e0Var = (e0) com.google.android.exoplayer2.util.a.e(this.b);
        long j = this.f;
        boolean z = this.i;
        e0Var.e(j, z ? 1 : 0, this.e, 0, null);
        this.e = 0;
        this.f = -9223372036854775807L;
        this.h = false;
    }

    private static long e(long j, long j2, long j3) {
        return j + p0.N0(j2 - j3, 1000000L, 90000L);
    }

    private boolean f(d0 d0Var, int i) {
        int D = d0Var.D();
        if ((D & 16) == 16 && (D & 7) == 0) {
            if (this.h && this.e > 0) {
                d();
            }
            this.h = true;
        } else {
            if (!this.h) {
                s.i("RtpVP8Reader", "RTP packet is not the start of a new VP8 partition, skipping.");
                return false;
            }
            int b = com.google.android.exoplayer2.source.rtsp.g.b(this.d);
            if (i < b) {
                s.i("RtpVP8Reader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", new Object[]{Integer.valueOf(b), Integer.valueOf(i)}));
                return false;
            }
        }
        if ((D & 128) != 0) {
            int D2 = d0Var.D();
            if ((D2 & 128) != 0 && (d0Var.D() & 128) != 0) {
                d0Var.Q(1);
            }
            if ((D2 & 64) != 0) {
                d0Var.Q(1);
            }
            if ((D2 & 32) != 0 || (D2 & 16) != 0) {
                d0Var.Q(1);
            }
        }
        return true;
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        com.google.android.exoplayer2.util.a.i(this.b);
        if (f(d0Var, i)) {
            if (this.e == -1 && this.h) {
                this.i = (d0Var.h() & 1) == 0;
            }
            if (!this.j) {
                int e = d0Var.e();
                d0Var.P(e + 6);
                int v = d0Var.v() & 16383;
                int v2 = d0Var.v() & 16383;
                d0Var.P(e);
                p1 p1Var = this.a.c;
                if (v != p1Var.q || v2 != p1Var.r) {
                    this.b.d(p1Var.b().j0(v).Q(v2).E());
                }
                this.j = true;
            }
            int a = d0Var.a();
            this.b.c(d0Var, a);
            int i2 = this.e;
            if (i2 == -1) {
                this.e = a;
            } else {
                this.e = i2 + a;
            }
            this.f = e(this.g, j, this.c);
            if (z) {
                d();
            }
            this.d = i;
        }
    }

    @Override // ba.j
    public void b(long j, int i) {
        com.google.android.exoplayer2.util.a.g(this.c == -9223372036854775807L);
        this.c = j;
    }

    @Override // ba.j
    public void c(n nVar, int i) {
        e0 track = nVar.track(i, 2);
        this.b = track;
        track.d(this.a.c);
    }

    @Override // ba.j
    public void seek(long j, long j2) {
        this.c = j;
        this.e = -1;
        this.g = j2;
    }
}
