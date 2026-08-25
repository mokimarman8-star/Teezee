package vz;

import com.transsion.baselib.report.recent_event.ActionEvent;
import org.mvel2.ast.ASTNode;
import org.mvel2.optimizers.OptimizationNotSupported;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class x {
    final g a;
    private final e b;
    private int c;
    private String d;
    private int e;
    private a[] f;
    private int g;
    private d h;
    private int i;
    private d j;
    private int k;
    private a[] l;

    private static class a extends w {
        final int h;
        a i;

        a(int i, int i2, long j, int i3) {
            super(i, i2, null, null, null, j);
            this.h = i3;
        }

        a(int i, int i2, String str, int i3) {
            super(i, i2, null, null, str, 0L);
            this.h = i3;
        }

        a(int i, int i2, String str, long j, int i3) {
            super(i, i2, null, null, str, j);
            this.h = i3;
        }

        a(int i, int i2, String str, String str2, int i3) {
            super(i, i2, null, str, str2, 0L);
            this.h = i3;
        }

        a(int i, int i2, String str, String str2, String str3, long j, int i3) {
            super(i, i2, str, str2, str3, j);
            this.h = i3;
        }
    }

    x(g gVar) {
        this.a = gVar;
        this.b = null;
        this.f = new a[ASTNode.COLLECTION];
        this.g = 1;
        this.h = new d();
    }

    x(g gVar, e eVar) {
        this.a = gVar;
        this.b = eVar;
        byte[] bArr = eVar.a;
        int f = eVar.f(1) - 1;
        int i = eVar.g - f;
        this.g = eVar.g();
        d dVar = new d(i);
        this.h = dVar;
        dVar.h(bArr, f, i);
        this.f = new a[this.g * 2];
        char[] cArr = new char[eVar.h()];
        boolean z = false;
        int i2 = 1;
        while (i2 < this.g) {
            int f2 = eVar.f(i2);
            byte b = bArr[f2 - 1];
            switch (b) {
                case 1:
                    E(i2, eVar.J(i2, cArr));
                    break;
                case 2:
                case 13:
                case ActionEvent.delete_comment /* 14 */:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                    n(i2, b, eVar.t(f2));
                    break;
                case 5:
                case 6:
                    r(i2, b, eVar.v(f2));
                    break;
                case 7:
                case 8:
                case 16:
                case ActionEvent.search_cover_expose /* 19 */:
                case ActionEvent.search_cover_click /* 20 */:
                    G(i2, b, eVar.G(f2, cArr));
                    break;
                case 9:
                case 10:
                case 11:
                    int f3 = eVar.f(eVar.H(f2 + 2));
                    t(i2, b, eVar.m(f2, cArr), eVar.G(f3, cArr), eVar.G(f3 + 2, cArr));
                    break;
                case 12:
                    A(i2, eVar.G(f2, cArr), eVar.G(f2 + 2, cArr));
                    break;
                case ActionEvent.pageview /* 15 */:
                    int f4 = eVar.f(eVar.H(f2 + 1));
                    int f5 = eVar.f(eVar.H(f4 + 2));
                    v(i2, eVar.l(f2), eVar.m(f4, cArr), eVar.G(f5, cArr), eVar.G(f5 + 2, cArr));
                    break;
                case ActionEvent.want_to_see_cancel /* 17 */:
                case 18:
                    int f6 = eVar.f(eVar.H(f2 + 2));
                    i(b, i2, eVar.G(f6, cArr), eVar.G(f6 + 2, cArr), eVar.H(f2));
                    z = true;
                    break;
            }
            i2 += (b == 5 || b == 6) ? 2 : 1;
        }
        if (z) {
            M(eVar, cArr);
        }
    }

    private void A(int i, String str, String str2) {
        a(new a(i, 12, str, str2, Y(12, str, str2)));
    }

    private void E(int i, String str) {
        a(new a(i, 1, str, W(1, str)));
    }

    private w F(int i, String str) {
        int W = W(i, str);
        for (a N = N(W); N != null; N = N.i) {
            if (N.b == i && N.h == W && N.e.equals(str)) {
                return N;
            }
        }
        this.h.e(i, D(str));
        int i2 = this.g;
        this.g = i2 + 1;
        return c0(new a(i2, i, str, W));
    }

    private void G(int i, int i2, String str) {
        a(new a(i, i2, str, W(i2, str)));
    }

    private int J(a aVar) {
        if (this.l == null) {
            this.l = new a[16];
        }
        int i = this.k;
        a[] aVarArr = this.l;
        if (i == aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length * 2];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            this.l = aVarArr2;
        }
        a[] aVarArr3 = this.l;
        int i2 = this.k;
        this.k = i2 + 1;
        aVarArr3[i2] = aVar;
        return c0(aVar).a;
    }

    private void M(e eVar, char[] cArr) {
        byte[] bArr = eVar.a;
        int e = eVar.e();
        int H = eVar.H(e - 2);
        while (true) {
            if (H <= 0) {
                break;
            }
            if ("BootstrapMethods".equals(eVar.G(e, cArr))) {
                this.i = eVar.H(e + 6);
                break;
            } else {
                e += eVar.t(e + 2) + 6;
                H--;
            }
        }
        if (this.i > 0) {
            int i = e + 8;
            int t = eVar.t(e + 2) - 2;
            d dVar = new d(t);
            this.j = dVar;
            dVar.h(bArr, i, t);
            int i2 = i;
            for (int i3 = 0; i3 < this.i; i3++) {
                int i4 = i2 - i;
                int H2 = eVar.H(i2);
                int H3 = eVar.H(i2 + 2);
                i2 += 4;
                int hashCode = eVar.o(H2, cArr).hashCode();
                while (true) {
                    int i6 = H3 - 1;
                    if (H3 > 0) {
                        int H4 = eVar.H(i2);
                        i2 += 2;
                        hashCode ^= eVar.o(H4, cArr).hashCode();
                        H3 = i6;
                    }
                }
                a(new a(i3, 64, i4, hashCode & Integer.MAX_VALUE));
            }
        }
    }

    private a N(int i) {
        a[] aVarArr = this.f;
        return aVarArr[i % aVarArr.length];
    }

    private static int U(int i, int i2) {
        return (i + i2) & Integer.MAX_VALUE;
    }

    private static int V(int i, long j) {
        return (i + ((int) j) + ((int) (j >>> 32))) & Integer.MAX_VALUE;
    }

    private static int W(int i, String str) {
        return (i + str.hashCode()) & Integer.MAX_VALUE;
    }

    private static int X(int i, String str, int i2) {
        return (i + str.hashCode() + i2) & Integer.MAX_VALUE;
    }

    private static int Y(int i, String str, String str2) {
        return (i + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
    }

    private static int Z(int i, String str, String str2, int i2) {
        return (i + (str.hashCode() * str2.hashCode() * (i2 + 1))) & Integer.MAX_VALUE;
    }

    private void a(a aVar) {
        this.e++;
        int i = aVar.h;
        a[] aVarArr = this.f;
        int length = i % aVarArr.length;
        aVar.i = aVarArr[length];
        aVarArr[length] = aVar;
    }

    private static int a0(int i, String str, String str2, String str3) {
        return (i + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
    }

    private w b(int i, int i2, int i3) {
        byte[] bArr = this.j.a;
        for (a N = N(i3); N != null; N = N.i) {
            if (N.b == 64 && N.h == i3) {
                int i4 = (int) N.f;
                for (int i6 = 0; i6 < i2; i6++) {
                    if (bArr[i + i6] != bArr[i4 + i6]) {
                        break;
                    }
                }
                this.j.b = i;
                return N;
            }
        }
        int i7 = this.i;
        this.i = i7 + 1;
        return c0(new a(i7, 64, i, i3));
    }

    private static int b0(int i, String str, String str2, String str3, int i2) {
        return (i + (str.hashCode() * str2.hashCode() * str3.hashCode() * i2)) & Integer.MAX_VALUE;
    }

    private a c0(a aVar) {
        int i = this.e;
        a[] aVarArr = this.f;
        if (i > (aVarArr.length * 3) / 4) {
            int length = aVarArr.length;
            int i2 = (length * 2) + 1;
            a[] aVarArr2 = new a[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                a aVar2 = this.f[i3];
                while (aVar2 != null) {
                    int i4 = aVar2.h % i2;
                    a aVar3 = aVar2.i;
                    aVar2.i = aVarArr2[i4];
                    aVarArr2[i4] = aVar2;
                    aVar2 = aVar3;
                }
            }
            this.f = aVarArr2;
        }
        this.e++;
        int i6 = aVar.h;
        a[] aVarArr3 = this.f;
        int length2 = i6 % aVarArr3.length;
        aVar.i = aVarArr3[length2];
        aVarArr3[length2] = aVar;
        return aVar;
    }

    private w h(int i, String str, String str2, int i2) {
        int Z = Z(i, str, str2, i2);
        for (a N = N(Z); N != null; N = N.i) {
            if (N.b == i && N.h == Z && N.f == i2 && N.d.equals(str) && N.e.equals(str2)) {
                return N;
            }
        }
        this.h.f(i, i2, z(str, str2));
        int i3 = this.g;
        this.g = i3 + 1;
        return c0(new a(i3, i, null, str, str2, i2, Z));
    }

    private void i(int i, int i2, String str, String str2, int i3) {
        a(new a(i2, i, null, str, str2, i3, Z(i, str, str2, i3)));
    }

    private w m(int i, int i2) {
        int U = U(i, i2);
        for (a N = N(U); N != null; N = N.i) {
            if (N.b == i && N.h == U && N.f == i2) {
                return N;
            }
        }
        this.h.g(i).i(i2);
        int i3 = this.g;
        this.g = i3 + 1;
        return c0(new a(i3, i, i2, U));
    }

    private void n(int i, int i2, int i3) {
        a(new a(i, i2, i3, U(i2, i3)));
    }

    private w q(int i, long j) {
        int V = V(i, j);
        for (a N = N(V); N != null; N = N.i) {
            if (N.b == i && N.h == V && N.f == j) {
                return N;
            }
        }
        int i2 = this.g;
        this.h.g(i).j(j);
        this.g += 2;
        return c0(new a(i2, i, j, V));
    }

    private void r(int i, int i2, long j) {
        a(new a(i, i2, j, V(i2, j)));
    }

    private a s(int i, String str, String str2, String str3) {
        int a0 = a0(i, str, str2, str3);
        for (a N = N(a0); N != null; N = N.i) {
            if (N.b == i && N.h == a0 && N.c.equals(str) && N.d.equals(str2) && N.e.equals(str3)) {
                return N;
            }
        }
        this.h.f(i, e(str).a, z(str2, str3));
        int i2 = this.g;
        this.g = i2 + 1;
        return c0(new a(i2, i, str, str2, str3, 0L, a0));
    }

    private void t(int i, int i2, String str, String str2, String str3) {
        a(new a(i, i2, str, str2, str3, 0L, a0(i2, str, str2, str3)));
    }

    private void v(int i, int i2, String str, String str2, String str3) {
        a(new a(i, 15, str, str2, str3, i2, b0(15, str, str2, str3, i2)));
    }

    w B(String str) {
        return F(20, str);
    }

    w C(String str) {
        return F(8, str);
    }

    int D(String str) {
        int W = W(1, str);
        for (a N = N(W); N != null; N = N.i) {
            if (N.b == 1 && N.h == W && N.e.equals(str)) {
                return N.a;
            }
        }
        this.h.g(1).l(str);
        int i = this.g;
        this.g = i + 1;
        return c0(new a(i, 1, str, W)).a;
    }

    int H(int i, int i2) {
        long j = i | (i2 << 32);
        int U = U(130, i + i2);
        for (a N = N(U); N != null; N = N.i) {
            if (N.b == 130 && N.h == U && N.f == j) {
                return N.g;
            }
        }
        a[] aVarArr = this.l;
        int I = I(this.a.p(aVarArr[i].e, aVarArr[i2].e));
        c0(new a(this.k, 130, j, U)).g = I;
        return I;
    }

    int I(String str) {
        int W = W(ASTNode.ASSIGN, str);
        for (a N = N(W); N != null; N = N.i) {
            if (N.b == 128 && N.h == W && N.e.equals(str)) {
                return N.a;
            }
        }
        return J(new a(this.k, ASTNode.ASSIGN, str, W));
    }

    int K(String str, int i) {
        int X = X(129, str, i);
        for (a N = N(X); N != null; N = N.i) {
            if (N.b == 129 && N.h == X && N.f == i && N.e.equals(str)) {
                return N.a;
            }
        }
        return J(new a(this.k, 129, str, i, X));
    }

    int L() {
        if (this.j == null) {
            return 0;
        }
        D("BootstrapMethods");
        return this.j.b + 8;
    }

    String O() {
        return this.d;
    }

    int P() {
        return this.g;
    }

    int Q() {
        return this.h.b;
    }

    int R() {
        return this.c;
    }

    e S() {
        return this.b;
    }

    w T(int i) {
        return this.l[i];
    }

    w c(o oVar, Object... objArr) {
        d dVar = this.j;
        if (dVar == null) {
            dVar = new d();
            this.j = dVar;
        }
        for (Object obj : objArr) {
            d(obj);
        }
        int i = dVar.b;
        dVar.k(u(oVar.d(), oVar.c(), oVar.b(), oVar.a(), oVar.e()).a);
        dVar.k(objArr.length);
        for (Object obj2 : objArr) {
            dVar.k(d(obj2).a);
        }
        int i2 = dVar.b - i;
        int hashCode = oVar.hashCode();
        for (Object obj3 : objArr) {
            hashCode ^= obj3.hashCode();
        }
        return b(i, i2, hashCode & Integer.MAX_VALUE);
    }

    w d(Object obj) {
        if (obj instanceof Integer) {
            return l(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return l(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return l(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return l(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return l(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return k(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return p(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return f(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return C((String) obj);
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            int l = yVar.l();
            return l == 10 ? e(yVar.g()) : l == 11 ? w(yVar.e()) : e(yVar.e());
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return u(oVar.d(), oVar.c(), oVar.b(), oVar.a(), oVar.e());
        }
        if (!(obj instanceof h)) {
            throw new OptimizationNotSupported();
        }
        h hVar = (h) obj;
        return g(hVar.d(), hVar.c(), hVar.a(), hVar.b());
    }

    void d0(d dVar) {
        if (this.j != null) {
            d k = dVar.k(D("BootstrapMethods")).i(this.j.b + 2).k(this.i);
            d dVar2 = this.j;
            k.h(dVar2.a, 0, dVar2.b);
        }
    }

    w e(String str) {
        return F(7, str);
    }

    void e0(d dVar) {
        d k = dVar.k(this.g);
        d dVar2 = this.h;
        k.h(dVar2.a, 0, dVar2.b);
    }

    w f(double d) {
        return q(6, Double.doubleToRawLongBits(d));
    }

    int f0(int i, String str) {
        this.c = i;
        this.d = str;
        return e(str).a;
    }

    w g(String str, String str2, o oVar, Object... objArr) {
        return h(17, str, str2, c(oVar, objArr).a);
    }

    w j(String str, String str2, String str3) {
        return s(9, str, str2, str3);
    }

    w k(float f) {
        return m(4, Float.floatToRawIntBits(f));
    }

    w l(int i) {
        return m(3, i);
    }

    w o(String str, String str2, o oVar, Object... objArr) {
        return h(18, str, str2, c(oVar, objArr).a);
    }

    w p(long j) {
        return q(5, j);
    }

    w u(int i, String str, String str2, String str3, boolean z) {
        int b0 = b0(15, str, str2, str3, i);
        for (a N = N(b0); N != null; N = N.i) {
            if (N.b == 15 && N.h == b0 && N.f == i && N.c.equals(str) && N.d.equals(str2) && N.e.equals(str3)) {
                return N;
            }
        }
        if (i <= 4) {
            this.h.d(15, i, j(str, str2, str3).a);
        } else {
            this.h.d(15, i, x(str, str2, str3, z).a);
        }
        int i2 = this.g;
        this.g = i2 + 1;
        return c0(new a(i2, 15, str, str2, str3, i, b0));
    }

    w w(String str) {
        return F(16, str);
    }

    w x(String str, String str2, String str3, boolean z) {
        return s(z ? 11 : 10, str, str2, str3);
    }

    w y(String str) {
        return F(19, str);
    }

    int z(String str, String str2) {
        int Y = Y(12, str, str2);
        for (a N = N(Y); N != null; N = N.i) {
            if (N.b == 12 && N.h == Y && N.d.equals(str) && N.e.equals(str2)) {
                return N.a;
            }
        }
        this.h.f(12, D(str), D(str2));
        int i = this.g;
        this.g = i + 1;
        return c0(new a(i, 12, str, str2, Y)).a;
    }
}
