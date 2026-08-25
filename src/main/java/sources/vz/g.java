package vz;

import org.mvel2.asm.ClassTooLargeException;
import org.mvel2.ast.ASTNode;
import vz.c;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class g extends f {
    private int A;
    private d B;
    private c C;
    private int D;
    private int c;
    private final x d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int[] i;
    private m j;
    private m k;
    private s l;
    private s m;
    private int n;
    private d o;
    private int p;
    private int q;
    private int r;
    private int s;
    private d t;
    private b u;
    private b v;
    private b w;
    private b x;
    private u y;
    private int z;

    public g(int i) {
        this(null, i);
    }

    public g(e eVar, int i) {
        super(458752);
        this.d = eVar == null ? new x(this) : new x(this, eVar);
        if ((i & 2) != 0) {
            this.D = 4;
        } else if ((i & 1) != 0) {
            this.D = 1;
        } else {
            this.D = 0;
        }
    }

    private c[] n() {
        c.a aVar = new c.a();
        aVar.b(this.C);
        for (m mVar = this.j; mVar != null; mVar = (m) mVar.b) {
            mVar.e(aVar);
        }
        for (s sVar = this.l; sVar != null; sVar = (s) sVar.b) {
            sVar.I(aVar);
        }
        return aVar.d();
    }

    private byte[] q(byte[] bArr, boolean z) {
        c[] n = n();
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = 0;
        this.A = 0;
        this.B = null;
        this.C = null;
        this.D = z ? 3 : 0;
        new e(bArr, 0, false).a(this, n, (z ? 8 : 0) | ASTNode.COLLECTION);
        return r();
    }

    @Override // vz.f
    public final void a(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.c = i;
        this.e = i2;
        int i3 = i & 65535;
        this.f = this.d.f0(i3, str);
        if (str2 != null) {
            this.r = this.d.D(str2);
        }
        this.g = str3 == null ? 0 : this.d.e(str3).a;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.h = length;
            this.i = new int[length];
            for (int i4 = 0; i4 < this.h; i4++) {
                this.i[i4] = this.d.e(strArr[i4]).a;
            }
        }
        if (this.D != 1 || i3 < 51) {
            return;
        }
        this.D = 2;
    }

    @Override // vz.f
    public final a b(String str, boolean z) {
        d dVar = new d();
        dVar.k(this.d.D(str)).k(0);
        if (z) {
            b bVar = new b(this.d, dVar, this.u);
            this.u = bVar;
            return bVar;
        }
        b bVar2 = new b(this.d, dVar, this.v);
        this.v = bVar2;
        return bVar2;
    }

    @Override // vz.f
    public final void c(c cVar) {
        cVar.c = this.C;
        this.C = cVar;
    }

    @Override // vz.f
    public final void d() {
    }

    @Override // vz.f
    public final l e(int i, String str, String str2, String str3, Object obj) {
        m mVar = new m(this.d, i, str, str2, str3, obj);
        if (this.j == null) {
            this.j = mVar;
        } else {
            this.k.b = mVar;
        }
        this.k = mVar;
        return mVar;
    }

    @Override // vz.f
    public final void f(String str, String str2, String str3, int i) {
        if (this.o == null) {
            this.o = new d();
        }
        w e = this.d.e(str);
        if (e.g == 0) {
            this.n++;
            this.o.k(e.a);
            this.o.k(str2 == null ? 0 : this.d.e(str2).a);
            this.o.k(str3 != null ? this.d.D(str3) : 0);
            this.o.k(i);
            e.g = this.n;
        }
    }

    @Override // vz.f
    public final r g(int i, String str, String str2, String str3, String[] strArr) {
        s sVar = new s(this.d, i, str, str2, str3, strArr, this.D);
        if (this.l == null) {
            this.l = sVar;
        } else {
            this.m.b = sVar;
        }
        this.m = sVar;
        return sVar;
    }

    @Override // vz.f
    public final t h(String str, int i, String str2) {
        x xVar = this.d;
        u uVar = new u(xVar, xVar.y(str).a, i, str2 == null ? 0 : this.d.D(str2));
        this.y = uVar;
        return uVar;
    }

    @Override // vz.f
    public void i(String str) {
        this.z = this.d.e(str).a;
    }

    @Override // vz.f
    public void j(String str) {
        if (this.B == null) {
            this.B = new d();
        }
        this.A++;
        this.B.k(this.d.e(str).a);
    }

    @Override // vz.f
    public final void k(String str, String str2, String str3) {
        this.p = this.d.e(str).a;
        if (str2 == null || str3 == null) {
            return;
        }
        this.q = this.d.z(str2, str3);
    }

    @Override // vz.f
    public final void l(String str, String str2) {
        if (str != null) {
            this.s = this.d.D(str);
        }
        if (str2 != null) {
            this.t = new d().a(str2, 0, Integer.MAX_VALUE);
        }
    }

    @Override // vz.f
    public final a m(int i, z zVar, String str, boolean z) {
        d dVar = new d();
        a0.a(i, dVar);
        z.d(zVar, dVar);
        dVar.k(this.d.D(str)).k(0);
        if (z) {
            b bVar = new b(this.d, dVar, this.w);
            this.w = bVar;
            return bVar;
        }
        b bVar2 = new b(this.d, dVar, this.x);
        this.x = bVar2;
        return bVar2;
    }

    protected ClassLoader o() {
        return getClass().getClassLoader();
    }

    protected String p(String str, String str2) {
        ClassLoader o = o();
        try {
            Class<?> cls = Class.forName(str.replace('/', '.'), false, o);
            try {
                Class<?> cls2 = Class.forName(str2.replace('/', '.'), false, o);
                if (cls.isAssignableFrom(cls2)) {
                    return str;
                }
                if (cls2.isAssignableFrom(cls)) {
                    return str2;
                }
                if (cls.isInterface() || cls2.isInterface()) {
                    return "java/lang/Object";
                }
                do {
                    cls = cls.getSuperclass();
                } while (!cls.isAssignableFrom(cls2));
                return cls.getName().replace('.', '/');
            } catch (ClassNotFoundException e) {
                throw new TypeNotPresentException(str2, e);
            }
        } catch (ClassNotFoundException e3) {
            throw new TypeNotPresentException(str, e3);
        }
    }

    public byte[] r() {
        int i;
        int i2;
        int i3;
        int i4 = (this.h * 2) + 24;
        int i6 = 0;
        for (m mVar = this.j; mVar != null; mVar = (m) mVar.b) {
            i6++;
            i4 += mVar.f();
        }
        int i7 = 0;
        for (s sVar = this.l; sVar != null; sVar = (s) sVar.b) {
            i7++;
            i4 += sVar.L();
        }
        d dVar = this.o;
        if (dVar != null) {
            i4 += dVar.b + 8;
            this.d.D("InnerClasses");
            i = 1;
        } else {
            i = 0;
        }
        if (this.p != 0) {
            i++;
            i4 += 10;
            this.d.D("EnclosingMethod");
        }
        if ((this.e & 4096) != 0 && (this.c & 65535) < 49) {
            i++;
            i4 += 6;
            this.d.D("Synthetic");
        }
        if (this.r != 0) {
            i++;
            i4 += 8;
            this.d.D("Signature");
        }
        if (this.s != 0) {
            i++;
            i4 += 8;
            this.d.D("SourceFile");
        }
        d dVar2 = this.t;
        if (dVar2 != null) {
            i++;
            i4 += dVar2.b + 6;
            this.d.D("SourceDebugExtension");
        }
        if ((this.e & ASTNode.BLOCK_DO_UNTIL) != 0) {
            i++;
            i4 += 6;
            this.d.D("Deprecated");
        }
        b bVar = this.u;
        if (bVar != null) {
            i++;
            i4 += bVar.f("RuntimeVisibleAnnotations");
        }
        b bVar2 = this.v;
        if (bVar2 != null) {
            i++;
            i4 += bVar2.f("RuntimeInvisibleAnnotations");
        }
        b bVar3 = this.w;
        if (bVar3 != null) {
            i++;
            i4 += bVar3.f("RuntimeVisibleTypeAnnotations");
        }
        b bVar4 = this.x;
        if (bVar4 != null) {
            i++;
            i4 += bVar4.f("RuntimeInvisibleTypeAnnotations");
        }
        if (this.d.L() > 0) {
            i++;
            i4 += this.d.L();
        }
        u uVar = this.y;
        if (uVar != null) {
            i += uVar.j();
            i4 += this.y.i();
        }
        if (this.z != 0) {
            i++;
            i4 += 8;
            this.d.D("NestHost");
        }
        d dVar3 = this.B;
        if (dVar3 != null) {
            i++;
            i4 += dVar3.b + 8;
            this.d.D("NestMembers");
        }
        c cVar = this.C;
        if (cVar != null) {
            int c = i + cVar.c();
            i4 += this.C.a(this.d);
            i = c;
        }
        int Q = i4 + this.d.Q();
        int P = this.d.P();
        if (P > 65535) {
            throw new ClassTooLargeException(this.d.O(), P);
        }
        d dVar4 = new d(Q);
        dVar4.i(-889275714).i(this.c);
        this.d.e0(dVar4);
        dVar4.k((~((this.c & 65535) < 49 ? 4096 : 0)) & this.e).k(this.f).k(this.g);
        dVar4.k(this.h);
        for (int i8 = 0; i8 < this.h; i8++) {
            dVar4.k(this.i[i8]);
        }
        dVar4.k(i6);
        for (m mVar2 = this.j; mVar2 != null; mVar2 = (m) mVar2.b) {
            mVar2.g(dVar4);
        }
        dVar4.k(i7);
        boolean z = false;
        boolean z2 = false;
        for (s sVar2 = this.l; sVar2 != null; sVar2 = (s) sVar2.b) {
            z |= sVar2.O();
            z2 |= sVar2.N();
            sVar2.S(dVar4);
        }
        dVar4.k(i);
        if (this.o != null) {
            d k = dVar4.k(this.d.D("InnerClasses")).i(this.o.b + 2).k(this.n);
            d dVar5 = this.o;
            k.h(dVar5.a, 0, dVar5.b);
        }
        if (this.p != 0) {
            dVar4.k(this.d.D("EnclosingMethod")).i(4).k(this.p).k(this.q);
        }
        if ((this.e & 4096) != 0 && (this.c & 65535) < 49) {
            dVar4.k(this.d.D("Synthetic")).i(0);
        }
        if (this.r != 0) {
            i2 = 2;
            dVar4.k(this.d.D("Signature")).i(2).k(this.r);
        } else {
            i2 = 2;
        }
        if (this.s != 0) {
            dVar4.k(this.d.D("SourceFile")).i(i2).k(this.s);
        }
        d dVar6 = this.t;
        if (dVar6 != null) {
            int i9 = dVar6.b;
            i3 = 0;
            dVar4.k(this.d.D("SourceDebugExtension")).i(i9).h(this.t.a, 0, i9);
        } else {
            i3 = 0;
        }
        if ((this.e & ASTNode.BLOCK_DO_UNTIL) != 0) {
            dVar4.k(this.d.D("Deprecated")).i(i3);
        }
        b bVar5 = this.u;
        if (bVar5 != null) {
            bVar5.h(this.d.D("RuntimeVisibleAnnotations"), dVar4);
        }
        b bVar6 = this.v;
        if (bVar6 != null) {
            bVar6.h(this.d.D("RuntimeInvisibleAnnotations"), dVar4);
        }
        b bVar7 = this.w;
        if (bVar7 != null) {
            bVar7.h(this.d.D("RuntimeVisibleTypeAnnotations"), dVar4);
        }
        b bVar8 = this.x;
        if (bVar8 != null) {
            bVar8.h(this.d.D("RuntimeInvisibleTypeAnnotations"), dVar4);
        }
        this.d.d0(dVar4);
        u uVar2 = this.y;
        if (uVar2 != null) {
            uVar2.k(dVar4);
        }
        if (this.z != 0) {
            dVar4.k(this.d.D("NestHost")).i(2).k(this.z);
        }
        if (this.B != null) {
            d k2 = dVar4.k(this.d.D("NestMembers")).i(this.B.b + 2).k(this.A);
            d dVar7 = this.B;
            k2.h(dVar7.a, 0, dVar7.b);
        }
        c cVar2 = this.C;
        if (cVar2 != null) {
            cVar2.e(this.d, dVar4);
        }
        return z2 ? q(dVar4.a, z) : dVar4.a;
    }
}
