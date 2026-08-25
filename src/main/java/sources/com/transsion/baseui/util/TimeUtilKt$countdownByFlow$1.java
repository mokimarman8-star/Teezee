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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/b;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baseui.util.TimeUtilKt$countdownByFlow$1", f = "TimeUtil.kt", l = {326, 327}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TimeUtilKt$countdownByFlow$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $max;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimeUtilKt$countdownByFlow$1(int i, Continuation<? super TimeUtilKt$countdownByFlow$1> continuation) {
        super(2, continuation);
        this.$max = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TimeUtilKt$countdownByFlow$1 timeUtilKt$countdownByFlow$1 = new TimeUtilKt$countdownByFlow$1(this.$max, continuation);
        timeUtilKt$countdownByFlow$1.L$0 = obj;
        return timeUtilKt$countdownByFlow$1;
    }

    public final Object invoke(kotlinx.coroutines.flow.b bVar, Continuation<? super Unit> continuation) {
        return create(bVar, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        if (r1 != 0) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0056 -> B:6:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        kotlinx.coroutines.flow.b bVar;
        int i;
        kotlinx.coroutines.flow.b bVar2;
        Object f = IntrinsicsKt.f();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                i = this.I$0;
                bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
            }
            bVar = bVar2;
            i--;
            if (-1 < i) {
                Integer d = Boxing.d(i);
                this.L$0 = bVar;
                this.I$0 = i;
                this.label = 1;
                if (bVar.emit(d, this) == f) {
                    return f;
                }
                bVar2 = bVar;
                if (i != 0) {
                    this.L$0 = bVar2;
                    this.I$0 = i;
                    this.label = 2;
                    if (u0.a(1000L, this) == f) {
                        return f;
                    }
                }
                bVar = bVar2;
                i--;
                if (-1 < i) {
                    return Unit.a;
                }
            }
        } else {
            ResultKt.b(obj);
            bVar = (kotlinx.coroutines.flow.b) this.L$0;
            i = this.$max;
            if (-1 < i) {
            }
        }
    }
}
