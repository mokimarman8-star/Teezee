package x9;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.upstream.i0;
import x9.g;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class m extends f {
    private final g j;
    private g.b k;
    private long l;
    private volatile boolean m;

    public m(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, p1 p1Var, int i, Object obj, g gVar) {
        super(kVar, nVar, 2, p1Var, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.j = gVar;
    }

    public void cancelLoad() {
        this.m = true;
    }

    public void e(g.b bVar) {
        this.k = bVar;
    }

    public void load() {
        if (this.l == 0) {
            this.j.d(this.k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            com.google.android.exoplayer2.upstream.n e = this.b.e(this.l);
            i0 i0Var = this.i;
            i9.f fVar = new i9.f(i0Var, e.g, i0Var.a(e));
            while (!this.m && this.j.a(fVar)) {
                try {
                } finally {
                    this.l = fVar.getPosition() - this.b.g;
                }
            }
        } finally {
            com.google.android.exoplayer2.upstream.m.a(this.i);
        }
    }
}
