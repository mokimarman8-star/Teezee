package com.transsion.startup.work;

import android.content.Context;
import android.os.Build;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkManager;
import androidx.work.b;
import androidx.work.m;
import cm.f;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final void a(Context context) {
        String value;
        Boolean m1;
        Intrinsics.h(context, "context");
        boolean z = false;
        ConfigBean d = f.d(f.c.a(), "key_report_request_off", false, 2, (Object) null);
        if (d != null && (value = d.getValue()) != null && (m1 = StringsKt.m1(value)) != null) {
            z = m1.booleanValue();
        }
        if (z) {
            return;
        }
        try {
            Result$Companion result$Companion = Result.Companion;
            if (Build.VERSION.SDK_INT >= 24) {
                context = androidx.profileinstaller.b.a(context);
            }
            androidx.work.b a2 = new b.a().b(NetworkType.CONNECTED).a();
            TimeUnit timeUnit = TimeUnit.HOURS;
            Result.constructor-impl(WorkManager.f(context).e("NetworkDataSourceWorker", ExistingPeriodicWorkPolicy.REPLACE, new m.a(NetworkDataSourceWorker.class, 1L, timeUnit).i(a2).a("NetworkDataSourceWorker").k(1L, timeUnit).b()));
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
    }
}
