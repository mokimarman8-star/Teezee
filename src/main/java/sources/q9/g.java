package q9;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.x;
import i9.a0;
import i9.b0;
import i9.e0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import q9.a;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class g implements i9.l {
    public static final i9.r I = new i9.r() { // from class: q9.e
        @Override // i9.r
        public /* synthetic */ i9.l[] c(Uri uri, Map map) {
            return i9.q.a(this, uri, map);
        }

        @Override // i9.r
        public final i9.l[] createExtractors() {
            i9.l[] k;
            k = g.k();
            return k;
        }
    };
    private static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final p1 K = new p1.b().e0("application/x-emsg").E();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private i9.n E;
    private e0[] F;
    private e0[] G;
    private boolean H;
    private final int a;
    private final o b;
    private final List c;
    private final SparseArray d;
    private final d0 e;
    private final d0 f;
    private final d0 g;
    private final byte[] h;
    private final d0 i;
    private final l0 j;
    private final com.google.android.exoplayer2.metadata.emsg.b k;
    private final d0 l;
    private final ArrayDeque m;
    private final ArrayDeque n;
    private final e0 o;
    private int p;
    private int q;
    private long r;
    private int s;
    private d0 t;
    private long u;
    private int v;
    private long w;
    private long x;
    private long y;
    private b z;

    private static final class a {
        public final long a;
        public final boolean b;
        public final int c;

        public a(long j, boolean z, int i) {
            this.a = j;
            this.b = z;
            this.c = i;
        }
    }

    private static final class b {
        public final e0 a;
        public r d;
        public c e;
        public int f;
        public int g;
        public int h;
        public int i;
        private boolean l;
        public final q b = new q();
        public final d0 c = new d0();
        private final d0 j = new d0(1);
        private final d0 k = new d0();

        public b(e0 e0Var, r rVar, c cVar) {
            this.a = e0Var;
            this.d = rVar;
            this.e = cVar;
            j(rVar, cVar);
        }

        public int c() {
            int i = !this.l ? this.d.g[this.f] : this.b.k[this.f] ? 1 : 0;
            return g() != null ? i | MemoryConstants.GB : i;
        }

        public long d() {
            return !this.l ? this.d.c[this.f] : this.b.g[this.h];
        }

        public long e() {
            return !this.l ? this.d.f[this.f] : this.b.c(this.f);
        }

        public int f() {
            return !this.l ? this.d.d[this.f] : this.b.i[this.f];
        }

        public p g() {
            if (!this.l) {
                return null;
            }
            int i = ((c) p0.j(this.b.a)).a;
            p pVar = this.b.n;
            if (pVar == null) {
                pVar = this.d.a.a(i);
            }
            if (pVar == null || !pVar.a) {
                return null;
            }
            return pVar;
        }

        public boolean h() {
            this.f++;
            if (!this.l) {
                return false;
            }
            int i = this.g + 1;
            this.g = i;
            int[] iArr = this.b.h;
            int i2 = this.h;
            if (i != iArr[i2]) {
                return true;
            }
            this.h = i2 + 1;
            this.g = 0;
            return false;
        }

        public int i(int i, int i2) {
            d0 d0Var;
            p g = g();
            if (g == null) {
                return 0;
            }
            int i3 = g.d;
            if (i3 != 0) {
                d0Var = this.b.o;
            } else {
                byte[] bArr = (byte[]) p0.j(g.e);
                this.k.N(bArr, bArr.length);
                d0 d0Var2 = this.k;
                i3 = bArr.length;
                d0Var = d0Var2;
            }
            boolean g2 = this.b.g(this.f);
            boolean z = g2 || i2 != 0;
            this.j.d()[0] = (byte) ((z ? 128 : 0) | i3);
            this.j.P(0);
            this.a.f(this.j, 1, 1);
            this.a.f(d0Var, i3, 1);
            if (!z) {
                return i3 + 1;
            }
            if (!g2) {
                this.c.L(8);
                byte[] d = this.c.d();
                d[0] = 0;
                d[1] = 1;
                d[2] = (byte) ((i2 >> 8) & 255);
                d[3] = (byte) (i2 & 255);
                d[4] = (byte) ((i >> 24) & 255);
                d[5] = (byte) ((i >> 16) & 255);
                d[6] = (byte) ((i >> 8) & 255);
                d[7] = (byte) (i & 255);
                this.a.f(this.c, 8, 1);
                return i3 + 9;
            }
            d0 d0Var3 = this.b.o;
            int J = d0Var3.J();
            d0Var3.Q(-2);
            int i4 = (J * 6) + 2;
            if (i2 != 0) {
                this.c.L(i4);
                byte[] d2 = this.c.d();
                d0Var3.j(d2, 0, i4);
                int i5 = (((d2[2] & 255) << 8) | (d2[3] & 255)) + i2;
                d2[2] = (byte) ((i5 >> 8) & 255);
                d2[3] = (byte) (i5 & 255);
                d0Var3 = this.c;
            }
            this.a.f(d0Var3, i4, 1);
            return i3 + 1 + i4;
        }

        public void j(r rVar, c cVar) {
            this.d = rVar;
            this.e = cVar;
            this.a.d(rVar.a.f);
            k();
        }

        public void k() {
            this.b.f();
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }

        public void l(long j) {
            int i = this.f;
            while (true) {
                q qVar = this.b;
                if (i >= qVar.f || qVar.c(i) >= j) {
                    return;
                }
                if (this.b.k[i]) {
                    this.i = i;
                }
                i++;
            }
        }

        public void m() {
            p g = g();
            if (g == null) {
                return;
            }
            d0 d0Var = this.b.o;
            int i = g.d;
            if (i != 0) {
                d0Var.Q(i);
            }
            if (this.b.g(this.f)) {
                d0Var.Q(d0Var.J() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            p a = this.d.a.a(((c) p0.j(this.b.a)).a);
            this.a.d(this.d.a.f.b().M(drmInitData.copyWithSchemeType(a != null ? a.b : null)).E());
        }
    }

    public g() {
        this(0);
    }

    public g(int i) {
        this(i, null);
    }

    public g(int i, l0 l0Var) {
        this(i, l0Var, null, Collections.emptyList());
    }

    public g(int i, l0 l0Var, o oVar) {
        this(i, l0Var, oVar, Collections.emptyList());
    }

    public g(int i, l0 l0Var, o oVar, List list) {
        this(i, l0Var, oVar, list, null);
    }

    public g(int i, l0 l0Var, o oVar, List list, e0 e0Var) {
        this.a = i;
        this.j = l0Var;
        this.b = oVar;
        this.c = Collections.unmodifiableList(list);
        this.o = e0Var;
        this.k = new com.google.android.exoplayer2.metadata.emsg.b();
        this.l = new d0(16);
        this.e = new d0(x.a);
        this.f = new d0(5);
        this.g = new d0();
        byte[] bArr = new byte[16];
        this.h = bArr;
        this.i = new d0(bArr);
        this.m = new ArrayDeque();
        this.n = new ArrayDeque();
        this.d = new SparseArray();
        this.x = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.E = i9.n.i1;
        this.F = new e0[0];
        this.G = new e0[0];
    }

    private static long A(d0 d0Var) {
        d0Var.P(8);
        return q9.a.c(d0Var.n()) == 1 ? d0Var.I() : d0Var.F();
    }

    private static b B(d0 d0Var, SparseArray sparseArray, boolean z) {
        d0Var.P(8);
        int b2 = q9.a.b(d0Var.n());
        b bVar = (b) (z ? sparseArray.valueAt(0) : sparseArray.get(d0Var.n()));
        if (bVar == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long I2 = d0Var.I();
            q qVar = bVar.b;
            qVar.c = I2;
            qVar.d = I2;
        }
        c cVar = bVar.e;
        bVar.b.a = new c((b2 & 2) != 0 ? d0Var.n() - 1 : cVar.a, (b2 & 8) != 0 ? d0Var.n() : cVar.b, (b2 & 16) != 0 ? d0Var.n() : cVar.c, (b2 & 32) != 0 ? d0Var.n() : cVar.d);
        return bVar;
    }

    private static void C(a.C0062a c0062a, SparseArray sparseArray, boolean z, int i, byte[] bArr) {
        b B = B(((a.b) com.google.android.exoplayer2.util.a.e(c0062a.g(1952868452))).b, sparseArray, z);
        if (B == null) {
            return;
        }
        q qVar = B.b;
        long j = qVar.q;
        boolean z2 = qVar.r;
        B.k();
        B.l = true;
        a.b g = c0062a.g(1952867444);
        if (g == null || (i & 2) != 0) {
            qVar.q = j;
            qVar.r = z2;
        } else {
            qVar.q = A(g.b);
            qVar.r = true;
        }
        F(c0062a, B, i);
        p a2 = B.d.a.a(((c) com.google.android.exoplayer2.util.a.e(qVar.a)).a);
        a.b g2 = c0062a.g(1935763834);
        if (g2 != null) {
            v((p) com.google.android.exoplayer2.util.a.e(a2), g2.b, qVar);
        }
        a.b g3 = c0062a.g(1935763823);
        if (g3 != null) {
            u(g3.b, qVar);
        }
        a.b g4 = c0062a.g(1936027235);
        if (g4 != null) {
            y(g4.b, qVar);
        }
        w(c0062a, a2 != null ? a2.b : null, qVar);
        int size = c0062a.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = (a.b) c0062a.c.get(i2);
            if (bVar.a == 1970628964) {
                G(bVar.b, qVar, bArr);
            }
        }
    }

    private static Pair D(d0 d0Var) {
        d0Var.P(12);
        return Pair.create(Integer.valueOf(d0Var.n()), new c(d0Var.n() - 1, d0Var.n(), d0Var.n(), d0Var.n()));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int E(b bVar, int i, int i2, d0 d0Var, int i3) {
        long j;
        long j2;
        int i4;
        int i5;
        boolean z;
        int i6;
        boolean z2;
        int i7;
        boolean z3;
        boolean z4;
        boolean z5;
        int i10;
        b bVar2 = bVar;
        d0Var.P(8);
        int b2 = q9.a.b(d0Var.n());
        o oVar = bVar2.d.a;
        q qVar = bVar2.b;
        c cVar = (c) p0.j(qVar.a);
        qVar.h[i] = d0Var.H();
        long[] jArr = qVar.g;
        long j3 = qVar.c;
        jArr[i] = j3;
        if ((b2 & 1) != 0) {
            jArr[i] = j3 + d0Var.n();
        }
        boolean z6 = (b2 & 4) != 0;
        int i11 = cVar.d;
        if (z6) {
            i11 = d0Var.n();
        }
        boolean z10 = (b2 & 256) != 0;
        boolean z11 = (b2 & 512) != 0;
        boolean z12 = (b2 & MemoryConstants.KB) != 0;
        boolean z13 = (b2 & 2048) != 0;
        long[] jArr2 = oVar.h;
        if (jArr2 == null || jArr2.length != 1) {
            j = 0;
        } else {
            j = 0;
            if (jArr2[0] == 0) {
                j2 = ((long[]) p0.j(oVar.i))[0];
                int[] iArr = qVar.i;
                long[] jArr3 = qVar.j;
                boolean[] zArr = qVar.k;
                int i12 = i11;
                boolean z14 = (oVar.b == 2 || (i2 & 1) == 0) ? false : true;
                i4 = i3 + qVar.h[i];
                boolean z15 = z14;
                long j4 = oVar.c;
                long j5 = qVar.q;
                i5 = i3;
                while (i5 < i4) {
                    int e = e(z10 ? d0Var.n() : cVar.b);
                    if (z11) {
                        i6 = d0Var.n();
                        z = z10;
                    } else {
                        z = z10;
                        i6 = cVar.c;
                    }
                    int e2 = e(i6);
                    if (z12) {
                        z2 = z6;
                        i7 = d0Var.n();
                    } else if (i5 == 0 && z6) {
                        z2 = z6;
                        i7 = i12;
                    } else {
                        z2 = z6;
                        i7 = cVar.d;
                    }
                    if (z13) {
                        z3 = z13;
                        z4 = z11;
                        z5 = z12;
                        i10 = d0Var.n();
                    } else {
                        z3 = z13;
                        z4 = z11;
                        z5 = z12;
                        i10 = 0;
                    }
                    long N0 = p0.N0((i10 + j5) - j2, 1000000L, j4);
                    jArr3[i5] = N0;
                    if (!qVar.r) {
                        jArr3[i5] = N0 + bVar2.d.h;
                    }
                    iArr[i5] = e2;
                    zArr[i5] = ((i7 >> 16) & 1) == 0 && (!z15 || i5 == 0);
                    j5 += e;
                    i5++;
                    bVar2 = bVar;
                    z10 = z;
                    z6 = z2;
                    z13 = z3;
                    z11 = z4;
                    z12 = z5;
                }
                qVar.q = j5;
                return i4;
            }
        }
        j2 = j;
        int[] iArr2 = qVar.i;
        long[] jArr32 = qVar.j;
        boolean[] zArr2 = qVar.k;
        int i122 = i11;
        if (oVar.b == 2) {
        }
        i4 = i3 + qVar.h[i];
        boolean z152 = z14;
        long j42 = oVar.c;
        long j52 = qVar.q;
        i5 = i3;
        while (i5 < i4) {
        }
        qVar.q = j52;
        return i4;
    }

    private static void F(a.C0062a c0062a, b bVar, int i) {
        List list = c0062a.c;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            a.b bVar2 = (a.b) list.get(i4);
            if (bVar2.a == 1953658222) {
                d0 d0Var = bVar2.b;
                d0Var.P(12);
                int H = d0Var.H();
                if (H > 0) {
                    i3 += H;
                    i2++;
                }
            }
        }
        bVar.h = 0;
        bVar.g = 0;
        bVar.f = 0;
        bVar.b.e(i2, i3);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            a.b bVar3 = (a.b) list.get(i7);
            if (bVar3.a == 1953658222) {
                i6 = E(bVar, i5, i, bVar3.b, i6);
                i5++;
            }
        }
    }

    private static void G(d0 d0Var, q qVar, byte[] bArr) {
        d0Var.P(8);
        d0Var.j(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            x(d0Var, 16, qVar);
        }
    }

    private void H(long j) {
        while (!this.m.isEmpty() && ((a.C0062a) this.m.peek()).b == j) {
            m((a.C0062a) this.m.pop());
        }
        f();
    }

    private boolean I(i9.m mVar) {
        if (this.s == 0) {
            if (!mVar.readFully(this.l.d(), 0, 8, true)) {
                return false;
            }
            this.s = 8;
            this.l.P(0);
            this.r = this.l.F();
            this.q = this.l.n();
        }
        long j = this.r;
        if (j == 1) {
            mVar.readFully(this.l.d(), 8, 8);
            this.s += 8;
            this.r = this.l.I();
        } else if (j == 0) {
            long length = mVar.getLength();
            if (length == -1 && !this.m.isEmpty()) {
                length = ((a.C0062a) this.m.peek()).b;
            }
            if (length != -1) {
                this.r = (length - mVar.getPosition()) + this.s;
            }
        }
        if (this.r < this.s) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        long position = mVar.getPosition() - this.s;
        int i = this.q;
        if ((i == 1836019558 || i == 1835295092) && !this.H) {
            this.E.g(new b0.b(this.x, position));
            this.H = true;
        }
        if (this.q == 1836019558) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                q qVar = ((b) this.d.valueAt(i2)).b;
                qVar.b = position;
                qVar.d = position;
                qVar.c = position;
            }
        }
        int i3 = this.q;
        if (i3 == 1835295092) {
            this.z = null;
            this.u = position + this.r;
            this.p = 2;
            return true;
        }
        if (M(i3)) {
            long position2 = (mVar.getPosition() + this.r) - 8;
            this.m.push(new a.C0062a(this.q, position2));
            if (this.r == this.s) {
                H(position2);
            } else {
                f();
            }
        } else if (N(this.q)) {
            if (this.s != 8) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
            }
            long j2 = this.r;
            if (j2 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
            }
            d0 d0Var = new d0((int) j2);
            System.arraycopy(this.l.d(), 0, d0Var.d(), 0, 8);
            this.t = d0Var;
            this.p = 1;
        } else {
            if (this.r > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.t = null;
            this.p = 1;
        }
        return true;
    }

    private void J(i9.m mVar) {
        int i = ((int) this.r) - this.s;
        d0 d0Var = this.t;
        if (d0Var != null) {
            mVar.readFully(d0Var.d(), 8, i);
            o(new a.b(this.q, d0Var), mVar.getPosition());
        } else {
            mVar.skipFully(i);
        }
        H(mVar.getPosition());
    }

    private void K(i9.m mVar) {
        int size = this.d.size();
        long j = Long.MAX_VALUE;
        b bVar = null;
        for (int i = 0; i < size; i++) {
            q qVar = ((b) this.d.valueAt(i)).b;
            if (qVar.p) {
                long j2 = qVar.d;
                if (j2 < j) {
                    bVar = (b) this.d.valueAt(i);
                    j = j2;
                }
            }
        }
        if (bVar == null) {
            this.p = 3;
            return;
        }
        int position = (int) (j - mVar.getPosition());
        if (position < 0) {
            throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", (Throwable) null);
        }
        mVar.skipFully(position);
        bVar.b.b(mVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean L(i9.m mVar) {
        int b2;
        b bVar = this.z;
        Throwable th = null;
        if (bVar == null) {
            bVar = i(this.d);
            if (bVar == null) {
                int position = (int) (this.u - mVar.getPosition());
                if (position < 0) {
                    throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", (Throwable) null);
                }
                mVar.skipFully(position);
                f();
                return false;
            }
            int d = (int) (bVar.d() - mVar.getPosition());
            if (d < 0) {
                s.i("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                d = 0;
            }
            mVar.skipFully(d);
            this.z = bVar;
        }
        int i = 4;
        int i2 = 1;
        if (this.p == 3) {
            int f = bVar.f();
            this.A = f;
            if (bVar.f < bVar.i) {
                mVar.skipFully(f);
                bVar.m();
                if (!bVar.h()) {
                    this.z = null;
                }
                this.p = 3;
                return true;
            }
            if (bVar.d.a.g == 1) {
                this.A = f - 8;
                mVar.skipFully(8);
            }
            if ("audio/ac4".equals(bVar.d.a.f.l)) {
                this.B = bVar.i(this.A, 7);
                com.google.android.exoplayer2.audio.c.a(this.A, this.i);
                bVar.a.c(this.i, 7);
                this.B += 7;
            } else {
                this.B = bVar.i(this.A, 0);
            }
            this.A += this.B;
            this.p = 4;
            this.C = 0;
        }
        o oVar = bVar.d.a;
        e0 e0Var = bVar.a;
        long e = bVar.e();
        l0 l0Var = this.j;
        if (l0Var != null) {
            e = l0Var.a(e);
        }
        long j = e;
        if (oVar.j == 0) {
            while (true) {
                int i3 = this.B;
                int i4 = this.A;
                if (i3 >= i4) {
                    break;
                }
                this.B += e0Var.b(mVar, i4 - i3, false);
            }
        } else {
            byte[] d2 = this.f.d();
            d2[0] = 0;
            d2[1] = 0;
            d2[2] = 0;
            int i5 = oVar.j;
            int i6 = i5 + 1;
            int i7 = 4 - i5;
            while (this.B < this.A) {
                int i10 = this.C;
                if (i10 == 0) {
                    mVar.readFully(d2, i7, i6);
                    this.f.P(0);
                    int n = this.f.n();
                    if (n < i2) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", th);
                    }
                    this.C = n - 1;
                    this.e.P(0);
                    e0Var.c(this.e, i);
                    e0Var.c(this.f, i2);
                    this.D = (this.G.length <= 0 || !x.g(oVar.f.l, d2[i])) ? 0 : i2;
                    this.B += 5;
                    this.A += i7;
                } else {
                    if (this.D) {
                        this.g.L(i10);
                        mVar.readFully(this.g.d(), 0, this.C);
                        e0Var.c(this.g, this.C);
                        b2 = this.C;
                        int q = x.q(this.g.d(), this.g.f());
                        this.g.P("video/hevc".equals(oVar.f.l) ? 1 : 0);
                        this.g.O(q);
                        i9.c.a(j, this.g, this.G);
                    } else {
                        b2 = e0Var.b(mVar, i10, false);
                    }
                    this.B += b2;
                    this.C -= b2;
                    th = null;
                    i = 4;
                    i2 = 1;
                }
            }
        }
        int c = bVar.c();
        p g = bVar.g();
        e0Var.e(j, c, this.A, 0, g != null ? g.c : null);
        r(j);
        if (!bVar.h()) {
            this.z = null;
        }
        this.p = 3;
        return true;
    }

    private static boolean M(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    private static boolean N(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    private static int e(int i) {
        if (i >= 0) {
            return i;
        }
        throw ParserException.createForMalformedContainer("Unexpected negative value: " + i, (Throwable) null);
    }

    private void f() {
        this.p = 0;
        this.s = 0;
    }

    private c g(SparseArray sparseArray, int i) {
        return sparseArray.size() == 1 ? (c) sparseArray.valueAt(0) : (c) com.google.android.exoplayer2.util.a.e((c) sparseArray.get(i));
    }

    private static DrmInitData h(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            a.b bVar = (a.b) list.get(i);
            if (bVar.a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] d = bVar.b.d();
                UUID f = l.f(d);
                if (f == null) {
                    s.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(f, "video/mp4", d));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static b i(SparseArray sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            b bVar2 = (b) sparseArray.valueAt(i);
            if ((bVar2.l || bVar2.f != bVar2.d.b) && (!bVar2.l || bVar2.h != bVar2.b.e)) {
                long d = bVar2.d();
                if (d < j) {
                    bVar = bVar2;
                    j = d;
                }
            }
        }
        return bVar;
    }

    private void j() {
        int i;
        e0[] e0VarArr = new e0[2];
        this.F = e0VarArr;
        e0 e0Var = this.o;
        int i2 = 0;
        if (e0Var != null) {
            e0VarArr[0] = e0Var;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.a & 4) != 0) {
            e0VarArr[i] = this.E.track(100, 5);
            i3 = 101;
            i++;
        }
        e0[] e0VarArr2 = (e0[]) p0.G0(this.F, i);
        this.F = e0VarArr2;
        for (e0 e0Var2 : e0VarArr2) {
            e0Var2.d(K);
        }
        this.G = new e0[this.c.size()];
        while (i2 < this.G.length) {
            e0 track = this.E.track(i3, 3);
            track.d((p1) this.c.get(i2));
            this.G[i2] = track;
            i2++;
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i9.l[] k() {
        return new i9.l[]{new g()};
    }

    private void m(a.C0062a c0062a) {
        int i = c0062a.a;
        if (i == 1836019574) {
            q(c0062a);
        } else if (i == 1836019558) {
            p(c0062a);
        } else {
            if (this.m.isEmpty()) {
                return;
            }
            ((a.C0062a) this.m.peek()).d(c0062a);
        }
    }

    private void n(d0 d0Var) {
        long N0;
        String str;
        long N02;
        String str2;
        long F;
        long j;
        if (this.F.length == 0) {
            return;
        }
        d0Var.P(8);
        int c = q9.a.c(d0Var.n());
        if (c == 0) {
            String str3 = (String) com.google.android.exoplayer2.util.a.e(d0Var.x());
            String str4 = (String) com.google.android.exoplayer2.util.a.e(d0Var.x());
            long F2 = d0Var.F();
            N0 = p0.N0(d0Var.F(), 1000000L, F2);
            long j2 = this.y;
            long j3 = j2 != -9223372036854775807L ? j2 + N0 : -9223372036854775807L;
            str = str3;
            N02 = p0.N0(d0Var.F(), 1000L, F2);
            str2 = str4;
            F = d0Var.F();
            j = j3;
        } else {
            if (c != 1) {
                s.i("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + c);
                return;
            }
            long F3 = d0Var.F();
            j = p0.N0(d0Var.I(), 1000000L, F3);
            long N03 = p0.N0(d0Var.F(), 1000L, F3);
            long F4 = d0Var.F();
            str = (String) com.google.android.exoplayer2.util.a.e(d0Var.x());
            N02 = N03;
            F = F4;
            str2 = (String) com.google.android.exoplayer2.util.a.e(d0Var.x());
            N0 = -9223372036854775807L;
        }
        byte[] bArr = new byte[d0Var.a()];
        d0Var.j(bArr, 0, d0Var.a());
        d0 d0Var2 = new d0(this.k.a(new EventMessage(str, str2, N02, F, bArr)));
        int a2 = d0Var2.a();
        for (e0 e0Var : this.F) {
            d0Var2.P(0);
            e0Var.c(d0Var2, a2);
        }
        if (j == -9223372036854775807L) {
            this.n.addLast(new a(N0, true, a2));
            this.v += a2;
            return;
        }
        if (!this.n.isEmpty()) {
            this.n.addLast(new a(j, false, a2));
            this.v += a2;
            return;
        }
        l0 l0Var = this.j;
        if (l0Var != null) {
            j = l0Var.a(j);
        }
        for (e0 e0Var2 : this.F) {
            e0Var2.e(j, 1, a2, 0, null);
        }
    }

    private void o(a.b bVar, long j) {
        if (!this.m.isEmpty()) {
            ((a.C0062a) this.m.peek()).e(bVar);
            return;
        }
        int i = bVar.a;
        if (i != 1936286840) {
            if (i == 1701671783) {
                n(bVar.b);
            }
        } else {
            Pair z = z(bVar.b, j);
            this.y = ((Long) z.first).longValue();
            this.E.g((b0) z.second);
            this.H = true;
        }
    }

    private void p(a.C0062a c0062a) {
        t(c0062a, this.d, this.b != null, this.a, this.h);
        DrmInitData h = h(c0062a.c);
        if (h != null) {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                ((b) this.d.valueAt(i)).n(h);
            }
        }
        if (this.w != -9223372036854775807L) {
            int size2 = this.d.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((b) this.d.valueAt(i2)).l(this.w);
            }
            this.w = -9223372036854775807L;
        }
    }

    private void q(a.C0062a c0062a) {
        int i = 0;
        com.google.android.exoplayer2.util.a.h(this.b == null, "Unexpected moov box.");
        DrmInitData h = h(c0062a.c);
        a.C0062a c0062a2 = (a.C0062a) com.google.android.exoplayer2.util.a.e(c0062a.f(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = c0062a2.c.size();
        long j = -9223372036854775807L;
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = (a.b) c0062a2.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 1953654136) {
                Pair D = D(bVar.b);
                sparseArray.put(((Integer) D.first).intValue(), (c) D.second);
            } else if (i3 == 1835362404) {
                j = s(bVar.b);
            }
        }
        List A = q9.b.A(c0062a, new i9.x(), j, h, (this.a & 16) != 0, false, new com.google.common.base.f() { // from class: q9.f
            public final Object apply(Object obj) {
                return g.this.l((o) obj);
            }
        });
        int size2 = A.size();
        if (this.d.size() != 0) {
            com.google.android.exoplayer2.util.a.g(this.d.size() == size2);
            while (i < size2) {
                r rVar = (r) A.get(i);
                o oVar = rVar.a;
                ((b) this.d.get(oVar.a)).j(rVar, g(sparseArray, oVar.a));
                i++;
            }
            return;
        }
        while (i < size2) {
            r rVar2 = (r) A.get(i);
            o oVar2 = rVar2.a;
            this.d.put(oVar2.a, new b(this.E.track(i, oVar2.b), rVar2, g(sparseArray, oVar2.a)));
            this.x = Math.max(this.x, oVar2.e);
            i++;
        }
        this.E.endTracks();
    }

    private void r(long j) {
        while (!this.n.isEmpty()) {
            a aVar = (a) this.n.removeFirst();
            this.v -= aVar.c;
            long j2 = aVar.a;
            if (aVar.b) {
                j2 += j;
            }
            l0 l0Var = this.j;
            if (l0Var != null) {
                j2 = l0Var.a(j2);
            }
            for (e0 e0Var : this.F) {
                e0Var.e(j2, 1, aVar.c, this.v, null);
            }
        }
    }

    private static long s(d0 d0Var) {
        d0Var.P(8);
        return q9.a.c(d0Var.n()) == 0 ? d0Var.F() : d0Var.I();
    }

    private static void t(a.C0062a c0062a, SparseArray sparseArray, boolean z, int i, byte[] bArr) {
        int size = c0062a.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0062a c0062a2 = (a.C0062a) c0062a.d.get(i2);
            if (c0062a2.a == 1953653094) {
                C(c0062a2, sparseArray, z, i, bArr);
            }
        }
    }

    private static void u(d0 d0Var, q qVar) {
        d0Var.P(8);
        int n = d0Var.n();
        if ((q9.a.b(n) & 1) == 1) {
            d0Var.Q(8);
        }
        int H = d0Var.H();
        if (H == 1) {
            qVar.d += q9.a.c(n) == 0 ? d0Var.F() : d0Var.I();
        } else {
            throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + H, (Throwable) null);
        }
    }

    private static void v(p pVar, d0 d0Var, q qVar) {
        int i;
        int i2 = pVar.d;
        d0Var.P(8);
        if ((q9.a.b(d0Var.n()) & 1) == 1) {
            d0Var.Q(8);
        }
        int D = d0Var.D();
        int H = d0Var.H();
        if (H > qVar.f) {
            throw ParserException.createForMalformedContainer("Saiz sample count " + H + " is greater than fragment sample count" + qVar.f, (Throwable) null);
        }
        if (D == 0) {
            boolean[] zArr = qVar.m;
            i = 0;
            for (int i3 = 0; i3 < H; i3++) {
                int D2 = d0Var.D();
                i += D2;
                zArr[i3] = D2 > i2;
            }
        } else {
            i = D * H;
            Arrays.fill(qVar.m, 0, H, D > i2);
        }
        Arrays.fill(qVar.m, H, qVar.f, false);
        if (i > 0) {
            qVar.d(i);
        }
    }

    private static void w(a.C0062a c0062a, String str, q qVar) {
        byte[] bArr = null;
        d0 d0Var = null;
        d0 d0Var2 = null;
        for (int i = 0; i < c0062a.c.size(); i++) {
            a.b bVar = (a.b) c0062a.c.get(i);
            d0 d0Var3 = bVar.b;
            int i2 = bVar.a;
            if (i2 == 1935828848) {
                d0Var3.P(12);
                if (d0Var3.n() == 1936025959) {
                    d0Var = d0Var3;
                }
            } else if (i2 == 1936158820) {
                d0Var3.P(12);
                if (d0Var3.n() == 1936025959) {
                    d0Var2 = d0Var3;
                }
            }
        }
        if (d0Var == null || d0Var2 == null) {
            return;
        }
        d0Var.P(8);
        int c = q9.a.c(d0Var.n());
        d0Var.Q(4);
        if (c == 1) {
            d0Var.Q(4);
        }
        if (d0Var.n() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
        d0Var2.P(8);
        int c2 = q9.a.c(d0Var2.n());
        d0Var2.Q(4);
        if (c2 == 1) {
            if (d0Var2.F() == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
            }
        } else if (c2 >= 2) {
            d0Var2.Q(4);
        }
        if (d0Var2.F() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        d0Var2.Q(1);
        int D = d0Var2.D();
        int i3 = (D & 240) >> 4;
        int i4 = D & 15;
        boolean z = d0Var2.D() == 1;
        if (z) {
            int D2 = d0Var2.D();
            byte[] bArr2 = new byte[16];
            d0Var2.j(bArr2, 0, 16);
            if (D2 == 0) {
                int D3 = d0Var2.D();
                bArr = new byte[D3];
                d0Var2.j(bArr, 0, D3);
            }
            qVar.l = true;
            qVar.n = new p(z, str, D2, bArr2, i3, i4, bArr);
        }
    }

    private static void x(d0 d0Var, int i, q qVar) {
        d0Var.P(i + 8);
        int b2 = q9.a.b(d0Var.n());
        if ((b2 & 1) != 0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b2 & 2) != 0;
        int H = d0Var.H();
        if (H == 0) {
            Arrays.fill(qVar.m, 0, qVar.f, false);
            return;
        }
        if (H == qVar.f) {
            Arrays.fill(qVar.m, 0, H, z);
            qVar.d(d0Var.a());
            qVar.a(d0Var);
        } else {
            throw ParserException.createForMalformedContainer("Senc sample count " + H + " is different from fragment sample count" + qVar.f, (Throwable) null);
        }
    }

    private static void y(d0 d0Var, q qVar) {
        x(d0Var, 0, qVar);
    }

    private static Pair z(d0 d0Var, long j) {
        long I2;
        long I3;
        d0Var.P(8);
        int c = q9.a.c(d0Var.n());
        d0Var.Q(4);
        long F = d0Var.F();
        if (c == 0) {
            I2 = d0Var.F();
            I3 = d0Var.F();
        } else {
            I2 = d0Var.I();
            I3 = d0Var.I();
        }
        long j2 = I2;
        long j3 = j + I3;
        long N0 = p0.N0(j2, 1000000L, F);
        d0Var.Q(2);
        int J2 = d0Var.J();
        int[] iArr = new int[J2];
        long[] jArr = new long[J2];
        long[] jArr2 = new long[J2];
        long[] jArr3 = new long[J2];
        long j4 = N0;
        int i = 0;
        long j5 = j2;
        while (i < J2) {
            int n = d0Var.n();
            if ((n & Integer.MIN_VALUE) != 0) {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", (Throwable) null);
            }
            long F2 = d0Var.F();
            iArr[i] = n & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            long j6 = j5 + F2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i2 = J2;
            long N02 = p0.N0(j6, 1000000L, F);
            jArr4[i] = N02 - jArr5[i];
            d0Var.Q(4);
            j3 += r1[i];
            i++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            J2 = i2;
            j5 = j6;
            j4 = N02;
        }
        return Pair.create(Long.valueOf(N0), new i9.d(iArr, jArr, jArr2, jArr3));
    }

    @Override // i9.l
    public void b(i9.n nVar) {
        this.E = nVar;
        f();
        j();
        o oVar = this.b;
        if (oVar != null) {
            this.d.put(0, new b(nVar.track(0, oVar.b), new r(this.b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0)));
            this.E.endTracks();
        }
    }

    @Override // i9.l
    public boolean c(i9.m mVar) {
        return n.b(mVar);
    }

    @Override // i9.l
    public int d(i9.m mVar, a0 a0Var) {
        while (true) {
            int i = this.p;
            if (i != 0) {
                if (i == 1) {
                    J(mVar);
                } else if (i == 2) {
                    K(mVar);
                } else if (L(mVar)) {
                    return 0;
                }
            } else if (!I(mVar)) {
                return -1;
            }
        }
    }

    protected o l(o oVar) {
        return oVar;
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            ((b) this.d.valueAt(i)).k();
        }
        this.n.clear();
        this.v = 0;
        this.w = j2;
        this.m.clear();
        f();
    }
}
