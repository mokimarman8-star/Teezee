package com.transsion.player.longvideo.ui;

import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import wj.f$a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.ui.LongVodPlayerView$pay$1$1$1$success$2", f = "LongVodPlayerView.kt", l = {3469}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class LongVodPlayerView$pay$1$1$1$success$2 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongVodPlayerView$pay$1$1$1$success$2(String str, Continuation<? super LongVodPlayerView$pay$1$1$1$success$2> continuation) {
        super(2, continuation);
        this.$orderId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerView$pay$1$1$1$success$2(this.$orderId, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            wj.f fVar = (wj.f) TheRouter.d(wj.f.class, new Object[0]);
            if (fVar != null) {
                String str = this.$orderId;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                this.label = 1;
                if (f$a.a(fVar, BuildConfig.FLAVOR, str, false, this, 4, null) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
