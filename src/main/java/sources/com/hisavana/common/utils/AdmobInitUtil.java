package com.hisavana.common.utils;

import android.os.HandlerThread;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class AdmobInitUtil {
    private static volatile HandlerThread handlerThread = null;
    private static volatile boolean started = false;
    private static String threadName = "admob init thread";

    public static synchronized HandlerThread getHanderThread() {
        HandlerThread handlerThread2;
        synchronized (AdmobInitUtil.class) {
            try {
                if (handlerThread == null) {
                    synchronized (AdmobInitUtil.class) {
                        try {
                            if (handlerThread == null) {
                                handlerThread = new HandlerThread(threadName);
                            }
                        } finally {
                        }
                    }
                }
                handlerThread2 = handlerThread;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handlerThread2;
    }

    public static synchronized void quit() {
        synchronized (AdmobInitUtil.class) {
            if (handlerThread != null) {
                handlerThread.quit();
            }
        }
    }

    public static synchronized void start() {
        synchronized (AdmobInitUtil.class) {
            if (!started && handlerThread != null) {
                handlerThread.start();
                started = !started;
            }
        }
    }
}
