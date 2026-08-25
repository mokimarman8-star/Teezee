package com.transsion.baseui.util;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.baseui.util.TimeUtilKt$countdownByFlow$2", f = "TimeUtil.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TimeUtilKt$countdownByFlow$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $onTick;
    /* synthetic */ int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TimeUtilKt$countdownByFlow$2(Function1<? super Integer, Unit> function1, Continuation<? super TimeUtilKt$countdownByFlow$2> continuation) {
        super(2, continuation);
        this.$onTick = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TimeUtilKt$countdownByFlow$2 timeUtilKt$countdownByFlow$2 = new TimeUtilKt$countdownByFlow$2(this.$onTick, continuation);
        timeUtilKt$countdownByFlow$2.I$0 = ((Number) obj).intValue();
        return timeUtilKt$countdownByFlow$2;
    }

    public final Object invoke(int i, Continuation<? super Unit> continuation) {
        return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.a);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) obj2);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.$onTick.invoke(Boxing.d(this.I$0));
        return Unit.a;
    }
}
