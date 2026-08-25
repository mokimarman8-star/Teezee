package x9;

import com.google.android.exoplayer2.d3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.q1;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v9.s;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class i implements s, b0, Loader.b, Loader.e {
    public final int a;
    private final int[] b;
    private final p1[] c;
    private final boolean[] d;
    private final j e;
    private final b0.a f;
    private final p.a g;
    private final z h;
    private final Loader i;
    private final h j;
    private final ArrayList k;
    private final List l;
    private final a0 m;
    private final a0[] n;
    private final c o;
    private f p;
    private p1 q;
    private b r;
    private long s;
    private long t;
    private int u;
    private x9.a v;
    boolean w;

    public final class a implements s {
        public final i a;
        private final a0 b;
        private final int c;
        private boolean d;

        public a(i iVar, a0 a0Var, int i) {
            this.a = iVar;
            this.b = a0Var;
            this.c = i;
        }

        private void b() {
            if (this.d) {
                return;
            }
            i.this.g.i(i.this.b[this.c], i.this.c[this.c], 0, (Object) null, i.this.t);
            this.d = true;
        }

        @Override // v9.s
        public int a(q1 q1Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (i.this.u()) {
                return -3;
            }
            if (i.this.v != null && i.this.v.g(this.c + 1) <= this.b.C()) {
                return -3;
            }
            b();
            return this.b.S(q1Var, decoderInputBuffer, i, i.this.w);
        }

        public void c() {
            com.google.android.exoplayer2.util.a.g(i.this.d[this.c]);
            i.this.d[this.c] = false;
        }

        @Override // v9.s
        public boolean isReady() {
            return !i.this.u() && this.b.K(i.this.w);
        }

        @Override // v9.s
        public void maybeThrowError() {
        }

        @Override // v9.s
        public int skipData(long j) {
            if (i.this.u()) {
                return 0;
            }
            int E = this.b.E(j, i.this.w);
            if (i.this.v != null) {
                E = Math.min(E, i.this.v.g(this.c + 1) - this.b.C());
            }
            this.b.e0(E);
            if (E > 0) {
                b();
            }
            return E;
        }
    }

    public interface b {
        void a(i iVar);
    }

    public i(int i, int[] iArr, p1[] p1VarArr, j jVar, b0.a aVar, com.google.android.exoplayer2.upstream.b bVar, long j, u uVar, s.a aVar2, z zVar, p.a aVar3) {
        this.a = i;
        int i2 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.b = iArr;
        this.c = p1VarArr == null ? new p1[0] : p1VarArr;
        this.e = jVar;
        this.f = aVar;
        this.g = aVar3;
        this.h = zVar;
        this.i = new Loader("ChunkSampleStream");
        this.j = new h();
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        this.l = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.n = new a0[length];
        this.d = new boolean[length];
        int i3 = length + 1;
        int[] iArr2 = new int[i3];
        a0[] a0VarArr = new a0[i3];
        a0 k = a0.k(bVar, uVar, aVar2);
        this.m = k;
        iArr2[0] = i;
        a0VarArr[0] = k;
        while (i2 < length) {
            a0 l = a0.l(bVar);
            this.n[i2] = l;
            int i4 = i2 + 1;
            a0VarArr[i4] = l;
            iArr2[i4] = this.b[i2];
            i2 = i4;
        }
        this.o = new c(iArr2, a0VarArr);
        this.s = j;
        this.t = j;
    }

    private int A(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.k.size()) {
                return this.k.size() - 1;
            }
        } while (((x9.a) this.k.get(i2)).g(0) <= i);
        return i2 - 1;
    }

    private void D() {
        this.m.V();
        for (a0 a0Var : this.n) {
            a0Var.V();
        }
    }

    private void m(int i) {
        int min = Math.min(A(i, 0), this.u);
        if (min > 0) {
            p0.M0(this.k, 0, min);
            this.u -= min;
        }
    }

    private void o(int i) {
        com.google.android.exoplayer2.util.a.g(!this.i.i());
        int size = this.k.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (!s(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = r().h;
        x9.a p = p(i);
        if (this.k.isEmpty()) {
            this.s = this.t;
        }
        this.w = false;
        this.g.D(this.a, p.g, j);
    }

    private x9.a p(int i) {
        x9.a aVar = (x9.a) this.k.get(i);
        ArrayList arrayList = this.k;
        p0.M0(arrayList, i, arrayList.size());
        this.u = Math.max(this.u, this.k.size());
        int i2 = 0;
        this.m.u(aVar.g(0));
        while (true) {
            a0[] a0VarArr = this.n;
            if (i2 >= a0VarArr.length) {
                return aVar;
            }
            a0 a0Var = a0VarArr[i2];
            i2++;
            a0Var.u(aVar.g(i2));
        }
    }

    private x9.a r() {
        return (x9.a) this.k.get(r0.size() - 1);
    }

    private boolean s(int i) {
        int C;
        x9.a aVar = (x9.a) this.k.get(i);
        if (this.m.C() > aVar.g(0)) {
            return true;
        }
        int i2 = 0;
        do {
            a0[] a0VarArr = this.n;
            if (i2 >= a0VarArr.length) {
                return false;
            }
            C = a0VarArr[i2].C();
            i2++;
        } while (C <= aVar.g(i2));
        return true;
    }

    private boolean t(f fVar) {
        return fVar instanceof x9.a;
    }

    private void v() {
        int A = A(this.m.C(), this.u - 1);
        while (true) {
            int i = this.u;
            if (i > A) {
                return;
            }
            this.u = i + 1;
            w(i);
        }
    }

    private void w(int i) {
        x9.a aVar = (x9.a) this.k.get(i);
        p1 p1Var = aVar.d;
        if (!p1Var.equals(this.q)) {
            this.g.i(this.a, p1Var, aVar.e, aVar.f, aVar.g);
        }
        this.q = p1Var;
    }

    public void B() {
        C(null);
    }

    public void C(b bVar) {
        this.r = bVar;
        this.m.R();
        for (a0 a0Var : this.n) {
            a0Var.R();
        }
        this.i.l(this);
    }

    public void E(long j) {
        x9.a aVar;
        this.t = j;
        if (u()) {
            this.s = j;
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            aVar = (x9.a) this.k.get(i2);
            long j2 = aVar.g;
            if (j2 == j && aVar.k == -9223372036854775807L) {
                break;
            } else {
                if (j2 > j) {
                    break;
                }
            }
        }
        aVar = null;
        if (aVar != null ? this.m.Y(aVar.g(0)) : this.m.Z(j, j < getNextLoadPositionUs())) {
            this.u = A(this.m.C(), 0);
            a0[] a0VarArr = this.n;
            int length = a0VarArr.length;
            while (i < length) {
                a0VarArr[i].Z(j, true);
                i++;
            }
            return;
        }
        this.s = j;
        this.w = false;
        this.k.clear();
        this.u = 0;
        if (!this.i.i()) {
            this.i.f();
            D();
            return;
        }
        this.m.r();
        a0[] a0VarArr2 = this.n;
        int length2 = a0VarArr2.length;
        while (i < length2) {
            a0VarArr2[i].r();
            i++;
        }
        this.i.e();
    }

    public a F(long j, int i) {
        for (int i2 = 0; i2 < this.n.length; i2++) {
            if (this.b[i2] == i) {
                com.google.android.exoplayer2.util.a.g(!this.d[i2]);
                this.d[i2] = true;
                this.n[i2].Z(j, true);
                return new a(this, this.n[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    @Override // v9.s
    public int a(q1 q1Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (u()) {
            return -3;
        }
        x9.a aVar = this.v;
        if (aVar != null && aVar.g(0) <= this.m.C()) {
            return -3;
        }
        v();
        return this.m.S(q1Var, decoderInputBuffer, i, this.w);
    }

    public long b(long j, d3 d3Var) {
        return this.e.b(j, d3Var);
    }

    public boolean continueLoading(long j) {
        List list;
        long j2;
        if (this.w || this.i.i() || this.i.h()) {
            return false;
        }
        boolean u = u();
        if (u) {
            list = Collections.emptyList();
            j2 = this.s;
        } else {
            list = this.l;
            j2 = r().h;
        }
        this.e.g(j, j2, list, this.j);
        h hVar = this.j;
        boolean z = hVar.b;
        f fVar = hVar.a;
        hVar.a();
        if (z) {
            this.s = -9223372036854775807L;
            this.w = true;
            return true;
        }
        if (fVar == null) {
            return false;
        }
        this.p = fVar;
        if (t(fVar)) {
            x9.a aVar = (x9.a) fVar;
            if (u) {
                long j3 = aVar.g;
                long j4 = this.s;
                if (j3 != j4) {
                    this.m.b0(j4);
                    for (a0 a0Var : this.n) {
                        a0Var.b0(this.s);
                    }
                }
                this.s = -9223372036854775807L;
            }
            aVar.i(this.o);
            this.k.add(aVar);
        } else if (fVar instanceof m) {
            ((m) fVar).e(this.o);
        }
        this.g.A(new v9.h(fVar.a, fVar.b, this.i.m(fVar, this, this.h.a(fVar.c))), fVar.c, this.a, fVar.d, fVar.e, fVar.f, fVar.g, fVar.h);
        return true;
    }

    public void discardBuffer(long j, boolean z) {
        if (u()) {
            return;
        }
        int x = this.m.x();
        this.m.q(j, z, true);
        int x2 = this.m.x();
        if (x2 > x) {
            long y = this.m.y();
            int i = 0;
            while (true) {
                a0[] a0VarArr = this.n;
                if (i >= a0VarArr.length) {
                    break;
                }
                a0VarArr[i].q(y, z, this.d[i]);
                i++;
            }
        }
        m(x2);
    }

    public long getBufferedPositionUs() {
        if (this.w) {
            return Long.MIN_VALUE;
        }
        if (u()) {
            return this.s;
        }
        long j = this.t;
        x9.a r = r();
        if (!r.f()) {
            if (this.k.size() > 1) {
                r = (x9.a) this.k.get(r2.size() - 2);
            } else {
                r = null;
            }
        }
        if (r != null) {
            j = Math.max(j, r.h);
        }
        return Math.max(j, this.m.z());
    }

    public long getNextLoadPositionUs() {
        if (u()) {
            return this.s;
        }
        if (this.w) {
            return Long.MIN_VALUE;
        }
        return r().h;
    }

    public boolean isLoading() {
        return this.i.i();
    }

    @Override // v9.s
    public boolean isReady() {
        return !u() && this.m.K(this.w);
    }

    @Override // v9.s
    public void maybeThrowError() {
        this.i.maybeThrowError();
        this.m.N();
        if (this.i.i()) {
            return;
        }
        this.e.maybeThrowError();
    }

    public void onLoaderReleased() {
        this.m.T();
        for (a0 a0Var : this.n) {
            a0Var.T();
        }
        this.e.release();
        b bVar = this.r;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public j q() {
        return this.e;
    }

    public void reevaluateBuffer(long j) {
        if (this.i.h() || u()) {
            return;
        }
        if (!this.i.i()) {
            int preferredQueueSize = this.e.getPreferredQueueSize(j, this.l);
            if (preferredQueueSize < this.k.size()) {
                o(preferredQueueSize);
                return;
            }
            return;
        }
        f fVar = (f) com.google.android.exoplayer2.util.a.e(this.p);
        if (!(t(fVar) && s(this.k.size() - 1)) && this.e.d(j, fVar, this.l)) {
            this.i.e();
            if (t(fVar)) {
                this.v = (x9.a) fVar;
            }
        }
    }

    @Override // v9.s
    public int skipData(long j) {
        if (u()) {
            return 0;
        }
        int E = this.m.E(j, this.w);
        x9.a aVar = this.v;
        if (aVar != null) {
            E = Math.min(E, aVar.g(0) - this.m.C());
        }
        this.m.e0(E);
        v();
        return E;
    }

    boolean u() {
        return this.s != -9223372036854775807L;
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void j(f fVar, long j, long j2, boolean z) {
        this.p = null;
        this.v = null;
        v9.h hVar = new v9.h(fVar.a, fVar.b, fVar.d(), fVar.c(), j, j2, fVar.a());
        this.h.b(fVar.a);
        this.g.r(hVar, fVar.c, this.a, fVar.d, fVar.e, fVar.f, fVar.g, fVar.h);
        if (z) {
            return;
        }
        if (u()) {
            D();
        } else if (t(fVar)) {
            p(this.k.size() - 1);
            if (this.k.isEmpty()) {
                this.s = this.t;
            }
        }
        this.f.g(this);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void l(f fVar, long j, long j2) {
        this.p = null;
        this.e.h(fVar);
        v9.h hVar = new v9.h(fVar.a, fVar.b, fVar.d(), fVar.c(), j, j2, fVar.a());
        this.h.b(fVar.a);
        this.g.u(hVar, fVar.c, this.a, fVar.d, fVar.e, fVar.f, fVar.g, fVar.h);
        this.f.g(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Loader.c n(f fVar, long j, long j2, IOException iOException, int i) {
        Loader.c cVar;
        boolean c;
        long a2 = fVar.a();
        boolean t = t(fVar);
        int size = this.k.size() - 1;
        boolean z = (a2 != 0 && t && s(size)) ? false : true;
        v9.h hVar = new v9.h(fVar.a, fVar.b, fVar.d(), fVar.c(), j, j2, a2);
        z.c cVar2 = new z.c(hVar, new v9.i(fVar.c, this.a, fVar.d, fVar.e, fVar.f, p0.e1(fVar.g), p0.e1(fVar.h)), iOException, i);
        if (this.e.f(fVar, z, cVar2, this.h)) {
            if (z) {
                cVar = Loader.f;
                if (t) {
                    com.google.android.exoplayer2.util.a.g(p(size) == fVar);
                    if (this.k.isEmpty()) {
                        this.s = this.t;
                    }
                }
                if (cVar == null) {
                    long c2 = this.h.c(cVar2);
                    cVar = c2 != -9223372036854775807L ? Loader.g(false, c2) : Loader.g;
                }
                c = cVar.c();
                this.g.w(hVar, fVar.c, this.a, fVar.d, fVar.e, fVar.f, fVar.g, fVar.h, iOException, !c);
                if (!c) {
                    this.p = null;
                    this.h.b(fVar.a);
                    this.f.g(this);
                }
                return cVar;
            }
            com.google.android.exoplayer2.util.s.i("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
        }
        cVar = null;
        if (cVar == null) {
        }
        c = cVar.c();
        this.g.w(hVar, fVar.c, this.a, fVar.d, fVar.e, fVar.f, fVar.g, fVar.h, iOException, !c);
        if (!c) {
        }
        return cVar;
    }
}
