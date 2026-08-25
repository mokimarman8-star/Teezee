package r9;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import i9.b0;
import i9.m;
import i9.s;
import i9.t;
import i9.u;
import i9.v;
import java.util.Arrays;
import r9.i;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class b extends i {
    private v n;
    private a o;

    private static final class a implements g {
        private v a;
        private v.a b;
        private long c = -1;
        private long d = -1;

        public a(v vVar, v.a aVar) {
            this.a = vVar;
            this.b = aVar;
        }

        @Override // r9.g
        public long a(m mVar) {
            long j = this.d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.d = -1L;
            return j2;
        }

        public void b(long j) {
            this.c = j;
        }

        @Override // r9.g
        public b0 createSeekMap() {
            com.google.android.exoplayer2.util.a.g(this.c != -1);
            return new u(this.a, this.c);
        }

        @Override // r9.g
        public void startSeek(long j) {
            long[] jArr = this.b.a;
            this.d = jArr[p0.i(jArr, j, true, true)];
        }
    }

    b() {
    }

    private int n(d0 d0Var) {
        int i = (d0Var.d()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            d0Var.Q(4);
            d0Var.K();
        }
        int j = s.j(d0Var, i);
        d0Var.P(0);
        return j;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(d0 d0Var) {
        return d0Var.a() >= 5 && d0Var.D() == 127 && d0Var.F() == 1179402563;
    }

    @Override // r9.i
    protected long f(d0 d0Var) {
        if (o(d0Var.d())) {
            return n(d0Var);
        }
        return -1L;
    }

    @Override // r9.i
    protected boolean h(d0 d0Var, long j, i.b bVar) {
        byte[] d = d0Var.d();
        v vVar = this.n;
        if (vVar == null) {
            v vVar2 = new v(d, 17);
            this.n = vVar2;
            bVar.a = vVar2.g(Arrays.copyOfRange(d, 9, d0Var.f()), null);
            return true;
        }
        if ((d[0] & Byte.MAX_VALUE) == 3) {
            v.a f = t.f(d0Var);
            v b = vVar.b(f);
            this.n = b;
            this.o = new a(b, f);
            return true;
        }
        if (!o(d)) {
            return true;
        }
        a aVar = this.o;
        if (aVar != null) {
            aVar.b(j);
            bVar.b = this.o;
        }
        com.google.android.exoplayer2.util.a.e(bVar.a);
        return false;
    }

    @Override // r9.i
    protected void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }
}
