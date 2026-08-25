package ba;

import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class e implements j {
    private final com.google.android.exoplayer2.source.rtsp.j a;
    private e0 b;
    private int d;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private long c = -9223372036854775807L;
    private int e = -1;

    public e(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.a = jVar;
    }

    private void d(d0 d0Var, boolean z) {
        int e = d0Var.e();
        if (((d0Var.F() >> 10) & 63) != 32) {
            d0Var.P(e);
            this.h = false;
            return;
        }
        int h = d0Var.h();
        int i = (h >> 1) & 1;
        if (!z && i == 0) {
            int i2 = (h >> 2) & 7;
            if (i2 == 1) {
                this.f = 128;
                this.g = 96;
            } else {
                int i3 = i2 - 2;
                this.f = 176 << i3;
                this.g = 144 << i3;
            }
        }
        d0Var.P(e);
        this.h = i == 0;
    }

    private static long e(long j, long j2, long j3) {
        return j + p0.N0(j2 - j3, 1000000L, 90000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        com.google.android.exoplayer2.util.a.i(this.b);
        int e = d0Var.e();
        int J = d0Var.J();
        Object[] objArr = (J & MemoryConstants.KB) > 0;
        if ((J & 512) != 0 || (J & 504) != 0 || (J & 7) != 0) {
            s.i("RtpH263Reader", "Dropping packet: video reduncancy coding is not supported, packet header VRC, or PLEN or PEBIT is non-zero");
            return;
        }
        if (objArr != true) {
            int b = com.google.android.exoplayer2.source.rtsp.g.b(this.e);
            if (i != b) {
                s.i("RtpH263Reader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", new Object[]{Integer.valueOf(b), Integer.valueOf(i)}));
                return;
            }
        } else if ((d0Var.h() & 252) < 128) {
            s.i("RtpH263Reader", "Picture start Code (PSC) missing, dropping packet.");
            return;
        } else {
            d0Var.d()[e] = 0;
            d0Var.d()[e + 1] = 0;
            d0Var.P(e);
        }
        if (this.d == 0) {
            d(d0Var, this.i);
            if (!this.i && this.h) {
                int i2 = this.f;
                p1 p1Var = this.a.c;
                if (i2 != p1Var.q || this.g != p1Var.r) {
                    this.b.d(p1Var.b().j0(this.f).Q(this.g).E());
                }
                this.i = true;
            }
        }
        int a = d0Var.a();
        this.b.c(d0Var, a);
        this.d += a;
        if (z) {
            if (this.c == -9223372036854775807L) {
                this.c = j;
            }
            this.b.e(e(this.j, j, this.c), this.h ? 1 : 0, this.d, 0, null);
            this.d = 0;
            this.h = false;
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
        track.d(this.a.c);
    }

    @Override // ba.j
    public void seek(long j, long j2) {
        this.c = j;
        this.d = 0;
        this.j = j2;
    }
}
