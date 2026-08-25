package s9;

import com.google.android.exoplayer2.p1;
import java.util.List;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class k0 {
    private final List a;
    private final i9.e0[] b;

    public k0(List list) {
        this.a = list;
        this.b = new i9.e0[list.size()];
    }

    public void a(long j, com.google.android.exoplayer2.util.d0 d0Var) {
        if (d0Var.a() < 9) {
            return;
        }
        int n = d0Var.n();
        int n2 = d0Var.n();
        int D = d0Var.D();
        if (n == 434 && n2 == 1195456820 && D == 3) {
            i9.c.b(j, d0Var, this.b);
        }
    }

    public void b(i9.n nVar, i0.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            dVar.a();
            i9.e0 track = nVar.track(dVar.c(), 3);
            p1 p1Var = (p1) this.a.get(i);
            String str = p1Var.l;
            com.google.android.exoplayer2.util.a.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            track.d(new p1.b().S(dVar.b()).e0(str).g0(p1Var.d).V(p1Var.c).F(p1Var.D).T(p1Var.n).E());
            this.b[i] = track;
        }
    }
}
