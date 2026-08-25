package vz;

import androidx.core.view.ViewCompat;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
class n {
    q a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private short f;
    private short g;
    private int h;
    private int[] i;

    n(q qVar) {
        this.a = qVar;
    }

    private void b(int i) {
        if (this.i == null) {
            this.i = new int[2];
        }
        int length = this.i.length;
        int i2 = this.h;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.i, 0, iArr, 0, length);
            this.i = iArr;
        }
        int[] iArr2 = this.i;
        int i3 = this.h;
        this.h = i3 + 1;
        iArr2[i3] = i;
    }

    static int e(x xVar, Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() | 16777216 : obj instanceof String ? f(xVar, y.k((String) obj).e(), 0) : xVar.K("", ((q) obj).d) | 50331648;
    }

    private static int f(x xVar, String str, int i) {
        char charAt = str.charAt(i);
        int i2 = 16777218;
        if (charAt == 'F') {
            return 16777218;
        }
        if (charAt == 'L') {
            return xVar.I(str.substring(i + 1, str.length() - 1)) | ASTNode.PCTX_STORED;
        }
        if (charAt != 'S') {
            if (charAt == 'V') {
                return 0;
            }
            if (charAt != 'I') {
                if (charAt == 'J') {
                    return 16777220;
                }
                if (charAt != 'Z') {
                    if (charAt == '[') {
                        int i3 = i + 1;
                        while (str.charAt(i3) == '[') {
                            i3++;
                        }
                        char charAt2 = str.charAt(i3);
                        if (charAt2 != 'F') {
                            if (charAt2 == 'L') {
                                i2 = xVar.I(str.substring(i3 + 1, str.length() - 1)) | ASTNode.PCTX_STORED;
                            } else if (charAt2 == 'S') {
                                i2 = 16777228;
                            } else if (charAt2 == 'Z') {
                                i2 = 16777225;
                            } else if (charAt2 == 'I') {
                                i2 = 16777217;
                            } else if (charAt2 != 'J') {
                                switch (charAt2) {
                                    case 'B':
                                        i2 = 16777226;
                                        break;
                                    case 'C':
                                        i2 = 16777227;
                                        break;
                                    case 'D':
                                        i2 = 16777219;
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            } else {
                                i2 = 16777220;
                            }
                        }
                        return ((i3 - i) << 28) | i2;
                    }
                    switch (charAt) {
                        case 'B':
                        case 'C':
                            break;
                        case 'D':
                            return 16777219;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return 16777217;
    }

    static int g(x xVar, String str) {
        return xVar.I(str) | ASTNode.PCTX_STORED;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[LOOP:0: B:8:0x000d->B:15:0x0051, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int h(vz.x r9, int r10) {
        /*
            r8 = this;
            r0 = 16777222(0x1000006, float:2.3509904E-38)
            if (r10 == r0) goto Lc
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r10
            r2 = 50331648(0x3000000, float:3.761582E-37)
            if (r1 != r2) goto L54
        Lc:
            r1 = 0
        Ld:
            int r2 = r8.h
            if (r1 >= r2) goto L54
            int[] r2 = r8.i
            r2 = r2[r1]
            r3 = -268435456(0xfffffffff0000000, float:-1.58456325E29)
            r3 = r3 & r2
            r4 = 251658240(0xf000000, float:6.3108872E-30)
            r4 = r4 & r2
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r2 & r5
            r7 = 67108864(0x4000000, float:1.5046328E-36)
            if (r4 != r7) goto L2a
            int[] r2 = r8.b
            r2 = r2[r6]
        L28:
            int r2 = r2 + r3
            goto L35
        L2a:
            r7 = 83886080(0x5000000, float:6.018531E-36)
            if (r4 != r7) goto L35
            int[] r2 = r8.c
            int r4 = r2.length
            int r4 = r4 - r6
            r2 = r2[r4]
            goto L28
        L35:
            if (r10 != r2) goto L51
            r1 = 33554432(0x2000000, float:9.403955E-38)
            if (r10 != r0) goto L45
            java.lang.String r10 = r9.O()
            int r9 = r9.I(r10)
        L43:
            r9 = r9 | r1
            return r9
        L45:
            r10 = r10 & r5
            vz.w r10 = r9.T(r10)
            java.lang.String r10 = r10.e
            int r9 = r9.I(r10)
            goto L43
        L51:
            int r1 = r1 + 1
            goto Ld
        L54:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: vz.n.h(vz.x, int):int");
    }

    private int j(int i) {
        int[] iArr = this.d;
        if (iArr == null || i >= iArr.length) {
            return i | ASTNode.ARRAY_TYPE_LITERAL;
        }
        int i2 = iArr[i];
        if (i2 != 0) {
            return i2;
        }
        int i3 = i | ASTNode.ARRAY_TYPE_LITERAL;
        iArr[i] = i3;
        return i3;
    }

    private static boolean k(x xVar, int i, int[] iArr, int i2) {
        int min;
        int I;
        int i3 = iArr[i2];
        if (i3 == i) {
            return false;
        }
        if ((268435455 & i) == 16777221) {
            if (i3 == 16777221) {
                return false;
            }
            i = 16777221;
        }
        if (i3 == 0) {
            iArr[i2] = i;
            return true;
        }
        int i4 = i3 & (-268435456);
        int i6 = 16777216;
        if (i4 != 0 || (i3 & 251658240) == 33554432) {
            if (i == 16777221) {
                return false;
            }
            if ((i & ViewCompat.MEASURED_STATE_MASK) != ((-16777216) & i3)) {
                int i7 = i & (-268435456);
                if (i7 != 0 || (i & 251658240) == 33554432) {
                    if (i7 != 0 && (i & 251658240) != 33554432) {
                        i7 -= 268435456;
                    }
                    if (i4 != 0 && (i3 & 251658240) != 33554432) {
                        i4 -= 268435456;
                    }
                    min = Math.min(i7, i4) | ASTNode.PCTX_STORED;
                    I = xVar.I("java/lang/Object");
                    i6 = min | I;
                }
            } else if ((i3 & 251658240) == 33554432) {
                i6 = (i & (-268435456)) | ASTNode.PCTX_STORED | xVar.H(i & 1048575, 1048575 & i3);
            } else {
                min = ((i & (-268435456)) - 268435456) | ASTNode.PCTX_STORED;
                I = xVar.I("java/lang/Object");
                i6 = min | I;
            }
        } else if (i3 == 16777221) {
            if ((i & (-268435456)) == 0 && (i & 251658240) != 33554432) {
                i = 16777216;
            }
            i6 = i;
        }
        if (i6 == i3) {
            return false;
        }
        iArr[i2] = i6;
        return true;
    }

    private int m() {
        short s = this.g;
        if (s <= 0) {
            short s2 = (short) (this.f - 1);
            this.f = s2;
            return (-s2) | 83886080;
        }
        int[] iArr = this.e;
        short s3 = (short) (s - 1);
        this.g = s3;
        return iArr[s3];
    }

    private void n(int i) {
        short s = this.g;
        if (s >= i) {
            this.g = (short) (s - i);
        } else {
            this.f = (short) (this.f - (i - s));
            this.g = (short) 0;
        }
    }

    private void o(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            n((y.c(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            n(2);
        } else {
            n(1);
        }
    }

    private void p(int i) {
        if (this.e == null) {
            this.e = new int[10];
        }
        int length = this.e.length;
        short s = this.g;
        if (s >= length) {
            int[] iArr = new int[Math.max(s + 1, length * 2)];
            System.arraycopy(this.e, 0, iArr, 0, length);
            this.e = iArr;
        }
        int[] iArr2 = this.e;
        short s2 = this.g;
        short s3 = (short) (s2 + 1);
        this.g = s3;
        iArr2[s2] = i;
        short s4 = (short) (this.f + s3);
        q qVar = this.a;
        if (s4 > qVar.h) {
            qVar.h = s4;
        }
    }

    private void q(x xVar, String str) {
        int f = f(xVar, str, str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0);
        if (f != 0) {
            p(f);
            if (f == 16777220 || f == 16777219) {
                p(16777216);
            }
        }
    }

    static void r(x xVar, int i, d dVar) {
        int i2 = ((-268435456) & i) >> 28;
        if (i2 == 0) {
            int i3 = i & 1048575;
            int i4 = i & 251658240;
            if (i4 == 16777216) {
                dVar.g(i3);
                return;
            } else if (i4 == 33554432) {
                dVar.g(7).k(xVar.e(xVar.T(i3).e).a);
                return;
            } else {
                if (i4 != 50331648) {
                    throw new AssertionError();
                }
                dVar.g(8).k((int) xVar.T(i3).f);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i6 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            sb.append('[');
            i2 = i6;
        }
        if ((i & 251658240) == 33554432) {
            sb.append('L');
            sb.append(xVar.T(i & 1048575).e);
            sb.append(';');
        } else {
            int i7 = i & 1048575;
            if (i7 == 1) {
                sb.append('I');
            } else if (i7 == 2) {
                sb.append('F');
            } else if (i7 == 3) {
                sb.append('D');
            } else if (i7 != 4) {
                switch (i7) {
                    case 9:
                        sb.append('Z');
                        break;
                    case 10:
                        sb.append('B');
                        break;
                    case 11:
                        sb.append('C');
                        break;
                    case 12:
                        sb.append('S');
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                sb.append('J');
            }
        }
        dVar.g(7).k(xVar.e(sb.toString()).a);
    }

    private void u(int i, int i2) {
        if (this.d == null) {
            this.d = new int[10];
        }
        int length = this.d.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.d, 0, iArr, 0, length);
            this.d = iArr;
        }
        this.d[i] = i2;
    }

    final void a(s sVar) {
        int[] iArr = this.b;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i6 = 2;
            if (i2 >= iArr.length) {
                break;
            }
            int i7 = iArr[i2];
            if (i7 != 16777220 && i7 != 16777219) {
                i6 = 1;
            }
            i2 += i6;
            if (i7 == 16777216) {
                i4++;
            } else {
                i3 += i4 + 1;
                i4 = 0;
            }
        }
        int[] iArr2 = this.c;
        int i8 = 0;
        int i9 = 0;
        while (i8 < iArr2.length) {
            int i10 = iArr2[i8];
            i8 += (i10 == 16777220 || i10 == 16777219) ? 2 : 1;
            i9++;
        }
        int V = sVar.V(this.a.d, i3, i9);
        int i11 = 0;
        while (true) {
            int i12 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            int i13 = iArr[i11];
            i11 += (i13 == 16777220 || i13 == 16777219) ? 2 : 1;
            sVar.T(V, i13);
            i3 = i12;
            V++;
        }
        while (true) {
            int i14 = i9 - 1;
            if (i9 <= 0) {
                sVar.U();
                return;
            }
            int i15 = iArr2[i];
            i += (i15 == 16777220 || i15 == 16777219) ? 2 : 1;
            sVar.T(V, i15);
            V++;
            i9 = i14;
        }
    }

    final void c(n nVar) {
        this.b = nVar.b;
        this.c = nVar.c;
        this.f = (short) 0;
        this.d = nVar.d;
        this.e = nVar.e;
        this.g = nVar.g;
        this.h = nVar.h;
        this.i = nVar.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0356  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void d(int r17, int r18, vz.w r19, vz.x r20) {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vz.n.d(int, int, vz.w, vz.x):void");
    }

    final int i() {
        return this.c.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        if (r8 == 16777219) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        if (r8 == 16777219) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f6, code lost:
    
        if (r6 == 16777219) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x010e, code lost:
    
        if (r6 == 16777219) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean l(vz.x r20, vz.n r21, int r22) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vz.n.l(vz.x, vz.n, int):boolean");
    }

    final void s(x xVar, int i, Object[] objArr, int i2, Object[] objArr2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i6 = i3 + 1;
            this.b[i3] = e(xVar, objArr[i4]);
            Object obj = objArr[i4];
            if (obj == v.e || obj == v.d) {
                i3 += 2;
                this.b[i6] = 16777216;
            } else {
                i3 = i6;
            }
        }
        while (true) {
            int[] iArr = this.b;
            if (i3 >= iArr.length) {
                break;
            }
            iArr[i3] = 16777216;
            i3++;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            Object obj2 = objArr2[i8];
            if (obj2 == v.e || obj2 == v.d) {
                i7++;
            }
        }
        this.c = new int[i7 + i2];
        int i9 = 0;
        for (int i10 = 0; i10 < i2; i10++) {
            int i11 = i9 + 1;
            this.c[i9] = e(xVar, objArr2[i10]);
            Object obj3 = objArr2[i10];
            if (obj3 == v.e || obj3 == v.d) {
                i9 += 2;
                this.c[i11] = 16777216;
            } else {
                i9 = i11;
            }
        }
        this.g = (short) 0;
        this.h = 0;
    }

    final void t(x xVar, int i, String str, int i2) {
        int i3;
        int[] iArr = new int[i2];
        this.b = iArr;
        this.c = new int[0];
        if ((i & 8) == 0) {
            i3 = 1;
            if ((i & ASTNode.BLOCK_FOR) == 0) {
                iArr[0] = xVar.I(xVar.O()) | ASTNode.PCTX_STORED;
            } else {
                iArr[0] = 16777222;
            }
        } else {
            i3 = 0;
        }
        for (y yVar : y.b(str)) {
            int f = f(xVar, yVar.e(), 0);
            int[] iArr2 = this.b;
            int i4 = i3 + 1;
            iArr2[i3] = f;
            if (f == 16777220 || f == 16777219) {
                i3 += 2;
                iArr2[i4] = 16777216;
            } else {
                i3 = i4;
            }
        }
        while (i3 < i2) {
            this.b[i3] = 16777216;
            i3++;
        }
    }
}
