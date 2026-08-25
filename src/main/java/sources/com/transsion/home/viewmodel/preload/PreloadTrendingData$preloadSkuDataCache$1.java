package com.transsion.home.viewmodel.preload;

import android.content.Context;
import com.blankj.utilcode.util.o;
import com.transsion.memberapi.SkuData;
import im.i;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData$preloadSkuDataCache$1", f = "PreloadTrendingData.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class PreloadTrendingData$preloadSkuDataCache$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreloadTrendingData$preloadSkuDataCache$1(Context context, Continuation<? super PreloadTrendingData$preloadSkuDataCache$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadTrendingData$preloadSkuDataCache$1(this.$context, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PreloadTrendingData$preloadSkuDataCache$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Context context = this.$context;
        try {
            Result.Companion companion = Result.Companion;
            String a = new im.g().a(context);
            if (a != null) {
                i.a.b().n((SkuData) o.e(a, o.h(SkuData.class, new Type[0])));
            }
            Result.m34constructorimpl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m34constructorimpl(ResultKt.a(th));
        }
        return Unit.a;
    }
}
