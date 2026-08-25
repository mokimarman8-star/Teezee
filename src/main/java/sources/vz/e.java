package vz;

import com.transsion.baselib.report.recent_event.ActionEvent;
import okio.Utf8;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class e {
    public final byte[] a;
    private final int[] b;
    private final String[] c;
    private final h[] d;
    private final int[] e;
    private final int f;
    public final int g;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    e(byte[] bArr, int i, boolean z) {
        this.a = bArr;
        if (z) {
            int i2 = i + 6;
            if (B(i2) > 56) {
                throw new IllegalArgumentException("Unsupported class file major version " + ((int) B(i2)));
            }
        }
        int H = H(i + 8);
        this.b = new int[H];
        this.c = new String[H];
        int i3 = i + 10;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i6 = 1;
        while (i6 < H) {
            int i7 = i6 + 1;
            int i8 = i3 + 1;
            this.b[i6] = i8;
            int i9 = 3;
            switch (bArr[i3]) {
                case 1:
                    i9 = 3 + H(i8);
                    if (i9 > i4) {
                        i6 = i7;
                        i4 = i9;
                        i3 += i9;
                    }
                    i6 = i7;
                    i3 += i9;
                case 2:
                case 13:
                case ActionEvent.delete_comment /* 14 */:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    i6 = i7;
                    i9 = 5;
                    i3 += i9;
                case 5:
                case 6:
                    i6 += 2;
                    i9 = 9;
                    i3 += i9;
                case 7:
                case 8:
                case 16:
                case ActionEvent.search_cover_expose /* 19 */:
                case ActionEvent.search_cover_click /* 20 */:
                    i6 = i7;
                    i3 += i9;
                case ActionEvent.pageview /* 15 */:
                    i9 = 4;
                    i6 = i7;
                    i3 += i9;
                case ActionEvent.want_to_see_cancel /* 17 */:
                    z2 = true;
                    i6 = i7;
                    i9 = 5;
                    i3 += i9;
                case 18:
                    z3 = true;
                    i6 = i7;
                    i9 = 5;
                    i3 += i9;
            }
        }
        this.f = i4;
        this.g = i3;
        this.d = z2 ? new h[H] : null;
        this.e = (z2 || z3) ? k(i4) : null;
    }

    private void A(r rVar, i iVar, int i, boolean z) {
        int i2 = i + 1;
        int i3 = this.a[i] & 255;
        rVar.a(i3, z);
        char[] cArr = iVar.c;
        for (int i4 = 0; i4 < i3; i4++) {
            int H = H(i2);
            i2 += 2;
            while (true) {
                int i6 = H - 1;
                if (H > 0) {
                    i2 = r(rVar.z(i4, G(i2, cArr), z), i2 + 2, true, cArr);
                    H = i6;
                }
            }
        }
    }

    private int C(int i, boolean z, boolean z2, i iVar) {
        int i2;
        int i3;
        char[] cArr = iVar.c;
        q[] qVarArr = iVar.g;
        if (z) {
            i2 = i + 1;
            i3 = this.a[i] & 255;
        } else {
            iVar.m = -1;
            i2 = i;
            i3 = 255;
        }
        iVar.p = 0;
        if (i3 < 64) {
            iVar.n = 3;
            iVar.r = 0;
        } else if (i3 < 128) {
            i3 -= 64;
            i2 = K(i2, iVar.s, 0, cArr, qVarArr);
            iVar.n = 4;
            iVar.r = 1;
        } else {
            if (i3 < 247) {
                throw new IllegalArgumentException();
            }
            int H = H(i2);
            int i4 = i2 + 2;
            if (i3 == 247) {
                i2 = K(i4, iVar.s, 0, cArr, qVarArr);
                iVar.n = 4;
                iVar.r = 1;
            } else {
                if (i3 >= 248 && i3 < 251) {
                    iVar.n = 2;
                    int i6 = 251 - i3;
                    iVar.p = i6;
                    iVar.o -= i6;
                    iVar.r = 0;
                } else if (i3 == 251) {
                    iVar.n = 3;
                    iVar.r = 0;
                } else if (i3 < 255) {
                    int i7 = i3 - 251;
                    int i8 = z2 ? iVar.o : 0;
                    i2 = i4;
                    int i9 = i7;
                    while (i9 > 0) {
                        i2 = K(i2, iVar.q, i8, cArr, qVarArr);
                        i9--;
                        i8++;
                    }
                    iVar.n = 1;
                    iVar.p = i7;
                    iVar.o += i7;
                    iVar.r = 0;
                } else {
                    int H2 = H(i4);
                    int i10 = i2 + 4;
                    iVar.n = 0;
                    iVar.p = H2;
                    iVar.o = H2;
                    for (int i11 = 0; i11 < H2; i11++) {
                        i10 = K(i10, iVar.q, i11, cArr, qVarArr);
                    }
                    int H3 = H(i10);
                    i2 = i10 + 2;
                    iVar.r = H3;
                    for (int i12 = 0; i12 < H3; i12++) {
                        i2 = K(i2, iVar.s, i12, cArr, qVarArr);
                    }
                }
                i2 = i4;
            }
            i3 = H;
        }
        int i13 = iVar.m + i3 + 1;
        iVar.m = i13;
        d(i13, qVarArr);
        return i2;
    }

    private String D(int i, char[] cArr) {
        return G(this.b[H(i)], cArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int E(vz.i r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.t(r11)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L70
            if (r1 == r2) goto L70
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            switch(r1) {
                case 16: goto L6d;
                case 17: goto L6d;
                case 18: goto L6d;
                case 19: goto L6a;
                case 20: goto L6a;
                case 21: goto L6a;
                case 22: goto L70;
                case 23: goto L6d;
                default: goto L10;
            }
        L10:
            switch(r1) {
                case 64: goto L24;
                case 65: goto L24;
                case 66: goto L6d;
                case 67: goto L20;
                case 68: goto L20;
                case 69: goto L20;
                case 70: goto L20;
                case 71: goto L19;
                case 72: goto L19;
                case 73: goto L19;
                case 74: goto L19;
                case 75: goto L19;
                default: goto L13;
            }
        L13:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L19:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r11 = r11 + 4
            goto L75
        L20:
            r0 = r0 & r3
        L21:
            int r11 = r11 + 3
            goto L75
        L24:
            r0 = r0 & r3
            int r1 = r11 + 1
            int r1 = r9.H(r1)
            int r11 = r11 + 3
            vz.q[] r3 = new vz.q[r1]
            r10.j = r3
            vz.q[] r3 = new vz.q[r1]
            r10.k = r3
            int[] r3 = new int[r1]
            r10.l = r3
            r3 = 0
        L3a:
            if (r3 >= r1) goto L75
            int r4 = r9.H(r11)
            int r5 = r11 + 2
            int r5 = r9.H(r5)
            int r6 = r11 + 4
            int r6 = r9.H(r6)
            int r11 = r11 + 6
            vz.q[] r7 = r10.j
            vz.q[] r8 = r10.g
            vz.q r8 = r9.d(r4, r8)
            r7[r3] = r8
            vz.q[] r7 = r10.k
            int r4 = r4 + r5
            vz.q[] r5 = r10.g
            vz.q r4 = r9.d(r4, r5)
            r7[r3] = r4
            int[] r4 = r10.l
            r4[r3] = r6
            int r3 = r3 + 1
            goto L3a
        L6a:
            r0 = r0 & r3
            int r11 = r11 + r2
            goto L75
        L6d:
            r0 = r0 & (-256(0xffffffffffffff00, float:NaN))
            goto L21
        L70:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r11 = r11 + 2
        L75:
            r10.h = r0
            int r0 = r9.l(r11)
            if (r0 != 0) goto L7f
            r1 = 0
            goto L86
        L7f:
            vz.z r1 = new vz.z
            byte[] r3 = r9.a
            r1.<init>(r3, r11)
        L86:
            r10.i = r1
            int r11 = r11 + r2
            int r0 = r0 * 2
            int r11 = r11 + r0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: vz.e.E(vz.i, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] F(vz.r r11, vz.i r12, int r13, boolean r14) {
        /*
            r10 = this;
            char[] r0 = r12.c
            int r1 = r10.H(r13)
            int[] r2 = new int[r1]
            int r13 = r13 + 2
            r3 = 0
        Lb:
            if (r3 >= r1) goto L84
            r2[r3] = r13
            int r4 = r10.t(r13)
            int r5 = r4 >>> 24
            r6 = 23
            if (r5 == r6) goto L4d
            switch(r5) {
                case 16: goto L4d;
                case 17: goto L4d;
                case 18: goto L4d;
                default: goto L1c;
            }
        L1c:
            switch(r5) {
                case 64: goto L28;
                case 65: goto L28;
                case 66: goto L4d;
                case 67: goto L4d;
                case 68: goto L4d;
                case 69: goto L4d;
                case 70: goto L4d;
                case 71: goto L25;
                case 72: goto L25;
                case 73: goto L25;
                case 74: goto L25;
                case 75: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>()
            throw r11
        L25:
            int r13 = r13 + 4
            goto L4f
        L28:
            int r6 = r13 + 1
            int r6 = r10.H(r6)
            int r13 = r13 + 3
        L30:
            int r7 = r6 + (-1)
            if (r6 <= 0) goto L4f
            int r6 = r10.H(r13)
            int r8 = r13 + 2
            int r8 = r10.H(r8)
            int r13 = r13 + 6
            vz.q[] r9 = r12.g
            r10.d(r6, r9)
            int r6 = r6 + r8
            vz.q[] r8 = r12.g
            r10.d(r6, r8)
            r6 = r7
            goto L30
        L4d:
            int r13 = r13 + 3
        L4f:
            int r6 = r10.l(r13)
            r7 = 66
            r8 = 0
            r9 = 1
            if (r5 != r7) goto L78
            if (r6 != 0) goto L5c
            goto L63
        L5c:
            vz.z r8 = new vz.z
            byte[] r5 = r10.a
            r8.<init>(r5, r13)
        L63:
            int r6 = r6 * 2
            int r6 = r6 + r9
            int r13 = r13 + r6
            java.lang.String r5 = r10.G(r13, r0)
            int r13 = r13 + 2
            r4 = r4 & (-256(0xffffffffffffff00, float:NaN))
            vz.a r4 = r11.B(r4, r8, r5, r14)
            int r13 = r10.r(r4, r13, r9, r0)
            goto L81
        L78:
            int r6 = r6 * 2
            int r6 = r6 + 3
            int r13 = r13 + r6
            int r13 = r10.r(r8, r13, r9, r0)
        L81:
            int r3 = r3 + 1
            goto Lb
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: vz.e.F(vz.r, vz.i, int, boolean):int[]");
    }

    private String I(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.a;
        int i6 = 0;
        while (i < i4) {
            int i7 = i + 1;
            byte b = bArr[i];
            if ((b & 128) == 0) {
                cArr[i6] = (char) (b & Byte.MAX_VALUE);
                i6++;
                i = i7;
            } else {
                if ((b & 224) == 192) {
                    i3 = i6 + 1;
                    i += 2;
                    cArr[i6] = (char) (((b & 31) << 6) + (bArr[i7] & Utf8.REPLACEMENT_BYTE));
                } else {
                    i3 = i6 + 1;
                    int i8 = i + 2;
                    i += 3;
                    cArr[i6] = (char) (((b & 15) << 12) + ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 6) + (bArr[i8] & Utf8.REPLACEMENT_BYTE));
                }
                i6 = i3;
            }
        }
        return new String(cArr, 0, i6);
    }

    private int K(int i, Object[] objArr, int i2, char[] cArr, q[] qVarArr) {
        int i3 = i + 1;
        switch (this.a[i] & 255) {
            case 0:
                objArr[i2] = v.a;
                return i3;
            case 1:
                objArr[i2] = v.b;
                return i3;
            case 2:
                objArr[i2] = v.c;
                return i3;
            case 3:
                objArr[i2] = v.d;
                return i3;
            case 4:
                objArr[i2] = v.e;
                return i3;
            case 5:
                objArr[i2] = v.f;
                return i3;
            case 6:
                objArr[i2] = v.g;
                return i3;
            case 7:
                objArr[i2] = m(i3, cArr);
                break;
            case 8:
                objArr[i2] = d(H(i3), qVarArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i + 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0051, code lost:
    
        r11.o = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0053, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(vz.i r11) {
        /*
            r10 = this;
            java.lang.String r0 = r11.f
            java.lang.Object[] r1 = r11.q
            int r2 = r11.d
            r2 = r2 & 8
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L29
            java.lang.String r2 = "<init>"
            java.lang.String r5 = r11.e
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L1c
            java.lang.Integer r2 = vz.v.g
            r1[r4] = r2
        L1a:
            r4 = r3
            goto L29
        L1c:
            int r2 = r10.g
            int r2 = r2 + 2
            char[] r5 = r11.c
            java.lang.String r2 = r10.m(r2, r5)
            r1[r4] = r2
            goto L1a
        L29:
            r2 = r3
        L2a:
            int r5 = r2 + 1
            char r6 = r0.charAt(r2)
            r7 = 70
            if (r6 == r7) goto La6
            r7 = 59
            r8 = 76
            if (r6 == r8) goto L8f
            r9 = 83
            if (r6 == r9) goto L88
            r9 = 73
            if (r6 == r9) goto L88
            r9 = 74
            if (r6 == r9) goto L81
            r9 = 90
            if (r6 == r9) goto L88
            r9 = 91
            if (r6 == r9) goto L5d
            switch(r6) {
                case 66: goto L88;
                case 67: goto L88;
                case 68: goto L54;
                default: goto L51;
            }
        L51:
            r11.o = r4
            return
        L54:
            int r2 = r4 + 1
            java.lang.Integer r6 = vz.v.d
            r1[r4] = r6
        L5a:
            r4 = r2
            r2 = r5
            goto L2a
        L5d:
            char r6 = r0.charAt(r5)
            if (r6 != r9) goto L66
            int r5 = r5 + 1
            goto L5d
        L66:
            char r6 = r0.charAt(r5)
            if (r6 != r8) goto L75
        L6c:
            int r5 = r5 + 1
            char r6 = r0.charAt(r5)
            if (r6 == r7) goto L75
            goto L6c
        L75:
            int r6 = r4 + 1
            int r5 = r5 + r3
            java.lang.String r2 = r0.substring(r2, r5)
            r1[r4] = r2
            r2 = r5
            r4 = r6
            goto L2a
        L81:
            int r2 = r4 + 1
            java.lang.Integer r6 = vz.v.e
            r1[r4] = r6
            goto L5a
        L88:
            int r2 = r4 + 1
            java.lang.Integer r6 = vz.v.b
            r1[r4] = r6
            goto L5a
        L8f:
            r2 = r5
        L90:
            char r6 = r0.charAt(r2)
            if (r6 == r7) goto L99
            int r2 = r2 + 1
            goto L90
        L99:
            int r6 = r4 + 1
            int r7 = r2 + 1
            java.lang.String r2 = r0.substring(r5, r2)
            r1[r4] = r2
            r4 = r6
            r2 = r7
            goto L2a
        La6:
            int r2 = r4 + 1
            java.lang.Integer r6 = vz.v.c
            r1[r4] = r6
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: vz.e.b(vz.i):void");
    }

    private void c(int i, q[] qVarArr) {
        if (qVarArr[i] == null) {
            q u = u(i, qVarArr);
            u.a = (short) (u.a | 1);
        }
    }

    private q d(int i, q[] qVarArr) {
        q u = u(i, qVarArr);
        u.a = (short) (u.a & (-2));
        return u;
    }

    private int i(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || l(iArr[i]) < 67) {
            return -1;
        }
        return H(iArr[i] + 1);
    }

    private c j(c[] cVarArr, String str, int i, int i2, char[] cArr, int i3, q[] qVarArr) {
        for (c cVar : cVarArr) {
            if (cVar.a.equals(str)) {
                return cVar.g(this, i, i2, cArr, i3, qVarArr);
            }
        }
        return new c(str).g(this, i, i2, null, -1, null);
    }

    private int[] k(int i) {
        char[] cArr = new char[i];
        int e = e();
        for (int H = H(e - 2); H > 0; H--) {
            String G = G(e, cArr);
            int t = t(e + 2);
            int i2 = e + 6;
            if ("BootstrapMethods".equals(G)) {
                int H2 = H(i2);
                int[] iArr = new int[H2];
                int i3 = e + 8;
                for (int i4 = 0; i4 < H2; i4++) {
                    iArr[i4] = i3;
                    i3 += (H(i3 + 2) * 2) + 4;
                }
                return iArr;
            }
            e = i2 + t;
        }
        return null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private void n(vz.r r39, vz.i r40, int r41) {
        /*
            Method dump skipped, instructions count: 3348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vz.e.n(vz.r, vz.i, int):void");
    }

    private h p(int i, char[] cArr) {
        h hVar = this.d[i];
        if (hVar != null) {
            return hVar;
        }
        int[] iArr = this.b;
        int i2 = iArr[i];
        int i3 = iArr[H(i2 + 2)];
        String G = G(i3, cArr);
        String G2 = G(i3 + 2, cArr);
        int i4 = this.e[H(i2)];
        o oVar = (o) o(H(i4), cArr);
        int H = H(i4 + 2);
        Object[] objArr = new Object[H];
        int i6 = i4 + 4;
        for (int i7 = 0; i7 < H; i7++) {
            objArr[i7] = o(H(i6), cArr);
            i6 += 2;
        }
        h[] hVarArr = this.d;
        h hVar2 = new h(G, G2, oVar, objArr);
        hVarArr[i] = hVar2;
        return hVar2;
    }

    private int q(a aVar, int i, String str, char[] cArr) {
        int i2 = 0;
        if (aVar == null) {
            int i3 = this.a[i] & 255;
            return i3 != 64 ? i3 != 91 ? i3 != 101 ? i + 3 : i + 5 : r(null, i + 1, false, cArr) : r(null, i + 3, true, cArr);
        }
        int i4 = i + 1;
        int i6 = this.a[i] & 255;
        if (i6 == 64) {
            return r(aVar.b(str, G(i4, cArr)), i + 3, true, cArr);
        }
        if (i6 != 70) {
            if (i6 == 83) {
                aVar.a(str, Short.valueOf((short) t(this.b[H(i4)])));
            } else if (i6 == 99) {
                aVar.a(str, y.n(G(i4, cArr)));
            } else {
                if (i6 == 101) {
                    aVar.e(str, G(i4, cArr), G(i + 3, cArr));
                    return i + 5;
                }
                if (i6 == 115) {
                    aVar.a(str, G(i4, cArr));
                } else if (i6 != 73 && i6 != 74) {
                    if (i6 == 90) {
                        aVar.a(str, t(this.b[H(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                    } else {
                        if (i6 == 91) {
                            int H = H(i4);
                            int i7 = i + 3;
                            if (H == 0) {
                                return r(aVar.c(str), i + 1, false, cArr);
                            }
                            int i8 = this.a[i7] & 255;
                            if (i8 == 70) {
                                float[] fArr = new float[H];
                                while (i2 < H) {
                                    fArr[i2] = Float.intBitsToFloat(t(this.b[H(i7 + 1)]));
                                    i7 += 3;
                                    i2++;
                                }
                                aVar.a(str, fArr);
                            } else if (i8 == 83) {
                                short[] sArr = new short[H];
                                while (i2 < H) {
                                    sArr[i2] = (short) t(this.b[H(i7 + 1)]);
                                    i7 += 3;
                                    i2++;
                                }
                                aVar.a(str, sArr);
                            } else if (i8 == 90) {
                                boolean[] zArr = new boolean[H];
                                for (int i9 = 0; i9 < H; i9++) {
                                    zArr[i9] = t(this.b[H(i7 + 1)]) != 0;
                                    i7 += 3;
                                }
                                aVar.a(str, zArr);
                            } else if (i8 == 73) {
                                int[] iArr = new int[H];
                                while (i2 < H) {
                                    iArr[i2] = t(this.b[H(i7 + 1)]);
                                    i7 += 3;
                                    i2++;
                                }
                                aVar.a(str, iArr);
                            } else if (i8 != 74) {
                                switch (i8) {
                                    case 66:
                                        byte[] bArr = new byte[H];
                                        while (i2 < H) {
                                            bArr[i2] = (byte) t(this.b[H(i7 + 1)]);
                                            i7 += 3;
                                            i2++;
                                        }
                                        aVar.a(str, bArr);
                                        break;
                                    case 67:
                                        char[] cArr2 = new char[H];
                                        while (i2 < H) {
                                            cArr2[i2] = (char) t(this.b[H(i7 + 1)]);
                                            i7 += 3;
                                            i2++;
                                        }
                                        aVar.a(str, cArr2);
                                        break;
                                    case 68:
                                        double[] dArr = new double[H];
                                        while (i2 < H) {
                                            dArr[i2] = Double.longBitsToDouble(v(this.b[H(i7 + 1)]));
                                            i7 += 3;
                                            i2++;
                                        }
                                        aVar.a(str, dArr);
                                        break;
                                    default:
                                        return r(aVar.c(str), i + 1, false, cArr);
                                }
                            } else {
                                long[] jArr = new long[H];
                                while (i2 < H) {
                                    jArr[i2] = v(this.b[H(i7 + 1)]);
                                    i7 += 3;
                                    i2++;
                                }
                                aVar.a(str, jArr);
                            }
                            return i7;
                        }
                        switch (i6) {
                            case 66:
                                aVar.a(str, Byte.valueOf((byte) t(this.b[H(i4)])));
                                break;
                            case 67:
                                aVar.a(str, Character.valueOf((char) t(this.b[H(i4)])));
                                break;
                            case 68:
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    }
                }
            }
            return i + 3;
        }
        aVar.a(str, o(H(i4), cArr));
        return i + 3;
    }

    private int r(a aVar, int i, boolean z, char[] cArr) {
        int H = H(i);
        int i2 = i + 2;
        if (!z) {
            while (true) {
                int i3 = H - 1;
                if (H <= 0) {
                    break;
                }
                i2 = q(aVar, i2, null, cArr);
                H = i3;
            }
        } else {
            while (true) {
                int i4 = H - 1;
                if (H <= 0) {
                    break;
                }
                i2 = q(aVar, i2 + 2, G(i2, cArr), cArr);
                H = i4;
            }
        }
        if (aVar != null) {
            aVar.d();
        }
        return i2;
    }

    private int s(f fVar, i iVar, int i) {
        int i2;
        int i3;
        i iVar2 = iVar;
        char[] cArr = iVar2.c;
        int H = H(i);
        String G = G(i + 2, cArr);
        String G2 = G(i + 4, cArr);
        int H2 = H(i + 6);
        int i4 = i + 8;
        int i6 = H;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        c cVar = null;
        String str = null;
        Object obj = null;
        while (true) {
            int i11 = H2 - 1;
            if (H2 <= 0) {
                break;
            }
            String G3 = G(i4, cArr);
            int t = t(i4 + 2);
            int i12 = i4 + 6;
            if ("ConstantValue".equals(G3)) {
                int H3 = H(i12);
                obj = H3 == 0 ? null : o(H3, cArr);
            } else if ("Signature".equals(G3)) {
                str = G(i12, cArr);
            } else {
                if ("Deprecated".equals(G3)) {
                    i3 = 131072 | i6;
                } else if ("Synthetic".equals(G3)) {
                    i3 = i6 | 4096;
                } else {
                    if ("RuntimeVisibleAnnotations".equals(G3)) {
                        i10 = i12;
                        i2 = i10;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(G3)) {
                        i8 = i12;
                        i2 = i8;
                    } else if ("RuntimeInvisibleAnnotations".equals(G3)) {
                        i9 = i12;
                        i2 = i9;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(G3)) {
                        i7 = i12;
                        i2 = i7;
                    } else {
                        i2 = i12;
                        c cVar2 = cVar;
                        cVar = j(iVar2.a, G3, i2, t, cArr, -1, null);
                        cVar.c = cVar2;
                        i9 = i9;
                        i10 = i10;
                        i7 = i7;
                        i8 = i8;
                    }
                    i4 = i2 + t;
                    iVar2 = iVar;
                    H2 = i11;
                }
                i6 = i3;
            }
            i2 = i12;
            i4 = i2 + t;
            iVar2 = iVar;
            H2 = i11;
        }
        c cVar3 = cVar;
        int i13 = i7;
        int i14 = i8;
        int i15 = i9;
        int i16 = i10;
        l e = fVar.e(i6, G, G2, str, obj);
        if (e == null) {
            return i4;
        }
        if (i16 != 0) {
            int H4 = H(i16);
            int i17 = i16 + 2;
            while (true) {
                int i18 = H4 - 1;
                if (H4 <= 0) {
                    break;
                }
                i17 = r(e.a(G(i17, cArr), true), i17 + 2, true, cArr);
                H4 = i18;
            }
        }
        if (i15 != 0) {
            int H5 = H(i15);
            int i19 = i15 + 2;
            while (true) {
                int i20 = H5 - 1;
                if (H5 <= 0) {
                    break;
                }
                i19 = r(e.a(G(i19, cArr), false), i19 + 2, true, cArr);
                H5 = i20;
            }
        }
        if (i14 != 0) {
            int H6 = H(i14);
            int i21 = i14 + 2;
            while (true) {
                int i22 = H6 - 1;
                if (H6 <= 0) {
                    break;
                }
                int E = E(iVar, i21);
                i21 = r(e.d(iVar.h, iVar.i, G(E, cArr), true), E + 2, true, cArr);
                H6 = i22;
            }
        }
        if (i13 != 0) {
            int H7 = H(i13);
            int i23 = i13 + 2;
            while (true) {
                int i24 = H7 - 1;
                if (H7 <= 0) {
                    break;
                }
                int E2 = E(iVar, i23);
                i23 = r(e.d(iVar.h, iVar.i, G(E2, cArr), false), E2 + 2, true, cArr);
                H7 = i24;
            }
        }
        while (true) {
            c cVar4 = cVar3;
            if (cVar4 == null) {
                e.c();
                return i4;
            }
            cVar3 = cVar4.c;
            cVar4.c = null;
            e.b(cVar4);
        }
    }

    private int w(f fVar, i iVar, int i) {
        int i2;
        int i3;
        char[] cArr = iVar.c;
        iVar.d = H(i);
        iVar.e = G(i + 2, cArr);
        int i4 = i + 4;
        iVar.f = G(i4, cArr);
        int H = H(i + 6);
        int i6 = i + 8;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        c cVar = null;
        boolean z = false;
        int i14 = 0;
        String[] strArr = null;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = H - 1;
            if (H <= 0) {
                break;
            }
            String G = G(i6, cArr);
            int t = t(i6 + 2);
            int i19 = i13;
            int i20 = i6 + 6;
            int i21 = i7;
            if (!"Code".equals(G)) {
                if ("Exceptions".equals(G)) {
                    int H2 = H(i20);
                    String[] strArr2 = new String[H2];
                    int i22 = i6 + 8;
                    i2 = i8;
                    for (int i23 = 0; i23 < H2; i23++) {
                        strArr2[i23] = m(i22, cArr);
                        i22 += 2;
                    }
                    strArr = strArr2;
                    i14 = i20;
                    i3 = i14;
                } else {
                    i2 = i8;
                    if ("Signature".equals(G)) {
                        i3 = i20;
                        i7 = i21;
                        i8 = i2;
                        i13 = H(i20);
                    } else if ("Deprecated".equals(G)) {
                        iVar.d |= ASTNode.BLOCK_DO_UNTIL;
                        i3 = i20;
                    } else if ("RuntimeVisibleAnnotations".equals(G)) {
                        i10 = i20;
                        i3 = i10;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(G)) {
                        i8 = i20;
                        i3 = i8;
                        i13 = i19;
                        i7 = i21;
                    } else if ("AnnotationDefault".equals(G)) {
                        i12 = i20;
                        i3 = i12;
                    } else if ("Synthetic".equals(G)) {
                        iVar.d |= 4096;
                        i3 = i20;
                        i13 = i19;
                        i7 = i21;
                        i8 = i2;
                        z = true;
                    } else if ("RuntimeInvisibleAnnotations".equals(G)) {
                        i9 = i20;
                        i3 = i9;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(G)) {
                        i7 = i20;
                        i3 = i7;
                        i13 = i19;
                    } else if ("RuntimeVisibleParameterAnnotations".equals(G)) {
                        i15 = i20;
                        i3 = i15;
                    } else if ("RuntimeInvisibleParameterAnnotations".equals(G)) {
                        i16 = i20;
                        i3 = i16;
                    } else if ("MethodParameters".equals(G)) {
                        i11 = i20;
                        i3 = i11;
                    } else {
                        i3 = i20;
                        c j = j(iVar.a, G, i20, t, cArr, -1, null);
                        j.c = cVar;
                        cVar = j;
                        i13 = i19;
                        i7 = i21;
                        i8 = i2;
                        i9 = i9;
                        i10 = i10;
                        i11 = i11;
                        i12 = i12;
                    }
                    i6 = i3 + t;
                    H = i18;
                }
                i13 = i19;
                i7 = i21;
            } else if ((iVar.b & 1) == 0) {
                i17 = i20;
                i3 = i17;
                i13 = i19;
                i7 = i21;
                i6 = i3 + t;
                H = i18;
            } else {
                i2 = i8;
                i3 = i20;
                i13 = i19;
                i7 = i21;
            }
            i8 = i2;
            i6 = i3 + t;
            H = i18;
        }
        int i24 = i7;
        int i25 = i8;
        int i26 = i9;
        int i27 = i10;
        int i28 = i11;
        int i29 = i12;
        r g = fVar.g(iVar.d, iVar.e, iVar.f, i13 == 0 ? null : J(i13, cArr), strArr);
        if (g == null) {
            return i6;
        }
        if (g instanceof s) {
            if (((s) g).H(this, i, i6 - i, z, (iVar.d & ASTNode.BLOCK_DO_UNTIL) != 0, H(i4), i13, i14)) {
                return i6;
            }
        }
        if (i28 != 0) {
            int l = l(i28);
            int i30 = i28 + 1;
            while (true) {
                int i31 = l - 1;
                if (l <= 0) {
                    break;
                }
                g.y(G(i30, cArr), H(i30 + 2));
                i30 += 4;
                l = i31;
            }
        }
        if (i29 != 0) {
            a c = g.c();
            q(c, i29, null, cArr);
            if (c != null) {
                c.d();
            }
        }
        if (i27 != 0) {
            int H3 = H(i27);
            int i32 = i27 + 2;
            while (true) {
                int i33 = H3 - 1;
                if (H3 <= 0) {
                    break;
                }
                i32 = r(g.b(G(i32, cArr), true), i32 + 2, true, cArr);
                H3 = i33;
            }
        }
        if (i26 != 0) {
            int H4 = H(i26);
            int i34 = i26 + 2;
            while (true) {
                int i35 = H4 - 1;
                if (H4 <= 0) {
                    break;
                }
                i34 = r(g.b(G(i34, cArr), false), i34 + 2, true, cArr);
                H4 = i35;
            }
        }
        if (i25 != 0) {
            int H5 = H(i25);
            int i36 = i25 + 2;
            while (true) {
                int i37 = H5 - 1;
                if (H5 <= 0) {
                    break;
                }
                int E = E(iVar, i36);
                i36 = r(g.D(iVar.h, iVar.i, G(E, cArr), true), E + 2, true, cArr);
                H5 = i37;
            }
        }
        if (i24 != 0) {
            int H6 = H(i24);
            int i38 = i24 + 2;
            while (true) {
                int i39 = H6 - 1;
                if (H6 <= 0) {
                    break;
                }
                int E2 = E(iVar, i38);
                i38 = r(g.D(iVar.h, iVar.i, G(E2, cArr), false), E2 + 2, true, cArr);
                H6 = i39;
            }
        }
        int i40 = i15;
        if (i40 != 0) {
            A(g, iVar, i40, true);
        }
        int i41 = i16;
        if (i41 != 0) {
            A(g, iVar, i41, false);
        }
        while (cVar != null) {
            c cVar2 = cVar.c;
            cVar.c = null;
            g.d(cVar);
            cVar = cVar2;
        }
        int i42 = i17;
        if (i42 != 0) {
            g.e();
            n(g, iVar, i42);
        }
        g.f();
        return i6;
    }

    private void y(f fVar, i iVar, int i, int i2, String str) {
        String[] strArr;
        char[] cArr = iVar.c;
        int i3 = i + 6;
        t h = fVar.h(x(i, cArr), H(i + 2), G(i + 4, cArr));
        if (h == null) {
            return;
        }
        if (str != null) {
            h.c(str);
        }
        if (i2 != 0) {
            int H = H(i2);
            int i4 = i2 + 2;
            while (true) {
                int i6 = H - 1;
                if (H <= 0) {
                    break;
                }
                h.e(z(i4, cArr));
                i4 += 2;
                H = i6;
            }
        }
        int H2 = H(i3);
        int i7 = i + 8;
        while (true) {
            int i8 = H2 - 1;
            if (H2 <= 0) {
                break;
            }
            String x = x(i7, cArr);
            int H3 = H(i7 + 2);
            String G = G(i7 + 4, cArr);
            i7 += 6;
            h.g(x, H3, G);
            H2 = i8;
        }
        int H4 = H(i7);
        int i9 = i7 + 2;
        while (true) {
            int i10 = H4 - 1;
            String[] strArr2 = null;
            if (H4 <= 0) {
                break;
            }
            String z = z(i9, cArr);
            int H5 = H(i9 + 2);
            int H6 = H(i9 + 4);
            i9 += 6;
            if (H6 != 0) {
                strArr2 = new String[H6];
                for (int i11 = 0; i11 < H6; i11++) {
                    strArr2[i11] = x(i9, cArr);
                    i9 += 2;
                }
            }
            h.b(z, H5, strArr2);
            H4 = i10;
        }
        int H7 = H(i9);
        int i12 = i9 + 2;
        while (true) {
            int i13 = H7 - 1;
            if (H7 <= 0) {
                break;
            }
            String z2 = z(i12, cArr);
            int H8 = H(i12 + 2);
            int H9 = H(i12 + 4);
            i12 += 6;
            if (H9 != 0) {
                strArr = new String[H9];
                for (int i14 = 0; i14 < H9; i14++) {
                    strArr[i14] = x(i12, cArr);
                    i12 += 2;
                }
            } else {
                strArr = null;
            }
            h.d(z2, H8, strArr);
            H7 = i13;
        }
        int H10 = H(i12);
        int i15 = i12 + 2;
        while (true) {
            int i16 = H10 - 1;
            if (H10 <= 0) {
                break;
            }
            h.h(m(i15, cArr));
            i15 += 2;
            H10 = i16;
        }
        int H11 = H(i15);
        int i17 = i15 + 2;
        while (true) {
            int i18 = H11 - 1;
            if (H11 <= 0) {
                h.a();
                return;
            }
            String m = m(i17, cArr);
            int H12 = H(i17 + 2);
            i17 += 4;
            String[] strArr3 = new String[H12];
            for (int i19 = 0; i19 < H12; i19++) {
                strArr3[i19] = m(i17, cArr);
                i17 += 2;
            }
            h.f(m, strArr3);
            H11 = i18;
        }
    }

    public short B(int i) {
        byte[] bArr = this.a;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public String G(int i, char[] cArr) {
        int H = H(i);
        if (i == 0 || H == 0) {
            return null;
        }
        return J(H, cArr);
    }

    public int H(int i) {
        byte[] bArr = this.a;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    final String J(int i, char[] cArr) {
        String[] strArr = this.c;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.b[i];
        String I = I(i2 + 2, H(i2), cArr);
        strArr[i] = I;
        return I;
    }

    public void a(f fVar, c[] cVarArr, int i) {
        int i2;
        int i3;
        int i4;
        String[] strArr;
        i iVar = new i();
        iVar.a = cVarArr;
        iVar.b = i;
        char[] cArr = new char[this.f];
        iVar.c = cArr;
        int i6 = this.g;
        int H = H(i6);
        String m = m(i6 + 2, cArr);
        String m2 = m(i6 + 4, cArr);
        int H2 = H(i6 + 6);
        String[] strArr2 = new String[H2];
        int i7 = i6 + 8;
        for (int i8 = 0; i8 < H2; i8++) {
            strArr2[i8] = m(i7, cArr);
            i7 += 2;
        }
        int e = e();
        int i9 = H;
        int H3 = H(e - 2);
        String str = null;
        String str2 = null;
        int i10 = 0;
        String str3 = null;
        int i11 = 0;
        String str4 = null;
        String str5 = null;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        c cVar = null;
        int i18 = 0;
        while (H3 > 0) {
            String G = G(e, cArr);
            int t = t(e + 2);
            int i19 = e + 6;
            String str6 = str;
            if ("SourceFile".equals(G)) {
                i2 = i19;
                str2 = G(i19, cArr);
            } else if ("InnerClasses".equals(G)) {
                i18 = i19;
                i2 = i18;
            } else if ("EnclosingMethod".equals(G)) {
                i12 = i19;
                i2 = i12;
            } else if ("NestHost".equals(G)) {
                i2 = i19;
                str5 = m(i19, cArr);
            } else if ("NestMembers".equals(G)) {
                i17 = i19;
                i2 = i17;
            } else {
                if ("Signature".equals(G)) {
                    str3 = G(i19, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(G)) {
                    i13 = i19;
                    i2 = i13;
                } else if ("RuntimeVisibleTypeAnnotations".equals(G)) {
                    i15 = i19;
                    i2 = i15;
                } else if ("Deprecated".equals(G)) {
                    i9 |= ASTNode.BLOCK_DO_UNTIL;
                } else if ("Synthetic".equals(G)) {
                    i9 |= 4096;
                } else if ("SourceDebugExtension".equals(G)) {
                    str = I(i19, t, new char[t]);
                    i2 = i19;
                    i3 = i7;
                    i4 = t;
                    strArr = strArr2;
                    e = i2 + i4;
                    H3--;
                    strArr2 = strArr;
                    i7 = i3;
                } else if ("RuntimeInvisibleAnnotations".equals(G)) {
                    i14 = i19;
                    i2 = i14;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(G)) {
                    i16 = i19;
                    i2 = i16;
                } else if ("Module".equals(G)) {
                    i10 = i19;
                    i2 = i10;
                } else if ("ModuleMainClass".equals(G)) {
                    str4 = m(i19, cArr);
                } else if ("ModulePackages".equals(G)) {
                    i11 = i19;
                    i2 = i11;
                } else {
                    if ("BootstrapMethods".equals(G)) {
                        i2 = i19;
                        i3 = i7;
                        i4 = t;
                        strArr = strArr2;
                        str = str6;
                    } else {
                        i2 = i19;
                        i3 = i7;
                        i4 = t;
                        strArr = strArr2;
                        c j = j(cVarArr, G, i2, t, cArr, -1, null);
                        j.c = cVar;
                        cVar = j;
                        i9 = i9;
                        str = str6;
                        str2 = str2;
                    }
                    e = i2 + i4;
                    H3--;
                    strArr2 = strArr;
                    i7 = i3;
                }
                i2 = i19;
            }
            i3 = i7;
            i4 = t;
            strArr = strArr2;
            str = str6;
            e = i2 + i4;
            H3--;
            strArr2 = strArr;
            i7 = i3;
        }
        String str7 = str;
        String str8 = str2;
        int i20 = i7;
        String[] strArr3 = strArr2;
        c cVar2 = cVar;
        fVar.a(t(this.b[1] - 7), i9, m, str3, m2, strArr3);
        if ((i & 2) == 0 && (str8 != null || str7 != null)) {
            fVar.l(str8, str7);
        }
        if (i10 != 0) {
            y(fVar, iVar, i10, i11, str4);
        }
        String str9 = str5;
        if (str9 != null) {
            fVar.i(str9);
        }
        int i21 = i12;
        if (i21 != 0) {
            String m3 = m(i21, cArr);
            int H4 = H(i21 + 2);
            fVar.k(m3, H4 == 0 ? null : G(this.b[H4], cArr), H4 == 0 ? null : G(this.b[H4] + 2, cArr));
        }
        int i22 = i13;
        if (i22 != 0) {
            int H5 = H(i22);
            int i23 = i22 + 2;
            while (true) {
                int i24 = H5 - 1;
                if (H5 <= 0) {
                    break;
                }
                i23 = r(fVar.b(G(i23, cArr), true), i23 + 2, true, cArr);
                H5 = i24;
            }
        }
        int i25 = i14;
        if (i25 != 0) {
            int H6 = H(i25);
            int i26 = i25 + 2;
            while (true) {
                int i27 = H6 - 1;
                if (H6 <= 0) {
                    break;
                }
                i26 = r(fVar.b(G(i26, cArr), false), i26 + 2, true, cArr);
                H6 = i27;
            }
        }
        int i28 = i15;
        if (i28 != 0) {
            int H7 = H(i28);
            int i29 = i28 + 2;
            while (true) {
                int i30 = H7 - 1;
                if (H7 <= 0) {
                    break;
                }
                int E = E(iVar, i29);
                i29 = r(fVar.m(iVar.h, iVar.i, G(E, cArr), true), E + 2, true, cArr);
                H7 = i30;
            }
        }
        int i31 = i16;
        if (i31 != 0) {
            int H8 = H(i31);
            int i32 = i31 + 2;
            while (true) {
                int i33 = H8 - 1;
                if (H8 <= 0) {
                    break;
                }
                int E2 = E(iVar, i32);
                i32 = r(fVar.m(iVar.h, iVar.i, G(E2, cArr), false), E2 + 2, true, cArr);
                H8 = i33;
            }
        }
        while (cVar2 != null) {
            c cVar3 = cVar2.c;
            cVar2.c = null;
            fVar.c(cVar2);
            cVar2 = cVar3;
        }
        int i34 = i17;
        if (i34 != 0) {
            int H9 = H(i34);
            int i35 = i34 + 2;
            while (true) {
                int i36 = H9 - 1;
                if (H9 <= 0) {
                    break;
                }
                fVar.j(m(i35, cArr));
                i35 += 2;
                H9 = i36;
            }
        }
        int i37 = i18;
        if (i37 != 0) {
            int H10 = H(i37);
            int i38 = i37 + 2;
            while (true) {
                int i39 = H10 - 1;
                if (H10 <= 0) {
                    break;
                }
                fVar.f(m(i38, cArr), m(i38 + 2, cArr), G(i38 + 4, cArr), H(i38 + 6));
                i38 += 8;
                H10 = i39;
            }
        }
        int H11 = H(i20);
        int i40 = i20 + 2;
        while (true) {
            int i41 = H11 - 1;
            if (H11 <= 0) {
                break;
            }
            i40 = s(fVar, iVar, i40);
            H11 = i41;
        }
        int H12 = H(i40);
        int i42 = i40 + 2;
        while (true) {
            int i43 = H12 - 1;
            if (H12 <= 0) {
                fVar.d();
                return;
            } else {
                i42 = w(fVar, iVar, i42);
                H12 = i43;
            }
        }
    }

    final int e() {
        int i = this.g;
        int H = i + 8 + (H(i + 6) * 2);
        int H2 = H(H);
        int i2 = H + 2;
        while (true) {
            int i3 = H2 - 1;
            if (H2 <= 0) {
                break;
            }
            int H3 = H(i2 + 6);
            i2 += 8;
            while (true) {
                int i4 = H3 - 1;
                if (H3 > 0) {
                    i2 += t(i2 + 2) + 6;
                    H3 = i4;
                }
            }
            H2 = i3;
        }
        int H4 = H(i2);
        int i6 = i2 + 2;
        while (true) {
            int i7 = H4 - 1;
            if (H4 <= 0) {
                return i6 + 2;
            }
            int H5 = H(i6 + 6);
            i6 += 8;
            while (true) {
                int i8 = H5 - 1;
                if (H5 > 0) {
                    i6 += t(i6 + 2) + 6;
                    H5 = i8;
                }
            }
            H4 = i7;
        }
    }

    public int f(int i) {
        return this.b[i];
    }

    public int g() {
        return this.b.length;
    }

    public int h() {
        return this.f;
    }

    public int l(int i) {
        return this.a[i] & 255;
    }

    public String m(int i, char[] cArr) {
        return D(i, cArr);
    }

    public Object o(int i, char[] cArr) {
        int i2 = this.b[i];
        byte b = this.a[i2 - 1];
        switch (b) {
            case 3:
                return Integer.valueOf(t(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(t(i2)));
            case 5:
                return Long.valueOf(v(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(v(i2)));
            case 7:
                return y.k(G(i2, cArr));
            case 8:
                return G(i2, cArr);
            default:
                switch (b) {
                    case ActionEvent.pageview /* 15 */:
                        int l = l(i2);
                        int i3 = this.b[H(i2 + 1)];
                        int i4 = this.b[H(i3 + 2)];
                        return new o(l, m(i3, cArr), G(i4, cArr), G(i4 + 2, cArr), this.a[i3 - 1] == 11);
                    case 16:
                        return y.j(G(i2, cArr));
                    case ActionEvent.want_to_see_cancel /* 17 */:
                        return p(i, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    public int t(int i) {
        byte[] bArr = this.a;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    protected q u(int i, q[] qVarArr) {
        if (qVarArr[i] == null) {
            qVarArr[i] = new q();
        }
        return qVarArr[i];
    }

    public long v(int i) {
        return (t(i) << 32) | (t(i + 4) & 4294967295L);
    }

    public String x(int i, char[] cArr) {
        return D(i, cArr);
    }

    public String z(int i, char[] cArr) {
        return D(i, cArr);
    }
}
