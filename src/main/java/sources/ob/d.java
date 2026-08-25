package ob;

import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract /* synthetic */ class d {
    public static Object a(e eVar, Class cls) {
        return eVar.f(b0.b(cls));
    }

    public static Object b(e eVar, b0 b0Var) {
        kc.b c = eVar.c(b0Var);
        if (c == null) {
            return null;
        }
        return c.get();
    }

    public static kc.a c(e eVar, Class cls) {
        return eVar.b(b0.b(cls));
    }

    public static kc.b d(e eVar, Class cls) {
        return eVar.c(b0.b(cls));
    }

    public static Set e(e eVar, Class cls) {
        return eVar.d(b0.b(cls));
    }

    public static Set f(e eVar, b0 b0Var) {
        return (Set) eVar.g(b0Var).get();
    }
}
