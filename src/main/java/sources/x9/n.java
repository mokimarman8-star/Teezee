package x9;

import com.google.android.exoplayer2.p1;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class n extends f {
    public final long j;

    public n(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, p1 p1Var, int i, Object obj, long j, long j2, long j3) {
        super(kVar, nVar, 1, p1Var, i, obj, j, j2);
        com.google.android.exoplayer2.util.a.e(p1Var);
        this.j = j3;
    }

    public long e() {
        long j = this.j;
        if (j != -1) {
            return 1 + j;
        }
        return -1L;
    }

    public abstract boolean f();
}
