package p9;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.b;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import i9.a0;
import i9.e0;
import i9.k;
import i9.l;
import i9.m;
import i9.n;
import i9.q;
import i9.r;
import i9.x;
import i9.y;
import java.io.EOFException;
import java.util.Map;
import p9.g;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class f implements l {
    public static final r u = new r() { // from class: p9.d
        @Override // i9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // i9.r
        public final l[] createExtractors() {
            l[] n;
            n = f.n();
            return n;
        }
    };
    private static final b.a v = new b.a() { // from class: p9.e
        public final boolean evaluate(int i, int i2, int i3, int i4, int i5) {
            boolean o;
            o = f.o(i, i2, i3, i4, i5);
            return o;
        }
    };
    private final int a;
    private final long b;
    private final d0 c;
    private final b0.a d;
    private final x e;
    private final y f;
    private final e0 g;
    private n h;
    private e0 i;
    private e0 j;
    private int k;
    private Metadata l;
    private long m;
    private long n;
    private long o;
    private int p;
    private g q;
    private boolean r;
    private boolean s;
    private long t;

    public f() {
        this(0);
    }

    public f(int i) {
        this(i, -9223372036854775807L);
    }

    public f(int i, long j) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.b = j;
        this.c = new d0(10);
        this.d = new b0.a();
        this.e = new x();
        this.m = -9223372036854775807L;
        this.f = new y();
        k kVar = new k();
        this.g = kVar;
        this.j = kVar;
    }

    private void f() {
        com.google.android.exoplayer2.util.a.i(this.i);
        p0.j(this.h);
    }

    private g g(m mVar) {
        long k;
        long j;
        g q = q(mVar);
        c p = p(this.l, mVar.getPosition());
        if (this.r) {
            return new g.a();
        }
        if ((this.a & 4) != 0) {
            if (p != null) {
                k = p.getDurationUs();
                j = p.a();
            } else if (q != null) {
                k = q.getDurationUs();
                j = q.a();
            } else {
                k = k(this.l);
                j = -1;
            }
            q = new b(k, mVar.getPosition(), j);
        } else if (p != null) {
            q = p;
        } else if (q == null) {
            q = null;
        }
        if (q == null || !(q.isSeekable() || (this.a & 1) == 0)) {
            return j(mVar, (this.a & 2) != 0);
        }
        return q;
    }

    private long h(long j) {
        return this.m + ((j * 1000000) / this.d.d);
    }

    private g j(m mVar, boolean z) {
        mVar.peekFully(this.c.d(), 0, 4);
        this.c.P(0);
        this.d.a(this.c.n());
        return new a(mVar.getLength(), mVar.getPosition(), this.d, z);
    }

    private static long k(Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.length();
        for (int i = 0; i < length; i++) {
            TextInformationFrame textInformationFrame = metadata.get(i);
            if (textInformationFrame instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame2 = textInformationFrame;
                if (((Id3Frame) textInformationFrame2).id.equals("TLEN")) {
                    return p0.B0(Long.parseLong(textInformationFrame2.value));
                }
            }
        }
        return -9223372036854775807L;
    }

    private static int l(d0 d0Var, int i) {
        if (d0Var.f() >= i + 4) {
            d0Var.P(i);
            int n = d0Var.n();
            if (n == 1483304551 || n == 1231971951) {
                return n;
            }
        }
        if (d0Var.f() < 40) {
            return 0;
        }
        d0Var.P(36);
        return d0Var.n() == 1447187017 ? 1447187017 : 0;
    }

    private static boolean m(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] n() {
        return new l[]{new f()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean o(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    private static c p(Metadata metadata, long j) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i = 0; i < length; i++) {
            MlltFrame mlltFrame = metadata.get(i);
            if (mlltFrame instanceof MlltFrame) {
                return c.b(j, mlltFrame, k(metadata));
            }
        }
        return null;
    }

    private g q(m mVar) {
        d0 d0Var = new d0(this.d.c);
        mVar.peekFully(d0Var.d(), 0, this.d.c);
        b0.a aVar = this.d;
        int i = 21;
        if ((aVar.a & 1) != 0) {
            if (aVar.e != 1) {
                i = 36;
            }
        } else if (aVar.e == 1) {
            i = 13;
        }
        int i2 = i;
        int l = l(d0Var, i2);
        if (l != 1483304551 && l != 1231971951) {
            if (l != 1447187017) {
                mVar.resetPeekPosition();
                return null;
            }
            h b = h.b(mVar.getLength(), mVar.getPosition(), this.d, d0Var);
            mVar.skipFully(this.d.c);
            return b;
        }
        i b2 = i.b(mVar.getLength(), mVar.getPosition(), this.d, d0Var);
        if (b2 != null && !this.e.a()) {
            mVar.resetPeekPosition();
            mVar.advancePeekPosition(i2 + 141);
            mVar.peekFully(this.c.d(), 0, 3);
            this.c.P(0);
            this.e.d(this.c.G());
        }
        mVar.skipFully(this.d.c);
        return (b2 == null || b2.isSeekable() || l != 1231971951) ? b2 : j(mVar, false);
    }

    private boolean r(m mVar) {
        g gVar = this.q;
        if (gVar != null) {
            long a = gVar.a();
            if (a != -1 && mVar.getPeekPosition() > a - 4) {
                return true;
            }
        }
        try {
            return !mVar.peekFully(this.c.d(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private int s(m mVar) {
        if (this.k == 0) {
            try {
                u(mVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.q == null) {
            g g = g(mVar);
            this.q = g;
            this.h.g(g);
            this.j.d(new p1.b().e0(this.d.b).W(4096).H(this.d.e).f0(this.d.d).N(this.e.a).O(this.e.b).X((this.a & 8) != 0 ? null : this.l).E());
            this.o = mVar.getPosition();
        } else if (this.o != 0) {
            long position = mVar.getPosition();
            long j = this.o;
            if (position < j) {
                mVar.skipFully((int) (j - position));
            }
        }
        return t(mVar);
    }

    private int t(m mVar) {
        if (this.p == 0) {
            mVar.resetPeekPosition();
            if (r(mVar)) {
                return -1;
            }
            this.c.P(0);
            int n = this.c.n();
            if (!m(n, this.k) || b0.j(n) == -1) {
                mVar.skipFully(1);
                this.k = 0;
                return 0;
            }
            this.d.a(n);
            if (this.m == -9223372036854775807L) {
                this.m = this.q.getTimeUs(mVar.getPosition());
                if (this.b != -9223372036854775807L) {
                    this.m += this.b - this.q.getTimeUs(0L);
                }
            }
            this.p = this.d.c;
            g gVar = this.q;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.c(h(this.n + r0.g), mVar.getPosition() + this.d.c);
                if (this.s && bVar.b(this.t)) {
                    this.s = false;
                    this.j = this.i;
                }
            }
        }
        int b = this.j.b(mVar, this.p, true);
        if (b == -1) {
            return -1;
        }
        int i = this.p - b;
        this.p = i;
        if (i > 0) {
            return 0;
        }
        this.j.e(h(this.n), 1, this.d.c, 0, null);
        this.n += this.d.g;
        this.p = 0;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x009a, code lost:
    
        if (r13 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009c, code lost:
    
        r12.skipFully(r1 + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a4, code lost:
    
        r11.k = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a6, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a1, code lost:
    
        r12.resetPeekPosition();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean u(m mVar, boolean z) {
        int i;
        int i2;
        int j;
        int i3 = z ? 32768 : 131072;
        mVar.resetPeekPosition();
        if (mVar.getPosition() == 0) {
            Metadata a = this.f.a(mVar, (this.a & 8) == 0 ? null : v);
            this.l = a;
            if (a != null) {
                this.e.c(a);
            }
            i = (int) mVar.getPeekPosition();
            if (!z) {
                mVar.skipFully(i);
            }
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i4 = i2;
        int i5 = i4;
        while (true) {
            if (!r(mVar)) {
                this.c.P(0);
                int n = this.c.n();
                if ((i2 == 0 || m(n, i2)) && (j = b0.j(n)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.d.a(n);
                        i2 = n;
                    }
                    mVar.advancePeekPosition(j - 4);
                } else {
                    int i6 = i5 + 1;
                    if (i5 == i3) {
                        if (z) {
                            return false;
                        }
                        throw ParserException.createForMalformedContainer("Searched too many bytes.", (Throwable) null);
                    }
                    if (z) {
                        mVar.resetPeekPosition();
                        mVar.advancePeekPosition(i + i6);
                    } else {
                        mVar.skipFully(1);
                    }
                    i4 = 0;
                    i5 = i6;
                    i2 = 0;
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
    }

    @Override // i9.l
    public void b(n nVar) {
        this.h = nVar;
        e0 track = nVar.track(0, 1);
        this.i = track;
        this.j = track;
        this.h.endTracks();
    }

    @Override // i9.l
    public boolean c(m mVar) {
        return u(mVar, true);
    }

    @Override // i9.l
    public int d(m mVar, a0 a0Var) {
        f();
        int s = s(mVar);
        if (s == -1 && (this.q instanceof b)) {
            long h = h(this.n);
            if (this.q.getDurationUs() != h) {
                ((b) this.q).d(h);
                this.h.g(this.q);
            }
        }
        return s;
    }

    public void i() {
        this.r = true;
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        this.k = 0;
        this.m = -9223372036854775807L;
        this.n = 0L;
        this.p = 0;
        this.t = j2;
        g gVar = this.q;
        if (!(gVar instanceof b) || ((b) gVar).b(j2)) {
            return;
        }
        this.s = true;
        this.j = this.g;
    }
}
