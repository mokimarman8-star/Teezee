package com.transsion.subroom.activity;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.therouter.TheRouter;
import com.transsion.baselib.helper.ReferrerBean;
import com.transsion.baselib.report.launch.RoomInstallReferrer;
import jg.b;
import kk.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subroom.activity.SplashActivity$toMain$1", f = "SplashActivity.kt", l = {319}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
final class SplashActivity$toMain$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplashActivity$toMain$1(SplashActivity splashActivity, Continuation<? super SplashActivity$toMain$1> continuation) {
        super(2, continuation);
        this.this$0 = splashActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SplashActivity$toMain$1 splashActivity$toMain$1 = new SplashActivity$toMain$1(this.this$0, continuation);
        splashActivity$toMain$1.L$0 = obj;
        return splashActivity$toMain$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SplashActivity$toMain$1) create(n0Var, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            n0 n0Var = (n0) this.L$0;
            RoomInstallReferrer roomInstallReferrer = RoomInstallReferrer.a;
            this.label = 1;
            if (roomInstallReferrer.f(n0Var, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        b.a aVar = jg.b.a;
        Application application = this.this$0.getApplication();
        Intrinsics.g(application, "getApplication(...)");
        if (TextUtils.equals(aVar.e(application), "gp")) {
            RoomInstallReferrer roomInstallReferrer2 = RoomInstallReferrer.a;
            Application application2 = this.this$0.getApplication();
            Intrinsics.g(application2, "getApplication(...)");
            roomInstallReferrer2.e(application2, new RoomInstallReferrer.a() { // from class: com.transsion.subroom.activity.SplashActivity$toMain$1.1
                public void a(ReferrerBean referrerBean) {
                    String utmContent;
                    a aVar2;
                    Intrinsics.h(referrerBean, "referrer");
                    if (TextUtils.isEmpty(referrerBean.getUtmContent())) {
                        return;
                    }
                    try {
                        if (Intrinsics.c(referrerBean.getUtmSource(), "fission-share") && (utmContent = referrerBean.getUtmContent()) != null && (aVar2 = (a) TheRouter.d(a.class, new Object[0])) != null) {
                            aVar2.a(utmContent);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Uri g = com.transsion.baselib.helper.b.a.g(Uri.parse(referrerBean.getUtmContent()));
                    if (g != null) {
                        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new onResolved.2(g, (Continuation) null), 3, (Object) null);
                    }
                }
            });
        } else {
            RoomInstallReferrer roomInstallReferrer3 = RoomInstallReferrer.a;
            Application application3 = this.this$0.getApplication();
            Intrinsics.g(application3, "getApplication(...)");
            roomInstallReferrer3.i(application3, "unknown", null);
        }
        return Unit.a;
    }
}
