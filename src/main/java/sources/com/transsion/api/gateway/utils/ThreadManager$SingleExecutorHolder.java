package com.transsion.api.gateway.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ThreadManager$SingleExecutorHolder {
    private static ExecutorService mSingleExecutor = Executors.newSingleThreadExecutor();

    private ThreadManager$SingleExecutorHolder() {
    }
}
