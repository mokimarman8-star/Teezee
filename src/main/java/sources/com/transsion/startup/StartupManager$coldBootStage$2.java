package com.transsion.startup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.startup.StartupManager$coldBootStage$2", f = "StartupManager.kt", l = {299, 300, 303, 313, 316, 317}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class StartupManager$coldBootStage$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ StartupManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StartupManager$coldBootStage$2(StartupManager startupManager, Continuation<? super StartupManager$coldBootStage$2> continuation) {
        super(2, continuation);
        this.this$0 = startupManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartupManager$coldBootStage$2(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((StartupManager$coldBootStage$2) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x019a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0198 -> B:7:0x0021). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.startup.StartupManager$coldBootStage$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
