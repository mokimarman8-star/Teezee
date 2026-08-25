package androidx.coroutines.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;
import kotlin.jvm.internal.Intrinsics;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class j {
    public static final void c(Context context, d dVar) {
        Intrinsics.h(context, "context");
        Intrinsics.h(dVar, "sqLiteDatabase");
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i5 = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i6 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            dVar.A();
            try {
                dVar.J("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i5)});
                dVar.J("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i6)});
                sharedPreferences.edit().clear().apply();
                dVar.I();
            } finally {
                dVar.L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(WorkDatabase workDatabase, String str) {
        Long longValue = workDatabase.i0().getLongValue(str);
        int longValue2 = longValue != null ? (int) longValue.longValue() : 0;
        e(workDatabase, str, longValue2 != Integer.MAX_VALUE ? longValue2 + 1 : 0);
        return longValue2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WorkDatabase workDatabase, String str, int i5) {
        workDatabase.i0().a(new j4.d(str, Long.valueOf(i5)));
    }
}
