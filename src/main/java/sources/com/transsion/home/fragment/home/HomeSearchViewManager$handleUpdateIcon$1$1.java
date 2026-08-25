package com.transsion.home.fragment.home;

import android.app.Activity;
import android.content.Context;
import com.transsion.gslb.BuildConfig;
import com.transsion.version.update.UpdateManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.fragment.home.HomeSearchViewManager$handleUpdateIcon$1$1", f = "HomeSearchViewManager.kt", l = {117}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HomeSearchViewManager$handleUpdateIcon$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeSearchViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeSearchViewManager$handleUpdateIcon$1$1(HomeSearchViewManager homeSearchViewManager, Continuation<? super HomeSearchViewManager$handleUpdateIcon$1$1> continuation) {
        super(2, continuation);
        this.this$0 = homeSearchViewManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeSearchViewManager$handleUpdateIcon$1$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            UpdateManager a = UpdateManager.f.a();
            Context context = this.this$0.d;
            if (context == null) {
                Intrinsics.y("context");
                context = null;
            }
            this.label = 1;
            obj = a.i((Activity) context, "app_center", "wefeed-mobile-bff", BuildConfig.FLAVOR, true, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a.a.f(wf.a.a, "update", "checkUpdate " + booleanValue, false, 4, (Object) null);
        return Unit.a;
    }
}
