package jl;

import com.transsion.core.log.ObjectLogUtils;
import com.transsion.core.log.ObjectLogUtils$a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class b implements c {
    private static b d;
    boolean a = false;
    int b = 2;
    private ObjectLogUtils c = new ObjectLogUtils$a().o(true).r(true).q(false).m();

    private b() {
    }

    public static b b() {
        if (d == null) {
            synchronized (b.class) {
                try {
                    if (d == null) {
                        d = new b();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    @Override // jl.c
    public void a(boolean z) {
        if (z != this.a) {
            this.a = z;
        }
    }

    public boolean c() {
        return this.a;
    }

    @Override // jl.c
    public void d(String str, String str2) {
        f(2, str, str2);
    }

    @Override // jl.c
    public void e(String str, String str2) {
        f(6, str, str2);
    }

    @Override // jl.c
    public void e(String str, String str2, Throwable th2) {
        g(6, str, str2, th2);
    }

    public void f(int i, String str, String str2) {
        g(i, str, str2, null);
    }

    public void g(int i, String str, String str2, Throwable th2) {
        if (c() && h(i)) {
            if (i == 2) {
                this.c.y(str, new Object[]{str2, th2});
                return;
            }
            if (i == 3) {
                this.c.h(str, new Object[]{str2, th2});
                return;
            }
            if (i == 4) {
                this.c.o(str, new Object[]{str2, th2});
            } else if (i == 5) {
                this.c.A(str, new Object[]{str2, th2});
            } else {
                if (i != 6) {
                    return;
                }
                this.c.j(str, new Object[]{str2, th2});
            }
        }
    }

    public boolean h(int i) {
        return i >= this.b;
    }

    @Override // jl.c
    public void v(String str, String str2) {
        f(2, str, str2);
    }
}
