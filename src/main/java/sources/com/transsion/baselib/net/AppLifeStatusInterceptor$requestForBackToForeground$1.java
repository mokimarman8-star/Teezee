package com.transsion.baselib.net;

import bm.e;
import com.therouter.TheRouter;
import com.transsion.gslb.BuildConfig;
import im.b$a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import vw.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baselib.net.AppLifeStatusInterceptor$requestForBackToForeground$1", f = "AppLifeStatusInterceptor.kt", l = {65}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AppLifeStatusInterceptor$requestForBackToForeground$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    AppLifeStatusInterceptor$requestForBackToForeground$1(Continuation<? super AppLifeStatusInterceptor$requestForBackToForeground$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppLifeStatusInterceptor$requestForBackToForeground$1(continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            e.p(e.a, (String) null, (String) null, 3, (Object) null);
            b bVar = (b) TheRouter.d(b.class, new Object[0]);
            if (bVar != null) {
                this.label = 1;
                if (bVar.c(this) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        im.b bVar2 = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar2 != null) {
            b$a.a(bVar2, null, 1, null);
        }
        return Unit.a;
    }
}
