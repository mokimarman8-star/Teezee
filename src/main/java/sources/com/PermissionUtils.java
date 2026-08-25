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

    public static void ensurePermission(Context context) {
        if (context instanceof Activity) {
            final Activity activity = (Activity) context;
            if (!getUserAvoid(activity) && !hasPermission(activity)) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.PermissionUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        new AlertDialog.Builder(activity).setTitle("Storage Permission Needed").setMessage("Do you want to save the contents to external storage?").setCancelable(false).setPositiveButton("Grant", new DialogInterface.OnClickListener() { // from class: com.PermissionUtils.1.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                PermissionUtils.requestPermission(activity);
                            }
                        }).setNegativeButton("No thanks", new DialogInterface.OnClickListener() { // from class: com.PermissionUtils.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                PermissionUtils.setUserAvoid(activity, true);
                            }
                        }).show();
                    }
                });
            }
        }
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
