package s9;

import com.google.android.exoplayer2.p1;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class r implements m {
    private i9.e0 b;
    private boolean c;
    private int e;
    private int f;
    private final com.google.android.exoplayer2.util.d0 a = new com.google.android.exoplayer2.util.d0(10);
    private long d = -9223372036854775807L;

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.b);
        if (this.c) {
            int a = d0Var.a();
            int i = this.f;
            if (i < 10) {
                int min = Math.min(a, 10 - i);
                System.arraycopy(d0Var.d(), d0Var.e(), this.a.d(), this.f, min);
                if (this.f + min == 10) {
                    this.a.P(0);
                    if (73 != this.a.D() || 68 != this.a.D() || 51 != this.a.D()) {
                        com.google.android.exoplayer2.util.s.i("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.a.Q(3);
                        this.e = this.a.C() + 10;
                    }
                }
            }
            int min2 = Math.min(a, this.e - this.f);
            this.b.c(d0Var, min2);
            this.f += min2;
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.d = j;
        }
        this.e = 0;
        this.f = 0;
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        dVar.a();
        i9.e0 track = nVar.track(dVar.c(), 5);
        this.b = track;
        track.d(new p1.b().S(dVar.b()).e0("application/id3").E());
    }

    @Override // s9.m
    public void packetFinished() {
        int i;
        com.google.android.exoplayer2.util.a.i(this.b);
        if (this.c && (i = this.e) != 0 && this.f == i) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                this.b.e(j, 1, i, 0, null);
            }
            this.c = false;
        }
    }

    @Override // s9.m
    public void seek() {
        this.c = false;
        this.d = -9223372036854775807L;
    }
}
