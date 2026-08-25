package com.google.firebase.messaging;

import android.support.v4.media.session.c;
import androidx.annotation.Keep;
import bc.b;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.f;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import hc.d;
import java.util.Arrays;
import java.util.List;
import jc.a;
import ob.b0;
import ob.e;
import ob.h;
import ob.r;
import zc.i;

@Keep
@KeepForSdk
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(b0 b0Var, e eVar) {
        f fVar = (f) eVar.a(f.class);
        c.a(eVar.a(a.class));
        return new FirebaseMessaging(fVar, null, eVar.h(i.class), eVar.h(HeartBeatInfo.class), (lc.e) eVar.a(lc.e.class), eVar.c(b0Var), (d) eVar.a(d.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<ob.c> getComponents() {
        final b0 a = b0.a(b.class, t8.i.class);
        return Arrays.asList(ob.c.c(FirebaseMessaging.class).h(LIBRARY_NAME).b(r.k(f.class)).b(r.h(a.class)).b(r.i(i.class)).b(r.i(HeartBeatInfo.class)).b(r.k(lc.e.class)).b(r.j(a)).b(r.k(d.class)).f(new h() { // from class: com.google.firebase.messaging.c0
            public final Object a(e eVar) {
                FirebaseMessaging lambda$getComponents$0;
                lambda$getComponents$0 = FirebaseMessagingRegistrar.lambda$getComponents$0(a, eVar);
                return lambda$getComponents$0;
            }
        }).c().d(), zc.h.b(LIBRARY_NAME, "25.0.1"));
    }
}
