package x9;

import android.util.SparseArray;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.w;
import g9.u1;
import i9.a0;
import i9.b0;
import i9.d0;
import i9.e0;
import java.util.List;
import x9.g;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class e implements i9.n, g {
    public static final g.a j = new g.a() { // from class: x9.d
        @Override // x9.g.a
        public final g a(int i, p1 p1Var, boolean z, List list, e0 e0Var, u1 u1Var) {
            g f;
            f = e.f(i, p1Var, z, list, e0Var, u1Var);
            return f;
        }
    };
    private static final a0 k = new a0();
    private final i9.l a;
    private final int b;
    private final p1 c;
    private final SparseArray d = new SparseArray();
    private boolean e;
    private g.b f;
    private long g;
    private b0 h;
    private p1[] i;

    private static final class a implements e0 {
        private final int a;
        private final int b;
        private final p1 c;
        private final i9.k d = new i9.k();
        public p1 e;
        private e0 f;
        private long g;

        public a(int i, int i2, p1 p1Var) {
            this.a = i;
            this.b = i2;
            this.c = p1Var;
        }

        @Override // i9.e0
        public int a(com.google.android.exoplayer2.upstream.g gVar, int i, boolean z, int i2) {
            return ((e0) p0.j(this.f)).b(gVar, i, z);
        }

        @Override // i9.e0
        public /* synthetic */ int b(com.google.android.exoplayer2.upstream.g gVar, int i, boolean z) {
            return d0.a(this, gVar, i, z);
        }

        @Override // i9.e0
        public /* synthetic */ void c(com.google.android.exoplayer2.util.d0 d0Var, int i) {
            d0.b(this, d0Var, i);
        }

        @Override // i9.e0
        public void d(p1 p1Var) {
            p1 p1Var2 = this.c;
            if (p1Var2 != null) {
                p1Var = p1Var.j(p1Var2);
            }
            this.e = p1Var;
            ((e0) p0.j(this.f)).d(this.e);
        }

        @Override // i9.e0
        public void e(long j, int i, int i2, int i3, e0.a aVar) {
            long j2 = this.g;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.f = this.d;
            }
            ((e0) p0.j(this.f)).e(j, i, i2, i3, aVar);
        }

        @Override // i9.e0
        public void f(com.google.android.exoplayer2.util.d0 d0Var, int i, int i2) {
            ((e0) p0.j(this.f)).c(d0Var, i);
        }

        public void g(g.b bVar, long j) {
            if (bVar == null) {
                this.f = this.d;
                return;
            }
            this.g = j;
            e0 track = bVar.track(this.a, this.b);
            this.f = track;
            p1 p1Var = this.e;
            if (p1Var != null) {
                track.d(p1Var);
            }
        }
    }

    public e(i9.l lVar, int i, p1 p1Var) {
        this.a = lVar;
        this.b = i;
        this.c = p1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g f(int i, p1 p1Var, boolean z, List list, e0 e0Var, u1 u1Var) {
        i9.l gVar;
        String str = p1Var.k;
        if (w.r(str)) {
            return null;
        }
        if (w.q(str)) {
            gVar = new o9.e(1);
        } else {
            gVar = new q9.g(z ? 4 : 0, null, null, list, e0Var);
        }
        return new e(gVar, i, p1Var);
    }

    @Override // x9.g
    public boolean a(i9.m mVar) {
        int d = this.a.d(mVar, k);
        com.google.android.exoplayer2.util.a.g(d != 1);
        return d == 0;
    }

    @Override // x9.g
    public i9.d b() {
        b0 b0Var = this.h;
        if (b0Var instanceof i9.d) {
            return (i9.d) b0Var;
        }
        return null;
    }

    @Override // x9.g
    public p1[] c() {
        return this.i;
    }

    @Override // x9.g
    public void d(g.b bVar, long j2, long j3) {
        this.f = bVar;
        this.g = j3;
        if (!this.e) {
            this.a.b(this);
            if (j2 != -9223372036854775807L) {
                this.a.seek(0L, j2);
            }
            this.e = true;
            return;
        }
        i9.l lVar = this.a;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        lVar.seek(0L, j2);
        for (int i = 0; i < this.d.size(); i++) {
            ((a) this.d.valueAt(i)).g(bVar, j3);
        }
    }

    @Override // i9.n
    public void endTracks() {
        p1[] p1VarArr = new p1[this.d.size()];
        for (int i = 0; i < this.d.size(); i++) {
            p1VarArr[i] = (p1) com.google.android.exoplayer2.util.a.i(((a) this.d.valueAt(i)).e);
        }
        this.i = p1VarArr;
    }

    @Override // i9.n
    public void g(b0 b0Var) {
        this.h = b0Var;
    }

    @Override // x9.g
    public void release() {
        this.a.release();
    }

    @Override // i9.n
    public e0 track(int i, int i2) {
        a aVar = (a) this.d.get(i);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.g(this.i == null);
            aVar = new a(i, i2, i2 == this.b ? this.c : null);
            aVar.g(this.f, this.g);
            this.d.put(i, aVar);
        }
        return aVar;
    }
}
