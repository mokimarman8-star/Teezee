package q9;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.x;
import i9.a0;
import i9.b0;
import i9.c0;
import i9.e0;
import i9.f0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q9.a;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class k implements i9.l, b0 {
    public static final i9.r y = new i9.r() { // from class: q9.j
        @Override // i9.r
        public /* synthetic */ i9.l[] c(Uri uri, Map map) {
            return i9.q.a(this, uri, map);
        }

        @Override // i9.r
        public final i9.l[] createExtractors() {
            i9.l[] n;
            n = k.n();
            return n;
        }
    };
    private final int a;
    private final d0 b;
    private final d0 c;
    private final d0 d;
    private final d0 e;
    private final ArrayDeque f;
    private final m g;
    private final List h;
    private int i;
    private int j;
    private long k;
    private int l;
    private d0 m;
    private int n;
    private int o;
    private int p;
    private int q;
    private i9.n r;
    private a[] s;
    private long[][] t;
    private int u;
    private long v;
    private int w;
    private MotionPhotoMetadata x;

    private static final class a {
        public final o a;
        public final r b;
        public final e0 c;
        public final f0 d;
        public int e;

        public a(o oVar, r rVar, e0 e0Var) {
            this.a = oVar;
            this.b = rVar;
            this.c = e0Var;
            this.d = "audio/true-hd".equals(oVar.f.l) ? new f0() : null;
        }
    }

    public k() {
        this(0);
    }

    public k(int i) {
        this.a = i;
        this.i = (i & 4) != 0 ? 3 : 0;
        this.g = new m();
        this.h = new ArrayList();
        this.e = new d0(16);
        this.f = new ArrayDeque();
        this.b = new d0(x.a);
        this.c = new d0(4);
        this.d = new d0();
        this.n = -1;
        this.r = i9.n.i1;
        this.s = new a[0];
    }

    private static boolean A(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    private void B(a aVar, long j) {
        r rVar = aVar.b;
        int a2 = rVar.a(j);
        if (a2 == -1) {
            a2 = rVar.b(j);
        }
        aVar.e = a2;
    }

    private static int g(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] h(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            jArr[i] = new long[aVarArr[i].b.b];
            jArr2[i] = aVarArr[i].b.f[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < aVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            long[] jArr3 = jArr[i3];
            jArr3[i5] = j;
            r rVar = aVarArr[i3].b;
            j += rVar.d[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr3.length) {
                jArr2[i3] = rVar.f[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private void i() {
        this.i = 0;
        this.l = 0;
    }

    private static int k(r rVar, long j) {
        int a2 = rVar.a(j);
        return a2 == -1 ? rVar.b(j) : a2;
    }

    private int l(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.s;
            if (i3 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i3];
            int i4 = aVar.e;
            r rVar = aVar.b;
            if (i4 != rVar.b) {
                long j5 = rVar.c[i4];
                long j6 = ((long[][]) p0.j(this.t))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i2 = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o m(o oVar) {
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i9.l[] n() {
        return new i9.l[]{new k()};
    }

    private static long o(r rVar, long j, long j2) {
        int k = k(rVar, j);
        return k == -1 ? j2 : Math.min(rVar.c[k], j2);
    }

    private void p(i9.m mVar) {
        this.d.L(8);
        mVar.peekFully(this.d.d(), 0, 8);
        b.e(this.d);
        mVar.skipFully(this.d.e());
        mVar.resetPeekPosition();
    }

    private void q(long j) {
        while (!this.f.isEmpty() && ((a.C0062a) this.f.peek()).b == j) {
            a.C0062a c0062a = (a.C0062a) this.f.pop();
            if (c0062a.a == 1836019574) {
                t(c0062a);
                this.f.clear();
                this.i = 2;
            } else if (!this.f.isEmpty()) {
                ((a.C0062a) this.f.peek()).d(c0062a);
            }
        }
        if (this.i != 2) {
            i();
        }
    }

    private void r() {
        if (this.w != 2 || (this.a & 2) == 0) {
            return;
        }
        this.r.track(0, 4).d(new p1.b().X(this.x == null ? null : new Metadata(new Metadata.Entry[]{this.x})).E());
        this.r.endTracks();
        this.r.g(new b0.b(-9223372036854775807L));
    }

    private static int s(d0 d0Var) {
        d0Var.P(8);
        int g = g(d0Var.n());
        if (g != 0) {
            return g;
        }
        d0Var.Q(4);
        while (d0Var.a() > 0) {
            int g2 = g(d0Var.n());
            if (g2 != 0) {
                return g2;
            }
        }
        return 0;
    }

    private void t(a.C0062a c0062a) {
        Metadata metadata;
        Metadata metadata2;
        List list;
        int i;
        Metadata metadata3;
        ArrayList arrayList;
        int i2;
        int i3;
        ArrayList arrayList2 = new ArrayList();
        boolean z = this.w == 1;
        i9.x xVar = new i9.x();
        a.b g = c0062a.g(1969517665);
        if (g != null) {
            Pair B = b.B(g);
            Metadata metadata4 = (Metadata) B.first;
            Metadata metadata5 = (Metadata) B.second;
            if (metadata4 != null) {
                xVar.c(metadata4);
            }
            metadata2 = metadata5;
            metadata = metadata4;
        } else {
            metadata = null;
            metadata2 = null;
        }
        a.C0062a f = c0062a.f(1835365473);
        Metadata n = f != null ? b.n(f) : null;
        Metadata metadata6 = metadata;
        List A = b.A(c0062a, xVar, -9223372036854775807L, null, (this.a & 1) != 0, z, new com.google.common.base.f() { // from class: q9.i
            public final Object apply(Object obj) {
                o m;
                m = k.m((o) obj);
                return m;
            }
        });
        int size = A.size();
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        int i4 = 0;
        int i5 = -1;
        while (i4 < size) {
            r rVar = (r) A.get(i4);
            if (rVar.b == 0) {
                list = A;
                i = size;
                arrayList = arrayList2;
                metadata3 = metadata6;
                i2 = 1;
            } else {
                o oVar = rVar.a;
                ArrayList arrayList3 = arrayList2;
                long j3 = oVar.e;
                if (j3 == j) {
                    j3 = rVar.h;
                }
                j2 = Math.max(j2, j3);
                list = A;
                a aVar = new a(oVar, rVar, this.r.track(i4, oVar.b));
                int i6 = "audio/true-hd".equals(oVar.f.l) ? rVar.e * 16 : rVar.e + 30;
                p1.b b = oVar.f.b();
                b.W(i6);
                i = size;
                if (oVar.b == 2 && j3 > 0 && (i3 = rVar.b) > 1) {
                    b.P(i3 / (j3 / 1000000.0f));
                }
                h.k(oVar.b, xVar, b);
                metadata3 = metadata6;
                h.l(oVar.b, metadata3, n, b, metadata2, this.h.isEmpty() ? null : new Metadata(this.h));
                aVar.c.d(b.E());
                if (oVar.b == 2 && i5 == -1) {
                    i5 = arrayList3.size();
                }
                arrayList = arrayList3;
                arrayList.add(aVar);
                i2 = 1;
            }
            i4 += i2;
            metadata6 = metadata3;
            arrayList2 = arrayList;
            A = list;
            size = i;
            j = -9223372036854775807L;
        }
        this.u = i5;
        this.v = j2;
        a[] aVarArr = (a[]) arrayList2.toArray(new a[0]);
        this.s = aVarArr;
        this.t = h(aVarArr);
        this.r.endTracks();
        this.r.g(this);
    }

    private void u(long j) {
        if (this.j == 1836086884) {
            int i = this.l;
            this.x = new MotionPhotoMetadata(0L, j, -9223372036854775807L, j + i, this.k - i);
        }
    }

    private boolean v(i9.m mVar) {
        a.C0062a c0062a;
        if (this.l == 0) {
            if (!mVar.readFully(this.e.d(), 0, 8, true)) {
                r();
                return false;
            }
            this.l = 8;
            this.e.P(0);
            this.k = this.e.F();
            this.j = this.e.n();
        }
        long j = this.k;
        if (j == 1) {
            mVar.readFully(this.e.d(), 8, 8);
            this.l += 8;
            this.k = this.e.I();
        } else if (j == 0) {
            long length = mVar.getLength();
            if (length == -1 && (c0062a = (a.C0062a) this.f.peek()) != null) {
                length = c0062a.b;
            }
            if (length != -1) {
                this.k = (length - mVar.getPosition()) + this.l;
            }
        }
        if (this.k < this.l) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        if (z(this.j)) {
            long position = mVar.getPosition();
            long j2 = this.k;
            int i = this.l;
            long j3 = (position + j2) - i;
            if (j2 != i && this.j == 1835365473) {
                p(mVar);
            }
            this.f.push(new a.C0062a(this.j, j3));
            if (this.k == this.l) {
                q(j3);
            } else {
                i();
            }
        } else if (A(this.j)) {
            com.google.android.exoplayer2.util.a.g(this.l == 8);
            com.google.android.exoplayer2.util.a.g(this.k <= 2147483647L);
            d0 d0Var = new d0((int) this.k);
            System.arraycopy(this.e.d(), 0, d0Var.d(), 0, 8);
            this.m = d0Var;
            this.i = 1;
        } else {
            u(mVar.getPosition() - this.l);
            this.m = null;
            this.i = 1;
        }
        return true;
    }

    private boolean w(i9.m mVar, a0 a0Var) {
        boolean z;
        long j = this.k - this.l;
        long position = mVar.getPosition() + j;
        d0 d0Var = this.m;
        if (d0Var != null) {
            mVar.readFully(d0Var.d(), this.l, (int) j);
            if (this.j == 1718909296) {
                this.w = s(d0Var);
            } else if (!this.f.isEmpty()) {
                ((a.C0062a) this.f.peek()).e(new a.b(this.j, d0Var));
            }
        } else {
            if (j >= 262144) {
                a0Var.a = mVar.getPosition() + j;
                z = true;
                q(position);
                return (z || this.i == 2) ? false : true;
            }
            mVar.skipFully((int) j);
        }
        z = false;
        q(position);
        if (z) {
        }
    }

    private int x(i9.m mVar, a0 a0Var) {
        int i;
        a0 a0Var2;
        long position = mVar.getPosition();
        if (this.n == -1) {
            int l = l(position);
            this.n = l;
            if (l == -1) {
                return -1;
            }
        }
        a aVar = this.s[this.n];
        e0 e0Var = aVar.c;
        int i2 = aVar.e;
        r rVar = aVar.b;
        long j = rVar.c[i2];
        int i3 = rVar.d[i2];
        f0 f0Var = aVar.d;
        long j2 = (j - position) + this.o;
        if (j2 < 0) {
            i = 1;
            a0Var2 = a0Var;
        } else {
            if (j2 < 262144) {
                if (aVar.a.g == 1) {
                    j2 += 8;
                    i3 -= 8;
                }
                mVar.skipFully((int) j2);
                o oVar = aVar.a;
                if (oVar.j == 0) {
                    if ("audio/ac4".equals(oVar.f.l)) {
                        if (this.p == 0) {
                            com.google.android.exoplayer2.audio.c.a(i3, this.d);
                            e0Var.c(this.d, 7);
                            this.p += 7;
                        }
                        i3 += 7;
                    } else if (f0Var != null) {
                        f0Var.d(mVar);
                    }
                    while (true) {
                        int i4 = this.p;
                        if (i4 >= i3) {
                            break;
                        }
                        int b = e0Var.b(mVar, i3 - i4, false);
                        this.o += b;
                        this.p += b;
                        this.q -= b;
                    }
                } else {
                    byte[] d = this.c.d();
                    d[0] = 0;
                    d[1] = 0;
                    d[2] = 0;
                    int i5 = aVar.a.j;
                    int i6 = 4 - i5;
                    while (this.p < i3) {
                        int i7 = this.q;
                        if (i7 == 0) {
                            mVar.readFully(d, i6, i5);
                            this.o += i5;
                            this.c.P(0);
                            int n = this.c.n();
                            if (n < 0) {
                                throw ParserException.createForMalformedContainer("Invalid NAL length", (Throwable) null);
                            }
                            this.q = n;
                            this.b.P(0);
                            e0Var.c(this.b, 4);
                            this.p += 4;
                            i3 += i6;
                        } else {
                            int b2 = e0Var.b(mVar, i7, false);
                            this.o += b2;
                            this.p += b2;
                            this.q -= b2;
                        }
                    }
                }
                int i10 = i3;
                r rVar2 = aVar.b;
                long j3 = rVar2.f[i2];
                int i11 = rVar2.g[i2];
                if (f0Var != null) {
                    f0Var.c(e0Var, j3, i11, i10, 0, null);
                    if (i2 + 1 == aVar.b.b) {
                        f0Var.a(e0Var, null);
                    }
                } else {
                    e0Var.e(j3, i11, i10, 0, null);
                }
                aVar.e++;
                this.n = -1;
                this.o = 0;
                this.p = 0;
                this.q = 0;
                return 0;
            }
            a0Var2 = a0Var;
            i = 1;
        }
        a0Var2.a = j;
        return i;
    }

    private int y(i9.m mVar, a0 a0Var) {
        int c = this.g.c(mVar, a0Var, this.h);
        if (c == 1 && a0Var.a == 0) {
            i();
        }
        return c;
    }

    private static boolean z(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    @Override // i9.l
    public void b(i9.n nVar) {
        this.r = nVar;
    }

    @Override // i9.l
    public boolean c(i9.m mVar) {
        return n.d(mVar, (this.a & 2) != 0);
    }

    @Override // i9.l
    public int d(i9.m mVar, a0 a0Var) {
        while (true) {
            int i = this.i;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return x(mVar, a0Var);
                    }
                    if (i == 3) {
                        return y(mVar, a0Var);
                    }
                    throw new IllegalStateException();
                }
                if (w(mVar, a0Var)) {
                    return 1;
                }
            } else if (!v(mVar)) {
                return -1;
            }
        }
    }

    @Override // i9.b0
    public long getDurationUs() {
        return this.v;
    }

    @Override // i9.b0
    public b0.a getSeekPoints(long j) {
        return j(j, -1);
    }

    @Override // i9.b0
    public boolean isSeekable() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b0.a j(long j, int i) {
        long j2;
        long j3;
        long j4;
        long j5;
        int b;
        a[] aVarArr = this.s;
        if (aVarArr.length == 0) {
            return new b0.a(c0.c);
        }
        int i2 = i != -1 ? i : this.u;
        if (i2 != -1) {
            r rVar = aVarArr[i2].b;
            int k = k(rVar, j);
            if (k == -1) {
                return new b0.a(c0.c);
            }
            j3 = rVar.f[k];
            j2 = rVar.c[k];
            if (j3 < j && k < rVar.b - 1 && (b = rVar.b(j)) != -1 && b != k) {
                j5 = rVar.f[b];
                j4 = rVar.c[b];
                if (i == -1) {
                    int i3 = 0;
                    while (true) {
                        a[] aVarArr2 = this.s;
                        if (i3 >= aVarArr2.length) {
                            break;
                        }
                        if (i3 != this.u) {
                            r rVar2 = aVarArr2[i3].b;
                            long o = o(rVar2, j3, j2);
                            if (j5 != -9223372036854775807L) {
                                j4 = o(rVar2, j5, j4);
                            }
                            j2 = o;
                        }
                        i3++;
                    }
                }
                c0 c0Var = new c0(j3, j2);
                return j5 != -9223372036854775807L ? new b0.a(c0Var) : new b0.a(c0Var, new c0(j5, j4));
            }
        } else {
            j2 = Long.MAX_VALUE;
            j3 = j;
        }
        j4 = -1;
        j5 = -9223372036854775807L;
        if (i == -1) {
        }
        c0 c0Var2 = new c0(j3, j2);
        if (j5 != -9223372036854775807L) {
        }
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        this.f.clear();
        this.l = 0;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        if (j == 0) {
            if (this.i != 3) {
                i();
                return;
            } else {
                this.g.g();
                this.h.clear();
                return;
            }
        }
        for (a aVar : this.s) {
            B(aVar, j2);
            f0 f0Var = aVar.d;
            if (f0Var != null) {
                f0Var.b();
            }
        }
    }
}
