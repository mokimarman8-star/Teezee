package x9;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.upstream.i0;
import x9.g;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class k extends a {
    private final int o;
    private final long p;
    private final g q;
    private long r;
    private volatile boolean s;
    private boolean t;

    public k(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, p1 p1Var, int i, Object obj, long j, long j2, long j3, long j4, long j5, int i2, long j6, g gVar) {
        super(kVar, nVar, p1Var, i, obj, j, j2, j3, j4, j5);
        this.o = i2;
        this.p = j6;
        this.q = gVar;
    }

    public final void cancelLoad() {
        this.s = true;
    }

    @Override // x9.n
    public long e() {
        return this.j + this.o;
    }

    @Override // x9.n
    public boolean f() {
        return this.t;
    }

    protected g.b j(c cVar) {
        return cVar;
    }

    public final void load() {
        if (this.r == 0) {
            c h = h();
            h.b(this.p);
            g gVar = this.q;
            g.b j = j(h);
            long j2 = this.k;
            long j3 = j2 == -9223372036854775807L ? -9223372036854775807L : j2 - this.p;
            long j4 = this.l;
            gVar.d(j, j3, j4 == -9223372036854775807L ? -9223372036854775807L : j4 - this.p);
        }
        try {
            com.google.android.exoplayer2.upstream.n e = this.b.e(this.r);
            i0 i0Var = this.i;
            i9.f fVar = new i9.f(i0Var, e.g, i0Var.a(e));
            do {
                try {
                    if (this.s) {
                        break;
                    }
                } finally {
                    this.r = fVar.getPosition() - this.b.g;
                }
            } while (this.q.a(fVar));
            com.google.android.exoplayer2.upstream.m.a(this.i);
            this.t = !this.s;
        } catch (Throwable th) {
            com.google.android.exoplayer2.upstream.m.a(this.i);
            throw th;
        }
    }
}
