package tc;

import com.google.firebase.perf.session.SessionManager;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class g implements iy.a {
    private final a a;

    public g(a aVar) {
        this.a = aVar;
    }

    public static g a(a aVar) {
        return new g(aVar);
    }

    public static SessionManager c(a aVar) {
        return (SessionManager) ux.b.c(aVar.f());
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SessionManager get() {
        return c(this.a);
    }
}
