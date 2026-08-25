package com.transsion.api.gateway.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ThreadManager$ScheduledExecutorHolder {
    private static ScheduledExecutorService mScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

    private ThreadManager$ScheduledExecutorHolder() {
    }
}
