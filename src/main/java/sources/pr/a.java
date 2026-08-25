package pr;

import ur.c;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    private static c b;

    private a() {
    }

    private final c a() {
        c cVar = b;
        if (cVar == null) {
            vr.a c = pq.c.a.c();
            cVar = c != null ? c.k() : null;
            b = cVar;
        }
        return cVar;
    }

    public final String b() {
        return d() ? "/ugc_shorts/detail" : "/shorts/detail";
    }

    public final String c() {
        return d() ? "/ugc_shorts/favorite" : "/shorts/favorite";
    }

    public final boolean d() {
        c a2 = a();
        if (a2 != null) {
            return a2.a();
        }
        return false;
    }
}
