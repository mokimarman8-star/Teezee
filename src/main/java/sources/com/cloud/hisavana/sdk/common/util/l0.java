package com.cloud.hisavana.sdk.common.util;

import com.cloud.sdk.commonutil.util.DeviceUtil;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class l0 {
    private static final AtomicInteger a = new AtomicInteger();

    public static String a() {
        return DeviceUtil.o();
    }

    public static String b() {
        String valueOf = String.valueOf(a.incrementAndGet());
        String valueOf2 = String.valueOf((int) (((new SecureRandom().nextDouble() * 9.0d) + 1.0d) * 100000.0d));
        return valueOf + String.valueOf(System.currentTimeMillis()) + valueOf2;
    }
}
