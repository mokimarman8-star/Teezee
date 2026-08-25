package p9;

import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.t;
import i9.b0;
import i9.c0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b implements g {
    private final long a;
    private final t b;
    private final t c;
    private long d;

    public b(long j, long j2, long j3) {
        this.d = j;
        this.a = j3;
        t tVar = new t();
        this.b = tVar;
        t tVar2 = new t();
        this.c = tVar2;
        tVar.a(0L);
        tVar2.a(j2);
    }

    @Override // p9.g
    public long a() {
        return this.a;
    }

    public boolean b(long j) {
        t tVar = this.b;
        return j - tVar.b(tVar.c() - 1) < 100000;
    }

    public void c(long j, long j2) {
        if (b(j)) {
            return;
        }
        this.b.a(j);
        this.c.a(j2);
    }

    void d(long j) {
        this.d = j;
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.d;
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        int f = p0.f(this.b, j, true, true);
        c0 c0Var = new c0(this.b.b(f), this.c.b(f));
        if (c0Var.a == j || f == this.b.c() - 1) {
            return new b0.a(c0Var);
        }
        int i = f + 1;
        return new b0.a(c0Var, new c0(this.b.b(i), this.c.b(i)));
    }

    @Override // p9.g
    public long getTimeUs(long j) {
        return this.b.b(p0.f(this.c, j, true, true));
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return true;
    }
}
