package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.f;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import nb.a;
import nb.b;
import nb.c;
import ob.b0;
import ob.e;
import ob.h;
import ob.r;
import qb.g;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    private final b0 a = b0.a(a.class, ExecutorService.class);
    private final b0 b = b0.a(b.class, ExecutorService.class);
    private final b0 c = b0.a(c.class, ExecutorService.class);

    static {
        FirebaseSessionsDependencies.a(SessionSubscriber.Name.CRASHLYTICS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseCrashlytics b(e eVar) {
        CrashlyticsWorkers.f(false);
        long currentTimeMillis = System.currentTimeMillis();
        FirebaseCrashlytics b = FirebaseCrashlytics.b((f) eVar.a(f.class), (lc.e) eVar.a(lc.e.class), eVar.i(qb.a.class), eVar.i(mb.a.class), eVar.i(cd.a.class), (ExecutorService) eVar.f(this.a), (ExecutorService) eVar.f(this.b), (ExecutorService) eVar.f(this.c));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 16) {
            g.f().b("Initializing Crashlytics blocked main for " + currentTimeMillis2 + " ms");
        }
        return b;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(ob.c.c(FirebaseCrashlytics.class).h("fire-cls").b(r.k(f.class)).b(r.k(lc.e.class)).b(r.l(this.a)).b(r.l(this.b)).b(r.l(this.c)).b(r.a(qb.a.class)).b(r.a(mb.a.class)).b(r.a(cd.a.class)).f(new h() { // from class: pb.f
            public final Object a(e eVar) {
                FirebaseCrashlytics b;
                b = CrashlyticsRegistrar.this.b(eVar);
                return b;
            }
        }).e().d(), zc.h.b("fire-cls", "19.3.0"));
    }
}
