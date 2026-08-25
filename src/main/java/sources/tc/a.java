package tc;

import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private final com.google.firebase.f a;
    private final lc.e b;
    private final kc.b c;
    private final kc.b d;

    public a(com.google.firebase.f fVar, lc.e eVar, kc.b bVar, kc.b bVar2) {
        this.a = fVar;
        this.b = eVar;
        this.c = bVar;
        this.d = bVar2;
    }

    com.google.firebase.perf.config.a a() {
        return com.google.firebase.perf.config.a.g();
    }

    com.google.firebase.f b() {
        return this.a;
    }

    lc.e c() {
        return this.b;
    }

    kc.b d() {
        return this.c;
    }

    RemoteConfigManager e() {
        return RemoteConfigManager.getInstance();
    }

    SessionManager f() {
        return SessionManager.getInstance();
    }

    kc.b g() {
        return this.d;
    }
}
