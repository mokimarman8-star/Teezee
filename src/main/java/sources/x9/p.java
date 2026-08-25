package x9;

import com.google.android.exoplayer2.p1;
import i9.e0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class p extends a {
    private final int o;
    private final p1 p;
    private long q;
    private boolean r;

    public p(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, p1 p1Var, int i, Object obj, long j, long j2, long j3, int i2, p1 p1Var2) {
        super(kVar, nVar, p1Var, i, obj, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.o = i2;
        this.p = p1Var2;
    }

    public void cancelLoad() {
    }

    @Override // x9.n
    public boolean f() {
        return this.r;
    }

    public void load() {
        c h = h();
        h.b(0L);
        e0 track = h.track(0, this.o);
        track.d(this.p);
        try {
            long a = this.i.a(this.b.e(this.q));
            if (a != -1) {
                a += this.q;
            }
            i9.f fVar = new i9.f(this.i, this.q, a);
            for (int i = 0; i != -1; i = track.b(fVar, Integer.MAX_VALUE, true)) {
                this.q += i;
            }
            track.e(this.g, 1, (int) this.q, 0, null);
            com.google.android.exoplayer2.upstream.m.a(this.i);
            this.r = true;
        } catch (Throwable th) {
            com.google.android.exoplayer2.upstream.m.a(this.i);
            throw th;
        }
    }
}
