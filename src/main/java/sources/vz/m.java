package vz;

import org.mvel2.ast.ASTNode;
import vz.c;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class m extends l {
    private final x c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private int h;
    private b i;
    private b j;
    private b k;
    private b l;
    private c m;

    m(x xVar, int i, String str, String str2, String str3, Object obj) {
        super(458752);
        this.c = xVar;
        this.d = i;
        this.e = xVar.D(str);
        this.f = xVar.D(str2);
        if (str3 != null) {
            this.g = xVar.D(str3);
        }
        if (obj != null) {
            this.h = xVar.d(obj).a;
        }
    }

    @Override // vz.l
    public a a(String str, boolean z) {
        d dVar = new d();
        dVar.k(this.c.D(str)).k(0);
        if (z) {
            b bVar = new b(this.c, dVar, this.i);
            this.i = bVar;
            return bVar;
        }
        b bVar2 = new b(this.c, dVar, this.j);
        this.j = bVar2;
        return bVar2;
    }

    @Override // vz.l
    public void b(c cVar) {
        cVar.c = this.m;
        this.m = cVar;
    }

    @Override // vz.l
    public void c() {
    }

    @Override // vz.l
    public a d(int i, z zVar, String str, boolean z) {
        d dVar = new d();
        a0.a(i, dVar);
        z.d(zVar, dVar);
        dVar.k(this.c.D(str)).k(0);
        if (z) {
            b bVar = new b(this.c, dVar, this.k);
            this.k = bVar;
            return bVar;
        }
        b bVar2 = new b(this.c, dVar, this.l);
        this.l = bVar2;
        return bVar2;
    }

    final void e(c.a aVar) {
        aVar.b(this.m);
    }

    int f() {
        int i;
        if (this.h != 0) {
            this.c.D("ConstantValue");
            i = 16;
        } else {
            i = 8;
        }
        if ((this.d & 4096) != 0 && this.c.R() < 49) {
            this.c.D("Synthetic");
            i += 6;
        }
        if (this.g != 0) {
            this.c.D("Signature");
            i += 8;
        }
        if ((this.d & ASTNode.BLOCK_DO_UNTIL) != 0) {
            this.c.D("Deprecated");
            i += 6;
        }
        b bVar = this.i;
        if (bVar != null) {
            i += bVar.f("RuntimeVisibleAnnotations");
        }
        b bVar2 = this.j;
        if (bVar2 != null) {
            i += bVar2.f("RuntimeInvisibleAnnotations");
        }
        b bVar3 = this.k;
        if (bVar3 != null) {
            i += bVar3.f("RuntimeVisibleTypeAnnotations");
        }
        b bVar4 = this.l;
        if (bVar4 != null) {
            i += bVar4.f("RuntimeInvisibleTypeAnnotations");
        }
        c cVar = this.m;
        return cVar != null ? i + cVar.a(this.c) : i;
    }

    void g(d dVar) {
        boolean z = this.c.R() < 49;
        dVar.k((~(z ? 4096 : 0)) & this.d).k(this.e).k(this.f);
        int i = this.h == 0 ? 0 : 1;
        int i2 = this.d;
        if ((i2 & 4096) != 0 && z) {
            i++;
        }
        if (this.g != 0) {
            i++;
        }
        if ((i2 & ASTNode.BLOCK_DO_UNTIL) != 0) {
            i++;
        }
        if (this.i != null) {
            i++;
        }
        if (this.j != null) {
            i++;
        }
        if (this.k != null) {
            i++;
        }
        if (this.l != null) {
            i++;
        }
        c cVar = this.m;
        if (cVar != null) {
            i += cVar.c();
        }
        dVar.k(i);
        if (this.h != 0) {
            dVar.k(this.c.D("ConstantValue")).i(2).k(this.h);
        }
        if ((4096 & this.d) != 0 && z) {
            dVar.k(this.c.D("Synthetic")).i(0);
        }
        if (this.g != 0) {
            dVar.k(this.c.D("Signature")).i(2).k(this.g);
        }
        if ((this.d & ASTNode.BLOCK_DO_UNTIL) != 0) {
            dVar.k(this.c.D("Deprecated")).i(0);
        }
        b bVar = this.i;
        if (bVar != null) {
            bVar.h(this.c.D("RuntimeVisibleAnnotations"), dVar);
        }
        b bVar2 = this.j;
        if (bVar2 != null) {
            bVar2.h(this.c.D("RuntimeInvisibleAnnotations"), dVar);
        }
        b bVar3 = this.k;
        if (bVar3 != null) {
            bVar3.h(this.c.D("RuntimeVisibleTypeAnnotations"), dVar);
        }
        b bVar4 = this.l;
        if (bVar4 != null) {
            bVar4.h(this.c.D("RuntimeInvisibleTypeAnnotations"), dVar);
        }
        c cVar2 = this.m;
        if (cVar2 != null) {
            cVar2.e(this.c, dVar);
        }
    }
}
