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
@DebugMetadata(c = "com.transsion.room.sub.viewmodel.subscription.SubscriptionFeedListViewModel$getSubscriptionFeedData$1", f = "SubscriptionFeedListViewModel.kt", l = {92}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubscriptionFeedListViewModel$getSubscriptionFeedData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cursor;
    int label;
    final /* synthetic */ SubscriptionFeedListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubscriptionFeedListViewModel$getSubscriptionFeedData$1(SubscriptionFeedListViewModel subscriptionFeedListViewModel, String str, Continuation<? super SubscriptionFeedListViewModel$getSubscriptionFeedData$1> continuation) {
        super(2, continuation);
        this.this$0 = subscriptionFeedListViewModel;
        this.$cursor = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubscriptionFeedListViewModel$getSubscriptionFeedData$1(this.this$0, this.$cursor, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        pp.a aVar;
        int i;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        try {
            if (i2 == 0) {
                ResultKt.b(obj);
                aVar = this.this$0.d;
                String a = gg.a.a.a();
                String valueOf = String.valueOf(this.$cursor);
                i = SubscriptionFeedListViewModel.g;
                this.label = 1;
                obj = aVar.b(a, valueOf, i, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            Object data = baseDto.getData();
            StringBuilder sb = new StringBuilder();
            sb.append("Feed List: ");
            sb.append(data);
            this.this$0.e().n(baseDto.getData());
        } catch (Exception e) {
            e.printStackTrace();
            a.a aVar2 = wf.a.a;
            String simpleName = SubscriptionFeedListViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            aVar2.i(simpleName, "exceptionHandler " + e.getMessage(), true);
        }
        return Unit.a;
    }
}
