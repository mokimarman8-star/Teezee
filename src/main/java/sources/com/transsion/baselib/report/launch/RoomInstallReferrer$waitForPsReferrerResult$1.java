package com.transsion.baselib.report.launch;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.baselib.report.launch.RoomInstallReferrer", f = "RoomInstallReferrer.kt", l = {198}, m = "waitForPsReferrerResult")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RoomInstallReferrer$waitForPsReferrerResult$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomInstallReferrer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomInstallReferrer$waitForPsReferrerResult$1(RoomInstallReferrer roomInstallReferrer, Continuation<? super RoomInstallReferrer$waitForPsReferrerResult$1> continuation) {
        super(continuation);
        this.this$0 = roomInstallReferrer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomInstallReferrer.d(this.this$0, this);
    }
}
