package com.transsion.base.infras_config;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.base.infras_config.InfraInitManager", f = "InfraInitManager.kt", l = {50}, m = "init-BWLJW6A")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class InfraInitManager$init$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InfraInitManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InfraInitManager$init$1(InfraInitManager infraInitManager, Continuation<? super InfraInitManager$init$1> continuation) {
        super(continuation);
        this.this$0 = infraInitManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object e = this.this$0.e(null, null, null, this);
        return e == IntrinsicsKt.f() ? e : Result.box-impl(e);
    }
}
