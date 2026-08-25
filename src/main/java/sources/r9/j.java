package r9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.common.collect.ImmutableList;
import i9.h0;
import java.util.ArrayList;
import java.util.Arrays;
import r9.i;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class j extends i {
    private a n;
    private int o;
    private boolean p;
    private h0.d q;
    private h0.b r;

    static final class a {
        public final h0.d a;
        public final h0.b b;
        public final byte[] c;
        public final h0.c[] d;
        public final int e;

        public a(h0.d dVar, h0.b bVar, byte[] bArr, h0.c[] cVarArr, int i) {
            this.a = dVar;
            this.b = bVar;
            this.c = bArr;
            this.d = cVarArr;
            this.e = i;
        }
    }

    j() {
    }

    static void n(d0 d0Var, long j) {
        if (d0Var.b() < d0Var.f() + 4) {
            d0Var.M(Arrays.copyOf(d0Var.d(), d0Var.f() + 4));
        } else {
            d0Var.O(d0Var.f() + 4);
        }
        byte[] d = d0Var.d();
        d[d0Var.f() - 4] = (byte) (j & 255);
        d[d0Var.f() - 3] = (byte) ((j >>> 8) & 255);
        d[d0Var.f() - 2] = (byte) ((j >>> 16) & 255);
        d[d0Var.f() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int o(byte b, a aVar) {
        return !aVar.d[p(b, aVar.e, 1)].a ? aVar.a.g : aVar.a.h;
    }

    static int p(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    public static boolean r(d0 d0Var) {
        try {
            return h0.m(1, d0Var, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // r9.i
    protected void e(long j) {
        super.e(j);
        this.p = j != 0;
        h0.d dVar = this.q;
        this.o = dVar != null ? dVar.g : 0;
    }

    @Override // r9.i
    protected long f(d0 d0Var) {
        if ((d0Var.d()[0] & 1) == 1) {
            return -1L;
        }
        int o = o(d0Var.d()[0], (a) com.google.android.exoplayer2.util.a.i(this.n));
        long j = this.p ? (this.o + o) / 4 : 0;
        n(d0Var, j);
        this.p = true;
        this.o = o;
        return j;
    }

    @Override // r9.i
    protected boolean h(d0 d0Var, long j, i.b bVar) {
        if (this.n != null) {
            com.google.android.exoplayer2.util.a.e(bVar.a);
            return false;
        }
        a q = q(d0Var);
        this.n = q;
        if (q == null) {
            return true;
        }
        h0.d dVar = q.a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.j);
        arrayList.add(q.c);
        bVar.a = new p1.b().e0("audio/vorbis").G(dVar.e).Z(dVar.d).H(dVar.b).f0(dVar.c).T(arrayList).X(h0.c(ImmutableList.copyOf(q.b.b))).E();
        return true;
    }

    @Override // r9.i
    protected void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    a q(d0 d0Var) {
        h0.d dVar = this.q;
        if (dVar == null) {
            this.q = h0.k(d0Var);
            return null;
        }
        h0.b bVar = this.r;
        if (bVar == null) {
            this.r = h0.i(d0Var);
            return null;
        }
        byte[] bArr = new byte[d0Var.f()];
        System.arraycopy(d0Var.d(), 0, bArr, 0, d0Var.f());
        return new a(dVar, bVar, bArr, h0.l(d0Var, dVar.b), h0.a(r4.length - 1));
    }
}
