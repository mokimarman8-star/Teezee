package com.transsion.baselib.db.member;

import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.baselib.db.member.MemberResolutionDao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.baselib.db.member.MemberResolutionDao$DefaultImpls", f = "MemberResolutionDao.kt", l = {96, TidConfigBean.REASON_TID_DISABLE, 107}, m = "updateIsUnlockOrCreate")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MemberResolutionDao$updateIsUnlockOrCreate$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    MemberResolutionDao$updateIsUnlockOrCreate$1(Continuation<? super MemberResolutionDao$updateIsUnlockOrCreate$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MemberResolutionDao.DefaultImpls.a(null, null, 0, 0, false, this);
    }
}
