package com.cloud.sdk.commonutil.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class Preconditions {
    public static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("Must be called from the UiThread");
        }
    }

    public static Object b(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException(str);
    }

    public static void d(final a aVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cloud.sdk.commonutil.util.Preconditions.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.onRun();
                }
            });
        } else {
            aVar.onRun();
        }
    }
}
