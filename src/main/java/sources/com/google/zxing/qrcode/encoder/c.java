package com.google.zxing.qrcode.encoder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class c {
    static int a(ae.a aVar) {
        return b(aVar, true) + b(aVar, false);
    }

    private static int b(ae.a aVar, boolean z) {
        int d = z ? aVar.d() : aVar.e();
        int e = z ? aVar.e() : aVar.d();
        byte[][] c = aVar.c();
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            byte b = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < e; i4++) {
                byte b2 = z ? c[i2][i4] : c[i4][i2];
                if (b2 == b) {
                    i3++;
                } else {
                    if (i3 >= 5) {
                        i += i3 - 2;
                    }
                    i3 = 1;
                    b = b2;
                }
            }
            if (i3 >= 5) {
                i += i3 - 2;
            }
        }
        return i;
    }

    static int c(ae.a aVar) {
        byte[][] c = aVar.c();
        int e = aVar.e();
        int d = aVar.d();
        int i = 0;
        for (int i2 = 0; i2 < d - 1; i2++) {
            byte[] bArr = c[i2];
            int i3 = 0;
            while (i3 < e - 1) {
                byte b = bArr[i3];
                int i4 = i3 + 1;
                if (b == bArr[i4]) {
                    byte[] bArr2 = c[i2 + 1];
                    if (b == bArr2[i3] && b == bArr2[i4]) {
                        i++;
                    }
                }
                i3 = i4;
            }
        }
        return i * 3;
    }

    static int d(ae.a aVar) {
        byte[][] c = aVar.c();
        int e = aVar.e();
        int d = aVar.d();
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            for (int i3 = 0; i3 < e; i3++) {
                byte[] bArr = c[i2];
                int i4 = i3 + 6;
                if (i4 < e && bArr[i3] == 1 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1 && bArr[i3 + 3] == 1 && bArr[i3 + 4] == 1 && bArr[i3 + 5] == 0 && bArr[i4] == 1 && (g(bArr, i3 - 4, i3) || g(bArr, i3 + 7, i3 + 11))) {
                    i++;
                }
                int i5 = i2 + 6;
                if (i5 < d && c[i2][i3] == 1 && c[i2 + 1][i3] == 0 && c[i2 + 2][i3] == 1 && c[i2 + 3][i3] == 1 && c[i2 + 4][i3] == 1 && c[i2 + 5][i3] == 0 && c[i5][i3] == 1 && (h(c, i3, i2 - 4, i2) || h(c, i3, i2 + 7, i2 + 11))) {
                    i++;
                }
            }
        }
        return i * 40;
    }

    static int e(ae.a aVar) {
        byte[][] c = aVar.c();
        int e = aVar.e();
        int d = aVar.d();
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            byte[] bArr = c[i2];
            for (int i3 = 0; i3 < e; i3++) {
                if (bArr[i3] == 1) {
                    i++;
                }
            }
        }
        int d2 = aVar.d() * aVar.e();
        return ((Math.abs((i * 2) - d2) * 10) / d2) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean f(int i, int i2, int i3) {
        int i4;
        int i5;
        switch (i) {
            case 0:
                i3 += i2;
                i4 = i3 & 1;
                return i4 != 0;
            case 1:
                i4 = i3 & 1;
                if (i4 != 0) {
                }
                break;
            case 2:
                i4 = i2 % 3;
                if (i4 != 0) {
                }
                break;
            case 3:
                i4 = (i3 + i2) % 3;
                if (i4 != 0) {
                }
                break;
            case 4:
                i3 /= 2;
                i2 /= 3;
                i3 += i2;
                i4 = i3 & 1;
                if (i4 != 0) {
                }
                break;
            case 5:
                int i6 = i3 * i2;
                i4 = (i6 & 1) + (i6 % 3);
                if (i4 != 0) {
                }
                break;
            case 6:
                int i7 = i3 * i2;
                i5 = (i7 & 1) + (i7 % 3);
                i4 = i5 & 1;
                if (i4 != 0) {
                }
                break;
            case 7:
                i5 = ((i3 * i2) % 3) + ((i3 + i2) & 1);
                i4 = i5 & 1;
                if (i4 != 0) {
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i);
        }
    }

    private static boolean g(byte[] bArr, int i, int i2) {
        if (i < 0 || bArr.length < i2) {
            return false;
        }
        while (i < i2) {
            if (bArr[i] == 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i, int i2, int i3) {
        if (i2 < 0 || bArr.length < i3) {
            return false;
        }
        while (i2 < i3) {
            if (bArr[i2][i] == 1) {
                return false;
            }
            i2++;
        }
        return true;
    }
}
