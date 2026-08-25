package com.transsion.subroom.activity;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.j0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class MainActivity$b extends AbstractCoroutineContextElement implements j0 {
    public MainActivity$b(j0.a aVar) {
        super(aVar);
    }

    @Override // kotlinx.coroutines.j0
    public void m(CoroutineContext coroutineContext, Throwable th) {
        wf.a.a.i("MainActivity", "coroutineExceptionHandler " + th.getMessage(), true);
        th.printStackTrace();
    }
}
