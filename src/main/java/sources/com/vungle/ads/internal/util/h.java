package com.vungle.ads.internal.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h {
    private final Handler handler = new Handler(Looper.getMainLooper());

    private final long calculateTime(long j) {
        return SystemClock.uptimeMillis() + j;
    }

    public final void cancel(String tag) {
        Intrinsics.h(tag, "tag");
        this.handler.removeCallbacksAndMessages(tag);
    }

    public final void cancelAll() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public final void schedule(Runnable runnable, long j) {
        Intrinsics.h(runnable, "runnable");
        this.handler.postAtTime(runnable, calculateTime(j));
    }

    public final void schedule(Runnable runnable, String tag, long j) {
        Intrinsics.h(runnable, "runnable");
        Intrinsics.h(tag, "tag");
        this.handler.postAtTime(runnable, tag, calculateTime(j));
    }
}
