package s9;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import i9.b0;
import java.io.EOFException;
import java.util.Map;
import s9.i0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class h implements i9.l {
    public static final i9.r m = new i9.r() { // from class: s9.g
        @Override // i9.r
        public /* synthetic */ i9.l[] c(Uri uri, Map map) {
            return i9.q.a(this, uri, map);
        }

        @Override // i9.r
        public final i9.l[] createExtractors() {
            i9.l[] h;
            h = h.h();
            return h;
        }
    };
    private final int a;
    private final i b;
    private final com.google.android.exoplayer2.util.d0 c;
    private final com.google.android.exoplayer2.util.d0 d;
    private final com.google.android.exoplayer2.util.c0 e;
    private i9.n f;
    private long g;
    private long h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;

    public h() {
        this(0);
    }

    public h(int i) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.b = new i(true);
        this.c = new com.google.android.exoplayer2.util.d0(2048);
        this.i = -1;
        this.h = -1L;
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(10);
        this.d = d0Var;
        this.e = new com.google.android.exoplayer2.util.c0(d0Var.d());
    }

    private void e(i9.m mVar) {
        if (this.j) {
            return;
        }
        this.i = -1;
        mVar.resetPeekPosition();
        long j = 0;
        if (mVar.getPosition() == 0) {
            j(mVar);
        }
        int i = 0;
        int i2 = 0;
        while (mVar.peekFully(this.d.d(), 0, 2, true)) {
            try {
                this.d.P(0);
                if (!i.k(this.d.J())) {
                    break;
                }
                if (!mVar.peekFully(this.d.d(), 0, 4, true)) {
                    break;
                }
                this.e.p(14);
                int h = this.e.h(13);
                if (h <= 6) {
                    this.j = true;
                    throw ParserException.createForMalformedContainer("Malformed ADTS stream", (Throwable) null);
                }
                j += h;
                i2++;
                if (i2 != 1000 && mVar.advancePeekPosition(h - 6, true)) {
                }
                break;
            } catch (EOFException unused) {
            }
        }
        i = i2;
        mVar.resetPeekPosition();
        if (i > 0) {
            this.i = (int) (j / i);
        } else {
            this.i = -1;
        }
        this.j = true;
    }

    private static int f(int i, long j) {
        return (int) ((i * 8000000) / j);
    }

    private i9.b0 g(long j, boolean z) {
        return new i9.e(j, this.h, f(this.i, this.b.i()), this.i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i9.l[] h() {
        return new i9.l[]{new h()};
    }

    private void i(long j, boolean z) {
        if (this.l) {
            return;
        }
        boolean z2 = (this.a & 1) != 0 && this.i > 0;
        if (z2 && this.b.i() == -9223372036854775807L && !z) {
            return;
        }
        if (!z2 || this.b.i() == -9223372036854775807L) {
            this.f.g(new b0.b(-9223372036854775807L));
        } else {
            this.f.g(g(j, (this.a & 2) != 0));
        }
        this.l = true;
    }

    private int j(i9.m mVar) {
        int i = 0;
        while (true) {
            mVar.peekFully(this.d.d(), 0, 10);
            this.d.P(0);
            if (this.d.G() != 4801587) {
                break;
            }
            this.d.Q(3);
            int C = this.d.C();
            i += C + 10;
            mVar.advancePeekPosition(C);
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    @Override // i9.l
    public void b(i9.n nVar) {
        this.f = nVar;
        this.b.d(nVar, new i0.d(0, 1));
        nVar.endTracks();
    }

    @Override // i9.l
    public boolean c(i9.m mVar) {
        int j = j(mVar);
        int i = j;
        int i2 = 0;
        int i3 = 0;
        do {
            mVar.peekFully(this.d.d(), 0, 2);
            this.d.P(0);
            if (i.k(this.d.J())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                mVar.peekFully(this.d.d(), 0, 4);
                this.e.p(14);
                int h = this.e.h(13);
                if (h <= 6) {
                    i++;
                    mVar.resetPeekPosition();
                    mVar.advancePeekPosition(i);
                } else {
                    mVar.advancePeekPosition(h - 6);
                    i3 += h;
                }
            } else {
                i++;
                mVar.resetPeekPosition();
                mVar.advancePeekPosition(i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - j < 8192);
        return false;
    }

    @Override // i9.l
    public int d(i9.m mVar, i9.a0 a0Var) {
        com.google.android.exoplayer2.util.a.i(this.f);
        long length = mVar.getLength();
        int i = this.a;
        if ((i & 2) != 0 || ((i & 1) != 0 && length != -1)) {
            e(mVar);
        }
        int read = mVar.read(this.c.d(), 0, 2048);
        boolean z = read == -1;
        i(length, z);
        if (z) {
            return -1;
        }
        this.c.P(0);
        this.c.O(read);
        if (!this.k) {
            this.b.c(this.g, 4);
            this.k = true;
        }
        this.b.b(this.c);
        return 0;
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        this.k = false;
        this.b.seek();
        this.g = j2;
    }
}
