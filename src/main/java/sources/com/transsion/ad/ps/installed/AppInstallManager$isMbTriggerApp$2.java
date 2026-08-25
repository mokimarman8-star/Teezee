package com.transsion.ad.ps.installed;

import android.content.Context;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.pslink.AppInstalledBean;
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
import kotlinx.coroutines.n0;
import vh.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)Z"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.ps.installed.AppInstallManager$isMbTriggerApp$2", f = "AppInstallManager.kt", l = {97}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class AppInstallManager$isMbTriggerApp$2 extends SuspendLambda implements Function2<n0, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ String $packageName;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppInstallManager$isMbTriggerApp$2(Context context, String str, Continuation<? super AppInstallManager$isMbTriggerApp$2> continuation) {
        super(2, continuation);
        this.$applicationContext = context;
        this.$packageName = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInstallManager$isMbTriggerApp$2(this.$applicationContext, this.$packageName, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Boolean> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            a v0 = MbAdDatabase.INSTANCE.b(this.$applicationContext).v0();
            String str = this.$packageName;
            this.label = 1;
            obj = v0.b(str, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Boxing.a(((AppInstalledBean) obj) != null);
    }
}
