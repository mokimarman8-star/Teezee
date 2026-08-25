package ba;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.x;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class f implements j {
    private final com.google.android.exoplayer2.source.rtsp.j c;
    private e0 d;
    private int e;
    private int h;
    private long i;
    private final d0 b = new d0(x.a);
    private final d0 a = new d0();
    private long f = -9223372036854775807L;
    private int g = -1;

    public f(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.c = jVar;
    }

    private static int d(int i) {
        return i == 5 ? 1 : 0;
    }

    private void e(d0 d0Var, int i) {
        byte b = d0Var.d()[0];
        byte b2 = d0Var.d()[1];
        int i2 = (b & 224) | (b2 & 31);
        boolean z = (b2 & 128) > 0;
        boolean z2 = (b2 & 64) > 0;
        if (z) {
            this.h += i();
            d0Var.d()[1] = (byte) i2;
            this.a.M(d0Var.d());
            this.a.P(1);
        } else {
            int b3 = com.google.android.exoplayer2.source.rtsp.g.b(this.g);
            if (i != b3) {
                s.i("RtpH264Reader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", new Object[]{Integer.valueOf(b3), Integer.valueOf(i)}));
                return;
            } else {
                this.a.M(d0Var.d());
                this.a.P(2);
            }
        }
        int a = this.a.a();
        this.d.c(this.a, a);
        this.h += a;
        if (z2) {
            this.e = d(i2 & 31);
        }
    }

    private void f(d0 d0Var) {
        int a = d0Var.a();
        this.h += i();
        this.d.c(d0Var, a);
        this.h += a;
        this.e = d(d0Var.d()[0] & 31);
    }

    private void g(d0 d0Var) {
        d0Var.D();
        while (d0Var.a() > 4) {
            int J = d0Var.J();
            this.h += i();
            this.d.c(d0Var, J);
            this.h += J;
        }
        this.e = 0;
    }

    private static long h(long j, long j2, long j3) {
        return j + p0.N0(j2 - j3, 1000000L, 90000L);
    }

    private int i() {
        this.b.P(0);
        int a = this.b.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.d)).c(this.b, a);
        return a;
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        try {
            int i2 = d0Var.d()[0] & 31;
            com.google.android.exoplayer2.util.a.i(this.d);
            if (i2 > 0 && i2 < 24) {
                f(d0Var);
            } else if (i2 == 24) {
                g(d0Var);
            } else {
                if (i2 != 28) {
                    throw ParserException.createForMalformedManifest(String.format("RTP H264 packetization mode [%d] not supported.", Integer.valueOf(i2)), (Throwable) null);
                }
                e(d0Var, i);
            }
            if (z) {
                if (this.f == -9223372036854775807L) {
                    this.f = j;
                }
                this.d.e(h(this.i, j, this.f), this.e, this.h, 0, null);
                this.h = 0;
            }
            this.g = i;
        } catch (IndexOutOfBoundsException e) {
            throw ParserException.createForMalformedManifest((String) null, e);
        }
    }

    @Override // ba.j
    public void b(long j, int i) {
    }

    @Override // ba.j
    public void c(n nVar, int i) {
        e0 track = nVar.track(i, 2);
        this.d = track;
        ((e0) p0.j(track)).d(this.c.c);
    }

    @Override // ba.j
    public void seek(long j, long j2) {
        this.f = j;
        this.h = 0;
        this.i = j2;
    }
}
