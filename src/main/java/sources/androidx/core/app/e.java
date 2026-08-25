package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e {

    static class a {
        static Object a(Context context, Class cls) {
            return context.getSystemService(cls);
        }

        static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        static String c(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    static class b {
        static int a(AppOpsManager appOpsManager, String str, int i5, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i5, str2);
        }

        static String b(Context context) {
            return context.getOpPackageName();
        }

        static AppOpsManager c(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    public static int a(Context context, int i5, String str, String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return b(context, str, str2);
        }
        AppOpsManager c5 = b.c(context);
        int a5 = b.a(c5, str, Binder.getCallingUid(), str2);
        return a5 != 0 ? a5 : b.a(c5, str, i5, b.b(context));
    }

    public static int b(Context context, String str, String str2) {
        return a.b((AppOpsManager) a.a(context, AppOpsManager.class), str, str2);
    }

    public static String c(String str) {
        return a.c(str);
    }
}
