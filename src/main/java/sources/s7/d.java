package s7;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import s7.a;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class d {
    private s7.a a;
    private g8.c b;

    public static class a {
        private int a;
        private String b;
        private boolean c;
        private boolean d;
        private boolean e;
        private String f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private w7.b k;
        private z7.b l;
        private y7.b m;
        private b8.b n;
        private a8.b o;
        private v7.a p;
        private Map q;
        private List r;
        private g8.c s;

        public a() {
            e.a();
        }

        public d t() {
            return new d(this);
        }

        public void u(Object[] objArr) {
            t().b(objArr);
        }

        public void v(Object[] objArr) {
            t().d(objArr);
        }

        public void w(Object[] objArr) {
            t().f(objArr);
        }

        public a x(String str) {
            this.b = str;
            return this;
        }

        public void y(Object[] objArr) {
            t().j(objArr);
        }

        public void z(Object[] objArr) {
            t().k(objArr);
        }
    }

    d(s7.a aVar, g8.c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    d(a aVar) {
        a.C0065a c0065a = new a.C0065a(e.b);
        if (aVar.a != 0) {
            c0065a.B(aVar.a);
        }
        if (aVar.b != null) {
            c0065a.E(aVar.b);
        }
        if (aVar.d) {
            if (aVar.c) {
                c0065a.x();
            } else {
                c0065a.u();
            }
        }
        if (aVar.h) {
            if (aVar.e) {
                c0065a.w(aVar.f, aVar.g);
            } else {
                c0065a.t();
            }
        }
        if (aVar.j) {
            if (aVar.i) {
                c0065a.v();
            } else {
                c0065a.s();
            }
        }
        if (aVar.k != null) {
            c0065a.A(aVar.k);
        }
        if (aVar.l != null) {
            c0065a.H(aVar.l);
        }
        if (aVar.m != null) {
            c0065a.G(aVar.m);
        }
        if (aVar.n != null) {
            c0065a.F(aVar.n);
        }
        if (aVar.o != null) {
            c0065a.D(aVar.o);
        }
        if (aVar.p != null) {
            c0065a.q(aVar.p);
        }
        if (aVar.q != null) {
            c0065a.C(aVar.q);
        }
        if (aVar.r != null) {
            c0065a.z(aVar.r);
        }
        this.a = c0065a.r();
        if (aVar.s != null) {
            this.b = aVar.s;
        } else {
            this.b = e.c;
        }
    }

    private void h(int i, Object[] objArr) {
        if (i < this.a.a) {
            return;
        }
        i(i, Arrays.deepToString(objArr));
    }

    private void i(int i, String str) {
        String str2;
        String sb;
        s7.a aVar = this.a;
        String str3 = aVar.b;
        String a2 = aVar.c ? aVar.k.a(Thread.currentThread()) : null;
        s7.a aVar2 = this.a;
        if (aVar2.d) {
            a8.b bVar = aVar2.l;
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            s7.a aVar3 = this.a;
            str2 = bVar.a(f8.a.b(stackTrace, aVar3.e, aVar3.f));
        } else {
            str2 = null;
        }
        if (this.a.o != null) {
            b bVar2 = new b(i, str3, a2, str2, str);
            for (c8.a aVar4 : this.a.o) {
                bVar2 = aVar4.a(bVar2);
                if (bVar2 == null) {
                    return;
                }
                if (bVar2.b == null || bVar2.c == null) {
                    d8.b.e().c("Interceptor " + aVar4 + " should not remove the tag or message of a log, if you don't want to print this log, just return a null when intercept.");
                    return;
                }
            }
            i = bVar2.a;
            str3 = bVar2.b;
            a2 = bVar2.d;
            str2 = bVar2.e;
            str = bVar2.c;
        }
        g8.c cVar = this.b;
        s7.a aVar5 = this.a;
        if (aVar5.g) {
            sb = aVar5.m.a(new String[]{a2, str2, str});
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a2 != null ? a2 + d8.c.a : "");
            sb2.append(str2 != null ? str2 + d8.c.a : "");
            sb2.append(str);
            sb = sb2.toString();
        }
        cVar.a(i, str3, sb);
    }

    public void a(String str) {
        g(3, str);
    }

    public void b(Object[] objArr) {
        h(3, objArr);
    }

    public void c(String str) {
        g(6, str);
    }

    public void d(Object[] objArr) {
        h(6, objArr);
    }

    public void e(String str) {
        g(4, str);
    }

    public void f(Object[] objArr) {
        h(4, objArr);
    }

    void g(int i, String str) {
        if (i < this.a.a) {
            return;
        }
        if (str == null) {
            str = "";
        }
        i(i, str);
    }

    public void j(Object[] objArr) {
        h(2, objArr);
    }

    public void k(Object[] objArr) {
        h(5, objArr);
    }
}
