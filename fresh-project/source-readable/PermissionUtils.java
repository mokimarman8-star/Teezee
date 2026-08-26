package com;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

/**
 * Reconstructed storage-permission helper.
 *
 * <p>Important startup rule: this helper must never open Settings while the
 * launcher is trying to display the first screen. Android 11+ uses scoped or
 * app-specific storage for normal downloads; broad all-files access is only
 * requested by an explicit user export action.</p>
 */
public final class PermissionUtils {

    private PermissionUtils() {
        // Utility class.
    }

    /**
     * Kept as a compatibility entry point for existing callers. It is
     * intentionally non-blocking so it cannot prevent Activity creation.
     */
    public static void ensurePermission(Context context) {
        // No permission dialog or Settings redirect during app startup.
    }

    /** Returns whether broad external-storage access is currently granted. */
    public static boolean hasAllFilesAccess(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        }
        return context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE")
                == android.content.pm.PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Requests broad access only after the user explicitly chooses an action
     * that genuinely requires it. Callers must provide the Activity context.
     */
    public static void requestForExplicitExport(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                Intent intent = new Intent(
                        "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION",
                        Uri.parse("package:" + activity.getPackageName()));
                activity.startActivity(intent);
            } catch (RuntimeException ignored) {
                activity.startActivity(new Intent(
                        "android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
            }
            return;
        }
        activity.requestPermissions(
                new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},
                123
        );
    }
}
