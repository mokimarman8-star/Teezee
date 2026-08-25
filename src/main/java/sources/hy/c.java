package hy;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class c extends h {

    static class a extends c {
        private byte[][] a = {new byte[]{27, 36, 41, 65}, new byte[]{27, 36, 41, 71}, new byte[]{27, 36, 42, 72}, new byte[]{27, 36, 41, 69}, new byte[]{27, 36, 43, 73}, new byte[]{27, 36, 43, 74}, new byte[]{27, 36, 43, 75}, new byte[]{27, 36, 43, 76}, new byte[]{27, 36, 43, 77}, new byte[]{27, 78}, new byte[]{27, 79}};

        a() {
        }

        @Override // hy.h
        String b() {
            return "ISO-2022-CN";
        }

        @Override // hy.h
        hy.b c(hy.a aVar) {
            int d = d(aVar.a, aVar.b, this.a);
            if (d == 0) {
                return null;
            }
            return new hy.b(aVar, this, d);
        }
    }

    static class b extends c {
        private byte[][] a = {new byte[]{27, 36, 40, 67}, new byte[]{27, 36, 40, 68}, new byte[]{27, 36, 64}, new byte[]{27, 36, 65}, new byte[]{27, 36, 66}, new byte[]{27, 38, 64}, new byte[]{27, 40, 66}, new byte[]{27, 40, 72}, new byte[]{27, 40, 73}, new byte[]{27, 40, 74}, new byte[]{27, 46, 65}, new byte[]{27, 46, 70}};

        b() {
        }

        @Override // hy.h
        String b() {
            return "ISO-2022-JP";
        }

        @Override // hy.h
        hy.b c(hy.a aVar) {
            int d = d(aVar.a, aVar.b, this.a);
            if (d == 0) {
                return null;
            }
            return new hy.b(aVar, this, d);
        }
    }

    /* renamed from: hy.c$c, reason: collision with other inner class name */
    static class C0062c extends c {
        private byte[][] a = {new byte[]{27, 36, 41, 67}};

        C0062c() {
        }

        @Override // hy.h
        String b() {
            return "ISO-2022-KR";
        }

        @Override // hy.h
        hy.b c(hy.a aVar) {
            int d = d(aVar.a, aVar.b, this.a);
            if (d == 0) {
                return null;
            }
            return new hy.b(aVar, this, d);
        }
    }

    c() {
    }

    int d(byte[] bArr, int i, byte[][] bArr2) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < i) {
            if (bArr[i2] == 27) {
                for (byte[] bArr3 : bArr2) {
                    if (i - i2 >= bArr3.length) {
                        for (int i6 = 1; i6 < bArr3.length; i6++) {
                            if (bArr3[i6] != bArr[i2 + i6]) {
                                break;
                            }
                        }
                        i3++;
                        i2 += bArr3.length - 1;
                        break;
                    }
                }
                i4++;
            }
            byte b2 = bArr[i2];
            if (b2 == 14 || b2 == 15) {
                i5++;
            }
            i2++;
        }
        if (i3 == 0) {
            return 0;
        }
        int i7 = ((i3 * 100) - (i4 * 100)) / (i4 + i3);
        int i8 = i3 + i5;
        if (i8 < 5) {
            i7 -= (5 - i8) * 10;
        }
        if (i7 < 0) {
            return 0;
        }
        return i7;
    }
}
