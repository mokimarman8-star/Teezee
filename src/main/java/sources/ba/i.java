package ba;

import com.google.android.exoplayer2.audio.c0;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.e0;
import i9.n;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class i implements j {
    private final com.google.android.exoplayer2.source.rtsp.j a;
    private e0 b;
    private long d;
    private boolean f;
    private boolean g;
    private long c = -1;
    private int e = -1;

    public i(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.a = jVar;
    }

    private static long d(long j, long j2, long j3) {
        return j + p0.N0(j2 - j3, 1000000L, 48000L);
    }

    private static void e(d0 d0Var) {
        int e = d0Var.e();
        com.google.android.exoplayer2.util.a.b(d0Var.f() > 18, "ID Header has insufficient data");
        com.google.android.exoplayer2.util.a.b(d0Var.A(8).equals("OpusHead"), "ID Header missing");
        com.google.android.exoplayer2.util.a.b(d0Var.D() == 1, "version number must always be 1");
        d0Var.P(e);
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        com.google.android.exoplayer2.util.a.i(this.b);
        if (!this.f) {
            e(d0Var);
            List a = c0.a(d0Var.d());
            p1.b b = this.a.c.b();
            b.T(a);
            this.b.d(b.E());
            this.f = true;
        } else if (this.g) {
            int b2 = com.google.android.exoplayer2.source.rtsp.g.b(this.e);
            if (i != b2) {
                s.i("RtpOpusReader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", new Object[]{Integer.valueOf(b2), Integer.valueOf(i)}));
            }
            int a2 = d0Var.a();
            this.b.c(d0Var, a2);
            this.b.e(d(this.d, j, this.c), 1, a2, 0, null);
        } else {
            com.google.android.exoplayer2.util.a.b(d0Var.f() >= 8, "Comment Header has insufficient data");
            com.google.android.exoplayer2.util.a.b(d0Var.A(8).equals("OpusTags"), "Comment Header should follow ID Header");
            this.g = true;
        }
        this.e = i;
    }

    @Override // ba.j
    public void b(long j, int i) {
        this.c = j;
    }

    @Override // ba.j
    public void c(n nVar, int i) {
        e0 track = nVar.track(i, 1);
        this.b = track;
        track.d(this.a.c);
    }

    @Override // ba.j
    public void seek(long j, long j2) {
        this.c = j;
        this.d = j2;
    }
}
