package rc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.metrics.h;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import xc.k;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e {
    private static final uc.a i = uc.a.e();
    private final Map a = new ConcurrentHashMap();
    private final com.google.firebase.perf.config.a b;
    private final d c;
    private Boolean d;
    private final com.google.firebase.f e;
    private final kc.b f;
    private final lc.e g;
    private final kc.b h;

    e(com.google.firebase.f fVar, kc.b bVar, lc.e eVar, kc.b bVar2, RemoteConfigManager remoteConfigManager, com.google.firebase.perf.config.a aVar, SessionManager sessionManager) {
        this.d = null;
        this.e = fVar;
        this.f = bVar;
        this.g = eVar;
        this.h = bVar2;
        if (fVar == null) {
            this.d = Boolean.FALSE;
            this.b = aVar;
            this.c = new d(new Bundle());
            return;
        }
        k.k().r(fVar, eVar, bVar2);
        Context k = fVar.k();
        d a = a(k);
        this.c = a;
        remoteConfigManager.setFirebaseRemoteConfigProvider(bVar);
        this.b = aVar;
        aVar.P(a);
        aVar.O(k);
        sessionManager.setApplicationContext(k);
        this.d = aVar.j();
        uc.a aVar2 = i;
        if (aVar2.h() && d()) {
            aVar2.f(String.format("Firebase Performance Monitoring is successfully initialized! In a minute, visit the Firebase console to view your data: %s", uc.b.b(fVar.n().e(), k.getPackageName())));
        }
    }

    private static d a(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No perf enable meta data found ");
            sb2.append(e.getMessage());
            bundle = null;
        }
        return bundle != null ? new d(bundle) : new d();
    }

    public static e c() {
        return (e) com.google.firebase.f.l().j(e.class);
    }

    public Map b() {
        return new HashMap(this.a);
    }

    public boolean d() {
        Boolean bool = this.d;
        return bool != null ? bool.booleanValue() : com.google.firebase.f.l().t();
    }

    public h e(String str, String str2) {
        return new h(str, str2, k.k(), new Timer());
    }
}
