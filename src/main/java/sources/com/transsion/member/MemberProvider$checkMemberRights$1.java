package com.transsion.member;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.member.MemberProvider", f = "MemberProvider.kt", l = {403, 413}, m = "checkMemberRights")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class MemberProvider$checkMemberRights$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemberProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MemberProvider$checkMemberRights$1(MemberProvider memberProvider, Continuation<? super MemberProvider$checkMemberRights$1> continuation) {
        super(continuation);
        this.this$0 = memberProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
