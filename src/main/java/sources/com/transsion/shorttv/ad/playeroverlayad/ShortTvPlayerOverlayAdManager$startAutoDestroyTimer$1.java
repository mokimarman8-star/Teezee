package com.transsion.shorttv.ad.playeroverlayad;

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
import kotlinx.coroutines.o0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.ad.playeroverlayad.ShortTvPlayerOverlayAdManager$startAutoDestroyTimer$1", f = "ShortTvPlayerOverlayAdManager.kt", l = {97}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ShortTvPlayerOverlayAdManager$startAutoDestroyTimer$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    ShortTvPlayerOverlayAdManager$startAutoDestroyTimer$1(Continuation<? super ShortTvPlayerOverlayAdManager$startAutoDestroyTimer$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShortTvPlayerOverlayAdManager$startAutoDestroyTimer$1 shortTvPlayerOverlayAdManager$startAutoDestroyTimer$1 = new ShortTvPlayerOverlayAdManager$startAutoDestroyTimer$1(continuation);
        shortTvPlayerOverlayAdManager$startAutoDestroyTimer$1.L$0 = obj;
        return shortTvPlayerOverlayAdManager$startAutoDestroyTimer$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0033 -> B:5:0x0036). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        n0 n0Var;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            n0Var = (n0) this.L$0;
            if (o0.g(n0Var)) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            n0Var = (n0) this.L$0;
            ResultKt.b(obj);
            ShortTvPlayerOverlayAdManager.a.f();
            if (o0.g(n0Var)) {
                this.L$0 = n0Var;
                this.label = 1;
                if (u0.a(5000L, this) == f) {
                    return f;
                }
                ShortTvPlayerOverlayAdManager.a.f();
                if (o0.g(n0Var)) {
                    return Unit.a;
                }
            }
        }
    }
}
