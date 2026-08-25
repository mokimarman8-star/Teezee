package ba;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class h implements j {
    private final com.google.android.exoplayer2.source.rtsp.j a;
    private e0 b;
    private int c;
    private long f;
    private long d = -9223372036854775807L;
    private int e = -1;
    private int g = 0;

    public h(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.a = jVar;
    }

    private static int d(d0 d0Var) {
        int a = com.google.common.primitives.a.a(d0Var.d(), new byte[]{0, 0, 1, -74});
        if (a == -1) {
            return 0;
        }
        d0Var.P(a + 4);
        return (d0Var.h() >> 6) == 0 ? 1 : 0;
    }

    private static long e(long j, long j2, long j3) {
        return j + p0.N0(j2 - j3, 1000000L, 90000L);
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        int b;
        com.google.android.exoplayer2.util.a.i(this.b);
        int i2 = this.e;
        if (i2 != -1 && i != (b = com.google.android.exoplayer2.source.rtsp.g.b(i2))) {
            s.i("RtpMpeg4Reader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", new Object[]{Integer.valueOf(b), Integer.valueOf(i)}));
        }
        int a = d0Var.a();
        this.b.c(d0Var, a);
        if (this.g == 0) {
            this.c = d(d0Var);
        }
        this.g += a;
        if (z) {
            if (this.d == -9223372036854775807L) {
                this.d = j;
            }
            this.b.e(e(this.f, j, this.d), this.c, this.g, 0, null);
            this.g = 0;
        }
        this.e = i;
    }

    @Override // ba.j
    public void b(long j, int i) {
    }

    @Override // ba.j
    public void c(n nVar, int i) {
        e0 track = nVar.track(i, 2);
        this.b = track;
        ((e0) p0.j(track)).d(this.a.c);
    }

    @Override // ba.j
    public void seek(long j, long j2) {
        this.d = j;
        this.f = j2;
        this.g = 0;
    }
}
