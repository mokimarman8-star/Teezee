package com.transsion.usercenter.setting.labelsfeedback.sender;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.setting.labelsfeedback.sender.FBSender$sendJson$1", f = "FBSender.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FBSender$sendJson$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveData $liveData;
    final /* synthetic */ FBSender$a $observer;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FBSender$sendJson$1(LiveData liveData, FBSender$a fBSender$a, Continuation<? super FBSender$sendJson$1> continuation) {
        super(2, continuation);
        this.$liveData = liveData;
        this.$observer = fBSender$a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FBSender$sendJson$1(this.$liveData, this.$observer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((FBSender$sendJson$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.$liveData.k(this.$observer);
        return Unit.a;
    }
}
