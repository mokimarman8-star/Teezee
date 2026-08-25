package org.brotli.dec;

import okhttp3.internal.http2.Settings;
import org.apache.tools.zip.UnixStat;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract class d {
    private static final int[] a = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final int[] b = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
    private static final int[] c = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
    private static final int[] d = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

    private static void a(j jVar) {
        a aVar = jVar.c;
        byte[] bArr = jVar.d;
        int i = jVar.g;
        if (i <= 0) {
            a.k(aVar);
            jVar.a = 1;
            return;
        }
        int min = Math.min(jVar.Q - jVar.r, i);
        a.c(aVar, bArr, jVar.r, min);
        jVar.g -= min;
        int i2 = jVar.r + min;
        jVar.r = i2;
        int i3 = jVar.Q;
        if (i2 != i3) {
            a.k(aVar);
            jVar.a = 1;
        } else {
            jVar.b = 5;
            jVar.Y = i3;
            jVar.X = 0;
            jVar.a = 12;
        }
    }

    private static void b(j jVar, int i) {
        a aVar = jVar.c;
        int[] iArr = jVar.p;
        int i2 = i * 2;
        a.d(aVar);
        int i3 = i * 1080;
        int r = r(jVar.e, i3, aVar);
        jVar.n[i] = m(jVar.f, i3, aVar);
        int i4 = r == 1 ? iArr[i2 + 1] + 1 : r == 0 ? iArr[i2] : r - 2;
        int i5 = jVar.o[i];
        if (i4 >= i5) {
            i4 -= i5;
        }
        int i6 = i2 + 1;
        iArr[i2] = iArr[i6];
        iArr[i6] = i4;
    }

    private static void c(j jVar) {
        b(jVar, 1);
        jVar.F = jVar.l.c[jVar.p[3]];
    }

    private static int d(int i, byte[] bArr, a aVar) {
        a.j(aVar);
        int h = h(aVar) + 1;
        if (h == 1) {
            l.a(bArr, 0, i);
            return h;
        }
        int i2 = a.i(aVar, 1) == 1 ? a.i(aVar, 4) + 1 : 0;
        int[] iArr = new int[1080];
        n(h + i2, iArr, 0, aVar);
        int i3 = 0;
        while (i3 < i) {
            a.j(aVar);
            a.d(aVar);
            int r = r(iArr, 0, aVar);
            if (r == 0) {
                bArr[i3] = 0;
            } else if (r <= i2) {
                for (int i4 = (1 << r) + a.i(aVar, r); i4 != 0; i4--) {
                    if (i3 >= i) {
                        throw new BrotliRuntimeException("Corrupted context map");
                    }
                    bArr[i3] = 0;
                    i3++;
                }
            } else {
                bArr[i3] = (byte) (r - i2);
            }
            i3++;
        }
        if (a.i(aVar, 1) == 1) {
            j(bArr, i);
        }
        return h;
    }

    private static void e(j jVar) {
        b(jVar, 2);
        jVar.C = jVar.p[5] << 2;
    }

    private static void f(j jVar) {
        b(jVar, 0);
        int i = jVar.p[1];
        int i2 = i << 6;
        jVar.B = i2;
        int i3 = jVar.A[i2] & 255;
        jVar.v = i3;
        jVar.w = jVar.k.c[i3];
        byte b2 = jVar.z[i];
        int[] iArr = c.b;
        jVar.D = iArr[b2];
        jVar.E = iArr[b2 + 1];
    }

    private static void g(a aVar, j jVar) {
        boolean z = a.i(aVar, 1) == 1;
        jVar.h = z;
        jVar.g = 0;
        jVar.i = false;
        jVar.j = false;
        if (!z || a.i(aVar, 1) == 0) {
            int i = a.i(aVar, 2) + 4;
            if (i == 7) {
                jVar.j = true;
                if (a.i(aVar, 1) != 0) {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
                int i2 = a.i(aVar, 2);
                if (i2 == 0) {
                    return;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = a.i(aVar, 8);
                    if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    jVar.g = (i4 << (i3 * 8)) | jVar.g;
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = a.i(aVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    jVar.g = (i6 << (i5 * 4)) | jVar.g;
                }
            }
            jVar.g++;
            if (jVar.h) {
                return;
            }
            jVar.i = a.i(aVar, 1) == 1;
        }
    }

    private static int h(a aVar) {
        if (a.i(aVar, 1) == 0) {
            return 0;
        }
        int i = a.i(aVar, 3);
        if (i == 0) {
            return 1;
        }
        return a.i(aVar, i) + (1 << i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:184:0x00a6, code lost:
    
        throw new org.brotli.dec.BrotliRuntimeException("Invalid backward reference");
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013b A[LOOP:2: B:55:0x013b->B:136:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void i(j jVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = jVar.a;
        if (i7 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i7 == 11) {
            throw new IllegalStateException("Can't decompress after close");
        }
        a aVar = jVar.c;
        int i8 = jVar.Q - 1;
        byte[] bArr = jVar.d;
        while (true) {
            int i9 = jVar.a;
            if (i9 == 10) {
                if (i9 == 10) {
                    if (jVar.g < 0) {
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    a.g(aVar);
                    a.a(jVar.c, true);
                    return;
                }
                return;
            }
            if (i9 != 12) {
                int i10 = 0;
                switch (i9) {
                    case 1:
                        if (jVar.g < 0) {
                            throw new BrotliRuntimeException("Invalid metablock length");
                        }
                        q(jVar);
                        i8 = jVar.Q - 1;
                        bArr = jVar.d;
                        break;
                    case 2:
                        p(jVar);
                        jVar.a = 3;
                        if (jVar.g > 0) {
                            jVar.a = 1;
                            break;
                        } else {
                            a.j(aVar);
                            if (jVar.n[1] == 0) {
                                c(jVar);
                            }
                            int[] iArr = jVar.n;
                            iArr[1] = iArr[1] - 1;
                            a.d(aVar);
                            int r = r(jVar.l.b, jVar.F, aVar);
                            int i11 = r >>> 6;
                            jVar.G = 0;
                            if (i11 >= 2) {
                                i11 -= 2;
                                jVar.G = -1;
                            }
                            int i12 = i.g[i11] + ((r >>> 3) & 7);
                            int i13 = i.h[i11] + (r & 7);
                            jVar.y = i.c[i12] + a.i(aVar, i.d[i12]);
                            jVar.M = i.e[i13] + a.i(aVar, i.f[i13]);
                            jVar.x = 0;
                            jVar.a = 6;
                            if (jVar.u) {
                                int i14 = jVar.r;
                                int i15 = bArr[(i14 - 1) & i8] & 255;
                                int i16 = bArr[(i14 - 2) & i8] & 255;
                                while (true) {
                                    if (jVar.x < jVar.y) {
                                        a.j(aVar);
                                        if (jVar.n[0] == 0) {
                                            f(jVar);
                                        }
                                        byte[] bArr2 = jVar.A;
                                        int i17 = jVar.B;
                                        int[] iArr2 = c.a;
                                        int i18 = bArr2[i17 + (iArr2[jVar.E + i16] | iArr2[jVar.D + i15])] & 255;
                                        int[] iArr3 = jVar.n;
                                        iArr3[0] = iArr3[0] - 1;
                                        a.d(aVar);
                                        g gVar = jVar.k;
                                        int r2 = r(gVar.b, gVar.c[i18], aVar);
                                        int i19 = jVar.r;
                                        bArr[i19] = (byte) r2;
                                        jVar.x++;
                                        jVar.r = i19 + 1;
                                        if (i19 == i8) {
                                            jVar.b = 6;
                                            jVar.Y = jVar.Q;
                                            jVar.X = 0;
                                            jVar.a = 12;
                                        } else {
                                            int i20 = i15;
                                            i15 = r2;
                                            i16 = i20;
                                        }
                                    }
                                }
                            } else {
                                while (true) {
                                    if (jVar.x < jVar.y) {
                                        a.j(aVar);
                                        if (jVar.n[0] == 0) {
                                            f(jVar);
                                        }
                                        int[] iArr4 = jVar.n;
                                        iArr4[0] = iArr4[0] - 1;
                                        a.d(aVar);
                                        bArr[jVar.r] = (byte) r(jVar.k.b, jVar.w, aVar);
                                        jVar.x++;
                                        int i21 = jVar.r;
                                        jVar.r = i21 + 1;
                                        if (i21 == i8) {
                                            jVar.b = 6;
                                            jVar.Y = jVar.Q;
                                            jVar.X = 0;
                                            jVar.a = 12;
                                        }
                                    }
                                }
                            }
                            if (jVar.a == 6) {
                                continue;
                            } else {
                                int i22 = jVar.g - jVar.y;
                                jVar.g = i22;
                                if (i22 <= 0) {
                                    jVar.a = 3;
                                    break;
                                } else {
                                    if (jVar.G < 0) {
                                        a.j(aVar);
                                        if (jVar.n[2] == 0) {
                                            e(jVar);
                                        }
                                        int[] iArr5 = jVar.n;
                                        iArr5[2] = iArr5[2] - 1;
                                        a.d(aVar);
                                        g gVar2 = jVar.m;
                                        int[] iArr6 = gVar2.b;
                                        int[] iArr7 = gVar2.c;
                                        byte[] bArr3 = jVar.H;
                                        int i23 = jVar.C;
                                        int i24 = jVar.M;
                                        int r3 = r(iArr6, iArr7[bArr3[i23 + (i24 > 4 ? 3 : i24 - 2)] & 255], aVar);
                                        jVar.G = r3;
                                        int i25 = jVar.I;
                                        if (r3 >= i25) {
                                            int i26 = r3 - i25;
                                            int i27 = jVar.J & i26;
                                            int i28 = i26 >>> jVar.K;
                                            jVar.G = i28;
                                            int i29 = (i28 >>> 1) + 1;
                                            jVar.G = i25 + i27 + ((((((i28 & 1) + 2) << i29) - 4) + a.i(aVar, i29)) << jVar.K);
                                        }
                                    }
                                    int t = t(jVar.G, jVar.q, jVar.t);
                                    jVar.L = t;
                                    if (t < 0) {
                                        throw new BrotliRuntimeException("Negative distance");
                                    }
                                    int i30 = jVar.s;
                                    int i31 = jVar.O;
                                    if (i30 == i31 || (i6 = jVar.r) >= i31) {
                                        jVar.s = i31;
                                    } else {
                                        jVar.s = i6;
                                    }
                                    jVar.N = jVar.r;
                                    if (t > jVar.s) {
                                        jVar.a = 9;
                                        break;
                                    } else {
                                        if (jVar.G > 0) {
                                            int[] iArr8 = jVar.q;
                                            int i32 = jVar.t;
                                            iArr8[i32 & 3] = t;
                                            jVar.t = i32 + 1;
                                        }
                                        if (jVar.M > jVar.g) {
                                            throw new BrotliRuntimeException("Invalid backward reference");
                                        }
                                        jVar.x = 0;
                                        jVar.a = 7;
                                        int i33 = jVar.r;
                                        i = (i33 - jVar.L) & i8;
                                        i2 = jVar.M - jVar.x;
                                        if (i + i2 < i8 || i33 + i2 >= i8) {
                                            do {
                                                i3 = jVar.x;
                                                if (i3 >= jVar.M) {
                                                    i4 = jVar.r;
                                                    bArr[i4] = bArr[(i4 - jVar.L) & i8];
                                                    jVar.g--;
                                                    jVar.x = i3 + 1;
                                                    jVar.r = i4 + 1;
                                                }
                                            } while (i4 != i8);
                                            i5 = 7;
                                            jVar.b = 7;
                                            jVar.Y = jVar.Q;
                                            jVar.X = 0;
                                            jVar.a = 12;
                                            if (jVar.a != i5) {
                                                break;
                                            } else {
                                                jVar.a = 3;
                                                break;
                                            }
                                        } else {
                                            while (i10 < i2) {
                                                bArr[i33] = bArr[i];
                                                i10++;
                                                i33++;
                                                i++;
                                            }
                                            jVar.x += i2;
                                            jVar.g -= i2;
                                            jVar.r += i2;
                                        }
                                        i5 = 7;
                                        if (jVar.a != i5) {
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 3:
                        if (jVar.g > 0) {
                        }
                        break;
                    case 4:
                        while (jVar.g > 0) {
                            a.j(aVar);
                            a.i(aVar, 8);
                            jVar.g--;
                        }
                        jVar.a = 1;
                        break;
                    case 5:
                        a(jVar);
                        break;
                    case 6:
                        if (jVar.u) {
                        }
                        if (jVar.a == 6) {
                        }
                        break;
                    case 7:
                        int i332 = jVar.r;
                        i = (i332 - jVar.L) & i8;
                        i2 = jVar.M - jVar.x;
                        if (i + i2 < i8) {
                            break;
                        }
                        do {
                            i3 = jVar.x;
                            if (i3 >= jVar.M) {
                            }
                        } while (i4 != i8);
                        i5 = 7;
                        jVar.b = 7;
                        jVar.Y = jVar.Q;
                        jVar.X = 0;
                        jVar.a = 12;
                        if (jVar.a != i5) {
                        }
                        break;
                    case 8:
                        int i34 = jVar.Q;
                        System.arraycopy(bArr, i34, bArr, 0, jVar.N - i34);
                        jVar.a = 3;
                        break;
                    case 9:
                        int i35 = jVar.M;
                        if (i35 >= 4 && i35 <= 24) {
                            int i36 = e.a[i35];
                            int i37 = (jVar.L - jVar.s) - 1;
                            int i38 = e.b[i35];
                            int i39 = ((1 << i38) - 1) & i37;
                            int i40 = i37 >>> i38;
                            int i41 = i36 + (i39 * i35);
                            k[] kVarArr = k.d;
                            if (i40 >= kVarArr.length) {
                                throw new BrotliRuntimeException("Invalid backward reference");
                            }
                            int b2 = k.b(bArr, jVar.N, e.a(), i41, jVar.M, kVarArr[i40]);
                            int i42 = jVar.N + b2;
                            jVar.N = i42;
                            jVar.r += b2;
                            jVar.g -= b2;
                            int i43 = jVar.Q;
                            if (i42 < i43) {
                                jVar.a = 3;
                                break;
                            } else {
                                jVar.b = 8;
                                jVar.Y = i43;
                                jVar.X = 0;
                                jVar.a = 12;
                                break;
                            }
                        }
                        break;
                    default:
                        throw new BrotliRuntimeException("Unexpected state " + jVar.a);
                }
            } else {
                if (!u(jVar)) {
                    return;
                }
                int i44 = jVar.r;
                int i45 = jVar.O;
                if (i44 >= i45) {
                    jVar.s = i45;
                }
                jVar.r = i44 & i8;
                jVar.a = jVar.b;
            }
        }
    }

    private static void j(byte[] bArr, int i) {
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = bArr[i3] & 255;
            bArr[i3] = (byte) iArr[i4];
            if (i4 != 0) {
                l(iArr, i4);
            }
        }
    }

    private static void k(j jVar) {
        int i;
        int i2 = jVar.P;
        long j = i2;
        long j2 = jVar.R;
        if (j > j2) {
            while (true) {
                int i3 = i2 >> 1;
                if (i3 <= ((int) j2) + jVar.S.length) {
                    break;
                } else {
                    i2 = i3;
                }
            }
            if (!jVar.h && i2 < 16384 && jVar.P >= 16384) {
                i2 = 16384;
            }
        }
        int i4 = jVar.Q;
        if (i2 <= i4) {
            return;
        }
        byte[] bArr = new byte[i2 + 37];
        byte[] bArr2 = jVar.d;
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr, 0, i4);
        } else {
            byte[] bArr3 = jVar.S;
            if (bArr3.length != 0) {
                int length = bArr3.length;
                int i5 = jVar.O;
                if (length > i5) {
                    i = length - i5;
                } else {
                    i5 = length;
                    i = 0;
                }
                System.arraycopy(bArr3, i, bArr, 0, i5);
                jVar.r = i5;
                jVar.T = i5;
            }
        }
        jVar.d = bArr;
        jVar.Q = i2;
    }

    private static void l(int[] iArr, int i) {
        int i2 = iArr[i];
        while (i > 0) {
            iArr[i] = iArr[i - 1];
            i--;
        }
        iArr[0] = i2;
    }

    private static int m(int[] iArr, int i, a aVar) {
        a.d(aVar);
        int r = r(iArr, i, aVar);
        return i.a[r] + a.i(aVar, i.b[r]);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void n(int i, int[] iArr, int i2, a aVar) {
        int i3;
        int i4;
        int i5;
        a.j(aVar);
        int[] iArr2 = new int[i];
        int i6 = a.i(aVar, 2);
        boolean z = true;
        if (i6 == 1) {
            int i7 = i - 1;
            int[] iArr3 = new int[4];
            int i8 = a.i(aVar, 2) + 1;
            int i9 = 0;
            while (i7 != 0) {
                i7 >>= 1;
                i9++;
            }
            for (int i10 = 0; i10 < i8; i10++) {
                int i11 = a.i(aVar, i9) % i;
                iArr3[i10] = i11;
                iArr2[i11] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (i8 != 1) {
                if (i8 == 2) {
                    int i12 = iArr3[0];
                    int i13 = iArr3[1];
                    r5 = i12 != i13;
                    iArr2[i13] = 1;
                } else if (i8 != 3) {
                    int i14 = iArr3[0];
                    int i15 = iArr3[1];
                    boolean z2 = (i14 == i15 || i14 == (i4 = iArr3[2]) || i14 == (i5 = iArr3[3]) || i15 == i4 || i15 == i5 || i4 == i5) ? false : true;
                    if (a.i(aVar, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                    } else {
                        iArr2[iArr3[0]] = 2;
                    }
                    z = z2;
                } else {
                    int i16 = iArr3[0];
                    int i17 = iArr3[1];
                    if (i16 != i17 && i16 != (i3 = iArr3[2]) && i17 != i3) {
                        r5 = true;
                    }
                }
            }
            if (z) {
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            f.a(iArr, i2, 8, iArr2, i);
            return;
        }
        int[] iArr4 = new int[18];
        int i18 = 0;
        int i19 = 32;
        while (i6 < 18 && i19 > 0) {
            int i20 = a[i6];
            a.d(aVar);
            long j = aVar.f;
            int i21 = aVar.g;
            int i22 = d[((int) (j >>> i21)) & 15];
            aVar.g = i21 + (i22 >> 16);
            int i23 = i22 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            iArr4[i20] = i23;
            if (i23 != 0) {
                i19 -= 32 >> i23;
                i18++;
            }
            i6++;
        }
        r5 = i18 == 1 || i19 == 0;
        o(iArr4, i, iArr2, aVar);
        z = r5;
        if (z) {
        }
    }

    private static void o(int[] iArr, int i, int[] iArr2, a aVar) {
        int[] iArr3 = new int[32];
        f.a(iArr3, 0, 5, iArr, 18);
        int i2 = 8;
        int i3 = 32768;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i && i3 > 0) {
            a.j(aVar);
            a.d(aVar);
            long j = aVar.f;
            int i7 = aVar.g;
            int i8 = iArr3[((int) (j >>> i7)) & 31];
            aVar.g = i7 + (i8 >> 16);
            int i9 = i8 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            if (i9 < 16) {
                int i10 = i4 + 1;
                iArr2[i4] = i9;
                if (i9 != 0) {
                    i3 -= UnixStat.FILE_FLAG >> i9;
                    i4 = i10;
                    i2 = i9;
                } else {
                    i4 = i10;
                }
                i6 = 0;
            } else {
                int i11 = i9 - 14;
                int i12 = i9 == 16 ? i2 : 0;
                if (i5 != i12) {
                    i6 = 0;
                    i5 = i12;
                }
                int i13 = (i6 > 0 ? (i6 - 2) << i11 : i6) + a.i(aVar, i11) + 3;
                int i14 = i13 - i6;
                if (i4 + i14 > i) {
                    throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                }
                int i15 = 0;
                while (i15 < i14) {
                    iArr2[i4] = i5;
                    i15++;
                    i4++;
                }
                if (i5 != 0) {
                    i3 -= i14 << (15 - i5);
                }
                i6 = i13;
            }
        }
        if (i3 != 0) {
            throw new BrotliRuntimeException("Unused space");
        }
        l.b(iArr2, i4, i - i4);
    }

    private static void p(j jVar) {
        int i;
        int[] iArr;
        a aVar = jVar.c;
        for (int i2 = 0; i2 < 3; i2++) {
            jVar.o[i2] = h(aVar) + 1;
            jVar.n[i2] = 268435456;
            int i3 = jVar.o[i2];
            if (i3 > 1) {
                int i4 = i2 * 1080;
                n(i3 + 2, jVar.e, i4, aVar);
                n(26, jVar.f, i4, aVar);
                jVar.n[i2] = m(jVar.f, i4, aVar);
            }
        }
        a.j(aVar);
        jVar.K = a.i(aVar, 2);
        int i5 = a.i(aVar, 4);
        int i6 = jVar.K;
        int i7 = (i5 << i6) + 16;
        jVar.I = i7;
        jVar.J = (1 << i6) - 1;
        int i8 = i7 + (48 << i6);
        jVar.z = new byte[jVar.o[0]];
        int i9 = 0;
        while (true) {
            i = jVar.o[0];
            if (i9 >= i) {
                break;
            }
            int min = Math.min(i9 + 96, i);
            while (i9 < min) {
                jVar.z[i9] = (byte) (a.i(aVar, 2) << 1);
                i9++;
            }
            a.j(aVar);
        }
        byte[] bArr = new byte[i << 6];
        jVar.A = bArr;
        int d2 = d(i << 6, bArr, aVar);
        jVar.u = true;
        int i10 = 0;
        while (true) {
            iArr = jVar.o;
            if (i10 >= (iArr[0] << 6)) {
                break;
            }
            if (jVar.A[i10] != (i10 >> 6)) {
                jVar.u = false;
                break;
            }
            i10++;
        }
        int i11 = iArr[2];
        byte[] bArr2 = new byte[i11 << 2];
        jVar.H = bArr2;
        int d3 = d(i11 << 2, bArr2, aVar);
        g.b(jVar.k, 256, d2);
        g.b(jVar.l, 704, jVar.o[1]);
        g.b(jVar.m, i8, d3);
        g.a(jVar.k, aVar);
        g.a(jVar.l, aVar);
        g.a(jVar.m, aVar);
        jVar.B = 0;
        jVar.C = 0;
        int[] iArr2 = c.b;
        byte b2 = jVar.z[0];
        jVar.D = iArr2[b2];
        jVar.E = iArr2[b2 + 1];
        jVar.v = 0;
        jVar.w = jVar.k.c[0];
        jVar.F = jVar.l.c[0];
        int[] iArr3 = jVar.p;
        iArr3[4] = 1;
        iArr3[2] = 1;
        iArr3[0] = 1;
        iArr3[5] = 0;
        iArr3[3] = 0;
        iArr3[1] = 0;
    }

    private static void q(j jVar) {
        a aVar = jVar.c;
        if (jVar.h) {
            jVar.b = 10;
            jVar.Y = jVar.r;
            jVar.X = 0;
            jVar.a = 12;
            return;
        }
        g gVar = jVar.k;
        gVar.b = null;
        gVar.c = null;
        g gVar2 = jVar.l;
        gVar2.b = null;
        gVar2.c = null;
        g gVar3 = jVar.m;
        gVar3.b = null;
        gVar3.c = null;
        a.j(aVar);
        g(aVar, jVar);
        if (jVar.g != 0 || jVar.j) {
            if (jVar.i || jVar.j) {
                a.g(aVar);
                jVar.a = jVar.j ? 4 : 5;
            } else {
                jVar.a = 2;
            }
            if (jVar.j) {
                return;
            }
            jVar.R += jVar.g;
            if (jVar.Q < jVar.P) {
                k(jVar);
            }
        }
    }

    private static int r(int[] iArr, int i, a aVar) {
        long j = aVar.f;
        int i2 = aVar.g;
        int i3 = (int) (j >>> i2);
        int i4 = i + (i3 & 255);
        int i5 = iArr[i4];
        int i6 = i5 >> 16;
        int i7 = i5 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (i6 <= 8) {
            aVar.g = i2 + i6;
            return i7;
        }
        int i8 = iArr[i4 + i7 + ((i3 & ((1 << i6) - 1)) >>> 8)];
        aVar.g = i2 + (i8 >> 16) + 8;
        return i8 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
    }

    static void s(j jVar, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        jVar.S = bArr;
    }

    private static int t(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(i2 + b[i]) & 3] + c[i] : i - 15;
    }

    private static boolean u(j jVar) {
        int i = jVar.T;
        if (i != 0) {
            jVar.X += i;
            jVar.T = 0;
        }
        int min = Math.min(jVar.V - jVar.W, jVar.Y - jVar.X);
        if (min != 0) {
            System.arraycopy(jVar.d, jVar.X, jVar.Z, jVar.U + jVar.W, min);
            jVar.W += min;
            jVar.X += min;
        }
        return jVar.W < jVar.V;
    }
}
