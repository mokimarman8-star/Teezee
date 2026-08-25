package com.cloud.tmc.miniapp.prestrategy;

import android.content.Context;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 implements com.cloud.tmc.miniapp.ipc.OooO0O0 {
    public final String OooO00o;
    public final String OooO0O0;
    public final /* synthetic */ Context OooO0OO;
    public final /* synthetic */ Function1<Boolean, Unit> OooO0Oo;

    /* JADX WARN: Multi-variable type inference failed */
    public OooO0O0(String str, String str2, Context context, Function1<? super Boolean, Unit> function1) {
        this.OooO0OO = context;
        this.OooO0Oo = function1;
        this.OooO00o = str;
        this.OooO0O0 = str2;
    }

    public static final void OooO00o(Context context, OooO0O0 oooO0O0, Function1 function1) {
        Intrinsics.h(oooO0O0, "this$0");
        try {
            PreStrategyManager.OooO00o.OooO0O0(context, oooO0O0.OooO00o, oooO0O0.OooO0O0, function1);
        } catch (Throwable th) {
            PreStrategyManager preStrategyManager = PreStrategyManager.OooO00o;
            TmcLogger.e("Prefetch:PreStrategyManager", th);
        }
    }

    @Override // com.cloud.tmc.miniapp.ipc.OooO0O0
    public void OooO00o(Integer num, Throwable th) {
        PreStrategyManager preStrategyManager = PreStrategyManager.OooO00o;
        TmcLogger.e("Prefetch:PreStrategyManager", th);
    }

    public void OooO00o(boolean z) {
        if (z) {
            return;
        }
        try {
            ExecutorType executorType = ExecutorType.IO;
            final Context context = this.OooO0OO;
            final Function1<Boolean, Unit> function1 = this.OooO0Oo;
            ExecutorUtils.execute(executorType, new Runnable() { // from class: com.cloud.tmc.miniapp.prestrategy.a
                @Override // java.lang.Runnable
                public final void run() {
                    OooO0O0.OooO00o(context, this, function1);
                }
            });
        } catch (Throwable th) {
            PreStrategyManager preStrategyManager = PreStrategyManager.OooO00o;
            TmcLogger.e("Prefetch:PreStrategyManager", th);
        }
    }
}
