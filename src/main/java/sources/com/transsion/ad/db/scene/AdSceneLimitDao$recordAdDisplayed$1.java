package com.transsion.ad.db.scene;

import com.transsion.ad.db.scene.AdSceneLimitDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.ad.db.scene.AdSceneLimitDao$DefaultImpls", f = "AdSceneLimitDao.kt", l = {126, 138}, m = "recordAdDisplayed")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AdSceneLimitDao$recordAdDisplayed$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    AdSceneLimitDao$recordAdDisplayed$1(Continuation<? super AdSceneLimitDao$recordAdDisplayed$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AdSceneLimitDao.DefaultImpls.c(null, null, null, 0L, this);
    }
}
