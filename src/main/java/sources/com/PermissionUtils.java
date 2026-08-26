package com;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class PermissionUtils {
    private static final String KEY_AVOID = "avoid_permission";
    private static final String PREFS = "perm_prefs";

    /**
     * Startup must remain usable without storage access. Downloads can request
     * the appropriate permission at the point where the user chooses a download.
     * This method intentionally performs no Settings redirect or modal prompt.
     */
    public static void ensurePermission(Context context) {
        // Intentionally non-blocking. See requestPermission(Activity) for the
        // explicit, user-initiated download path.
    }

    private static boolean hasPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                activity.startActivity(intent);
                return;
            } catch (Exception e) {
                activity.startActivity(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
                return;
            }
        }
        activity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 123);
    }

    private static boolean getUserAvoid(Context context) {
        return context.getSharedPreferences(PREFS, 0).getBoolean(KEY_AVOID, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setUserAvoid(Context context, boolean z) {
        context.getSharedPreferences(PREFS, 0).edit().putBoolean(KEY_AVOID, z).apply();
    }
}
