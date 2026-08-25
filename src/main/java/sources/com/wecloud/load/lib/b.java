package com.wecloud.load.lib;

import android.content.Context;
import android.util.Log;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.WorkManager;
import androidx.work.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final b a = new b();
    private static final long b = 15;

    private b() {
    }

    public final void a(Context context) {
        Intrinsics.h(context, "context");
        try {
            long j = b;
            WorkManager.f(context.getApplicationContext()).e("exit_check_work", ExistingPeriodicWorkPolicy.KEEP, new m.a(ExitCheckWorker.class, j, TimeUnit.MINUTES).b());
            StringBuilder sb = new StringBuilder();
            sb.append("已注册退出监控周期任务，每 ");
            sb.append(j);
            sb.append(" 分钟检查一次");
        } catch (Exception e) {
            Log.e("ExitCheckScheduler", "注册退出监控任务失败: " + e.getMessage(), e);
        }
    }
}
