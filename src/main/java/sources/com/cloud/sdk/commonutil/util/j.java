package com.cloud.sdk.commonutil.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class j {
    public static final j a = new j();
    private static final Map b = new HashMap();
    private static final Map c = new HashMap();

    private j() {
    }

    private final synchronized HandlerThread b(String str) {
        HandlerThread handlerThread;
        Map map = b;
        handlerThread = (HandlerThread) map.get(str);
        if (handlerThread == null) {
            handlerThread = new HandlerThread(str);
            handlerThread.start();
            map.put(str, handlerThread);
        }
        return handlerThread;
    }

    public final synchronized Handler a(String str) {
        Handler handler;
        Looper looper;
        Intrinsics.h(str, "threadName");
        Map map = c;
        handler = (Handler) map.get(str);
        if (handler == null && (looper = b(str).getLooper()) != null) {
            handler = new Handler(looper);
            map.put(str, handler);
        }
        return handler;
    }
}
