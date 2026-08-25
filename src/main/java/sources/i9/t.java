package i9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.common.collect.ImmutableList;
import i9.v;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class t {

    public static final class a {
        public v a;

        public a(v vVar) {
            this.a = vVar;
        }
    }

    public static boolean a(m mVar) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(4);
        mVar.peekFully(d0Var.d(), 0, 4);
        return d0Var.F() == 1716281667;
    }

    public static int b(m mVar) {
        mVar.resetPeekPosition();
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(2);
        mVar.peekFully(d0Var.d(), 0, 2);
        int J = d0Var.J();
        if ((J >> 2) == 16382) {
            mVar.resetPeekPosition();
            return J;
        }
        mVar.resetPeekPosition();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", (Throwable) null);
    }

    public static Metadata c(m mVar, boolean z) {
        Metadata a2 = new y().a(mVar, z ? null : com.google.android.exoplayer2.metadata.id3.b.b);
        if (a2 == null || a2.length() == 0) {
            return null;
        }
        return a2;
    }

    public static Metadata d(m mVar, boolean z) {
        mVar.resetPeekPosition();
        long peekPosition = mVar.getPeekPosition();
        Metadata c = c(mVar, z);
        mVar.skipFully((int) (mVar.getPeekPosition() - peekPosition));
        return c;
    }

    public static boolean e(m mVar, a aVar) {
        mVar.resetPeekPosition();
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(new byte[4]);
        mVar.peekFully(c0Var.a, 0, 4);
        boolean g = c0Var.g();
        int h = c0Var.h(7);
        int h2 = c0Var.h(24) + 4;
        if (h == 0) {
            aVar.a = h(mVar);
        } else {
            v vVar = aVar.a;
            if (vVar == null) {
                throw new IllegalArgumentException();
            }
            if (h == 3) {
                aVar.a = vVar.b(g(mVar, h2));
            } else if (h == 4) {
                aVar.a = vVar.c(j(mVar, h2));
            } else if (h == 6) {
                com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(h2);
                mVar.readFully(d0Var.d(), 0, h2);
                d0Var.Q(4);
                aVar.a = vVar.a(ImmutableList.of(PictureFrame.fromPictureBlock(d0Var)));
            } else {
                mVar.skipFully(h2);
            }
        }
        return g;
    }

    public static v.a f(com.google.android.exoplayer2.util.d0 d0Var) {
        d0Var.Q(1);
        int G = d0Var.G();
        long e = d0Var.e() + G;
        int i = G / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long w = d0Var.w();
            if (w == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = w;
            jArr2[i2] = d0Var.w();
            d0Var.Q(2);
            i2++;
        }
        d0Var.Q((int) (e - d0Var.e()));
        return new v.a(jArr, jArr2);
    }

    private static v.a g(m mVar, int i) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(i);
        mVar.readFully(d0Var.d(), 0, i);
        return f(d0Var);
    }

    private static v h(m mVar) {
        byte[] bArr = new byte[38];
        mVar.readFully(bArr, 0, 38);
        return new v(bArr, 4);
    }

    public static void i(m mVar) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(4);
        mVar.readFully(d0Var.d(), 0, 4);
        if (d0Var.F() != 1716281667) {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", (Throwable) null);
        }
    }

    private static List j(m mVar, int i) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(i);
        mVar.readFully(d0Var.d(), 0, i);
        d0Var.Q(4);
        return Arrays.asList(h0.j(d0Var, false, false).b);
    }
}
