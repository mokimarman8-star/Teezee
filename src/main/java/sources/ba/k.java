package ba;

import android.util.Log;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import i9.e0;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class k implements j {
    private final com.google.android.exoplayer2.source.rtsp.j a;
    private e0 b;
    private long c = -9223372036854775807L;
    private long d = 0;
    private int e = -1;

    public k(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.a = jVar;
    }

    private static long d(long j, long j2, long j3, int i) {
        return j + p0.N0(j2 - j3, 1000000L, i);
    }

    @Override // ba.j
    public void a(d0 d0Var, long j, int i, boolean z) {
        int b;
        com.google.android.exoplayer2.util.a.e(this.b);
        int i2 = this.e;
        if (i2 != -1 && i != (b = com.google.android.exoplayer2.source.rtsp.g.b(i2))) {
            Log.w("RtpPcmReader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", new Object[]{Integer.valueOf(b), Integer.valueOf(i)}));
        }
        long d = d(this.d, j, this.c, this.a.b);
        int a = d0Var.a();
        this.b.c(d0Var, a);
        this.b.e(d, 1, a, 0, null);
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
