package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import bc.b;
import com.google.android.datatransport.cct.a;
import com.google.android.datatransport.runtime.t;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.datatransport.TransportRegistrar;
import java.util.Arrays;
import java.util.List;
import ob.b0;
import ob.c;
import ob.e;
import ob.h;
import ob.r;
import t8.i;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i lambda$getComponents$0(e eVar) {
        t.f((Context) eVar.a(Context.class));
        return t.c().g(a.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i lambda$getComponents$1(e eVar) {
        t.f((Context) eVar.a(Context.class));
        return t.c().g(a.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i lambda$getComponents$2(e eVar) {
        t.f((Context) eVar.a(Context.class));
        return t.c().g(a.g);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    public List<c> getComponents() {
        return Arrays.asList(c.c(i.class).h(LIBRARY_NAME).b(r.k(Context.class)).f(new h() { // from class: bc.c
            public final Object a(ob.e eVar) {
                i lambda$getComponents$0;
                lambda$getComponents$0 = TransportRegistrar.lambda$getComponents$0(eVar);
                return lambda$getComponents$0;
            }
        }).d(), c.e(b0.a(bc.a.class, i.class)).b(r.k(Context.class)).f(new h() { // from class: bc.d
            public final Object a(ob.e eVar) {
                i lambda$getComponents$1;
                lambda$getComponents$1 = TransportRegistrar.lambda$getComponents$1(eVar);
                return lambda$getComponents$1;
            }
        }).d(), c.e(b0.a(b.class, i.class)).b(r.k(Context.class)).f(new h() { // from class: bc.e
            public final Object a(ob.e eVar) {
                i lambda$getComponents$2;
                lambda$getComponents$2 = TransportRegistrar.lambda$getComponents$2(eVar);
                return lambda$getComponents$2;
            }
        }).d(), zc.h.b(LIBRARY_NAME, "19.0.0"));
    }
}
