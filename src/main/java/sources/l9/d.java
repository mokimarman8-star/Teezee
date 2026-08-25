package l9;

import android.net.Uri;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import i9.a0;
import i9.b0;
import i9.e0;
import i9.l;
import i9.m;
import i9.n;
import i9.q;
import i9.r;
import i9.s;
import i9.t;
import i9.u;
import i9.v;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class d implements l {
    public static final r o = new r() { // from class: l9.c
        @Override // i9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // i9.r
        public final l[] createExtractors() {
            l[] i;
            i = d.i();
            return i;
        }
    };
    private final byte[] a;
    private final d0 b;
    private final boolean c;
    private final s.a d;
    private n e;
    private e0 f;
    private int g;
    private Metadata h;
    private v i;
    private int j;
    private int k;
    private b l;
    private int m;
    private long n;

    public d() {
        this(0);
    }

    public d(int i) {
        this.a = new byte[42];
        this.b = new d0(new byte[32768], 0);
        this.c = (i & 1) != 0;
        this.d = new s.a();
        this.g = 0;
    }

    private long e(d0 d0Var, boolean z) {
        boolean z2;
        com.google.android.exoplayer2.util.a.e(this.i);
        int e = d0Var.e();
        while (e <= d0Var.f() - 16) {
            d0Var.P(e);
            if (s.d(d0Var, this.i, this.k, this.d)) {
                d0Var.P(e);
                return this.d.a;
            }
            e++;
        }
        if (!z) {
            d0Var.P(e);
            return -1L;
        }
        while (e <= d0Var.f() - this.j) {
            d0Var.P(e);
            try {
                z2 = s.d(d0Var, this.i, this.k, this.d);
            } catch (IndexOutOfBoundsException unused) {
                z2 = false;
            }
            if (d0Var.e() <= d0Var.f() ? z2 : false) {
                d0Var.P(e);
                return this.d.a;
            }
            e++;
        }
        d0Var.P(d0Var.f());
        return -1L;
    }

    private void f(m mVar) {
        this.k = t.b(mVar);
        ((n) p0.j(this.e)).g(g(mVar.getPosition(), mVar.getLength()));
        this.g = 5;
    }

    private b0 g(long j, long j2) {
        com.google.android.exoplayer2.util.a.e(this.i);
        v vVar = this.i;
        if (vVar.k != null) {
            return new u(vVar, j);
        }
        if (j2 == -1 || vVar.j <= 0) {
            return new b0.b(vVar.f());
        }
        b bVar = new b(vVar, this.k, j, j2);
        this.l = bVar;
        return bVar.b();
    }

    private void h(m mVar) {
        byte[] bArr = this.a;
        mVar.peekFully(bArr, 0, bArr.length);
        mVar.resetPeekPosition();
        this.g = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] i() {
        return new l[]{new d()};
    }

    private void j() {
        ((e0) p0.j(this.f)).e((this.n * 1000000) / ((v) p0.j(this.i)).e, 1, this.m, 0, null);
    }

    private int k(m mVar, a0 a0Var) {
        boolean z;
        com.google.android.exoplayer2.util.a.e(this.f);
        com.google.android.exoplayer2.util.a.e(this.i);
        b bVar = this.l;
        if (bVar != null && bVar.d()) {
            return this.l.c(mVar, a0Var);
        }
        if (this.n == -1) {
            this.n = s.i(mVar, this.i);
            return 0;
        }
        int f = this.b.f();
        if (f < 32768) {
            int read = mVar.read(this.b.d(), f, 32768 - f);
            z = read == -1;
            if (!z) {
                this.b.O(f + read);
            } else if (this.b.a() == 0) {
                j();
                return -1;
            }
        } else {
            z = false;
        }
        int e = this.b.e();
        int i = this.m;
        int i2 = this.j;
        if (i < i2) {
            d0 d0Var = this.b;
            d0Var.Q(Math.min(i2 - i, d0Var.a()));
        }
        long e2 = e(this.b, z);
        int e3 = this.b.e() - e;
        this.b.P(e);
        this.f.c(this.b, e3);
        this.m += e3;
        if (e2 != -1) {
            j();
            this.m = 0;
            this.n = e2;
        }
        if (this.b.a() < 16) {
            int a = this.b.a();
            System.arraycopy(this.b.d(), this.b.e(), this.b.d(), 0, a);
            this.b.P(0);
            this.b.O(a);
        }
        return 0;
    }

    private void l(m mVar) {
        this.h = t.d(mVar, !this.c);
        this.g = 1;
    }

    private void m(m mVar) {
        t.a aVar = new t.a(this.i);
        boolean z = false;
        while (!z) {
            z = t.e(mVar, aVar);
            this.i = (v) p0.j(aVar.a);
        }
        com.google.android.exoplayer2.util.a.e(this.i);
        this.j = Math.max(this.i.c, 6);
        ((e0) p0.j(this.f)).d(this.i.g(this.a, this.h));
        this.g = 4;
    }

    private void n(m mVar) {
        t.i(mVar);
        this.g = 3;
    }

    @Override // i9.l
    public void b(n nVar) {
        this.e = nVar;
        this.f = nVar.track(0, 1);
        nVar.endTracks();
    }

    @Override // i9.l
    public boolean c(m mVar) {
        t.c(mVar, false);
        return t.a(mVar);
    }

    @Override // i9.l
    public int d(m mVar, a0 a0Var) {
        int i = this.g;
        if (i == 0) {
            l(mVar);
            return 0;
        }
        if (i == 1) {
            h(mVar);
            return 0;
        }
        if (i == 2) {
            n(mVar);
            return 0;
        }
        if (i == 3) {
            m(mVar);
            return 0;
        }
        if (i == 4) {
            f(mVar);
            return 0;
        }
        if (i == 5) {
            return k(mVar, a0Var);
        }
        throw new IllegalStateException();
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            b bVar = this.l;
            if (bVar != null) {
                bVar.h(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.b.L(0);
    }
}
