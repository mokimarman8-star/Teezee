package com.transsion.push.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ThreadManager$b {
    private static HandlerThread a;
    private static Handler b;

    static {
        HandlerThread handlerThread = new HandlerThread("event-thread");
        a = handlerThread;
        handlerThread.start();
        b = new Handler(a.getLooper());
    }
}
