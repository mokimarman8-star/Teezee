package com.mbridge.msdk.foundation.download.core;

import java.util.concurrent.ExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface ExecutorSupplier {
    ExecutorService getBackgroundTasks();

    ExecutorService getDownloadResultTasks();

    DownloadExecutor getDownloadTasks();

    ExecutorService getLruCacheThreadTasks();
}
