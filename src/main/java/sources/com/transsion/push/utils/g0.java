package com.transsion.push.utils;

import com.transsion.push.PushConstants;
import com.transsion.push.bean.ConfigInfo;
import com.transsion.push.config.PushRepository;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g0 {
    public static int a() {
        int i;
        ConfigInfo.Config config = PushRepository.getInstance().getConfig();
        if (config == null || (i = config.version) <= 0) {
            return 0;
        }
        return i;
    }

    public static long b() {
        int intValue;
        if (o.c()) {
            ConfigInfo.Config config = PushRepository.getInstance().getConfig();
            if ((config == null || (intValue = config.uploadInterval) <= 0) && (intValue = ((Integer) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_APP_UPLOAD_INTERVAL, -1)).intValue()) <= 0) {
                return 14400000L;
            }
        } else {
            ConfigInfo.Config config2 = PushRepository.getInstance().getConfig();
            if ((config2 == null || (intValue = config2.mobileUploadInterval) <= 0) && (intValue = ((Integer) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_APP_MOBILE_UPLOAD_INTERVAL, -1)).intValue()) <= 0) {
                return 14400000L;
            }
        }
        return intValue * 1000;
    }

    public static int c() {
        int i;
        ConfigInfo.Config config = PushRepository.getInstance().getConfig();
        if (config == null || (i = config.retryCount) <= 0) {
            return 2;
        }
        return i;
    }

    public static long d() {
        int i;
        ConfigInfo.Config config = PushRepository.getInstance().getConfig();
        if (config == null || (i = config.retryInterval) <= 0) {
            return 20000L;
        }
        return i * 1000;
    }

    public static long e() {
        return ((Integer) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_SELF_DESTROYING_INTERVAL, 86400)).intValue() * 1000;
    }

    public static long f() {
        return Math.min(86400000L, Math.max(900000L, ((Long) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_TRACKER_REPORT_INTERVAL, -1L)).longValue()));
    }

    public static boolean g() {
        return ((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_IMMEDIATELY_TRACK, Boolean.FALSE)).booleanValue();
    }

    public static boolean h() {
        return 2 == ((Integer) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_SELF_DESTROYING, 1)).intValue();
    }
}
