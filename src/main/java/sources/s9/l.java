package s9;

import com.google.android.exoplayer2.p1;
import java.util.Collections;
import java.util.List;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class l implements m {
    private final List a;
    private final i9.e0[] b;
    private boolean c;
    private int d;
    private int e;
    private long f = -9223372036854775807L;

    public l(List list) {
        this.a = list;
        this.b = new i9.e0[list.size()];
    }

    private boolean a(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        if (d0Var.a() == 0) {
            return false;
        }
        if (d0Var.D() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        if (this.c) {
            if (this.d != 2 || a(d0Var, 32)) {
                if (this.d != 1 || a(d0Var, 0)) {
                    int e = d0Var.e();
                    int a = d0Var.a();
                    for (i9.e0 e0Var : this.b) {
                        d0Var.P(e);
                        e0Var.c(d0Var, a);
                    }
                    this.e += a;
                }
            }
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.f = j;
        }
        this.e = 0;
        this.d = 2;
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            i0.a aVar = (i0.a) this.a.get(i);
            dVar.a();
            i9.e0 track = nVar.track(dVar.c(), 3);
            track.d(new p1.b().S(dVar.b()).e0("application/dvbsubs").T(Collections.singletonList(aVar.c)).V(aVar.a).E());
            this.b[i] = track;
        }
    }

    @Override // s9.m
    public void packetFinished() {
        if (this.c) {
            if (this.f != -9223372036854775807L) {
                for (i9.e0 e0Var : this.b) {
                    e0Var.e(this.f, 1, this.e, 0, null);
                }
            }
            this.c = false;
        }
    }

    @Override // s9.m
    public void seek() {
        this.c = false;
        this.f = -9223372036854775807L;
    }
}
