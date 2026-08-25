package com.transsion.home.viewmodel.preload;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.j0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PreloadTrendingData$b extends AbstractCoroutineContextElement implements j0 {
    public PreloadTrendingData$b(j0.a aVar) {
        super(aVar);
    }

    public void m(CoroutineContext coroutineContext, Throwable th2) {
        a.a.i("PreloadTrending", "coroutineExceptionHandler " + th2.getMessage(), true);
        th2.printStackTrace();
    }
}
