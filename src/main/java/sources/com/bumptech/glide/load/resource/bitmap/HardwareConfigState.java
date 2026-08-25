package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.compose.ui.graphics.p0;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED;
    private static final File FD_SIZE_LIST;
    public static final boolean HARDWARE_BITMAPS_SUPPORTED;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;

    @Deprecated
    public static final int NO_MAX_FD_COUNT = -1;
    private static final int REDUCED_MAX_FDS_FOR_HARDWARE_CONFIGS_P = 500;
    private static final String TAG = "HardwareConfig";
    private static volatile HardwareConfigState instance;
    private int decodesSinceLastFdCheck;
    private boolean isFdSizeBelowHardwareLimit = true;
    private final AtomicBoolean isHardwareConfigAllowedByAppState = new AtomicBoolean(false);
    private final int sdkBasedMaxFdCount = MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P;

    static {
        int i = Build.VERSION.SDK_INT;
        BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = i < 29;
        HARDWARE_BITMAPS_SUPPORTED = i >= 28;
        FD_SIZE_LIST = new File("/proc/self/fd");
    }

    HardwareConfigState() {
    }

    private boolean areHardwareBitmapsBlockedByAppState() {
        return BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED && !this.isHardwareConfigAllowedByAppState.get();
    }

    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (instance == null) {
                        instance = new HardwareConfigState();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private int getMaxFdCount() {
        if (isHardwareBitmapCountReducedOnApi28ByB139097735()) {
            return 500;
        }
        return this.sdkBasedMaxFdCount;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        try {
            boolean z = true;
            int i = this.decodesSinceLastFdCheck + 1;
            this.decodesSinceLastFdCheck = i;
            if (i >= 50) {
                this.decodesSinceLastFdCheck = 0;
                int length = FD_SIZE_LIST.list().length;
                long maxFdCount = getMaxFdCount();
                if (length >= maxFdCount) {
                    z = false;
                }
                this.isFdSizeBelowHardwareLimit = z;
                if (!z && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + maxFdCount);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.isFdSizeBelowHardwareLimit;
    }

    private static boolean isHardwareBitmapCountReducedOnApi28ByB139097735() {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public void blockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(false);
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!HARDWARE_BITMAPS_SUPPORTED) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (areHardwareBitmapsBlockedByAppState()) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z2) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i < 0 || i2 < 0) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        }
        if (isFdSizeBelowHardwareLimit()) {
            return true;
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    @TargetApi(26)
    boolean setHardwareConfigIfAllowed(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean isHardwareConfigAllowed = isHardwareConfigAllowed(i, i2, z, z2);
        if (isHardwareConfigAllowed) {
            options.inPreferredConfig = p0.a();
            options.inMutable = false;
        }
        return isHardwareConfigAllowed;
    }

    public void unblockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(true);
    }
}
