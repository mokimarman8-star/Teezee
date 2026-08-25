package com.cloud.tmc.miniapp.offlineapps.scan;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0o implements ThreadFactory {
    public AtomicLong OooO00o = new AtomicLong(0);

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "Tmc#ScanThreadFactory" + this.OooO00o.addAndGet(1L));
    }
}
