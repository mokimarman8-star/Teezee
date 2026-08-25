package com.transsion.push.notification;

import android.graphics.Bitmap;
import com.transsion.baselib.db.download.DownloadException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n0;
import ni.f;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "Landroid/graphics/Bitmap;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.notification.ToolbarNotificationUtils$loadImageAsBitmap$2", f = "ToolbarNotificationUtils.kt", l = {DownloadException.EXCEPTION_IO_UNKNOWN_SERVICE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ToolbarNotificationUtils$loadImageAsBitmap$2 extends SuspendLambda implements Function2<n0, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ int $dp20;
    final /* synthetic */ String $url;
    int I$0;
    Object L$0;
    int label;

    static final class a implements Function1 {
        final /* synthetic */ n a;

        a(n nVar) {
            this.a = nVar;
        }

        public final void a(Bitmap bitmap) {
            this.a.resume(bitmap, (Function1) null);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Bitmap) obj);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ToolbarNotificationUtils$loadImageAsBitmap$2(String str, int i, Continuation<? super ToolbarNotificationUtils$loadImageAsBitmap$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$dp20 = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ToolbarNotificationUtils$loadImageAsBitmap$2(this.$url, this.$dp20, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Bitmap> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            String str = this.$url;
            int i2 = this.$dp20;
            this.L$0 = str;
            this.I$0 = i2;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(this), 1);
            cancellableContinuationImpl.initCancellability();
            zg.c.a.b(f.a.e(ni.f.a, str, i2, false, true, 4, null), new a(cancellableContinuationImpl));
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.f()) {
                DebugProbesKt.c(this);
            }
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}
