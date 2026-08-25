package com.tn.tranpay.helper;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.tn.tranpay.helper.PayUtils", f = "PayUtils.kt", l = {99, TaskResultKt.ERROR_LOAD_REQUEST_FAIL}, m = "retryWithFixedIntervalAndTimeLimit")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class PayUtils$retryWithFixedIntervalAndTimeLimit$1<T> extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PayUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayUtils$retryWithFixedIntervalAndTimeLimit$1(PayUtils payUtils, Continuation<? super PayUtils$retryWithFixedIntervalAndTimeLimit$1> continuation) {
        super(continuation);
        this.this$0 = payUtils;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(0L, 0L, null, this);
    }
}
