package com.cloud.tmc.reporttrack.thread;

import com.cloud.tmc.reporttrack.BuildConfig;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/cloud/tmc/reporttrack/thread/QueryAthenaStatusRejectHandler;", "Ljava/util/concurrent/ThreadPoolExecutor$DiscardPolicy;", "()V", "rejectedExecution", "", "r", "Ljava/lang/Runnable;", "e", "Ljava/util/concurrent/ThreadPoolExecutor;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class QueryAthenaStatusRejectHandler extends ThreadPoolExecutor.DiscardPolicy {
    @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryAthenaStatusRejectHandler -> Task: ");
        sb.append(r != null ? r.toString() : null);
    }
}
