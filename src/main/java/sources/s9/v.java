package s9;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class v implements b0 {
    private p1 a;
    private l0 b;
    private i9.e0 c;

    public v(String str) {
        this.a = new p1.b().e0(str).E();
    }

    private void c() {
        com.google.android.exoplayer2.util.a.i(this.b);
        p0.j(this.c);
    }

    @Override // s9.b0
    public void a(l0 l0Var, i9.n nVar, i0.d dVar) {
        this.b = l0Var;
        dVar.a();
        i9.e0 track = nVar.track(dVar.c(), 5);
        this.c = track;
        track.d(this.a);
    }

    @Override // s9.b0
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        c();
        long d = this.b.d();
        long e = this.b.e();
        if (d == -9223372036854775807L || e == -9223372036854775807L) {
            return;
        }
        p1 p1Var = this.a;
        if (e != p1Var.p) {
            p1 E = p1Var.b().i0(e).E();
            this.a = E;
            this.c.d(E);
        }
        int a = d0Var.a();
        this.c.c(d0Var, a);
        this.c.e(d, 1, a, 0, null);
    }
}
