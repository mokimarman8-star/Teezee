package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class r {
    protected final int a;
    protected r b;

    public r(int i) {
        this(i, null);
    }

    public r(int i, r rVar) {
        if (i != 393216 && i != 327680 && i != 262144 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.a = i;
        this.b = rVar;
    }

    public abstract void A(int i, int i2, q qVar, q... qVarArr);

    public abstract a B(int i, z zVar, String str, boolean z);

    public abstract void C(q qVar, q qVar2, q qVar3, String str);

    public abstract a D(int i, z zVar, String str, boolean z);

    public abstract void E(int i, String str);

    public abstract void F(int i, int i2);

    public abstract void a(int i, boolean z);

    public abstract a b(String str, boolean z);

    public abstract a c();

    public abstract void d(c cVar);

    public abstract void e();

    public abstract void f();

    public abstract void g(int i, String str, String str2, String str3);

    public abstract void h(int i, int i2, Object[] objArr, int i3, Object[] objArr2);

    public abstract void i(int i, int i2);

    public abstract void j(int i);

    public abstract a k(int i, z zVar, String str, boolean z);

    public abstract void l(int i, int i2);

    public abstract void m(String str, String str2, o oVar, Object... objArr);

    public abstract void n(int i, q qVar);

    public abstract void o(q qVar);

    public abstract void p(Object obj);

    public abstract void q(int i, q qVar);

    public abstract void r(String str, String str2, String str3, q qVar, q qVar2, int i);

    public abstract a s(int i, z zVar, q[] qVarArr, q[] qVarArr2, int[] iArr, String str, boolean z);

    public abstract void t(q qVar, int[] iArr, q[] qVarArr);

    public abstract void u(int i, int i2);

    public void v(int i, String str, String str2, String str3) {
        if (this.a >= 327680) {
            w(i, str, str2, str3, i == 185);
            return;
        }
        r rVar = this.b;
        if (rVar != null) {
            rVar.v(i, str, str2, str3);
        }
    }

    public abstract void w(int i, String str, String str2, String str3, boolean z);

    public abstract void x(String str, int i);

    public abstract void y(String str, int i);

    public abstract a z(int i, String str, boolean z);
}
