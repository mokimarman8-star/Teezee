package ba;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class d implements j {
    private static final int[] h = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] i = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private final com.google.android.exoplayer2.source.rtsp.j a;
    private final boolean b;
    private final int c;
    private e0 d;
    private long e = -9223372036854775807L;
    private int g = -1;
    private long f = 0;

    public d(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.a = jVar;
        this.b = "audio/amr-wb".equals(com.google.android.exoplayer2.util.a.e(jVar.c.l));
        this.c = jVar.b;
    }

    public static int d(int i2, boolean z) {
        boolean z2 = (i2 >= 0 && i2 <= 8) || i2 == 15;
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(z ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i2);
        com.google.android.exoplayer2.util.a.b(z2, sb.toString());
        return z ? i[i2] : h[i2];
    }

    private static long e(long j, long j2, long j3, int i2) {
        return j + p0.N0(j2 - j3, 1000000L, i2);
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i2, boolean z) {
        int b;
        com.google.android.exoplayer2.util.a.i(this.d);
        int i3 = this.g;
        if (i3 != -1 && i2 != (b = com.google.android.exoplayer2.source.rtsp.g.b(i3))) {
            s.i("RtpAmrReader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", new Object[]{Integer.valueOf(b), Integer.valueOf(i2)}));
        }
        d0Var.Q(1);
        int d = d((d0Var.h() >> 3) & 15, this.b);
        int a = d0Var.a();
        com.google.android.exoplayer2.util.a.b(a == d, "compound payload not supported currently");
        this.d.c(d0Var, a);
        this.d.e(e(this.f, j, this.e, this.c), 1, a, 0, null);
        this.g = i2;
    }

    @Override // ba.j
    public void b(long j, int i2) {
        this.e = j;
    }

    @Override // ba.j
    public void c(n nVar, int i2) {
        e0 track = nVar.track(i2, 1);
        this.d = track;
        track.d(this.a.c);
    }

    @Override // ba.j
    public void seek(long j, long j2) {
        this.e = j;
        this.f = j2;
    }
}
