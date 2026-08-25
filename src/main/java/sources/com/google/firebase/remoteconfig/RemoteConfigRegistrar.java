package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.abt.component.a;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.f;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import nb.b;
import ob.b0;
import ob.c;
import ob.e;
import ob.h;
import ob.r;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class RemoteConfigRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rc";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c lambda$getComponents$0(b0 b0Var, e eVar) {
        return new c((Context) eVar.a(Context.class), (ScheduledExecutorService) eVar.f(b0Var), (f) eVar.a(f.class), (lc.e) eVar.a(lc.e.class), ((a) eVar.a(a.class)).b("frc"), eVar.h(mb.a.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        final b0 a = b0.a(b.class, ScheduledExecutorService.class);
        return Arrays.asList(c.d(c.class, new Class[]{cd.a.class}).h(LIBRARY_NAME).b(r.k(Context.class)).b(r.l(a)).b(r.k(f.class)).b(r.k(lc.e.class)).b(r.k(a.class)).b(r.i(mb.a.class)).f(new h() { // from class: ad.o
            public final Object a(e eVar) {
                com.google.firebase.remoteconfig.c lambda$getComponents$0;
                lambda$getComponents$0 = RemoteConfigRegistrar.lambda$getComponents$0(a, eVar);
                return lambda$getComponents$0;
            }
        }).e().d(), zc.h.b(LIBRARY_NAME, "22.0.1"));
    }
}
