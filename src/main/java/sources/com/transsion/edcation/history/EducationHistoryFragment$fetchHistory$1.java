package com.transsion.edcation.history;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment", f = "EducationHistoryFragment.kt", l = {136}, m = "fetchHistory")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class EducationHistoryFragment$fetchHistory$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EducationHistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EducationHistoryFragment$fetchHistory$1(EducationHistoryFragment educationHistoryFragment, Continuation<? super EducationHistoryFragment$fetchHistory$1> continuation) {
        super(continuation);
        this.this$0 = educationHistoryFragment;
    }

    public final Object invokeSuspend(Object obj) {
        Object i0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        i0 = this.this$0.i0(false, this);
        return i0;
    }
}
