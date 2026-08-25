package com.cloud.tmc.storage;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class TmcStorageModuleLogger {
    private static final String LOG_LAUNCHER_SWITCH_TAG = "Launcher";
    private static final String LOG_SWITCH_TAG = "miniapp";
    private static final String TAG = "MiniAppProtocolModule::";

    public static void d(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2) || Log.isLoggable("miniapp", 3)) {
                return;
            }
            Log.isLoggable(LOG_LAUNCHER_SWITCH_TAG, 3);
        } catch (Throwable th) {
            Log.e(TAG, "d: ", th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        try {
            Log.e(str, str2, th);
        } catch (Throwable th2) {
            Log.e(TAG, "e: ", th2);
        }
    }
}
