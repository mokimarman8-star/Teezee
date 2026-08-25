package s9;

import android.net.Uri;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.l0;
import i9.b0;
import java.util.Map;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a0 implements i9.l {
    public static final i9.r l = new i9.r() { // from class: s9.z
        @Override // i9.r
        public /* synthetic */ i9.l[] c(Uri uri, Map map) {
            return i9.q.a(this, uri, map);
        }

        @Override // i9.r
        public final i9.l[] createExtractors() {
            i9.l[] e;
            e = a0.e();
            return e;
        }
    };
    private final l0 a;
    private final SparseArray b;
    private final com.google.android.exoplayer2.util.d0 c;
    private final y d;
    private boolean e;
    private boolean f;
    private boolean g;
    private long h;
    private x i;
    private i9.n j;
    private boolean k;

    private static final class a {
        private final m a;
        private final l0 b;
        private final com.google.android.exoplayer2.util.c0 c = new com.google.android.exoplayer2.util.c0(new byte[64]);
        private boolean d;
        private boolean e;
        private boolean f;
        private int g;
        private long h;

        public a(m mVar, l0 l0Var) {
            this.a = mVar;
            this.b = l0Var;
        }

        private void b() {
            this.c.r(8);
            this.d = this.c.g();
            this.e = this.c.g();
            this.c.r(6);
            this.g = this.c.h(8);
        }

        private void c() {
            this.h = 0L;
            if (this.d) {
                this.c.r(4);
                this.c.r(1);
                this.c.r(1);
                long h = (this.c.h(3) << 30) | (this.c.h(15) << 15) | this.c.h(15);
                this.c.r(1);
                if (!this.f && this.e) {
                    this.c.r(4);
                    this.c.r(1);
                    this.c.r(1);
                    this.c.r(1);
                    this.b.b((this.c.h(3) << 30) | (this.c.h(15) << 15) | this.c.h(15));
                    this.f = true;
                }
                this.h = this.b.b(h);
            }
        }

        public void a(com.google.android.exoplayer2.util.d0 d0Var) {
            d0Var.j(this.c.a, 0, 3);
            this.c.p(0);
            b();
            d0Var.j(this.c.a, 0, this.g);
            this.c.p(0);
            c();
            this.a.c(this.h, 4);
            this.a.b(d0Var);
            this.a.packetFinished();
        }

        public void d() {
            this.f = false;
            this.a.seek();
        }
    }

    public a0() {
        this(new l0(0L));
    }

    public a0(l0 l0Var) {
        this.a = l0Var;
        this.c = new com.google.android.exoplayer2.util.d0(4096);
        this.b = new SparseArray();
        this.d = new y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i9.l[] e() {
        return new i9.l[]{new a0()};
    }

    private void f(long j) {
        if (this.k) {
            return;
        }
        this.k = true;
        if (this.d.c() == -9223372036854775807L) {
            this.j.g(new b0.b(this.d.c()));
            return;
        }
        x xVar = new x(this.d.d(), this.d.c(), j);
        this.i = xVar;
        this.j.g(xVar.b());
    }

    @Override // i9.l
    public void b(i9.n nVar) {
        this.j = nVar;
    }

    @Override // i9.l
    public boolean c(i9.m mVar) {
        byte[] bArr = new byte[14];
        mVar.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        mVar.advancePeekPosition(bArr[13] & 7);
        mVar.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // i9.l
    public int d(i9.m mVar, i9.a0 a0Var) {
        m mVar2;
        com.google.android.exoplayer2.util.a.i(this.j);
        long length = mVar.getLength();
        if (length != -1 && !this.d.e()) {
            return this.d.g(mVar, a0Var);
        }
        f(length);
        x xVar = this.i;
        if (xVar != null && xVar.d()) {
            return this.i.c(mVar, a0Var);
        }
        mVar.resetPeekPosition();
        long peekPosition = length != -1 ? length - mVar.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !mVar.peekFully(this.c.d(), 0, 4, true)) {
            return -1;
        }
        this.c.P(0);
        int n = this.c.n();
        if (n == 441) {
            return -1;
        }
        if (n == 442) {
            mVar.peekFully(this.c.d(), 0, 10);
            this.c.P(9);
            mVar.skipFully((this.c.D() & 7) + 14);
            return 0;
        }
        if (n == 443) {
            mVar.peekFully(this.c.d(), 0, 2);
            this.c.P(0);
            mVar.skipFully(this.c.J() + 6);
            return 0;
        }
        if (((n & (-256)) >> 8) != 1) {
            mVar.skipFully(1);
            return 0;
        }
        int i = n & 255;
        a aVar = (a) this.b.get(i);
        if (!this.e) {
            if (aVar == null) {
                if (i == 189) {
                    mVar2 = new c();
                    this.f = true;
                    this.h = mVar.getPosition();
                } else if ((n & 224) == 192) {
                    mVar2 = new t();
                    this.f = true;
                    this.h = mVar.getPosition();
                } else if ((n & 240) == 224) {
                    mVar2 = new n();
                    this.g = true;
                    this.h = mVar.getPosition();
                } else {
                    mVar2 = null;
                }
                if (mVar2 != null) {
                    mVar2.d(this.j, new i0.d(i, 256));
                    aVar = new a(mVar2, this.a);
                    this.b.put(i, aVar);
                }
            }
            if (mVar.getPosition() > ((this.f && this.g) ? this.h + 8192 : 1048576L)) {
                this.e = true;
                this.j.endTracks();
            }
        }
        mVar.peekFully(this.c.d(), 0, 2);
        this.c.P(0);
        int J = this.c.J() + 6;
        if (aVar == null) {
            mVar.skipFully(J);
        } else {
            this.c.L(J);
            mVar.readFully(this.c.d(), 0, J);
            this.c.P(6);
            aVar.a(this.c);
            com.google.android.exoplayer2.util.d0 d0Var = this.c;
            d0Var.O(d0Var.b());
        }
        return 0;
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        boolean z = this.a.e() == -9223372036854775807L;
        if (!z) {
            long c = this.a.c();
            z = (c == -9223372036854775807L || c == 0 || c == j2) ? false : true;
        }
        if (z) {
            this.a.g(j2);
        }
        x xVar = this.i;
        if (xVar != null) {
            xVar.h(j2);
        }
        for (int i = 0; i < this.b.size(); i++) {
            ((a) this.b.valueAt(i)).d();
        }
    }
}
