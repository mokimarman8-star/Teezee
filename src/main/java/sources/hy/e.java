package hy;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class e extends h {

    static class a extends e {
        a() {
        }

        @Override // hy.h
        String b() {
            return "UTF-16BE";
        }

        @Override // hy.h
        hy.b c(hy.a aVar) {
            byte[] bArr = aVar.e;
            int min = Math.min(bArr.length, 30);
            int i = 10;
            int i2 = 0;
            while (true) {
                if (i2 >= min - 1) {
                    break;
                }
                int e = e.e(bArr[i2], bArr[i2 + 1]);
                if (i2 != 0 || e != 65279) {
                    i = e.d(e, i);
                    if (i == 0 || i == 100) {
                        break;
                    }
                    i2 += 2;
                } else {
                    i = 100;
                    break;
                }
            }
            int i3 = (min >= 4 || i >= 100) ? i : 0;
            if (i3 > 0) {
                return new hy.b(aVar, this, i3);
            }
            return null;
        }
    }

    static class b extends e {
        b() {
        }

        @Override // hy.h
        String b() {
            return "UTF-16LE";
        }

        @Override // hy.h
        hy.b c(hy.a aVar) {
            byte[] bArr = aVar.e;
            int min = Math.min(bArr.length, 30);
            int i = 10;
            int i2 = 0;
            while (true) {
                if (i2 >= min - 1) {
                    break;
                }
                int e = e.e(bArr[i2 + 1], bArr[i2]);
                if (i2 != 0 || e != 65279) {
                    i = e.d(e, i);
                    if (i == 0 || i == 100) {
                        break;
                    }
                    i2 += 2;
                } else {
                    i = 100;
                    break;
                }
            }
            int i3 = (min >= 4 || i >= 100) ? i : 0;
            if (i3 > 0) {
                return new hy.b(aVar, this, i3);
            }
            return null;
        }
    }

    static abstract class c extends e {
        c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        @Override // hy.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        hy.b c(hy.a aVar) {
            byte[] bArr = aVar.e;
            int i = (aVar.f / 4) * 4;
            if (i == 0) {
                return null;
            }
            int i2 = 0;
            boolean z = f(bArr, 0) == 65279;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5 += 4) {
                int f = f(bArr, i5);
                if (f < 0 || f >= 1114111 || (f >= 55296 && f <= 57343)) {
                    i3++;
                } else {
                    i4++;
                }
            }
            if (!z || i3 != 0) {
                if (!z || i4 <= i3 * 10) {
                    if (i4 <= 3 || i3 != 0) {
                        if (i4 <= 0 || i3 != 0) {
                            if (i4 > i3 * 10) {
                                i2 = 25;
                            }
                            if (i2 == 0) {
                                return null;
                            }
                            return new hy.b(aVar, this, i2);
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

        abstract int f(byte[] bArr, int i);
    }

    static class d extends c {
        d() {
        }

        @Override // hy.h
        String b() {
            return "UTF-32BE";
        }

        @Override // hy.e.c
        int f(byte[] bArr, int i) {
            return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        }
    }

    /* renamed from: hy.e$e, reason: collision with other inner class name */
    static class C0063e extends c {
        C0063e() {
        }

        @Override // hy.h
        String b() {
            return "UTF-32LE";
        }

        @Override // hy.e.c
        int f(byte[] bArr, int i) {
            return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
        }
    }

    e() {
    }

    static int d(int i, int i2) {
        if (i == 0) {
            i2 -= 10;
        } else if ((i >= 32 && i <= 255) || i == 10) {
            i2 += 10;
        }
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    static int e(byte b2, byte b3) {
        return ((b2 & 255) << 8) | (b3 & 255);
    }
}
