package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uA {
    private static volatile Handler Sj;

    public static Handler Sj() {
        return com.bytedance.sdk.component.Dq.Sj.Sj.Sj().sP();
    }

    public static Handler sP() {
        if (Sj == null) {
            synchronized (uA.class) {
                try {
                    if (Sj == null) {
                        Sj = new Handler(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Sj;
    }
}
