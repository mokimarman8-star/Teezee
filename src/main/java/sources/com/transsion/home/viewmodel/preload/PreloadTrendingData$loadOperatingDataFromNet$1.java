package com.transsion.home.viewmodel.preload;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData$loadOperatingDataFromNet$1", f = "PreloadTrendingData.kt", l = {100}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class PreloadTrendingData$loadOperatingDataFromNet$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $version;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PreloadTrendingData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreloadTrendingData$loadOperatingDataFromNet$1(PreloadTrendingData preloadTrendingData, String str, Continuation<? super PreloadTrendingData$loadOperatingDataFromNet$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadTrendingData;
        this.$version = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PreloadTrendingData$loadOperatingDataFromNet$1 preloadTrendingData$loadOperatingDataFromNet$1 = new PreloadTrendingData$loadOperatingDataFromNet$1(this.this$0, this.$version, continuation);
        preloadTrendingData$loadOperatingDataFromNet$1.L$0 = obj;
        return preloadTrendingData$loadOperatingDataFromNet$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            t1 d = i.d((n0) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new PreloadTrendingData$loadOperatingDataFromNet$1$op$1(this.this$0, this.$version, null), 3, (Object) null);
            this.label = 1;
            if (d.join(this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        PreloadTrendingData.t(this.this$0, false);
        return Unit.a;
    }
}
