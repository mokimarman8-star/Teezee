package uc;

import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private static volatile a c;
    private final c a;
    private boolean b;

    private a() {
        this(null);
    }

    public a(c cVar) {
        this.b = false;
        this.a = cVar == null ? c.c() : cVar;
    }

    public static a e() {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new a();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void a(String str) {
        if (this.b) {
            this.a.a(str);
        }
    }

    public void b(String str, Object... objArr) {
        if (this.b) {
            this.a.a(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void c(String str) {
        if (this.b) {
            this.a.b(str);
        }
    }

    public void d(String str, Object... objArr) {
        if (this.b) {
            this.a.b(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void f(String str) {
        if (this.b) {
            this.a.d(str);
        }
    }

    public void g(String str, Object... objArr) {
        if (this.b) {
            this.a.d(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public boolean h() {
        return this.b;
    }

    public void i(boolean z) {
        this.b = z;
    }

    public void j(String str) {
        if (this.b) {
            this.a.e(str);
        }
    }

    public void k(String str, Object... objArr) {
        if (this.b) {
            this.a.e(String.format(Locale.ENGLISH, str, objArr));
        }
    }
}
