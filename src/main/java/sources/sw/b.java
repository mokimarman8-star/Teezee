package sw;

import android.app.ActivityManager;
import android.content.Context;
import java.util.Collection;
import java.util.List;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final boolean a(Context context) {
        Intrinsics.h(context, "context");
        try {
            Result$Companion result$Companion = Result.Companion;
            Object systemService = context.getSystemService("activity");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            String packageName = context.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> list = runningAppProcesses;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                if (Intrinsics.c(runningAppProcessInfo.processName, packageName) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            Object obj = Result.constructor-impl(ResultKt.a(th));
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = Boolean.FALSE;
            }
            return ((Boolean) obj).booleanValue();
        }
    }
}
