package com.cloud.hisavana.net.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class CommonWorkThread {
    private final Handler a;

    private static class WorkThreadHolder {
        private static final CommonWorkThread a = new CommonWorkThread();

        private WorkThreadHolder() {
        }
    }

    private CommonWorkThread() {
        HandlerThread handlerThread = new HandlerThread("common_work_thread");
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper());
    }
}
