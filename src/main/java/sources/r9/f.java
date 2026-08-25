package r9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import i9.m;
import i9.o;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class f {
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    private final d0 k = new d0(255);

    f() {
    }

    public boolean a(m mVar, boolean z) {
        b();
        this.k.L(27);
        if (!o.b(mVar, this.k.d(), 0, 27, z) || this.k.F() != 1332176723) {
            return false;
        }
        int D = this.k.D();
        this.a = D;
        if (D != 0) {
            if (z) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        this.b = this.k.D();
        this.c = this.k.r();
        this.d = this.k.t();
        this.e = this.k.t();
        this.f = this.k.t();
        int D2 = this.k.D();
        this.g = D2;
        this.h = D2 + 27;
        this.k.L(D2);
        if (!o.b(mVar, this.k.d(), 0, this.g, z)) {
            return false;
        }
        for (int i = 0; i < this.g; i++) {
            this.j[i] = this.k.D();
            this.i += this.j[i];
        }
        return true;
    }

    public void b() {
        this.a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean c(m mVar) {
        return d(mVar, -1L);
    }

    public boolean d(m mVar, long j) {
        com.google.android.exoplayer2.util.a.a(mVar.getPosition() == mVar.getPeekPosition());
        this.k.L(4);
        while (true) {
            if ((j == -1 || mVar.getPosition() + 4 < j) && o.b(mVar, this.k.d(), 0, 4, true)) {
                this.k.P(0);
                if (this.k.F() == 1332176723) {
                    mVar.resetPeekPosition();
                    return true;
                }
                mVar.skipFully(1);
            }
        }
        do {
            if (j != -1 && mVar.getPosition() >= j) {
                break;
            }
        } while (mVar.skip(1) != -1);
        return false;
    }
}
