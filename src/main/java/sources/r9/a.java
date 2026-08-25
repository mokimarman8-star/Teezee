package r9;

import com.google.android.exoplayer2.util.p0;
import i9.b0;
import i9.c0;
import i9.m;
import i9.o;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class a implements g {
    private final f a;
    private final long b;
    private final long c;
    private final i d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    private final class b implements b0 {
        private b() {
        }

        @Override // i9.b0
        public long getDurationUs() {
            return a.this.d.b(a.this.f);
        }

        @Override // i9.b0
        public b0.a getSeekPoints(long j) {
            return new b0.a(new c0(j, p0.r((a.this.b + ((a.this.d.c(j) * (a.this.c - a.this.b)) / a.this.f)) - 30000, a.this.b, a.this.c - 1)));
        }

        @Override // i9.b0
        public boolean isSeekable() {
            return true;
        }
    }

    public a(i iVar, long j, long j2, long j3, long j4, boolean z) {
        com.google.android.exoplayer2.util.a.a(j >= 0 && j2 > j);
        this.d = iVar;
        this.b = j;
        this.c = j2;
        if (j3 == j2 - j || z) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new f();
    }

    private long g(m mVar) {
        if (this.i == this.j) {
            return -1L;
        }
        long position = mVar.getPosition();
        if (!this.a.d(mVar, this.j)) {
            long j = this.i;
            if (j != position) {
                return j;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.a.a(mVar, false);
        mVar.resetPeekPosition();
        long j2 = this.h;
        f fVar = this.a;
        long j3 = fVar.c;
        long j4 = j2 - j3;
        int i = fVar.h + fVar.i;
        if (0 <= j4 && j4 < 72000) {
            return -1L;
        }
        if (j4 < 0) {
            this.j = position;
            this.l = j3;
        } else {
            this.i = mVar.getPosition() + i;
            this.k = this.a.c;
        }
        long j5 = this.j;
        long j6 = this.i;
        if (j5 - j6 < 100000) {
            this.j = j6;
            return j6;
        }
        long position2 = mVar.getPosition() - (i * (j4 <= 0 ? 2L : 1L));
        long j7 = this.j;
        long j10 = this.i;
        return p0.r(position2 + ((j4 * (j7 - j10)) / (this.l - this.k)), j10, j7 - 1);
    }

    private void i(m mVar) {
        while (true) {
            this.a.c(mVar);
            this.a.a(mVar, false);
            f fVar = this.a;
            if (fVar.c > this.h) {
                mVar.resetPeekPosition();
                return;
            } else {
                mVar.skipFully(fVar.h + fVar.i);
                this.i = mVar.getPosition();
                this.k = this.a.c;
            }
        }
    }

    @Override // r9.g
    public long a(m mVar) {
        int i = this.e;
        if (i == 0) {
            long position = mVar.getPosition();
            this.g = position;
            this.e = 1;
            long j = this.c - 65307;
            if (j > position) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long g = g(mVar);
                if (g != -1) {
                    return g;
                }
                this.e = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            i(mVar);
            this.e = 4;
            return -(this.k + 2);
        }
        this.f = h(mVar);
        this.e = 4;
        return this.g;
    }

    @Override // r9.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b createSeekMap() {
        if (this.f != 0) {
            return new b();
        }
        return null;
    }

    long h(m mVar) {
        this.a.b();
        if (!this.a.c(mVar)) {
            throw new EOFException();
        }
        this.a.a(mVar, false);
        f fVar = this.a;
        mVar.skipFully(fVar.h + fVar.i);
        long j = this.a.c;
        while (true) {
            f fVar2 = this.a;
            if ((fVar2.b & 4) == 4 || !fVar2.c(mVar) || mVar.getPosition() >= this.c || !this.a.a(mVar, true)) {
                break;
            }
            f fVar3 = this.a;
            if (!o.e(mVar, fVar3.h + fVar3.i)) {
                break;
            }
            j = this.a.c;
        }
        return j;
    }

    @Override // r9.g
    public void startSeek(long j) {
        this.h = p0.r(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }
}
