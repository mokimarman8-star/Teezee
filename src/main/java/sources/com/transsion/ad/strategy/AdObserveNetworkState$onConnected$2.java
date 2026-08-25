package com.transsion.ad.strategy;

import com.transsion.ad.monopoly.MonopolyAdManager;
import com.transsion.gslb.BuildConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.strategy.AdObserveNetworkState$onConnected$2", f = "AdObserveNetworkState.kt", l = {67, 69}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AdObserveNetworkState$onConnected$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AdObserveNetworkState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdObserveNetworkState$onConnected$2(AdObserveNetworkState adObserveNetworkState, Continuation<? super AdObserveNetworkState$onConnected$2> continuation) {
        super(2, continuation);
        this.this$0 = adObserveNetworkState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(AdObserveNetworkState adObserveNetworkState, boolean z) {
        String e;
        AtomicBoolean atomicBoolean;
        adObserveNetworkState.c = z;
        xh.a aVar = xh.a.a;
        e = adObserveNetworkState.e();
        xh.a.e(aVar, null, e + " --> onConnected() --> 广告请求结果--> result == " + z, 0, false, 13, null);
        atomicBoolean = adObserveNetworkState.b;
        atomicBoolean.set(false);
        return Unit.a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdObserveNetworkState$onConnected$2(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String e;
        String str;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (u0.a(500L, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        xh.a aVar = xh.a.a;
        e = this.this$0.e();
        xh.a.e(aVar, null, e + " --> onConnected() --> 网络变化，请求广告配置", 0, false, 13, null);
        MonopolyAdManager monopolyAdManager = MonopolyAdManager.a;
        str = this.this$0.a;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        final AdObserveNetworkState adObserveNetworkState = this.this$0;
        Function1 function1 = new Function1() { // from class: com.transsion.ad.strategy.f
            public final Object invoke(Object obj2) {
                Unit d;
                d = AdObserveNetworkState$onConnected$2.d(AdObserveNetworkState.this, ((Boolean) obj2).booleanValue());
                return d;
            }
        };
        this.label = 2;
        if (monopolyAdManager.a(str, function1, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
