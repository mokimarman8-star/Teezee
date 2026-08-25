package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.abt.component.AbtRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import mb.a;
import ob.c;
import ob.e;
import ob.h;
import ob.r;

@Keep
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class AbtRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-abt";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a lambda$getComponents$0(e eVar) {
        return new a((Context) eVar.a(Context.class), eVar.h(a.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        return Arrays.asList(c.c(a.class).h(LIBRARY_NAME).b(r.k(Context.class)).b(r.i(a.class)).f(new h() { // from class: kb.a
            public final Object a(e eVar) {
                com.google.firebase.abt.component.a lambda$getComponents$0;
                lambda$getComponents$0 = AbtRegistrar.lambda$getComponents$0(eVar);
                return lambda$getComponents$0;
            }
        }).d(), zc.h.b(LIBRARY_NAME, "21.1.1"));
    }
}
