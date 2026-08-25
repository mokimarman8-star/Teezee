package rh;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class f {
    public static final f a = new f();
    private static Boolean b;
    private static Boolean c;
    private static Boolean d;

    private f() {
    }

    public final boolean a() {
        Boolean bool = c;
        if (bool == null) {
            Boolean valueOf = Boolean.valueOf(com.transsion.ad.strategy.e.a.b().getBoolean("isDetailRequestLog", false));
            c = valueOf;
            return valueOf.booleanValue();
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean b() {
        return com.transsion.ad.strategy.e.a.b().getBoolean("isGlobalAdOff", false);
    }

    public final Boolean c() {
        if (d == null) {
            d = Boolean.valueOf(com.transsion.ad.strategy.e.a.b().getBoolean("isHitLog", false));
        }
        return d;
    }

    public final boolean d() {
        Boolean bool = b;
        if (bool == null) {
            Boolean valueOf = Boolean.valueOf(com.transsion.ad.strategy.e.a.b().getBoolean("isReleasePsApi", true));
            b = valueOf;
            return valueOf.booleanValue();
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void e(boolean z) {
        com.transsion.ad.strategy.e.a.b().putBoolean("isDetailRequestLog", z);
        c = Boolean.valueOf(z);
    }

    public final void f(boolean z) {
        com.transsion.ad.strategy.e.a.b().putBoolean("isGlobalAdOff", z);
    }

    public final void g(Boolean bool) {
        if (bool == null) {
            return;
        }
        com.transsion.ad.strategy.e.a.b().putBoolean("isHitLog", bool.booleanValue());
        d = bool;
    }

    public final void h(boolean z) {
        com.transsion.ad.strategy.e.a.b().putBoolean("isReleasePsApi", z);
        b = Boolean.valueOf(z);
    }
}
