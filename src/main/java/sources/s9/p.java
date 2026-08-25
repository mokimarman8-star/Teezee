package s9;

import android.util.SparseArray;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.x;
import java.util.ArrayList;
import java.util.Arrays;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class p implements m {
    private final d0 a;
    private final boolean b;
    private final boolean c;
    private long g;
    private String i;
    private i9.e0 j;
    private b k;
    private boolean l;
    private boolean n;
    private final boolean[] h = new boolean[3];
    private final u d = new u(7, 128);
    private final u e = new u(8, 128);
    private final u f = new u(6, 128);
    private long m = -9223372036854775807L;
    private final com.google.android.exoplayer2.util.d0 o = new com.google.android.exoplayer2.util.d0();

    private static final class b {
        private final i9.e0 a;
        private final boolean b;
        private final boolean c;
        private final SparseArray d = new SparseArray();
        private final SparseArray e = new SparseArray();
        private final com.google.android.exoplayer2.util.e0 f;
        private byte[] g;
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private a m;
        private a n;
        private boolean o;
        private long p;
        private long q;
        private boolean r;

        private static final class a {
            private boolean a;
            private boolean b;
            private x.c c;
            private int d;
            private int e;
            private int f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(a aVar) {
                int i;
                int i2;
                int i3;
                boolean z;
                if (!this.a) {
                    return false;
                }
                if (!aVar.a) {
                    return true;
                }
                x.c cVar = (x.c) com.google.android.exoplayer2.util.a.i(this.c);
                x.c cVar2 = (x.c) com.google.android.exoplayer2.util.a.i(aVar.c);
                return (this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && (!this.i || !aVar.i || this.j == aVar.j) && (((i = this.d) == (i2 = aVar.d) || (i != 0 && i2 != 0)) && (((i3 = cVar.l) != 0 || cVar2.l != 0 || (this.m == aVar.m && this.n == aVar.n)) && ((i3 != 1 || cVar2.l != 1 || (this.o == aVar.o && this.p == aVar.p)) && (z = this.k) == aVar.k && (!z || this.l == aVar.l))))) ? false : true;
            }

            public void b() {
                this.b = false;
                this.a = false;
            }

            public boolean d() {
                int i;
                return this.b && ((i = this.e) == 7 || i == 2);
            }

            public void e(x.c cVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i10, int i11) {
                this.c = cVar;
                this.d = i;
                this.e = i2;
                this.f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i10;
                this.p = i11;
                this.a = true;
                this.b = true;
            }

            public void f(int i) {
                this.e = i;
                this.b = true;
            }
        }

        public b(i9.e0 e0Var, boolean z, boolean z2) {
            this.a = e0Var;
            this.b = z;
            this.c = z2;
            this.m = new a();
            this.n = new a();
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new com.google.android.exoplayer2.util.e0(bArr, 0, 0);
            g();
        }

        private void d(int i) {
            long j = this.q;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.r;
            this.a.e(j, z ? 1 : 0, (int) (this.j - this.p), i, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(byte[] bArr, int i, int i2) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i10;
            if (this.k) {
                int i11 = i2 - i;
                byte[] bArr2 = this.g;
                int length = bArr2.length;
                int i12 = this.h;
                if (length < i12 + i11) {
                    this.g = Arrays.copyOf(bArr2, (i12 + i11) * 2);
                }
                System.arraycopy(bArr, i, this.g, this.h, i11);
                int i13 = this.h + i11;
                this.h = i13;
                this.f.i(this.g, 0, i13);
                if (this.f.b(8)) {
                    this.f.k();
                    int e = this.f.e(2);
                    this.f.l(5);
                    if (this.f.c()) {
                        this.f.h();
                        if (this.f.c()) {
                            int h = this.f.h();
                            if (!this.c) {
                                this.k = false;
                                this.n.f(h);
                                return;
                            }
                            if (this.f.c()) {
                                int h2 = this.f.h();
                                if (this.e.indexOfKey(h2) < 0) {
                                    this.k = false;
                                    return;
                                }
                                x.b bVar = (x.b) this.e.get(h2);
                                x.c cVar = (x.c) this.d.get(bVar.b);
                                if (cVar.i) {
                                    if (!this.f.b(2)) {
                                        return;
                                    } else {
                                        this.f.l(2);
                                    }
                                }
                                if (this.f.b(cVar.k)) {
                                    int e2 = this.f.e(cVar.k);
                                    if (cVar.j) {
                                        z = false;
                                        z2 = false;
                                    } else {
                                        if (!this.f.b(1)) {
                                            return;
                                        }
                                        boolean d = this.f.d();
                                        if (d) {
                                            if (this.f.b(1)) {
                                                z = d;
                                                z2 = true;
                                                z3 = this.f.d();
                                                z4 = this.i != 5;
                                                if (z4) {
                                                    i3 = 0;
                                                } else if (!this.f.c()) {
                                                    return;
                                                } else {
                                                    i3 = this.f.h();
                                                }
                                                i4 = cVar.l;
                                                if (i4 != 0) {
                                                    if (!this.f.b(cVar.m)) {
                                                        return;
                                                    }
                                                    int e3 = this.f.e(cVar.m);
                                                    if (bVar.c && !z) {
                                                        if (this.f.c()) {
                                                            i6 = this.f.g();
                                                            i5 = e3;
                                                            i7 = 0;
                                                            i10 = i7;
                                                            this.n.e(cVar, e, h, e2, h2, z, z2, z3, z4, i3, i5, i6, i7, i10);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i5 = e3;
                                                    i6 = 0;
                                                } else {
                                                    if (i4 == 1 && !cVar.n) {
                                                        if (this.f.c()) {
                                                            int g = this.f.g();
                                                            if (!bVar.c || z) {
                                                                i7 = g;
                                                                i5 = 0;
                                                                i6 = 0;
                                                                i10 = 0;
                                                            } else {
                                                                if (!this.f.c()) {
                                                                    return;
                                                                }
                                                                i10 = this.f.g();
                                                                i7 = g;
                                                                i5 = 0;
                                                                i6 = 0;
                                                            }
                                                            this.n.e(cVar, e, h, e2, h2, z, z2, z3, z4, i3, i5, i6, i7, i10);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i5 = 0;
                                                    i6 = 0;
                                                }
                                                i7 = i6;
                                                i10 = i7;
                                                this.n.e(cVar, e, h, e2, h2, z, z2, z3, z4, i3, i5, i6, i7, i10);
                                                this.k = false;
                                            }
                                            return;
                                        }
                                        z = d;
                                        z2 = false;
                                    }
                                    z3 = z2;
                                    if (this.i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i4 = cVar.l;
                                    if (i4 != 0) {
                                    }
                                    i7 = i6;
                                    i10 = i7;
                                    this.n.e(cVar, e, h, e2, h2, z, z2, z3, z4, i3, i5, i6, i7, i10);
                                    this.k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean b(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.i == 9 || (this.c && this.n.c(this.m))) {
                if (z && this.o) {
                    d(i + ((int) (j - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            if (this.b) {
                z2 = this.n.d();
            }
            boolean z4 = this.r;
            int i2 = this.i;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.r = z5;
            return z5;
        }

        public boolean c() {
            return this.c;
        }

        public void e(x.b bVar) {
            this.e.append(bVar.a, bVar);
        }

        public void f(x.c cVar) {
            this.d.append(cVar.d, cVar);
        }

        public void g() {
            this.k = false;
            this.o = false;
            this.n.b();
        }

        public void h(long j, int i, long j2) {
            this.i = i;
            this.l = j2;
            this.j = j;
            if (!this.b || i != 1) {
                if (!this.c) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            aVar.b();
            this.h = 0;
            this.k = true;
        }
    }

    public p(d0 d0Var, boolean z, boolean z2) {
        this.a = d0Var;
        this.b = z;
        this.c = z2;
    }

    private void a() {
        com.google.android.exoplayer2.util.a.i(this.j);
        p0.j(this.k);
    }

    private void e(long j, int i, int i2, long j2) {
        if (!this.l || this.k.c()) {
            this.d.b(i2);
            this.e.b(i2);
            if (this.l) {
                if (this.d.c()) {
                    u uVar = this.d;
                    this.k.f(com.google.android.exoplayer2.util.x.l(uVar.d, 3, uVar.e));
                    this.d.d();
                } else if (this.e.c()) {
                    u uVar2 = this.e;
                    this.k.e(com.google.android.exoplayer2.util.x.j(uVar2.d, 3, uVar2.e));
                    this.e.d();
                }
            } else if (this.d.c() && this.e.c()) {
                ArrayList arrayList = new ArrayList();
                u uVar3 = this.d;
                arrayList.add(Arrays.copyOf(uVar3.d, uVar3.e));
                u uVar4 = this.e;
                arrayList.add(Arrays.copyOf(uVar4.d, uVar4.e));
                u uVar5 = this.d;
                x.c l = com.google.android.exoplayer2.util.x.l(uVar5.d, 3, uVar5.e);
                u uVar6 = this.e;
                x.b j3 = com.google.android.exoplayer2.util.x.j(uVar6.d, 3, uVar6.e);
                this.j.d(new p1.b().S(this.i).e0("video/avc").I(com.google.android.exoplayer2.util.f.a(l.a, l.b, l.c)).j0(l.f).Q(l.g).a0(l.h).T(arrayList).E());
                this.l = true;
                this.k.f(l);
                this.k.e(j3);
                this.d.d();
                this.e.d();
            }
        }
        if (this.f.b(i2)) {
            u uVar7 = this.f;
            this.o.N(this.f.d, com.google.android.exoplayer2.util.x.q(uVar7.d, uVar7.e));
            this.o.P(4);
            this.a.a(j2, this.o);
        }
        if (this.k.b(j, i, this.l, this.n)) {
            this.n = false;
        }
    }

    private void f(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.c()) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    private void g(long j, int i, long j2) {
        if (!this.l || this.k.c()) {
            this.d.e(i);
            this.e.e(i);
        }
        this.f.e(i);
        this.k.h(j, i, j2);
    }

    @Override // s9.m
    public void b(com.google.android.exoplayer2.util.d0 d0Var) {
        a();
        int e = d0Var.e();
        int f = d0Var.f();
        byte[] d = d0Var.d();
        this.g += d0Var.a();
        this.j.c(d0Var, d0Var.a());
        while (true) {
            int c = com.google.android.exoplayer2.util.x.c(d, e, f, this.h);
            if (c == f) {
                f(d, e, f);
                return;
            }
            int f2 = com.google.android.exoplayer2.util.x.f(d, c);
            int i = c - e;
            if (i > 0) {
                f(d, e, c);
            }
            int i2 = f - c;
            long j = this.g - i2;
            e(j, i2, i < 0 ? -i : 0, this.m);
            g(j, f2, this.m);
            e = c + 3;
        }
    }

    @Override // s9.m
    public void c(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
        this.n |= (i & 2) != 0;
    }

    @Override // s9.m
    public void d(i9.n nVar, i0.d dVar) {
        dVar.a();
        this.i = dVar.b();
        i9.e0 track = nVar.track(dVar.c(), 2);
        this.j = track;
        this.k = new b(track, this.b, this.c);
        this.a.b(nVar, dVar);
    }

    @Override // s9.m
    public void packetFinished() {
    }

    @Override // s9.m
    public void seek() {
        this.g = 0L;
        this.n = false;
        this.m = -9223372036854775807L;
        com.google.android.exoplayer2.util.x.a(this.h);
        this.d.d();
        this.e.d();
        this.f.d();
        b bVar = this.k;
        if (bVar != null) {
            bVar.g();
        }
    }
}
