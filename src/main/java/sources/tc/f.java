package tc;

import com.google.firebase.perf.config.RemoteConfigManager;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class f implements iy.a {
    private final a a;

    public f(a aVar) {
        this.a = aVar;
    }

    public static f a(a aVar) {
        return new f(aVar);
    }

    public static RemoteConfigManager c(a aVar) {
        return (RemoteConfigManager) ux.b.c(aVar.e());
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RemoteConfigManager get() {
        return c(this.a);
    }
}
