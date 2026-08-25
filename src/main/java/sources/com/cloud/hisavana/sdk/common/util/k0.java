package com.cloud.hisavana.sdk.common.util;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.b4;
import java.util.TimeZone;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class k0 {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String[] split = str.split(":");
            if (split.length != 3) {
                return 0;
            }
            return (Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]);
        } catch (Exception unused) {
            b4.b().e("TimeUtil", "getDuration wrong,param is " + str);
            return 0;
        }
    }

    public static long b(long j) {
        return j - ((TimeZone.getDefault().getRawOffset() + j) % 3600000);
    }

    public static long c(long j) {
        return j - ((TimeZone.getDefault().getRawOffset() + j) % 86400000);
    }
}
