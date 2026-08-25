package com.cloud.tmc.miniapp.task;

import com.cloud.tmc.offline.download.model.TaskResult;
import com.cloud.tmc.offline.download.task.base.BaseTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o extends BaseTask {
    public final String OooO00o;
    public final Runnable OooO0O0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO00o(String str, Runnable runnable) {
        super("NormalTask", 0L, 2, null);
        Intrinsics.h(str, "uniqueId");
        Intrinsics.h(runnable, "execute");
        this.OooO00o = str;
        this.OooO0O0 = runnable;
    }

    @Override // com.cloud.tmc.offline.download.task.base.ITask
    public String getTrigger() {
        return "normal";
    }

    @Override // com.cloud.tmc.offline.download.task.base.ITask
    public void run(Function1<? super TaskResult<?>, Unit> function1) {
        this.OooO0O0.run();
    }
}
