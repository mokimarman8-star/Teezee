package com.transsion.ad.scene;

import android.app.Application;
import ci.p;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdSceneDisplayLimitManager {
    public static final AdSceneDisplayLimitManager a = new AdSceneDisplayLimitManager();

    private AdSceneDisplayLimitManager() {
    }

    public final Object a(String str, Continuation continuation) {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return companion.b(a2).u0().b(str, p.a.c(), System.currentTimeMillis(), r0.f(str) * 1000, a.a.d(str), continuation);
    }

    public final void b(String str) {
        Intrinsics.h(str, "sceneId");
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AdSceneDisplayLimitManager$recordDisplay$1(str, null), 3, (Object) null);
    }
}
