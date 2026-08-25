package hy;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class d extends h {
    d() {
    }

    @Override // hy.h
    String b() {
        return "UTF-8";
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x008d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    @Override // hy.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    b c(a aVar) {
        int i;
        byte[] bArr = aVar.e;
        int i2 = 0;
        boolean z = aVar.f >= 3 && (bArr[0] & 255) == 239 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < aVar.f) {
            byte b = bArr[i3];
            if ((b & 128) != 0) {
                if ((b & 224) == 192) {
                    i = 1;
                } else if ((b & 240) == 224) {
                    i = 2;
                } else {
                    if ((b & 248) == 240) {
                        i = 3;
                    }
                    i4++;
                }
                while (true) {
                    i3++;
                    if (i3 < aVar.f) {
                        if ((bArr[i3] & 192) != 128) {
                            break;
                        }
                        i--;
                        if (i == 0) {
                            i5++;
                            break;
                        }
                    }
                }
            }
            i3++;
        }
        if (!z || i4 != 0) {
            if (!z || i5 <= i4 * 10) {
                if (i5 <= 3 || i4 != 0) {
                    if (i5 <= 0 || i4 != 0) {
                        if (i5 == 0 && i4 == 0) {
                            i2 = 15;
                        } else if (i5 > i4 * 10) {
                            i2 = 25;
                        }
                        if (i2 == 0) {
                            return null;
                        }
                        return new b(aVar, this, i2);
                    }
                }
            }
            i2 = 80;
            if (i2 == 0) {
            }
        }
        i2 = 100;
        if (i2 == 0) {
        }
    }
}
