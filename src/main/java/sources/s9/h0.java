package s9;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import i9.b0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class h0 implements i9.l {
    public static final i9.r t = new i9.r() { // from class: s9.g0
        @Override // i9.r
        public /* synthetic */ i9.l[] c(Uri uri, Map map) {
            return i9.q.a(this, uri, map);
        }

        @Override // i9.r
        public final i9.l[] createExtractors() {
            i9.l[] v;
            v = h0.v();
            return v;
        }
    };
    private final int a;
    private final int b;
    private final List c;
    private final com.google.android.exoplayer2.util.d0 d;
    private final SparseIntArray e;
    private final i0.c f;
    private final SparseArray g;
    private final SparseBooleanArray h;
    private final SparseBooleanArray i;
    private final f0 j;
    private e0 k;
    private i9.n l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private i0 q;
    private int r;
    private int s;

    private class a implements b0 {
        private final com.google.android.exoplayer2.util.c0 a = new com.google.android.exoplayer2.util.c0(new byte[4]);

        public a() {
        }

        @Override // s9.b0
        public void a(l0 l0Var, i9.n nVar, i0.d dVar) {
        }

        @Override // s9.b0
        public void b(com.google.android.exoplayer2.util.d0 d0Var) {
            if (d0Var.D() == 0 && (d0Var.D() & 128) != 0) {
                d0Var.Q(6);
                int a = d0Var.a() / 4;
                for (int i = 0; i < a; i++) {
                    d0Var.i(this.a, 4);
                    int h = this.a.h(16);
                    this.a.r(3);
                    if (h == 0) {
                        this.a.r(13);
                    } else {
                        int h2 = this.a.h(13);
                        if (h0.this.g.get(h2) == null) {
                            h0.this.g.put(h2, new c0(h0.this.new b(h2)));
                            h0.j(h0.this);
                        }
                    }
                }
                if (h0.this.a != 2) {
                    h0.this.g.remove(0);
                }
            }
        }
    }

    private class b implements b0 {
        private final com.google.android.exoplayer2.util.c0 a = new com.google.android.exoplayer2.util.c0(new byte[5]);
        private final SparseArray b = new SparseArray();
        private final SparseIntArray c = new SparseIntArray();
        private final int d;

        public b(int i) {
            this.d = i;
        }

        private i0.b c(com.google.android.exoplayer2.util.d0 d0Var, int i) {
            int e = d0Var.e();
            int i2 = i + e;
            int i3 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (d0Var.e() < i2) {
                int D = d0Var.D();
                int e2 = d0Var.e() + d0Var.D();
                if (e2 > i2) {
                    break;
                }
                if (D == 5) {
                    long F = d0Var.F();
                    if (F != 1094921523) {
                        if (F != 1161904947) {
                            if (F != 1094921524) {
                                if (F == 1212503619) {
                                    i3 = 36;
                                }
                            }
                            i3 = 172;
                        }
                        i3 = 135;
                    }
                    i3 = 129;
                } else {
                    if (D != 106) {
                        if (D != 122) {
                            if (D == 127) {
                                if (d0Var.D() != 21) {
                                }
                                i3 = 172;
                            } else if (D == 123) {
                                i3 = 138;
                            } else if (D == 10) {
                                str = d0Var.A(3).trim();
                            } else if (D == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (d0Var.e() < e2) {
                                    String trim = d0Var.A(3).trim();
                                    int D2 = d0Var.D();
                                    byte[] bArr = new byte[4];
                                    d0Var.j(bArr, 0, 4);
                                    arrayList2.add(new i0.a(trim, D2, bArr));
                                }
                                arrayList = arrayList2;
                                i3 = 89;
                            } else if (D == 111) {
                                i3 = 257;
                            }
                        }
                        i3 = 135;
                    }
                    i3 = 129;
                }
                d0Var.Q(e2 - d0Var.e());
            }
            d0Var.P(i2);
            return new i0.b(i3, str, arrayList, Arrays.copyOfRange(d0Var.d(), e, i2));
        }

        @Override // s9.b0
        public void a(l0 l0Var, i9.n nVar, i0.d dVar) {
        }

        @Override // s9.b0
        public void b(com.google.android.exoplayer2.util.d0 d0Var) {
            l0 l0Var;
            if (d0Var.D() != 2) {
                return;
            }
            if (h0.this.a == 1 || h0.this.a == 2 || h0.this.m == 1) {
                l0Var = (l0) h0.this.c.get(0);
            } else {
                l0Var = new l0(((l0) h0.this.c.get(0)).c());
                h0.this.c.add(l0Var);
            }
            if ((d0Var.D() & 128) == 0) {
                return;
            }
            d0Var.Q(1);
            int J = d0Var.J();
            int i = 3;
            d0Var.Q(3);
            d0Var.i(this.a, 2);
            this.a.r(3);
            int i2 = 13;
            h0.this.s = this.a.h(13);
            d0Var.i(this.a, 2);
            int i3 = 4;
            this.a.r(4);
            d0Var.Q(this.a.h(12));
            if (h0.this.a == 2 && h0.this.q == null) {
                i0.b bVar = new i0.b(21, null, null, p0.f);
                h0 h0Var = h0.this;
                h0Var.q = h0Var.f.a(21, bVar);
                if (h0.this.q != null) {
                    h0.this.q.a(l0Var, h0.this.l, new i0.d(J, 21, 8192));
                }
            }
            this.b.clear();
            this.c.clear();
            int a = d0Var.a();
            while (a > 0) {
                d0Var.i(this.a, 5);
                int h = this.a.h(8);
                this.a.r(i);
                int h2 = this.a.h(i2);
                this.a.r(i3);
                int h3 = this.a.h(12);
                i0.b c = c(d0Var, h3);
                if (h == 6 || h == 5) {
                    h = c.a;
                }
                a -= h3 + 5;
                int i4 = h0.this.a == 2 ? h : h2;
                if (!h0.this.h.get(i4)) {
                    i0 a2 = (h0.this.a == 2 && h == 21) ? h0.this.q : h0.this.f.a(h, c);
                    if (h0.this.a != 2 || h2 < this.c.get(i4, 8192)) {
                        this.c.put(i4, h2);
                        this.b.put(i4, a2);
                    }
                }
                i = 3;
                i3 = 4;
                i2 = 13;
            }
            int size = this.c.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = this.c.keyAt(i5);
                int valueAt = this.c.valueAt(i5);
                h0.this.h.put(keyAt, true);
                h0.this.i.put(valueAt, true);
                i0 i0Var = (i0) this.b.valueAt(i5);
                if (i0Var != null) {
                    if (i0Var != h0.this.q) {
                        i0Var.a(l0Var, h0.this.l, new i0.d(J, keyAt, 8192));
                    }
                    h0.this.g.put(valueAt, i0Var);
                }
            }
            if (h0.this.a == 2) {
                if (h0.this.n) {
                    return;
                }
                h0.this.l.endTracks();
                h0.this.m = 0;
                h0.this.n = true;
                return;
            }
            h0.this.g.remove(this.d);
            h0 h0Var2 = h0.this;
            h0Var2.m = h0Var2.a == 1 ? 0 : h0.this.m - 1;
            if (h0.this.m == 0) {
                h0.this.l.endTracks();
                h0.this.n = true;
            }
        }
    }

    public h0() {
        this(0);
    }

    public h0(int i) {
        this(1, i, 112800);
    }

    public h0(int i, int i2, int i3) {
        this(i, new l0(0L), new j(i2), i3);
    }

    public h0(int i, l0 l0Var, i0.c cVar) {
        this(i, l0Var, cVar, 112800);
    }

    public h0(int i, l0 l0Var, i0.c cVar, int i2) {
        this.f = (i0.c) com.google.android.exoplayer2.util.a.e(cVar);
        this.b = i2;
        this.a = i;
        if (i == 1 || i == 2) {
            this.c = Collections.singletonList(l0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            arrayList.add(l0Var);
        }
        this.d = new com.google.android.exoplayer2.util.d0(new byte[9400], 0);
        this.h = new SparseBooleanArray();
        this.i = new SparseBooleanArray();
        this.g = new SparseArray();
        this.e = new SparseIntArray();
        this.j = new f0(i2);
        this.l = i9.n.i1;
        this.s = -1;
        x();
    }

    static /* synthetic */ int j(h0 h0Var) {
        int i = h0Var.m;
        h0Var.m = i + 1;
        return i;
    }

    private boolean t(i9.m mVar) {
        byte[] d = this.d.d();
        if (9400 - this.d.e() < 188) {
            int a2 = this.d.a();
            if (a2 > 0) {
                System.arraycopy(d, this.d.e(), d, 0, a2);
            }
            this.d.N(d, a2);
        }
        while (this.d.a() < 188) {
            int f = this.d.f();
            int read = mVar.read(d, f, 9400 - f);
            if (read == -1) {
                return false;
            }
            this.d.O(f + read);
        }
        return true;
    }

    private int u() {
        int e = this.d.e();
        int f = this.d.f();
        int a2 = j0.a(this.d.d(), e, f);
        this.d.P(a2);
        int i = a2 + 188;
        if (i > f) {
            int i2 = this.r + (a2 - e);
            this.r = i2;
            if (this.a == 2 && i2 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", (Throwable) null);
            }
        } else {
            this.r = 0;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i9.l[] v() {
        return new i9.l[]{new h0()};
    }

    private void w(long j) {
        if (this.o) {
            return;
        }
        this.o = true;
        if (this.j.b() == -9223372036854775807L) {
            this.l.g(new b0.b(this.j.b()));
            return;
        }
        e0 e0Var = new e0(this.j.c(), this.j.b(), j, this.s, this.b);
        this.k = e0Var;
        this.l.g(e0Var.b());
    }

    private void x() {
        this.h.clear();
        this.g.clear();
        SparseArray createInitialPayloadReaders = this.f.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i = 0; i < size; i++) {
            this.g.put(createInitialPayloadReaders.keyAt(i), (i0) createInitialPayloadReaders.valueAt(i));
        }
        this.g.put(0, new c0(new a()));
        this.q = null;
    }

    private boolean y(int i) {
        return this.a == 2 || this.n || !this.i.get(i, false);
    }

    @Override // i9.l
    public void b(i9.n nVar) {
        this.l = nVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        r1 = r1 + 1;
     */
    @Override // i9.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(i9.m mVar) {
        byte[] d = this.d.d();
        mVar.peekFully(d, 0, 940);
        int i = 0;
        while (i < 188) {
            for (int i2 = 0; i2 < 5; i2++) {
                if (d[(i2 * 188) + i] != 71) {
                    break;
                }
            }
            mVar.skipFully(i);
            return true;
        }
        return false;
    }

    @Override // i9.l
    public int d(i9.m mVar, i9.a0 a0Var) {
        long length = mVar.getLength();
        if (this.n) {
            if (length != -1 && this.a != 2 && !this.j.d()) {
                return this.j.e(mVar, a0Var, this.s);
            }
            w(length);
            if (this.p) {
                this.p = false;
                seek(0L, 0L);
                if (mVar.getPosition() != 0) {
                    a0Var.a = 0L;
                    return 1;
                }
            }
            e0 e0Var = this.k;
            if (e0Var != null && e0Var.d()) {
                return this.k.c(mVar, a0Var);
            }
        }
        if (!t(mVar)) {
            return -1;
        }
        int u = u();
        int f = this.d.f();
        if (u > f) {
            return 0;
        }
        int n = this.d.n();
        if ((8388608 & n) != 0) {
            this.d.P(u);
            return 0;
        }
        int i = (4194304 & n) != 0 ? 1 : 0;
        int i2 = (2096896 & n) >> 8;
        boolean z = (n & 32) != 0;
        i0 i0Var = (n & 16) != 0 ? (i0) this.g.get(i2) : null;
        if (i0Var == null) {
            this.d.P(u);
            return 0;
        }
        if (this.a != 2) {
            int i3 = n & 15;
            int i4 = this.e.get(i2, i3 - 1);
            this.e.put(i2, i3);
            if (i4 == i3) {
                this.d.P(u);
                return 0;
            }
            if (i3 != ((i4 + 1) & 15)) {
                i0Var.seek();
            }
        }
        if (z) {
            int D = this.d.D();
            i |= (this.d.D() & 64) != 0 ? 2 : 0;
            this.d.Q(D - 1);
        }
        boolean z2 = this.n;
        if (y(i2)) {
            this.d.O(u);
            i0Var.b(this.d, i);
            this.d.O(f);
        }
        if (this.a != 2 && !z2 && this.n && length != -1) {
            this.p = true;
        }
        this.d.P(u);
        return 0;
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        e0 e0Var;
        com.google.android.exoplayer2.util.a.g(this.a != 2);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            l0 l0Var = (l0) this.c.get(i);
            boolean z = l0Var.e() == -9223372036854775807L;
            if (!z) {
                long c = l0Var.c();
                z = (c == -9223372036854775807L || c == 0 || c == j2) ? false : true;
            }
            if (z) {
                l0Var.g(j2);
            }
        }
        if (j2 != 0 && (e0Var = this.k) != null) {
            e0Var.h(j2);
        }
        this.d.L(0);
        this.e.clear();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            ((i0) this.g.valueAt(i2)).seek();
        }
        this.r = 0;
    }
}
