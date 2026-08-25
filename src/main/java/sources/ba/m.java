package ba;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class m implements j {
    private final com.google.android.exoplayer2.source.rtsp.j a;
    private e0 b;
    private int f;
    private long c = -9223372036854775807L;
    private long d = 0;
    private int e = -1;
    private int g = -1;
    private int h = -1;
    private boolean i = false;
    private boolean j = false;

    public m(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.a = jVar;
    }

    private static long d(long j, long j2, long j3) {
        return j + p0.N0(j2 - j3, 1000000L, 90000L);
    }

    private boolean e(d0 d0Var, int i) {
        int D = d0Var.D();
        if (this.i) {
            int b = com.google.android.exoplayer2.source.rtsp.g.b(this.e);
            if (i != b) {
                s.i("RtpVp9Reader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", new Object[]{Integer.valueOf(b), Integer.valueOf(i)}));
                return false;
            }
        } else {
            if ((D & 8) == 0) {
                s.i("RtpVp9Reader", "First payload octet of the RTP packet is not the beginning of a new VP9 partition, Dropping current packet.");
                return false;
            }
            this.i = true;
        }
        if ((D & 128) != 0 && (d0Var.D() & 128) != 0 && d0Var.a() < 1) {
            return false;
        }
        int i2 = D & 16;
        com.google.android.exoplayer2.util.a.b(i2 == 0, "VP9 flexible mode is not supported.");
        if ((D & 32) != 0) {
            d0Var.Q(1);
            if (d0Var.a() < 1) {
                return false;
            }
            if (i2 == 0) {
                d0Var.Q(1);
            }
        }
        if ((D & 2) != 0) {
            int D2 = d0Var.D();
            int i3 = (D2 >> 5) & 7;
            if ((D2 & 16) != 0) {
                int i4 = i3 + 1;
                if (d0Var.a() < i4 * 4) {
                    return false;
                }
                for (int i5 = 0; i5 < i4; i5++) {
                    this.g = d0Var.J();
                    this.h = d0Var.J();
                }
            }
            if ((D2 & 8) != 0) {
                int D3 = d0Var.D();
                if (d0Var.a() < D3) {
                    return false;
                }
                for (int i6 = 0; i6 < D3; i6++) {
                    int J = (d0Var.J() & 12) >> 2;
                    if (d0Var.a() < J) {
                        return false;
                    }
                    d0Var.Q(J);
                }
            }
        }
        return true;
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        int i2;
        int i3;
        com.google.android.exoplayer2.util.a.i(this.b);
        if (e(d0Var, i)) {
            int i4 = (this.f == 0 && this.i && (d0Var.h() & 4) == 0) ? 1 : 0;
            if (!this.j && (i2 = this.g) != -1 && (i3 = this.h) != -1) {
                p1 p1Var = this.a.c;
                if (i2 != p1Var.q || i3 != p1Var.r) {
                    this.b.d(p1Var.b().j0(this.g).Q(this.h).E());
                }
                this.j = true;
            }
            int a = d0Var.a();
            this.b.c(d0Var, a);
            this.f += a;
            if (z) {
                if (this.c == -9223372036854775807L) {
                    this.c = j;
                }
                this.b.e(d(this.d, j, this.c), i4, this.f, 0, null);
                this.f = 0;
                this.i = false;
            }
            this.e = i;
        }
    }

    @Override // ba.j
    public void b(long j, int i) {
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
        this.f = 0;
        this.d = j2;
    }
}
