package com.transsion.ad.db.scene;

import com.transsion.ad.db.scene.AdSceneLimitDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.db.scene.AdSceneLimitDao$DefaultImpls", f = "AdSceneLimitDao.kt", l = {56, 65}, m = "getOrCreateSceneLimit")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AdSceneLimitDao$getOrCreateSceneLimit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    AdSceneLimitDao$getOrCreateSceneLimit$1(Continuation<? super AdSceneLimitDao$getOrCreateSceneLimit$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AdSceneLimitDao.DefaultImpls.b(null, null, null, this);
    }
}
