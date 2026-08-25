package j9;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import i9.a0;
import i9.b0;
import i9.e;
import i9.e0;
import i9.l;
import i9.m;
import i9.n;
import i9.q;
import i9.r;
import java.io.EOFException;
import java.util.Arrays;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b implements l {
    private static final int[] r;
    private static final int u;
    private final byte[] a;
    private final int b;
    private boolean c;
    private long d;
    private int e;
    private int f;
    private boolean g;
    private long h;
    private int i;
    private int j;
    private long k;
    private n l;
    private e0 m;
    private b0 n;
    private boolean o;
    public static final r p = new r() { // from class: j9.a
        @Override // i9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // i9.r
        public final l[] createExtractors() {
            l[] l;
            l = b.l();
            return l;
        }
    };
    private static final int[] q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final byte[] s = p0.n0("#!AMR\n");
    private static final byte[] t = p0.n0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        r = iArr;
        u = iArr[8];
    }

    public b() {
        this(0);
    }

    public b(int i) {
        this.b = (i & 2) != 0 ? i | 1 : i;
        this.a = new byte[1];
        this.i = -1;
    }

    private void e() {
        com.google.android.exoplayer2.util.a.i(this.m);
        p0.j(this.l);
    }

    private static int f(int i, long j) {
        return (int) ((i * 8000000) / j);
    }

    private b0 g(long j, boolean z) {
        return new e(j, this.h, f(this.i, 20000L), this.i, z);
    }

    private int h(int i) {
        if (j(i)) {
            return this.c ? r[i] : q[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.c ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i);
        throw ParserException.createForMalformedContainer(sb.toString(), (Throwable) null);
    }

    private boolean i(int i) {
        return !this.c && (i < 12 || i > 14);
    }

    private boolean j(int i) {
        return i >= 0 && i <= 15 && (k(i) || i(i));
    }

    private boolean k(int i) {
        return this.c && (i < 10 || i > 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] l() {
        return new l[]{new b()};
    }

    private void m() {
        if (this.o) {
            return;
        }
        this.o = true;
        boolean z = this.c;
        this.m.d(new p1.b().e0(z ? "audio/amr-wb" : "audio/3gpp").W(u).H(1).f0(z ? 16000 : 8000).E());
    }

    private void n(long j, int i) {
        int i2;
        if (this.g) {
            return;
        }
        int i3 = this.b;
        if ((i3 & 1) == 0 || j == -1 || !((i2 = this.i) == -1 || i2 == this.e)) {
            b0.b bVar = new b0.b(-9223372036854775807L);
            this.n = bVar;
            this.l.g(bVar);
            this.g = true;
            return;
        }
        if (this.j >= 20 || i == -1) {
            b0 g = g(j, (i3 & 2) != 0);
            this.n = g;
            this.l.g(g);
            this.g = true;
        }
    }

    private static boolean o(m mVar, byte[] bArr) {
        mVar.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        mVar.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int p(m mVar) {
        mVar.resetPeekPosition();
        mVar.peekFully(this.a, 0, 1);
        byte b = this.a[0];
        if ((b & 131) <= 0) {
            return h((b >> 3) & 15);
        }
        throw ParserException.createForMalformedContainer("Invalid padding bits for frame header " + ((int) b), (Throwable) null);
    }

    private boolean q(m mVar) {
        byte[] bArr = s;
        if (o(mVar, bArr)) {
            this.c = false;
            mVar.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = t;
        if (!o(mVar, bArr2)) {
            return false;
        }
        this.c = true;
        mVar.skipFully(bArr2.length);
        return true;
    }

    private int r(m mVar) {
        if (this.f == 0) {
            try {
                int p2 = p(mVar);
                this.e = p2;
                this.f = p2;
                if (this.i == -1) {
                    this.h = mVar.getPosition();
                    this.i = this.e;
                }
                if (this.i == this.e) {
                    this.j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int b = this.m.b(mVar, this.f, true);
        if (b == -1) {
            return -1;
        }
        int i = this.f - b;
        this.f = i;
        if (i > 0) {
            return 0;
        }
        this.m.e(this.k + this.d, 1, this.e, 0, null);
        this.d += 20000;
        return 0;
    }

    @Override // i9.l
    public void b(n nVar) {
        this.l = nVar;
        this.m = nVar.track(0, 1);
        nVar.endTracks();
    }

    @Override // i9.l
    public boolean c(m mVar) {
        return q(mVar);
    }

    @Override // i9.l
    public int d(m mVar, a0 a0Var) {
        e();
        if (mVar.getPosition() == 0 && !q(mVar)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", (Throwable) null);
        }
        m();
        int r2 = r(mVar);
        n(mVar.getLength(), r2);
        return r2;
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        this.d = 0L;
        this.e = 0;
        this.f = 0;
        if (j != 0) {
            b0 b0Var = this.n;
            if (b0Var instanceof e) {
                this.k = ((e) b0Var).c(j);
                return;
            }
        }
        this.k = 0L;
    }
}
