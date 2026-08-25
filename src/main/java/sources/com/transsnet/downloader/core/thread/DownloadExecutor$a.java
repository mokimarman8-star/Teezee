package com.transsnet.downloader.core.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadExecutor$a implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    DownloadExecutor$a() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        final String str = "or_download_" + this.a.getAndIncrement();
        return new Thread(runnable, str) { // from class: com.transsnet.downloader.core.thread.DownloadExecutor$BackgroundThread
            {
                setPriority(5);
            }
        };
    }
}
