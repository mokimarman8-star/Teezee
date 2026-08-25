package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.crashlytics.ndk.CrashlyticsNdkRegistrar;
import java.util.Arrays;
import java.util.List;
import ob.c;
import ob.e;
import ob.h;
import ob.r;
import qb.a;
import qb.f;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public a b(e eVar) {
        return c.f((Context) eVar.a(Context.class), !f.g(r2));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(c.c(a.class).h("fire-cls-ndk").b(r.k(Context.class)).f(new h() { // from class: ac.a
            public final Object a(e eVar) {
                qb.a b;
                b = CrashlyticsNdkRegistrar.this.b(eVar);
                return b;
            }
        }).e().d(), zc.h.b("fire-cls-ndk", "19.3.0"));
    }
}
