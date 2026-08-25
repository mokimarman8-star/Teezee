package com.transsion.ad.ps.installed;

import android.content.Context;
import android.os.SystemClock;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.ps.PSReportUtil;
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
import vh.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.installed.AppInstallManager$onOpenEvent$1", f = "AppInstallManager.kt", l = {60}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AppInstallManager$onOpenEvent$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $packageName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppInstallManager$onOpenEvent$1(Context context, String str, Continuation<? super AppInstallManager$onOpenEvent$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$packageName = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInstallManager$onOpenEvent$1(this.$context, this.$packageName, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            a v0 = MbAdDatabase.INSTANCE.b(this.$context).v0();
            String str = this.$packageName;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.label = 1;
            if (v0.c(str, elapsedRealtime, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        xh.a.k(xh.a.a, "AppInstallManager --> onOpenEvent(保存到本地数据库) --> packageName = " + this.$packageName, 0, false, 6, null);
        PSReportUtil.a.b(this.$packageName, BuildConfig.FLAVOR, "open");
        return Unit.a;
    }
}
