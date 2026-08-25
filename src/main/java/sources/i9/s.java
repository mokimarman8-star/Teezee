package i9;

import com.cloud.tmc.kernel.bridge.extension.BridgeResponse;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class s {

    public static final class a {
        public long a;
    }

    private static boolean a(com.google.android.exoplayer2.util.d0 d0Var, v vVar, int i) {
        int j = j(d0Var, i);
        return j != -1 && j <= vVar.b;
    }

    private static boolean b(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        return d0Var.D() == p0.u(d0Var.d(), i, d0Var.e() - 1, 0);
    }

    private static boolean c(com.google.android.exoplayer2.util.d0 d0Var, v vVar, boolean z, a aVar) {
        try {
            long K = d0Var.K();
            if (!z) {
                K *= vVar.b;
            }
            aVar.a = K;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(com.google.android.exoplayer2.util.d0 d0Var, v vVar, int i, a aVar) {
        int e = d0Var.e();
        long F = d0Var.F();
        long j = F >>> 16;
        if (j != i) {
            return false;
        }
        return g((int) ((F >> 4) & 15), vVar) && f((int) ((F >> 1) & 7), vVar) && !(((F & 1) > 1L ? 1 : ((F & 1) == 1L ? 0 : -1)) == 0) && c(d0Var, vVar, ((j & 1) > 1L ? 1 : ((j & 1) == 1L ? 0 : -1)) == 0, aVar) && a(d0Var, vVar, (int) ((F >> 12) & 15)) && e(d0Var, vVar, (int) ((F >> 8) & 15)) && b(d0Var, e);
    }

    private static boolean e(com.google.android.exoplayer2.util.d0 d0Var, v vVar, int i) {
        int i2 = vVar.e;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == vVar.f;
        }
        if (i == 12) {
            return d0Var.D() * 1000 == i2;
        }
        if (i > 14) {
            return false;
        }
        int J = d0Var.J();
        if (i == 14) {
            J *= 10;
        }
        return J == i2;
    }

    private static boolean f(int i, v vVar) {
        return i == 0 || i == vVar.i;
    }

    private static boolean g(int i, v vVar) {
        return i <= 7 ? i == vVar.g - 1 : i <= 10 && vVar.g == 2;
    }

    public static boolean h(m mVar, v vVar, int i, a aVar) {
        long peekPosition = mVar.getPeekPosition();
        byte[] bArr = new byte[2];
        mVar.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            mVar.resetPeekPosition();
            mVar.advancePeekPosition((int) (peekPosition - mVar.getPosition()));
            return false;
        }
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(16);
        System.arraycopy(bArr, 0, d0Var.d(), 0, 2);
        d0Var.O(o.c(mVar, d0Var.d(), 2, 14));
        mVar.resetPeekPosition();
        mVar.advancePeekPosition((int) (peekPosition - mVar.getPosition()));
        return d(d0Var, vVar, i, aVar);
    }

    public static long i(m mVar, v vVar) {
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        mVar.peekFully(bArr, 0, 1);
        boolean z = (bArr[0] & 1) == 1;
        mVar.advancePeekPosition(2);
        int i = z ? 7 : 6;
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(i);
        d0Var.O(o.c(mVar, d0Var.d(), 0, i));
        mVar.resetPeekPosition();
        a aVar = new a();
        if (c(d0Var, vVar, z, aVar)) {
            return aVar.a;
        }
        throw ParserException.createForMalformedContainer((String) null, (Throwable) null);
    }

    public static int j(com.google.android.exoplayer2.util.d0 d0Var, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return d0Var.D() + 1;
            case 7:
                return d0Var.J() + 1;
            case 8:
            case 9:
            case BridgeResponse.ERROR_CODE_UNAUTHORIZED_USERINFO /* 10 */:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
