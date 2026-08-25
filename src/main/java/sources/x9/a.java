package x9;

import com.google.android.exoplayer2.p1;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class a extends n {
    public final long k;
    public final long l;
    private c m;
    private int[] n;

    public a(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, p1 p1Var, int i, Object obj, long j, long j2, long j3, long j4, long j5) {
        super(kVar, nVar, p1Var, i, obj, j, j2, j5);
        this.k = j3;
        this.l = j4;
    }

    public final int g(int i) {
        return ((int[]) com.google.android.exoplayer2.util.a.i(this.n))[i];
    }

    protected final c h() {
        return (c) com.google.android.exoplayer2.util.a.i(this.m);
    }

    public void i(c cVar) {
        this.m = cVar;
        this.n = cVar.a();
    }
}
