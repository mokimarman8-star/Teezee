package com.transsion.home.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.home.repository.HomePreferencesRepository", f = "HomePreferencesRepository.kt", l = {197, 216}, m = "updateIntervalRecord")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HomePreferencesRepository$updateIntervalRecord$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomePreferencesRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomePreferencesRepository$updateIntervalRecord$1(HomePreferencesRepository homePreferencesRepository, Continuation<? super HomePreferencesRepository$updateIntervalRecord$1> continuation) {
        super(continuation);
        this.this$0 = homePreferencesRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object n;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        n = this.this$0.n(null, null, this);
        return n;
    }
}
