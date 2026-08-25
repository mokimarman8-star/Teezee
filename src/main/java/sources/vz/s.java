package vz;

import org.mvel2.asm.MethodTooLargeException;
import org.mvel2.ast.ASTNode;
import vz.c;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class s extends r {
    private static final int[] c0 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    private final int A;
    private b B;
    private b C;
    private int D;
    private b[] E;
    private int F;
    private b[] G;
    private b H;
    private b I;
    private d J;
    private int K;
    private d L;
    private c M;
    private final int N;
    private q O;
    private q P;
    private q Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int[] V;
    private int[] W;
    private boolean X;
    private boolean Y;
    private int Z;
    private int a0;
    private int b0;
    private final x c;
    private final int d;
    private final int e;
    private final String f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private final d k;
    private p l;
    private p m;
    private int n;
    private d o;
    private int p;
    private d q;
    private int r;
    private d s;
    private int t;
    private d u;
    private b v;
    private b w;
    private c x;
    private final int y;
    private final int[] z;

    s(x xVar, int i, String str, String str2, String str3, String[] strArr, int i2) {
        super(458752);
        this.k = new d();
        this.c = xVar;
        this.d = "<init>".equals(str) ? 262144 | i : i;
        this.e = xVar.D(str);
        this.f = str;
        this.g = xVar.D(str2);
        this.h = str2;
        this.A = str3 == null ? 0 : xVar.D(str3);
        if (strArr == null || strArr.length <= 0) {
            this.y = 0;
            this.z = null;
        } else {
            int length = strArr.length;
            this.y = length;
            this.z = new int[length];
            for (int i3 = 0; i3 < this.y; i3++) {
                this.z[i3] = xVar.e(strArr[i3]).a;
            }
        }
        this.N = i2;
        if (i2 != 0) {
            int c = y.c(str2) >> 2;
            c = (i & 8) != 0 ? c - 1 : c;
            this.j = c;
            this.T = c;
            q qVar = new q();
            this.O = qVar;
            o(qVar);
        }
    }

    private void G(int i, q qVar) {
        q qVar2 = this.Q;
        qVar2.l = new k(i, qVar, qVar2.l);
    }

    private void J() {
        p pVar = this.l;
        while (true) {
            if (pVar == null) {
                break;
            }
            String str = pVar.e;
            int g = n.g(this.c, str != null ? str : "java/lang/Throwable");
            q e = pVar.c.e();
            e.a = (short) (e.a | 2);
            q e3 = pVar.b.e();
            for (q e4 = pVar.a.e(); e4 != e3; e4 = e4.k) {
                e4.l = new k(g, e, e4.l);
            }
            pVar = pVar.f;
        }
        n nVar = this.O.j;
        nVar.t(this.c, this.d, this.h, this.j);
        nVar.a(this);
        q qVar = this.O;
        qVar.m = q.n;
        int i = 0;
        while (qVar != q.n) {
            q qVar2 = qVar.m;
            qVar.m = null;
            qVar.a = (short) (qVar.a | 8);
            int i2 = qVar.j.i() + qVar.h;
            if (i2 > i) {
                i = i2;
            }
            for (k kVar = qVar.l; kVar != null; kVar = kVar.c) {
                q e5 = kVar.b.e();
                if (qVar.j.l(this.c, e5.j, kVar.a) && e5.m == null) {
                    e5.m = qVar2;
                    qVar2 = e5;
                }
            }
            qVar = qVar2;
        }
        for (q qVar3 = this.O; qVar3 != null; qVar3 = qVar3.k) {
            if ((qVar3.a & 10) == 10) {
                qVar3.j.a(this);
            }
            if ((qVar3.a & 8) == 0) {
                q qVar4 = qVar3.k;
                int i3 = qVar3.d;
                int i4 = (qVar4 == null ? this.k.b : qVar4.d) - 1;
                if (i4 >= i3) {
                    for (int i6 = i3; i6 < i4; i6++) {
                        this.k.a[i6] = 0;
                    }
                    this.k.a[i4] = -65;
                    this.W[V(i3, 0, 1)] = n.g(this.c, "java/lang/Throwable");
                    U();
                    this.l = p.d(this.l, qVar3, qVar4);
                    i = Math.max(i, 1);
                }
            }
        }
        this.i = i;
    }

    private void K() {
        for (p pVar = this.l; pVar != null; pVar = pVar.f) {
            q qVar = pVar.c;
            q qVar2 = pVar.b;
            for (q qVar3 = pVar.a; qVar3 != qVar2; qVar3 = qVar3.k) {
                if ((qVar3.a & 16) == 0) {
                    qVar3.l = new k(Integer.MAX_VALUE, qVar, qVar3.l);
                } else {
                    k kVar = qVar3.l.c;
                    kVar.c = new k(Integer.MAX_VALUE, qVar, kVar.c);
                }
            }
        }
        if (this.X) {
            this.O.f((short) 1);
            short s = 1;
            for (short s2 = 1; s2 <= s; s2 = (short) (s2 + 1)) {
                for (q qVar4 = this.O; qVar4 != null; qVar4 = qVar4.k) {
                    if ((qVar4.a & 16) != 0 && qVar4.i == s2) {
                        q qVar5 = qVar4.l.c.b;
                        if (qVar5.i == 0) {
                            s = (short) (s + 1);
                            qVar5.f(s);
                        }
                    }
                }
            }
            for (q qVar6 = this.O; qVar6 != null; qVar6 = qVar6.k) {
                if ((qVar6.a & 16) != 0) {
                    qVar6.l.c.b.d(qVar6);
                }
            }
        }
        q qVar7 = this.O;
        qVar7.m = q.n;
        int i = this.i;
        while (qVar7 != q.n) {
            q qVar8 = qVar7.m;
            short s3 = qVar7.f;
            int i2 = qVar7.h + s3;
            if (i2 > i) {
                i = i2;
            }
            k kVar2 = qVar7.l;
            if ((qVar7.a & 16) != 0) {
                kVar2 = kVar2.c;
            }
            qVar7 = qVar8;
            while (kVar2 != null) {
                q qVar9 = kVar2.b;
                if (qVar9.m == null) {
                    int i3 = kVar2.a;
                    qVar9.f = (short) (i3 == Integer.MAX_VALUE ? 1 : i3 + s3);
                    qVar9.m = qVar7;
                    qVar7 = qVar9;
                }
                kVar2 = kVar2.c;
            }
        }
        this.i = i;
    }

    private void M() {
        int i = this.N;
        if (i != 4) {
            if (i == 1) {
                this.Q.h = (short) this.S;
                this.Q = null;
                return;
            }
            return;
        }
        q qVar = new q();
        qVar.j = new n(qVar);
        d dVar = this.k;
        qVar.i(dVar.a, dVar.b);
        this.P.k = qVar;
        this.P = qVar;
        this.Q = null;
    }

    private void P(int i, int i2) {
        while (i < i2) {
            n.r(this.c, this.W[i], this.u);
            i++;
        }
    }

    private void Q() {
        char c;
        int[] iArr = this.W;
        int i = iArr[1];
        int i2 = iArr[2];
        int i3 = 0;
        if (this.c.R() < 50) {
            this.u.k(this.W[0]).k(i);
            int i4 = i + 3;
            P(3, i4);
            this.u.k(i2);
            P(i4, i2 + i4);
            return;
        }
        int i6 = this.t == 0 ? this.W[0] : (this.W[0] - this.V[0]) - 1;
        int i7 = this.V[1];
        int i8 = i - i7;
        if (i2 == 0) {
            switch (i8) {
                case -3:
                case -2:
                case -1:
                    c = 248;
                    break;
                case 0:
                    if (i6 >= 64) {
                        c = 251;
                        break;
                    } else {
                        c = 0;
                        break;
                    }
                case 1:
                case 2:
                case 3:
                    c = 252;
                    break;
                default:
                    c = 255;
                    break;
            }
        } else {
            if (i8 == 0 && i2 == 1) {
                c = i6 < 63 ? '@' : (char) 247;
            }
            c = 255;
        }
        if (c != 255) {
            int i9 = 3;
            while (true) {
                if (i3 < i7 && i3 < i) {
                    if (this.W[i9] != this.V[i9]) {
                        c = 255;
                    } else {
                        i9++;
                        i3++;
                    }
                }
            }
        }
        if (c == 0) {
            this.u.g(i6);
            return;
        }
        if (c == '@') {
            this.u.g(i6 + 64);
            P(i + 3, i + 4);
            return;
        }
        if (c == 247) {
            this.u.g(247).k(i6);
            P(i + 3, i + 4);
            return;
        }
        if (c == 248) {
            this.u.g(i8 + 251).k(i6);
            return;
        }
        if (c == 251) {
            this.u.g(251).k(i6);
            return;
        }
        if (c == 252) {
            this.u.g(i8 + 251).k(i6);
            P(i7 + 3, i + 3);
            return;
        }
        this.u.g(255).k(i6).k(i);
        int i10 = i + 3;
        P(3, i10);
        this.u.k(i2);
        P(i10, i2 + i10);
    }

    private void R(Object obj) {
        if (obj instanceof Integer) {
            this.u.g(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.u.g(7).k(this.c.e((String) obj).a);
        } else {
            this.u.g(8).k(((q) obj).d);
        }
    }

    private void W(q qVar, q[] qVarArr) {
        q qVar2 = this.Q;
        if (qVar2 != null) {
            int i = this.N;
            if (i == 4) {
                qVar2.j.d(171, 0, null, null);
                G(0, qVar);
                q e = qVar.e();
                e.a = (short) (e.a | 2);
                for (q qVar3 : qVarArr) {
                    G(0, qVar3);
                    q e3 = qVar3.e();
                    e3.a = (short) (e3.a | 2);
                }
            } else if (i == 1) {
                int i2 = this.R - 1;
                this.R = i2;
                G(i2, qVar);
                for (q qVar4 : qVarArr) {
                    G(this.R, qVar4);
                }
            }
            M();
        }
    }

    @Override // vz.r
    public void A(int i, int i2, q qVar, q... qVarArr) {
        d dVar = this.k;
        this.Z = dVar.b;
        dVar.g(170).h(null, 0, (4 - (this.k.b % 4)) % 4);
        qVar.h(this.k, this.Z, true);
        this.k.i(i).i(i2);
        for (q qVar2 : qVarArr) {
            qVar2.h(this.k, this.Z, true);
        }
        W(qVar, qVarArr);
    }

    @Override // vz.r
    public a B(int i, z zVar, String str, boolean z) {
        d dVar = new d();
        a0.a(i, dVar);
        z.d(zVar, dVar);
        dVar.k(this.c.D(str)).k(0);
        if (z) {
            b bVar = new b(this.c, dVar, this.v);
            this.v = bVar;
            return bVar;
        }
        b bVar2 = new b(this.c, dVar, this.w);
        this.w = bVar2;
        return bVar2;
    }

    @Override // vz.r
    public void C(q qVar, q qVar2, q qVar3, String str) {
        p pVar = new p(qVar, qVar2, qVar3, str != null ? this.c.e(str).a : 0, str);
        if (this.l == null) {
            this.l = pVar;
        } else {
            this.m.f = pVar;
        }
        this.m = pVar;
    }

    @Override // vz.r
    public a D(int i, z zVar, String str, boolean z) {
        d dVar = new d();
        a0.a(i, dVar);
        z.d(zVar, dVar);
        dVar.k(this.c.D(str)).k(0);
        if (z) {
            b bVar = new b(this.c, dVar, this.H);
            this.H = bVar;
            return bVar;
        }
        b bVar2 = new b(this.c, dVar, this.I);
        this.I = bVar2;
        return bVar2;
    }

    @Override // vz.r
    public void E(int i, String str) {
        this.Z = this.k.b;
        w e = this.c.e(str);
        this.k.e(i, e.a);
        q qVar = this.Q;
        if (qVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                qVar.j.d(i, this.Z, e, this.c);
            } else if (i == 187) {
                int i3 = this.R + 1;
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
        }
    }

    @Override // vz.r
    public void F(int i, int i2) {
        d dVar = this.k;
        this.Z = dVar.b;
        if (i2 < 4 && i != 169) {
            dVar.g((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            dVar.g(196).e(i, i2);
        } else {
            dVar.c(i, i2);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                qVar.j.d(i, i2, null, null);
            } else if (i == 169) {
                qVar.a = (short) (qVar.a | 64);
                qVar.g = (short) this.R;
                M();
            } else {
                int i4 = this.R + c0[i];
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
        int i6 = this.N;
        if (i6 != 0) {
            int i7 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i7 > this.j) {
                this.j = i7;
            }
        }
        if (i < 54 || i6 != 4 || this.l == null) {
            return;
        }
        o(new q());
    }

    boolean H(e eVar, int i, int i2, boolean z, boolean z2, int i3, int i4, int i6) {
        if (eVar == this.c.S() && i3 == this.g && i4 == this.A) {
            if (z2 == ((this.d & ASTNode.BLOCK_DO_UNTIL) != 0)) {
                if (z != (this.c.R() < 49 && (this.d & 4096) != 0)) {
                    return false;
                }
                if (i6 == 0) {
                    if (this.y != 0) {
                        return false;
                    }
                } else if (eVar.H(i6) == this.y) {
                    int i7 = i6 + 2;
                    for (int i8 = 0; i8 < this.y; i8++) {
                        if (eVar.H(i7) != this.z[i8]) {
                            return false;
                        }
                        i7 += 2;
                    }
                }
                this.a0 = i + 6;
                this.b0 = i2 - 6;
                return true;
            }
        }
        return false;
    }

    final void I(c.a aVar) {
        aVar.b(this.M);
        aVar.b(this.x);
    }

    int L() {
        int i;
        if (this.a0 != 0) {
            return this.b0 + 6;
        }
        int i2 = this.k.b;
        if (i2 <= 0) {
            i = 8;
        } else {
            if (i2 > 65535) {
                throw new MethodTooLargeException(this.c.O(), this.f, this.h, this.k.b);
            }
            this.c.D("Code");
            i = this.k.b + 16 + p.b(this.l) + 8;
            if (this.u != null) {
                this.c.D(this.c.R() >= 50 ? "StackMapTable" : "StackMap");
                i += this.u.b + 8;
            }
            if (this.o != null) {
                this.c.D("LineNumberTable");
                i += this.o.b + 8;
            }
            if (this.q != null) {
                this.c.D("LocalVariableTable");
                i += this.q.b + 8;
            }
            if (this.s != null) {
                this.c.D("LocalVariableTypeTable");
                i += this.s.b + 8;
            }
            b bVar = this.v;
            if (bVar != null) {
                i += bVar.f("RuntimeVisibleTypeAnnotations");
            }
            b bVar2 = this.w;
            if (bVar2 != null) {
                i += bVar2.f("RuntimeInvisibleTypeAnnotations");
            }
            c cVar = this.x;
            if (cVar != null) {
                x xVar = this.c;
                d dVar = this.k;
                i += cVar.b(xVar, dVar.a, dVar.b, this.i, this.j);
            }
        }
        if (this.y > 0) {
            this.c.D("Exceptions");
            i += (this.y * 2) + 8;
        }
        boolean z = this.c.R() < 49;
        if ((this.d & 4096) != 0 && z) {
            this.c.D("Synthetic");
            i += 6;
        }
        if (this.A != 0) {
            this.c.D("Signature");
            i += 8;
        }
        if ((this.d & ASTNode.BLOCK_DO_UNTIL) != 0) {
            this.c.D("Deprecated");
            i += 6;
        }
        b bVar3 = this.B;
        if (bVar3 != null) {
            i += bVar3.f("RuntimeVisibleAnnotations");
        }
        b bVar4 = this.C;
        if (bVar4 != null) {
            i += bVar4.f("RuntimeInvisibleAnnotations");
        }
        b[] bVarArr = this.E;
        if (bVarArr != null) {
            int i3 = this.D;
            if (i3 == 0) {
                i3 = bVarArr.length;
            }
            i += b.g("RuntimeVisibleParameterAnnotations", bVarArr, i3);
        }
        b[] bVarArr2 = this.G;
        if (bVarArr2 != null) {
            int i4 = this.F;
            if (i4 == 0) {
                i4 = bVarArr2.length;
            }
            i += b.g("RuntimeInvisibleParameterAnnotations", bVarArr2, i4);
        }
        b bVar5 = this.H;
        if (bVar5 != null) {
            i += bVar5.f("RuntimeVisibleTypeAnnotations");
        }
        b bVar6 = this.I;
        if (bVar6 != null) {
            i += bVar6.f("RuntimeInvisibleTypeAnnotations");
        }
        if (this.J != null) {
            this.c.D("AnnotationDefault");
            i += this.J.b + 6;
        }
        if (this.L != null) {
            this.c.D("MethodParameters");
            i += this.L.b + 7;
        }
        c cVar2 = this.M;
        return cVar2 != null ? i + cVar2.a(this.c) : i;
    }

    boolean N() {
        return this.Y;
    }

    boolean O() {
        return this.t > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void S(vz.d r23) {
        /*
            Method dump skipped, instructions count: 870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vz.s.S(vz.d):void");
    }

    void T(int i, int i2) {
        this.W[i] = i2;
    }

    void U() {
        if (this.V != null) {
            if (this.u == null) {
                this.u = new d();
            }
            Q();
            this.t++;
        }
        this.V = this.W;
        this.W = null;
    }

    int V(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        int[] iArr = this.W;
        if (iArr == null || iArr.length < i4) {
            this.W = new int[i4];
        }
        int[] iArr2 = this.W;
        iArr2[0] = i;
        iArr2[1] = i2;
        iArr2[2] = i3;
        return 3;
    }

    @Override // vz.r
    public void a(int i, boolean z) {
        if (z) {
            this.D = i;
        } else {
            this.F = i;
        }
    }

    @Override // vz.r
    public a b(String str, boolean z) {
        d dVar = new d();
        dVar.k(this.c.D(str)).k(0);
        if (z) {
            b bVar = new b(this.c, dVar, this.B);
            this.B = bVar;
            return bVar;
        }
        b bVar2 = new b(this.c, dVar, this.C);
        this.C = bVar2;
        return bVar2;
    }

    @Override // vz.r
    public a c() {
        d dVar = new d();
        this.J = dVar;
        return new b(this.c, false, dVar, null);
    }

    @Override // vz.r
    public void d(c cVar) {
        if (cVar.d()) {
            cVar.c = this.x;
            this.x = cVar;
        } else {
            cVar.c = this.M;
            this.M = cVar;
        }
    }

    @Override // vz.r
    public void e() {
    }

    @Override // vz.r
    public void f() {
    }

    @Override // vz.r
    public void g(int i, String str, String str2, String str3) {
        int i2;
        int i3;
        this.Z = this.k.b;
        w j = this.c.j(str, str2, str3);
        this.k.e(i, j.a);
        q qVar = this.Q;
        if (qVar != null) {
            int i4 = this.N;
            if (i4 == 4 || i4 == 3) {
                qVar.j.d(i, 0, j, this.c);
                return;
            }
            char charAt = str3.charAt(0);
            int i6 = -2;
            switch (i) {
                case 178:
                    i2 = this.R + ((charAt == 'D' || charAt == 'J') ? 2 : 1);
                    break;
                case 179:
                    i3 = this.R;
                    if (charAt != 'D' && charAt != 'J') {
                        i6 = -1;
                    }
                    i2 = i3 + i6;
                    break;
                case 180:
                    i2 = this.R + ((charAt == 'D' || charAt == 'J') ? 1 : 0);
                    break;
                default:
                    i3 = this.R;
                    if (charAt == 'D' || charAt == 'J') {
                        i6 = -3;
                    }
                    i2 = i3 + i6;
                    break;
            }
            if (i2 > this.S) {
                this.S = i2;
            }
            this.R = i2;
        }
    }

    @Override // vz.r
    public void h(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        int i6 = this.N;
        if (i6 == 4) {
            return;
        }
        if (i6 == 3) {
            q qVar = this.Q;
            n nVar = qVar.j;
            if (nVar == null) {
                qVar.j = new j(qVar);
                this.Q.j.t(this.c, this.d, this.h, i2);
                this.Q.j.a(this);
            } else {
                if (i == -1) {
                    nVar.s(this.c, i2, objArr, i3, objArr2);
                }
                this.Q.j.a(this);
            }
        } else if (i == -1) {
            if (this.V == null) {
                int c = y.c(this.h) >> 2;
                n nVar2 = new n(new q());
                nVar2.t(this.c, this.d, this.h, c);
                nVar2.a(this);
            }
            this.T = i2;
            int V = V(this.k.b, i2, i3);
            int i7 = 0;
            while (i7 < i2) {
                this.W[V] = n.e(this.c, objArr[i7]);
                i7++;
                V++;
            }
            int i8 = 0;
            while (i8 < i3) {
                this.W[V] = n.e(this.c, objArr2[i8]);
                i8++;
                V++;
            }
            U();
        } else {
            if (this.u == null) {
                this.u = new d();
                i4 = this.k.b;
            } else {
                i4 = (this.k.b - this.U) - 1;
                if (i4 < 0) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i == 0) {
                this.T = i2;
                this.u.g(255).k(i4).k(i2);
                for (int i9 = 0; i9 < i2; i9++) {
                    R(objArr[i9]);
                }
                this.u.k(i3);
                for (int i10 = 0; i10 < i3; i10++) {
                    R(objArr2[i10]);
                }
            } else if (i == 1) {
                this.T += i2;
                this.u.g(i2 + 251).k(i4);
                for (int i11 = 0; i11 < i2; i11++) {
                    R(objArr[i11]);
                }
            } else if (i == 2) {
                this.T -= i2;
                this.u.g(251 - i2).k(i4);
            } else if (i != 3) {
                if (i != 4) {
                    throw new IllegalArgumentException();
                }
                if (i4 < 64) {
                    this.u.g(i4 + 64);
                } else {
                    this.u.g(247).k(i4);
                }
                R(objArr2[0]);
            } else if (i4 < 64) {
                this.u.g(i4);
            } else {
                this.u.g(251).k(i4);
            }
            this.U = this.k.b;
            this.t++;
        }
        if (this.N == 2) {
            this.R = i3;
            for (int i12 = 0; i12 < i3; i12++) {
                Object obj = objArr2[i12];
                if (obj == v.e || obj == v.d) {
                    this.R++;
                }
            }
            int i13 = this.R;
            if (i13 > this.S) {
                this.S = i13;
            }
        }
        this.i = Math.max(this.i, i3);
        this.j = Math.max(this.j, this.T);
    }

    @Override // vz.r
    public void i(int i, int i2) {
        int i3;
        int i4;
        d dVar = this.k;
        this.Z = dVar.b;
        if (i > 255 || i2 > 127 || i2 < -128) {
            dVar.g(196).e(132, i).k(i2);
        } else {
            dVar.g(132).c(i, i2);
        }
        q qVar = this.Q;
        if (qVar != null && ((i4 = this.N) == 4 || i4 == 3)) {
            qVar.j.d(132, i, null, null);
        }
        if (this.N == 0 || (i3 = i + 1) <= this.j) {
            return;
        }
        this.j = i3;
    }

    @Override // vz.r
    public void j(int i) {
        d dVar = this.k;
        this.Z = dVar.b;
        dVar.g(i);
        q qVar = this.Q;
        if (qVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                qVar.j.d(i, 0, null, null);
            } else {
                int i3 = this.R + c0[i];
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
            if ((i < 172 || i > 177) && i != 191) {
                return;
            }
            M();
        }
    }

    @Override // vz.r
    public a k(int i, z zVar, String str, boolean z) {
        d dVar = new d();
        a0.a((i & (-16776961)) | (this.Z << 8), dVar);
        z.d(zVar, dVar);
        dVar.k(this.c.D(str)).k(0);
        if (z) {
            b bVar = new b(this.c, dVar, this.v);
            this.v = bVar;
            return bVar;
        }
        b bVar2 = new b(this.c, dVar, this.w);
        this.w = bVar2;
        return bVar2;
    }

    @Override // vz.r
    public void l(int i, int i2) {
        d dVar = this.k;
        this.Z = dVar.b;
        if (i == 17) {
            dVar.e(i, i2);
        } else {
            dVar.c(i, i2);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                qVar.j.d(i, i2, null, null);
            } else if (i != 188) {
                int i4 = this.R + 1;
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
    }

    @Override // vz.r
    public void m(String str, String str2, o oVar, Object... objArr) {
        this.Z = this.k.b;
        w o = this.c.o(str, str2, oVar, objArr);
        this.k.e(186, o.a);
        this.k.k(0);
        q qVar = this.Q;
        if (qVar != null) {
            int i = this.N;
            if (i == 4 || i == 3) {
                qVar.j.d(186, 0, o, this.c);
                return;
            }
            int a = o.a();
            int i2 = this.R + ((a & 3) - (a >> 2)) + 1;
            if (i2 > this.S) {
                this.S = i2;
            }
            this.R = i2;
        }
    }

    @Override // vz.r
    public void n(int i, q qVar) {
        boolean z;
        d dVar = this.k;
        int i2 = dVar.b;
        this.Z = i2;
        int i3 = i >= 200 ? i - 33 : i;
        if ((qVar.a & 4) == 0 || qVar.d - i2 >= -32768) {
            if (i3 != i) {
                dVar.g(i);
                d dVar2 = this.k;
                qVar.h(dVar2, dVar2.b - 1, true);
            } else {
                dVar.g(i3);
                d dVar3 = this.k;
                qVar.h(dVar3, dVar3.b - 1, false);
            }
            z = false;
        } else {
            if (i3 == 167) {
                dVar.g(200);
            } else if (i3 == 168) {
                dVar.g(201);
            } else {
                dVar.g(i3 >= 198 ? i3 ^ 1 : ((i3 + 1) ^ 1) - 1);
                this.k.k(8);
                this.k.g(220);
                this.Y = true;
                z = true;
                d dVar4 = this.k;
                qVar.h(dVar4, dVar4.b - 1, true);
            }
            z = false;
            d dVar42 = this.k;
            qVar.h(dVar42, dVar42.b - 1, true);
        }
        q qVar2 = this.Q;
        if (qVar2 != null) {
            int i4 = this.N;
            q qVar3 = null;
            if (i4 == 4) {
                qVar2.j.d(i3, 0, null, null);
                q e = qVar.e();
                e.a = (short) (e.a | 2);
                G(0, qVar);
                if (i3 != 167) {
                    qVar3 = new q();
                }
            } else if (i4 == 3) {
                qVar2.j.d(i3, 0, null, null);
            } else if (i4 == 2) {
                this.R += c0[i3];
            } else if (i3 == 168) {
                short s = qVar.a;
                if ((s & 32) == 0) {
                    qVar.a = (short) (s | 32);
                    this.X = true;
                }
                qVar2.a = (short) (qVar2.a | 16);
                G(this.R + 1, qVar);
                qVar3 = new q();
            } else {
                int i6 = this.R + c0[i3];
                this.R = i6;
                G(i6, qVar);
            }
            if (qVar3 != null) {
                if (z) {
                    qVar3.a = (short) (qVar3.a | 2);
                }
                o(qVar3);
            }
            if (i3 == 167) {
                M();
            }
        }
    }

    @Override // vz.r
    public void o(q qVar) {
        boolean z = this.Y;
        d dVar = this.k;
        this.Y = z | qVar.i(dVar.a, dVar.b);
        short s = qVar.a;
        if ((s & 1) != 0) {
            return;
        }
        int i = this.N;
        if (i == 4) {
            q qVar2 = this.Q;
            if (qVar2 != null) {
                if (qVar.d == qVar2.d) {
                    qVar2.a = (short) ((s & 2) | qVar2.a);
                    qVar.j = qVar2.j;
                    return;
                }
                G(0, qVar);
            }
            q qVar3 = this.P;
            if (qVar3 != null) {
                if (qVar.d == qVar3.d) {
                    qVar3.a = (short) (qVar3.a | (qVar.a & 2));
                    qVar.j = qVar3.j;
                    this.Q = qVar3;
                    return;
                }
                qVar3.k = qVar;
            }
            this.P = qVar;
            this.Q = qVar;
            qVar.j = new n(qVar);
            return;
        }
        if (i == 3) {
            q qVar4 = this.Q;
            if (qVar4 == null) {
                this.Q = qVar;
                return;
            } else {
                qVar4.j.a = qVar;
                return;
            }
        }
        if (i != 1) {
            if (i == 2 && this.Q == null) {
                this.Q = qVar;
                return;
            }
            return;
        }
        q qVar5 = this.Q;
        if (qVar5 != null) {
            qVar5.h = (short) this.S;
            G(this.R, qVar);
        }
        this.Q = qVar;
        this.R = 0;
        this.S = 0;
        q qVar6 = this.P;
        if (qVar6 != null) {
            qVar6.k = qVar;
        }
        this.P = qVar;
    }

    @Override // vz.r
    public void p(Object obj) {
        char charAt;
        this.Z = this.k.b;
        w d = this.c.d(obj);
        int i = d.a;
        int i2 = d.b;
        boolean z = i2 == 5 || i2 == 6 || (i2 == 17 && ((charAt = d.e.charAt(0)) == 'J' || charAt == 'D'));
        if (z) {
            this.k.e(20, i);
        } else if (i >= 256) {
            this.k.e(19, i);
        } else {
            this.k.c(18, i);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                qVar.j.d(18, 0, d, this.c);
                return;
            }
            int i4 = this.R + (z ? 2 : 1);
            if (i4 > this.S) {
                this.S = i4;
            }
            this.R = i4;
        }
    }

    @Override // vz.r
    public void q(int i, q qVar) {
        if (this.o == null) {
            this.o = new d();
        }
        this.n++;
        this.o.k(qVar.d);
        this.o.k(i);
    }

    @Override // vz.r
    public void r(String str, String str2, String str3, q qVar, q qVar2, int i) {
        if (str3 != null) {
            if (this.s == null) {
                this.s = new d();
            }
            this.r++;
            this.s.k(qVar.d).k(qVar2.d - qVar.d).k(this.c.D(str)).k(this.c.D(str3)).k(i);
        }
        if (this.q == null) {
            this.q = new d();
        }
        this.p++;
        this.q.k(qVar.d).k(qVar2.d - qVar.d).k(this.c.D(str)).k(this.c.D(str2)).k(i);
        if (this.N != 0) {
            char charAt = str2.charAt(0);
            int i2 = i + ((charAt == 'J' || charAt == 'D') ? 2 : 1);
            if (i2 > this.j) {
                this.j = i2;
            }
        }
    }

    @Override // vz.r
    public a s(int i, z zVar, q[] qVarArr, q[] qVarArr2, int[] iArr, String str, boolean z) {
        d dVar = new d();
        dVar.g(i >>> 24).k(qVarArr.length);
        for (int i2 = 0; i2 < qVarArr.length; i2++) {
            dVar.k(qVarArr[i2].d).k(qVarArr2[i2].d - qVarArr[i2].d).k(iArr[i2]);
        }
        z.d(zVar, dVar);
        dVar.k(this.c.D(str)).k(0);
        if (z) {
            b bVar = new b(this.c, dVar, this.v);
            this.v = bVar;
            return bVar;
        }
        b bVar2 = new b(this.c, dVar, this.w);
        this.w = bVar2;
        return bVar2;
    }

    @Override // vz.r
    public void t(q qVar, int[] iArr, q[] qVarArr) {
        d dVar = this.k;
        this.Z = dVar.b;
        dVar.g(171).h(null, 0, (4 - (this.k.b % 4)) % 4);
        qVar.h(this.k, this.Z, true);
        this.k.i(qVarArr.length);
        for (int i = 0; i < qVarArr.length; i++) {
            this.k.i(iArr[i]);
            qVarArr[i].h(this.k, this.Z, true);
        }
        W(qVar, qVarArr);
    }

    @Override // vz.r
    public void u(int i, int i2) {
        int i3 = this.N;
        if (i3 == 4) {
            J();
            return;
        }
        if (i3 == 1) {
            K();
        } else if (i3 == 2) {
            this.i = this.S;
        } else {
            this.i = i;
            this.j = i2;
        }
    }

    @Override // vz.r
    public void w(int i, String str, String str2, String str3, boolean z) {
        this.Z = this.k.b;
        w x = this.c.x(str, str2, str3, z);
        if (i == 185) {
            this.k.e(185, x.a).c(x.a() >> 2, 0);
        } else {
            this.k.e(i, x.a);
        }
        q qVar = this.Q;
        if (qVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                qVar.j.d(i, 0, x, this.c);
                return;
            }
            int a = x.a();
            int i3 = (a & 3) - (a >> 2);
            int i4 = i == 184 ? this.R + i3 + 1 : this.R + i3;
            if (i4 > this.S) {
                this.S = i4;
            }
            this.R = i4;
        }
    }

    @Override // vz.r
    public void x(String str, int i) {
        this.Z = this.k.b;
        w e = this.c.e(str);
        this.k.e(197, e.a).g(i);
        q qVar = this.Q;
        if (qVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                qVar.j.d(197, i, e, this.c);
            } else {
                this.R += 1 - i;
            }
        }
    }

    @Override // vz.r
    public void y(String str, int i) {
        if (this.L == null) {
            this.L = new d();
        }
        this.K++;
        this.L.k(str == null ? 0 : this.c.D(str)).k(i);
    }

    @Override // vz.r
    public a z(int i, String str, boolean z) {
        d dVar = new d();
        dVar.k(this.c.D(str)).k(0);
        if (z) {
            if (this.E == null) {
                this.E = new b[y.b(this.h).length];
            }
            b[] bVarArr = this.E;
            b bVar = new b(this.c, dVar, bVarArr[i]);
            bVarArr[i] = bVar;
            return bVar;
        }
        if (this.G == null) {
            this.G = new b[y.b(this.h).length];
        }
        b[] bVarArr2 = this.G;
        b bVar2 = new b(this.c, dVar, bVarArr2[i]);
        bVarArr2[i] = bVar2;
        return bVar2;
    }
}
