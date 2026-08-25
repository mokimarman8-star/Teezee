package com.google.firebase.perf;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.f;
import com.google.firebase.n;
import com.google.firebase.perf.FirebasePerfRegistrar;
import com.google.firebase.remoteconfig.c;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import nb.d;
import ob.b0;
import ob.e;
import ob.h;
import ob.r;
import rc.b;
import sc.a;
import t8.i;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebasePerfRegistrar implements ComponentRegistrar {
    private static final String EARLY_LIBRARY_NAME = "fire-perf-early";
    private static final String LIBRARY_NAME = "fire-perf";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b lambda$getComponents$0(b0 b0Var, e eVar) {
        return new b((f) eVar.a(f.class), (n) eVar.h(n.class).get(), (Executor) eVar.f(b0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static rc.e providesFirebasePerformance(e eVar) {
        eVar.a(b.class);
        return a.a().b(new tc.a((f) eVar.a(f.class), (lc.e) eVar.a(lc.e.class), eVar.h(c.class), eVar.h(i.class))).a().a();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<ob.c> getComponents() {
        final b0 a = b0.a(d.class, Executor.class);
        return Arrays.asList(ob.c.c(rc.e.class).h(LIBRARY_NAME).b(r.k(f.class)).b(r.m(c.class)).b(r.k(lc.e.class)).b(r.m(i.class)).b(r.k(b.class)).f(new h() { // from class: rc.c
            public final Object a(e eVar) {
                e providesFirebasePerformance;
                providesFirebasePerformance = FirebasePerfRegistrar.providesFirebasePerformance(eVar);
                return providesFirebasePerformance;
            }
        }).d(), ob.c.c(b.class).h(EARLY_LIBRARY_NAME).b(r.k(f.class)).b(r.i(n.class)).b(r.l(a)).e().f(new h() { // from class: rc.d
            public final Object a(e eVar) {
                b lambda$getComponents$0;
                lambda$getComponents$0 = FirebasePerfRegistrar.lambda$getComponents$0(a, eVar);
                return lambda$getComponents$0;
            }
        }).d(), zc.h.b(LIBRARY_NAME, "21.0.3"));
    }
}
