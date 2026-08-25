package i9;

import com.google.android.exoplayer2.util.p0;
import i9.b0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class a {
    protected final C0049a a;
    protected final f b;
    protected c c;
    private final int d;

    /* renamed from: i9.a$a, reason: collision with other inner class name */
    public static class C0049a implements b0 {
        private final d a;
        private final long b;
        private final long c;
        private final long d;
        private final long e;
        private final long f;
        private final long g;

        public C0049a(d dVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.a = dVar;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
        }

        public long g(long j) {
            return this.a.a(j);
        }

        @Override // i9.b0
        public long getDurationUs() {
            return this.b;
        }

        @Override // i9.b0
        public b0.a getSeekPoints(long j) {
            return new b0.a(new c0(j, c.h(this.a.a(j), this.c, this.d, this.e, this.f, this.g)));
        }

        @Override // i9.b0
        public boolean isSeekable() {
            return true;
        }
    }

    public static final class b implements d {
        @Override // i9.a.d
        public long a(long j) {
            return j;
        }
    }

    protected static class c {
        private final long a;
        private final long b;
        private final long c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;

        protected c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.a = j;
            this.b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = h(j2, j3, j4, j5, j6, j7);
        }

        protected static long h(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return p0.r(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long i() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long j() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long k() {
            return this.h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long l() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long m() {
            return this.b;
        }

        private void n() {
            this.h = h(this.b, this.d, this.e, this.f, this.g, this.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(long j, long j2) {
            this.e = j;
            this.g = j2;
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(long j, long j2) {
            this.d = j;
            this.f = j2;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface d {
        long a(long j);
    }

    public static final class e {
        public static final e d = new e(-3, -9223372036854775807L, -1);
        private final int a;
        private final long b;
        private final long c;

        private e(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        public static e d(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e e(long j) {
            return new e(0, -9223372036854775807L, j);
        }

        public static e f(long j, long j2) {
            return new e(-2, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface f {
        void a();

        e b(m mVar, long j);
    }

    protected a(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.b = fVar;
        this.d = i;
        this.a = new C0049a(dVar, j, j2, j3, j4, j5, j6);
    }

    protected c a(long j) {
        return new c(j, this.a.g(j), this.a.c, this.a.d, this.a.e, this.a.f, this.a.g);
    }

    public final b0 b() {
        return this.a;
    }

    public int c(m mVar, a0 a0Var) {
        while (true) {
            c cVar = (c) com.google.android.exoplayer2.util.a.i(this.c);
            long j = cVar.j();
            long i = cVar.i();
            long k = cVar.k();
            if (i - j <= this.d) {
                e(false, j);
                return g(mVar, j, a0Var);
            }
            if (!i(mVar, k)) {
                return g(mVar, k, a0Var);
            }
            mVar.resetPeekPosition();
            e b2 = this.b.b(mVar, cVar.m());
            int i2 = b2.a;
            if (i2 == -3) {
                e(false, k);
                return g(mVar, k, a0Var);
            }
            if (i2 == -2) {
                cVar.p(b2.b, b2.c);
            } else {
                if (i2 != -1) {
                    if (i2 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(mVar, b2.c);
                    e(true, b2.c);
                    return g(mVar, b2.c, a0Var);
                }
                cVar.o(b2.b, b2.c);
            }
        }
    }

    public final boolean d() {
        return this.c != null;
    }

    protected final void e(boolean z, long j) {
        this.c = null;
        this.b.a();
        f(z, j);
    }

    protected void f(boolean z, long j) {
    }

    protected final int g(m mVar, long j, a0 a0Var) {
        if (j == mVar.getPosition()) {
            return 0;
        }
        a0Var.a = j;
        return 1;
    }

    public final void h(long j) {
        c cVar = this.c;
        if (cVar == null || cVar.l() != j) {
            this.c = a(j);
        }
    }

    protected final boolean i(m mVar, long j) {
        long position = j - mVar.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        mVar.skipFully((int) position);
        return true;
    }
}
