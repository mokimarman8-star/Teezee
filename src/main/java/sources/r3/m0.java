package r3;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class m0 {
    public static int a(byte[] bArr, int i5, int i6) {
        while (i5 < i6 && bArr[i5] != 71) {
            i5++;
        }
        return i5;
    }

    public static boolean b(byte[] bArr, int i5, int i6, int i7) {
        int i8 = 0;
        for (int i9 = -4; i9 <= 4; i9++) {
            int i10 = (i9 * 188) + i7;
            if (i10 < i5 || i10 >= i6 || bArr[i10] != 71) {
                i8 = 0;
            } else {
                i8++;
                if (i8 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(androidx.media3.common.util.j0 j0Var, int i5, int i6) {
        j0Var.W(i5);
        if (j0Var.a() < 5) {
            return -9223372036854775807L;
        }
        int q5 = j0Var.q();
        if ((8388608 & q5) != 0 || ((2096896 & q5) >> 8) != i6 || (q5 & 32) == 0 || j0Var.H() < 7 || j0Var.a() < 7 || (j0Var.H() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        j0Var.l(bArr, 0, 6);
        return d(bArr);
    }

    private static long d(byte[] bArr) {
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((255 & bArr[4]) >> 7);
    }
}
