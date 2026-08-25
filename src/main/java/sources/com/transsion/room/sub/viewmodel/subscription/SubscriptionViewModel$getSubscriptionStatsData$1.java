package com.transsion.room.sub.viewmodel.subscription;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.sub.viewmodel.subscription.SubscriptionViewModel$getSubscriptionStatsData$1", f = "SubscriptionViewModel.kt", l = {65}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubscriptionViewModel$getSubscriptionStatsData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uid;
    int label;
    final /* synthetic */ SubscriptionViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubscriptionViewModel$getSubscriptionStatsData$1(SubscriptionViewModel subscriptionViewModel, String str, Continuation<? super SubscriptionViewModel$getSubscriptionStatsData$1> continuation) {
        super(2, continuation);
        this.this$0 = subscriptionViewModel;
        this.$uid = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubscriptionViewModel$getSubscriptionStatsData$1(this.this$0, this.$uid, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        pp.a aVar;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                aVar = this.this$0.i;
                String a = gg.a.a.a();
                String str = this.$uid;
                this.label = 1;
                obj = aVar.a(a, str, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.this$0.d().n(((BaseDto) obj).getData());
        } catch (Exception e) {
            this.this$0.d().n((Object) null);
            e.printStackTrace();
            a.a aVar2 = wf.a.a;
            String simpleName = SubscriptionViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            aVar2.i(simpleName, "exceptionHandler " + e.getMessage(), true);
        }
        return Unit.a;
    }
}
