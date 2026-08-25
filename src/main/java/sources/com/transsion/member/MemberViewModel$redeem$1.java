package com.transsion.member;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.member.MemberViewModel", f = "MemberViewModel.kt", l = {279}, m = "redeem")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MemberViewModel$redeem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemberViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MemberViewModel$redeem$1(MemberViewModel memberViewModel, Continuation<? super MemberViewModel$redeem$1> continuation) {
        super(continuation);
        this.this$0 = memberViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object I;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        I = this.this$0.I(null, this);
        return I;
    }
}
