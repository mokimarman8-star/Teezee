package com.transsion.postdetail.ad;

import android.view.ViewGroup;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ad.BaseVideoAdHelper$closeSceneAd$1", f = "BaseVideoAdHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class BaseVideoAdHelper$closeSceneAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseVideoAdHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseVideoAdHelper$closeSceneAd$1(BaseVideoAdHelper baseVideoAdHelper, Continuation<? super BaseVideoAdHelper$closeSceneAd$1> continuation) {
        super(2, continuation);
        this.this$0 = baseVideoAdHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseVideoAdHelper$closeSceneAd$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        ViewGroup g0 = this.this$0.g0();
        if (g0 != null) {
            g0.setVisibility(8);
        }
        ViewGroup h0 = this.this$0.h0();
        if (h0 != null) {
            h0.setVisibility(8);
        }
        this.this$0.H(false);
        this.this$0.z1(false);
        this.this$0.v1(false);
        this.this$0.f1();
        if (this.this$0.N0()) {
            this.this$0.g1();
        }
        this.this$0.o1(false);
        this.this$0.Q();
        this.this$0.R();
        this.this$0.k2();
        return Unit.a;
    }
}
