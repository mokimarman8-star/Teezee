package com.transsion.push.notification;

import android.graphics.Bitmap;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.ToolbarNoticeItem;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.notification.ToolbarNotificationUtils$loadImages$1", f = "ToolbarNotificationUtils.kt", l = {299, 300}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ToolbarNotificationUtils$loadImages$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Bitmap, Bitmap, Unit> $callback;
    final /* synthetic */ Pair<ToolbarNoticeItem, ToolbarNoticeItem> $pair;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ToolbarNotificationUtils$loadImages$1(Function2<? super Bitmap, ? super Bitmap, Unit> function2, Pair<ToolbarNoticeItem, ToolbarNoticeItem> pair, Continuation<? super ToolbarNotificationUtils$loadImages$1> continuation) {
        super(2, continuation);
        this.$callback = function2;
        this.$pair = pair;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ToolbarNotificationUtils$loadImages$1 toolbarNotificationUtils$loadImages$1 = new ToolbarNotificationUtils$loadImages$1(this.$callback, this.$pair, continuation);
        toolbarNotificationUtils$loadImages$1.L$0 = obj;
        return toolbarNotificationUtils$loadImages$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        r0 r0Var;
        Bitmap bitmap;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (TimeoutCancellationException unused) {
            this.$callback.invoke((Object) null, (Object) null);
        }
        if (i == 0) {
            ResultKt.b(obj);
            n0 n0Var = (n0) this.L$0;
            r0 b = kotlinx.coroutines.i.b(n0Var, y0.b(), (CoroutineStart) null, new ToolbarNotificationUtils$loadImages$1$image1Deferred$1(this.$pair, null), 2, (Object) null);
            r0 b2 = kotlinx.coroutines.i.b(n0Var, y0.b(), (CoroutineStart) null, new ToolbarNotificationUtils$loadImages$1$image2Deferred$1(this.$pair, null), 2, (Object) null);
            this.L$0 = b2;
            this.label = 1;
            Object f2 = b.f(this);
            if (f2 == f) {
                return f;
            }
            r0Var = b2;
            obj = f2;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bitmap = (Bitmap) this.L$0;
                ResultKt.b(obj);
                this.$callback.invoke(bitmap, (Bitmap) obj);
                return Unit.a;
            }
            r0Var = (r0) this.L$0;
            ResultKt.b(obj);
        }
        Bitmap bitmap2 = (Bitmap) obj;
        this.L$0 = bitmap2;
        this.label = 2;
        Object f3 = r0Var.f(this);
        if (f3 == f) {
            return f;
        }
        bitmap = bitmap2;
        obj = f3;
        this.$callback.invoke(bitmap, (Bitmap) obj);
        return Unit.a;
    }
}
