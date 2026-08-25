package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class u extends t {
    private final x c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private final d h;
    private int i;
    private final d j;
    private int k;
    private final d l;
    private int m;
    private final d n;
    private int o;
    private final d p;
    private int q;
    private final d r;
    private int s;

    u(x xVar, int i, int i2, int i3) {
        super(458752);
        this.c = xVar;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.h = new d();
        this.j = new d();
        this.l = new d();
        this.n = new d();
        this.p = new d();
        this.r = new d();
    }

    @Override // vz.t
    public void a() {
    }

    @Override // vz.t
    public void b(String str, int i, String... strArr) {
        this.j.k(this.c.B(str).a).k(i);
        if (strArr == null) {
            this.j.k(0);
        } else {
            this.j.k(strArr.length);
            for (String str2 : strArr) {
                this.j.k(this.c.y(str2).a);
            }
        }
        this.i++;
    }

    @Override // vz.t
    public void c(String str) {
        this.s = this.c.e(str).a;
    }

    @Override // vz.t
    public void d(String str, int i, String... strArr) {
        this.l.k(this.c.B(str).a).k(i);
        if (strArr == null) {
            this.l.k(0);
        } else {
            this.l.k(strArr.length);
            for (String str2 : strArr) {
                this.l.k(this.c.y(str2).a);
            }
        }
        this.k++;
    }

    @Override // vz.t
    public void e(String str) {
        this.r.k(this.c.B(str).a);
        this.q++;
    }

    @Override // vz.t
    public void f(String str, String... strArr) {
        this.p.k(this.c.e(str).a);
        this.p.k(strArr.length);
        for (String str2 : strArr) {
            this.p.k(this.c.e(str2).a);
        }
        this.o++;
    }

    @Override // vz.t
    public void g(String str, int i, String str2) {
        this.h.k(this.c.y(str).a).k(i).k(str2 == null ? 0 : this.c.D(str2));
        this.g++;
    }

    @Override // vz.t
    public void h(String str) {
        this.n.k(this.c.e(str).a);
        this.m++;
    }

    int i() {
        this.c.D("Module");
        int i = this.h.b + 22 + this.j.b + this.l.b + this.n.b + this.p.b;
        if (this.q > 0) {
            this.c.D("ModulePackages");
            i += this.r.b + 8;
        }
        if (this.s <= 0) {
            return i;
        }
        this.c.D("ModuleMainClass");
        return i + 8;
    }

    int j() {
        return (this.q > 0 ? 1 : 0) + 1 + (this.s > 0 ? 1 : 0);
    }

    void k(d dVar) {
        d k = dVar.k(this.c.D("Module")).i(this.h.b + 16 + this.j.b + this.l.b + this.n.b + this.p.b).k(this.d).k(this.e).k(this.f).k(this.g);
        d dVar2 = this.h;
        d k2 = k.h(dVar2.a, 0, dVar2.b).k(this.i);
        d dVar3 = this.j;
        d k3 = k2.h(dVar3.a, 0, dVar3.b).k(this.k);
        d dVar4 = this.l;
        d k4 = k3.h(dVar4.a, 0, dVar4.b).k(this.m);
        d dVar5 = this.n;
        d k5 = k4.h(dVar5.a, 0, dVar5.b).k(this.o);
        d dVar6 = this.p;
        k5.h(dVar6.a, 0, dVar6.b);
        if (this.q > 0) {
            d k6 = dVar.k(this.c.D("ModulePackages")).i(this.r.b + 2).k(this.q);
            d dVar7 = this.r;
            k6.h(dVar7.a, 0, dVar7.b);
        }
        if (this.s > 0) {
            dVar.k(this.c.D("ModuleMainClass")).i(2).k(this.s);
        }
    }
}
