package k9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.r4;
import i9.a0;
import i9.b0;
import i9.e0;
import i9.j;
import i9.l;
import i9.m;
import i9.n;
import java.util.ArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b implements l {
    private int c;
    private k9.c e;
    private long h;
    private e i;
    private int m;
    private boolean n;
    private final d0 a = new d0(12);
    private final c b = new c();
    private n d = new j();
    private e[] g = new e[0];
    private long k = -1;
    private long l = -1;
    private int j = -1;
    private long f = -9223372036854775807L;

    /* renamed from: k9.b$b, reason: collision with other inner class name */
    private class C0051b implements b0 {
        private final long a;

        public C0051b(long j) {
            this.a = j;
        }

        @Override // i9.b0
        public long getDurationUs() {
            return this.a;
        }

        @Override // i9.b0
        public b0.a getSeekPoints(long j) {
            b0.a i = b.this.g[0].i(j);
            for (int i2 = 1; i2 < b.this.g.length; i2++) {
                b0.a i3 = b.this.g[i2].i(j);
                if (i3.a.b < i.a.b) {
                    i = i3;
                }
            }
            return i;
        }

        @Override // i9.b0
        public boolean isSeekable() {
            return true;
        }
    }

    private static class c {
        public int a;
        public int b;
        public int c;

        private c() {
        }

        public void a(d0 d0Var) {
            this.a = d0Var.q();
            this.b = d0Var.q();
            this.c = 0;
        }

        public void b(d0 d0Var) {
            a(d0Var);
            if (this.a == 1414744396) {
                this.c = d0Var.q();
                return;
            }
            throw ParserException.createForMalformedContainer("LIST expected, found: " + this.a, (Throwable) null);
        }
    }

    private static void e(m mVar) {
        if ((mVar.getPosition() & 1) == 1) {
            mVar.skipFully(1);
        }
    }

    private e f(int i) {
        for (e eVar : this.g) {
            if (eVar.j(i)) {
                return eVar;
            }
        }
        return null;
    }

    private void g(d0 d0Var) {
        f c2 = f.c(1819436136, d0Var);
        if (c2.getType() != 1819436136) {
            throw ParserException.createForMalformedContainer("Unexpected header list type " + c2.getType(), (Throwable) null);
        }
        k9.c cVar = (k9.c) c2.b(k9.c.class);
        if (cVar == null) {
            throw ParserException.createForMalformedContainer("AviHeader not found", (Throwable) null);
        }
        this.e = cVar;
        this.f = cVar.c * cVar.a;
        ArrayList arrayList = new ArrayList();
        r4 it = c2.a.iterator();
        int i = 0;
        while (it.hasNext()) {
            k9.a aVar = (k9.a) it.next();
            if (aVar.getType() == 1819440243) {
                int i2 = i + 1;
                e j = j((f) aVar, i);
                if (j != null) {
                    arrayList.add(j);
                }
                i = i2;
            }
        }
        this.g = (e[]) arrayList.toArray(new e[0]);
        this.d.endTracks();
    }

    private void h(d0 d0Var) {
        long i = i(d0Var);
        while (d0Var.a() >= 16) {
            int q = d0Var.q();
            int q2 = d0Var.q();
            long q3 = d0Var.q() + i;
            d0Var.q();
            e f = f(q);
            if (f != null) {
                if ((q2 & 16) == 16) {
                    f.b(q3);
                }
                f.k();
            }
        }
        for (e eVar : this.g) {
            eVar.c();
        }
        this.n = true;
        this.d.g(new C0051b(this.f));
    }

    private long i(d0 d0Var) {
        if (d0Var.a() < 16) {
            return 0L;
        }
        int e = d0Var.e();
        d0Var.Q(8);
        long q = d0Var.q();
        long j = this.k;
        long j2 = q <= j ? j + 8 : 0L;
        d0Var.P(e);
        return j2;
    }

    private e j(f fVar, int i) {
        d dVar = (d) fVar.b(d.class);
        g gVar = (g) fVar.b(g.class);
        if (dVar == null) {
            s.i("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (gVar == null) {
            s.i("AviExtractor", "Missing Stream Format");
            return null;
        }
        long a2 = dVar.a();
        p1 p1Var = gVar.a;
        p1.b b = p1Var.b();
        b.R(i);
        int i2 = dVar.f;
        if (i2 != 0) {
            b.W(i2);
        }
        h hVar = (h) fVar.b(h.class);
        if (hVar != null) {
            b.U(hVar.a);
        }
        int k = w.k(p1Var.l);
        if (k != 1 && k != 2) {
            return null;
        }
        e0 track = this.d.track(i, k);
        track.d(b.E());
        e eVar = new e(i, k, a2, dVar.e, track);
        this.f = a2;
        return eVar;
    }

    private int k(m mVar) {
        if (mVar.getPosition() >= this.l) {
            return -1;
        }
        e eVar = this.i;
        if (eVar == null) {
            e(mVar);
            mVar.peekFully(this.a.d(), 0, 12);
            this.a.P(0);
            int q = this.a.q();
            if (q == 1414744396) {
                this.a.P(8);
                mVar.skipFully(this.a.q() != 1769369453 ? 8 : 12);
                mVar.resetPeekPosition();
                return 0;
            }
            int q2 = this.a.q();
            if (q == 1263424842) {
                this.h = mVar.getPosition() + q2 + 8;
                return 0;
            }
            mVar.skipFully(8);
            mVar.resetPeekPosition();
            e f = f(q);
            if (f == null) {
                this.h = mVar.getPosition() + q2;
                return 0;
            }
            f.n(q2);
            this.i = f;
        } else if (eVar.m(mVar)) {
            this.i = null;
        }
        return 0;
    }

    private boolean l(m mVar, a0 a0Var) {
        boolean z;
        if (this.h != -1) {
            long position = mVar.getPosition();
            long j = this.h;
            if (j < position || j > 262144 + position) {
                a0Var.a = j;
                z = true;
                this.h = -1L;
                return z;
            }
            mVar.skipFully((int) (j - position));
        }
        z = false;
        this.h = -1L;
        return z;
    }

    @Override // i9.l
    public void b(n nVar) {
        this.c = 0;
        this.d = nVar;
        this.h = -1L;
    }

    @Override // i9.l
    public boolean c(m mVar) {
        mVar.peekFully(this.a.d(), 0, 12);
        this.a.P(0);
        if (this.a.q() != 1179011410) {
            return false;
        }
        this.a.Q(4);
        return this.a.q() == 541677121;
    }

    @Override // i9.l
    public int d(m mVar, a0 a0Var) {
        if (l(mVar, a0Var)) {
            return 1;
        }
        switch (this.c) {
            case 0:
                if (!c(mVar)) {
                    throw ParserException.createForMalformedContainer("AVI Header List not found", (Throwable) null);
                }
                mVar.skipFully(12);
                this.c = 1;
                return 0;
            case 1:
                mVar.readFully(this.a.d(), 0, 12);
                this.a.P(0);
                this.b.b(this.a);
                c cVar = this.b;
                if (cVar.c == 1819436136) {
                    this.j = cVar.b;
                    this.c = 2;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("hdrl expected, found: " + this.b.c, (Throwable) null);
            case 2:
                int i = this.j - 4;
                d0 d0Var = new d0(i);
                mVar.readFully(d0Var.d(), 0, i);
                g(d0Var);
                this.c = 3;
                return 0;
            case 3:
                if (this.k != -1) {
                    long position = mVar.getPosition();
                    long j = this.k;
                    if (position != j) {
                        this.h = j;
                        return 0;
                    }
                }
                mVar.peekFully(this.a.d(), 0, 12);
                mVar.resetPeekPosition();
                this.a.P(0);
                this.b.a(this.a);
                int q = this.a.q();
                int i2 = this.b.a;
                if (i2 == 1179011410) {
                    mVar.skipFully(12);
                    return 0;
                }
                if (i2 != 1414744396 || q != 1769369453) {
                    this.h = mVar.getPosition() + this.b.b + 8;
                    return 0;
                }
                long position2 = mVar.getPosition();
                this.k = position2;
                this.l = position2 + this.b.b + 8;
                if (!this.n) {
                    if (((k9.c) com.google.android.exoplayer2.util.a.e(this.e)).a()) {
                        this.c = 4;
                        this.h = this.l;
                        return 0;
                    }
                    this.d.g(new b0.b(this.f));
                    this.n = true;
                }
                this.h = mVar.getPosition() + 12;
                this.c = 6;
                return 0;
            case 4:
                mVar.readFully(this.a.d(), 0, 8);
                this.a.P(0);
                int q2 = this.a.q();
                int q3 = this.a.q();
                if (q2 == 829973609) {
                    this.c = 5;
                    this.m = q3;
                } else {
                    this.h = mVar.getPosition() + q3;
                }
                return 0;
            case 5:
                d0 d0Var2 = new d0(this.m);
                mVar.readFully(d0Var2.d(), 0, this.m);
                h(d0Var2);
                this.c = 6;
                this.h = this.k;
                return 0;
            case 6:
                return k(mVar);
            default:
                throw new AssertionError();
        }
    }

    @Override // i9.l
    public void release() {
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        this.h = -1L;
        this.i = null;
        for (e eVar : this.g) {
            eVar.o(j);
        }
        if (j != 0) {
            this.c = 6;
        } else if (this.g.length == 0) {
            this.c = 0;
        } else {
            this.c = 3;
        }
    }
}
