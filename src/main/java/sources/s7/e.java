package s7;

import s7.d;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class e {
    private static d a;
    static a b;
    static g8.c c;
    static boolean d;

    static void a() {
        if (!d) {
            throw new IllegalStateException("Do you forget to initialize XLog?");
        }
    }

    public static void b(String str) {
        a();
        a.a(str);
    }

    public static void c(String str) {
        a();
        a.c(str);
    }

    public static void d(String str) {
        a();
        a.e(str);
    }

    public static void e(a aVar) {
        f(aVar, d8.a.i());
    }

    public static void f(a aVar, g8.c... cVarArr) {
        if (d) {
            d8.b.e().g("XLog is already initialized, do not initialize again");
        }
        d = true;
        if (aVar == null) {
            throw new IllegalArgumentException("Please specify a LogConfiguration");
        }
        b = aVar;
        g8.d dVar = new g8.d(cVarArr);
        c = dVar;
        a = new d(b, dVar);
    }

    public static d.a g(String str) {
        return new d.a().x(str);
    }
}
