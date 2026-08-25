package t9;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import i9.m;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class d {

    private static final class a {
        public final int a;
        public final long b;

        private a(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public static a a(m mVar, d0 d0Var) {
            mVar.peekFully(d0Var.d(), 0, 8);
            d0Var.P(0);
            return new a(d0Var.n(), d0Var.t());
        }
    }

    public static boolean a(m mVar) {
        d0 d0Var = new d0(8);
        int i = a.a(mVar, d0Var).a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        mVar.peekFully(d0Var.d(), 0, 4);
        d0Var.P(0);
        int n = d0Var.n();
        if (n == 1463899717) {
            return true;
        }
        s.c("WavHeaderReader", "Unsupported form type: " + n);
        return false;
    }

    public static c b(m mVar) {
        byte[] bArr;
        d0 d0Var = new d0(16);
        a d = d(1718449184, mVar, d0Var);
        com.google.android.exoplayer2.util.a.g(d.b >= 16);
        mVar.peekFully(d0Var.d(), 0, 16);
        d0Var.P(0);
        int v = d0Var.v();
        int v2 = d0Var.v();
        int u = d0Var.u();
        int u2 = d0Var.u();
        int v3 = d0Var.v();
        int v4 = d0Var.v();
        int i = ((int) d.b) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            mVar.peekFully(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = p0.f;
        }
        mVar.skipFully((int) (mVar.getPeekPosition() - mVar.getPosition()));
        return new c(v, v2, u, u2, v3, v4, bArr);
    }

    public static long c(m mVar) {
        d0 d0Var = new d0(8);
        a a2 = a.a(mVar, d0Var);
        if (a2.a != 1685272116) {
            mVar.resetPeekPosition();
            return -1L;
        }
        mVar.advancePeekPosition(8);
        d0Var.P(0);
        mVar.peekFully(d0Var.d(), 0, 8);
        long r = d0Var.r();
        mVar.skipFully(((int) a2.b) + 8);
        return r;
    }

    private static a d(int i, m mVar, d0 d0Var) {
        a a2 = a.a(mVar, d0Var);
        while (a2.a != i) {
            s.i("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.a);
            long j = a2.b + 8;
            if (j > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + a2.a);
            }
            mVar.skipFully((int) j);
            a2 = a.a(mVar, d0Var);
        }
        return a2;
    }

    public static Pair e(m mVar) {
        mVar.resetPeekPosition();
        a d = d(1684108385, mVar, new d0(8));
        mVar.skipFully(8);
        return Pair.create(Long.valueOf(mVar.getPosition()), Long.valueOf(d.b));
    }
}
