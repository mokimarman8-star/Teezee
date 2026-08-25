package com.transsion.api.gateway.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ThreadManager$EventHandlerThreadHolder {
    private static Handler mHandler;
    private static HandlerThread mHandlerThread;

    static {
        HandlerThread handlerThread = new HandlerThread("event-thread");
        mHandlerThread = handlerThread;
        handlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
    }

    private ThreadManager$EventHandlerThreadHolder() {
    }
}
