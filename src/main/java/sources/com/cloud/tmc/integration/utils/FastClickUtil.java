package com.cloud.tmc.integration.utils;

import android.os.SystemClock;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class FastClickUtil {
    private static final long DOUBLE_DEVIATE_TIME = 400;
    private static long mLastChickTime;

    private FastClickUtil() {
    }

    public static boolean isFastDoubleClick() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - mLastChickTime;
        if (j > DOUBLE_DEVIATE_TIME) {
            mLastChickTime = elapsedRealtime;
            return false;
        }
        if (j >= 0) {
            return true;
        }
        mLastChickTime = 0L;
        return false;
    }
}
