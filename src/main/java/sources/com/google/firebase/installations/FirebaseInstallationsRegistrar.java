package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.FirebaseExecutors;
import com.google.firebase.f;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import ic.g;
import ic.h;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import lc.e;
import nb.a;
import nb.b;
import ob.b0;
import ob.c;
import ob.r;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e lambda$getComponents$0(ob.e eVar) {
        return new c((f) eVar.a(f.class), eVar.h(h.class), (ExecutorService) eVar.f(b0.a(a.class, ExecutorService.class)), FirebaseExecutors.b((Executor) eVar.f(b0.a(b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        return Arrays.asList(c.c(e.class).h(LIBRARY_NAME).b(r.k(f.class)).b(r.i(h.class)).b(r.l(b0.a(a.class, ExecutorService.class))).b(r.l(b0.a(b.class, Executor.class))).f(new ob.h() { // from class: lc.f
            public final Object a(ob.e eVar) {
                e lambda$getComponents$0;
                lambda$getComponents$0 = FirebaseInstallationsRegistrar.lambda$getComponents$0(eVar);
                return lambda$getComponents$0;
            }
        }).d(), g.a(), zc.h.b(LIBRARY_NAME, "18.0.0"));
    }
}
