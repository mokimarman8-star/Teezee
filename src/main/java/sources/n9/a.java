package n9;

import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import i9.a0;
import i9.b0;
import i9.l;
import i9.m;
import i9.n;
import q9.k;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a implements l {
    private n b;
    private int c;
    private int d;
    private int e;
    private MotionPhotoMetadata g;
    private m h;
    private c i;
    private k j;
    private final d0 a = new d0(6);
    private long f = -1;

    private void a(m mVar) {
        this.a.L(2);
        mVar.peekFully(this.a.d(), 0, 2);
        mVar.advancePeekPosition(this.a.J() - 2);
    }

    private void e() {
        g(new Metadata.Entry[0]);
        ((n) com.google.android.exoplayer2.util.a.e(this.b)).endTracks();
        this.b.g(new b0.b(-9223372036854775807L));
        this.c = 6;
    }

    private static MotionPhotoMetadata f(String str, long j) {
        b a;
        if (j == -1 || (a = e.a(str)) == null) {
            return null;
        }
        return a.a(j);
    }

    private void g(Metadata.Entry... entryArr) {
        ((n) com.google.android.exoplayer2.util.a.e(this.b)).track(MemoryConstants.KB, 4).d(new p1.b().K("image/jpeg").X(new Metadata(entryArr)).E());
    }

    private int h(m mVar) {
        this.a.L(2);
        mVar.peekFully(this.a.d(), 0, 2);
        return this.a.J();
    }

    private void i(m mVar) {
        this.a.L(2);
        mVar.readFully(this.a.d(), 0, 2);
        int J = this.a.J();
        this.d = J;
        if (J == 65498) {
            if (this.f != -1) {
                this.c = 4;
                return;
            } else {
                e();
                return;
            }
        }
        if ((J < 65488 || J > 65497) && J != 65281) {
            this.c = 1;
        }
    }

    private void j(m mVar) {
        String x;
        if (this.d == 65505) {
            d0 d0Var = new d0(this.e);
            mVar.readFully(d0Var.d(), 0, this.e);
            if (this.g == null && "http://ns.adobe.com/xap/1.0/".equals(d0Var.x()) && (x = d0Var.x()) != null) {
                MotionPhotoMetadata f = f(x, mVar.getLength());
                this.g = f;
                if (f != null) {
                    this.f = f.videoStartPosition;
                }
            }
        } else {
            mVar.skipFully(this.e);
        }
        this.c = 0;
    }

    private void k(m mVar) {
        this.a.L(2);
        mVar.readFully(this.a.d(), 0, 2);
        this.e = this.a.J() - 2;
        this.c = 2;
    }

    private void l(m mVar) {
        if (!mVar.peekFully(this.a.d(), 0, 1, true)) {
            e();
            return;
        }
        mVar.resetPeekPosition();
        if (this.j == null) {
            this.j = new k();
        }
        c cVar = new c(mVar, this.f);
        this.i = cVar;
        if (!this.j.c(cVar)) {
            e();
        } else {
            this.j.b(new d(this.f, (n) com.google.android.exoplayer2.util.a.e(this.b)));
            m();
        }
    }

    private void m() {
        g((Metadata.Entry) com.google.android.exoplayer2.util.a.e(this.g));
        this.c = 5;
    }

    @Override // i9.l
    public void b(n nVar) {
        this.b = nVar;
    }

    @Override // i9.l
    public boolean c(m mVar) {
        if (h(mVar) != 65496) {
            return false;
        }
        int h = h(mVar);
        this.d = h;
        if (h == 65504) {
            a(mVar);
            this.d = h(mVar);
        }
        if (this.d != 65505) {
            return false;
        }
        mVar.advancePeekPosition(2);
        this.a.L(6);
        mVar.peekFully(this.a.d(), 0, 6);
        return this.a.F() == 1165519206 && this.a.J() == 0;
    }

    @Override // i9.l
    public int d(m mVar, a0 a0Var) {
        int i = this.c;
        if (i == 0) {
            i(mVar);
            return 0;
        }
        if (i == 1) {
            k(mVar);
            return 0;
        }
        if (i == 2) {
            j(mVar);
            return 0;
        }
        if (i == 4) {
            long position = mVar.getPosition();
            long j = this.f;
            if (position != j) {
                a0Var.a = j;
                return 1;
            }
            l(mVar);
            return 0;
        }
        if (i != 5) {
            if (i == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.i == null || mVar != this.h) {
            this.h = mVar;
            this.i = new c(mVar, this.f);
        }
        int d = ((k) com.google.android.exoplayer2.util.a.e(this.j)).d(this.i, a0Var);
        if (d == 1) {
            a0Var.a += this.f;
        }
        return d;
    }

    @Override // i9.l
    public void release() {
        k kVar = this.j;
        if (kVar != null) {
            kVar.release();
        }
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        if (j == 0) {
            this.c = 0;
            this.j = null;
        } else if (this.c == 5) {
            ((k) com.google.android.exoplayer2.util.a.e(this.j)).seek(j, j2);
        }
    }
}
