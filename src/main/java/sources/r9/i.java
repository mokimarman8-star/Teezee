package r9;

import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import i9.a0;
import i9.b0;
import i9.e0;
import i9.m;
import i9.n;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class i {
    private e0 b;
    private n c;
    private g d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private long k;
    private boolean l;
    private boolean m;
    private final e a = new e();
    private b j = new b();

    static class b {
        p1 a;
        g b;

        b() {
        }
    }

    private static final class c implements g {
        private c() {
        }

        @Override // r9.g
        public long a(m mVar) {
            return -1L;
        }

        @Override // r9.g
        public b0 createSeekMap() {
            return new b0.b(-9223372036854775807L);
        }

        @Override // r9.g
        public void startSeek(long j) {
        }
    }

    private void a() {
        com.google.android.exoplayer2.util.a.i(this.b);
        p0.j(this.c);
    }

    private boolean i(m mVar) {
        while (this.a.d(mVar)) {
            this.k = mVar.getPosition() - this.f;
            if (!h(this.a.c(), this.f, this.j)) {
                return true;
            }
            this.f = mVar.getPosition();
        }
        this.h = 3;
        return false;
    }

    private int j(m mVar) {
        if (!i(mVar)) {
            return -1;
        }
        p1 p1Var = this.j.a;
        this.i = p1Var.z;
        if (!this.m) {
            this.b.d(p1Var);
            this.m = true;
        }
        g gVar = this.j.b;
        if (gVar != null) {
            this.d = gVar;
        } else if (mVar.getLength() == -1) {
            this.d = new c();
        } else {
            f b2 = this.a.b();
            this.d = new r9.a(this, this.f, mVar.getLength(), b2.h + b2.i, b2.c, (b2.b & 4) != 0);
        }
        this.h = 2;
        this.a.f();
        return 0;
    }

    private int k(m mVar, a0 a0Var) {
        long a2 = this.d.a(mVar);
        if (a2 >= 0) {
            a0Var.a = a2;
            return 1;
        }
        if (a2 < -1) {
            e(-(a2 + 2));
        }
        if (!this.l) {
            this.c.g((b0) com.google.android.exoplayer2.util.a.i(this.d.createSeekMap()));
            this.l = true;
        }
        if (this.k <= 0 && !this.a.d(mVar)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        d0 c2 = this.a.c();
        long f = f(c2);
        if (f >= 0) {
            long j = this.g;
            if (j + f >= this.e) {
                long b2 = b(j);
                this.b.c(c2, c2.f());
                this.b.e(b2, 1, c2.f(), 0, null);
                this.e = -1L;
            }
        }
        this.g += f;
        return 0;
    }

    protected long b(long j) {
        return (j * 1000000) / this.i;
    }

    protected long c(long j) {
        return (this.i * j) / 1000000;
    }

    void d(n nVar, e0 e0Var) {
        this.c = nVar;
        this.b = e0Var;
        l(true);
    }

    protected void e(long j) {
        this.g = j;
    }

    protected abstract long f(d0 d0Var);

    final int g(m mVar, a0 a0Var) {
        a();
        int i = this.h;
        if (i == 0) {
            return j(mVar);
        }
        if (i == 1) {
            mVar.skipFully((int) this.f);
            this.h = 2;
            return 0;
        }
        if (i == 2) {
            p0.j(this.d);
            return k(mVar, a0Var);
        }
        if (i == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    protected abstract boolean h(d0 d0Var, long j, b bVar);

    protected void l(boolean z) {
        if (z) {
            this.j = new b();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }

    final void m(long j, long j2) {
        this.a.e();
        if (j == 0) {
            l(!this.l);
        } else if (this.h != 0) {
            this.e = c(j2);
            ((g) p0.j(this.d)).startSeek(this.e);
            this.h = 2;
        }
    }
}
