package com.transsion.api.gateway.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ThreadManager$TimerHandlerThreadHolder {
    private static Handler mHandler;
    private static HandlerThread mHandlerThread;

    static {
        HandlerThread handlerThread = new HandlerThread("globle_timer");
        mHandlerThread = handlerThread;
        handlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
    }

    private ThreadManager$TimerHandlerThreadHolder() {
    }
}
