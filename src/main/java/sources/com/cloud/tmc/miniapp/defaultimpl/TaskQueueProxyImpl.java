package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.proxy.ITaskQueueProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class TaskQueueProxyImpl implements ITaskQueueProxy {
    public static final void OooO00o(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void addAppTask(String str, final Function0<Unit> function0) {
        Intrinsics.h(str, "uniqueId");
        com.cloud.tmc.miniapp.utils.OooO oooO = com.cloud.tmc.miniapp.utils.OooO.OooO00o;
        com.cloud.tmc.miniapp.task.OooO00o oooO00o = new com.cloud.tmc.miniapp.task.OooO00o(str, new Runnable() { // from class: com.cloud.tmc.miniapp.defaultimpl.l
            @Override // java.lang.Runnable
            public final void run() {
                TaskQueueProxyImpl.OooO00o(function0);
            }
        });
        Intrinsics.h(oooO00o, "task");
        try {
            oooO.OooO00o().OooO00o(oooO00o);
        } catch (Throwable th) {
            TmcLogger.e("NormalTaskQueueUtils", "", th);
        }
    }
}
