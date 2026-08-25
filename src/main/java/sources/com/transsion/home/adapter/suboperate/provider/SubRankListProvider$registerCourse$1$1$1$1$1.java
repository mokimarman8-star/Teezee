package com.transsion.home.adapter.suboperate.provider;

import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1$1$1$1", f = "SubRankListProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubRankListProvider$registerCourse$1$1$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ Subject $subject;
    int label;
    final /* synthetic */ SubRankListProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubRankListProvider$registerCourse$1$1$1$1$1(SubRankListProvider subRankListProvider, int i, Subject subject, Continuation<? super SubRankListProvider$registerCourse$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = subRankListProvider;
        this.$index = i;
        this.$subject = subject;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubRankListProvider$registerCourse$1$1$1$1$1(this.this$0, this.$index, this.$subject, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        com.transsion.home.adapter.suboperate.adapter.r rVar;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        rVar = this.this$0.h;
        if (rVar != null) {
            rVar.notifyItemChanged(this.$index, this.$subject);
        }
        return Unit.a;
    }
}
