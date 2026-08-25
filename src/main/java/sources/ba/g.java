package ba;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.x;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class g implements j {
    private final com.google.android.exoplayer2.source.rtsp.j c;
    private e0 d;
    private int e;
    private int h;
    private long i;
    private final d0 a = new d0();
    private final d0 b = new d0(x.a);
    private long f = -9223372036854775807L;
    private int g = -1;

    public g(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.c = jVar;
    }

    private static int d(int i) {
        return (i == 19 || i == 20) ? 1 : 0;
    }

    private void e(d0 d0Var, int i) {
        if (d0Var.d().length < 3) {
            throw ParserException.createForMalformedManifest("Malformed FU header.", (Throwable) null);
        }
        int i2 = d0Var.d()[1] & 7;
        byte b = d0Var.d()[2];
        int i3 = b & 63;
        boolean z = (b & 128) > 0;
        boolean z2 = (b & 64) > 0;
        if (z) {
            this.h += h();
            d0Var.d()[1] = (byte) ((i3 << 1) & 127);
            d0Var.d()[2] = (byte) i2;
            this.a.M(d0Var.d());
            this.a.P(1);
        } else {
            int i4 = (this.g + 1) % 65535;
            if (i != i4) {
                s.i("RtpH265Reader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", new Object[]{Integer.valueOf(i4), Integer.valueOf(i)}));
                return;
            } else {
                this.a.M(d0Var.d());
                this.a.P(3);
            }
        }
        int a = this.a.a();
        this.d.c(this.a, a);
        this.h += a;
        if (z2) {
            this.e = d(i3);
        }
    }

    private void f(d0 d0Var) {
        int a = d0Var.a();
        this.h += h();
        this.d.c(d0Var, a);
        this.h += a;
        this.e = d((d0Var.d()[0] >> 1) & 63);
    }

    private static long g(long j, long j2, long j3) {
        return j + p0.N0(j2 - j3, 1000000L, 90000L);
    }

    private int h() {
        this.b.P(0);
        int a = this.b.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.d)).c(this.b, a);
        return a;
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        if (d0Var.d().length == 0) {
            throw ParserException.createForMalformedManifest("Empty RTP data packet.", (Throwable) null);
        }
        int i2 = (d0Var.d()[0] >> 1) & 63;
        com.google.android.exoplayer2.util.a.i(this.d);
        if (i2 >= 0 && i2 < 48) {
            f(d0Var);
        } else {
            if (i2 == 48) {
                throw new UnsupportedOperationException("need to implement processAggregationPacket");
            }
            if (i2 != 49) {
                throw ParserException.createForMalformedManifest(String.format("RTP H265 payload type [%d] not supported.", Integer.valueOf(i2)), (Throwable) null);
            }
            e(d0Var, i);
        }
        if (z) {
            if (this.f == -9223372036854775807L) {
                this.f = j;
            }
            this.d.e(g(this.i, j, this.f), this.e, this.h, 0, null);
            this.h = 0;
        }
        this.g = i;
    }

    @Override // ba.j
    public void b(long j, int i) {
    }

    @Override // ba.j
    public void c(n nVar, int i) {
        e0 track = nVar.track(i, 2);
        this.d = track;
        track.d(this.c.c);
    }

    @Override // ba.j
    public void seek(long j, long j2) {
        this.f = j;
        this.h = 0;
        this.i = j2;
    }
}
