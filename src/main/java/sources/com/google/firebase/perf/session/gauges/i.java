package com.google.firebase.perf.session.gauges;

import android.app.ActivityManager;
import android.content.Context;
import com.google.firebase.perf.util.StorageUnit;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class i {
    private static final uc.a e = uc.a.e();
    private final Runtime a;
    private final ActivityManager b;
    private final ActivityManager.MemoryInfo c;
    private final Context d;

    i(Context context) {
        this(Runtime.getRuntime(), context);
    }

    i(Runtime runtime, Context context) {
        this.a = runtime;
        this.d = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.b = activityManager;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.c = memoryInfo;
        activityManager.getMemoryInfo(memoryInfo);
    }

    public int a() {
        return com.google.firebase.perf.util.k.c(StorageUnit.BYTES.toKilobytes(this.c.totalMem));
    }

    public int b() {
        return com.google.firebase.perf.util.k.c(StorageUnit.BYTES.toKilobytes(this.a.maxMemory()));
    }

    public int c() {
        return com.google.firebase.perf.util.k.c(StorageUnit.MEGABYTES.toKilobytes(this.b.getMemoryClass()));
    }
}
